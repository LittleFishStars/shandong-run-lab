package com.zj.adlib;

import android.graphics.Path;
import com.airbnb.lottie.model.animatable.c;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ew3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f41537a = JsonReader.a.a("nm", y6b.f, j.b, "t", "s", "e", "r", LiveConfigKey.HIGH);
    public static final JsonReader.a b = JsonReader.a.a("p", "k");

    public static dw3 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        d dVarH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strV = null;
        GradientType gradientType = null;
        c cVarG = null;
        e eVarI = null;
        e eVarI2 = null;
        boolean zP = false;
        while (jsonReader.l()) {
            switch (jsonReader.F(f41537a)) {
                case 0:
                    strV = jsonReader.v();
                    break;
                case 1:
                    jsonReader.h();
                    int iR = -1;
                    while (jsonReader.l()) {
                        int iF = jsonReader.F(b);
                        if (iF == 0) {
                            iR = jsonReader.r();
                        } else if (iF != 1) {
                            jsonReader.H();
                            jsonReader.J();
                        } else {
                            cVarG = a.g(jsonReader, k35Var, iR);
                        }
                    }
                    jsonReader.k();
                    break;
                case 2:
                    dVarH = a.h(jsonReader, k35Var);
                    break;
                case 3:
                    gradientType = jsonReader.r() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    eVarI = a.i(jsonReader, k35Var);
                    break;
                case 5:
                    eVarI2 = a.i(jsonReader, k35Var);
                    break;
                case 6:
                    fillType = jsonReader.r() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zP = jsonReader.p();
                    break;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    break;
            }
        }
        return new dw3(strV, gradientType, fillType, cVarG, dVarH == null ? new d(Collections.singletonList(new ps4(100))) : dVarH, eVarI, eVarI2, null, null, zP);
    }
}
