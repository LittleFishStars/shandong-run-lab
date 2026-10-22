package com.ipd.dsp.internal.e0;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f38291a = false;

    public static class b extends c {
        public volatile RuntimeException b;

        public b() {
            super();
        }

        @Override // com.ipd.dsp.internal.e0.c
        public void a(boolean z) {
            if (z) {
                this.b = new RuntimeException("Released");
            } else {
                this.b = null;
            }
        }

        @Override // com.ipd.dsp.internal.e0.c
        public void b() {
            if (this.b != null) {
                throw new IllegalStateException("Already released", this.b);
            }
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.e0.c$c, reason: collision with other inner class name */
    public static class C0878c extends c {
        public volatile boolean b;

        public C0878c() {
            super();
        }

        @Override // com.ipd.dsp.internal.e0.c
        public void a(boolean z) {
            this.b = z;
        }

        @Override // com.ipd.dsp.internal.e0.c
        public void b() {
            if (this.b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static c a() {
        return new C0878c();
    }

    public abstract void a(boolean z);

    public abstract void b();

    public c() {
    }
}
