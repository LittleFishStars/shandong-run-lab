package com.efs.sdk.memleaksdk.monitor.shark;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f29650a;
    public static final ai b;
    public static final ai c;

    public static class a extends ai {
        private a() {
            super((byte) 0);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return (j / 1024.0f) / 1024.0f;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b extends ai {
        private b() {
            super((byte) 0);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j * 1024.0f;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return j / 1024.0f;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c extends ai {
        private c() {
            super((byte) 0);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j * 1024.0f * 1024.0f;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return j;
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    static {
        byte b2 = 0;
        f29650a = new a(b2);
        b = new b(b2);
        c = new c(b2);
    }

    public /* synthetic */ ai(byte b2) {
        this();
    }

    public float a(int i) {
        return a(i);
    }

    public float a(long j) {
        return 0.0f;
    }

    public float b(long j) {
        return 0.0f;
    }

    private ai() {
    }
}
