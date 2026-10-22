package com.zj.adlib;

import android.graphics.PointF;
import com.acse.ottn.p3;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ku6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42912a = JsonReader.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", p3.g, LiveConfigKey.HIGH, "d");

    public static PolystarShape a(JsonReader jsonReader, k35 k35Var, int i) throws IOException {
        boolean zP = false;
        boolean z = i == 3;
        String strV = null;
        PolystarShape.Type typeForValue = null;
        b bVarF = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        b bVarF2 = null;
        b bVarE = null;
        b bVarE2 = null;
        b bVarF3 = null;
        b bVarF4 = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f42912a)) {
                case 0:
                    strV = jsonReader.v();
                    break;
                case 1:
                    typeForValue = PolystarShape.Type.forValue(jsonReader.r());
                    break;
                case 2:
                    bVarF = a.f(jsonReader, k35Var, false);
                    break;
                case 3:
                    animatableValueB = i60.b(jsonReader, k35Var);
                    break;
                case 4:
                    bVarF2 = a.f(jsonReader, k35Var, false);
                    break;
                case 5:
                    bVarE2 = a.e(jsonReader, k35Var);
                    break;
                case 6:
                    bVarF4 = a.f(jsonReader, k35Var, false);
                    break;
                case 7:
                    bVarE = a.e(jsonReader, k35Var);
                    break;
                case 8:
                    bVarF3 = a.f(jsonReader, k35Var, false);
                    break;
                case 9:
                    zP = jsonReader.p();
                    break;
                case 10:
                    z = jsonReader.r() == 3;
                    break;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    break;
            }
        }
        return new PolystarShape(strV, typeForValue, bVarF, animatableValueB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4, zP, z);
    }
}
