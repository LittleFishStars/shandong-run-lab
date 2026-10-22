package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJOilPrice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21680a;
    public String b;
    public String c;

    public CJOilPrice setInterstitialId(String str) {
        this.f21680a = str;
        return this;
    }

    public CJOilPrice setRewardId(String str) {
        this.b = str;
        return this;
    }

    public CJOilPrice setUserId(String str) {
        this.c = str;
        return this;
    }

    public void show(Activity activity, CJRewardListener cJRewardListener) {
    }
}
