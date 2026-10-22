package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IntentUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ResolutionDelegate implements IBridgeActivityDelegate {
    public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
    private static final int REQUEST_CODE = 1002;
    private static final String TAG = "ResolutionDelegate";
    private WeakReference<Activity> mThisWeakRef;

    private void finishBridgeActivity() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private BusResponseCallback getResponseCallback(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1002;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Bundle extras;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e(TAG, "activity is null or finishing");
            return;
        }
        this.mThisWeakRef = new WeakReference<>(activity);
        try {
            extras = activity.getIntent().getExtras();
        } catch (Exception e) {
            HMSLog.e(TAG, "getExtras exception:" + e.getMessage());
            extras = null;
        }
        if (extras != null) {
            activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) extras.getParcelable(CommonCode.MapKey.HAS_RESOLUTION)), 1002);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        this.mThisWeakRef = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        BusResponseCallback responseCallback = getResponseCallback(CALLBACK_METHOD);
        int iIsHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mThisWeakRef.get(), 30000000);
        if (i2 == -1 && iIsHuaweiMobileServicesAvailable == 0) {
            HMSLog.i(TAG, "Make service available success.");
        } else {
            responseCallback.innerError(this.mThisWeakRef.get(), i2, "Make service available failed.");
        }
        finishBridgeActivity();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
    }
}
