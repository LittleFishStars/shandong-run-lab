package com.huachenjie.ad.widget;

import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.ad.widget.SplashAdView$startCountDown$2", f = "SplashAdView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SplashAdView$startCountDown$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ SplashAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView$startCountDown$2(SplashAdView splashAdView, Continuation<? super SplashAdView$startCountDown$2> continuation) {
        super(2, continuation);
        this.this$0 = splashAdView;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SplashAdView$startCountDown$2 splashAdView$startCountDown$2 = new SplashAdView$startCountDown$2(this.this$0, continuation);
        splashAdView$startCountDown$2.I$0 = ((Number) obj).intValue();
        return splashAdView$startCountDown$2;
    }

    @Nullable
    public final Object invoke(int i, @Nullable Continuation<? super Unit> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i = this.I$0;
        this.this$0.getCountDownView().setText("跳过  " + i + 's');
        return Unit.INSTANCE;
    }
}
