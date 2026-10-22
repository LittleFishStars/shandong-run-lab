package com.huachenjie.common.util.open;

import android.content.Context;
import com.huachenjie.common.callback.VoidCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public interface OpenThirdApp {
    void a(Context context, String url, VoidCallback cancelCallback, VoidCallback confirmCallback);

    void b(Context context, String userName, String path, VoidCallback cancelCallback, VoidCallback confirmCallback);
}
