// This is a generated file. Not intended for manual editing.
package org.covscript.devkt.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;
import org.covscript.devkt.lang.psi.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;

public class CovCompareLevelOpImpl extends CovExprImpl implements CovCompareLevelOp {

  public CovCompareLevelOpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CovVisitor visitor) {
    visitor.visitCompareLevelOp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CovVisitor) accept((CovVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CovExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CovExpr.class);
  }

}
