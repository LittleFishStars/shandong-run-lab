package com.zj.adlib;

import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class n29 extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public m29 e(ug7 ug7Var) {
        String str;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith(WVUCWebViewClient.SCHEME_TEL) && !massagedText.startsWith("TEL:")) {
            return null;
        }
        if (massagedText.startsWith("TEL:")) {
            str = WVUCWebViewClient.SCHEME_TEL + massagedText.substring(4);
        } else {
            str = massagedText;
        }
        int iIndexOf = massagedText.indexOf(63, 4);
        return new m29(iIndexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, iIndexOf), str, null);
    }
}
