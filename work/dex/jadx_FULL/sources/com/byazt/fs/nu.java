package com.byazt.fs;

import android.util.JsonReader;
import com.google.android.exoplayer2.source.rtsp.j;
import com.zj.adlib.y6b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 137})
public class nu {
    public static com.byazt.jx.a c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.jx.rh.c cVar;
        com.byazt.jx.rh.tt ttVar;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.jx.sp spVar = null;
        com.byazt.kd.ve veVarC = null;
        com.byazt.kd.a aVarVe = null;
        com.byazt.kd.a aVarVe2 = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.jx.rh.c cVar2 = null;
        com.byazt.jx.rh.tt ttVar2 = null;
        com.byazt.kd.tt ttVar3 = null;
        boolean zNextBoolean = false;
        com.byazt.kd.uj ujVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            zNextBoolean = zNextBoolean;
            com.byazt.kd.tt ttVar4 = ttVar3;
            float f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.kd.tt ttVarC2 = null;
                        while (jsonReader.hasNext()) {
                            com.byazt.jx.rh.tt ttVar5 = ttVar2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.byazt.jx.rh.c cVar3 = cVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                ttVarC2 = uj.c(jsonReader, aVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            ttVar2 = ttVar5;
                            cVar2 = cVar3;
                        }
                        cVar2 = cVar2;
                        ttVar2 = ttVar2;
                        jsonReader.endObject();
                        if (j.b.equals(strNextString2)) {
                            ttVar4 = ttVarC2;
                        } else if ("d".equals(strNextString2) || y6b.f.equals(strNextString2)) {
                            aVar.c(true);
                            arrayList.add(ttVarC2);
                        }
                    }
                    cVar = cVar2;
                    ttVar = ttVar2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        ttVar3 = ttVar4;
                    } else {
                        ttVar3 = ttVar4;
                    }
                    ttVar2 = ttVar;
                    fNextDouble = f;
                    cVar2 = cVar;
                    break;
                case "e":
                    aVarVe2 = uj.ve(jsonReader, aVar);
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals("k")) {
                            veVarC = uj.c(jsonReader, aVar, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "o":
                    ujVar = uj.tt(jsonReader, aVar);
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "s":
                    aVarVe = uj.ve(jsonReader, aVar);
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "t":
                    spVar = jsonReader.nextInt() == 1 ? com.byazt.jx.sp.LINEAR : com.byazt.jx.sp.RADIAL;
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "w":
                    ttVarC = uj.c(jsonReader, aVar);
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "lc":
                    cVar2 = com.byazt.jx.rh.c.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "lj":
                    ttVar2 = com.byazt.jx.rh.tt.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = zNextBoolean;
                    ttVar3 = ttVar4;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    cVar = cVar2;
                    ttVar = ttVar2;
                    ttVar3 = ttVar4;
                    ttVar2 = ttVar;
                    fNextDouble = f;
                    cVar2 = cVar;
                    break;
            }
        }
        com.byazt.jx.rh.c cVar4 = cVar2;
        com.byazt.jx.rh.tt ttVar6 = ttVar2;
        float f2 = fNextDouble;
        com.byazt.kd.tt ttVar7 = ttVar3;
        boolean z = zNextBoolean;
        if (ujVar == null) {
            ujVar = new com.byazt.kd.uj(Collections.singletonList(new com.byazt.vc.c(100)));
        }
        return new com.byazt.jx.a(strNextString, spVar, veVarC, ujVar, aVarVe, aVarVe2, ttVarC, cVar4, ttVar6, f2, arrayList, ttVar7, z);
    }
}
