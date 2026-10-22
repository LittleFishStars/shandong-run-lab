package com.zj.adlib;

import com.google.common.net.c;
import com.google.zxing.client.result.ResultParser;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class r10 extends ResultParser {
    public static String[] i(String str, String str2) {
        ArrayList arrayList = null;
        for (int i = 1; i <= 3; i++) {
            String strD = ResultParser.d(str + i + c.b, str2, '\r', true);
            if (strD == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(3);
            }
            arrayList.add(strD);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(ResultParser.f6728a);
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public s10 e(ug7 ug7Var) {
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        String strD = ResultParser.d("NAME1:", massagedText, '\r', true);
        String strD2 = ResultParser.d("NAME2:", massagedText, '\r', true);
        String[] strArrI = i("TEL", massagedText);
        String[] strArrI2 = i("MAIL", massagedText);
        String strD3 = ResultParser.d("MEMORY:", massagedText, '\r', false);
        String strD4 = ResultParser.d("ADD:", massagedText, '\r', true);
        return new s10(ResultParser.maybeWrap(strD), null, strD2, strArrI, null, strArrI2, null, null, strD3, strD4 != null ? new String[]{strD4} : null, null, null, null, null, null, null);
    }
}
