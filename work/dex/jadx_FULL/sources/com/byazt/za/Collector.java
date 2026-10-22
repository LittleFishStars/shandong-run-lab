package com.byazt.za;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.byazt.lu.uj;
import com.byazt.yv.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 76, 1534})
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            da.tt((Throwable) null);
        } else {
            uj.c(stringArrayExtra);
        }
    }
}
