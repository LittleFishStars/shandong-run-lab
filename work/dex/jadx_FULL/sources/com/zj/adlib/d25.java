package com.zj.adlib;

import android.util.Log;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d25 implements LottieLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f41093a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void b(String str, Throwable th) {
        Set<String> set = f41093a;
        if (set.contains(str)) {
            return;
        }
        Log.w(vs4.f20320a, str, th);
        set.add(str);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str) {
        debug(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String str, Throwable th) {
        if (vs4.f20321a) {
            Log.d(vs4.f20320a, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str, Throwable th) {
        if (vs4.f20321a) {
            Log.d(vs4.f20320a, str, th);
        }
    }
}
