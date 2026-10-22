package com.huachenjie.mall.page.my_order;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.R;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bJ\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013J\u001c\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010(\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u0006+"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "", "status", "Lkotlin/Function1;", "", RenderCallContext.TYPE_CALLBACK, "E", "addressNo", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "I", "orderAddressNo", "C", "tradeNo", "reasonType", "Lkotlin/Function0;", "B", "orderNo", "D", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/page/my_order/MyOrderListAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "F", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "a", "Ljava/lang/Integer;", "H", "()Ljava/lang/Integer;", "K", "(Ljava/lang/Integer;)V", "orderStatus", "b", "G", "J", "commentStatus", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyOrderListVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyOrderListVM.kt\ncom/huachenjie/mall/page/my_order/MyOrderListVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1864#2,3:107\n1855#2,2:110\n*S KotlinDebug\n*F\n+ 1 MyOrderListVM.kt\ncom/huachenjie/mall/page/my_order/MyOrderListVM\n*L\n41#1:107,3\n67#1:110,2\n*E\n"})
public final class MyOrderListVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Integer orderStatus;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Integer commentStatus;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MyOrderListAdapter> adapter = new MutableLiveData<>();

    public final void B(@NotNull String tradeNo, int reasonType, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new MyOrderListVM$cancelOrder$1(tradeNo, reasonType, callback, null), 14, null);
    }

    public final void C(@NotNull String orderAddressNo, @NotNull String addressNo) {
        Intrinsics.checkNotNullParameter(orderAddressNo, "orderAddressNo");
        Intrinsics.checkNotNullParameter(addressNo, "addressNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new MyOrderListVM$changeAddress$1(orderAddressNo, addressNo, null), 14, null);
    }

    public final void D(@NotNull String orderNo, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new MyOrderListVM$confirmReceive$1(orderNo, callback, null), 14, null);
    }

    public final void E(int status, @NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        MyOrderListAdapter value = this.adapter.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        int i = 0;
        for (Object obj : value.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MyOrderBean myOrderBean = (MyOrderBean) obj;
            if (myOrderBean.getOrderStatus() == 0 || myOrderBean.getOrderStatus() == 5) {
                if (myOrderBean.getPayRemainTime() > 0) {
                    myOrderBean.setPayRemainTime(myOrderBean.getPayRemainTime() - 1);
                    value.notifyItemChanged(i);
                } else if (myOrderBean.getPayRemainTime() == 0) {
                    if (myOrderBean.getOrderStatus() == 5) {
                        z = true;
                    } else {
                        myOrderBean.setOrderStatus(4);
                        if (status == 1) {
                            arrayList.add(myOrderBean);
                        } else {
                            String strE = ys8.e(R.string.mall_my_order_status5);
                            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mall_my_order_status5)");
                            myOrderBean.setOrderStatusDesc(strE);
                            value.notifyItemChanged(i);
                        }
                    }
                }
            }
            i = i2;
        }
        if (z) {
            y();
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            callback.invoke(((MyOrderBean) it.next()).getOrderNo());
        }
    }

    @NotNull
    public final MutableLiveData<MyOrderListAdapter> F() {
        return this.adapter;
    }

    @Nullable
    /* JADX INFO: renamed from: G, reason: from getter */
    public final Integer getCommentStatus() {
        return this.commentStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: H, reason: from getter */
    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final void I(@NotNull String addressNo, @NotNull Function1<? super ShippingAddressBean, Unit> callback) {
        Intrinsics.checkNotNullParameter(addressNo, "addressNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new MyOrderListVM$queryAddress$1(addressNo, callback, null), 14, null);
    }

    public final void J(@Nullable Integer num) {
        this.commentStatus = num;
    }

    public final void K(@Nullable Integer num) {
        this.orderStatus = num;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new MyOrderListVM$loadMoreData$1(this, null), 11, null);
    }
}
