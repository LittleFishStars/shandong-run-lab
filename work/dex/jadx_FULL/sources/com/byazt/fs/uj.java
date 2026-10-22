package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 15})
public class uj {
    public static com.byazt.kd.da a(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.da(c(jsonReader, com.byazt.kk.da.c(), aVar, i.c));
    }

    public static com.byazt.kd.tt c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return c(jsonReader, aVar, true);
    }

    public static com.byazt.kd.x n(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.x(c(jsonReader, com.byazt.kk.da.c(), aVar, cu.c));
    }

    public static com.byazt.kd.c sp(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.c(c(jsonReader, aVar, sp.c));
    }

    public static com.byazt.kd.uj tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.uj(c(jsonReader, aVar, rh.c));
    }

    public static com.byazt.kd.sp uj(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.sp(c(jsonReader, aVar, or.c));
    }

    public static com.byazt.kd.a ve(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.kd.a(rl.c(jsonReader, aVar, com.byazt.kk.da.c(), md.c, true));
    }

    public static com.byazt.kd.tt c(JsonReader jsonReader, com.byazt.ga.a aVar, boolean z) throws IOException {
        return new com.byazt.kd.tt(c(jsonReader, z ? com.byazt.kk.da.c() : 1.0f, aVar, t.c));
    }

    public static com.byazt.kd.ve c(JsonReader jsonReader, com.byazt.ga.a aVar, int i) throws IOException {
        return new com.byazt.kd.ve(c(jsonReader, aVar, new z(i)));
    }

    private static <T> List<com.byazt.vc.c<T>> c(JsonReader jsonReader, com.byazt.ga.a aVar, aw<T> awVar) throws IOException {
        return rl.c(jsonReader, aVar, 1.0f, awVar, false);
    }

    private static <T> List<com.byazt.vc.c<T>> c(JsonReader jsonReader, float f, com.byazt.ga.a aVar, aw<T> awVar) throws IOException {
        return rl.c(jsonReader, aVar, f, awVar, false);
    }
}
