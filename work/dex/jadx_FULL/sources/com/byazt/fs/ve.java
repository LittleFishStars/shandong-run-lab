package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 54})
public class ve {
    public static com.byazt.kd.t c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.byazt.kd.tt ttVar = null;
        com.byazt.kd.n nVarC = null;
        com.byazt.kd.u<PointF, PointF> uVarTt = null;
        com.byazt.kd.sp spVarUj = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        com.byazt.kd.uj ujVarTt = null;
        com.byazt.kd.tt ttVarC3 = null;
        com.byazt.kd.tt ttVarC4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            nVarC = c.c(jsonReader, aVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    ujVarTt = uj.tt(jsonReader, aVar);
                    continue;
                    break;
                case "p":
                    uVarTt = c.tt(jsonReader, aVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    spVarUj = uj.uj(jsonReader, aVar);
                    continue;
                    break;
                case "eo":
                    ttVarC4 = uj.c(jsonReader, aVar, false);
                    continue;
                    break;
                case "rz":
                    aVar.c("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    ttVarC2 = uj.c(jsonReader, aVar, false);
                    continue;
                    break;
                case "sk":
                    ttVarC = uj.c(jsonReader, aVar, false);
                    continue;
                    break;
                case "so":
                    ttVarC3 = uj.c(jsonReader, aVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.byazt.kd.tt ttVarC5 = uj.c(jsonReader, aVar, false);
            if (ttVarC5.ve().isEmpty()) {
                ttVarC5.ve().add(new com.byazt.vc.c(aVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(aVar.sp())));
            } else if (((com.byazt.vc.c) ttVarC5.ve().get(0)).c == 0) {
                ttVarC5.ve().set(0, new com.byazt.vc.c(aVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(aVar.sp())));
            }
            ttVar = ttVarC5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (c(nVarC)) {
            nVarC = null;
        }
        return new com.byazt.kd.t(nVarC, c(uVarTt) ? null : uVarTt, c(spVarUj) ? null : spVarUj, c(ttVar) ? null : ttVar, ujVarTt, ttVarC3, ttVarC4, tt(ttVarC) ? null : ttVarC, ve(ttVarC2) ? null : ttVarC2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean tt(com.byazt.kd.tt ttVar) {
        if (ttVar != null) {
            return ttVar.tt() && ((Float) ((com.byazt.vc.c) ttVar.ve().get(0)).c).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean ve(com.byazt.kd.tt ttVar) {
        if (ttVar != null) {
            return ttVar.tt() && ((Float) ((com.byazt.vc.c) ttVar.ve().get(0)).c).floatValue() == 0.0f;
        }
        return true;
    }

    private static boolean c(com.byazt.kd.n nVar) {
        if (nVar != null) {
            return nVar.tt() && nVar.ve().get(0).c.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean c(com.byazt.kd.u<PointF, PointF> uVar) {
        if (uVar != null) {
            return !(uVar instanceof com.byazt.kd.i) && uVar.tt() && uVar.ve().get(0).c.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.byazt.kd.tt ttVar) {
        if (ttVar != null) {
            return ttVar.tt() && ((Float) ((com.byazt.vc.c) ttVar.ve().get(0)).c).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.byazt.kd.sp spVar) {
        if (spVar != null) {
            return spVar.tt() && ((com.byazt.vc.uj) ((com.byazt.vc.c) spVar.ve().get(0)).c).tt(1.0f, 1.0f);
        }
        return true;
    }
}
