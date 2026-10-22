package com.byazt.dg;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 133})
public class z extends sp<com.byazt.nb.tt> {
    public z(List<com.byazt.vc.c<com.byazt.nb.tt>> list) {
        super(list);
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
    public com.byazt.nb.tt c(com.byazt.vc.c<com.byazt.nb.tt> cVar, float f) {
        com.byazt.nb.tt ttVar;
        com.byazt.vc.ve<A> veVar = this.ve;
        if (veVar == 0) {
            return (f != 1.0f || (ttVar = cVar.tt) == null) ? cVar.c : ttVar;
        }
        float f2 = cVar.f29127a;
        Float f3 = cVar.sp;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        com.byazt.nb.tt ttVar2 = cVar.c;
        com.byazt.nb.tt ttVar3 = cVar.tt;
        return (com.byazt.nb.tt) veVar.c(f2, fFloatValue, ttVar2, ttVar3 == null ? ttVar2 : ttVar3, f, n(), x());
    }
}
