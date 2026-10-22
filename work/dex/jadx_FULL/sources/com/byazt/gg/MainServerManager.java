package com.byazt.gg;

import android.app.Application;
import android.content.Context;
import com.byazt.bog.n;
import com.byazt.lm.uj;
import com.byazt.quv.AbsServerManager;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.huachenjie.common.constants.ErrorCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, ErrorCode.CHECK_START_RUN_ERROR.e, 174})
public class MainServerManager extends AbsServerManager {
    @Override // com.byazt.quv.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TTAppContextHolder.setContext(applicationContext);
        if (!n.c() && (applicationContext instanceof Application)) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(uj.instance().getActivityLifecycleCallback());
        }
        return super.onCreate();
    }
}
