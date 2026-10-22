package com.byazt.fs;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 499})
public class yv {
    public static com.byazt.dg.i c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.dg.i(aVar, gt.c(jsonReader, aVar, com.byazt.kk.da.c(), p.c, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
