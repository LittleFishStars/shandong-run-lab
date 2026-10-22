package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vl extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27873a;

    public vl(String str) {
        this.f27873a = str;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return "Render structs has conflict or unexpected error, " + this.f27873a;
    }
}
