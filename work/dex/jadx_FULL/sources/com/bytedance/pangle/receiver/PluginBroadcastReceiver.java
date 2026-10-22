package com.bytedance.pangle.receiver;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public abstract class PluginBroadcastReceiver {
    public abstract void onReceive(Context context, Intent intent);
}
