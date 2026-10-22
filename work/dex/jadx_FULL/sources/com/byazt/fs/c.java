package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 20})
public class c {
    public static com.byazt.kd.n c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(yv.c(jsonReader, aVar));
            }
            jsonReader.endArray();
            rl.c(arrayList);
        } else {
            arrayList.add(new com.byazt.vc.c(my.tt(jsonReader, com.byazt.kk.da.c())));
        }
        return new com.byazt.kd.n(arrayList);
    }

    public static com.byazt.kd.u<PointF, PointF> tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.kd.n nVarC = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    nVarC = c(jsonReader, aVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        ttVarC = uj.c(jsonReader, aVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        ttVarC2 = uj.c(jsonReader, aVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            aVar.c("Lottie doesn't support expressions.");
        }
        return nVarC != null ? nVarC : new com.byazt.kd.i(ttVarC, ttVarC2);
    }
}
