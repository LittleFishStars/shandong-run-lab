package com.alibaba.ariver.mtop.monitor;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVCountDispatcher extends Proxiable {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f24350a = 1;
        public static final int b = 2;
        public static final int c = 3;
        protected int d;

        public int a() {
            return this.d;
        }
    }

    public interface b {
        void onEvent(a aVar);
    }

    public static class c extends a {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public int h;
        public long i;

        public c() {
            this.d = 2;
        }
    }

    public static class d extends a {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public int h;
        public long i;

        public d() {
            this.d = 1;
        }
    }

    public static class e extends a {
        public static final int e = 1;
        public static final int f = 2;
        public int g;

        public e() {
            this.d = 3;
        }
    }

    void addListener(int i, b bVar);

    void dispatch(a aVar);

    void removeListener(int i, b bVar);
}
