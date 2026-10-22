package com.huachenjie.base.dsbridge_webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.alibaba.ariver.kernel.RVParams;
import com.blankj.utilcode.util.KeyboardUtils;
import com.gyf.immersionbar.e;
import com.huachenjie.base.R;
import com.huachenjie.base.dsbridge_webview.interceptor.CloseInterceptor;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.zj.adlib.c25;
import com.zj.adlib.cr2;
import com.zj.adlib.i4a;
import com.zj.adlib.lu9;
import com.zj.adlib.pu9;
import com.zj.adlib.vk0;
import com.zj.adlib.zn1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DWebViewActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WebContentView f7185a;
    public boolean c;
    public boolean g;
    public String t;
    public String x;
    public String y;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WebChromeClient f7184a = new a();
    public boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BroadcastReceiver f32909a = new BroadcastReceiver() { // from class: com.huachenjie.base.dsbridge_webview.DWebViewActivity.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DWebViewActivity.this.t0();
        }
    };

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f32911a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WebChromeClient.CustomViewCallback f7186a;

        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebContentView webContentView = DWebViewActivity.this.f7185a;
            if (webContentView == null || webContentView.getWebView() == null || DWebViewActivity.this.f7185a.getCustomViewContent() == null) {
                return;
            }
            DWebViewActivity.this.f7185a.getWebView().setVisibility(0);
            DWebViewActivity.this.f7185a.getCustomViewContent().setVisibility(8);
            if (this.f32911a == null) {
                return;
            }
            DWebViewActivity.this.f7185a.getCustomViewContent().removeView(this.f32911a);
            WebChromeClient.CustomViewCallback customViewCallback = this.f7186a;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
            this.f32911a = null;
            DWebViewActivity.this.setRequestedOrientation(1);
            super.onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            WebContentView webContentView = DWebViewActivity.this.f7185a;
            if (webContentView == null || webContentView.getWebView() == null || DWebViewActivity.this.f7185a.getCustomViewContent() == null) {
                return;
            }
            if (this.f32911a != null) {
                callback.onCustomViewHidden();
                return;
            }
            this.f32911a = view;
            DWebViewActivity.this.f7185a.getCustomViewContent().setVisibility(0);
            DWebViewActivity.this.f7185a.getCustomViewContent().addView(this.f32911a);
            this.f7186a = callback;
            DWebViewActivity.this.f7185a.getWebView().setVisibility(8);
            DWebViewActivity.this.setRequestedOrientation(0);
        }
    }

    public class b implements KeyboardUtils.OnSoftInputChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32912a = 0;

        public b() {
        }

        @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
        public void a(int height) {
            DWebView webView;
            if (this.f32912a == 0 && height > 0) {
                this.f32912a = height;
            }
            if (this.f32912a <= 0 || (webView = DWebViewActivity.this.f7185a.getWebView()) == null) {
                return;
            }
            webView.loadUrl("javascript:onKeyboardHeightChange(" + height + ");void(0);");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean s0(Object obj) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            i4a.a("on web close:" + jSONObject);
            CloseInterceptor closeInterceptorA = lu9.a(this.y);
            if (closeInterceptorA != null) {
                closeInterceptorA.a(this, jSONObject);
            }
        }
        finish();
        return false;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return zn1.a(R.color.black);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public CharSequence X() {
        return TextUtils.isEmpty(this.t) ? "" : this.t;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.activity_dwebview;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
        this.t = intent.getStringExtra("title");
        this.x = intent.getStringExtra("url");
        this.c = intent.getBooleanExtra(RVParams.LONG_SHOW_TOOLBAR, false);
        this.g = intent.getBooleanExtra("forbidBack", false);
        this.y = intent.getStringExtra("closeInterceptorName");
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        EventBus.f().v(this);
        pu9.registerReceiver(this, this.f32909a);
        o0();
        WebContentView webContentView = (WebContentView) findViewById(R.id.dWebContentView);
        this.f7185a = webContentView;
        webContentView.getWebView().setJavascriptCloseWindowListener(new DWebView.JavascriptCloseWindowListener() { // from class: com.zj.adlib.o52
            @Override // com.huachenjie.base.dsbridge_webview.DWebView.JavascriptCloseWindowListener
            public final boolean a(Object obj) {
                return this.f43674a.s0(obj);
            }
        });
        this.f7185a.getWebView().setLifecycle(getLifecycle());
        u0(this.f7185a.getWebView());
        if (!TextUtils.isEmpty(this.x)) {
            this.f7185a.getWebView().loadUrl(this.x);
        }
        p0();
    }

    public WebContentView n0() {
        return this.f7185a;
    }

    public final void o0() {
        View viewFindViewById = findViewById(R.id.headerBar);
        if (viewFindViewById == null) {
            return;
        }
        if (!this.c) {
            viewFindViewById.setVisibility(8);
            return;
        }
        ViewDataBinding viewDataBindingBind = DataBindingUtil.bind(viewFindViewById);
        if (viewDataBindingBind == null) {
            return;
        }
        BindingTitleBean backClick = new BindingTitleBean().setStatusBarHeight(cr2.b(this, e.H0(this))).setBackground(-1).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.p52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43906a.q0(view);
            }
        });
        int i = R.color.color_2C3E50;
        viewDataBindingBind.setVariable(vk0.m0, backClick.setBackTintColor(Integer.valueOf(zn1.a(i))).setLeftSubIconShow(true).setLeftSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.q52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44127a.r0(view);
            }
        }).setLeftSubIconResId(R.drawable.ic_home).setLeftSubIconTintColor(Integer.valueOf(zn1.a(i))).setTitleTextColor(zn1.a(i)).setTitleName(TextUtils.isEmpty(this.t) ? "" : this.t));
        viewDataBindingBind.executePendingBindings();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f7185a.getWebView().canGoBack()) {
            this.f7185a.getWebView().goBack();
            return;
        }
        if (!this.g) {
            super.onBackPressed();
        } else if (this.f7185a.loadFail()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.f().A(this);
        pu9.unregisterReceiver(this, this.f32909a);
        this.f7185a.onDestroy();
        KeyboardUtils.v(getWindow());
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String code) {
        c25.p(code);
        WebContentView webContentView = this.f7185a;
        if (webContentView == null || webContentView.getWebView() == null || isFinishing()) {
            return;
        }
        this.f7185a.getWebView().onWechatAuth(code);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f7185a.getWebView().callHandler("setVisible", new Object[]{Boolean.FALSE});
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h) {
            this.h = false;
        } else {
            this.f7185a.getWebView().callHandler("setVisible", new Object[]{Boolean.TRUE});
        }
    }

    public final void p0() {
        KeyboardUtils.p(getWindow(), new b());
    }

    public void t0() {
        WebContentView webContentView;
        if (isFinishing() || (webContentView = this.f7185a) == null || webContentView.getWebView() == null) {
            return;
        }
        this.f7185a.getWebView().reload();
    }

    public void u0(DWebView webView) {
        webView.setWebChromeClient(this.f7184a);
    }
}
