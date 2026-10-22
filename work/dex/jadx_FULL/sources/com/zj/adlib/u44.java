package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class u44 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public t44 e(ug7 ug7Var) {
        if (ug7Var.b() != BarcodeFormat.EAN_13) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (massagedText.length() != 13) {
            return null;
        }
        if (massagedText.startsWith("978") || massagedText.startsWith("979")) {
            return new t44(massagedText);
        }
        return null;
    }
}
