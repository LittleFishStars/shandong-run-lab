package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class f1 {
    public static dc a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "complain":
                return new e1();
            case "conditionclose":
                return new l1();
            case "close":
                return new d1();
            case "voiceswitch":
                return new k1();
            case "downloadInfo":
                return new h1();
            default:
                if (i == 0) {
                    return new g1();
                }
                if (i == 1) {
                    return new i1();
                }
                if (i == 2) {
                    return new j1();
                }
                return null;
        }
    }
}
