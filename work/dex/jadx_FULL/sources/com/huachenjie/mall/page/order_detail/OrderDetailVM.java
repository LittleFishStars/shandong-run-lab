package com.huachenjie.mall.page.order_detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.zj.adlib.r90;
import com.zj.adlib.v41;
import com.zj.adlib.ws1;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J$\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00198\u0006¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R%\u00100\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00040\u00040\u00198\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0006¢\u0006\f\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001dR\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0006¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002070\u00198\u0006¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010\u001d¨\u0006="}, d2 = {"Lcom/huachenjie/mall/page/order_detail/OrderDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "orderNo", "", "needShowError", "", "x", "orderAddressNo", "addressNo", "Lkotlin/Function0;", RenderCallContext.TYPE_CALLBACK, "n", "", "reasonType", "m", j.b, "orderItemNo", j.o, "Landroid/content/Context;", "context", "A", "Lcom/huachenjie/base/bean/mall/OrderDetailBean;", "detailBean", "C", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "u", "()Landroidx/lifecycle/MutableLiveData;", "layoutState", "c", "q", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/mall/page/order_detail/OrderDetailGoodsAdapter;", "d", "p", "adapter", "e", "t", "countPayTime", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "countDownTask", "kotlin.jvm.PlatformType", "f", "v", "payBtnEnable", y6b.f, "r", "cancelResult", y6b.g, "s", "confirmResult", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "i", "w", "refundGoodsBean", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class OrderDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Job countDownTask;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderDetailBean> bean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderDetailGoodsAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> countPayTime = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> payBtnEnable = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> cancelResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> confirmResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderGoodsBean> refundGoodsBean = new MutableLiveData<>();

    public static final void B(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$callback");
        ViewParent parent = view.getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        r90.U(((CheckBox) ((ViewGroup) parent).findViewById(R.id.cb_no_hint)).isChecked());
        function0.invoke();
    }

    public static /* synthetic */ void y(OrderDetailVM orderDetailVM, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        orderDetailVM.x(str, z);
    }

    public final void A(@NotNull Context context, @NotNull final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        OrderDetailBean value = this.bean.getValue();
        if ((value != null ? value.getPayPointsTotal() : 0) <= 0) {
            callback.invoke();
        } else if (r90.q()) {
            callback.invoke();
        } else {
            ws1.Z(context).U(R.style.confirm_dialog_theme).R(R.layout.mall_dialog_apply_after_sale_hint).X(context.getString(R.string.mall_order_detail_sale_hint_title)).Q(context.getString(R.string.mall_order_detail_sale_hint_content)).F(context.getString(R.string.mall_order_detail_sale_hint_cancel)).N(context.getString(R.string.mall_order_detail_sale_hint_confirm)).J(new View.OnClickListener() { // from class: com.zj.adlib.vd6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderDetailVM.B(callback, view);
                }
            }).Y();
        }
    }

    public final void C(OrderDetailBean detailBean) {
        this.countPayTime.setValue(detailBean.getRemainPayTime());
        this.countDownTask = v41.e(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OrderDetailVM$startCountDown$1(detailBean, this, null), 3, (Object) null);
    }

    public final void m(int reasonType) {
        BaseViewModelExtKt.b(this, true, false, null, null, new OrderDetailVM$cancelOrder$1(this, reasonType, null), 14, null);
    }

    public final void n(@NotNull String orderAddressNo, @NotNull String addressNo, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(orderAddressNo, "orderAddressNo");
        Intrinsics.checkNotNullParameter(addressNo, "addressNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new OrderDetailVM$changeAddress$1(orderAddressNo, addressNo, callback, null), 14, null);
    }

    public final void o() {
        BaseViewModelExtKt.b(this, true, false, null, null, new OrderDetailVM$confirmReceive$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<OrderDetailGoodsAdapter> p() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<OrderDetailBean> q() {
        return this.bean;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.cancelResult;
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return this.confirmResult;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.countPayTime;
    }

    @NotNull
    public final MutableLiveData<Integer> u() {
        return this.layoutState;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.payBtnEnable;
    }

    @NotNull
    public final MutableLiveData<OrderGoodsBean> w() {
        return this.refundGoodsBean;
    }

    public final void x(@NotNull String orderNo, final boolean needShowError) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        BaseViewModelExtKt.b(this, !needShowError, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailVM$queryOrderDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (needShowError) {
                    this.u().setValue(3);
                }
                return Boolean.FALSE;
            }
        }, null, new OrderDetailVM$queryOrderDetail$2(orderNo, this, null), 10, null);
    }

    public final void z(@NotNull String orderItemNo) {
        Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new OrderDetailVM$queryRefundGoodsInfo$1(orderItemNo, this, null), 14, null);
    }
}
