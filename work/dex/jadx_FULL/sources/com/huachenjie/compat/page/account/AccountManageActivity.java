package com.huachenjie.compat.page.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.enums.ThirdLoginType;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.compat.R;
import com.huachenjie.compat.databinding.ActivityAccountManageBinding;
import com.huachenjie.compat.page.account.AccountManageActivity;
import com.huachenjie.compat.page.personal.PhoneModifyActivity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.zj.adlib.dx7;
import com.zj.adlib.ft1;
import com.zj.adlib.h40;
import com.zj.adlib.it9;
import com.zj.adlib.wk0;
import com.zj.adlib.y29;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import java.util.Arrays;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/huachenjie/compat/page/account/AccountManageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/compat/databinding/ActivityAccountManageBinding;", "Lcom/huachenjie/compat/page/account/AccountManageVM;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "", "getLayoutResID", "", "", "V", "initView", "initData", "W", "onResume", "", "code", "onEvent", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/tauth/IUiListener;", "a", "Lcom/tencent/tauth/IUiListener;", "loginListener", "<init>", "()V", "b", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class AccountManageActivity extends BaseMVVMActivity<ActivityAccountManageBinding, AccountManageVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final IUiListener loginListener = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/compat/page/account/AccountManageActivity$a;", "", "Landroid/view/View;", "v", "", y6b.f, "d", "j", y6b.g, "e", "<init>", "(Lcom/huachenjie/compat/page/account/AccountManageActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void f(AccountManageActivity accountManageActivity, View view) {
            Intrinsics.checkNotNullParameter(accountManageActivity, "this$0");
            AccountManageActivity.b0(accountManageActivity).w(ThirdLoginType.AliPay);
        }

        public static final void i(AccountManageActivity accountManageActivity, View view) {
            Intrinsics.checkNotNullParameter(accountManageActivity, "this$0");
            AccountManageActivity.b0(accountManageActivity).w(ThirdLoginType.QQ);
        }

        public static final void k(AccountManageActivity accountManageActivity, View view) {
            Intrinsics.checkNotNullParameter(accountManageActivity, "this$0");
            AccountManageActivity.b0(accountManageActivity).w(ThirdLoginType.WeiXin);
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AccountManageActivity.this.startActivity(new Intent(AccountManageActivity.this, (Class<?>) CancelAccountActivity.class));
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!Intrinsics.areEqual(AccountManageActivity.b0(AccountManageActivity.this).o().getValue(), Boolean.TRUE)) {
                h40.a(AccountManageActivity.this);
            } else {
                final AccountManageActivity accountManageActivity = AccountManageActivity.this;
                ft1.o(accountManageActivity, "您确定要解绑支付宝账号吗？解绑后不能使用支付宝碰一碰核验，需再次绑定才行哦~", OptionsPickerHelper.e, "我要解绑", new View.OnClickListener() { // from class: com.zj.adlib.ws
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountManageActivity.a.f(accountManageActivity, view);
                    }
                });
            }
        }

        public final void g(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AccountManageActivity.b0(AccountManageActivity.this).v();
        }

        public final void h(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (Intrinsics.areEqual(AccountManageActivity.b0(AccountManageActivity.this).p().getValue(), Boolean.TRUE)) {
                final AccountManageActivity accountManageActivity = AccountManageActivity.this;
                ft1.o(accountManageActivity, "您确定要解绑QQ账号吗？解绑后不能使用QQ授权登录，需再次绑定才行哦~", OptionsPickerHelper.e, "我要解绑", new View.OnClickListener() { // from class: com.zj.adlib.us
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountManageActivity.a.i(accountManageActivity, view);
                    }
                });
            } else {
                y29 y29VarG = y29.g();
                AccountManageActivity accountManageActivity2 = AccountManageActivity.this;
                y29VarG.j(accountManageActivity2, accountManageActivity2.loginListener);
            }
        }

        public final void j(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!Intrinsics.areEqual(AccountManageActivity.b0(AccountManageActivity.this).q().getValue(), Boolean.TRUE)) {
                it9.h().r();
            } else {
                final AccountManageActivity accountManageActivity = AccountManageActivity.this;
                ft1.o(accountManageActivity, "您确定要解绑微信账号吗？解绑后不能使用微信授权登录，需再次绑定才行哦~", OptionsPickerHelper.e, "我要解绑", new View.OnClickListener() { // from class: com.zj.adlib.vs
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountManageActivity.a.k(accountManageActivity, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.compat.page.account.AccountManageActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/compat/page/account/AccountManageActivity$b;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) AccountManageActivity.class));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/account/AccountManageActivity$c", "Lcom/zj/adlib/y29$b;", "Lorg/json/JSONObject;", "values", "", "doComplete", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends y29.b {
        public c() {
        }

        public void doComplete(@NotNull JSONObject values) {
            Intrinsics.checkNotNullParameter(values, "values");
            try {
                String string = values.getString(dx7.c);
                AccountManageVM accountManageVMB0 = AccountManageActivity.b0(AccountManageActivity.this);
                ThirdLoginType thirdLoginType = ThirdLoginType.QQ;
                Intrinsics.checkNotNullExpressionValue(string, "openId");
                accountManageVMB0.j(thirdLoginType, string);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34080a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34080a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34080a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34080a.invoke(obj);
        }
    }

    public static final /* synthetic */ AccountManageVM b0(AccountManageActivity accountManageActivity) {
        return accountManageActivity.getMViewModel();
    }

    public static final void c0(AccountManageActivity accountManageActivity, View view) {
        Intrinsics.checkNotNullParameter(accountManageActivity, "this$0");
        accountManageActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(wk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(wk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().n().observe(this, new d(new Function1<ThirdLoginType, Unit>() { // from class: com.huachenjie.compat.page.account.AccountManageActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ThirdLoginType) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ThirdLoginType thirdLoginType) {
                AccountManageActivity accountManageActivity = this.this$0;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ys8.e(R.string.repeat_bind_error);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.repeat_bind_error)");
                Object[] objArr = new Object[1];
                objArr[0] = thirdLoginType == ThirdLoginType.QQ ? "QQ" : "微信";
                String str = String.format(strE, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                ft1.z(accountManageActivity, str, "我知道了");
            }
        }));
        getMViewModel().m().observe(this, new d(new AccountManageActivity$initDataObserve$2(this)));
        getMViewModel().k().observe(this, new d(new Function1<Integer, Unit>() { // from class: com.huachenjie.compat.page.account.AccountManageActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                AccountManageActivity accountManageActivity = this.this$0;
                Intent intent = new Intent(this.this$0, (Class<?>) PhoneModifyActivity.class);
                Intrinsics.checkNotNullExpressionValue(num, "count");
                intent.putExtra("count", num.intValue());
                accountManageActivity.startActivity(intent);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_account_manage;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().r().setValue(Boolean.valueOf(y29.i(this)));
        getMViewModel().s().setValue(Boolean.valueOf(it9.q()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            value = 0;
        }
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("账号管理");
        int i = R.color.color_191F20;
        mutableLiveDataI.setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ts
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageActivity.c0(this.f44996a, view);
            }
        }));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10102 || requestCode == 11101) {
            Tencent.onActivityResultData(requestCode, resultCode, data, this.loginListener);
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
        getMViewModel().j(ThirdLoginType.WeiXin, code);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().t();
        getMViewModel().u();
    }
}
