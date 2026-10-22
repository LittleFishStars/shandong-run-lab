package com.alibaba.ariver.app.api.service.font;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FontSizeSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23823a;
    private float b;

    public FontSizeSetting(int i, float f) {
        this.f23823a = i;
        this.b = f;
    }

    public int getLevel() {
        return this.f23823a;
    }

    public float getScale() {
        return this.b;
    }

    public String toString() {
        return String.format("fontSize\t fontScale=%d,level=%d", Float.valueOf(this.b), Integer.valueOf(this.f23823a));
    }
}
