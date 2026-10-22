package com.fl.saas.adx.base.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.C1441w;
import com.fl.saas.F;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        String str;
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("downLoadUrl");
            LogcatUtil.d("DownloadActionReceiver", action);
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (C1441w.g.equals(action)) {
                intent2 = new Intent();
                str = F.s;
            } else if (C1441w.h.equals(action)) {
                intent2 = new Intent();
                str = F.t;
            } else {
                if (!C1441w.i.equals(action)) {
                    return;
                }
                intent2 = new Intent();
                str = F.u;
            }
            intent2.setAction(str);
            intent2.putExtra("downLoadUrl", stringExtra);
            context.sendBroadcast(intent2);
        }
    }
}
