package com.huachenjie.common.reconfig.net.exception;

import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B4\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR/\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/c;", "Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "b", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$NetException;", "a", "", "Z", "showError", "Lkotlin/Function1;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "errorFun", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class c implements IExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Function1<ResultException, Boolean> errorFun;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean showError;

    /* JADX WARN: Multi-variable type inference failed */
    public c(boolean z, @NotNull Function1<? super ResultException, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "errorFun");
        this.showError = z;
        this.errorFun = function1;
    }

    @Override // com.huachenjie.common.reconfig.net.exception.IExceptionHandler
    public void a(@NotNull ResultException.NetException exception) {
        Intrinsics.checkNotNullParameter(exception, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
        if (((Boolean) this.errorFun.invoke(exception)).booleanValue() || !this.showError) {
            return;
        }
        if (exception.getMessage().length() > 0) {
            fv5.b(exception.getMessage());
        }
    }

    @Override // com.huachenjie.common.reconfig.net.exception.IExceptionHandler
    public void b(@NotNull ResultException.ApiException exception) {
        Intrinsics.checkNotNullParameter(exception, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
        if (((Boolean) this.errorFun.invoke(exception)).booleanValue()) {
            return;
        }
        if (this.showError || exception.getCode() == 429) {
            String message = exception.getMessage();
            if (message == null || message.length() == 0) {
                return;
            }
            fv5.b(exception.getMessage());
        }
    }

    public /* synthetic */ c(boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, function1);
    }
}
