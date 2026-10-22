package com.zj.adlib;

import com.airbnb.lottie.model.animatable.a;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f43927a = JsonReader.a.a("nm", "c", "w", j.b, "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    public static final JsonReader.a b = JsonReader.a.a("n", "v");

    public static ShapeStroke a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fQ = 0.0f;
        boolean zP = false;
        String strV = null;
        b bVar = null;
        a aVarC = null;
        b bVarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        d dVar = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f43927a)) {
                case 0:
                    strV = jsonReader.v();
                    break;
                case 1:
                    aVarC = com.airbnb.lottie.parser.a.c(jsonReader, k35Var);
                    break;
                case 2:
                    bVarE = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                    break;
                case 3:
                    dVar = com.airbnb.lottie.parser.a.h(jsonReader, k35Var);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.r() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.r() - 1];
                    break;
                case 6:
                    fQ = (float) jsonReader.q();
                    break;
                case 7:
                    zP = jsonReader.p();
                    break;
                case 8:
                    jsonReader.g();
                    while (jsonReader.l()) {
                        jsonReader.h();
                        String strV2 = null;
                        b bVarE2 = null;
                        while (jsonReader.l()) {
                            int iF = jsonReader.F(b);
                            if (iF == 0) {
                                strV2 = jsonReader.v();
                            } else if (iF != 1) {
                                jsonReader.H();
                                jsonReader.J();
                            } else {
                                bVarE2 = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                            }
                        }
                        jsonReader.k();
                        strV2.hashCode();
                        switch (strV2) {
                            case "d":
                            case "g":
                                k35Var.y(true);
                                arrayList.add(bVarE2);
                                break;
                            case "o":
                                bVar = bVarE2;
                                break;
                        }
                    }
                    jsonReader.j();
                    if (arrayList.size() == 1) {
                        arrayList.add((b) arrayList.get(0));
                    }
                    break;
                default:
                    jsonReader.J();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new d(Collections.singletonList(new ps4(100)));
        }
        return new ShapeStroke(strV, bVar, arrayList, aVarC, dVar, bVarE, lineCapType, lineJoinType, fQ, zP);
    }
}
