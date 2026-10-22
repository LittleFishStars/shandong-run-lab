package com.huachenjie.mall.page.order_detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.OrderDetailLogisticBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.databinding.MallActivityOrderDetailBinding;
import com.huachenjie.mall.databinding.MallFooterOrderDetailBinding;
import com.huachenjie.mall.databinding.MallHeaderOrderDetailBinding;
import com.huachenjie.mall.databinding.MallViewOrderDetailAddressBinding;
import com.huachenjie.mall.databinding.MallViewOrderDetailDeliverBinding;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.huachenjie.mall.dialog.pay.PayDialog;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity;
import com.huachenjie.mall.page.apply_refund.ApplyRefundActivity;
import com.huachenjie.mall.page.comment.detail.CommentDetailActivity;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.noober.background.view.BLTextView;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.su9;
import com.zj.adlib.wd6;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.ORDER_DETAIL)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002=\u001eB\u0007¢\u0006\u0004\b;\u0010<J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u00060\u001dR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010/R)\u00107\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010202018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0019\u001a\u0004\b5\u00106R)\u0010:\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010202018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0019\u001a\u0004\b9\u00106¨\u0006>"}, d2 = {"Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityOrderDetailBinding;", "Lcom/huachenjie/mall/page/order_detail/OrderDetailVM;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "w0", bo.g, "Lcom/huachenjie/base/bean/mall/OrderDetailBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "t0", "r0", "s0", "u0", "v0", "", "b", "Lkotlin/Lazy;", "n0", "()Ljava/lang/String;", "orderNo", "Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity$ClickProxy;", "a", "Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity$ClickProxy;", "clickProxy", "Lcom/huachenjie/mall/databinding/MallHeaderOrderDetailBinding;", "c", "m0", "()Lcom/huachenjie/mall/databinding/MallHeaderOrderDetailBinding;", "headBinding", "Lcom/huachenjie/mall/databinding/MallViewOrderDetailAddressBinding;", "Lcom/huachenjie/mall/databinding/MallViewOrderDetailAddressBinding;", "addressBinding", "Lcom/huachenjie/mall/databinding/MallViewOrderDetailDeliverBinding;", "Lcom/huachenjie/mall/databinding/MallViewOrderDetailDeliverBinding;", "deliverBinding", "Lcom/huachenjie/mall/databinding/MallFooterOrderDetailBinding;", "d", "l0", "()Lcom/huachenjie/mall/databinding/MallFooterOrderDetailBinding;", "footerBinding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "e", "o0", "()Landroidx/activity/result/ActivityResultLauncher;", "refreshDispatch", "f", "k0", "addressDispatch", "<init>", "()V", "ClickProxy", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class OrderDetailActivity extends BaseMVVMActivity<MallActivityOrderDetailBinding, OrderDetailVM> implements AdCancelInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MallViewOrderDetailAddressBinding addressBinding;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MallViewOrderDetailDeliverBinding deliverBinding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$orderNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("orderNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ClickProxy clickProxy = new ClickProxy();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy headBinding = LazyKt.lazy(new Function0<MallHeaderOrderDetailBinding>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$headBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallHeaderOrderDetailBinding m573invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_header_order_detail, null, false);
            OrderDetailActivity orderDetailActivity = this.this$0;
            MallHeaderOrderDetailBinding mallHeaderOrderDetailBinding = (MallHeaderOrderDetailBinding) viewDataBindingInflate;
            mallHeaderOrderDetailBinding.setVariable(hk0.p0, OrderDetailActivity.g0(orderDetailActivity));
            mallHeaderOrderDetailBinding.setVariable(hk0.k, orderDetailActivity.clickProxy);
            return mallHeaderOrderDetailBinding;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy footerBinding = LazyKt.lazy(new Function0<MallFooterOrderDetailBinding>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$footerBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallFooterOrderDetailBinding m572invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_footer_order_detail, null, false);
            MallFooterOrderDetailBinding mallFooterOrderDetailBinding = (MallFooterOrderDetailBinding) viewDataBindingInflate;
            mallFooterOrderDetailBinding.setVariable(hk0.k, this.this$0.clickProxy);
            return mallFooterOrderDetailBinding;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy refreshDispatch = LazyKt.lazy(new OrderDetailActivity$refreshDispatch$2(this));

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy addressDispatch = LazyKt.lazy(new OrderDetailActivity$addressDispatch$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "d", "i", "k", "a", "b", y6b.f, "e", "f", "j", "c", y6b.g, "<init>", "(Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            boolean z = false;
            if (value != null && value.getOrderStatus() == 5) {
                z = true;
            }
            if (z) {
                fv5.a(R.string.mall_my_order_paying_hint);
                return;
            }
            CancelReasonDialog.Companion companion = CancelReasonDialog.INSTANCE;
            OrderDetailVM orderDetailVMG0 = OrderDetailActivity.g0(OrderDetailActivity.this);
            FragmentManager supportFragmentManager = OrderDetailActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            final OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            CancelReasonDialog.Companion.e(companion, orderDetailVMG0, supportFragmentManager, null, new Function1<OrderReasonBean, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$ClickProxy$clickCancel$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OrderReasonBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrderReasonBean orderReasonBean) {
                    Intrinsics.checkNotNullParameter(orderReasonBean, o.f);
                    OrderDetailActivity.g0(orderDetailActivity).m(orderReasonBean.getCode());
                }
            }, 4, null);
        }

        public final void b(@Nullable View v) {
            ShippingAddressBean addressInfo;
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            if (value == null || (addressInfo = value.getAddressInfo()) == null) {
                return;
            }
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            orderDetailActivity.k0().launch(ShippingAddressModifyActivity.INSTANCE.a(orderDetailActivity, addressInfo));
        }

        public final void c(@Nullable View v) {
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            if (value != null) {
                OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
                OrderGoodsBean orderGoodsBean = (OrderGoodsBean) CollectionsKt.firstOrNull(value.getGoodsList());
                if (orderGoodsBean != null) {
                    WriteReviewActivity.INSTANCE.a(orderDetailActivity, value.getOrderNo(), orderGoodsBean);
                }
            }
        }

        public final void d(@Nullable View v) {
            String orderNo;
            Object systemService = OrderDetailActivity.this.getApplication().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            if (value == null || (orderNo = value.getOrderNo()) == null) {
                orderNo = "";
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Text", orderNo));
            fv5.a(R.string.mall_order_detail_copy_suc);
        }

        public final void e(@Nullable View v) {
            String logisticNo;
            OrderDetailLogisticBean logisticInfo;
            ExpressLogisticsActivity.Companion companion = ExpressLogisticsActivity.INSTANCE;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            OrderDetailBean value = OrderDetailActivity.g0(orderDetailActivity).q().getValue();
            if (value == null || (logisticInfo = value.getLogisticInfo()) == null || (logisticNo = logisticInfo.getLogisticNo()) == null) {
                logisticNo = "";
            }
            ExpressLogisticsActivity.Companion.a(companion, orderDetailActivity, logisticNo, false, 4, null);
        }

        public final void f(@Nullable View v) {
            OrderGoodsBean orderGoodsBean;
            String orderItemNo;
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            if (value == null || (orderGoodsBean = (OrderGoodsBean) CollectionsKt.firstOrNull(value.getGoodsList())) == null || (orderItemNo = orderGoodsBean.getOrderItemNo()) == null) {
                return;
            }
            if (value.getCategoryView() == 1) {
                CourseDetailActivity.INSTANCE.b(OrderDetailActivity.this, orderItemNo);
            } else {
                EpisodesDetailActivity.INSTANCE.b(OrderDetailActivity.this, orderItemNo);
            }
        }

        public final void g(@Nullable View v) {
            OrderDetailBean value = OrderDetailActivity.g0(OrderDetailActivity.this).q().getValue();
            if (value == null) {
                return;
            }
            if (value.getOrderStatus() == 5) {
                fv5.a(R.string.mall_my_order_paying_hint);
                return;
            }
            PayDialog.Companion companion = PayDialog.INSTANCE;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            String payAmount = value.getPayAmount();
            String tradeNo = value.getTradeNo();
            int payRemainTime = value.getPayRemainTime();
            String orderNo = value.getOrderNo();
            String shopNo = value.getShopNo();
            final OrderDetailActivity orderDetailActivity2 = OrderDetailActivity.this;
            companion.c(orderDetailActivity, payAmount, tradeNo, payRemainTime, orderNo, shopNo, new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$ClickProxy$clickPay$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final void invoke(int i) {
                    OrderDetailVM orderDetailVMG0 = OrderDetailActivity.g0(orderDetailActivity2);
                    String strN0 = orderDetailActivity2.n0();
                    Intrinsics.checkNotNullExpressionValue(strN0, "orderNo");
                    OrderDetailVM.y(orderDetailVMG0, strN0, false, 2, null);
                    wd6 wd6Var = wd6.f20422a;
                    OrderDetailActivity orderDetailActivity3 = orderDetailActivity2;
                    String strN1 = orderDetailActivity3.n0();
                    Intrinsics.checkNotNullExpressionValue(strN1, "orderNo");
                    wd6Var.b(orderDetailActivity3, strN1, i != 1 ? 6 : 2);
                }
            });
        }

        public final void h(@NotNull View v) {
            String orderNo;
            Intrinsics.checkNotNullParameter(v, "v");
            CommentDetailActivity.Companion aVar = CommentDetailActivity.INSTANCE;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            OrderDetailBean value = OrderDetailActivity.g0(orderDetailActivity).q().getValue();
            if (value == null || (orderNo = value.getOrderNo()) == null) {
                orderNo = "";
            }
            aVar.a(orderDetailActivity, orderNo);
        }

        public final void i(@Nullable View v) {
            String shopNo;
            MerchantsActivity.Companion companion = MerchantsActivity.INSTANCE;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            OrderDetailBean value = OrderDetailActivity.g0(orderDetailActivity).q().getValue();
            if (value == null || (shopNo = value.getShopNo()) == null) {
                shopNo = "";
            }
            companion.a(orderDetailActivity, shopNo);
        }

        public final void j(@Nullable View v) {
            OrderDetailActivity.g0(OrderDetailActivity.this).o();
        }

        public final void k(@Nullable View v) {
            String orderItemNo;
            List<OrderGoodsBean> goodsList;
            OrderGoodsBean orderGoodsBean;
            OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            OrderDetailBean value = OrderDetailActivity.g0(orderDetailActivity).q().getValue();
            if (value == null || (goodsList = value.getGoodsList()) == null || (orderGoodsBean = (OrderGoodsBean) CollectionsKt.firstOrNull(goodsList)) == null || (orderItemNo = orderGoodsBean.getOrderItemNo()) == null) {
                orderItemNo = "";
            }
            su9.n(orderDetailActivity, orderItemNo);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.order_detail.OrderDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/order_detail/OrderDetailActivity$a;", "", "Landroid/content/Context;", "context", "", "orderNo", "", "a", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String orderNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intent intent = new Intent(context, (Class<?>) OrderDetailActivity.class);
            intent.putExtra("orderNo", orderNo);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35241a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35241a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35241a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35241a.invoke(obj);
        }
    }

    public static final /* synthetic */ OrderDetailVM g0(OrderDetailActivity orderDetailActivity) {
        return orderDetailActivity.getMViewModel();
    }

    public static final void q0(OrderDetailGoodsAdapter orderDetailGoodsAdapter, final OrderDetailActivity orderDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(orderDetailGoodsAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(orderDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final OrderGoodsBean orderGoodsBean = orderDetailGoodsAdapter.getData().get(i);
        int id = view.getId();
        if (id != R.id.tv_apply_refund) {
            if (id == R.id.ll_info) {
                GoodsDetailActivity.INSTANCE.a(orderDetailActivity, orderGoodsBean.getGoodsNo());
            }
        } else if (orderGoodsBean.isSaleProcessing()) {
            orderDetailActivity.startActivity(RefundDetailActivity.INSTANCE.a(orderDetailActivity, orderGoodsBean.getRefundOrderNo()));
        } else {
            orderDetailActivity.getMViewModel().A(orderDetailActivity, new Function0<Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$initGoodsList$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m574invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m574invoke() {
                    OrderDetailActivity.g0(this.this$0).z(orderGoodsBean.getOrderItemNo());
                }
            });
        }
    }

    public static final void x0(OrderDetailActivity orderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(orderDetailActivity, "this$0");
        orderDetailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), this.clickProxy)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().q().observe(this, new b(new Function1<OrderDetailBean, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OrderDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OrderDetailBean orderDetailBean) {
                BindingTitleBean value = OrderDetailActivity.g0(this.this$0).i().getValue();
                if (value != null) {
                    OrderDetailActivity orderDetailActivity = this.this$0;
                    value.setTitleName(orderDetailBean.getOrderStatusDesc());
                    OrderDetailActivity.g0(orderDetailActivity).i().setValue(value);
                }
                this.this$0.l0().setVariable(hk0.p0, OrderDetailActivity.g0(this.this$0));
                OrderDetailActivity orderDetailActivity2 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(orderDetailBean, o.f);
                orderDetailActivity2.t0(orderDetailBean);
                OrderDetailGoodsAdapter value2 = OrderDetailActivity.g0(this.this$0).p().getValue();
                if (value2 != null) {
                    value2.setList(orderDetailBean.getGoodsList());
                }
                Drawable background = this.this$0.getMBinding().g.getBackground();
                if (background instanceof GradientDrawable) {
                    if (orderDetailBean.isWaitReceiveStatus()) {
                        ((GradientDrawable) background).setStroke(SizeUtils.b(1.0f), zn1.a(R.color.color_e5e5e5));
                    } else {
                        ((GradientDrawable) background).setStroke(SizeUtils.b(1.0f), zn1.a(R.color.color_650aec));
                    }
                }
            }
        }));
        u0();
        v0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_order_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().u().setValue(4);
        OrderDetailVM mViewModel = getMViewModel();
        String strN0 = n0();
        Intrinsics.checkNotNullExpressionValue(strN0, "orderNo");
        mViewModel.x(strN0, true);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        o0();
        k0();
        w0();
        p0();
    }

    public final ActivityResultLauncher<Intent> k0() {
        return (ActivityResultLauncher) this.addressDispatch.getValue();
    }

    public final MallFooterOrderDetailBinding l0() {
        Object value = this.footerBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-footerBinding>(...)");
        return (MallFooterOrderDetailBinding) value;
    }

    public final MallHeaderOrderDetailBinding m0() {
        Object value = this.headBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-headBinding>(...)");
        return (MallHeaderOrderDetailBinding) value;
    }

    public final String n0() {
        return (String) this.orderNo.getValue();
    }

    public final ActivityResultLauncher<Intent> o0() {
        return (ActivityResultLauncher) this.refreshDispatch.getValue();
    }

    public final void p0() {
        MutableLiveData<OrderDetailGoodsAdapter> mutableLiveDataP = getMViewModel().p();
        final OrderDetailGoodsAdapter orderDetailGoodsAdapter = new OrderDetailGoodsAdapter();
        View root = m0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headBinding.root");
        BaseQuickAdapter.setHeaderView$default(orderDetailGoodsAdapter, root, 0, 0, 6, null);
        View root2 = l0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "footerBinding.root");
        BaseQuickAdapter.setFooterView$default(orderDetailGoodsAdapter, root2, 0, 0, 6, null);
        orderDetailGoodsAdapter.addChildClickViewIds(R.id.tv_shop_name, R.id.tv_apply_refund, R.id.ll_info);
        y57.b(orderDetailGoodsAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.td6
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrderDetailActivity.q0(orderDetailGoodsAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataP.setValue(orderDetailGoodsAdapter);
    }

    public final void r0(OrderDetailBean bean) {
        MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding = this.addressBinding;
        if (mallViewOrderDetailAddressBinding == null) {
            ViewStub viewStub = m0().f10714a.getViewStub();
            Intrinsics.checkNotNull(viewStub);
            this.addressBinding = (MallViewOrderDetailAddressBinding) DataBindingUtil.getBinding(viewStub.inflate());
        } else {
            View root = mallViewOrderDetailAddressBinding != null ? mallViewOrderDetailAddressBinding.getRoot() : null;
            if (root != null) {
                root.setVisibility(0);
            }
        }
        MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding2 = this.addressBinding;
        if (mallViewOrderDetailAddressBinding2 != null) {
            mallViewOrderDetailAddressBinding2.setVariable(hk0.g, bean);
        }
        MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding3 = this.addressBinding;
        if (mallViewOrderDetailAddressBinding3 != null) {
            mallViewOrderDetailAddressBinding3.setVariable(hk0.k, this.clickProxy);
        }
        MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding4 = this.addressBinding;
        BLTextView bLTextView = mallViewOrderDetailAddressBinding4 != null ? mallViewOrderDetailAddressBinding4.f11067a : null;
        if (bLTextView == null) {
            return;
        }
        bLTextView.setVisibility(bean.getOrderStatus() == 4 ? 8 : 0);
    }

    public final void s0(OrderDetailBean bean) {
        TextView textView;
        MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding = this.deliverBinding;
        if (mallViewOrderDetailDeliverBinding == null) {
            ViewStub viewStub = m0().b.getViewStub();
            Intrinsics.checkNotNull(viewStub);
            this.deliverBinding = (MallViewOrderDetailDeliverBinding) DataBindingUtil.getBinding(viewStub.inflate());
        } else {
            View root = mallViewOrderDetailDeliverBinding != null ? mallViewOrderDetailDeliverBinding.getRoot() : null;
            if (root != null) {
                root.setVisibility(0);
            }
        }
        MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding2 = this.deliverBinding;
        if (mallViewOrderDetailDeliverBinding2 != null) {
            mallViewOrderDetailDeliverBinding2.setVariable(hk0.g, bean);
        }
        MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding3 = this.deliverBinding;
        if (mallViewOrderDetailDeliverBinding3 != null) {
            mallViewOrderDetailDeliverBinding3.setVariable(hk0.k, this.clickProxy);
        }
        MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding4 = this.deliverBinding;
        if (mallViewOrderDetailDeliverBinding4 == null || (textView = mallViewOrderDetailDeliverBinding4.f11073a) == null) {
            return;
        }
        textView.setTypeface(null, (bean.getOrderStatus() == 3 || bean.getAfterSaleStatus() == 100) ? 1 : 0);
    }

    public final void t0(OrderDetailBean bean) {
        View root;
        if (bean.getOrderType() == 2 && bean.getOrderStatus() != 0 && bean.getOrderStatus() != 5) {
            MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding = this.addressBinding;
            View root2 = mallViewOrderDetailAddressBinding != null ? mallViewOrderDetailAddressBinding.getRoot() : null;
            if (root2 != null) {
                root2.setVisibility(8);
            }
            MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding = this.deliverBinding;
            root = mallViewOrderDetailDeliverBinding != null ? mallViewOrderDetailDeliverBinding.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(8);
            return;
        }
        if (bean.getLogisticInfo() != null) {
            s0(bean);
            MallViewOrderDetailAddressBinding mallViewOrderDetailAddressBinding2 = this.addressBinding;
            root = mallViewOrderDetailAddressBinding2 != null ? mallViewOrderDetailAddressBinding2.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(8);
            return;
        }
        r0(bean);
        MallViewOrderDetailDeliverBinding mallViewOrderDetailDeliverBinding2 = this.deliverBinding;
        root = mallViewOrderDetailDeliverBinding2 != null ? mallViewOrderDetailDeliverBinding2.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    public final void u0() {
        getMViewModel().w().observe(this, new b(new Function1<OrderGoodsBean, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$initRefundGoods$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OrderGoodsBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OrderGoodsBean orderGoodsBean) {
                ActivityResultLauncher activityResultLauncherO0 = this.this$0.o0();
                ApplyRefundActivity.a aVar = ApplyRefundActivity.f35138a;
                OrderDetailActivity orderDetailActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(orderGoodsBean, o.f);
                activityResultLauncherO0.launch(aVar.a(orderDetailActivity, orderGoodsBean));
            }
        }));
    }

    public final void v0() {
        getMViewModel().r().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$initStatusChange$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                wd6 wd6Var = wd6.f20422a;
                OrderDetailActivity orderDetailActivity = this.this$0;
                String strN0 = orderDetailActivity.n0();
                Intrinsics.checkNotNullExpressionValue(strN0, "orderNo");
                wd6Var.b(orderDetailActivity, strN0, 1);
            }
        }));
        getMViewModel().s().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.order_detail.OrderDetailActivity$initStatusChange$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                wd6 wd6Var = wd6.f20422a;
                OrderDetailActivity orderDetailActivity = this.this$0;
                String strN0 = orderDetailActivity.n0();
                Intrinsics.checkNotNullExpressionValue(strN0, "orderNo");
                wd6Var.b(orderDetailActivity, strN0, 3);
            }
        }));
    }

    public final void w0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_order_detail_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ud6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderDetailActivity.x0(this.f45121a, view);
            }
        }));
    }
}
