package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements Comparator<PackageBean.AppBean.PackBean> {
    public e(d dVar) {
    }

    @Override // java.util.Comparator
    public int compare(PackageBean.AppBean.PackBean packBean, PackageBean.AppBean.PackBean packBean2) {
        PackageBean.AppBean.PackBean packBean3 = packBean;
        PackageBean.AppBean.PackBean packBean4 = packBean2;
        if (packBean3.getExpirationTime() == packBean4.getExpirationTime()) {
            return 0;
        }
        return packBean3.getExpirationTime() > packBean4.getExpirationTime() ? 1 : -1;
    }
}
