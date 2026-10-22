package com.huachenjie.college.page.lightningPlay;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.bean.CommonSwitchEntranceConfig;
import com.huachenjie.base.dsbridge_webview.DWebView;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.college.R;
import com.huachenjie.college.databinding.CollegeFragmentLightningPlayBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.dq1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\b\n*\u0001\u001d\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/college/databinding/CollegeFragmentLightningPlayBinding;", "Lcom/huachenjie/college/page/lightningPlay/MoxiPlayVm;", "", "", "", "getVariables", "getLayoutResID", "", "initData", "initDataObservable", "", "canGoBack", "onPause", "onResume", "onDestroy", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "", "gameUrl$delegate", "Lkotlin/Lazy;", "getGameUrl", "()Ljava/lang/String;", "gameUrl", "url$delegate", "getUrl", "url", "com/huachenjie/college/page/lightningPlay/MoxiPlayFragment$jsProvider$2$a", "jsProvider$delegate", "getJsProvider", "()Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment$jsProvider$2$a;", "jsProvider", "<init>", "()V", "Companion", "a", "college_release"}, k = 1, mv = {1, 8, 0})
public final class MoxiPlayFragment extends BaseMVVMFragment<CollegeFragmentLightningPlayBinding, MoxiPlayVm> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_URL = "url";

    @NotNull
    private final WebChromeClient mWebChromeClient = new WebChromeClient();

    /* JADX INFO: renamed from: gameUrl$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameUrl = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.college.page.lightningPlay.MoxiPlayFragment$gameUrl$2
        @NotNull
        public final String invoke() {
            Object next;
            String url;
            Iterator<T> it = dq1.e().getHomeMetaEntryList().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((CommonSwitchEntranceConfig) next).getEntryType() == 19));
            CommonSwitchEntranceConfig commonSwitchEntranceConfig = (CommonSwitchEntranceConfig) next;
            return (commonSwitchEntranceConfig == null || (url = commonSwitchEntranceConfig.getUrl()) == null) ? "" : url;
        }
    });

    /* JADX INFO: renamed from: url$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy url = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.college.page.lightningPlay.MoxiPlayFragment$url$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("url")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: jsProvider$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy jsProvider = LazyKt.lazy(new Function0<MoxiPlayFragment$jsProvider$2.a>() { // from class: com.huachenjie.college.page.lightningPlay.MoxiPlayFragment$jsProvider$2

        @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\u0015"}, d2 = {"com/huachenjie/college/page/lightningPlay/MoxiPlayFragment$jsProvider$2$a", "Lcom/huachenjie/college/page/lightningPlay/LightningPlayJavascript$ILightningPlayProvider;", "Ljava/lang/Runnable;", "runnable", "", "a", "Landroid/content/Context;", "getContext", "Lcom/huachenjie/base/dsbridge_webview/DWebView;", "c", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", "d", "", "startTime", "", "viewTime", "", "receiveFlag", "b", "college_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements LightningPlayJavascript.ILightningPlayProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MoxiPlayFragment f33607a;

            public a(MoxiPlayFragment moxiPlayFragment) {
                this.f33607a = moxiPlayFragment;
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            public void a(@NotNull Runnable runnable) {
                WebContentView webContentView;
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                CollegeFragmentLightningPlayBinding collegeFragmentLightningPlayBindingAccess$getMBinding = MoxiPlayFragment.access$getMBinding(this.f33607a);
                if (collegeFragmentLightningPlayBindingAccess$getMBinding == null || (webContentView = collegeFragmentLightningPlayBindingAccess$getMBinding.f33570a) == null) {
                    return;
                }
                webContentView.post(runnable);
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            public void b(long startTime, int viewTime, boolean receiveFlag) {
                this.f33607a.getMViewModel().k(startTime, viewTime, receiveFlag ? 1 : 0);
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            @Nullable
            public DWebView c() {
                WebContentView webContentView;
                CollegeFragmentLightningPlayBinding collegeFragmentLightningPlayBindingAccess$getMBinding = MoxiPlayFragment.access$getMBinding(this.f33607a);
                if (collegeFragmentLightningPlayBindingAccess$getMBinding == null || (webContentView = collegeFragmentLightningPlayBindingAccess$getMBinding.f33570a) == null) {
                    return null;
                }
                return webContentView.getWebView();
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            @NotNull
            public String d() {
                String value = this.f33607a.getMViewModel().i().getValue();
                return value == null ? "" : value;
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            @Nullable
            public Context getContext() {
                return this.f33607a.getContext();
            }

            @Override // com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.ILightningPlayProvider
            @NotNull
            public Lifecycle getLifecycle() {
                Lifecycle lifecycle = this.f33607a.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "this@MoxiPlayFragment.lifecycle");
                return lifecycle;
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final a m335invoke() {
            return new a(this.this$0);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.college.page.lightningPlay.MoxiPlayFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment$a;", "", "", "url", "Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment;", "a", "KEY_URL", "Ljava/lang/String;", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MoxiPlayFragment a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            MoxiPlayFragment moxiPlayFragment = new MoxiPlayFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            moxiPlayFragment.setArguments(bundle);
            return moxiPlayFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33606a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33606a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33606a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33606a.invoke(obj);
        }
    }

    public static final /* synthetic */ CollegeFragmentLightningPlayBinding access$getMBinding(MoxiPlayFragment moxiPlayFragment) {
        return moxiPlayFragment.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGameUrl() {
        return (String) this.gameUrl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MoxiPlayFragment$jsProvider$2.a getJsProvider() {
        return (MoxiPlayFragment$jsProvider$2.a) this.jsProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUrl() {
        return (String) this.url.getValue();
    }

    public final boolean canGoBack() {
        WebContentView webContentView;
        CollegeFragmentLightningPlayBinding mBinding = getMBinding();
        DWebView webView = (mBinding == null || (webContentView = mBinding.f33570a) == null) ? null : webContentView.getWebView();
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        webView.goBack();
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_fragment_lightning_play;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.emptyMap();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().j();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().i().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.college.page.lightningPlay.MoxiPlayFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CollegeFragmentLightningPlayBinding collegeFragmentLightningPlayBindingAccess$getMBinding;
                WebContentView webContentView;
                DWebView webView;
                if ((str == null || str.length() == 0) || (collegeFragmentLightningPlayBindingAccess$getMBinding = MoxiPlayFragment.access$getMBinding(MoxiPlayFragment.this)) == null || (webContentView = collegeFragmentLightningPlayBindingAccess$getMBinding.f33570a) == null || (webView = webContentView.getWebView()) == null) {
                    return;
                }
                MoxiPlayFragment moxiPlayFragment = MoxiPlayFragment.this;
                a.a(webView, moxiPlayFragment.getJsProvider());
                webView.setWebChromeClient(moxiPlayFragment.mWebChromeClient, true);
                if (TextUtils.isEmpty(moxiPlayFragment.getUrl())) {
                    webView.loadUrl(moxiPlayFragment.getGameUrl());
                } else {
                    webView.loadUrl(moxiPlayFragment.getUrl());
                }
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        WebContentView webContentView;
        DWebView webView;
        WebContentView webContentView2;
        super.onDestroy();
        CollegeFragmentLightningPlayBinding mBinding = getMBinding();
        if (mBinding != null && (webContentView2 = mBinding.f33570a) != null) {
            webContentView2.onDestroy();
        }
        CollegeFragmentLightningPlayBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (webContentView = mBinding2.f33570a) == null || (webView = webContentView.getWebView()) == null) {
            return;
        }
        webView.destroy();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        WebContentView webContentView;
        DWebView webView;
        super.onPause();
        CollegeFragmentLightningPlayBinding mBinding = getMBinding();
        if (mBinding == null || (webContentView = mBinding.f33570a) == null || (webView = webContentView.getWebView()) == null) {
            return;
        }
        webView.onPause();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        WebContentView webContentView;
        DWebView webView;
        super.onResume();
        CollegeFragmentLightningPlayBinding mBinding = getMBinding();
        if (mBinding == null || (webContentView = mBinding.f33570a) == null || (webView = webContentView.getWebView()) == null) {
            return;
        }
        webView.onResume();
    }
}
