package com.huachenjie.common.reconfig.net.exception;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "k0", "Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "a", "Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "d", "()Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "handler", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", CachedContentIndex.a.e, "<init>", "(Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class a implements CoroutineExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final IExceptionHandler handler;

    public a(@NotNull IExceptionHandler iExceptionHandler) {
        Intrinsics.checkNotNullParameter(iExceptionHandler, "handler");
        this.handler = iExceptionHandler;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final IExceptionHandler getHandler() {
        return this.handler;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineExceptionHandler.a.a(this, r, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) CoroutineExceptionHandler.a.b(this, key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return CoroutineExceptionHandler.a;
    }

    public void k0(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exception, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
        ResultException resultExceptionA = b.f33873a.a(exception);
        if (resultExceptionA instanceof ResultException.ApiException) {
            this.handler.b((ResultException.ApiException) resultExceptionA);
        } else if (resultExceptionA instanceof ResultException.NetException) {
            this.handler.a((ResultException.NetException) resultExceptionA);
        }
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return CoroutineExceptionHandler.a.c(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.a.d(this, coroutineContext);
    }
}
