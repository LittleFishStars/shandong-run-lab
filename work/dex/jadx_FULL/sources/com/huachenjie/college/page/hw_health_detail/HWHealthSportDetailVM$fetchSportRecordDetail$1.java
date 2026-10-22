package com.huachenjie.college.page.hw_health_detail;

import com.huachenjie.college.api.RequestModel;
import com.huachenjie.college.bean.HWHealthSportDetailBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM$fetchSportRecordDetail$1", f = "HWHealthSportDetailVM.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class HWHealthSportDetailVM$fetchSportRecordDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sportRecordCode;
    int label;
    final /* synthetic */ HWHealthSportDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWHealthSportDetailVM$fetchSportRecordDetail$1(String str, HWHealthSportDetailVM hWHealthSportDetailVM, Continuation<? super HWHealthSportDetailVM$fetchSportRecordDetail$1> continuation) {
        super(2, continuation);
        this.$sportRecordCode = str;
        this.this$0 = hWHealthSportDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HWHealthSportDetailVM$fetchSportRecordDetail$1(this.$sportRecordCode, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33549a;
            String str = this.$sportRecordCode;
            this.label = 1;
            obj = requestModel.i(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HWHealthSportDetailBean hWHealthSportDetailBean = (HWHealthSportDetailBean) obj;
        if (hWHealthSportDetailBean != null) {
            this.this$0.o().setValue(hWHealthSportDetailBean);
        }
        return Unit.INSTANCE;
    }
}
