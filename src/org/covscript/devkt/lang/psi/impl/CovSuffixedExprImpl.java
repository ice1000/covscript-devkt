// This is a generated file. Not intended for manual editing.
package org.covscript.devkt.lang.psi.impl;

import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.covscript.devkt.lang.psi.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;

public class CovSuffixedExprImpl extends CovExprImpl implements CovSuffixedExpr {

  public CovSuffixedExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CovVisitor visitor) {
    visitor.visitSuffixedExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CovVisitor) accept((CovVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CovExpr getExpr() {
    return findNotNullChildByClass(CovExpr.class);
  }

}
