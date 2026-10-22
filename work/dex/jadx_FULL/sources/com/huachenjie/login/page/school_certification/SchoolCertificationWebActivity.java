package com.huachenjie.login.page.school_certification;

import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.databinding.LoginActivitySchoolCertificationWebBinding;
import com.huachenjie.login.page.bind.BindPhoneActivity;
import com.huachenjie.login.page.school_certification.SchoolCertificationWebActivity;
import com.huachenjie.login.util.LoginUtil;
import com.zj.adlib.ai9;
import com.zj.adlib.i4a;
import com.zj.adlib.sh9;
import com.zj.adlib.zk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = RoutePathConstants.Login.b)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/huachenjie/login/page/school_certification/SchoolCertificationWebActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivitySchoolCertificationWebBinding;", "Lcom/huachenjie/login/page/school_certification/SchoolCertificationWebWM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "onDestroy", "f0", "Lcom/huachenjie/login/bean/LoginResultData;", "loginResult", "d0", "e0", "h0", "initWebView", "", "schoolCode", "studentNumber", "bindKey", "i0", "t", "Ljava/lang/String;", "url", "x", "type", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolCertificationWebActivity extends BaseMVVMActivity<LoginActivitySchoolCertificationWebBinding, SchoolCertificationWebWM> {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Autowired(name = "url")
    @JvmField
    @Nullable
    public String url;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "type")
    @JvmField
    @Nullable
    public String type;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/login/page/school_certification/SchoolCertificationWebActivity$a", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "", "shouldOverrideUrlLoading", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull WebResourceRequest request) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            String string = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(string, "request.url.toString()");
            i4a.c("skip url:" + string);
            String strF = sh9.f(string, "schoolCode");
            String strF2 = sh9.f(string, "ticket");
            if (TextUtils.isEmpty(strF) || TextUtils.isEmpty(strF2)) {
                return true;
            }
            SchoolCertificationWebWM schoolCertificationWebWMB0 = SchoolCertificationWebActivity.b0(SchoolCertificationWebActivity.this);
            Intrinsics.checkNotNullExpressionValue(strF, "schoolCode");
            Intrinsics.checkNotNullExpressionValue(strF2, "ticket");
            String str = SchoolCertificationWebActivity.this.type;
            if (str == null) {
                str = "";
            }
            schoolCertificationWebWMB0.k(strF, strF2, str);
            return true;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34741a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34741a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34741a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34741a.invoke(obj);
        }
    }

    public static final /* synthetic */ SchoolCertificationWebWM b0(SchoolCertificationWebActivity schoolCertificationWebActivity) {
        return schoolCertificationWebActivity.getMViewModel();
    }

    public static final void g0(SchoolCertificationWebActivity schoolCertificationWebActivity, View view) {
        Intrinsics.checkNotNullParameter(schoolCertificationWebActivity, "this$0");
        schoolCertificationWebActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new b(new SchoolCertificationWebActivity$initDataObserve$1(this)));
        getMViewModel().m().observe(this, new b(new Function1<LoginResultData, Unit>() { // from class: com.huachenjie.login.page.school_certification.SchoolCertificationWebActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginResultData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable LoginResultData loginResultData) {
                if (loginResultData == null) {
                    return;
                }
                this.this$0.d0(loginResultData);
            }
        }));
    }

    public final void d0(LoginResultData loginResult) {
        if (!TextUtils.equals(this.type, "STUDENT_AUTH")) {
            LoginUtil.f34754a.b(this, getMViewModel(), loginResult);
        } else {
            BaseViewModelExtKt.b(getMViewModel(), true, false, null, null, new SchoolCertificationWebActivity$dealLogin$1(loginResult, ai9.e(), this, null), 14, null);
        }
    }

    public final void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void f0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("学校认证");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.cw7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SchoolCertificationWebActivity.g0(this.f41054a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_school_certification_web;
    }

    public final void h0() {
        LoginActivitySchoolCertificationWebBinding mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        String str = this.url;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            if (StringsKt.contains$default(str, "?", false, 2, (Object) null)) {
                i4a.c("url:" + this.url + "&t=" + System.currentTimeMillis());
                mBinding.f34666a.loadUrl(this.url + "&t=" + System.currentTimeMillis());
                return;
            }
        }
        i4a.c("url:" + this.url);
        WebView webView = mBinding.f34666a;
        String str2 = this.url;
        if (str2 == null) {
            str2 = "";
        }
        webView.loadUrl(str2);
    }

    public final void i0(String schoolCode, String studentNumber, String bindKey) {
        BindPhoneActivity.INSTANCE.startActivity(this, schoolCode, studentNumber, bindKey);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        h0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        e0();
        f0();
        initWebView();
    }

    public final void initWebView() {
        WebView webView;
        LoginActivitySchoolCertificationWebBinding mBinding = getMBinding();
        if (mBinding == null || (webView = mBinding.f34666a) == null) {
            return;
        }
        webView.setWebViewClient(new a());
        WebSettings settings = webView.getSettings();
        settings.setMixedContentMode(0);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(2);
        CookieManager.getInstance().removeSessionCookies(null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CookieManager.getInstance().removeSessionCookies(null);
        super.onDestroy();
    }
}
