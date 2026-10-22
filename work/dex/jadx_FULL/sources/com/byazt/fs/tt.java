package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 13})
public class tt {
    public static com.byazt.kd.sl c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.kd.sl slVarTt = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                slVarTt = tt(jsonReader, aVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return slVarTt == null ? new com.byazt.kd.sl(null, null, null, null) : slVarTt;
    }

    private static com.byazt.kd.sl tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.kd.c cVarSp = null;
        com.byazt.kd.c cVarSp2 = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    ttVarC2 = uj.c(jsonReader, aVar);
                    break;
                case "fc":
                    cVarSp = uj.sp(jsonReader, aVar);
                    break;
                case "sc":
                    cVarSp2 = uj.sp(jsonReader, aVar);
                    break;
                case "sw":
                    ttVarC = uj.c(jsonReader, aVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.kd.sl(cVarSp, cVarSp2, ttVarC, ttVarC2);
    }
}
