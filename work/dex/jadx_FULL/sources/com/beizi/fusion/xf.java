package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class xf {
    public static xc a(Context context, String str, boolean z) {
        str.getClass();
        switch (str) {
            case "invoke":
                return new bg(context);
            case "sensor":
                if (z) {
                    return new r8(context);
                }
                return null;
            case "clickslide":
                return new m8(context, true);
            case "opt":
                return new vk(context);
            case "opts":
                return new bo(context);
            case "optt":
                return new bp(context);
            case "click":
                return new ao(context);
            case "mixed":
                if (z) {
                    return new yh(context);
                }
                return null;
            case "shake":
                if (z) {
                    return new c1(context);
                }
                return null;
            case "slide":
                return new m8(context, false);
            default:
                return null;
        }
    }
}
