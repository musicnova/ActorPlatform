package im.actor.apiLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class CheckUniqueStructNames_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public CheckUniqueStructNames_NonTypesystemRule() {
  }
  public void applyRule(final SNode iEntity, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (SPropertyOperations.getString(iEntity, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")).equals("bytes")) {
      {
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(iEntity, "name bytes in unavailable", "r:6e7b088d-9a56-43ad-8e6a-4a3f15c66539(im.actor.apiLanguage.typesystem)", "5312209286554794578", null, errorTarget);
      }
    }
    Integer count = 0;
    for (SNode section : ListSequence.fromList(SLinkOperations.getChildren(SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.getParent(iEntity)), MetaAdapterFactory.getConcept(0x77fdf769432b4edeL, 0x8171050f8dee73fcL, 0x20977a66b6820f4bL, "im.actor.apiLanguage.structure.ApiDescription")), MetaAdapterFactory.getContainmentLink(0x77fdf769432b4edeL, 0x8171050f8dee73fcL, 0x20977a66b6820f4bL, 0x20977a66b682213bL, "sections")))) {
      for (SNode destDef : ListSequence.fromList(SLinkOperations.getChildren(section, MetaAdapterFactory.getContainmentLink(0x77fdf769432b4edeL, 0x8171050f8dee73fcL, 0x20977a66b6821192L, 0x20977a66b68211bdL, "definitions")))) {
        if (SNodeOperations.isInstanceOf(destDef, MetaAdapterFactory.getInterfaceConcept(0x77fdf769432b4edeL, 0x8171050f8dee73fcL, 0x4114dc2d7274a7e3L, "im.actor.apiLanguage.structure.IEntity"))) {
          if (SPropertyOperations.getString(iEntity, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")).equals(SPropertyOperations.getString(SNodeOperations.cast(destDef, MetaAdapterFactory.getInterfaceConcept(0x77fdf769432b4edeL, 0x8171050f8dee73fcL, 0x4114dc2d7274a7e3L, "im.actor.apiLanguage.structure.IEntity")), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")))) {
            count++;
          }
        }
      }
    }
    if (count > 1) {
      {
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(iEntity, "Duplicate Names", "r:6e7b088d-9a56-43ad-8e6a-4a3f15c66539(im.actor.apiLanguage.typesystem)", "2348480312264610464", null, errorTarget);
      }
    }
  }
  public String getApplicableConceptFQName() {
    return "im.actor.apiLanguage.structure.IEntity";
  }
  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConcept().getQualifiedName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }
  public boolean overrides() {
    return false;
  }
}
