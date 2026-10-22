package com.zj.adlib;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class pk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f44001a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static kk3 a(JsonReader jsonReader) throws IOException {
        jsonReader.h();
        String strV = null;
        String strV2 = null;
        float fQ = 0.0f;
        String strV3 = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f44001a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                strV3 = jsonReader.v();
            } else if (iF == 2) {
                strV2 = jsonReader.v();
            } else if (iF != 3) {
                jsonReader.H();
                jsonReader.J();
            } else {
                fQ = (float) jsonReader.q();
            }
        }
        jsonReader.k();
        return new kk3(strV, strV3, strV2, fQ);
    }
}
