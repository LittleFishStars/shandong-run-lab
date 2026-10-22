package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class il1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42384a = JsonReader.a.a("nm", "p", "s", LiveConfigKey.HIGH, "d");

    public static hl1 a(JsonReader jsonReader, k35 k35Var, int i) throws IOException {
        boolean z = i == 3;
        boolean zP = false;
        String strV = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        e eVarI = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f42384a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                animatableValueB = i60.b(jsonReader, k35Var);
            } else if (iF == 2) {
                eVarI = a.i(jsonReader, k35Var);
            } else if (iF == 3) {
                zP = jsonReader.p();
            } else if (iF != 4) {
                jsonReader.H();
                jsonReader.J();
            } else {
                z = jsonReader.r() == 3;
            }
        }
        return new hl1(strV, animatableValueB, eVarI, z, zP);
    }
}
