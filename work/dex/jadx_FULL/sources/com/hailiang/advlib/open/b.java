package com.hailiang.advlib.open;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface b {
    void acquireOAID(Context context);

    void asyncAcquireOAID(Context context);

    String getOaid();

    void setIsCanUseOaid(Context context, boolean z);

    void setOaid(String str);
}
