package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import com.alibaba.ariver.kernel.RVStartParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 42})
public class i implements aw<com.byazt.nb.tt> {
    public static final i c = new i();

    private i() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.fs.aw
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.nb.tt tt(JsonReader jsonReader, float f) throws IOException {
        float f2;
        PointF pointF;
        com.byazt.nb.n nVar;
        com.byazt.nb.tt.c cVar = com.byazt.nb.tt.c.CENTER;
        com.byazt.nb.n nVar2 = new com.byazt.nb.n();
        jsonReader.beginObject();
        com.byazt.nb.tt.c cVar2 = cVar;
        String strNextString = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        String strNextString2 = null;
        String strNextString3 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iC = 0;
        int iC2 = 0;
        boolean zNextBoolean = true;
        String strNextString4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 102:
                    if (strNextName.equals("f")) {
                        b = 0;
                    }
                    break;
                case 106:
                    if (strNextName.equals("j")) {
                        b = 1;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 3261:
                    if (strNextName.equals(AliyunLogKey.KEY_FILL_COLOR)) {
                        b = 4;
                    }
                    break;
                case 3452:
                    if (strNextName.equals("lh")) {
                        b = 5;
                    }
                    break;
                case 3463:
                    if (strNextName.equals(RVStartParams.KEY_LANDSCAPE_SHORT)) {
                        b = 6;
                    }
                    break;
                case 3543:
                    if (strNextName.equals("of")) {
                        b = 7;
                    }
                    break;
                case 3587:
                    if (strNextName.equals("ps")) {
                        b = 8;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 9;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 10;
                    }
                    break;
                case 3687:
                    if (strNextName.equals(AliyunLogKey.KEY_SIZE)) {
                        b = 11;
                    }
                    break;
                case 3710:
                    if (strNextName.equals("tr")) {
                        b = 12;
                    }
                    break;
                case 100524:
                    if (strNextName.equals("els")) {
                        b = 13;
                    }
                    break;
                case 100525:
                    if (strNextName.equals("elt")) {
                        b = com.google.common.base.a.p;
                    }
                    break;
                case 1188971929:
                    if (strNextName.equals("line_cfg")) {
                        b = com.google.common.base.a.q;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    strNextString = jsonReader.nextString();
                    continue;
                case 1:
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    int iNextInt2 = jsonReader.nextInt();
                    cVar2 = com.byazt.nb.tt.c.CENTER;
                    if (iNextInt2 <= cVar2.ordinal() && iNextInt2 >= 0) {
                        cVar2 = com.byazt.nb.tt.c.values()[iNextInt2];
                    }
                    break;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                case 3:
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    strNextString4 = jsonReader.nextString();
                    if (strNextString4 == null) {
                        strNextString4 = "";
                    }
                    break;
                case 4:
                    iC = my.c(jsonReader);
                    continue;
                case 5:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case 6:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                case 8:
                    jsonReader.beginArray();
                    pointF2 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    fNextDouble = fNextDouble;
                    continue;
                case 9:
                    iC2 = my.c(jsonReader);
                    continue;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                case 11:
                    jsonReader.beginArray();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF3 = pointF4;
                    break;
                case 12:
                    iNextInt = jsonReader.nextInt();
                    continue;
                case 13:
                    strNextString3 = jsonReader.nextString();
                    continue;
                case 14:
                    strNextString2 = jsonReader.nextString();
                    continue;
                case 15:
                    c(jsonReader, nVar2);
                    continue;
                default:
                    jsonReader.skipValue();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    break;
            }
            fNextDouble = f2;
            nVar2 = nVar;
            pointF2 = pointF;
        }
        jsonReader.endObject();
        return new com.byazt.nb.tt(strNextString4, strNextString, fNextDouble, cVar2, iNextInt, fNextDouble2, fNextDouble3, iC, iC2, fNextDouble4, zNextBoolean, pointF2, pointF3, nVar2, strNextString2, strNextString3);
    }

    private static void c(JsonReader jsonReader, com.byazt.nb.n nVar) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.kuaishou.weapon.p0.t.d)) {
                nVar.c = jsonReader.nextInt();
            } else if (!strNextName.equals("m")) {
                jsonReader.skipValue();
            } else {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt <= 3 && iNextInt >= 0) {
                    nVar.tt = iNextInt;
                } else {
                    nVar.tt = 0;
                }
            }
        }
        jsonReader.endObject();
    }
}
