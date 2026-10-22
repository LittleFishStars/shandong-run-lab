package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.zj.adlib.a45;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j extends KeyframeAnimation<DocumentData> {

    public class a extends j45<DocumentData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DocumentData f469a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ j45 f470a;
        public final /* synthetic */ a45 b;

        public a(a45 a45Var, j45 j45Var, DocumentData documentData) {
            this.b = a45Var;
            this.f470a = j45Var;
            this.f469a = documentData;
        }

        @Override // com.zj.adlib.j45
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public DocumentData a(a45<DocumentData> a45Var) {
            this.b.h(a45Var.f(), a45Var.a(), a45Var.g().f491a, a45Var.b().f491a, a45Var.d(), a45Var.c(), a45Var.e());
            String str = (String) this.f470a.a(this.b);
            DocumentData documentDataB = a45Var.c() == 1.0f ? a45Var.b() : a45Var.g();
            this.f469a.a(str, documentDataB.f494b, documentDataB.f23367a, documentDataB.f490a, documentDataB.f489a, documentDataB.b, documentDataB.c, documentDataB.f493b, documentDataB.f495c, documentDataB.d, documentDataB.f492a);
            return this.f469a;
        }
    }

    public j(List<ps4<DocumentData>> list) {
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
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public DocumentData g(ps4<DocumentData> ps4Var, float f) {
        DocumentData documentData;
        j45<A> j45Var = ((BaseKeyframeAnimation) this).f452a;
        if (j45Var == 0) {
            return (f != 1.0f || (documentData = ps4Var.f18932b) == null) ? ps4Var.f18928a : documentData;
        }
        float f2 = ps4Var.f44051a;
        Float f3 = ps4Var.f18927a;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        DocumentData documentData2 = ps4Var.f18928a;
        DocumentData documentData3 = documentData2;
        DocumentData documentData4 = ps4Var.f18932b;
        return (DocumentData) j45Var.b(f2, fFloatValue, documentData3, documentData4 == null ? documentData2 : documentData4, f, getInterpolatedCurrentKeyframeProgress(), d());
    }

    public void n(j45<String> j45Var) {
        super.k(new a(new a45(), j45Var, new DocumentData()));
    }
}
