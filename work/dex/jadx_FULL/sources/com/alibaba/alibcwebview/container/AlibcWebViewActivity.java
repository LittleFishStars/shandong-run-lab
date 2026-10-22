package com.alibaba.alibcwebview.container;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.utils.ResourceUtils;
import com.alibaba.alibcwebview.callback.INativeToJsCallback;
import com.alibaba.alibcwebview.messagebus.AlibcMessageListener;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcWebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23702a = "AlibcWebViewActivity";
    private a b;
    private boolean c = true;
    private BCWebView d;
    private TextView e;
    private View f;
    private View g;
    private View h;

    public class a extends AlibcMessageListener {
        public a() {
        }

        @Override // com.alibaba.alibcwebview.messagebus.AlibcMessageListener
        public final void a(Object obj) {
            if (obj instanceof String) {
                AlibcWebViewActivity.this.e.setText(String.valueOf(obj));
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MiscDO misc;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null || (misc = config.getMisc()) == null) {
            return;
        }
        if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(misc.getBackControl())) {
            com.alibaba.alibcwebview.jsbridge.b.a(this.d, "bcBackEvent", new JSONObject().toJSONString(), new INativeToJsCallback() { // from class: com.alibaba.alibcwebview.container.AlibcWebViewActivity.3
                @Override // com.alibaba.alibcwebview.callback.INativeToJsCallback
                public final void a(boolean z) {
                    if (z) {
                        return;
                    }
                    if (AlibcWebViewActivity.this.d.canGoBack()) {
                        AlibcWebViewActivity.this.d.goBack();
                    } else {
                        AlibcWebViewActivity.this.finish();
                    }
                }
            });
        } else if (this.d.canGoBack()) {
            this.d.goBack();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        requestWindowFeature(1);
        super.onCreate(bundle);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_bc_webview_activity"), (ViewGroup) null);
        BCWebView bCWebView = new BCWebView(this);
        this.d = bCWebView;
        c.a(bCWebView, this);
        linearLayout.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.e = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.g = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        this.h = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        this.f = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
        try {
            if ("true".equals(getIntent().getStringExtra("disableNav"))) {
                z = false;
            }
            this.c = z;
            if (z) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        } catch (Exception e) {
            AlibcLogger.e(f23702a, "get intent exception: " + e.getMessage());
        }
        View view = this.g;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.alibcwebview.container.AlibcWebViewActivity.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MiscDO misc;
                    ConfigDO config = AlibcConfigService.getInstance().getConfig();
                    if (config == null || (misc = config.getMisc()) == null) {
                        return;
                    }
                    if (!AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(misc.getBackControl())) {
                        AlibcWebViewActivity.this.finish();
                    } else {
                        com.alibaba.alibcwebview.jsbridge.b.a(AlibcWebViewActivity.this.d, "bcBackEvent", new JSONObject().toJSONString(), new INativeToJsCallback() { // from class: com.alibaba.alibcwebview.container.AlibcWebViewActivity.1.1
                            @Override // com.alibaba.alibcwebview.callback.INativeToJsCallback
                            public final void a(boolean z2) {
                                if (z2) {
                                    return;
                                }
                                AlibcWebViewActivity.this.finish();
                            }
                        });
                    }
                }
            });
        }
        View view2 = this.h;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.alibcwebview.container.AlibcWebViewActivity.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    AlibcWebViewActivity.this.onBackPressed();
                }
            });
        }
        try {
            String stringExtra = getIntent().getStringExtra("bc_webview_activity_title");
            if (TextUtils.isEmpty(stringExtra)) {
                this.b = new a();
                com.alibaba.alibcwebview.messagebus.a.a().a((AlibcMessageListener) this.b);
            } else {
                this.e.setText(stringExtra);
            }
        } catch (Exception e2) {
            AlibcLogger.e(f23702a, "拒绝服务漏洞: " + e2.getMessage());
        }
        try {
            String stringExtra2 = getIntent().getStringExtra(PerfId.loadUrl);
            AlibcLogger.i(f23702a, "加载的url: " + stringExtra2);
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.d.loadUrl(stringExtra2);
        } catch (Exception e3) {
            AlibcLogger.e(f23702a, "拒绝服务漏洞: " + e3.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        BCWebView bCWebView = this.d;
        if (bCWebView != null) {
            ViewGroup viewGroup = (ViewGroup) bCWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.d);
            }
            this.d.removeAllViews();
            this.d.destroy();
        }
        if (this.b != null) {
            com.alibaba.alibcwebview.messagebus.a.a().a((AlibcMessageListener) this.b);
        }
        AlibcTradeContext.getInstance().mWebView = null;
        AlibcTradeContext.getInstance().mActivity = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.resumeTimers();
    }
}
