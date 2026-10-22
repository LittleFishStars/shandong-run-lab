package com.huachenjie.mall.page.address;

import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.api.MallModel;
import com.zj.adlib.fv5;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.address.ShippingAddressVM$deleteAddress$1", f = "ShippingAddressVM.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class ShippingAddressVM$deleteAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShippingAddressBean $address;
    int label;
    final /* synthetic */ ShippingAddressVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShippingAddressVM$deleteAddress$1(ShippingAddressBean shippingAddressBean, ShippingAddressVM shippingAddressVM, Continuation<? super ShippingAddressVM$deleteAddress$1> continuation) {
        super(2, continuation);
        this.$address = shippingAddressBean;
        this.this$0 = shippingAddressVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShippingAddressVM$deleteAddress$1(this.$address, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<ShippingAddressBean> data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String addressNo = this.$address.getAddressNo();
            this.label = 1;
            obj = mallModel.j(addressNo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.b("删除成功");
        if (Intrinsics.areEqual((Boolean) obj, Boxing.boxBoolean(true))) {
            ShippingAddressAdapter value = this.this$0.k().getValue();
            if (value != null) {
                value.remove(this.$address);
            }
            ShippingAddressAdapter value2 = this.this$0.k().getValue();
            boolean z = false;
            if (value2 != null && (data = value2.getData()) != null && data.isEmpty()) {
                z = true;
            }
            if (z) {
                ShippingAddressAdapter value3 = this.this$0.k().getValue();
                if (value3 != null) {
                    value3.l();
                }
                this.this$0.o().setValue(Boxing.boxBoolean(true));
            }
        }
        return Unit.INSTANCE;
    }
}
