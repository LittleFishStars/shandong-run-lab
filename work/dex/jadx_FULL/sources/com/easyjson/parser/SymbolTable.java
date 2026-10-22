package com.easyjson.parser;

import com.easyjson.JSON;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SymbolTable {
    private final int indexMask;
    private final a[] symbols;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29554a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1516a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final char[] f1517a;

        public a(String str, int i) {
            this.f1516a = str;
            this.f1517a = str.toCharArray();
            this.f29554a = i;
        }
    }

    public SymbolTable(int i) {
        this.indexMask = i - 1;
        this.symbols = new a[i];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    public static int hash(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = (i4 * 31) + cArr[i];
            i3++;
            i++;
        }
        return i4;
    }

    private static String subString(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(String str, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        a aVar = this.symbols[i4];
        if (aVar != null) {
            return (i3 == aVar.f29554a && i2 == aVar.f1517a.length && str.regionMatches(i, aVar.f1516a, 0, i2)) ? aVar.f1516a : subString(str, i, i2);
        }
        if (i2 != str.length()) {
            str = subString(str, i, i2);
        }
        String strIntern = str.intern();
        this.symbols[i4] = new a(strIntern, i3);
        return strIntern;
    }

    public String addSymbol(char[] cArr, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        a aVar = this.symbols[i4];
        if (aVar == null) {
            String strIntern = new String(cArr, i, i2).intern();
            this.symbols[i4] = new a(strIntern, i3);
            return strIntern;
        }
        boolean z = false;
        if (i3 == aVar.f29554a && i2 == aVar.f1517a.length) {
            for (int i5 = 0; i5 < i2; i5++) {
                if (cArr[i + i5] == aVar.f1517a[i5]) {
                }
            }
            z = true;
        }
        return z ? aVar.f1516a : new String(cArr, i, i2);
    }
}
