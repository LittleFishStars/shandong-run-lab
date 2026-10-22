package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 126})
public class bx {
    public static com.byazt.jx.rh c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        int i;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.kd.tt ttVar = null;
        com.byazt.kd.c cVarSp = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.jx.rh.c cVar = null;
        com.byazt.jx.rh.tt ttVar2 = null;
        boolean zNextBoolean = false;
        com.byazt.kd.uj ujVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int i2 = 1;
            switch (strNextName) {
                case "c":
                    cVarSp = uj.sp(jsonReader, aVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.kd.tt ttVarC2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                ttVarC2 = uj.c(jsonReader, aVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i = 1;
                                aVar.c(true);
                                arrayList.add(ttVarC2);
                                i2 = i;
                                break;
                            case "o":
                                ttVar = ttVarC2;
                                i2 = 1;
                                break;
                            default:
                                i = 1;
                                i2 = i;
                                break;
                        }
                    }
                    int i3 = i2;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                case "o":
                    ujVar = uj.tt(jsonReader, aVar);
                    continue;
                    break;
                case "w":
                    ttVarC = uj.c(jsonReader, aVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    cVar = com.byazt.jx.rh.c.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    ttVar2 = com.byazt.jx.rh.tt.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (ujVar == null) {
            ujVar = new com.byazt.kd.uj(Collections.singletonList(new com.byazt.vc.c(100)));
        }
        return new com.byazt.jx.rh(strNextString, ttVar, arrayList, cVarSp, ujVar, ttVarC, cVar, ttVar2, fNextDouble, zNextBoolean);
    }
}
