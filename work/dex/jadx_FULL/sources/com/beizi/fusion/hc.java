package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface hc {

    public static class a implements b {
        public static final a f = new a(0, 100, false, false);
        public static final a g = new a(0, 100, false, true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27363a;
        private int b;
        private final int c;
        private final boolean d;
        private int e;

        public a(int i, int i2, boolean z, boolean z2) {
            this.b = i;
            this.c = i2;
            this.d = z;
            this.f27363a = z2;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.f27363a;
        }

        public void e() {
            this.b = 0;
        }

        @Override // com.beizi.fusion.hc.b
        public void a(int i) {
            this.e = i;
        }
    }

    public interface b {
        void a(int i);
    }

    void a(a aVar);
}
