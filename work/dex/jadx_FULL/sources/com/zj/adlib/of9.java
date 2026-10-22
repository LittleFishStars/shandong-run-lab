package com.zj.adlib;

import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class of9 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public kf9 e(ug7 ug7Var) {
        int iIndexOf;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if ((massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) && (iIndexOf = massagedText.indexOf(58, 6)) >= 0) {
            return new kf9(massagedText.substring(iIndexOf + 1), iIndexOf > 6 ? massagedText.substring(6, iIndexOf) : null);
        }
        return null;
    }
}
