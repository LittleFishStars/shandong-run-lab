package com.zj.adlib;

import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.c;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class hw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42220a = JsonReader.a.a("nm", y6b.f, j.b, "t", "s", "e", "w", "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    public static final JsonReader.a b = JsonReader.a.a("p", "k");
    public static final JsonReader.a c = JsonReader.a.a("n", "v");

    public static a a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fQ = 0.0f;
        String strV = null;
        GradientType gradientType = null;
        c cVarG = null;
        e eVarI = null;
        e eVarI2 = null;
        b bVarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        b bVar = null;
        boolean zP = false;
        d dVar = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f42220a)) {
                case 0:
                    strV = jsonReader.v();
                    continue;
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
                            cVarG = com.airbnb.lottie.parser.a.g(jsonReader, k35Var, iR);
                        }
                        cVarG = cVarG;
                    }
                    jsonReader.k();
                    break;
                case 2:
                    dVar = com.airbnb.lottie.parser.a.h(jsonReader, k35Var);
                    continue;
                case 3:
                    gradientType = jsonReader.r() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    eVarI = com.airbnb.lottie.parser.a.i(jsonReader, k35Var);
                    continue;
                case 5:
                    eVarI2 = com.airbnb.lottie.parser.a.i(jsonReader, k35Var);
                    continue;
                case 6:
                    bVarE = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                    continue;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.r() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.r() - 1];
                    break;
                case 9:
                    fQ = (float) jsonReader.q();
                    break;
                case 10:
                    zP = jsonReader.p();
                    continue;
                case 11:
                    jsonReader.g();
                    while (jsonReader.l()) {
                        jsonReader.h();
                        String strV2 = null;
                        b bVarE2 = null;
                        while (jsonReader.l()) {
                            int iF2 = jsonReader.F(c);
                            if (iF2 != 0) {
                                b bVar2 = bVar;
                                if (iF2 != 1) {
                                    jsonReader.H();
                                    jsonReader.J();
                                } else {
                                    bVarE2 = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                                }
                                bVar = bVar2;
                            } else {
                                strV2 = jsonReader.v();
                            }
                        }
                        b bVar3 = bVar;
                        jsonReader.k();
                        if (strV2.equals(j.b)) {
                            bVar = bVarE2;
                        } else {
                            if (strV2.equals("d") || strV2.equals(y6b.f)) {
                                k35Var.y(true);
                                arrayList.add(bVarE2);
                            }
                            bVar = bVar3;
                        }
                    }
                    b bVar4 = bVar;
                    jsonReader.j();
                    if (arrayList.size() == 1) {
                        arrayList.add((b) arrayList.get(0));
                    }
                    bVar = bVar4;
                    continue;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    continue;
            }
            strV = strV;
        }
        String str = strV;
        if (dVar == null) {
            dVar = new d(Collections.singletonList(new ps4(100)));
        }
        return new a(str, gradientType, cVarG, dVar, eVarI, eVarI2, bVarE, lineCapType, lineJoinType, fQ, arrayList, bVar, zP);
    }
}
