package com.fl.saas.common.saas.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PreAdPlace {
    private AdPlace mAdPlace;
    private int position;

    public PreAdPlace(int i, AdPlace adPlace) {
        this.position = i;
        this.mAdPlace = adPlace;
    }

    public static PreAdPlace create(int i, AdPlace adPlace) {
        return new PreAdPlace(i, adPlace);
    }

    public AdPlace getAdPlace() {
        return this.mAdPlace;
    }

    public int getPosition() {
        return this.position;
    }

    public void setAdPlace(AdPlace adPlace) {
        this.mAdPlace = adPlace;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
