package com.byazt.fs;

import android.util.JsonReader;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 46})
public class n {
    public static com.byazt.jx.c c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.jx.c cVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(ef.f25915a)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.byazt.jx.c cVarTt = tt(jsonReader, aVar);
                    if (cVarTt != null) {
                        cVar = cVarTt;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return cVar;
    }

    private static com.byazt.jx.c tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.jx.c cVar = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (!jsonReader.hasNext()) {
                    jsonReader.endObject();
                    return cVar;
                }
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z) {
                        cVar = new com.byazt.jx.c(uj.c(jsonReader, aVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!strNextName.equals(com.alipay.sdk.m.w.a.u)) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z = true;
                }
            }
        }
    }
}
