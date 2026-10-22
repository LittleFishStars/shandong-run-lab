package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import com.zj.adlib.zm6;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends KeyframeAnimation<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f23349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PointF f463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zm6 f464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f465a;

    public f(List<? extends ps4<PointF>> list) {
        super(list);
        this.f463a = new PointF();
        this.f465a = new float[2];
        this.f23349a = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public PointF g(ps4<PointF> ps4Var, float f) {
        PointF pointF;
        zm6 zm6Var = (zm6) ps4Var;
        Path pathJ = zm6Var.j();
        if (pathJ == null) {
            return ps4Var.f18928a;
        }
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        if (j45Var != 0 && (pointF = (PointF) j45Var.b(((ps4) zm6Var).f44051a, ((ps4) zm6Var).f18927a.floatValue(), (PointF) ((ps4) zm6Var).f18928a, (PointF) ((ps4) zm6Var).f18932b, c(), f, d())) != null) {
            return pointF;
        }
        if (this.f464a != zm6Var) {
            this.f23349a.setPath(pathJ, false);
            this.f464a = zm6Var;
        }
        PathMeasure pathMeasure = this.f23349a;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f465a, null);
        PointF pointF2 = this.f463a;
        float[] fArr = this.f465a;
        pointF2.set(fArr[0], fArr[1]);
        return this.f463a;
    }
}
