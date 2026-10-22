package com.ipd.dsp.internal.d0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38281a = 31;
    public static final int b = 17;
    public static final char[] c = "0123456789abcdef".toCharArray();
    public static final char[] d = new char[64];

    @Nullable
    public static volatile Handler e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38282a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f38282a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38282a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38282a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38282a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38282a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(int i, int i2) {
        return (i2 * 31) + i;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        String strA;
        char[] cArr = d;
        synchronized (cArr) {
            strA = a(bArr, cArr);
        }
        return strA;
    }

    @Deprecated
    public static int b(@NonNull Bitmap bitmap) {
        return a(bitmap);
    }

    public static Handler c() {
        if (e == null) {
            synchronized (o.class) {
                if (e == null) {
                    e = new Handler(Looper.getMainLooper());
                }
            }
        }
        return e;
    }

    public static boolean c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean d() {
        return !e();
    }

    public static boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(int i, int i2) {
        return c(i) && c(i2);
    }

    public static void b(Runnable runnable) {
        c().removeCallbacks(runnable);
    }

    @NonNull
    public static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = c;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & com.google.common.base.a.q];
        }
        return new String(cArr);
    }

    public static void b() {
        if (!e()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(int i) {
        return a(i, 17);
    }

    @TargetApi(19)
    public static int a(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int a(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * a(config);
    }

    public static int a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.f38282a[config.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                return i != 4 ? 4 : 8;
            }
        }
        return i2;
    }

    public static void a(Runnable runnable) {
        c().post(runnable);
    }

    public static void a() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    @NonNull
    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    @NonNull
    public static <T> List<T> a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof com.ipd.dsp.internal.n.m) {
            return ((com.ipd.dsp.internal.n.m) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean a(@Nullable com.ipd.dsp.internal.z.a<?> aVar, @Nullable com.ipd.dsp.internal.z.a<?> aVar2) {
        if (aVar == null) {
            return aVar2 == null;
        }
        return aVar.b(aVar2);
    }

    public static int a(float f) {
        return a(f, 17);
    }

    public static int a(float f, int i) {
        return a(Float.floatToIntBits(f), i);
    }

    public static int a(@Nullable Object obj, int i) {
        return a(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int a(boolean z, int i) {
        return a(z ? 1 : 0, i);
    }

    public static int a(boolean z) {
        return a(z, 17);
    }
}
