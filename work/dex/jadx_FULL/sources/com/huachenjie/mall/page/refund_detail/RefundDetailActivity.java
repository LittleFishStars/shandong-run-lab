package com.huachenjie.mall.page.refund_detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.AttachmentBean;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.bean.MyRefundDetailBean;
import com.huachenjie.mall.databinding.MallActivityRefundDetailBinding;
import com.huachenjie.mall.databinding.MallViewRefundDetailAddressBinding;
import com.huachenjie.mall.dialog.express.FillExpressDialog;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.wd6;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u0012B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityRefundDetailBinding;", "Lcom/huachenjie/mall/page/refund_detail/RefundDetailVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "k0", "g0", "i0", "j0", "Lcom/huachenjie/mall/databinding/MallViewRefundDetailAddressBinding;", "a", "Lcom/huachenjie/mall/databinding/MallViewRefundDetailAddressBinding;", "addressBinding", "Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity$ClickProxy;", "Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity$ClickProxy;", "clickProxy", "<init>", "()V", "ClickProxy", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RefundDetailActivity extends BaseMVVMActivity<MallActivityRefundDetailBinding, RefundDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "refund_order_no";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MallViewRefundDetailAddressBinding addressBinding;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ClickProxy clickProxy = new ClickProxy();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "b", "c", "a", "d", "<init>", "(Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            RefundCancelDialog refundCancelDialog = new RefundCancelDialog();
            final RefundDetailActivity refundDetailActivity = RefundDetailActivity.this;
            refundCancelDialog.setCallback(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.refund_detail.RefundDetailActivity$ClickProxy$clickCancelRefund$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    String refundOrderNo;
                    Intrinsics.checkNotNullParameter(str, o.f);
                    RefundDetailVM refundDetailVME0 = RefundDetailActivity.e0(refundDetailActivity);
                    MyRefundDetailBean value = RefundDetailActivity.e0(refundDetailActivity).l().getValue();
                    if (value == null || (refundOrderNo = value.getRefundOrderNo()) == null) {
                        refundOrderNo = "";
                    }
                    refundDetailVME0.j(refundOrderNo, str);
                }
            });
            FragmentManager supportFragmentManager = RefundDetailActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            refundCancelDialog.show(supportFragmentManager, "RefundCancelDialog");
        }

        public final void b(@Nullable View v) {
            ShippingAddressBean addressInfo;
            MyRefundDetailBean value = RefundDetailActivity.e0(RefundDetailActivity.this).l().getValue();
            if (value == null || (addressInfo = value.getAddressInfo()) == null) {
                return;
            }
            Object systemService = RefundDetailActivity.this.getApplication().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Address", addressInfo.getReceiverName() + ' ' + addressInfo.getReceiverPhone() + ' ' + addressInfo.formatCity() + ' ' + addressInfo.getAddress()));
            fv5.a(R.string.mall_order_detail_copy_suc);
        }

        public final void c(@Nullable View v) {
            String refundOrderNo;
            Object systemService = RefundDetailActivity.this.getApplication().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            MyRefundDetailBean value = RefundDetailActivity.e0(RefundDetailActivity.this).l().getValue();
            if (value == null || (refundOrderNo = value.getRefundOrderNo()) == null) {
                refundOrderNo = "";
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Text", refundOrderNo));
            fv5.a(R.string.mall_order_detail_copy_suc);
        }

        public final void d(@Nullable View v) {
            MyRefundDetailBean value = RefundDetailActivity.e0(RefundDetailActivity.this).l().getValue();
            if (value == null) {
                return;
            }
            final boolean zIsEmpty = TextUtils.isEmpty(value.getLogisticCoCode());
            FillExpressDialog.Companion companion = FillExpressDialog.INSTANCE;
            FragmentManager supportFragmentManager = RefundDetailActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            String refundOrderNo = value.getRefundOrderNo();
            String logisticCoName = value.getLogisticCoName();
            String logisticCoCode = value.getLogisticCoCode();
            String logisticSid = value.getLogisticSid();
            final RefundDetailActivity refundDetailActivity = RefundDetailActivity.this;
            companion.a(supportFragmentManager, zIsEmpty, refundOrderNo, logisticCoName, logisticCoCode, logisticSid, new Function2<ExpressCompanyBean, String, Unit>() { // from class: com.huachenjie.mall.page.refund_detail.RefundDetailActivity$ClickProxy$clickFillExpress$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((ExpressCompanyBean) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExpressCompanyBean expressCompanyBean, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(expressCompanyBean, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    RefundDetailVM.q(RefundDetailActivity.e0(refundDetailActivity), true, false, 2, null);
                    if (zIsEmpty) {
                        wd6 wd6Var = wd6.f20422a;
                        RefundDetailActivity refundDetailActivity2 = refundDetailActivity;
                        wd6Var.b(refundDetailActivity2, RefundDetailActivity.e0(refundDetailActivity2).getRefundOrderNo(), 5);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.refund_detail.RefundDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/refund_detail/RefundDetailActivity$a;", "", "Landroid/content/Context;", "context", "", "refundOrderNo", "Landroid/content/Intent;", "a", "KEY_REFUND_ORDER_NO", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String refundOrderNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
            Intent intent = new Intent(context, (Class<?>) RefundDetailActivity.class);
            intent.putExtra(RefundDetailActivity.t, refundOrderNo);
            return intent;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35257a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35257a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35257a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35257a.invoke(obj);
        }
    }

    public static final /* synthetic */ RefundDetailVM e0(RefundDetailActivity refundDetailActivity) {
        return refundDetailActivity.getMViewModel();
    }

    public static final void h0(RefundDetailFileAdapter refundDetailFileAdapter, RefundDetailActivity refundDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(refundDetailFileAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(refundDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        AttachmentBean attachmentBean = refundDetailFileAdapter.getData().get(i);
        if (attachmentBean.getAttachmentType() == 1) {
            PicturePreviewUtil.i(view, attachmentBean.getUrl());
        } else {
            VideoPlayerActivity.INSTANCE.a(refundDetailActivity, attachmentBean.getUrl());
        }
    }

    public static final void l0(RefundDetailActivity refundDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(refundDetailActivity, "this$0");
        refundDetailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), this.clickProxy)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        i0();
        j0();
    }

    public final void g0() {
        MutableLiveData<RefundDetailFileAdapter> mutableLiveDataK = getMViewModel().k();
        final RefundDetailFileAdapter refundDetailFileAdapter = new RefundDetailFileAdapter();
        refundDetailFileAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.vd7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RefundDetailActivity.h0(refundDetailFileAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataK.setValue(refundDetailFileAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_refund_detail;
    }

    public final void i0() {
        getMViewModel().l().observe(this, new b(new Function1<MyRefundDetailBean, Unit>() { // from class: com.huachenjie.mall.page.refund_detail.RefundDetailActivity$initAddressObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MyRefundDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MyRefundDetailBean myRefundDetailBean) {
                View root;
                MutableLiveData<BindingTitleBean> mutableLiveDataI = RefundDetailActivity.e0(this.this$0).i();
                BindingTitleBean value = RefundDetailActivity.e0(this.this$0).i().getValue();
                if (value != null) {
                    value.setTitleName(myRefundDetailBean.getRefundStatusTypeDesc());
                } else {
                    value = null;
                }
                mutableLiveDataI.setValue(value);
                if (!(myRefundDetailBean.getAddressInfo() != null && myRefundDetailBean.showSaleAddress())) {
                    MallViewRefundDetailAddressBinding mallViewRefundDetailAddressBinding = this.this$0.addressBinding;
                    root = mallViewRefundDetailAddressBinding != null ? mallViewRefundDetailAddressBinding.getRoot() : null;
                    if (root != null) {
                        root.setVisibility(8);
                    }
                } else if (this.this$0.addressBinding == null) {
                    RefundDetailActivity refundDetailActivity = this.this$0;
                    ViewStub viewStub = refundDetailActivity.getMBinding().f10340a.getViewStub();
                    Intrinsics.checkNotNull(viewStub);
                    refundDetailActivity.addressBinding = (MallViewRefundDetailAddressBinding) DataBindingUtil.getBinding(viewStub.inflate());
                    MallViewRefundDetailAddressBinding mallViewRefundDetailAddressBinding2 = this.this$0.addressBinding;
                    if (mallViewRefundDetailAddressBinding2 != null) {
                        mallViewRefundDetailAddressBinding2.setVariable(hk0.c, myRefundDetailBean.getAddressInfo());
                    }
                    MallViewRefundDetailAddressBinding mallViewRefundDetailAddressBinding3 = this.this$0.addressBinding;
                    if (mallViewRefundDetailAddressBinding3 != null) {
                        mallViewRefundDetailAddressBinding3.setVariable(hk0.k, this.this$0.clickProxy);
                    }
                } else {
                    MallViewRefundDetailAddressBinding mallViewRefundDetailAddressBinding4 = this.this$0.addressBinding;
                    root = mallViewRefundDetailAddressBinding4 != null ? mallViewRefundDetailAddressBinding4.getRoot() : null;
                    if (root != null) {
                        root.setVisibility(0);
                    }
                }
                if (!myRefundDetailBean.getAttachmentList().isEmpty()) {
                    this.this$0.getMBinding().f10341a.setLayoutManager(new GridLayoutManager(this.this$0, myRefundDetailBean.getAttachmentList().size() < 3 ? myRefundDetailBean.getAttachmentList().size() : 3));
                    RefundDetailFileAdapter value2 = RefundDetailActivity.e0(this.this$0).k().getValue();
                    Intrinsics.checkNotNull(value2);
                    value2.setList(myRefundDetailBean.getAttachmentList());
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        RefundDetailVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra(t);
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.r(stringExtra);
        getMViewModel().n().setValue(4);
        RefundDetailVM.q(getMViewModel(), false, true, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        k0();
        g0();
    }

    public final void j0() {
        getMViewModel().m().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.refund_detail.RefundDetailActivity$initResultObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    RefundDetailVM.q(RefundDetailActivity.e0(this.this$0), true, false, 2, null);
                    wd6 wd6Var = wd6.f20422a;
                    RefundDetailActivity refundDetailActivity = this.this$0;
                    wd6Var.b(refundDetailActivity, RefundDetailActivity.e0(refundDetailActivity).getRefundOrderNo(), 5);
                }
            }
        }));
    }

    public final void k0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_order_refund_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.wd7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.l0(this.f45577a, view);
            }
        }));
    }
}
