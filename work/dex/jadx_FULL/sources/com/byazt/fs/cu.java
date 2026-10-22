package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 121})
public class cu implements aw<com.byazt.jx.yp> {
    public static final cu c = new cu();

    private cu() {
    }

    @Override // com.byazt.fs.aw
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.jx.yp tt(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listC = null;
        List<PointF> listC2 = null;
        List<PointF> listC3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listC == null || listC2 == null || listC3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listC.isEmpty()) {
                    return new com.byazt.jx.yp(new PointF(), false, Collections.emptyList());
                }
                int size = listC.size();
                PointF pointF = listC.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listC.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.byazt.nb.c(com.byazt.kk.i.c(listC.get(i2), listC3.get(i2)), com.byazt.kk.i.c(pointF2, listC2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listC.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.byazt.nb.c(com.byazt.kk.i.c(listC.get(i3), listC3.get(i3)), com.byazt.kk.i.c(pointF3, listC2.get(0)), pointF3));
                }
                return new com.byazt.jx.yp(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listC2 = my.c(jsonReader, f);
                    break;
                case "o":
                    listC3 = my.c(jsonReader, f);
                    break;
                case "v":
                    listC = my.c(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }
}
