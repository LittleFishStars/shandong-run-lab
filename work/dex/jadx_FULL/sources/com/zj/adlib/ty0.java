package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.sdk.m.w.a;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ty0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f45025a = JsonReader.a.a(ef.f25915a);
    public static final JsonReader.a b = JsonReader.a.a(a.u, "v");

    @Nullable
    public static sy0 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        sy0 sy0Var = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (!jsonReader.l()) {
                    jsonReader.k();
                    return sy0Var;
                }
                int iF = jsonReader.F(b);
                if (iF != 0) {
                    if (iF != 1) {
                        jsonReader.H();
                        jsonReader.J();
                    } else if (z) {
                        sy0Var = new sy0(com.airbnb.lottie.parser.a.e(jsonReader, k35Var));
                    } else {
                        jsonReader.J();
                    }
                } else if (jsonReader.r() == 0) {
                    z = true;
                }
            }
        }
    }

    @Nullable
    public static sy0 b(JsonReader jsonReader, k35 k35Var) throws IOException {
        sy0 sy0Var = null;
        while (jsonReader.l()) {
            if (jsonReader.F(f45025a) != 0) {
                jsonReader.H();
                jsonReader.J();
            } else {
                jsonReader.g();
                while (jsonReader.l()) {
                    sy0 sy0VarA = a(jsonReader, k35Var);
                    if (sy0VarA != null) {
                        sy0Var = sy0VarA;
                    }
                }
                jsonReader.j();
            }
        }
        return sy0Var;
    }
}
