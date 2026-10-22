package com.byazt.sb;

import com.byazt.jtc.uj;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1065, 54})
public class ve {
    public static final TimeUnit c = TimeUnit.SECONDS;

    public static ExecutorService c() {
        uj ujVar = new uj(1, 2, 30L, c, new LinkedBlockingQueue(), new c("default"));
        ujVar.allowCoreThreadTimeOut(true);
        return ujVar;
    }
}
