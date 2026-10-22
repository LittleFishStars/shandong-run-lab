package com.airbnb.lottie.animation.keyframe;

import com.zj.adlib.cv7;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import com.zj.adlib.up5;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends KeyframeAnimation<cv7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cv7 f23351a;

    public h(List<ps4<cv7>> list) {
        super(list);
        this.f23351a = new cv7();
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
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public cv7 g(ps4<cv7> ps4Var, float f) {
        cv7 cv7Var;
        cv7 cv7Var2;
        cv7 cv7Var3 = ps4Var.f18928a;
        if (cv7Var3 == null || (cv7Var = ps4Var.f18932b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        cv7 cv7Var4 = cv7Var3;
        cv7 cv7Var5 = cv7Var;
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        if (j45Var != 0 && (cv7Var2 = (cv7) j45Var.b(ps4Var.f44051a, ps4Var.f18927a.floatValue(), cv7Var4, cv7Var5, f, c(), d())) != null) {
            return cv7Var2;
        }
        this.f23351a.d(up5.k(cv7Var4.b(), cv7Var5.b(), f), up5.k(cv7Var4.c(), cv7Var5.c(), f));
        return this.f23351a;
    }
}
