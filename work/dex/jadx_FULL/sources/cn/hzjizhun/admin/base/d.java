package cn.hzjizhun.admin.base;

import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22698a;
    public static final String b;

    static {
        StringBuilder sb = new StringBuilder();
        String strD = RcSdk.d();
        if (TextUtils.isEmpty(strD)) {
            strD = "http://inner.shunchangzhixing.com";
        }
        sb.append(strD);
        sb.append("/init2");
        f22698a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        String strD2 = RcSdk.d();
        sb2.append(TextUtils.isEmpty(strD2) ? "http://inner.shunchangzhixing.com" : strD2);
        sb2.append("/ad2");
        b = sb2.toString();
    }
}
