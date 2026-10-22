package com.kc.cw.ad.c.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b bVar;
        if (context == null || intent == null) {
            return;
        }
        boolean zContains = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        if (intExtra == 1) {
            zContains = TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName());
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
            d dVarA = d.a();
            if (DeviceIdType.OAID.equals(stringExtra)) {
                bVar = dVarA.b;
            } else if ("vaid".equals(stringExtra)) {
                bVar = dVarA.c;
            } else if ("aaid".equals(stringExtra)) {
                bVar = dVarA.d;
            } else {
                bVar = "udid".equals(stringExtra) ? dVarA.f38741a : null;
            }
            if (bVar == null) {
                return;
            }
            bVar.b();
        }
    }
}
