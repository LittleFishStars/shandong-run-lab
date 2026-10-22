package com.zj.adlib;

import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.igexin.push.g.o;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42763a = JsonReader.a.a("nm", LiveConfigKey.HIGH, o.f);

    public static j88 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strV = null;
        boolean zP = false;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f42763a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                zP = jsonReader.p();
            } else if (iF != 2) {
                jsonReader.J();
            } else {
                jsonReader.g();
                while (jsonReader.l()) {
                    ContentModel contentModelA = xu1.a(jsonReader, k35Var);
                    if (contentModelA != null) {
                        arrayList.add(contentModelA);
                    }
                }
                jsonReader.j();
            }
        }
        return new j88(strV, arrayList, zP);
    }
}
