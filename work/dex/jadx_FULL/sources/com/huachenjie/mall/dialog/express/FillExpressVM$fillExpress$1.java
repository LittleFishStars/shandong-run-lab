package com.huachenjie.mall.dialog.express;

import com.huachenjie.mall.api.MallModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.express.FillExpressVM$fillExpress$1", f = "FillExpressVM.kt", i = {}, l = {29, 31}, m = "invokeSuspend", n = {}, s = {})
public final class FillExpressVM$fillExpress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFillExpress;
    final /* synthetic */ String $refundOrderNo;
    final /* synthetic */ String $shipperCode;
    int label;
    final /* synthetic */ FillExpressVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillExpressVM$fillExpress$1(boolean z, String str, String str2, FillExpressVM fillExpressVM, Continuation<? super FillExpressVM$fillExpress$1> continuation) {
        super(2, continuation);
        this.$isFillExpress = z;
        this.$refundOrderNo = str;
        this.$shipperCode = str2;
        this.this$0 = fillExpressVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FillExpressVM$fillExpress$1(this.$isFillExpress, this.$refundOrderNo, this.$shipperCode, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isFillExpress) {
                MallModel mallModel = MallModel.f34763a;
                String str2 = this.$refundOrderNo;
                String str3 = this.$shipperCode;
                String value = this.this$0.k().getValue();
                str = value != null ? value : "";
                this.label = 1;
                if (mallModel.l(str2, str3, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                MallModel mallModel2 = MallModel.f34763a;
                String str4 = this.$refundOrderNo;
                String str5 = this.$shipperCode;
                String value2 = this.this$0.k().getValue();
                str = value2 != null ? value2 : "";
                this.label = 2;
                if (mallModel2.h(str4, str5, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.l().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
