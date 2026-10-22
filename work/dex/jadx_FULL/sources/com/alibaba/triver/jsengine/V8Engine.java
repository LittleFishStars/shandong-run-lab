package com.alibaba.triver.jsengine;

import android.content.Context;
import com.alipay.mobile.jsengine.JSEngine2;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Engine implements Serializable {
    public static String TAG = "jsengine";

    public static boolean Initialize(Context context) {
        if (context == null) {
            return false;
        }
        return JSEngine2.Initialize(new b(context));
    }

    public static boolean isInitialize() {
        return JSEngine2.isInitialized();
    }
}
