package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n39 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final LottieAnimationView f43436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LottieDrawable f18342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f18343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18344a;

    @VisibleForTesting
    public n39() {
        this.f18343a = new HashMap();
        this.f18344a = true;
        this.f43436a = null;
        this.f18342a = null;
    }

    public String a(String str) {
        return str;
    }

    public String b(String str, String str2) {
        return a(str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String c(String str, String str2) {
        if (this.f18344a && this.f18343a.containsKey(str2)) {
            return this.f18343a.get(str2);
        }
        String strB = b(str, str2);
        if (this.f18344a) {
            this.f18343a.put(str2, strB);
        }
        return strB;
    }

    public final void d() {
        LottieAnimationView lottieAnimationView = this.f43436a;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.f18342a;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public void e() {
        this.f18343a.clear();
        d();
    }

    public void f(String str) {
        this.f18343a.remove(str);
        d();
    }

    public void g(boolean z) {
        this.f18344a = z;
    }

    public void h(String str, String str2) {
        this.f18343a.put(str, str2);
        d();
    }

    public n39(LottieAnimationView lottieAnimationView) {
        this.f18343a = new HashMap();
        this.f18344a = true;
        this.f43436a = lottieAnimationView;
        this.f18342a = null;
    }

    public n39(LottieDrawable lottieDrawable) {
        this.f18343a = new HashMap();
        this.f18344a = true;
        this.f18342a = lottieDrawable;
        this.f43436a = null;
    }
}
