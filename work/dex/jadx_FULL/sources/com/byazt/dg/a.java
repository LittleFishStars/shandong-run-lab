package com.byazt.dg;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 34})
public class a extends sp<Integer> {
    public a(List<com.byazt.vc.c<Integer>> list) {
        super(list);
    }

    public int i() {
        return ve(ve(), n());
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public Integer c(com.byazt.vc.c<Integer> cVar, float f) {
        return Integer.valueOf(ve(cVar, f));
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
    public int ve(com.byazt.vc.c<Integer> cVar, float f) {
        Integer num;
        if (cVar.c == null || cVar.tt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.vc.ve<A> veVar = this.ve;
        return (veVar == 0 || (num = (Integer) veVar.c(cVar.f29127a, cVar.sp.floatValue(), cVar.c, cVar.tt, f, uj(), x())) == null) ? com.byazt.kk.i.c(cVar.x(), cVar.i(), f) : num.intValue();
    }
}
