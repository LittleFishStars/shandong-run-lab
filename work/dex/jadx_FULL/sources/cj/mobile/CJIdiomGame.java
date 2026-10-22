package cj.mobile;

import android.app.Activity;
import cj.mobile.listener.CJRewardListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJIdiomGame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21606a;
    public String b;

    public CJIdiomGame setInterstitialId(String str) {
        this.b = str;
        return this;
    }

    public CJIdiomGame setRewardId(String str) {
        this.f21606a = str;
        return this;
    }

    public void showGame(Activity activity, CJRewardListener cJRewardListener) {
    }
}
