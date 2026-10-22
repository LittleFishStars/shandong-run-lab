package com.byazt.ia;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.ariver.permission.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 515, 15})
public class uj {
    public int c;

    @com.byazt.zqa.c(c = {0, 1, 515, 123})
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    uj.this.c = (int) ((intent.getIntExtra(b.b, 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public uj(Context context) {
        try {
            c(context);
        } catch (Throwable unused) {
        }
    }

    private void c(Context context) {
        context.registerReceiver(new c(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int c() {
        return this.c;
    }
}
