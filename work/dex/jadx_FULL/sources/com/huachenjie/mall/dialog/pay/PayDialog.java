package com.huachenjie.mall.dialog.pay;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alipay.sdk.m.m.b;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MallPaySwitchConfig;
import com.huachenjie.mall.bean.OrderPayBean;
import com.huachenjie.mall.databinding.MallDialogPayBinding;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.pay.LklWebViewActivity;
import com.huachenjie.mall.page.pay.PayResultActivity;
import com.huachenjie.mall.page.pay.RewardPaySucActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.uj1;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002*)B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001b\u0010#\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/huachenjie/mall/dialog/pay/PayDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogPayBinding;", "Lcom/huachenjie/mall/dialog/pay/PayVM;", "", "observeOrderPay", "observeTradeStatus", "", UserTrackConstant.IS_SUCCESS, "goPayResultActivity", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "initData", "onResume", "initDataObserve", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "isCheckOrder$delegate", "Lkotlin/Lazy;", "isCheckOrder", "()Z", "fromAppOrder$delegate", "getFromAppOrder", PayDialog.KEY_FROM_APP_ORDER, "fromReward$delegate", "getFromReward", "fromReward", "Lkotlin/Function1;", "payResultCallback", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PayDialog extends BaseMVVMBottomDialogFragment<MallDialogPayBinding, PayVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_FROM_APP_ORDER = "fromAppOrder";

    @NotNull
    private static final String KEY_GOODS_FROM_REWARD = "fromReward";

    @NotNull
    private static final String KEY_IS_CHECK_ORDER = "is_check_order";

    @NotNull
    private static final String KEY_ORDER_NO = "order_no";

    @NotNull
    private static final String KEY_PAY_REMAIN_TIME = "pay_remain_time";

    @NotNull
    private static final String KEY_PAY_SWITCH = "pay_switch";

    @NotNull
    private static final String KEY_PRICE = "price";

    @NotNull
    private static final String KEY_TRADE_NO = "trade_no";
    public static final int PAY_RESULT_NONE = 0;
    public static final int PAY_RESULT_SUC = 1;
    public static final int PAY_RESULT_WAIT = 2;

    /* JADX INFO: renamed from: isCheckOrder$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isCheckOrder = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog.isCheckOrder.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m471invoke() {
            Bundle arguments = PayDialog.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(PayDialog.KEY_IS_CHECK_ORDER) : false);
        }
    });

    /* JADX INFO: renamed from: fromAppOrder$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fromAppOrder = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog$fromAppOrder$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m469invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("fromAppOrder") : false);
        }
    });

    /* JADX INFO: renamed from: fromReward$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fromReward = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog$fromReward$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m470invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("fromReward") : false);
        }
    });

    @NotNull
    private Function1<? super Integer, Unit> payResultCallback = new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog$payResultCallback$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
        }
    };

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJJ\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u000fJl\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fJ,\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000fH\u0002R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006'"}, d2 = {"Lcom/huachenjie/mall/dialog/pay/PayDialog$Companion;", "", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", PayDialog.KEY_PRICE, "tradeNo", "", "payRemainTime", "orderNo", "shopNo", "", "fromReward", "", "b", "Lkotlin/Function1;", "resultCallback", "c", PayDialog.KEY_FROM_APP_ORDER, "onDismiss", "d", "Lcom/huachenjie/mall/bean/MallPaySwitchConfig;", RenderCallContext.TYPE_CALLBACK, "a", "KEY_FROM_APP_ORDER", "Ljava/lang/String;", "KEY_GOODS_FROM_REWARD", "KEY_IS_CHECK_ORDER", "KEY_ORDER_NO", "KEY_PAY_REMAIN_TIME", "KEY_PAY_SWITCH", "KEY_PRICE", "KEY_TRADE_NO", "PAY_RESULT_NONE", "I", "PAY_RESULT_SUC", "PAY_RESULT_WAIT", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(Companion companion, FragmentActivity fragmentActivity, String str, String str2, int i, String str3, String str4, boolean z, Function1 function1, Function1 function2, int i2, Object obj) {
            companion.d(fragmentActivity, str, str2, i, str3, str4, (i2 & 64) != 0 ? false : z, function1, (i2 & 256) != 0 ? null : function2);
        }

        public final void a(FragmentActivity activity, String shopNo, Function1<? super MallPaySwitchConfig, Unit> callback) {
            Dialog dialogM = DialogUtil.m(activity);
            CoroutineExtKt.c(CoroutineExtKt.a(this), false, new PayDialog$Companion$loadPayChannel$1(dialogM, null), null, new PayDialog$Companion$loadPayChannel$2(dialogM, callback, shopNo, null), 5, null);
        }

        public final void b(@NotNull final FragmentActivity activity, @NotNull final String price, @NotNull final String tradeNo, final int payRemainTime, @NotNull final String orderNo, @NotNull String shopNo, final boolean fromReward) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            Intrinsics.checkNotNullParameter(price, PayDialog.KEY_PRICE);
            Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intrinsics.checkNotNullParameter(shopNo, "shopNo");
            a(activity, shopNo, new Function1<MallPaySwitchConfig, Unit>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog$Companion$showCheckOrderPay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MallPaySwitchConfig) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull MallPaySwitchConfig mallPaySwitchConfig) {
                    Intrinsics.checkNotNullParameter(mallPaySwitchConfig, o.f);
                    PayDialog payDialog = new PayDialog();
                    String str = price;
                    String str2 = tradeNo;
                    int i = payRemainTime;
                    String str3 = orderNo;
                    boolean z = fromReward;
                    Bundle bundle = new Bundle();
                    bundle.putString("price", str);
                    bundle.putString(b.B0, str2);
                    bundle.putInt("pay_remain_time", i);
                    bundle.putString("order_no", str3);
                    bundle.putParcelable("pay_switch", mallPaySwitchConfig);
                    bundle.putBoolean("is_check_order", true);
                    bundle.putBoolean("fromReward", z);
                    payDialog.setArguments(bundle);
                    FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                    payDialog.show(supportFragmentManager, "PayDialog");
                }
            });
        }

        public final void c(@NotNull FragmentActivity activity, @NotNull String price, @NotNull String tradeNo, int payRemainTime, @NotNull String orderNo, @NotNull String shopNo, @NotNull Function1<? super Integer, Unit> resultCallback) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            Intrinsics.checkNotNullParameter(price, PayDialog.KEY_PRICE);
            Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intrinsics.checkNotNullParameter(shopNo, "shopNo");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            e(this, activity, price, tradeNo, payRemainTime, orderNo, shopNo, true, resultCallback, null, 256, null);
        }

        public final void d(@NotNull final FragmentActivity activity, @NotNull final String price, @NotNull final String tradeNo, final int payRemainTime, @NotNull final String orderNo, @NotNull String shopNo, final boolean fromAppOrder, @NotNull final Function1<? super Integer, Unit> resultCallback, @Nullable final Function1<? super Integer, Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            Intrinsics.checkNotNullParameter(price, PayDialog.KEY_PRICE);
            Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intrinsics.checkNotNullParameter(shopNo, "shopNo");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            a(activity, shopNo, new Function1<MallPaySwitchConfig, Unit>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog$Companion$showPayWithResult$1

                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/mall/dialog/pay/PayDialog$Companion$showPayWithResult$1$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "mall_release"}, k = 1, mv = {1, 8, 0})
                public static final class a implements BaseDialogFragment.DialogFragmentListener {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ PayDialog f35108a;

                    /* JADX INFO: renamed from: a, reason: collision with other field name */
                    public final /* synthetic */ Function1<Integer, Unit> f11094a;

                    /* JADX WARN: Multi-variable type inference failed */
                    public a(Function1<? super Integer, Unit> function1, PayDialog payDialog) {
                        this.f11094a = function1;
                        this.f35108a = payDialog;
                    }

                    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
                    public void onDismiss() {
                        Function1<Integer, Unit> function1 = this.f11094a;
                        if (function1 != null) {
                            Integer value = PayDialog.access$getMViewModel(this.f35108a).s().getValue();
                            if (value == null) {
                                value = 0;
                            }
                            function1.invoke(value);
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MallPaySwitchConfig) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull MallPaySwitchConfig mallPaySwitchConfig) {
                    Intrinsics.checkNotNullParameter(mallPaySwitchConfig, o.f);
                    PayDialog payDialog = new PayDialog();
                    Function1<Integer, Unit> function1 = resultCallback;
                    String str = price;
                    String str2 = tradeNo;
                    int i = payRemainTime;
                    String str3 = orderNo;
                    boolean z = fromAppOrder;
                    Function1<Integer, Unit> function2 = onDismiss;
                    Bundle bundle = new Bundle();
                    bundle.putString("price", str);
                    bundle.putString(b.B0, str2);
                    bundle.putInt("pay_remain_time", i);
                    bundle.putString("order_no", str3);
                    bundle.putParcelable("pay_switch", mallPaySwitchConfig);
                    bundle.putBoolean("fromAppOrder", z);
                    payDialog.setArguments(bundle);
                    payDialog.payResultCallback = function1;
                    payDialog.setDialogFragmentListener(new a(function2, payDialog));
                    FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                    payDialog.show(supportFragmentManager, "PayDialog");
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/dialog/pay/PayDialog$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/dialog/pay/PayDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            PayDialog.this.dismiss();
        }

        public final void b(@Nullable View v) {
            RadioGroup radioGroup;
            Boolean value = PayDialog.access$getMViewModel(PayDialog.this).p().getValue();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool) && Intrinsics.areEqual(PayDialog.access$getMViewModel(PayDialog.this).q().getValue(), bool)) {
                return;
            }
            MallDialogPayBinding mallDialogPayBindingAccess$getMBinding = PayDialog.access$getMBinding(PayDialog.this);
            Integer numValueOf = (mallDialogPayBindingAccess$getMBinding == null || (radioGroup = mallDialogPayBindingAccess$getMBinding.f10602a) == null) ? null : Integer.valueOf(radioGroup.getCheckedRadioButtonId());
            int i = R.id.rb_ali;
            if (numValueOf != null && numValueOf.intValue() == i) {
                PayDialog.access$getMViewModel(PayDialog.this).t(2);
                return;
            }
            int i2 = R.id.rb_wx;
            if (numValueOf != null && numValueOf.intValue() == i2) {
                if (uj1.c(PayDialog.this.requireContext())) {
                    PayDialog.access$getMViewModel(PayDialog.this).t(1);
                } else {
                    fv5.b("微信客户端未安装");
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35110a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35110a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35110a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35110a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MallDialogPayBinding access$getMBinding(PayDialog payDialog) {
        return (MallDialogPayBinding) payDialog.getMBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PayVM access$getMViewModel(PayDialog payDialog) {
        return (PayVM) payDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFromAppOrder() {
        return ((Boolean) this.fromAppOrder.getValue()).booleanValue();
    }

    private final boolean getFromReward() {
        return ((Boolean) this.fromReward.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goPayResultActivity(boolean isSuccess) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("order_no")) == null) {
            return;
        }
        if (!isSuccess) {
            OrderDetailActivity.Companion companion = OrderDetailActivity.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.a(contextRequireContext, string);
        } else if (getFromReward()) {
            RewardPaySucActivity.Companion bVar = RewardPaySucActivity.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            bVar.a(contextRequireContext2, true, string);
        } else {
            PayResultActivity.Companion bVar2 = PayResultActivity.INSTANCE;
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            bVar2.a(contextRequireContext3, true, string);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCheckOrder() {
        return ((Boolean) this.isCheckOrder.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void observeOrderPay() {
        ((PayVM) getMViewModel()).n().observe(this, new b(new Function1<OrderPayBean, Unit>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog.observeOrderPay.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OrderPayBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OrderPayBean orderPayBean) {
                LklWebViewActivity.Companion aVar = LklWebViewActivity.INSTANCE;
                Context contextRequireContext = PayDialog.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                aVar.a(contextRequireContext, orderPayBean.getGatewayUrl());
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void observeTradeStatus() {
        ((PayVM) getMViewModel()).s().observe(this, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.dialog.pay.PayDialog.observeTradeStatus.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    fv5.a(R.string.mall_my_order_pay_retry);
                } else if (num.intValue() == 2) {
                    fv5.a(R.string.mall_my_order_paying);
                }
                if (PayDialog.this.isCheckOrder()) {
                    PayDialog.this.goPayResultActivity(num.intValue() == 1);
                    return;
                }
                if (!PayDialog.this.getFromAppOrder()) {
                    PayDialog.this.payResultCallback.invoke(num);
                    PayDialog.this.dismiss();
                } else if (num.intValue() == 1 || num.intValue() == 2) {
                    PayDialog.this.payResultCallback.invoke(num);
                    PayDialog.this.dismiss();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_pay;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String string;
        RadioGroup radioGroup;
        String string2;
        super.initData();
        MutableLiveData<String> mutableLiveDataO = ((PayVM) getMViewModel()).o();
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString(KEY_PRICE)) == null) {
            string = "";
        }
        mutableLiveDataO.setValue(string);
        MutableLiveData<String> mutableLiveDataR = ((PayVM) getMViewModel()).r();
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string2 = arguments2.getString("trade_no")) != null) {
            str = string2;
        }
        mutableLiveDataR.setValue(str);
        Bundle arguments3 = getArguments();
        MallPaySwitchConfig mallPaySwitchConfig = arguments3 != null ? (MallPaySwitchConfig) arguments3.getParcelable(KEY_PAY_SWITCH) : null;
        ((PayVM) getMViewModel()).p().setValue(mallPaySwitchConfig != null ? Boolean.valueOf(mallPaySwitchConfig.showAliPay()) : Boolean.TRUE);
        ((PayVM) getMViewModel()).q().setValue(mallPaySwitchConfig != null ? Boolean.valueOf(mallPaySwitchConfig.showWXPay()) : Boolean.TRUE);
        MallDialogPayBinding mallDialogPayBinding = (MallDialogPayBinding) getMBinding();
        if (mallDialogPayBinding == null || (radioGroup = mallDialogPayBinding.f10602a) == null) {
            return;
        }
        radioGroup.check(Intrinsics.areEqual(((PayVM) getMViewModel()).p().getValue(), Boolean.TRUE) ? R.id.rb_ali : R.id.rb_wx);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        observeOrderPay();
        observeTradeStatus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PayVM payVM = (PayVM) getMViewModel();
        Bundle arguments = getArguments();
        payVM.v(arguments != null ? arguments.getInt(KEY_PAY_REMAIN_TIME) : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (((PayVM) getMViewModel()).s().getValue() == null && isCheckOrder()) {
            goPayResultActivity(false);
        }
        super.onDismiss(dialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (((PayVM) getMViewModel()).n().getValue() != null) {
            ((PayVM) getMViewModel()).u();
        }
    }
}
