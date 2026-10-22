package cj.mobile.wm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class e9 {
    public static final char[] dexa = "0123456789abcdef".toCharArray();
    public static final char[] dexb = new char[64];
    public static final char[] dexc = new char[40];

    public static /* synthetic */ class dexa {
        public static final /* synthetic */ int[] dexa;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            dexa = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                dexa[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                dexa[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                dexa[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int dexa(int i, int i2, Bitmap.Config config) {
        return i * i2 * dexa(config);
    }

    public static int dexa(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = dexa.dexa[config.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 2 : 4;
        }
        return 1;
    }

    @TargetApi(19)
    public static int dexa(Bitmap bitmap) {
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    public static String dexa(byte[] bArr) {
        String strDexa;
        char[] cArr = dexb;
        synchronized (cArr) {
            strDexa = dexa(bArr, cArr);
        }
        return strDexa;
    }

    public static String dexa(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = dexa;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static <T> List<T> dexa(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> Queue<T> dexa(int i) {
        return new ArrayDeque(i);
    }

    public static void dexa() {
        if (!dexc()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean dexa(int i, int i2) {
        return dexb(i) && dexb(i2);
    }

    public static boolean dexb() {
        return !dexc();
    }

    public static boolean dexb(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean dexc() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
