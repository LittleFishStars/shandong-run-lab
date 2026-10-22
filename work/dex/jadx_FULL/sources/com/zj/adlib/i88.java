package com.zj.adlib;

import android.graphics.Path;
import com.airbnb.lottie.model.animatable.a;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42301a = JsonReader.a.a("nm", "c", j.b, "fillEnabled", "r", LiveConfigKey.HIGH);

    public static h88 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        d dVar = null;
        String strV = null;
        a aVarC = null;
        boolean zP = false;
        boolean zP2 = false;
        int iR = 1;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f42301a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                aVarC = com.airbnb.lottie.parser.a.c(jsonReader, k35Var);
            } else if (iF == 2) {
                dVar = com.airbnb.lottie.parser.a.h(jsonReader, k35Var);
            } else if (iF == 3) {
                zP = jsonReader.p();
            } else if (iF == 4) {
                iR = jsonReader.r();
            } else if (iF != 5) {
                jsonReader.H();
                jsonReader.J();
            } else {
                zP2 = jsonReader.p();
            }
        }
        if (dVar == null) {
            dVar = new d(Collections.singletonList(new ps4(100)));
        }
        return new h88(strV, zP, iR == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVar, zP2);
    }
}
