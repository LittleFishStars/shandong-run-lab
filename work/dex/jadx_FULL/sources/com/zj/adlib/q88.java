package com.zj.adlib;

import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f44153a = JsonReader.a.a("s", "e", j.b, "nm", "m", LiveConfigKey.HIGH);

    public static ShapeTrimPath a(JsonReader jsonReader, k35 k35Var) throws IOException {
        String strV = null;
        ShapeTrimPath.Type typeForId = null;
        b bVarF = null;
        b bVarF2 = null;
        b bVarF3 = null;
        boolean zP = false;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f44153a);
            if (iF == 0) {
                bVarF = a.f(jsonReader, k35Var, false);
            } else if (iF == 1) {
                bVarF2 = a.f(jsonReader, k35Var, false);
            } else if (iF == 2) {
                bVarF3 = a.f(jsonReader, k35Var, false);
            } else if (iF == 3) {
                strV = jsonReader.v();
            } else if (iF == 4) {
                typeForId = ShapeTrimPath.Type.forId(jsonReader.r());
            } else if (iF != 5) {
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        return new ShapeTrimPath(strV, typeForId, bVarF, bVarF2, bVarF3, zP);
    }
}
