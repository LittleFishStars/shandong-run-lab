package com.huachenjie.mall.page.my_order;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.OrderCountBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.my_order.MyOrderVM$queryOrderCount$1", f = "MyOrderVM.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class MyOrderVM$queryOrderCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MyOrderVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyOrderVM$queryOrderCount$1(MyOrderVM myOrderVM, Continuation<? super MyOrderVM$queryOrderCount$1> continuation) {
        super(2, continuation);
        this.this$0 = myOrderVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyOrderVM$queryOrderCount$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<OrderCountBean> mutableLiveDataK = this.this$0.k();
            MallModel mallModel = MallModel.f34763a;
            this.L$0 = mutableLiveDataK;
            this.label = 1;
            Object objQ = mallModel.Q(this);
            if (objQ == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataK;
            obj = objQ;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
