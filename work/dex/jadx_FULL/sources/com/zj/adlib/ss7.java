package com.zj.adlib;

import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ss7 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public rs7 e(ug7 ug7Var) {
        String strSubstring;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("smsto:") && !massagedText.startsWith("SMSTO:") && !massagedText.startsWith("mmsto:") && !massagedText.startsWith("MMSTO:")) {
            return null;
        }
        String strSubstring2 = massagedText.substring(6);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = null;
        }
        return new rs7(strSubstring2, (String) null, (String) null, strSubstring);
    }
}
