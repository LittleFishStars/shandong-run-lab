package com.huachenjie.mall.page.refund;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/refund/RefundListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "", "refundOrderNo", "cancelReason", "B", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/page/refund/RefundListAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "adapter", y6b.f, "D", "cancelResult", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RefundListVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RefundListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> cancelResult = new MutableLiveData<>();

    public final void B(@NotNull String refundOrderNo, @NotNull String cancelReason) {
        Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
        Intrinsics.checkNotNullParameter(cancelReason, "cancelReason");
        BaseViewModelExtKt.b(this, true, false, null, null, new RefundListVM$cancelAfterSale$1(refundOrderNo, cancelReason, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<RefundListAdapter> C() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> D() {
        return this.cancelResult;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new RefundListVM$loadMoreData$1(this, null), 11, null);
    }
}
