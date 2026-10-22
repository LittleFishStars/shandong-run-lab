package com.alipay.sdk.m.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class e extends BroadcastReceiver {
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        a aVar;
        if (context == null || intent == null) {
            return;
        }
        boolean zContains = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        f.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                zContains = true;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                zContains = stringArrayListExtra.contains(context.getPackageName());
            }
        } else if (intExtra == 0) {
            zContains = true;
        }
        if (zContains) {
            String stringExtra = intent.getStringExtra("openIdType");
            f fVarA = f.a();
            if (DeviceIdType.OAID.equals(stringExtra)) {
                aVar = fVarA.b;
            } else if ("vaid".equals(stringExtra)) {
                aVar = fVarA.d;
            } else if ("aaid".equals(stringExtra)) {
                aVar = fVarA.c;
            } else {
                aVar = "udid".equals(stringExtra) ? fVarA.f25474a : null;
            }
            if (aVar == null) {
                return;
            }
            aVar.b();
        }
    }
}
