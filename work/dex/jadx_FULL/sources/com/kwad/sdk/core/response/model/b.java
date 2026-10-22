package com.kwad.sdk.core.response.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private boolean aXL;
    private boolean anr = true;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public b(String str, int i, int i2, boolean z, boolean z2) {
        this.mUrl = str;
        this.mWidth = i;
        this.mHeight = i2;
        this.aXL = z2;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
