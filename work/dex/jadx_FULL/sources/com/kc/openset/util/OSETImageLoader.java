package com.kc.openset.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.BaseImageLoaderBridge;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile OSETImageLoader f39952a;
    private final Context b;
    private a c;
    private BaseImageLoaderBridge d;

    @Keep
    public interface BitmapCallback {
        void onBitmapLoaded(Bitmap bitmap);
    }

    @Keep
    public interface DrawableCallback {
        void onDrawableLoaded(Drawable drawable);
    }

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LruCache<String, Bitmap> f39953a;
        private com.kc.openset.d.a b;
        private ExecutorService c;
        private Handler d;

        /* JADX INFO: renamed from: com.kc.openset.util.OSETImageLoader$a$a, reason: collision with other inner class name */
        @Keep
        public class C1123a extends LruCache<String, Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f39954a;

            static {
                OSETSDKProtected.interface11(4966);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1123a(a aVar, int i) {
                super(i);
                this.f39954a = aVar;
            }

            public native int a(String str, Bitmap bitmap);

            @Override // android.util.LruCache
            public native /* bridge */ /* synthetic */ int sizeOf(String str, Bitmap bitmap);
        }

        @Keep
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f39955a;
            final ImageView b;
            final String c;
            final int d;
            final a e;

            /* JADX INFO: renamed from: com.kc.openset.util.OSETImageLoader$a$b$a, reason: collision with other inner class name */
            @Keep
            public class RunnableC1124a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final Bitmap f39956a;
                final b b;

                static {
                    OSETSDKProtected.interface11(4967);
                }

                public RunnableC1124a(b bVar, Bitmap bitmap) {
                    this.b = bVar;
                    this.f39956a = bitmap;
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                OSETSDKProtected.interface11(4968);
            }

            public b(a aVar, String str, ImageView imageView, String str2, int i) {
                this.e = aVar;
                this.f39955a = str;
                this.b = imageView;
                this.c = str2;
                this.d = i;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        @Keep
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f39957a;
            final DrawableCallback b;
            final String c;
            final int d;
            final a e;

            /* JADX INFO: renamed from: com.kc.openset.util.OSETImageLoader$a$c$a, reason: collision with other inner class name */
            @Keep
            public class RunnableC1125a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final Drawable f39958a;
                final c b;

                static {
                    OSETSDKProtected.interface11(4969);
                }

                public RunnableC1125a(c cVar, Drawable drawable) {
                    this.b = cVar;
                    this.f39958a = drawable;
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            @Keep
            public class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final c f39959a;

                static {
                    OSETSDKProtected.interface11(4970);
                }

                public b(c cVar) {
                    this.f39959a = cVar;
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                OSETSDKProtected.interface11(4971);
            }

            public c(a aVar, String str, DrawableCallback drawableCallback, String str2, int i) {
                this.e = aVar;
                this.f39957a = str;
                this.b = drawableCallback;
                this.c = str2;
                this.d = i;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        @Keep
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f39960a;
            final BitmapCallback b;
            final String c;
            final int d;
            final a e;

            /* JADX INFO: renamed from: com.kc.openset.util.OSETImageLoader$a$d$a, reason: collision with other inner class name */
            @Keep
            public class RunnableC1126a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final Bitmap f39961a;
                final d b;

                static {
                    OSETSDKProtected.interface11(4972);
                }

                public RunnableC1126a(d dVar, Bitmap bitmap) {
                    this.b = dVar;
                    this.f39961a = bitmap;
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            @Keep
            public class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f39962a;

                static {
                    OSETSDKProtected.interface11(4973);
                }

                public b(d dVar) {
                    this.f39962a = dVar;
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                OSETSDKProtected.interface11(4974);
            }

            public d(a aVar, String str, BitmapCallback bitmapCallback, String str2, int i) {
                this.e = aVar;
                this.f39960a = str;
                this.b = bitmapCallback;
                this.c = str2;
                this.d = i;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            OSETSDKProtected.interface11(4975);
        }

        private native Bitmap a(Bitmap bitmap, int i);

        public static native /* synthetic */ Bitmap a(a aVar, Bitmap bitmap, int i);

        public static native /* synthetic */ Bitmap a(a aVar, String str);

        private native Bitmap a(String str);

        public static native /* synthetic */ LruCache a(a aVar);

        public static native /* synthetic */ void a(a aVar, String str, Bitmap bitmap);

        public static native /* synthetic */ void a(a aVar, String str, ImageView imageView, int i);

        private native void a(String str, Bitmap bitmap);

        private native void a(String str, ImageView imageView, int i);

        public static native /* synthetic */ Bitmap b(a aVar, String str);

        private native Bitmap b(String str);

        public static native /* synthetic */ Handler b(a aVar);

        private native String c(String str);

        public native void a(Context context);

        public native void a(String str, int i, BitmapCallback bitmapCallback);

        public native void a(String str, int i, DrawableCallback drawableCallback);
    }

    static {
        OSETSDKProtected.interface11(4976);
    }

    private OSETImageLoader(Context context) {
        this.b = context;
        a();
        b();
    }

    private native BaseImageLoaderBridge a(String str);

    public static native OSETImageLoader a(Context context);

    private native void a();

    private native void b();

    private native boolean c();

    public native void a(Context context, String str, int i, BitmapCallback bitmapCallback);

    public native void a(Context context, String str, int i, DrawableCallback drawableCallback);

    public native void a(Context context, String str, ImageView imageView);

    public native void a(Context context, String str, ImageView imageView, int i);
}
