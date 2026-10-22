package com.huachenjie.mall.page.address.edit;

import com.huachenjie.base.bean.mall.ShippingAddressBean;
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
@DebugMetadata(c = "com.huachenjie.mall.page.address.edit.ShippingAddressEditVM$addAddress$1", f = "ShippingAddressEditVM.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class ShippingAddressEditVM$addAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShippingAddressEditVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShippingAddressEditVM$addAddress$1(ShippingAddressEditVM shippingAddressEditVM, Continuation<? super ShippingAddressEditVM$addAddress$1> continuation) {
        super(2, continuation);
        this.this$0 = shippingAddressEditVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShippingAddressEditVM$addAddress$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String provinceCode;
        String provinceName;
        String cityCode;
        String cityName;
        String districtCode;
        String districtName;
        Object objC;
        String addressNo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = "";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String value = this.this$0.q().getValue();
            if (value == null) {
                value = "";
            }
            String value2 = this.this$0.r().getValue();
            if (value2 == null) {
                value2 = "";
            }
            ShippingAddressBean value3 = this.this$0.l().getValue();
            if (value3 == null || (provinceCode = value3.getProvinceCode()) == null) {
                provinceCode = "";
            }
            ShippingAddressBean value4 = this.this$0.l().getValue();
            if (value4 == null || (provinceName = value4.getProvinceName()) == null) {
                provinceName = "";
            }
            ShippingAddressBean value5 = this.this$0.l().getValue();
            if (value5 == null || (cityCode = value5.getCityCode()) == null) {
                cityCode = "";
            }
            ShippingAddressBean value6 = this.this$0.l().getValue();
            if (value6 == null || (cityName = value6.getCityName()) == null) {
                cityName = "";
            }
            ShippingAddressBean value7 = this.this$0.l().getValue();
            if (value7 == null || (districtCode = value7.getDistrictCode()) == null) {
                districtCode = "";
            }
            ShippingAddressBean value8 = this.this$0.l().getValue();
            if (value8 == null || (districtName = value8.getDistrictName()) == null) {
                districtName = "";
            }
            String value9 = this.this$0.o().getValue();
            if (value9 == null) {
                value9 = "";
            }
            Boolean value10 = this.this$0.n().getValue();
            if (value10 == null) {
                value10 = Boxing.boxBoolean(false);
            }
            boolean zBooleanValue = value10.booleanValue();
            this.label = 1;
            objC = mallModel.c(value, value2, provinceCode, provinceName, cityCode, cityName, districtCode, districtName, value9, zBooleanValue, this);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objC = obj;
        }
        ShippingAddressBean shippingAddressBean = (ShippingAddressBean) objC;
        ShippingAddressBean value11 = this.this$0.l().getValue();
        if (value11 == null) {
            value11 = new ShippingAddressBean(null, null, null, null, null, null, null, null, null, null, null, false, false, 8191, null);
        }
        String value12 = this.this$0.q().getValue();
        if (value12 == null) {
            value12 = "";
        }
        value11.setReceiverName(value12);
        String value13 = this.this$0.r().getValue();
        if (value13 == null) {
            value13 = "";
        }
        value11.setReceiverPhone(value13);
        String value14 = this.this$0.o().getValue();
        if (value14 == null) {
            value14 = "";
        }
        value11.setAddress(value14);
        if (shippingAddressBean != null && (addressNo = shippingAddressBean.getAddressNo()) != null) {
            str = addressNo;
        }
        value11.setAddressNo(str);
        Boolean value15 = this.this$0.n().getValue();
        value11.setDefaultFlag(value15 != null ? value15.booleanValue() : false);
        this.this$0.s().setValue(value11);
        return Unit.INSTANCE;
    }
}
