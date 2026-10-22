package com.zj.adlib;

import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class xe7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f45808a = JsonReader.a.a("nm", "c", j.b, "tr", LiveConfigKey.HIGH);

    public static we7 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        String strV = null;
        b bVarF = null;
        b bVarF2 = null;
        m60 m60VarG = null;
        boolean zP = false;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f45808a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                bVarF = a.f(jsonReader, k35Var, false);
            } else if (iF == 2) {
                bVarF2 = a.f(jsonReader, k35Var, false);
            } else if (iF == 3) {
                m60VarG = n60.g(jsonReader, k35Var);
            } else if (iF != 4) {
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        return new we7(strV, bVarF, bVarF2, m60VarG, zP);
    }
}
