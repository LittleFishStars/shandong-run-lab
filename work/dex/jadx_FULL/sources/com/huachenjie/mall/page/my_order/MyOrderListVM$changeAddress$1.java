package com.huachenjie.mall.page.my_order;

import com.huachenjie.mall.R;
import com.huachenjie.mall.api.MallModel;
import com.zj.adlib.fv5;
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
@DebugMetadata(c = "com.huachenjie.mall.page.my_order.MyOrderListVM$changeAddress$1", f = "MyOrderListVM.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class MyOrderListVM$changeAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $addressNo;
    final /* synthetic */ String $orderAddressNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyOrderListVM$changeAddress$1(String str, String str2, Continuation<? super MyOrderListVM$changeAddress$1> continuation) {
        super(2, continuation);
        this.$orderAddressNo = str;
        this.$addressNo = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyOrderListVM$changeAddress$1(this.$orderAddressNo, this.$addressNo, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            String str = this.$orderAddressNo;
            String str2 = this.$addressNo;
            this.label = 1;
            if (mallModel.g(str, str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.a(R.string.mall_my_order_hint_address);
        return Unit.INSTANCE;
    }
}
