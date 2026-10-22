package com.huawei.hms.common.api;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AvailabilityException extends Exception {
    private static final String TAG = "AvailabilityException";
    private String message = null;

    private ConnectionResult generateConnectionResult(int i) {
        HMSLog.i(TAG, "The availability check result is: " + i);
        setMessage(i);
        return new ConnectionResult(i);
    }

    private void setMessage(int i) {
        if (i == 21) {
            this.message = "ANDROID_VERSION_UNSUPPORT";
            return;
        }
        if (i == 0) {
            this.message = "success";
            return;
        }
        if (i == 1) {
            this.message = "SERVICE_MISSING";
            return;
        }
        if (i == 2) {
            this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
        } else if (i != 3) {
            this.message = "INTERNAL_ERROR";
        } else {
            this.message = "SERVICE_DISABLED";
        }
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable huaweiApiCallable) {
        if (huaweiApiCallable == null || huaweiApiCallable.getHuaweiApi() == null) {
            HMSLog.e(TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApiCallable.getHuaweiApi().getContext(), 30000000));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> huaweiApi) {
        if (huaweiApi == null) {
            HMSLog.e(TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApi.getContext(), 30000000));
    }
}
