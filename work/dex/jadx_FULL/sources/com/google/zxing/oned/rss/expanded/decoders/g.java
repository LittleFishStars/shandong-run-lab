package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class g extends DecodedObject {
    public static final char b = '$';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f32526a;

    public g(int i, char c) {
        super(i);
        this.f32526a = c;
    }

    public char b() {
        return this.f32526a;
    }

    public boolean c() {
        return this.f32526a == '$';
    }
}
