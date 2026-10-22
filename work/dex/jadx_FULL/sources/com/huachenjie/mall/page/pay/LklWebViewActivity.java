package com.huachenjie.mall.page.pay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityLklWebviewBinding;
import com.huachenjie.mall.page.pay.LklWebViewActivity;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.it9;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/pay/LklWebViewActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityLklWebviewBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "", "S", "", "", "V", "getLayoutResID", "initView", "onDestroy", "b0", "<init>", "()V", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class LklWebViewActivity extends BaseMVVMActivity<MallActivityLklWebviewBinding, BaseTitleViewModel> implements AdCancelInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "url";

    /* JADX INFO: renamed from: com.huachenjie.mall.page.pay.LklWebViewActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/pay/LklWebViewActivity$a;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "KEY_URL", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) LklWebViewActivity.class);
            intent.putExtra("url", url);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J.\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/pay/LklWebViewActivity$b;", "", "", "url", "", "jumpAlipay", "userName", "path", "universalLink", "", "programType", "jumpWxApplet", "closeWindow", "<init>", "(Lcom/huachenjie/mall/page/pay/LklWebViewActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nLklWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LklWebViewActivity.kt\ncom/huachenjie/mall/page/pay/LklWebViewActivity$LklJsInterface\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,177:1\n29#2:178\n*S KotlinDebug\n*F\n+ 1 LklWebViewActivity.kt\ncom/huachenjie/mall/page/pay/LklWebViewActivity$LklJsInterface\n*L\n146#1:178\n*E\n"})
    public final class b {
        public b() {
        }

        @JavascriptInterface
        public final void closeWindow() {
            LklWebViewActivity.this.finish();
        }

        @JavascriptInterface
        public final void jumpAlipay(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(268435456);
            Uri uri = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
            intent.setData(uri);
            LklWebViewActivity.this.startActivity(intent);
        }

        @JavascriptInterface
        public final void jumpWxApplet(@Nullable String userName, @Nullable String path, @Nullable String universalLink, int programType) {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(LklWebViewActivity.this, it9.n());
            if (!iwxapiCreateWXAPI.isWXAppInstalled()) {
                fv5.b("您暂未安装该应用");
                return;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = userName;
            req.path = path;
            req.miniprogramType = programType;
            iwxapiCreateWXAPI.sendReq(req);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/mall/page/pay/LklWebViewActivity$c", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return false;
        }
    }

    public static final void c0(LklWebViewActivity lklWebViewActivity, View view) {
        Intrinsics.checkNotNullParameter(lklWebViewActivity, "this$0");
        lklWebViewActivity.b0();
    }

    public static final boolean d0(LklWebViewActivity lklWebViewActivity, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(lklWebViewActivity, "this$0");
        if (keyEvent.getAction() != 0 || i != 4) {
            return false;
        }
        lklWebViewActivity.b0();
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, BaseTitleViewModel> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final void b0() {
        if (getMBinding().f34802a == null || !getMBinding().f34802a.canGoBack()) {
            finish();
        } else {
            getMBinding().f34802a.goBack();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_lkl_webview;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
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
        bindingTitleBean.setTitleName("");
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xy4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LklWebViewActivity.c0(this.f45919a, view);
            }
        });
        bindingTitleBean.setBackIconResId(com.huachenjie.base.R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        mutableLiveDataI.setValue(bindingTitleBean);
        getMBinding().f34802a.getSettings().setUseWideViewPort(true);
        getMBinding().f34802a.getSettings().setLoadWithOverviewMode(true);
        getMBinding().f34802a.getSettings().setBlockNetworkImage(false);
        getMBinding().f34802a.getSettings().setBlockNetworkLoads(false);
        getMBinding().f34802a.getSettings().setDomStorageEnabled(true);
        getMBinding().f34802a.getSettings().setBuiltInZoomControls(true);
        getMBinding().f34802a.getSettings().setDisplayZoomControls(false);
        getMBinding().f34802a.getSettings().setGeolocationEnabled(true);
        getMBinding().f34802a.getSettings().setSupportZoom(true);
        getMBinding().f34802a.getSettings().setJavaScriptEnabled(true);
        getMBinding().f34802a.getSettings().setAllowFileAccess(true);
        getMBinding().f34802a.getSettings().setAllowFileAccessFromFileURLs(true);
        getMBinding().f34802a.getSettings().setAllowUniversalAccessFromFileURLs(true);
        getMBinding().f34802a.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getMBinding().f34802a.addJavascriptInterface(new b(), "LKLWebObject");
        try {
            Method method = getMBinding().f34802a.getSettings().getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(getMBinding().f34802a.getSettings(), Boolean.TRUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getMBinding().f34802a.setWebViewClient(new c());
        getMBinding().f34802a.getSettings().setMixedContentMode(0);
        String stringExtra = getIntent().getStringExtra("url");
        getMBinding().f34802a.loadUrl(stringExtra != null ? stringExtra : "");
        getMBinding().f34802a.setOnKeyListener(new View.OnKeyListener() { // from class: com.zj.adlib.yy4
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return LklWebViewActivity.d0(this.f46140a, view, i, keyEvent);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (getMBinding().f34802a != null) {
            getMBinding().f34802a.destroy();
        }
        super.onDestroy();
    }
}
