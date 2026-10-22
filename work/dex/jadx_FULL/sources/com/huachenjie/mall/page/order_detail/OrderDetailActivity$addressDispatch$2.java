package com.huachenjie.mall.page.order_detail;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.databinding.MallViewOrderDetailAddressBinding;
import com.zj.adlib.hk0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class OrderDetailActivity$addressDispatch$2 extends Lambda implements Function0<ActivityResultLauncher<Intent>> {
    final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$addressDispatch$2(OrderDetailActivity orderDetailActivity) {
        super(0);
        this.this$0 = orderDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(final OrderDetailActivity orderDetailActivity, ActivityResult activityResult) {
        Intent data;
        final ShippingAddressBean shippingAddressBean;
        Intrinsics.checkNotNullParameter(orderDetailActivity, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (shippingAddressBean = (ShippingAddressBean) data.getParcelableExtra("shippingAddress")) == null) {
            return;
        }
        OrderDetailActivity.g0(orderDetailActivity).n(shippingAddressBean.getOrderAddressNo(), shippingAddressBean.getAddressNo(), new Function0<Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$addressDispatch$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m571invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m571invoke() {
                OrderDetailBean value = OrderDetailActivity.g0(orderDetailActivity).q().getValue();
                if (value != null) {
                    value.setAddressInfo(shippingAddressBean);
                }
                MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding = orderDetailActivity.addressBinding;
                if (mallViewOrderDetailAddressBinding != null) {
                    mallViewOrderDetailAddressBinding.setVariable(hk0.g, OrderDetailActivity.g0(orderDetailActivity).q().getValue());
                }
            }
        });
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ActivityResultLauncher<Intent> m570invoke() {
        OrderDetailActivity orderDetailActivity = this.this$0;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        final OrderDetailActivity orderDetailActivity2 = this.this$0;
        return orderDetailActivity.registerForActivityResult(startActivityForResult, new ActivityResultCallback() { // from class: com.huachenjie.mall.page.order_detail.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrderDetailActivity$addressDispatch$2.invoke$lambda$0(orderDetailActivity2, (ActivityResult) obj);
            }
        });
    }
}
