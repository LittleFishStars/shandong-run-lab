package cn.jy.ad.sdk;

import android.content.Context;
import cn.jy.ad.sdk.jyinter.AdManager;
import cn.jy.ad.sdk.jyinter.JyAdNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements AdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdManager f22761a = new d();

    public static AdManager a() {
        return f22761a;
    }

    @Override // cn.jy.ad.sdk.jyinter.AdManager
    public JyAdNative createAdNative(Context context) {
        return g.a().a(context);
    }

    @Override // cn.jy.ad.sdk.jyinter.AdManager
    public int getSdkVersion() {
        return 21061;
    }
}
