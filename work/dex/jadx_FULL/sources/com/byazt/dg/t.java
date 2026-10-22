package com.byazt.dg;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 66})
public class t extends sp<com.byazt.vc.uj> {
    public final com.byazt.vc.uj uj;

    public t(List<com.byazt.vc.c<com.byazt.vc.uj>> list) {
        super(list);
        this.uj = new com.byazt.vc.uj();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public com.byazt.vc.uj c(com.byazt.vc.c<com.byazt.vc.uj> cVar, float f) {
        com.byazt.vc.uj ujVar;
        com.byazt.vc.uj ujVar2;
        com.byazt.vc.uj ujVar3 = cVar.c;
        if (ujVar3 == null || (ujVar = cVar.tt) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.vc.uj ujVar4 = ujVar3;
        com.byazt.vc.uj ujVar5 = ujVar;
        com.byazt.vc.ve<A> veVar = this.ve;
        if (veVar != 0 && (ujVar2 = (com.byazt.vc.uj) veVar.c(cVar.f29127a, cVar.sp.floatValue(), ujVar4, ujVar5, f, uj(), x())) != null) {
            return ujVar2;
        }
        this.uj.c(com.byazt.kk.i.c(ujVar4.c(), ujVar5.c(), f), com.byazt.kk.i.c(ujVar4.tt(), ujVar5.tt(), f));
        return this.uj;
    }
}
