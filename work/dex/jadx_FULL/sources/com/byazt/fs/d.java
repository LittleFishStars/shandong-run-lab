package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 512})
public class d {
    public static com.byazt.jx.sl c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        String strNextString = null;
        com.byazt.kd.u<PointF, PointF> uVarTt = null;
        com.byazt.kd.a aVarVe = null;
        com.byazt.kd.tt ttVarC = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    uVarTt = c.tt(jsonReader, aVar);
                    break;
                case "r":
                    ttVarC = uj.c(jsonReader, aVar);
                    break;
                case "s":
                    aVarVe = uj.ve(jsonReader, aVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.jx.sl(strNextString, uVarTt, aVarVe, ttVarC, zNextBoolean);
    }
}
