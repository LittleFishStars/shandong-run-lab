package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJVideoEnhance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21781a;
    public String b;
    public int c;
    public int d;
    public int e;

    public CJVideoEnhance setRewardCount(int i) {
        this.c = i;
        return this;
    }

    public CJVideoEnhance setRewardCountNow(int i) {
        this.e = i;
        return this;
    }

    public CJVideoEnhance setRewardId(String str) {
        this.f21781a = str;
        return this;
    }

    public CJVideoEnhance setRewardTime(int i) {
        this.d = i;
        return this;
    }

    public CJVideoEnhance setVideoContentId(String str) {
        this.b = str;
        return this;
    }

    public void showPage(Activity activity, CJRewardListener cJRewardListener) {
    }
}
