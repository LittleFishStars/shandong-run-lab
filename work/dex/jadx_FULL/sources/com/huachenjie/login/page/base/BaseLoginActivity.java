package com.huachenjie.login.page.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.page.account.LoginAccountActivity;
import com.huachenjie.login.page.base.BaseLoginActivity;
import com.huachenjie.login.page.base.BaseLoginVM;
import com.huachenjie.login.page.bind.BindPhoneActivity;
import com.huachenjie.login.page.school_certification.SchoolCertificationActivity;
import com.huachenjie.login.util.LoginUtil;
import com.huachenjie.login.util.ProtocolUtil;
import com.tencent.tauth.Tencent;
import com.zj.adlib.dx7;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.it9;
import com.zj.adlib.r90;
import com.zj.adlib.t47;
import com.zj.adlib.y29;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0006*\u0001%\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u001eB\u0007¢\u0006\u0004\b(\u0010)J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J(\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J\b\u0010\u0014\u001a\u00020\bH\u0014J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0007J\"\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0015J\b\u0010\u001d\u001a\u00020\bH\u0002R\"\u0010$\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/login/page/base/BaseLoginActivity;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/huachenjie/login/page/base/BaseLoginVM;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "initData", "W", "", "privacyName", "privacyUrl", "Landroid/view/View$OnClickListener;", "confirmClickListener", "", "checkProtocolState", "onResume", "code", "onEvent", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "e0", "a", "Z", "getDealWeChatLogin", "()Z", "setDealWeChatLogin", "(Z)V", "dealWeChatLogin", "com/huachenjie/login/page/base/BaseLoginActivity$b", "Lcom/huachenjie/login/page/base/BaseLoginActivity$b;", "qqLoginListener", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseLoginActivity<V extends ViewDataBinding, VM extends BaseLoginVM> extends BaseMVVMActivity<V, VM> {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean dealWeChatLogin = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public b qqLoginListener = new b(this);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/login/page/base/BaseLoginActivity$a;", "Lcom/huachenjie/login/page/base/ThirdLoginInterface;", "Landroid/view/View;", "v", "", "c", "b", "e", "d", "a", "<init>", "(Lcom/huachenjie/login/page/base/BaseLoginActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public class a implements ThirdLoginInterface {
        public a() {
        }

        public static final void i(BaseLoginActivity baseLoginActivity, View view) {
            Intrinsics.checkNotNullParameter(baseLoginActivity, "this$0");
            y29.g().j(baseLoginActivity, baseLoginActivity.qqLoginListener);
        }

        public static final void j(BaseLoginActivity baseLoginActivity, View view) {
            Intrinsics.checkNotNullParameter(baseLoginActivity, "this$0");
            baseLoginActivity.startActivity(new Intent(baseLoginActivity, (Class<?>) SchoolCertificationActivity.class));
        }

        public static final void k(View view) {
            it9.h().r();
        }

        @Override // com.huachenjie.login.page.base.ThirdLoginInterface
        public void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            LoginAccountActivity.INSTANCE.startActivity(BaseLoginActivity.this, 2);
        }

        @Override // com.huachenjie.login.page.base.ThirdLoginInterface
        public void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!y29.i(BaseLoginActivity.this)) {
                fv5.b(BaseLoginActivity.this.getString(R.string.login_qq_not_install));
                return;
            }
            final BaseLoginActivity<V, VM> baseLoginActivity = BaseLoginActivity.this;
            if (BaseLoginActivity.h0(baseLoginActivity, null, null, new View.OnClickListener() { // from class: com.zj.adlib.xo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginActivity.a.i(baseLoginActivity, view);
                }
            }, 3, null)) {
                y29 y29VarG = y29.g();
                BaseLoginActivity<V, VM> baseLoginActivity2 = BaseLoginActivity.this;
                y29VarG.j(baseLoginActivity2, baseLoginActivity2.qqLoginListener);
            }
        }

        @Override // com.huachenjie.login.page.base.ThirdLoginInterface
        public void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!it9.q()) {
                fv5.b(BaseLoginActivity.this.getString(R.string.login_wechat_not_install));
            } else if (BaseLoginActivity.h0(BaseLoginActivity.this, null, null, new View.OnClickListener() { // from class: com.zj.adlib.yo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginActivity.a.k(view);
                }
            }, 3, null)) {
                it9.h().r();
            }
        }

        @Override // com.huachenjie.login.page.base.ThirdLoginInterface
        public void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            LoginAccountActivity.INSTANCE.startActivity(BaseLoginActivity.this, 1);
        }

        @Override // com.huachenjie.login.page.base.ThirdLoginInterface
        public void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            final BaseLoginActivity<V, VM> baseLoginActivity = BaseLoginActivity.this;
            if (BaseLoginActivity.h0(baseLoginActivity, null, null, new View.OnClickListener() { // from class: com.zj.adlib.zo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginActivity.a.j(baseLoginActivity, view);
                }
            }, 3, null)) {
                BaseLoginActivity.this.startActivity(new Intent(BaseLoginActivity.this, (Class<?>) SchoolCertificationActivity.class));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/login/page/base/BaseLoginActivity$b", "Lcom/zj/adlib/y29$b;", "Lorg/json/JSONObject;", "values", "", "doComplete", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends y29.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLoginActivity<V, VM> f34699a;

        public b(BaseLoginActivity<V, VM> baseLoginActivity) {
            this.f34699a = baseLoginActivity;
        }

        public void doComplete(@NotNull JSONObject values) {
            Intrinsics.checkNotNullParameter(values, "values");
            String strOptString = values.optString(dx7.c);
            BaseLoginVM baseLoginVMC0 = BaseLoginActivity.c0(this.f34699a);
            LoginThirdType loginThirdType = LoginThirdType.QQ;
            Intrinsics.checkNotNullExpressionValue(strOptString, "openId");
            baseLoginVMC0.m(loginThirdType, strOptString);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34700a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34700a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34700a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34700a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BaseLoginVM c0(BaseLoginActivity baseLoginActivity) {
        return (BaseLoginVM) baseLoginActivity.getMViewModel();
    }

    public static final void f0(View view) {
        r90.b0();
    }

    public static final void g0(BaseLoginActivity baseLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(baseLoginActivity, "this$0");
        r90.b0();
        t47.e(baseLoginActivity);
    }

    public static /* synthetic */ boolean h0(BaseLoginActivity baseLoginActivity, String str, String str2, View.OnClickListener onClickListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkProtocolState");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return baseLoginActivity.checkProtocolState(str, str2, onClickListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i0(BaseLoginActivity baseLoginActivity, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(baseLoginActivity, "this$0");
        Intrinsics.checkNotNullParameter(onClickListener, "$confirmClickListener");
        ((BaseLoginVM) baseLoginActivity.getMViewModel()).l().setValue(Boolean.TRUE);
        onClickListener.onClick(view);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().j().observe(this, new c(new Function1<Pair<? extends LoginThirdType, ? extends String>, Unit>(this) { // from class: com.huachenjie.login.page.base.BaseLoginActivity$initDataObserve$1
            final /* synthetic */ BaseLoginActivity<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends LoginThirdType, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<? extends LoginThirdType, String> pair) {
                if (pair == null) {
                    return;
                }
                BindPhoneActivity.INSTANCE.startActivity(this.this$0, (LoginThirdType) pair.getFirst(), (String) pair.getSecond());
            }
        }));
        getMViewModel().k().observe(this, new c(new Function1<LoginResultData, Unit>(this) { // from class: com.huachenjie.login.page.base.BaseLoginActivity$initDataObserve$2
            final /* synthetic */ BaseLoginActivity<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginResultData) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final void invoke(@Nullable LoginResultData loginResultData) {
                if (loginResultData == null) {
                    return;
                }
                LoginUtil loginUtil = LoginUtil.f34754a;
                BaseLoginActivity<V, VM> baseLoginActivity = this.this$0;
                loginUtil.b(baseLoginActivity, BaseLoginActivity.c0(baseLoginActivity), loginResultData);
            }
        }));
    }

    public final boolean checkProtocolState(@Nullable String privacyName, @Nullable String privacyUrl, @NotNull final View.OnClickListener confirmClickListener) {
        SpannableString spannableStringE;
        Intrinsics.checkNotNullParameter(confirmClickListener, "confirmClickListener");
        if (Intrinsics.areEqual(getMViewModel().l().getValue(), Boolean.TRUE)) {
            return true;
        }
        if (TextUtils.isEmpty(privacyName)) {
            ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
            String string = getString(R.string.login_protocol_dialog);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.login_protocol_dialog)");
            spannableStringE = ProtocolUtil.e(protocolUtil, this, string, null, null, 12, null);
        } else {
            ProtocolUtil protocolUtil2 = ProtocolUtil.f10119a;
            String string2 = getString(R.string.login_protocol_with_phone_operator_dialog, (char) 12298 + privacyName + (char) 12299);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …}》\"\n                    )");
            spannableStringE = protocolUtil2.d(this, string2, (char) 12298 + privacyName + (char) 12299, privacyUrl);
        }
        ft1.q(this, "温馨提示", spannableStringE, "拒绝", "同意", new View.OnClickListener() { // from class: com.zj.adlib.wo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseLoginActivity.i0(this.f20482a, confirmClickListener, view);
            }
        });
        return false;
    }

    public final void e0() {
        if (Build.VERSION.SDK_INT < 33 && !t47.d(this) && r90.x().booleanValue()) {
            ft1.s(this, "允许“闪动校园”发送推送通知吗？", "通知可能包括提醒、声音和图标标记。可以在“设置”内修改通知权限。", false, "不允许", "允许", new View.OnClickListener() { // from class: com.zj.adlib.uo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginActivity.f0(view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.vo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginActivity.g0(this.f45398a, view);
                }
            });
        }
    }

    public final boolean getDealWeChatLogin() {
        return this.dealWeChatLogin;
    }

    public void initData() {
        super.initData();
        e0();
        getMViewModel().i();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10102 || requestCode == 11101) {
            Tencent.onActivityResultData(requestCode, resultCode, data, this.qqLoginListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        EventBus.f().v(this);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.f().A(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (this.dealWeChatLogin) {
            getMViewModel().m(LoginThirdType.WeiXin, code);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dealWeChatLogin = true;
    }

    public final void setDealWeChatLogin(boolean z) {
        this.dealWeChatLogin = z;
    }
}
