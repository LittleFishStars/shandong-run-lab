package com.byazt.gg;

import com.byazt.bog.a;
import com.byazt.nys.i;
import com.byazt.quv.AbsServerManager;
import com.byazt.zqa.c;
import com.huachenjie.common.constants.ErrorCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, ErrorCode.CHECK_START_RUN_ERROR.e, 2522})
public class DownloaderServerManager extends AbsServerManager {
    @Override // com.byazt.quv.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        try {
            i.c(getContext());
        } catch (Throwable th) {
            a.c(th);
        }
        return super.onCreate();
    }
}
