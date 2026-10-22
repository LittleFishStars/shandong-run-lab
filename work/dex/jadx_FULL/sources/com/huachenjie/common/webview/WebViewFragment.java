package com.huachenjie.common.webview;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.databinding.FragmentWebviewBinding;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.common.webview.WebViewFragment;
import com.zj.adlib.i62;
import com.zj.adlib.k94;
import com.zj.adlib.ov5;
import com.zj.adlib.ti4;
import com.zj.adlib.vk0;
import com.zj.adlib.vo6;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\u0003H\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/webview/WebViewFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "loadPage", "initWebViewClient", "initWebChromeClient", "checkLocationRight", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initDataAfterView", "initWebView", "initViewModel", "", "url", "Ljava/lang/String;", "", "needLocation", "Ljava/lang/Boolean;", "<init>", "()V", "Companion", "a", "b", "common_release"}, k = 1, mv = {1, 8, 0})
public class WebViewFragment extends BaseVMFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FRAGMENT_NEED_LOCATION = "fragmentNeedLocation";

    @NotNull
    private static final String FRAGMENT_URL = "fragmentUrl";

    @Nullable
    private Boolean needLocation = Boolean.FALSE;

    @Nullable
    private String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/webview/WebViewFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/common/webview/WebViewFragment;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            MyWebView myWebView;
            FragmentWebviewBinding fragmentWebviewBinding = (FragmentWebviewBinding) WebViewFragment.this.getBinding();
            boolean z = false;
            if (fragmentWebviewBinding != null && (myWebView = fragmentWebviewBinding.f8638a) != null && myWebView.canGoBack()) {
                z = true;
            }
            if (z) {
                fragmentWebviewBinding.f8638a.goBack();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.common.webview.WebViewFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/webview/WebViewFragment$b;", "", "", "url", "", "needLocation", "Lcom/huachenjie/common/webview/WebViewFragment;", "a", "FRAGMENT_NEED_LOCATION", "Ljava/lang/String;", "FRAGMENT_URL", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WebViewFragment a(@Nullable String url, boolean needLocation) {
            WebViewFragment webViewFragment = new WebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString(WebViewFragment.FRAGMENT_URL, url);
            bundle.putBoolean(WebViewFragment.FRAGMENT_NEED_LOCATION, needLocation);
            webViewFragment.setArguments(bundle);
            return webViewFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/common/webview/WebViewFragment$c", "Lcom/zj/adlib/k94;", "", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", RenderCallContext.TYPE_CALLBACK, "", "onGeolocationPermissionsShowPrompt", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends k94 {
        public c(FragmentActivity fragmentActivity, Class<ti4> cls) {
            super(fragmentActivity, "jsInterface", cls);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(@NotNull String origin, @NotNull GeolocationPermissions.Callback callback) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            callback.invoke(origin, true, true);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/common/webview/WebViewFragment$d", "Lcom/zj/adlib/ov5;", "Landroid/webkit/WebView;", "view", "", "url", "", "onPageFinished", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends ov5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentWebviewBinding f33969a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FragmentWebviewBinding fragmentWebviewBinding, FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.f33969a = fragmentWebviewBinding;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            FragmentWebviewBinding fragmentWebviewBinding = this.f33969a;
            fragmentWebviewBinding.f33759a.setVisibility(fragmentWebviewBinding.f8638a.canGoBack() ? 0 : 8);
            super.onPageFinished(view, url);
        }
    }

    private final void checkLocationRight() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        vo6.j(contextRequireContext, "android.permission.ACCESS_FINE_LOCATION", "为了能根据您的位置用于展示附近的信息，我们需要获取您的位置权限", new PermissionResultListener() { // from class: com.zj.adlib.xu9
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                WebViewFragment.checkLocationRight$lambda$1(this.f45901a, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLocationRight$lambda$1(WebViewFragment webViewFragment, boolean z) {
        Intrinsics.checkNotNullParameter(webViewFragment, "this$0");
        webViewFragment.loadPage();
    }

    private final void initWebChromeClient() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.FragmentWebviewBinding");
        ((FragmentWebviewBinding) binding).f8638a.setWebChromeClient(new c(getActivity(), ti4.class));
    }

    private final void initWebViewClient() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.FragmentWebviewBinding");
        final FragmentWebviewBinding fragmentWebviewBinding = (FragmentWebviewBinding) binding;
        fragmentWebviewBinding.f8638a.setWebViewClient(new d(fragmentWebviewBinding, getActivity()));
        fragmentWebviewBinding.f8638a.setOnKeyListener(new View.OnKeyListener() { // from class: com.zj.adlib.wu9
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return WebViewFragment.initWebViewClient$lambda$0(fragmentWebviewBinding, view, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initWebViewClient$lambda$0(FragmentWebviewBinding fragmentWebviewBinding, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(fragmentWebviewBinding, "$mBinding");
        if (keyEvent.getAction() != 1 || i != 4 || !fragmentWebviewBinding.f8638a.canGoBack()) {
            return false;
        }
        fragmentWebviewBinding.f8638a.goBack();
        return true;
    }

    private final void loadPage() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.FragmentWebviewBinding");
        FragmentWebviewBinding fragmentWebviewBinding = (FragmentWebviewBinding) binding;
        if (TextUtils.isEmpty(this.url)) {
            return;
        }
        String str = this.url;
        Intrinsics.checkNotNull(str);
        if (StringsKt.startsWith$default(str, "file:///android_asset", false, 2, (Object) null)) {
            fragmentWebviewBinding.f8638a.setAllowFileAccess(true);
            fragmentWebviewBinding.f8638a.setSupportZoom(true);
        }
        MyWebView myWebView = fragmentWebviewBinding.f8638a;
        String str2 = this.url;
        Intrinsics.checkNotNull(str2);
        myWebView.loadUrl(str2);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.fragment_webview), Integer.valueOf(vk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(vk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        super.initDataAfterView();
        Bundle arguments = getArguments();
        this.url = arguments != null ? arguments.getString(FRAGMENT_URL) : null;
        Bundle arguments2 = getArguments();
        this.needLocation = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean(FRAGMENT_NEED_LOCATION)) : null;
        initWebView();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    public final void initWebView() {
        initWebViewClient();
        initWebChromeClient();
        if (Intrinsics.areEqual(this.needLocation, Boolean.TRUE)) {
            checkLocationRight();
        } else {
            loadPage();
        }
    }
}
