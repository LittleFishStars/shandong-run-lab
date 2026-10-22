package com.google.zxing.client.result;

import com.zj.adlib.s10;
import com.zj.adlib.ug7;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b extends AbstractDoCoMoResultParser {
    public static String k(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    public static String[] l(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public s10 e(ug7 ug7Var) {
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        String strK = k(AbstractDoCoMoResultParser.j("N:", massagedText, true), AbstractDoCoMoResultParser.j("X:", massagedText, true));
        String strJ = AbstractDoCoMoResultParser.j("T:", massagedText, true);
        String strJ2 = AbstractDoCoMoResultParser.j("C:", massagedText, true);
        return new s10(ResultParser.maybeWrap(strK), null, null, l(AbstractDoCoMoResultParser.j("B:", massagedText, true), AbstractDoCoMoResultParser.j("M:", massagedText, true), AbstractDoCoMoResultParser.j("F:", massagedText, true)), null, ResultParser.maybeWrap(AbstractDoCoMoResultParser.j("E:", massagedText, true)), null, null, null, AbstractDoCoMoResultParser.i("A:", massagedText), null, strJ2, null, strJ, null, null);
    }
}
