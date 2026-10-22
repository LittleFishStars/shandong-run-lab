package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJHistoryDay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21586a;
    public String b;
    public String c;

    public CJHistoryDay setInterstitialId(String str) {
        this.f21586a = str;
        return this;
    }

    public CJHistoryDay setRewardId(String str) {
        this.b = str;
        return this;
    }

    public CJHistoryDay setUserId(String str) {
        this.c = str;
        return this;
    }

    public void show(Activity activity, CJRewardListener cJRewardListener) {
    }
}
