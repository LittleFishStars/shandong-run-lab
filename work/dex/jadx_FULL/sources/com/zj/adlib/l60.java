package com.zj.adlib;

import com.airbnb.lottie.model.animatable.a;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f43002a = JsonReader.a.a("a");
    public static final JsonReader.a b = JsonReader.a.a(AliyunLogKey.KEY_FILL_COLOR, "sc", "sw", "t");

    public static k60 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        k60 k60VarB = null;
        while (jsonReader.l()) {
            if (jsonReader.F(f43002a) != 0) {
                jsonReader.H();
                jsonReader.J();
            } else {
                k60VarB = b(jsonReader, k35Var);
            }
        }
        jsonReader.k();
        return k60VarB == null ? new k60(null, null, null, null) : k60VarB;
    }

    public static k60 b(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        a aVarC = null;
        a aVarC2 = null;
        b bVarE = null;
        b bVarE2 = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(b);
            if (iF == 0) {
                aVarC = com.airbnb.lottie.parser.a.c(jsonReader, k35Var);
            } else if (iF == 1) {
                aVarC2 = com.airbnb.lottie.parser.a.c(jsonReader, k35Var);
            } else if (iF == 2) {
                bVarE = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
            } else if (iF != 3) {
                jsonReader.H();
                jsonReader.J();
            } else {
                bVarE2 = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
            }
        }
        jsonReader.k();
        return new k60(aVarC, aVarC2, bVarE, bVarE2);
    }
}
