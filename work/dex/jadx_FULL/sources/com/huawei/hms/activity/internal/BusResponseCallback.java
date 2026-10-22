package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i, String str);

    BusResponseResult succeedReturn(Activity activity, int i, Intent intent);
}
