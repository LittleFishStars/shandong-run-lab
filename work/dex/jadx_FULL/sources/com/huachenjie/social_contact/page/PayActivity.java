package com.huachenjie.social_contact.page;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.PayResult;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.pay.receiver.WechatPayReceiver;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.PayBean;
import com.huachenjie.social_contact.databinding.ActivityPayBinding;
import com.huachenjie.social_contact.dialog.BuySuccessDialog;
import com.huachenjie.social_contact.vm.PayVM;
import com.igexin.push.g.o;
import com.zj.adlib.av3;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.it9;
import com.zj.adlib.ln6;
import com.zj.adlib.nk0;
import com.zj.adlib.su9;
import com.zj.adlib.uj1;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.i)
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u0007H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/page/PayActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/vm/PayVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "init", "initViewModel", "finish", "Lcom/huachenjie/social_contact/bean/PayBean;", "a", "Lcom/huachenjie/social_contact/bean/PayBean;", UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, "Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "mReceiver", "com/huachenjie/social_contact/page/PayActivity$b", "Lcom/huachenjie/social_contact/page/PayActivity$b;", "mHandler", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class PayActivity extends BaseVmActivity<PayVM> {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = UserConstants.SOCIAL_CONTACT_PARAMS.f33737a)
    @JvmField
    @Nullable
    public PayBean payBean;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final WechatPayReceiver mReceiver = new WechatPayReceiver(new c());

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public b mHandler = new b(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/page/PayActivity$a;", "", "Landroid/view/View;", "v", "", "b", "c", "a", "d", "<init>", "(Lcom/huachenjie/social_contact/page/PayActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PayVM payVM = (PayVM) ((BaseVmActivity) PayActivity.this).f8507a;
            if (payVM != null) {
                payVM.n(2);
            }
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PayActivity.this.finish();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            su9.j(PayActivity.this.getContext(), "6");
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!uj1.c(PayActivity.this)) {
                fv5.b("微信客户端未安装");
                return;
            }
            PayVM payVM = (PayVM) ((BaseVmActivity) PayActivity.this).f8507a;
            if (payVM != null) {
                payVM.n(1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/PayActivity$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "dispatchMessage", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            PayActivity payActivity = PayActivity.this;
            if (msg.what == 200) {
                ((PayVM) ((BaseVmActivity) payActivity).f8507a).j();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/PayActivity$c", "Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;", "", "code", "", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements WechatPayReceiver.WechatPayCallback {
        public c() {
        }

        @Override // com.huachenjie.pay.receiver.WechatPayReceiver.WechatPayCallback
        public void a(int code) {
            ((PayVM) ((BaseVmActivity) PayActivity.this).f8507a).l();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36218a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36218a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36218a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36218a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.PayActivity$initViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", o.f, "Lcom/huachenjie/common/bean/PayResult;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 extends Lambda implements Function1<PayResult, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(ActivityPayBinding activityPayBinding, final PayActivity payActivity, PayResult payResult) {
            Intrinsics.checkNotNullParameter(activityPayBinding, "$mBinding");
            Intrinsics.checkNotNullParameter(payActivity, "this$0");
            activityPayBinding.f36089a.setVisibility(8);
            FragmentManager supportFragmentManager = payActivity.getSupportFragmentManager();
            BuySuccessDialog buySuccessDialogA = BuySuccessDialog.INSTANCE.a(payResult.getStarDrill());
            buySuccessDialogA.setFragmentDialogDismissCallback(new BaseDialogFragment.FragmentDialogDismissCallback() { // from class: com.huachenjie.social_contact.page.d
                @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment.FragmentDialogDismissCallback
                public final void onDismiss() {
                    PayActivity.AnonymousClass3.invoke$lambda$3$lambda$2$lambda$1(payActivity);
                }
            });
            buySuccessDialogA.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(BuySuccessDialog.class).getSimpleName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$2$lambda$1(final PayActivity payActivity) {
            Intrinsics.checkNotNullParameter(payActivity, "this$0");
            av3 av3Var = av3.f15400a;
            FragmentManager supportFragmentManager = payActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            av3Var.m(3, supportFragmentManager, new View.OnClickListener() { // from class: com.huachenjie.social_contact.page.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayActivity.AnonymousClass3.invoke$lambda$3$lambda$2$lambda$1$lambda$0(payActivity, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$2$lambda$1$lambda$0(PayActivity payActivity, View view) {
            Intrinsics.checkNotNullParameter(payActivity, "this$0");
            payActivity.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$4(PayActivity payActivity, View view) {
            Intrinsics.checkNotNullParameter(payActivity, "this$0");
            payActivity.finish();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PayResult) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(final PayResult payResult) {
            if (payResult.getPayStatus() != 1) {
                ((PayVM) ((BaseVmActivity) PayActivity.this).f8507a).t().setValue(Boolean.TRUE);
                return;
            }
            fv5.b("支付成功");
            ViewDataBinding binding = PayActivity.this.getBinding();
            Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivityPayBinding");
            final ActivityPayBinding activityPayBinding = (ActivityPayBinding) binding;
            activityPayBinding.f12736a.setVisibility(8);
            PayBean payBean = PayActivity.this.payBean;
            if (payBean != null && payBean.getType() == 1) {
                try {
                    ActivityLifecycleManager.l().f(RechargeActivity.class);
                } catch (Exception unused) {
                }
                activityPayBinding.f36089a.setVisibility(0);
                FrameLayout frameLayout = activityPayBinding.f36089a;
                final PayActivity payActivity = PayActivity.this;
                frameLayout.postDelayed(new Runnable() { // from class: com.huachenjie.social_contact.page.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        PayActivity.AnonymousClass3.invoke$lambda$3(activityPayBinding, payActivity, payResult);
                    }
                }, 500L);
                return;
            }
            PayBean payBean2 = PayActivity.this.payBean;
            if (payBean2 != null && payBean2.getType() == 2) {
                try {
                    ActivityLifecycleManager.l().f(SuperPackActivity.class);
                } catch (Exception unused2) {
                }
                av3 av3Var = av3.f15400a;
                FragmentManager supportFragmentManager = PayActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                final PayActivity payActivity2 = PayActivity.this;
                av3Var.m(3, supportFragmentManager, new View.OnClickListener() { // from class: com.huachenjie.social_contact.page.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PayActivity.AnonymousClass3.invoke$lambda$4(payActivity2, view);
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_pay), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivityPayBinding");
        ((ActivityPayBinding) binding).f36089a.setVisibility(8);
        PayBean payBean = this.payBean;
        if (payBean != null) {
            PayVM payVM = (PayVM) ((BaseVmActivity) this).f8507a;
            MutableLiveData<PayBean> mutableLiveDataQ = payVM != null ? payVM.q() : null;
            if (mutableLiveDataQ == null) {
                return;
            }
            mutableLiveDataQ.setValue(payBean);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((PayVM) ((BaseVmActivity) this).f8507a).r().observe(this, new d(new Function1<String, Unit>() { // from class: com.huachenjie.social_contact.page.PayActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PayActivity payActivity = PayActivity.this;
                b bVar = payActivity.mHandler;
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                ln6.b(payActivity, bVar, str);
            }
        }));
        ((PayVM) ((BaseVmActivity) this).f8507a).s().observe(this, new d(new Function1<String, Unit>() { // from class: com.huachenjie.social_contact.page.PayActivity.initViewModel.2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                ln6.g(str, it9.n(), it9.a.m());
            }
        }));
        ((PayVM) ((BaseVmActivity) this).f8507a).u().observe(this, new d(new AnonymousClass3()));
        ((PayVM) ((BaseVmActivity) this).f8507a).t().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.PayActivity.initViewModel.4
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
                    AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                    alertDataBean.setTitle("支付失败");
                    alertDataBean.setContent("若您已完成支付，请联系客服处理。");
                    alertDataBean.setConfirm("我知道了");
                    alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
                    AlertDialog.INSTANCE.a(alertDataBean).show(PayActivity.this.getSupportFragmentManager(), "PAY_FAILED_ALERT");
                    ((PayVM) ((BaseVmActivity) PayActivity.this).f8507a).t().setValue(Boolean.FALSE);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(savedInstanceState);
        av3.f15400a.h();
        ln6.f18003a.d(this, this.mReceiver);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ln6.f18003a.f(this, this.mReceiver);
        super.onDestroy();
    }
}
