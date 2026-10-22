package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class x07 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public w07 e(ug7 ug7Var) {
        BarcodeFormat barcodeFormatB = ug7Var.b();
        if (barcodeFormatB != BarcodeFormat.UPC_A && barcodeFormatB != BarcodeFormat.UPC_E && barcodeFormatB != BarcodeFormat.EAN_8 && barcodeFormatB != BarcodeFormat.EAN_13) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (ResultParser.isStringOfDigits(massagedText, massagedText.length())) {
            return new w07(massagedText, (barcodeFormatB == BarcodeFormat.UPC_E && massagedText.length() == 8) ? if9.m(massagedText) : massagedText);
        }
        return null;
    }
}
