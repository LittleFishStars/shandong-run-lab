package com.airbnb.lottie.animation.keyframe;

import com.zj.adlib.bs3;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import com.zj.adlib.up5;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends KeyframeAnimation<Integer> {
    public a(List<ps4<Integer>> list) {
        super(list);
    }

    public int m() {
        return n(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
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
    public int n(ps4<Integer> ps4Var, float f) {
        Integer num;
        if (ps4Var.f18928a == null || ps4Var.f18932b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        return (j45Var == 0 || (num = (Integer) j45Var.b(ps4Var.f44051a, ps4Var.f18927a.floatValue(), ps4Var.f18928a, ps4Var.f18932b, f, c(), d())) == null) ? bs3.c(up5.c(f, 0.0f, 1.0f), ps4Var.f18928a.intValue(), ps4Var.f18932b.intValue()) : num.intValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer g(ps4<Integer> ps4Var, float f) {
        return Integer.valueOf(n(ps4Var, f));
    }
}
