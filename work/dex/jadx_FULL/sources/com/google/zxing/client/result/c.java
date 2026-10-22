package com.google.zxing.client.result;

import com.zj.adlib.kf9;
import com.zj.adlib.lf9;
import com.zj.adlib.ug7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c extends AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public kf9 e(ug7 ug7Var) {
        String strG = ug7Var.g();
        if (!strG.startsWith("MEBKM:")) {
            return null;
        }
        String strJ = AbstractDoCoMoResultParser.j("TITLE:", strG, true);
        String[] strArrI = AbstractDoCoMoResultParser.i("URL:", strG);
        if (strArrI == null) {
            return null;
        }
        String str = strArrI[0];
        if (lf9.i(str)) {
            return new kf9(str, strJ);
        }
        return null;
    }
}
