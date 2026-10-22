package com.efs.sdk.base.core.controller.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends BroadcastReceiver implements Runnable {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        WorkThreadUtil.submit(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GlobalInfoManager.getInstance().refreshNetStatus();
    }
}
