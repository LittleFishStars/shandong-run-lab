package com.huachenjie.common.constants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public enum PetAnimationType {
    IDLE("idle"),
    WALK("walk"),
    WANT_FISH("want_fish"),
    WANT_WATER("want_water"),
    WANT_MEAT("want_meat"),
    WANT_SNACKS("want_snacks"),
    HAPPY("happy"),
    EATING("eating"),
    DRINKING("drinking"),
    SLEEP("sleep");

    public String value;

    PetAnimationType(String value) {
        this.value = value;
    }
}
