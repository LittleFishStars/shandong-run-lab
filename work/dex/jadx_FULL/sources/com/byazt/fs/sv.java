package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 613})
public class sv {
    public static com.byazt.jx.my c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        String strNextString = null;
        com.byazt.jx.my.c cVarC = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        com.byazt.kd.tt ttVarC3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    ttVarC2 = uj.c(jsonReader, aVar, false);
                    break;
                case "m":
                    cVarC = com.byazt.jx.my.c.c(jsonReader.nextInt());
                    break;
                case "o":
                    ttVarC3 = uj.c(jsonReader, aVar, false);
                    break;
                case "s":
                    ttVarC = uj.c(jsonReader, aVar, false);
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
        return new com.byazt.jx.my(strNextString, cVarC, ttVarC, ttVarC2, ttVarC3, zNextBoolean);
    }
}
