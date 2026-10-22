package com.huachenjie.ad.widget;

import com.huachenjie.ad.interfaces.SplashAdListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "cause", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.ad.widget.SplashAdView$startCountDown$3", f = "SplashAdView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SplashAdView$startCountDown$3 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplashAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView$startCountDown$3(SplashAdView splashAdView, Continuation<? super SplashAdView$startCountDown$3> continuation) {
        super(3, continuation);
        this.this$0 = splashAdView;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Integer> flowCollector, @Nullable Throwable th, @Nullable Continuation<? super Unit> continuation) {
        SplashAdView$startCountDown$3 splashAdView$startCountDown$3 = new SplashAdView$startCountDown$3(this.this$0, continuation);
        splashAdView$startCountDown$3.L$0 = th;
        return splashAdView$startCountDown$3.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (((Throwable) this.L$0) == null) {
            SplashAdListener splashAdListener = this.this$0.mListener;
            if (splashAdListener != null) {
                Integer num = this.this$0.mLoadSupplier;
                splashAdListener.b(num != null ? num.intValue() : -1);
            }
        } else {
            SplashAdListener splashAdListener2 = this.this$0.mListener;
            if (splashAdListener2 != null) {
                Integer num2 = this.this$0.mLoadSupplier;
                splashAdListener2.c(num2 != null ? num2.intValue() : -1, "-1", "广告加载超时");
            }
        }
        return Unit.INSTANCE;
    }
}
