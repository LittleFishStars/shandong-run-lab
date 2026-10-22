package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.f;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f43455a = JsonReader.a.a("a", "p", "s", "rz", "r", j.b, RVParams.SHOW_OPTION_MENU, "eo", "sk", "sa");
    public static final JsonReader.a b = JsonReader.a.a("k");

    public static boolean a(h60 h60Var) {
        return h60Var == null || (h60Var.isStatic() && h60Var.b().get(0).f18928a.equals(0.0f, 0.0f));
    }

    public static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof j60) && animatableValue.isStatic() && animatableValue.b().get(0).f18928a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((ps4) bVar.b().get(0)).f18928a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(f fVar) {
        return fVar == null || (fVar.isStatic() && ((cv7) ((ps4) fVar.b().get(0)).f18928a).a(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((ps4) bVar.b().get(0)).f18928a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((ps4) bVar.b().get(0)).f18928a).floatValue() == 0.0f);
    }

    public static m60 g(JsonReader jsonReader, k35 k35Var) throws IOException {
        boolean z;
        boolean z2 = false;
        boolean z3 = jsonReader.y() == JsonReader.Token.BEGIN_OBJECT;
        if (z3) {
            jsonReader.h();
        }
        b bVar = null;
        h60 h60VarA = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        f fVarJ = null;
        b bVarF = null;
        b bVarF2 = null;
        d dVarH = null;
        b bVarF3 = null;
        b bVarF4 = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f43455a)) {
                case 0:
                    boolean z4 = z2;
                    jsonReader.h();
                    while (jsonReader.l()) {
                        if (jsonReader.F(b) != 0) {
                            jsonReader.H();
                            jsonReader.J();
                        } else {
                            h60VarA = i60.a(jsonReader, k35Var);
                        }
                    }
                    jsonReader.k();
                    z2 = z4;
                    continue;
                case 1:
                    animatableValueB = i60.b(jsonReader, k35Var);
                    continue;
                case 2:
                    fVarJ = a.j(jsonReader, k35Var);
                    continue;
                case 3:
                    k35Var.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarH = a.h(jsonReader, k35Var);
                    continue;
                case 6:
                    bVarF3 = a.f(jsonReader, k35Var, z2);
                    continue;
                case 7:
                    bVarF4 = a.f(jsonReader, k35Var, z2);
                    continue;
                case 8:
                    bVarF = a.f(jsonReader, k35Var, z2);
                    continue;
                case 9:
                    bVarF2 = a.f(jsonReader, k35Var, z2);
                    continue;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    continue;
            }
            b bVarF5 = a.f(jsonReader, k35Var, z2);
            if (bVarF5.b().isEmpty()) {
                bVarF5.b().add(new ps4(k35Var, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(k35Var.f())));
            } else {
                if (((ps4) bVarF5.b().get(0)).f18928a == 0) {
                    z = false;
                    bVarF5.b().set(0, new ps4(k35Var, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(k35Var.f())));
                }
                z2 = z;
                bVar = bVarF5;
            }
            z = false;
            z2 = z;
            bVar = bVarF5;
        }
        if (z3) {
            jsonReader.k();
        }
        h60 h60Var = a(h60VarA) ? null : h60VarA;
        AnimatableValue<PointF, PointF> animatableValue = b(animatableValueB) ? null : animatableValueB;
        b bVar2 = c(bVar) ? null : bVar;
        if (d(fVarJ)) {
            fVarJ = null;
        }
        return new m60(h60Var, animatableValue, fVarJ, bVar2, dVarH, bVarF3, bVarF4, f(bVarF) ? null : bVarF, e(bVarF2) ? null : bVarF2);
    }
}
