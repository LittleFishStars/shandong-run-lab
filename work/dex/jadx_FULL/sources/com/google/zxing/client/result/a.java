package com.google.zxing.client.result;

import com.zj.adlib.s10;
import com.zj.adlib.ug7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a extends AbstractDoCoMoResultParser {
    public static String l(String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public s10 e(ug7 ug7Var) {
        String[] strArrI;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("MECARD:") || (strArrI = AbstractDoCoMoResultParser.i("N:", massagedText)) == null) {
            return null;
        }
        String strL = l(strArrI[0]);
        String strJ = AbstractDoCoMoResultParser.j("SOUND:", massagedText, true);
        String[] strArrI2 = AbstractDoCoMoResultParser.i("TEL:", massagedText);
        String[] strArrI3 = AbstractDoCoMoResultParser.i("EMAIL:", massagedText);
        String strJ2 = AbstractDoCoMoResultParser.j("NOTE:", massagedText, false);
        String[] strArrI4 = AbstractDoCoMoResultParser.i("ADR:", massagedText);
        String strJ3 = AbstractDoCoMoResultParser.j("BDAY:", massagedText, true);
        return new s10(ResultParser.maybeWrap(strL), null, strJ, strArrI2, null, strArrI3, null, null, strJ2, strArrI4, null, AbstractDoCoMoResultParser.j("ORG:", massagedText, true), !ResultParser.isStringOfDigits(strJ3, 8) ? null : strJ3, null, AbstractDoCoMoResultParser.i("URL:", massagedText), null);
    }
}
