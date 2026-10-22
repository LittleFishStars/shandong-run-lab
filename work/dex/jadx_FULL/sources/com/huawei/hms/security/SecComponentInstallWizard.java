package com.huawei.hms.security;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.api.HuaweiServicesNotAvailableException;
import com.huawei.hms.api.HuaweiServicesRepairableException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SecComponentInstallWizard {
    public static final String PROVIDER_NAME = "HmsCore_OpenSSL";

    public interface SecComponentInstallWizardListener {
        void onFailed(int i, Intent intent);

        void onSuccess();
    }

    public static void install(Context context) throws HuaweiServicesRepairableException, HuaweiServicesNotAvailableException {
    }
}
