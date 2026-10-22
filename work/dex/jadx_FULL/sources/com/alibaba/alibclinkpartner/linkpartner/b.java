package com.alibaba.alibclinkpartner.linkpartner;

import android.app.Application;
import android.content.Context;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static synchronized int init(Application application) {
        return init(application, null);
    }

    public static synchronized int init(Application application, String str) {
        return ALSLSmartLinkSDK.init(application, str);
    }

    public static void jumpApp(Context context, ALPTBJumpParam aLPTBJumpParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a.a(context, aLPTBJumpParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }
}
