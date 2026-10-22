package com.zj.adlib;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class mw9 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public lw9 e(ug7 ug7Var) {
        String strSubstring;
        String strD;
        String str;
        boolean z;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("WIFI:") || (strD = ResultParser.d("S:", (strSubstring = massagedText.substring(5)), dv9.e, false)) == null || strD.isEmpty()) {
            return null;
        }
        String strD2 = ResultParser.d("P:", strSubstring, dv9.e, false);
        String strD3 = ResultParser.d("T:", strSubstring, dv9.e, false);
        if (strD3 == null) {
            strD3 = "nopass";
        }
        String str2 = strD3;
        String strD4 = ResultParser.d("PH2:", strSubstring, dv9.e, false);
        String strD5 = ResultParser.d("H:", strSubstring, dv9.e, false);
        if (strD5 != null) {
            if (strD4 != null || "true".equalsIgnoreCase(strD5) || AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(strD5)) {
                str = strD4;
                z = Boolean.parseBoolean(strD5);
            } else {
                str = strD5;
            }
            return new lw9(str2, strD, strD2, z, ResultParser.d("I:", strSubstring, dv9.e, false), ResultParser.d("A:", strSubstring, dv9.e, false), ResultParser.d("E:", strSubstring, dv9.e, false), str);
        }
        str = strD4;
        z = false;
        return new lw9(str2, strD, strD2, z, ResultParser.d("I:", strSubstring, dv9.e, false), ResultParser.d("A:", strSubstring, dv9.e, false), ResultParser.d("E:", strSubstring, dv9.e, false), str);
    }
}
