package com.huachenjie.login.page.account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginCheckData;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.databinding.LoginActivityAccountBinding;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.enums.LoginType;
import com.huachenjie.login.page.account.LoginAccountActivity;
import com.huachenjie.login.page.base.BaseLoginActivity;
import com.huachenjie.login.page.password.PasswordActivity;
import com.huachenjie.login.page.password.SetPasswordActivity;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.huachenjie.login.util.ProtocolUtil;
import com.huachenjie.login.util.SendVerifyCodeUtil;
import com.zj.adlib.fe7;
import com.zj.adlib.fv5;
import com.zj.adlib.zk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/login/page/account/LoginAccountActivity;", "Lcom/huachenjie/login/page/base/BaseLoginActivity;", "Lcom/huachenjie/login/databinding/LoginActivityAccountBinding;", "Lcom/huachenjie/login/page/account/LoginAccountVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", "", "l0", "<init>", "()V", "a", "b", "login_release"}, k = 1, mv = {1, 8, 0})
public final class LoginAccountActivity extends BaseLoginActivity<LoginActivityAccountBinding, LoginAccountVM> {
    public static final int K = 1;
    public static final int L = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "typeKey";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/huachenjie/login/page/account/LoginAccountActivity$a;", "Lcom/huachenjie/login/page/base/BaseLoginActivity$a;", "Lcom/huachenjie/login/page/base/BaseLoginActivity;", "Lcom/huachenjie/login/databinding/LoginActivityAccountBinding;", "Lcom/huachenjie/login/page/account/LoginAccountVM;", "Landroid/view/View;", "view", "", "m", "n", "<init>", "(Lcom/huachenjie/login/page/account/LoginAccountActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a extends BaseLoginActivity<LoginActivityAccountBinding, LoginAccountVM>.a {
        public a() {
            super();
        }

        public static final void o(LoginAccountActivity loginAccountActivity, View view) {
            Intrinsics.checkNotNullParameter(loginAccountActivity, "this$0");
            LoginAccountActivity.k0(loginAccountActivity).n();
        }

        public final void m(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoginAccountActivity.this.finish();
        }

        public final void n(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (LoginAccountActivity.this.l0()) {
                final LoginAccountActivity loginAccountActivity = LoginAccountActivity.this;
                if (BaseLoginActivity.h0(loginAccountActivity, null, null, new View.OnClickListener() { // from class: com.zj.adlib.j25
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LoginAccountActivity.a.o(loginAccountActivity, view2);
                    }
                }, 3, null)) {
                    LoginAccountActivity.k0(LoginAccountActivity.this).n();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.account.LoginAccountActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/login/page/account/LoginAccountActivity$b;", "", "Landroid/content/Context;", "context", "", "type", "", PerfId.startActivity, "", "TYPE_KEY", "Ljava/lang/String;", "TYPE_PASSWORD", "I", "TYPE_SMS_CODE", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) LoginAccountActivity.class);
            intent.putExtra(LoginAccountActivity.t, type);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34696a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34696a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34696a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34696a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LoginAccountVM k0(LoginAccountActivity loginAccountActivity) {
        return (LoginAccountVM) loginAccountActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.login.page.base.BaseLoginActivity, com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        ((LoginAccountVM) getMViewModel()).p().observe(this, new c(new Function1<LoginCheckData, Unit>() { // from class: com.huachenjie.login.page.account.LoginAccountActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginCheckData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable LoginCheckData loginCheckData) {
                if (loginCheckData == null) {
                    return;
                }
                int loginType = loginCheckData.getLoginType();
                if (loginType == LoginType.SMS_CODE.getValue()) {
                    SendVerifyCodeUtil sendVerifyCodeUtil = SendVerifyCodeUtil.f34757a;
                    LoginAccountActivity loginAccountActivity = this.this$0;
                    LoginAccountVM loginAccountVMK0 = LoginAccountActivity.k0(loginAccountActivity);
                    String phone = loginCheckData.getPhone();
                    final LoginAccountActivity loginAccountActivity2 = this.this$0;
                    SendVerifyCodeUtil.k(sendVerifyCodeUtil, loginAccountActivity, loginAccountVMK0, phone, null, 0, new Function2<Boolean, VerifyCodeParams, Unit>() { // from class: com.huachenjie.login.page.account.LoginAccountActivity$initDataObserve$1.1
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke(((Boolean) obj).booleanValue(), (VerifyCodeParams) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z, @Nullable VerifyCodeParams verifyCodeParams) {
                            if (!z || verifyCodeParams == null) {
                                return;
                            }
                            VerifyCodeActivity.INSTANCE.a(loginAccountActivity2, verifyCodeParams, (124 & 4) != 0 ? LoginThirdType.None : null, (124 & 8) != 0 ? "" : null, (124 & 16) != 0 ? "" : null, (124 & 32) != 0 ? "" : null, (124 & 64) != 0 ? "" : null);
                        }
                    }, 24, null);
                    return;
                }
                if (loginType == LoginType.PASSWORD.getValue()) {
                    if (loginCheckData.getPasswordType() == 0) {
                        SetPasswordActivity.INSTANCE.a(this.this$0, loginCheckData.getPhone(), false);
                    } else {
                        PasswordActivity.INSTANCE.a(this.this$0, loginCheckData.getPhone());
                    }
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_account;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.login.page.base.BaseLoginActivity, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ((LoginAccountVM) getMViewModel()).q().setValue(Integer.valueOf(getIntent().getIntExtra(t, 1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
        TextView textView = ((LoginActivityAccountBinding) getMBinding()).f9915a.f10085a;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.layoutProtocol.tvProtocol");
        protocolUtil.f(textView, getString(R.string.login_protocol));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l0() {
        if (TextUtils.isEmpty(((LoginAccountVM) getMViewModel()).o().getValue())) {
            fv5.a(R.string.login_input_account_empty);
            return false;
        }
        boolean zA = fe7.f41654a.a(((LoginAccountVM) getMViewModel()).o().getValue());
        if (!zA) {
            fv5.a(R.string.login_input_account_error);
        }
        return zA;
    }
}
