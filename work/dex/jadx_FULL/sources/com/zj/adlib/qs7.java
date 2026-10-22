package com.zj.adlib;

import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.google.zxing.client.result.ResultParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class qs7 extends ResultParser {
    public static void i(Collection<String> collection, Collection<String> collection2, String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public rs7 e(ug7 ug7Var) {
        boolean z;
        String str;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        String str2 = null;
        if (!massagedText.startsWith(WVUCWebViewClient.SCHEME_SMS) && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> mapF = ResultParser.f(massagedText);
        if (mapF == null || mapF.isEmpty()) {
            z = false;
            str = null;
        } else {
            str2 = mapF.get("subject");
            str = mapF.get("body");
            z = true;
        }
        int iIndexOf = massagedText.indexOf(63, 4);
        String strSubstring = (iIndexOf < 0 || !z) ? massagedText.substring(4) : massagedText.substring(4, iIndexOf);
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        int i = -1;
        while (true) {
            int i2 = i + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i2);
            if (iIndexOf2 <= i) {
                i(arrayList, arrayList2, strSubstring.substring(i2));
                String[] strArr = ResultParser.f6728a;
                return new rs7((String[]) arrayList.toArray(strArr), (String[]) arrayList2.toArray(strArr), str2, str);
            }
            i(arrayList, arrayList2, strSubstring.substring(i2, iIndexOf2));
            i = iIndexOf2;
        }
    }
}
