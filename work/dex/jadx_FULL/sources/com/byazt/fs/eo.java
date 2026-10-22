package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 47})
public class eo {
    public static com.byazt.jx.t c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        String strNextString = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        com.byazt.kd.t tVarC = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    ttVarC = uj.c(jsonReader, aVar, false);
                    break;
                case "o":
                    ttVarC2 = uj.c(jsonReader, aVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    tVarC = ve.c(jsonReader, aVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.jx.t(strNextString, ttVarC, ttVarC2, tVarC, zNextBoolean);
    }
}
