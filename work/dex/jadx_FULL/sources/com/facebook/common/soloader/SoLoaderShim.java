package com.facebook.common.soloader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SoLoaderShim {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f29955a = new b();

    public interface Handler {
        void loadLibrary(String str);
    }

    public static class a implements Handler {
        @Override // com.facebook.common.soloader.SoLoaderShim.Handler
        public void loadLibrary(String str) {
        }
    }

    public static class b implements Handler {
        @Override // com.facebook.common.soloader.SoLoaderShim.Handler
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void a(String str) {
        f29955a.loadLibrary(str);
    }

    public static void b(Handler handler) {
        if (handler == null) {
            throw new NullPointerException("Handler cannot be null");
        }
        f29955a = handler;
    }

    public static void c() {
        b(new a());
    }
}
