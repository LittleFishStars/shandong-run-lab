package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class h extends DecodedObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6772a;
    public final int b;

    public h(int i, String str) {
        super(i);
        this.f32527a = str;
        this.f6772a = false;
        this.b = 0;
    }

    public String b() {
        return this.f32527a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.f6772a;
    }

    public h(int i, String str, int i2) {
        super(i);
        this.f6772a = true;
        this.b = i2;
        this.f32527a = str;
    }
}
