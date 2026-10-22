package com.zj.adlib;

import com.airbnb.lottie.model.animatable.g;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f43690a = JsonReader.a.a("nm", "ind", MediationConstant.ADN_KS, LiveConfigKey.HIGH);

    public static n88 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        String strV = null;
        int iR = 0;
        boolean zP = false;
        g gVarK = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f43690a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                iR = jsonReader.r();
            } else if (iF == 2) {
                gVarK = a.k(jsonReader, k35Var);
            } else if (iF != 3) {
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        return new n88(strV, iR, gVarK, zP);
    }
}
