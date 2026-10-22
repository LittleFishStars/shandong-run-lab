package com.zj.adlib;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ok3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f43766a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", "data");
    public static final JsonReader.a b = JsonReader.a.a("shapes");

    public static nk3 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.h();
        double dQ = 0.0d;
        String strV = null;
        String strV2 = null;
        char cCharAt = 0;
        double dQ2 = 0.0d;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f43766a);
            if (iF == 0) {
                cCharAt = jsonReader.v().charAt(0);
            } else if (iF == 1) {
                dQ2 = jsonReader.q();
            } else if (iF == 2) {
                dQ = jsonReader.q();
            } else if (iF == 3) {
                strV = jsonReader.v();
            } else if (iF == 4) {
                strV2 = jsonReader.v();
            } else if (iF != 5) {
                jsonReader.H();
                jsonReader.J();
            } else {
                jsonReader.h();
                while (jsonReader.l()) {
                    if (jsonReader.F(b) != 0) {
                        jsonReader.H();
                        jsonReader.J();
                    } else {
                        jsonReader.g();
                        while (jsonReader.l()) {
                            arrayList.add((j88) xu1.a(jsonReader, k35Var));
                        }
                        jsonReader.j();
                    }
                }
                jsonReader.k();
            }
        }
        jsonReader.k();
        return new nk3(arrayList, cCharAt, dQ2, dQ, strV, strV2);
    }
}
