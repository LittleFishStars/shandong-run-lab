package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 34})
public class a {
    public static com.byazt.jx.tt c(JsonReader jsonReader, com.byazt.ga.a aVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.kd.u<PointF, PointF> uVarTt = null;
        com.byazt.kd.a aVarVe = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    uVarTt = c.tt(jsonReader, aVar);
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
        return new com.byazt.jx.tt(strNextString, uVarTt, aVarVe, z, zNextBoolean);
    }
}
