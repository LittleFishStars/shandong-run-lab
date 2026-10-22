package com.huachenjie.mall.dialog.shop_order;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderVm;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "", y6b.f, "Ljava/lang/String;", "C", "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", ALPParamConstant.SHOPID, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseShopOrderVm extends BaseStateRequestModel {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String shopId = "";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChooseShopOrderAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ChooseShopOrderAdapter> B() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shopId = str;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, isRefreshData, false, q(), null, new ChooseShopOrderVm$loadMoreData$1(this, null), 10, null);
    }
}
