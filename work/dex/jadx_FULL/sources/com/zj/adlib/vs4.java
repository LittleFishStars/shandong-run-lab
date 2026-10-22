package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class vs4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45447a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static LottieNetworkCacheProvider f20316a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static LottieNetworkFetcher f20317a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile yx5 f20318a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile zx5 f20319a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20320a = "LOTTIE";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f20321a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long[] f20322a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String[] f20323a = null;
    public static int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f20324b = false;
    public static int c;

    public class a implements LottieNetworkCacheProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f45448a;

        public a(Context context) {
            this.f45448a = context;
        }

        @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
        @NonNull
        public File getCacheDir() {
            return new File(this.f45448a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (f20324b) {
            int i = b;
            if (i == 20) {
                c++;
                return;
            }
            f20323a[i] = str;
            f20322a[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            b++;
        }
    }

    public static float b(String str) {
        int i = c;
        if (i > 0) {
            c = i - 1;
            return 0.0f;
        }
        if (!f20324b) {
            return 0.0f;
        }
        int i2 = b - 1;
        b = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f20323a[i2])) {
            TraceCompat.endSection();
            return (System.nanoTime() - f20322a[b]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f20323a[b] + Consts.DOT);
    }

    @NonNull
    public static yx5 c(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        yx5 yx5Var = f20318a;
        if (yx5Var == null) {
            synchronized (yx5.class) {
                yx5Var = f20318a;
                if (yx5Var == null) {
                    LottieNetworkCacheProvider aVar = f20316a;
                    if (aVar == null) {
                        aVar = new a(applicationContext);
                    }
                    yx5Var = new yx5(aVar);
                    f20318a = yx5Var;
                }
            }
        }
        return yx5Var;
    }

    @NonNull
    public static zx5 d(@NonNull Context context) {
        zx5 zx5Var = f20319a;
        if (zx5Var == null) {
            synchronized (zx5.class) {
                zx5Var = f20319a;
                if (zx5Var == null) {
                    yx5 yx5VarC = c(context);
                    LottieNetworkFetcher wg2Var = f20317a;
                    if (wg2Var == null) {
                        wg2Var = new wg2();
                    }
                    zx5Var = new zx5(yx5VarC, wg2Var);
                    f20319a = zx5Var;
                }
            }
        }
        return zx5Var;
    }

    public static void e(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        f20316a = lottieNetworkCacheProvider;
    }

    public static void f(LottieNetworkFetcher lottieNetworkFetcher) {
        f20317a = lottieNetworkFetcher;
    }

    public static void g(boolean z) {
        if (f20324b == z) {
            return;
        }
        f20324b = z;
        if (z) {
            f20323a = new String[20];
            f20322a = new long[20];
        }
    }
}
