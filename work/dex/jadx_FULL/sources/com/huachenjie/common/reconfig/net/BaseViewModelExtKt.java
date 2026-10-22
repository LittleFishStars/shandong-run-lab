package com.huachenjie.common.reconfig.net;

import androidx.p002lifecycle.ViewModelKt;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.exception.IExceptionHandler;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.a;
import com.igexin.push.g.o;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0080\u0001\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", RVParams.LONG_SHOW_LOADING, "showError", "Lkotlin/Function1;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "Lkotlin/ParameterName;", "name", c.f25231a, "errorFun", "Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;", "exceptionHandler", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/Job;", "a", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;ZZLkotlin/jvm/functions/Function1;Lcom/huachenjie/common/reconfig/net/exception/IExceptionHandler;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "common_release"}, k = 2, mv = {1, 8, 0})
public final class BaseViewModelExtKt {
    @NotNull
    public static final Job a(@NotNull BaseViewModel baseViewModel, boolean z, boolean z2, @NotNull Function1<? super ResultException, Boolean> function1, @NotNull IExceptionHandler iExceptionHandler, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(baseViewModel, "<this>");
        Intrinsics.checkNotNullParameter(function1, "errorFun");
        Intrinsics.checkNotNullParameter(iExceptionHandler, "exceptionHandler");
        Intrinsics.checkNotNullParameter(function2, "block");
        return v41.e(ViewModelKt.getViewModelScope(baseViewModel), new a(iExceptionHandler), (CoroutineStart) null, new BaseViewModelExtKt$launch$2(z, baseViewModel, function2, null), 2, (Object) null);
    }

    public static /* synthetic */ Job b(BaseViewModel baseViewModel, boolean z, boolean z2, Function1 function1, IExceptionHandler iExceptionHandler, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 2) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            function1 = new Function1<ResultException, Boolean>() { // from class: com.huachenjie.common.reconfig.net.BaseViewModelExtKt$launch$1
                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    return Boolean.FALSE;
                }
            };
        }
        Function1 function3 = function1;
        if ((i & 8) != 0) {
            iExceptionHandler = new com.huachenjie.common.reconfig.net.exception.c(z4, function3);
        }
        return a(baseViewModel, z3, z4, function3, iExceptionHandler, function2);
    }
}
