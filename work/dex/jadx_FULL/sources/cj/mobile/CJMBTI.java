package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJMBTI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21642a;
    public String b;
    public String c;
    public String d;
    public int e;

    public CJMBTI setInterstitialId(String str) {
        this.c = str;
        return this;
    }

    public CJMBTI setNativeExpressId(String str) {
        this.d = str;
        return this;
    }

    public CJMBTI setRewardId(String str) {
        this.b = str;
        return this;
    }

    public CJMBTI setRewardInterval(int i) {
        this.e = i;
        return this;
    }

    public CJMBTI setUserId(String str) {
        this.f21642a = str;
        return this;
    }

    public void show(Activity activity, CJRewardListener cJRewardListener) {
    }
}
