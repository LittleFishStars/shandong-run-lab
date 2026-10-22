package com.huachenjie.mall.page.my_order;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MyOrderListFragment$addressDispatch$2 extends Lambda implements Function0<ActivityResultLauncher<Intent>> {
    final /* synthetic */ MyOrderListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyOrderListFragment$addressDispatch$2(MyOrderListFragment myOrderListFragment) {
        super(0);
        this.this$0 = myOrderListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MyOrderListFragment myOrderListFragment, ActivityResult activityResult) {
        Intent data;
        ShippingAddressBean shippingAddressBean;
        Intrinsics.checkNotNullParameter(myOrderListFragment, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (shippingAddressBean = (ShippingAddressBean) data.getParcelableExtra("shippingAddress")) == null) {
            return;
        }
        myOrderListFragment.getMViewModel().C(shippingAddressBean.getOrderAddressNo(), shippingAddressBean.getAddressNo());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ActivityResultLauncher<Intent> m566invoke() {
        MyOrderListFragment myOrderListFragment = this.this$0;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        final MyOrderListFragment myOrderListFragment2 = this.this$0;
        return myOrderListFragment.registerForActivityResult(startActivityForResult, new ActivityResultCallback() { // from class: com.huachenjie.mall.page.my_order.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MyOrderListFragment$addressDispatch$2.invoke$lambda$0(myOrderListFragment2, (ActivityResult) obj);
            }
        });
    }
}
