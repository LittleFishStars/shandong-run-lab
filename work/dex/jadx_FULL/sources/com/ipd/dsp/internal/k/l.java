package com.ipd.dsp.internal.k;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import androidx.annotation.VisibleForTesting;
import com.byazt.hv.TTDownloadField;
import com.ipd.dsp.Dsp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class l {
    public static final String e = "MemorySizeCalculator";

    @VisibleForTesting
    public static final int f = 4;
    public static final int g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38380a;
    public final int b;
    public final Context c;
    public final int d;

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f38382a;

        public b(DisplayMetrics displayMetrics) {
            this.f38382a = displayMetrics;
        }

        @Override // com.ipd.dsp.internal.k.l.c
        public int a() {
            return this.f38382a.heightPixels;
        }

        @Override // com.ipd.dsp.internal.k.l.c
        public int b() {
            return this.f38382a.widthPixels;
        }
    }

    public interface c {
        int a();

        int b();
    }

    public l(a aVar) {
        this.c = aVar.f38381a;
        int i = a(aVar.b) ? aVar.h / 2 : aVar.h;
        this.d = i;
        int iA = a(aVar.b, aVar.f, aVar.g);
        float fB = aVar.c.b() * aVar.c.a() * 4;
        int iRound = Math.round(aVar.e * fB);
        int iRound2 = Math.round(fB * aVar.d);
        int i2 = iA - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.b = iRound2;
            this.f38380a = iRound;
        } else {
            float f2 = i2;
            float f3 = aVar.e;
            float f4 = aVar.d;
            float f5 = f2 / (f3 + f4);
            this.b = Math.round(f4 * f5);
            this.f38380a = Math.round(f5 * aVar.e);
        }
        if (Dsp.isDebugLogEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.b));
            sb.append(", pool size: ");
            sb.append(a(this.f38380a));
            sb.append(", byte array size: ");
            sb.append(a(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > iA);
            sb.append(", max size: ");
            sb.append(a(iA));
            sb.append(", memoryClass: ");
            sb.append(aVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.b));
            com.ipd.dsp.internal.c2.k.a(e, sb.toString());
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.f38380a;
    }

    public int c() {
        return this.b;
    }

    public static final class a {

        @VisibleForTesting
        public static final float i = 1.5f;
        public static final int j = 1;
        public static final float k = 0.4f;
        public static final float l = 0.33f;
        public static final int m = 4194304;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38381a;
        public ActivityManager b;
        public c c;
        public float e;
        public float d = 1.5f;
        public float f = 0.4f;
        public float g = 0.33f;
        public int h = 4194304;

        public a(Context context) {
            this.e = j;
            this.f38381a = context;
            this.b = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            this.c = new b(context.getResources().getDisplayMetrics());
            if (l.a(this.b)) {
                this.e = 0.0f;
            }
        }

        public a a(float f) {
            com.ipd.dsp.internal.d0.m.a(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.e = f;
            return this;
        }

        public a b(float f) {
            com.ipd.dsp.internal.d0.m.a(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.g = f;
            return this;
        }

        public a c(float f) {
            com.ipd.dsp.internal.d0.m.a(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f = f;
            return this;
        }

        public a d(float f) {
            com.ipd.dsp.internal.d0.m.a(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.d = f;
            return this;
        }

        public a a(int i2) {
            this.h = i2;
            return this;
        }

        @VisibleForTesting
        public a a(ActivityManager activityManager) {
            this.b = activityManager;
            return this;
        }

        @VisibleForTesting
        public a a(c cVar) {
            this.c = cVar;
            return this;
        }

        public l a() {
            return new l(this);
        }
    }

    public static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    public final String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    public static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
