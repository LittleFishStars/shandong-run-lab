package cj.mobile.wm.common.enums;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum EnumPatchType {
    NORMAL(dexc.dexa("opsnbm")),
    VIDEO(dexc.dexa("wjefp"));

    public String str;

    EnumPatchType(String str) {
        this.str = str;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    public static EnumPatchType getTypeEnum(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1039745817) {
            if (iHashCode == 112202875 && str.equals(dexc.dexa("wjefp"))) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals(dexc.dexa("opsnbm"))) {
            b = 1;
        } else {
            b = -1;
        }
        return b != 2 ? NORMAL : VIDEO;
    }
}
