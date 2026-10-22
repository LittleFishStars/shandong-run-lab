package com.byazt.dg;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 15})
public class uj extends sp<Float> {
    public uj(List<com.byazt.vc.c<Float>> list) {
        super(list);
    }

    public float i() {
        return ve(ve(), n());
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public Float c(com.byazt.vc.c<Float> cVar, float f) {
        return Float.valueOf(ve(cVar, f));
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
    public float ve(com.byazt.vc.c<Float> cVar, float f) {
        Float f2;
        if (cVar.c == null || cVar.tt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.vc.ve<A> veVar = this.ve;
        return (veVar == 0 || (f2 = (Float) veVar.c(cVar.f29127a, cVar.sp.floatValue(), cVar.c, cVar.tt, f, uj(), x())) == null) ? com.byazt.kk.i.c(cVar.a(), cVar.sp(), f) : f2.floatValue();
    }
}
