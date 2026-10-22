package com.zj.adlib;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class bm5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f40779a = JsonReader.a.a("nm", "mm", LiveConfigKey.HIGH);

    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String strV = null;
        boolean zP = false;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f40779a);
            if (iF == 0) {
                strV = jsonReader.v();
            } else if (iF == 1) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.r());
            } else if (iF != 2) {
                jsonReader.H();
                jsonReader.J();
            } else {
                zP = jsonReader.p();
            }
        }
        return new MergePaths(strV, mergePathsModeForId, zP);
    }
}
