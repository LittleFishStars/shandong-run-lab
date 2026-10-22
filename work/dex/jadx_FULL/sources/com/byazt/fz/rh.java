package com.byazt.fz;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1022, 115})
public class rh {
    public static Object c(com.byazt.il.c cVar) {
        sl slVarC;
        if (cVar == null || (slVarC = c(cVar.c())) == null) {
            return null;
        }
        return slVarC.c(null, cVar.tt());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static sl c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1919300188:
                if (str.equals("toNumber")) {
                    b = 0;
                }
                break;
            case -1776922004:
                if (str.equals("toString")) {
                    b = 1;
                }
                break;
            case -1368121510:
                if (str.equals("formatDecimal")) {
                    b = 2;
                }
                break;
            case -652088201:
                if (str.equals("modArray")) {
                    b = 3;
                }
                break;
            case 3143097:
                if (str.equals("find")) {
                    b = 4;
                }
                break;
            case 3267882:
                if (str.equals("join")) {
                    b = 5;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    b = 6;
                }
                break;
            case 90259659:
                if (str.equals("includes")) {
                    b = 7;
                }
                break;
            case 94642797:
                if (str.equals("chunk")) {
                    b = 8;
                }
                break;
            case 96955127:
                if (str.equals("exist")) {
                    b = 9;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = 10;
                }
                break;
            case 515198113:
                if (str.equals("decodeUrl")) {
                    b = 11;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 12;
                }
                break;
            case 1508134777:
                if (str.equals("encodeUrl")) {
                    b = 13;
                }
                break;
            case 2056988195:
                if (str.equals("isDigit")) {
                    b = com.google.common.base.a.p;
                }
                break;
        }
        switch (b) {
            case 0:
                return new z();
            case 1:
                return new m();
            case 2:
                return new sp();
            case 3:
                return new t();
            case 4:
                return new a();
            case 5:
                return new da();
            case 6:
                return new u();
            case 7:
                return new x();
            case 8:
                return new c();
            case 9:
                return new n();
            case 10:
                return new yp();
            case 11:
                return new tt();
            case 12:
                return new nu();
            case 13:
                return new uj();
            case 14:
                return new i();
            default:
                return null;
        }
    }
}
