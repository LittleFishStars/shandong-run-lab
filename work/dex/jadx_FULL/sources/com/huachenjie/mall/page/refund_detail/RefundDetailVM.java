package com.huachenjie.mall.page.refund_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.bean.MyRefundDetailBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010¨\u0006%"}, d2 = {"Lcom/huachenjie/mall/page/refund_detail/RefundDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", RVParams.LONG_SHOW_LOADING, "needShowError", "", "p", "", "refundOrderNo", "cancelReason", "j", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "layoutState", "f", "Ljava/lang/String;", j.b, "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "Lcom/huachenjie/mall/bean/MyRefundDetailBean;", "c", t.d, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/mall/page/refund_detail/RefundDetailFileAdapter;", "d", "k", "adapter", "e", "m", "cancelResult", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RefundDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String refundOrderNo = "";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MyRefundDetailBean> bean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RefundDetailFileAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> cancelResult = new MutableLiveData<>();

    public static /* synthetic */ void q(RefundDetailVM refundDetailVM, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        refundDetailVM.p(z, z2);
    }

    public final void j(@NotNull String refundOrderNo, @NotNull String cancelReason) {
        Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
        Intrinsics.checkNotNullParameter(cancelReason, "cancelReason");
        BaseViewModelExtKt.b(this, true, false, null, null, new RefundDetailVM$cancelAfterSale$1(refundOrderNo, cancelReason, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<RefundDetailFileAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<MyRefundDetailBean> l() {
        return this.bean;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.cancelResult;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.layoutState;
    }

    @NotNull
    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getRefundOrderNo() {
        return this.refundOrderNo;
    }

    public final void p(boolean showLoading, final boolean needShowError) {
        BaseViewModelExtKt.b(this, showLoading, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.refund_detail.RefundDetailVM$queryRefundDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (needShowError) {
                    this.n().setValue(3);
                }
                return Boolean.FALSE;
            }
        }, null, new RefundDetailVM$queryRefundDetail$2(this, null), 10, null);
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refundOrderNo = str;
    }
}
