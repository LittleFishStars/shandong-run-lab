package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements com.alibaba.ariver.commonability.device.jsapi.system.field.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23990a = "CommonAbility#DeviceFieldGroup";
    private static final String b = "currentBattery";
    private Integer c;
    private final BroadcastReceiver d = new BroadcastReceiver() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.field.group.BatteryFieldGroup$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(com.alibaba.ariver.permission.b.b, 0);
                int intExtra2 = intent.getIntExtra("scale", 100);
                this.f23988a.c = Integer.valueOf((intExtra * 100) / intExtra2);
            }
        }
    };

    private int c(Context context) {
        Integer num = this.c;
        if (num != null) {
            return num.intValue();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(this.d, intentFilter);
            if ("android.intent.action.BATTERY_CHANGED".equals(intentRegisterReceiver.getAction())) {
                Integer numValueOf = Integer.valueOf((intentRegisterReceiver.getIntExtra(com.alibaba.ariver.permission.b.b, 0) * 100) / intentRegisterReceiver.getIntExtra("scale", 100));
                this.c = numValueOf;
                return numValueOf.intValue();
            }
        } catch (Exception e) {
            RVLogger.e("getCurrentBatteryPercentage...e=" + e);
        }
        return this.c.intValue();
    }

    private void d(final Context context) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.field.group.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (b.this.c != null) {
                        context.getApplicationContext().unregisterReceiver(b.this.d);
                        b.this.c = null;
                    }
                } catch (Throwable th) {
                    RVLogger.e(b.f23990a, "unregisterBroadcastReceiver...e=" + th);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context) {
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void b(Context context) {
        d(context);
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(b);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context, App app, Map<String, Object> map) {
        map.put(b, c(context) + "%");
    }
}
