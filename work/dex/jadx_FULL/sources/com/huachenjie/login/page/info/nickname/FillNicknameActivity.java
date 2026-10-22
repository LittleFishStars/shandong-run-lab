package com.huachenjie.login.page.info.nickname;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.databinding.LoginActivityFillNicknameBinding;
import com.huachenjie.login.page.bind.BindPhoneActivity;
import com.huachenjie.login.page.info.sex.ChooseSexActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.pg3;
import com.zj.adlib.zk0;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/login/page/info/nickname/FillNicknameActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityFillNicknameBinding;", "Lcom/huachenjie/login/page/info/nickname/FillNicknameVM;", "", "getLayoutResID", "", "", "V", "", "initData", "W", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "onBackPressed", "<init>", "()V", "a", "b", "login_release"}, k = 1, mv = {1, 8, 0})
public final class FillNicknameActivity extends BaseMVVMActivity<LoginActivityFillNicknameBinding, FillNicknameVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "isFromLogin";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/login/page/info/nickname/FillNicknameActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/login/page/info/nickname/FillNicknameActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            FillNicknameActivity.Z(FillNicknameActivity.this).i();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.info.nickname.FillNicknameActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/login/page/info/nickname/FillNicknameActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/login/bean/LoginResultData;", "resultData", "", FillNicknameActivity.t, "", PerfId.startActivity, "", "IS_FROM_LOGIN_KEY", "Ljava/lang/String;", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(Companion companion, Context context, LoginResultData loginResultData, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                loginResultData = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            companion.startActivity(context, loginResultData, z);
        }

        public final void startActivity(@NotNull Context context, @Nullable LoginResultData resultData, boolean isFromLogin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) FillNicknameActivity.class);
            intent.putExtra(FillNicknameActivity.t, isFromLogin);
            context.startActivity(intent);
            pg3.f18845a.j(resultData);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34711a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34711a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34711a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34711a.invoke(obj);
        }
    }

    public static final /* synthetic */ FillNicknameVM Z(FillNicknameActivity fillNicknameActivity) {
        return fillNicknameActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().j().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.login.page.info.nickname.FillNicknameActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (!Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    fv5.a(R.string.login_fill_nickname_name_error);
                    return;
                }
                String value = FillNicknameActivity.Z(this.this$0).l().getValue();
                if (value == null) {
                    value = "";
                }
                pg3.com.huachenjie.common.constants.UserConstants.USER_PARAMS.b java.lang.String = value;
                this.this$0.startActivity(new Intent(this.this$0, (Class<?>) ChooseSexActivity.class));
            }
        }));
        getMViewModel().l().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.login.page.info.nickname.FillNicknameActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                FillNicknameActivity.Z(this.this$0).k().setValue(this.this$0.getString(R.string.login_fill_nickname_name_max, Integer.valueOf(str.length())));
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_fill_nickname;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        com.blankj.utilcode.util.a.f(BindPhoneActivity.class);
        getMViewModel().m();
        getMViewModel().k().setValue(getString(R.string.login_fill_nickname_name_max, 0));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        boolean z = false;
        if (event != null && event.getKeyCode() == 4) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
