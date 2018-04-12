@file:JvmName("CovPsiImplUtils")
@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER", "ConflictingExtensionProperty")

package org.covscript.devkt.lang.psi.impl

import org.covscript.devkt.lang.psi.CovSymbol
import org.jetbrains.kotlin.com.intellij.openapi.progress.ProgressIndicatorProvider
import org.jetbrains.kotlin.com.intellij.psi.*
import org.jetbrains.kotlin.com.intellij.psi.scope.PsiScopeProcessor

fun PsiElement.processDeclTrivial(
		processor: PsiScopeProcessor,
		substitutor: ResolveState,
		lastParent: PsiElement?,
		place: PsiElement): Boolean {
	var run: PsiElement? = lastParent?.prevSibling ?: lastChild
	while (run != null) {
		if (!run.processDeclarations(processor, substitutor, null, place)) return false
		run = run.prevSibling
	}
	return true
}

fun collectFrom(startPoint: PsiElement, name: String, self: PsiElement? = null) = SyntaxTraverser
		.psiTraverser(startPoint)
		.filter { it is CovSymbol && !it.isDeclaration && it !== self && it.text == name }
		.mapNotNull(PsiElement::getReference)
		.let { if (self != null) it.filter { it.isReferenceTo(self) } else it }
		.toTypedArray()

fun treeWalkUp(
		processor: PsiScopeProcessor,
		entrance: PsiElement,
		maxScope: PsiElement?,
		state: ResolveState = ResolveState.initial()): Boolean {
	if (!entrance.isValid) return false
	var prevParent = entrance
	var scope: PsiElement? = entrance

	while (scope != null) {
		ProgressIndicatorProvider.checkCanceled()
		if (!scope.processDeclarations(processor, state, prevParent, entrance)) return false
		if (scope == maxScope) break
		prevParent = scope
		scope = prevParent.context
	}
	return true
}

