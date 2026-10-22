package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJHoroscope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21587a;
    public String b;
    public String c;

    public CJHoroscope setBannerId(String str) {
        this.c = str;
        return this;
    }

    public CJHoroscope setInterstitialId(String str) {
        this.b = str;
        return this;
    }

    public CJHoroscope setUserId(String str) {
        this.f21587a = str;
        return this;
    }

    public void show(Activity activity, String str, CJRewardListener cJRewardListener) {
    }
}
