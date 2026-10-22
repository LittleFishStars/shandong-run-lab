package com.kc.bw.common.enums;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public enum EnumPatchType {
    NORMAL(dexg.dexa("opsnbm")),
    VIDEO(dexg.dexa("wjefp"));

    public String str;

    EnumPatchType(String str) {
        this.str = str;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    public static EnumPatchType getTypeEnum(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1039745817) {
            if (iHashCode == 112202875 && str.equals(dexg.dexa("wjefp"))) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals(dexg.dexa("opsnbm"))) {
            b = 1;
        } else {
            b = -1;
        }
        return b != 2 ? NORMAL : VIDEO;
    }
}
