package com.huachenjie.login.page.password;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.databinding.LoginActivityPasswordSetBinding;
import com.huachenjie.login.util.CountDownTimerHelper;
import com.huachenjie.login.util.LoginUtil;
import com.igexin.push.g.o;
import com.zj.adlib.vm6;
import com.zj.adlib.y6b;
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
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0007*\u0001%\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u001bB\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/huachenjie/login/page/password/SetPasswordActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityPasswordSetBinding;", "Lcom/huachenjie/login/page/password/SetPasswordVM;", "", "onDestroy", "", "", "", "V", "getLayoutResID", "initData", "initView", "W", "g0", "", "a", "J", "mTotalCountdown", "d", "mCountdownInterval", "Landroid/os/Handler;", "Landroid/os/Handler;", "j0", "()Landroid/os/Handler;", "mHandler", "", "b", "Lkotlin/Lazy;", "i0", "()Ljava/lang/String;", "loginPhone", "", "c", "h0", "()Z", SetPasswordActivity.x, "com/huachenjie/login/page/password/SetPasswordActivity$smsCountDown$2$a", "k0", "()Lcom/huachenjie/login/page/password/SetPasswordActivity$smsCountDown$2$a;", "smsCountDown", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SetPasswordActivity extends BaseMVVMActivity<LoginActivityPasswordSetBinding, SetPasswordVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "loginPhone";

    @NotNull
    public static final String x = "forgotPassword";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long mTotalCountdown = 60000;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long mCountdownInterval = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy loginPhone = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$loginPhone$2
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

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy forgotPassword = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$forgotPassword$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m451invoke() {
            Intent intent = this.this$0.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra(SetPasswordActivity.x, false) : false);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy smsCountDown = LazyKt.lazy(new Function0<SetPasswordActivity$smsCountDown$2.a>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$smsCountDown$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/login/page/password/SetPasswordActivity$smsCountDown$2$a", "Lcom/huachenjie/login/util/CountDownTimerHelper;", "", "millisUntilFinished", "", y6b.f, "f", "login_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends CountDownTimerHelper {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SetPasswordActivity f34734a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SetPasswordActivity setPasswordActivity, Handler handler) {
                super(handler);
                this.f34734a = setPasswordActivity;
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void f() {
                this.f34734a.g0();
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void g(long millisUntilFinished) {
                SetPasswordActivity.e0(this.f34734a).s().setValue(this.f34734a.getString(R.string.login_verify_code_cool_down, Long.valueOf(millisUntilFinished / ((long) 1000))));
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final a m453invoke() {
            return new a(this.this$0, this.this$0.getMHandler());
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/login/page/password/SetPasswordActivity$a;", "", "Landroid/view/View;", "view", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/login/page/password/SetPasswordActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SetPasswordActivity.this.finish();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SetPasswordVM setPasswordVME0 = SetPasswordActivity.e0(SetPasswordActivity.this);
            String strI0 = SetPasswordActivity.this.i0();
            Intrinsics.checkNotNullExpressionValue(strI0, "loginPhone");
            setPasswordVME0.k(strI0);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SetPasswordActivity.e0(SetPasswordActivity.this).r().setValue(Boolean.FALSE);
            SetPasswordVM setPasswordVME0 = SetPasswordActivity.e0(SetPasswordActivity.this);
            String strI0 = SetPasswordActivity.this.i0();
            Intrinsics.checkNotNullExpressionValue(strI0, "loginPhone");
            setPasswordVME0.x(strI0, null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.password.SetPasswordActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/login/page/password/SetPasswordActivity$b;", "", "Landroid/content/Context;", "context", "", "loginPhone", "", SetPasswordActivity.x, "", "a", "FORGOT_PASSWORD", "Ljava/lang/String;", "LOGIN_PHONE", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String loginPhone, boolean forgotPassword) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(loginPhone, "loginPhone");
            Intent intent = new Intent(context, (Class<?>) SetPasswordActivity.class);
            intent.putExtra("loginPhone", loginPhone);
            intent.putExtra(SetPasswordActivity.x, forgotPassword);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34733a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34733a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34733a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34733a.invoke(obj);
        }
    }

    public static final /* synthetic */ SetPasswordVM e0(SetPasswordActivity setPasswordActivity) {
        return setPasswordActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().u().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                EditText editText = this.this$0.getMBinding().b;
                if (editText != null) {
                    Intrinsics.checkNotNullExpressionValue(bool, "show");
                    vm6.a(editText, bool.booleanValue());
                }
            }
        }));
        getMViewModel().t().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                EditText editText = this.this$0.getMBinding().f34654a;
                if (editText != null) {
                    Intrinsics.checkNotNullExpressionValue(bool, "show");
                    vm6.a(editText, bool.booleanValue());
                }
            }
        }));
        getMViewModel().v().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$3
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
                    this.this$0.k0().h(this.this$0.mTotalCountdown, this.this$0.mCountdownInterval);
                }
            }
        }));
        getMViewModel().o().observe(this, new c(new Function1<LoginResultData, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginResultData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LoginResultData loginResultData) {
                LoginUtil loginUtil = LoginUtil.f34754a;
                SetPasswordActivity setPasswordActivity = this.this$0;
                SetPasswordVM setPasswordVME0 = SetPasswordActivity.e0(setPasswordActivity);
                Intrinsics.checkNotNullExpressionValue(loginResultData, o.f);
                loginUtil.b(setPasswordActivity, setPasswordVME0, loginResultData);
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    this.this$0.finish();
                }
            }
        }));
        getMViewModel().p().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$6
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
                    final SetPasswordActivity setPasswordActivity = this.this$0;
                    companion.a(supportFragmentManager, new Function1<String, Unit>() { // from class: com.huachenjie.login.page.password.SetPasswordActivity$initDataObserve$6.1
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
                            SetPasswordActivity.e0(setPasswordActivity).r().setValue(Boolean.FALSE);
                            SetPasswordVM setPasswordVME0 = SetPasswordActivity.e0(setPasswordActivity);
                            String strI0 = setPasswordActivity.i0();
                            Intrinsics.checkNotNullExpressionValue(strI0, "loginPhone");
                            Intrinsics.checkNotNull(str);
                            setPasswordVME0.x(strI0, str);
                        }
                    });
                }
            }
        }));
    }

    public final void g0() {
        getMViewModel().s().setValue(getString(R.string.login_request_verify_code));
        getMViewModel().r().setValue(Boolean.TRUE);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_password_set;
    }

    public final boolean h0() {
        return ((Boolean) this.forgotPassword.getValue()).booleanValue();
    }

    public final String i0() {
        return (String) this.loginPhone.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().n().setValue(Boolean.valueOf(h0()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<Boolean> mutableLiveDataU = getMViewModel().u();
        Boolean bool = Boolean.FALSE;
        mutableLiveDataU.setValue(bool);
        getMViewModel().t().setValue(bool);
        g0();
    }

    @NotNull
    /* JADX INFO: renamed from: j0, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final SetPasswordActivity$smsCountDown$2.a k0() {
        return (SetPasswordActivity$smsCountDown$2.a) this.smsCountDown.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        k0().d();
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
