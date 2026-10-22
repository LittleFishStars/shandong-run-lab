package com.huachenjie.login.page.welcome;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginCheckData;
import com.huachenjie.login.databinding.LoginActivityWecomeLoginBinding;
import com.huachenjie.login.page.account.LoginAccountActivity;
import com.huachenjie.login.page.base.BaseLoginActivity;
import com.huachenjie.login.page.password.PasswordActivity;
import com.huachenjie.login.page.password.SetPasswordActivity;
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.huachenjie.login.util.ProtocolUtil;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fe7;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.ys8;
import com.zj.adlib.zj7;
import com.zj.adlib.zk0;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = zj7.f.LOGIN)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/login/page/welcome/WelcomeLoginActivity;", "Lcom/huachenjie/login/page/base/BaseLoginActivity;", "Lcom/huachenjie/login/databinding/LoginActivityWecomeLoginBinding;", "Lcom/huachenjie/login/page/welcome/WelcomeLoginVM;", "", "", "", "V", "getLayoutResID", "", "onResume", "initView", "initData", "W", bo.g, "", "m0", "", "b", "Lkotlin/Lazy;", "o0", "()Ljava/lang/String;", "title", "c", "n0", "content", "<init>", "()V", "a", "login_release"}, k = 1, mv = {1, 8, 0})
public final class WelcomeLoginActivity extends BaseLoginActivity<LoginActivityWecomeLoginBinding, WelcomeLoginVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy title = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.welcome.WelcomeLoginActivity$title$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra("title");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy content = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.welcome.WelcomeLoginActivity$content$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra("content");
            }
            return null;
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/huachenjie/login/page/welcome/WelcomeLoginActivity$a;", "Lcom/huachenjie/login/page/base/BaseLoginActivity$a;", "Lcom/huachenjie/login/page/base/BaseLoginActivity;", "Lcom/huachenjie/login/databinding/LoginActivityWecomeLoginBinding;", "Lcom/huachenjie/login/page/welcome/WelcomeLoginVM;", "Landroid/view/View;", "view", "", j.b, "m", "<init>", "(Lcom/huachenjie/login/page/welcome/WelcomeLoginActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a extends BaseLoginActivity<LoginActivityWecomeLoginBinding, WelcomeLoginVM>.a {
        public a() {
            super();
        }

        public static final void n(WelcomeLoginActivity welcomeLoginActivity, View view) {
            Intrinsics.checkNotNullParameter(welcomeLoginActivity, "this$0");
            WelcomeLoginActivity.k0(welcomeLoginActivity).n();
        }

        public final void m(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (WelcomeLoginActivity.this.m0()) {
                final WelcomeLoginActivity welcomeLoginActivity = WelcomeLoginActivity.this;
                if (BaseLoginActivity.h0(welcomeLoginActivity, null, null, new View.OnClickListener() { // from class: com.zj.adlib.pv9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WelcomeLoginActivity.a.n(welcomeLoginActivity, view2);
                    }
                }, 3, null)) {
                    WelcomeLoginActivity.k0(WelcomeLoginActivity.this).n();
                }
            }
        }

        public final void o(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            WelcomeLoginActivity.this.startActivity(new Intent(view.getContext(), (Class<?>) LoginAccountActivity.class));
            WelcomeLoginActivity.this.setDealWeChatLogin(false);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34751a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34751a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34751a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34751a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ WelcomeLoginVM k0(WelcomeLoginActivity welcomeLoginActivity) {
        return (WelcomeLoginVM) welcomeLoginActivity.getMViewModel();
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
        ((WelcomeLoginVM) getMViewModel()).p().observe(this, new b(new Function1<LoginCheckData, Unit>() { // from class: com.huachenjie.login.page.welcome.WelcomeLoginActivity$initDataObserve$1
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
                if (loginCheckData.getPasswordType() == 0) {
                    SetPasswordActivity.INSTANCE.a(this.this$0, loginCheckData.getPhone(), false);
                } else {
                    PasswordActivity.INSTANCE.a(this.this$0, loginCheckData.getPhone());
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_wecome_login;
    }

    @Override // com.huachenjie.login.page.base.BaseLoginActivity, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        p0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
        TextView textView = ((LoginActivityWecomeLoginBinding) getMBinding()).f10059a.f10085a;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.layoutProtocol.tvProtocol");
        protocolUtil.f(textView, getString(R.string.login_protocol));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean m0() {
        if (TextUtils.isEmpty(((WelcomeLoginVM) getMViewModel()).o().getValue())) {
            fv5.a(R.string.login_input_account_empty);
            return false;
        }
        boolean zA = fe7.f41654a.a(((WelcomeLoginVM) getMViewModel()).o().getValue());
        if (!zA) {
            fv5.a(R.string.login_input_account_error);
        }
        return zA;
    }

    public final String n0() {
        return (String) this.content.getValue();
    }

    public final String o0() {
        return (String) this.title.getValue();
    }

    @Override // com.huachenjie.login.page.base.BaseLoginActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        setDealWeChatLogin(true);
    }

    public final void p0() {
        if (TextUtils.isEmpty(n0())) {
            return;
        }
        ft1.B(this, o0(), n0(), ys8.e(R.string.i_know));
    }
}
