package com.ipd.dsp.internal.b0;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements g<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38196a;
    public final boolean b;
    public d c;

    public static class a {
        public static final int c = 300;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38197a;
        public boolean b;

        public a() {
            this(300);
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public a(int i) {
            this.f38197a = i;
        }

        public c a() {
            return new c(this.f38197a, this.b);
        }
    }

    public c(int i, boolean z) {
        this.f38196a = i;
        this.b = z;
    }

    @Override // com.ipd.dsp.internal.b0.g
    public f<Drawable> a(com.ipd.dsp.internal.f.a aVar, boolean z) {
        return aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE ? e.a() : a();
    }

    public final f<Drawable> a() {
        if (this.c == null) {
            this.c = new d(this.f38196a, this.b);
        }
        return this.c;
    }
}
