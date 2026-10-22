package com.alibaba.baichuan.trade.common.executor;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExecutorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24546a = "ExecutorManager";

    public static BcExecutor getTaskExecutor(ExecutorType executorType) {
        BcExecutor.a aVar = new BcExecutor.a();
        aVar.g = "task";
        if (TextUtils.isEmpty("task")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + aVar.g);
        }
        if (ExecutorType.UI.equals(executorType)) {
            return BcExecutor.d;
        }
        BcExecutor bcExecutor = (BcExecutor) BcExecutor.e.get(executorType);
        if (bcExecutor != null) {
            return bcExecutor;
        }
        BcExecutor bcExecutor2 = new BcExecutor(aVar.g, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.f24544a);
        BcExecutor.e.put(ExecutorType.NORMAL, bcExecutor2);
        return bcExecutor2;
    }
}
