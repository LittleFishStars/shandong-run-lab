package com.google.zxing.client.result;

import com.zj.adlib.bz2;
import com.zj.adlib.ug7;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class d extends AbstractDoCoMoResultParser {
    public static final Pattern d = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean k(String str) {
        return str != null && d.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public bz2 e(ug7 ug7Var) {
        String[] strArrI;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("MATMSG:") || (strArrI = AbstractDoCoMoResultParser.i("TO:", massagedText)) == null) {
            return null;
        }
        for (String str : strArrI) {
            if (!k(str)) {
                return null;
            }
        }
        return new bz2(strArrI, null, null, AbstractDoCoMoResultParser.j("SUB:", massagedText, false), AbstractDoCoMoResultParser.j("BODY:", massagedText, false));
    }
}
