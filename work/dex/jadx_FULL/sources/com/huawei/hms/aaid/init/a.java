package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37410a;

    public a(Context context) {
        this.f37410a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int internalCode = ErrorEnum.SUCCESS.getInternalCode();
            String token = null;
            try {
                token = HmsInstanceId.getInstance(this.f37410a).getToken(Util.getAppId(this.f37410a), null);
                HMSLog.i("AutoInit", "Push init succeed");
                if (TextUtils.isEmpty(token)) {
                    return;
                }
            } catch (ApiException e) {
                internalCode = e.getStatusCode();
                HMSLog.e("AutoInit", "new Push init failed");
            }
            try {
                Bundle bundle = this.f37410a.getPackageManager().getApplicationInfo(this.f37410a.getPackageName(), 128).metaData;
                if (bundle == null || bundle.getString("com.huawei.hms.client.service.name:push") == null) {
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                } else {
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f37410a.getPackageName());
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(RemoteMessageConst.MSGTYPE, "new_token");
                    bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, token);
                    bundle2.putInt("error", internalCode);
                    if (!new k().a(this.f37410a, bundle2, intent)) {
                        HMSLog.e("AutoInit", "start service failed");
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.i("AutoInit", "push kit sdk not exists");
            }
        } catch (Exception e2) {
            HMSLog.e("AutoInit", "Push init failed", e2);
        }
    }
}
