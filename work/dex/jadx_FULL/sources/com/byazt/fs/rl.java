package com.byazt.fs;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 117})
public class rl {
    public static <T> List<com.byazt.vc.c<T>> c(JsonReader jsonReader, com.byazt.ga.a aVar, float f, aw<T> awVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            aVar.c("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(gt.c(jsonReader, aVar, f, awVar, false, z));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(gt.c(jsonReader, aVar, f, awVar, true, z));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(gt.c(jsonReader, aVar, f, awVar, false, z));
            }
        }
        jsonReader.endObject();
        c(arrayList);
        return arrayList;
    }

    public static <T> void c(List<? extends com.byazt.vc.c<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.byazt.vc.c<T> cVar = list.get(i2);
            i2++;
            com.byazt.vc.c<T> cVar2 = list.get(i2);
            cVar.sp = Float.valueOf(cVar2.f29127a);
            if (cVar.tt == null && (t = cVar2.c) != null) {
                cVar.tt = t;
                if (cVar instanceof com.byazt.dg.i) {
                    ((com.byazt.dg.i) cVar).c();
                }
            }
        }
        com.byazt.vc.c<T> cVar3 = list.get(i);
        if ((cVar3.c == null || cVar3.tt == null) && list.size() > 1) {
            list.remove(cVar3);
        }
    }
}
