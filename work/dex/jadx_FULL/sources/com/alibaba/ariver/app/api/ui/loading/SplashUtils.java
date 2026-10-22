package com.alibaba.ariver.app.api.ui.loading;

import android.os.Bundle;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SplashUtils {
    public static boolean useSuperSplash(Bundle bundle) {
        return "YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVStartParams.KEY_SUPER_SPLASH));
    }
}
