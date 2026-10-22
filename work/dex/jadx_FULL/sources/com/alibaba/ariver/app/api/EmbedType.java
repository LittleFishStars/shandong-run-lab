package com.alibaba.ariver.app.api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum EmbedType {
    NO(0),
    FULL(1),
    MINI(2);

    private int mType;

    EmbedType(int i) {
        this.mType = i;
    }

    public static EmbedType parse(int i) {
        if (i == 1) {
            return FULL;
        }
        return i == 2 ? MINI : NO;
    }

    public int getTypeValue() {
        return this.mType;
    }

    public boolean isEmbedPage() {
        return this.mType != NO.getTypeValue();
    }
}
