package com.huachenjie.mall.page.check_order;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.TradeBaseInfo;
import com.huachenjie.mall.bean.TradeOrderResult;
import com.huachenjie.mall.databinding.MallActivityCheckOrderBinding;
import com.huachenjie.mall.dialog.pay.PayDialog;
import com.huachenjie.mall.dialog.pay_points.PayPointsDialog;
import com.huachenjie.mall.page.address.ShippingAddressActivity;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.pay.RewardPaySucActivity;
import com.huachenjie.mall.page.redeem_points.RedeemPointsResultActivity;
import com.huachenjie.mall.utils.RewardOrderHelp;
import com.igexin.push.g.o;
import com.zj.adlib.ar6;
import com.zj.adlib.hk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002('B\u0007¢\u0006\u0004\b%\u0010&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\nH\u0002R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018¨\u0006)"}, d2 = {"Lcom/huachenjie/mall/page/check_order/CheckOrderActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityCheckOrderBinding;", "Lcom/huachenjie/mall/page/check_order/CheckOrderVM;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "j0", "", "b", "Lkotlin/Lazy;", "i0", "()Ljava/lang/String;", "traceNo", "c", "h0", "source", "", "d", "g0", "()Z", "fromReward", "e", "f0", "exchangeCode", "<init>", "()V", "a", "ClickProxy", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CheckOrderActivity extends BaseMVVMActivity<MallActivityCheckOrderBinding, CheckOrderVM> implements AdCancelInterface {
    public static final int K = 1101;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "result_refresh";

    @NotNull
    public static final String x = "sku_no";

    @NotNull
    public static final String y = "goods_unit_price";

    @NotNull
    public static final String z = "goods_count";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy traceNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$traceNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("traceNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy source = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$source$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("source");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromReward = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$fromReward$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m500invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra("fromReward", false));
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy exchangeCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$exchangeCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("exchangeCode");
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/check_order/CheckOrderActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "a", "c", "<init>", "(Lcom/huachenjie/mall/page/check_order/CheckOrderActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OrderRemarkDialog.Companion bVar = OrderRemarkDialog.INSTANCE;
            String value = CheckOrderActivity.c0(CheckOrderActivity.this).p().getValue();
            if (value == null) {
                value = "";
            }
            final CheckOrderActivity checkOrderActivity = CheckOrderActivity.this;
            OrderRemarkDialog orderRemarkDialogA = bVar.a(value, new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$ClickProxy$clickRemark$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    CheckOrderActivity.c0(checkOrderActivity).p().setValue(str);
                }
            });
            FragmentManager supportFragmentManager = CheckOrderActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            orderRemarkDialogA.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(OrderRemarkDialog.class).getSimpleName());
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressActivity.Companion companion = ShippingAddressActivity.INSTANCE;
            CheckOrderActivity checkOrderActivity = CheckOrderActivity.this;
            companion.a(checkOrderActivity, CheckOrderActivity.c0(checkOrderActivity).l().getValue(), 1101);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (CheckOrderActivity.c0(CheckOrderActivity.this).l().getValue() == null || CheckOrderActivity.c0(CheckOrderActivity.this).r().getValue() == null) {
                return;
            }
            TradeBaseInfo value = CheckOrderActivity.c0(CheckOrderActivity.this).r().getValue();
            Intrinsics.checkNotNull(value);
            if (value.getPayFlag()) {
                CheckOrderActivity.c0(CheckOrderActivity.this).y(CheckOrderActivity.this.h0(), CheckOrderActivity.this.i0(), CheckOrderActivity.this.f0());
                return;
            }
            PayPointsDialog.Companion companion = PayPointsDialog.INSTANCE;
            FragmentManager supportFragmentManager = CheckOrderActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            TradeBaseInfo value2 = CheckOrderActivity.c0(CheckOrderActivity.this).r().getValue();
            Intrinsics.checkNotNull(value2);
            int payPointsTotal = value2.getTotalPrice().getPayPointsTotal();
            final CheckOrderActivity checkOrderActivity = CheckOrderActivity.this;
            companion.a(supportFragmentManager, payPointsTotal, new Function0<Unit>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$ClickProxy$clickSubmitOrder$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m498invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m498invoke() {
                    CheckOrderActivity.c0(checkOrderActivity).y(checkOrderActivity.h0(), checkOrderActivity.i0(), checkOrderActivity.f0());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.check_order.CheckOrderActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/check_order/CheckOrderActivity$a;", "", "Landroid/content/Context;", "context", "", "skuNo", "goodsUnitPrice", "", "goodsCount", "traceNo", "source", "", "fromReward", "exchangeCode", "Landroid/content/Intent;", "a", "ADDRESS_REQUEST_CODE", "I", "KEY_GOODS_COUNT", "Ljava/lang/String;", "KEY_GOODS_UNIT_PRICE", "KEY_SKU_NO", "RESULT_REFRESH", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String skuNo, @NotNull String goodsUnitPrice, int goodsCount, @NotNull String traceNo, @NotNull String source, boolean fromReward, @Nullable String exchangeCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuNo, "skuNo");
            Intrinsics.checkNotNullParameter(goodsUnitPrice, "goodsUnitPrice");
            Intrinsics.checkNotNullParameter(traceNo, "traceNo");
            Intrinsics.checkNotNullParameter(source, "source");
            Intent intent = new Intent(context, (Class<?>) CheckOrderActivity.class);
            intent.putExtra(CheckOrderActivity.x, skuNo);
            intent.putExtra(CheckOrderActivity.y, goodsUnitPrice);
            intent.putExtra(CheckOrderActivity.z, goodsCount);
            intent.putExtra("traceNo", traceNo);
            intent.putExtra("source", source);
            intent.putExtra("fromReward", fromReward);
            intent.putExtra("exchangeCode", exchangeCode);
            return intent;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35146a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35146a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35146a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35146a.invoke(obj);
        }
    }

    public static final /* synthetic */ CheckOrderVM c0(CheckOrderActivity checkOrderActivity) {
        return checkOrderActivity.getMViewModel();
    }

    public static final void k0(CheckOrderActivity checkOrderActivity, View view) {
        Intrinsics.checkNotNullParameter(checkOrderActivity, "this$0");
        checkOrderActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().s().observe(this, new b(new Function1<TradeOrderResult, Unit>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TradeOrderResult) obj);
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
            public final void invoke(TradeOrderResult tradeOrderResult) {
                TradeBaseInfo value = CheckOrderActivity.c0(this.this$0).r().getValue();
                Intrinsics.checkNotNull(value);
                if (!value.getPayFlag()) {
                    RedeemPointsResultActivity.INSTANCE.a(this.this$0);
                    this.this$0.finish();
                    return;
                }
                if (this.this$0.g0()) {
                    RewardOrderHelp rewardOrderHelp = RewardOrderHelp.f35274a;
                    CheckOrderActivity checkOrderActivity = this.this$0;
                    String orderNo = tradeOrderResult.getOrderNo();
                    String strF0 = this.this$0.f0();
                    if (strF0 == null) {
                        strF0 = "";
                    }
                    rewardOrderHelp.b(checkOrderActivity, orderNo, strF0);
                }
                if (this.this$0.g0()) {
                    TradeBaseInfo value2 = CheckOrderActivity.c0(this.this$0).r().getValue();
                    Intrinsics.checkNotNull(value2);
                    if (Float.parseFloat(value2.getTotalPrice().getOrderAmount()) <= 0.0f) {
                        RewardPaySucActivity.INSTANCE.a(this.this$0, true, tradeOrderResult.getOrderNo());
                        this.this$0.finish();
                        return;
                    }
                }
                PayDialog.Companion companion = PayDialog.INSTANCE;
                CheckOrderActivity checkOrderActivity2 = this.this$0;
                TradeBaseInfo value3 = CheckOrderActivity.c0(checkOrderActivity2).r().getValue();
                Intrinsics.checkNotNull(value3);
                String orderAmount = value3.getTotalPrice().getOrderAmount();
                String tradeNo = tradeOrderResult.getTradeNo();
                int payRemainTime = tradeOrderResult.getPayRemainTime();
                String orderNo2 = tradeOrderResult.getOrderNo();
                TradeBaseInfo value4 = CheckOrderActivity.c0(this.this$0).r().getValue();
                Intrinsics.checkNotNull(value4);
                companion.b(checkOrderActivity2, orderAmount, tradeNo, payRemainTime, orderNo2, value4.getGoodsInfo().getShopNo(), this.this$0.g0());
            }
        }));
        getMViewModel().o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    CheckOrderActivity checkOrderActivity = this.this$0;
                    Intent intent = new Intent();
                    intent.putExtra(CheckOrderActivity.t, true);
                    Unit unit = Unit.INSTANCE;
                    checkOrderActivity.setResult(-1, intent);
                }
            }
        }));
    }

    public final String f0() {
        return (String) this.exchangeCode.getValue();
    }

    public final boolean g0() {
        return ((Boolean) this.fromReward.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_check_order;
    }

    public final String h0() {
        return (String) this.source.getValue();
    }

    public final String i0() {
        return (String) this.traceNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().m().setValue(Integer.valueOf(getIntent().getIntExtra(z, 1)));
        CheckOrderVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra(x);
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.x(stringExtra);
        CheckOrderVM mViewModel2 = getMViewModel();
        String stringExtra2 = getIntent().getStringExtra(y);
        mViewModel2.w(stringExtra2 != null ? stringExtra2 : "");
        getMViewModel().v();
        getMViewModel().t();
        getMViewModel().u();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(ar6.E);
        j0();
    }

    public final void j0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName("确认订单");
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(titleName.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckOrderActivity.k0(this.f45366a, view);
            }
        }));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1101 && resultCode == -1 && data != null) {
            getMViewModel().l().setValue(data.getParcelableExtra("selectedAddress"));
            getMViewModel().u();
        }
    }
}
