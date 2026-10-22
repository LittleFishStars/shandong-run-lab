package com.huachenjie.common.reconfig.coroutine;

import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.zj.adlib.jo2;
import com.zj.adlib.pm1;
import com.zj.adlib.uw8;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u009e\u0001\u0010\u0012\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u000323\b\u0002\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00052 \b\u0002\u0010\u000e\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"", "Lcom/zj/adlib/pm1;", "a", "", "showError", "Lkotlin/Function2;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "Lkotlin/ParameterName;", "name", c.f25231a, "Lkotlin/coroutines/Continuation;", "errorFun", "Lkotlin/Function1;", "", "onCompletion", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/Job;", "b", "(Lcom/zj/adlib/pm1;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "common_release"}, k = 2, mv = {1, 8, 0})
public final class CoroutineExtKt {
    @NotNull
    public static final pm1 a(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return new pm1(uw8.c((Job) null, 1, (Object) null).plus(jo2.e().B0()));
    }

    @NotNull
    public static final Job b(@NotNull pm1 pm1Var, boolean z, @NotNull Function2<? super ResultException, ? super Continuation<? super Boolean>, ? extends Object> function2, @Nullable Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Function2<? super pm1, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(pm1Var, "<this>");
        Intrinsics.checkNotNullParameter(function2, "errorFun");
        Intrinsics.checkNotNullParameter(function3, "block");
        return v41.e(pm1Var, (CoroutineContext) null, (CoroutineStart) null, new CoroutineExtKt$launchCatching$2(function3, pm1Var, function2, function1, z, null), 3, (Object) null);
    }

    public static /* synthetic */ Job c(pm1 pm1Var, boolean z, Function2 function2, Function1 function1, Function2 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new CoroutineExtKt$launchCatching$1(null);
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return b(pm1Var, z, function2, function1, function3);
    }
}
