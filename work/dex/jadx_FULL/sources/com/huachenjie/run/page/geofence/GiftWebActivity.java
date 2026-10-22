package com.huachenjie.run.page.geofence;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.p002lifecycle.MediatorLiveData;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.run.databinding.RunActivityWebviewGiftBinding;
import com.huachenjie.run.page.geofence.GiftWebActivity;
import com.zj.adlib.i62;
import com.zj.adlib.k94;
import com.zj.adlib.ov5;
import com.zj.adlib.ti4;
import com.zj.adlib.vk0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.q)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/run/page/geofence/GiftWebActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/run/page/geofence/GeoFenceV2VM;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "initView", "h0", "onBackPressed", "", "x", "Ljava/lang/String;", "title", "y", "url", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class GiftWebActivity extends BaseVmActivity<GeoFenceV2VM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "title")
    @JvmField
    @Nullable
    public String title;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Autowired(name = "url")
    @JvmField
    @Nullable
    public String url;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/run/page/geofence/GiftWebActivity$a", "Lcom/zj/adlib/ov5;", "Landroid/webkit/WebView;", "view", "", "url", "", "onPageFinished", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends ov5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f35884a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GiftWebActivity giftWebActivity, ProgressBar progressBar) {
            super(giftWebActivity);
            this.f35884a = progressBar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            ProgressBar progressBar = this.f35884a;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/run/page/geofence/GiftWebActivity$b", "Lcom/zj/adlib/k94;", "Landroid/webkit/WebView;", "view", "", "newProgress", "", "onProgressChanged", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends k94 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f35885a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GiftWebActivity giftWebActivity, ProgressBar progressBar, Class<ti4> cls) {
            super(giftWebActivity, "jsInterface", cls);
            this.f35885a = progressBar;
        }

        @Override // com.zj.adlib.k94, android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView view, int newProgress) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onProgressChanged(view, newProgress);
            this.f35885a.setProgress(newProgress);
        }
    }

    public static final void i0(GiftWebActivity giftWebActivity, View view) {
        Intrinsics.checkNotNullParameter(giftWebActivity, "this$0");
        giftWebActivity.onBackPressed();
    }

    public static final void j0(GiftWebActivity giftWebActivity, View view) {
        Intrinsics.checkNotNullParameter(giftWebActivity, "this$0");
        giftWebActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.transparent).G1(true).q1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(com.huachenjie.run.R.layout.run_activity_webview_gift), Integer.valueOf(vk0.p0), ((BaseVmActivity) this).f8507a);
    }

    public final void h0() {
        String str;
        MediatorLiveData<BindingTitleBean> mediatorLiveData = ((GeoFenceV2VM) ((BaseVmActivity) this).f8507a).titleBean;
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((GeoFenceV2VM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean backIconResId = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackShow(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.eu3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftWebActivity.i0(this.f41527a, view);
            }
        }).setBackIconResId(R.drawable.ic_back_black);
        int i = R.color.color_2C3E50;
        BindingTitleBean titleTextColor = backIconResId.setBackTintColor(Integer.valueOf(zn1.a(i))).setTitleTextColor(zn1.a(i));
        if (TextUtils.isEmpty(this.title)) {
            str = "";
        } else {
            str = this.title;
            Intrinsics.checkNotNull(str);
        }
        mediatorLiveData.setValue(titleTextColor.setTitleName(str).setLeftSubIconShow(true).setLeftSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.fu3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftWebActivity.j0(this.f41758a, view);
            }
        }).setShowDivider(true).setLeftSubIconResId(R.drawable.ic_home).setLeftSubIconTintColor(Integer.valueOf(zn1.a(i))));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        initView();
        h0();
    }

    public final void initView() {
        RunActivityWebviewGiftBinding runActivityWebviewGiftBinding = (RunActivityWebviewGiftBinding) getBinding();
        if (runActivityWebviewGiftBinding == null) {
            return;
        }
        MyWebView myWebView = runActivityWebviewGiftBinding.f11669a;
        Intrinsics.checkNotNullExpressionValue(myWebView, "mBinding.webView");
        ProgressBar progressBar = runActivityWebviewGiftBinding.f35516a;
        Intrinsics.checkNotNullExpressionValue(progressBar, "mBinding.webViewProgressbar");
        myWebView.setWebViewClient(new a(this, progressBar));
        myWebView.setWebChromeClient(new b(this, progressBar, ti4.class));
        if (TextUtils.isEmpty(this.url)) {
            return;
        }
        String str = this.url;
        Intrinsics.checkNotNull(str);
        if (StringsKt.startsWith$default(str, "file:///android_asset", false, 2, (Object) null)) {
            myWebView.setAllowFileAccess(true);
            myWebView.setSupportZoom(true);
        }
        String str2 = this.url;
        if (str2 == null) {
            str2 = "";
        }
        myWebView.loadUrl(str2);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MyWebView myWebView;
        RunActivityWebviewGiftBinding runActivityWebviewGiftBinding = (RunActivityWebviewGiftBinding) getBinding();
        boolean z = false;
        if (runActivityWebviewGiftBinding != null && (myWebView = runActivityWebviewGiftBinding.f11669a) != null && myWebView.canGoBack()) {
            z = true;
        }
        if (z) {
            runActivityWebviewGiftBinding.f11669a.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
