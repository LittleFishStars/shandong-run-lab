package com.huachenjie.mall.dialog.pay;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.pay.PayVM$queryTradeProgress$2", f = "PayVM.kt", i = {}, l = {96, 98}, m = "invokeSuspend", n = {}, s = {})
public final class PayVM$queryTradeProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PayVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayVM$queryTradeProgress$2(PayVM payVM, Continuation<? super PayVM$queryTradeProgress$2> continuation) {
        super(2, continuation);
        this.this$0 = payVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayVM$queryTradeProgress$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JSONObject jSONObject;
        int intValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            jSONObject = (JSONObject) obj;
            MutableLiveData<Integer> mutableLiveDataS = this.this$0.s();
            if (jSONObject != null) {
                intValue = jSONObject.getIntValue("status");
            } else {
                intValue = 0;
            }
            mutableLiveDataS.setValue(Boxing.boxInt(intValue));
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (DelayKt.b(1000L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        MallModel mallModel = MallModel.f34763a;
        String value = this.this$0.r().getValue();
        if (value == null) {
            value = "";
        }
        this.label = 2;
        obj = mallModel.c0(value, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        jSONObject = (JSONObject) obj;
        MutableLiveData<Integer> mutableLiveDataS2 = this.this$0.s();
        if (jSONObject != null) {
            intValue = jSONObject.getIntValue("status");
        } else {
            intValue = 0;
        }
        mutableLiveDataS2.setValue(Boxing.boxInt(intValue));
        return Unit.INSTANCE;
    }
}
