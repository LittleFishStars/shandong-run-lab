package cj.mobile.wm;

import com.easyjson.JSON;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public final dexa[] dexa;
    public final int dexb;

    public static class dexa {
        public final String dexa;
        public final char[] dexb;
        public final int dexc;

        public dexa(String str, int i) {
            this.dexa = str;
            this.dexb = str.toCharArray();
            this.dexc = i;
        }
    }

    public c(int i) {
        this.dexb = i - 1;
        this.dexa = new dexa[i];
        dexa("$ref", 0, 4, 1185263);
        dexa(JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    public static String dexa(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public String dexa(String str, int i, int i2, int i3) {
        int i4 = this.dexb & i3;
        dexa dexaVar = this.dexa[i4];
        if (dexaVar != null) {
            return (i3 == dexaVar.dexc && i2 == dexaVar.dexb.length && str.regionMatches(i, dexaVar.dexa, 0, i2)) ? dexaVar.dexa : dexa(str, i, i2);
        }
        if (i2 != str.length()) {
            str = dexa(str, i, i2);
        }
        String strIntern = str.intern();
        this.dexa[i4] = new dexa(strIntern, i3);
        return strIntern;
    }

    public String dexa(char[] cArr, int i, int i2, int i3) {
        int i4 = this.dexb & i3;
        dexa dexaVar = this.dexa[i4];
        if (dexaVar == null) {
            String strIntern = new String(cArr, i, i2).intern();
            this.dexa[i4] = new dexa(strIntern, i3);
            return strIntern;
        }
        boolean z = false;
        if (i3 == dexaVar.dexc && i2 == dexaVar.dexb.length) {
            for (int i5 = 0; i5 < i2; i5++) {
                if (cArr[i + i5] == dexaVar.dexb[i5]) {
                }
            }
            z = true;
        }
        return z ? dexaVar.dexa : new String(cArr, i, i2);
    }
}
