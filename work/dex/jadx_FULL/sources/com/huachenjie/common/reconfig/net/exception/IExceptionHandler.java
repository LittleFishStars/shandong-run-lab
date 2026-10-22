package com.huachenjie.common.reconfig.net.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "b", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$NetException;", "a", "common_release"}, k = 1, mv = {1, 8, 0})
public interface IExceptionHandler {
    void a(@NotNull ResultException.NetException exception);

    void b(@NotNull ResultException.ApiException exception);
}
