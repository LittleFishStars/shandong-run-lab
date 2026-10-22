package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g extends KeyframeAnimation<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f23350a;

    public g(List<ps4<PointF>> list) {
        super(list);
        this.f23350a = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(ps4 ps4Var, float f, float f2, float f3) {
        return getValue((ps4<PointF>) ps4Var, f, f2, f3);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public PointF g(ps4<PointF> ps4Var, float f) {
        return getValue(ps4Var, f, f, f);
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
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(ps4<PointF> ps4Var, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = ps4Var.f18928a;
        if (pointF3 == null || (pointF = ps4Var.f18932b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        if (j45Var != 0 && (pointF2 = (PointF) j45Var.b(ps4Var.f44051a, ps4Var.f18927a.floatValue(), pointF4, pointF5, f, c(), d())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f23350a;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.f23350a;
    }
}
