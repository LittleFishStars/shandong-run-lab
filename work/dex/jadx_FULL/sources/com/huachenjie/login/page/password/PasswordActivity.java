package com.huachenjie.login.page.password;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.databinding.LoginActivityPasswordBinding;
import com.huachenjie.login.util.LoginUtil;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.vm6;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\rB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/login/page/password/PasswordActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityPasswordBinding;", "Lcom/huachenjie/login/page/password/PasswordVM;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "", "b", "Lkotlin/Lazy;", "c0", "()Ljava/lang/String;", "loginPhone", "<init>", "()V", "a", "login_release"}, k = 1, mv = {1, 8, 0})
public final class PasswordActivity extends BaseMVVMActivity<LoginActivityPasswordBinding, PasswordVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "loginPhone";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy loginPhone = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.password.PasswordActivity$loginPhone$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("loginPhone")) == null) ? "" : stringExtra;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/login/page/password/PasswordActivity$a;", "", "Landroid/view/View;", "view", "", "a", "b", "c", "<init>", "(Lcom/huachenjie/login/page/password/PasswordActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PasswordActivity.this.finish();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (TextUtils.isEmpty(PasswordActivity.b0(PasswordActivity.this).l().getValue())) {
                fv5.a(R.string.login_input_password_empty);
                return;
            }
            PasswordVM passwordVMB0 = PasswordActivity.b0(PasswordActivity.this);
            String strC0 = PasswordActivity.this.c0();
            Intrinsics.checkNotNullExpressionValue(strC0, "loginPhone");
            passwordVMB0.n(strC0, null);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SetPasswordActivity.Companion companion = SetPasswordActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            String strC0 = PasswordActivity.this.c0();
            Intrinsics.checkNotNullExpressionValue(strC0, "loginPhone");
            companion.a(context, strC0, true);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.password.PasswordActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/login/page/password/PasswordActivity$b;", "", "Landroid/content/Context;", "context", "", "loginPhone", "", "a", "LOGIN_PHONE", "Ljava/lang/String;", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String loginPhone) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(loginPhone, "loginPhone");
            Intent intent = new Intent(context, (Class<?>) PasswordActivity.class);
            intent.putExtra("loginPhone", loginPhone);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34729a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34729a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34729a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34729a.invoke(obj);
        }
    }

    public static final /* synthetic */ PasswordVM b0(PasswordActivity passwordActivity) {
        return passwordActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().m().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.PasswordActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                EditText editText = this.this$0.getMBinding().f34647a;
                Intrinsics.checkNotNullExpressionValue(bool, "show");
                vm6.a(editText, bool.booleanValue());
            }
        }));
        getMViewModel().i().observe(this, new c(new Function1<LoginResultData, Unit>() { // from class: com.huachenjie.login.page.password.PasswordActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginResultData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LoginResultData loginResultData) {
                LoginUtil loginUtil = LoginUtil.f34754a;
                PasswordActivity passwordActivity = this.this$0;
                PasswordVM passwordVMB0 = PasswordActivity.b0(passwordActivity);
                Intrinsics.checkNotNullExpressionValue(loginResultData, o.f);
                loginUtil.b(passwordActivity, passwordVMB0, loginResultData);
            }
        }));
        getMViewModel().k().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.PasswordActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                this.this$0.finish();
            }
        }));
        getMViewModel().j().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.PasswordActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    CaptchaDialog.Companion companion = CaptchaDialog.INSTANCE;
                    FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    final PasswordActivity passwordActivity = this.this$0;
                    companion.a(supportFragmentManager, new Function1<String, Unit>() { // from class: com.huachenjie.login.page.password.PasswordActivity$initDataObserve$4.1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable String str) {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            PasswordVM passwordVMB0 = PasswordActivity.b0(passwordActivity);
                            String strC0 = passwordActivity.c0();
                            Intrinsics.checkNotNullExpressionValue(strC0, "loginPhone");
                            passwordVMB0.n(strC0, str);
                        }
                    });
                }
            }
        }));
    }

    public final String c0() {
        return (String) this.loginPhone.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_password;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getMViewModel().m().setValue(Boolean.FALSE);
    }
}
