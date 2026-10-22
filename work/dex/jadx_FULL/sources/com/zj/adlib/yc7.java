package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class yc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f45998a = JsonReader.a.a("nm", "p", "s", "r", LiveConfigKey.HIGH);

    public static xc7 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        String strV = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        e eVarI = null;
        b bVarE = null;
        boolean zP = false;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f45998a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                animatableValueB = i60.b(jsonReader, k35Var);
            } else if (iF == 2) {
                eVarI = a.i(jsonReader, k35Var);
            } else if (iF == 3) {
                bVarE = a.e(jsonReader, k35Var);
            } else if (iF != 4) {
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        return new xc7(strV, animatableValueB, eVarI, bVarE, zP);
    }
}
