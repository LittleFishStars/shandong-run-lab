package com.aliyun.player.source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum Definition {
    DEFINITION_FD("FD"),
    DEFINITION_LD("LD"),
    DEFINITION_SD("SD"),
    DEFINITION_HD("HD"),
    DEFINITION_OD("OD"),
    DEFINITION_2K("2K"),
    DEFINITION_4K("4K"),
    DEFINITION_SQ("SQ"),
    DEFINITION_HQ("HQ"),
    DEFINITION_AUTO("AUTO");

    private String mName;

    Definition(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }
}
