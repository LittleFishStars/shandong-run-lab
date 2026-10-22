package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJNewsPage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21679a;
    public String b;
    public String c;
    public int d;
    public int e;

    public CJNewsPage setDownTime(int i) {
        this.d = i;
        return this;
    }

    public CJNewsPage setInterstitialId(String str) {
        this.b = str;
        return this;
    }

    public CJNewsPage setNativeExpressId(String str) {
        this.c = str;
        return this;
    }

    public CJNewsPage setReadCount(int i) {
        this.e = i;
        return this;
    }

    public CJNewsPage setTitle(String str) {
        this.f21679a = str;
        return this;
    }

    public void showPage(Activity activity, CJRewardListener cJRewardListener) {
    }
}
