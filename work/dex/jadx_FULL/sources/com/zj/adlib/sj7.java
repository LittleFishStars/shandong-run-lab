package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class sj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f44702a = JsonReader.a.a("nm", "r", LiveConfigKey.HIGH);

    @Nullable
    public static qj7 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        boolean zP = false;
        String strV = null;
        b bVarF = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f44702a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                bVarF = a.f(jsonReader, k35Var, true);
            } else if (iF != 2) {
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        if (zP) {
            return null;
        }
        return new qj7(strV, bVarF);
    }
}
