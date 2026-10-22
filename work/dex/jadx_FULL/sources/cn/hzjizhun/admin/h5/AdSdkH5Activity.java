package cn.hzjizhun.admin.h5;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;
import cn.hzjizhun.admin.ad.utils.JZAdUtil;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DialogUtils;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.util.ReportUtils;
import com.alipay.sdk.m.y.l;
import com.gyf.immersionbar.b;
import com.zj.adlib.eva;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdSdkH5Activity extends AppCompatActivity {
    public static final String INFUNCTIONPOSID = "inFunctionPosId";
    public static final String ISDOWNLOAD = "isDownload";
    public static final String ISFULLLANDINGPAGE = "isFullLandingPage";
    public static final String ISLANDINGPAGEFLOWSYSTEM = "isLandingPageFlowSystem";
    public static final String ISLANDINGVERTICAL = "isLandingVertical";
    public static final String ISOUTFUNCTION = "isOutFunction";
    public static final String ISSHOWSUREDIALOG = "isShowSureDialog";
    public static final String LANDINGPAGEALPHA = "landingPageAlpha";
    private static final int MSG_DOWNLOAD = 1;
    private static final int MSG_DP = 2;
    public static final String PKG = "PKG";
    public static final String POSPLATNAME = "posPlatName";
    public static final String REPORTKEY = "report_key";
    public static final String TOUCH_MAJOR = "touch_major";
    public static final String TOUCH_MINOR = "touch_minor";
    public static final String URL = "url_str";
    private boolean isShowingDialog;
    private LinearLayout mAdContainer;
    private ImageView mBackIv;
    private boolean mIsOutFunction;
    private boolean mIsShowSureDialog;
    private boolean mIsWebDownload;
    private String mPkg;
    private String mReportKey;
    private TextView mTitleTv;
    private WebView mWebView;
    private MWebChromeClient webChromeClient;
    private MWebViewClient webViewClient;
    private String TAG = "AdSdkH5Activity.....";
    Map<String, String> extraHeaders = new HashMap();
    private int landingPageAlpha = 0;
    private boolean isLandingPageFlowSystem = true;
    private boolean isLandingVertical = true;
    private boolean toggleFullLandingPage = true;
    private float mTouchMinor = 0.0f;
    private float mTouchMajor = 0.0f;
    private final Handler mWebDownloadHandler = new Handler(Looper.getMainLooper()) { // from class: cn.hzjizhun.admin.h5.AdSdkH5Activity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                int i = message.what;
                if (i == 1) {
                    AdSdkH5Activity.this.showDownloadDialog(message.obj.toString());
                } else if (i == 2) {
                    AdSdkH5Activity.this.skipDeeplink(message.obj.toString());
                }
            } catch (Throwable unused) {
            }
        }
    };

    public class MWebChromeClient extends WebChromeClient {
        private MWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            AdSdkH5Activity.this.updateTitle(str);
        }
    }

    private void adClose() {
        AdapterCustomSplashAdLoader.AdCloseListener splashAdListener = AdSdkH5Helper.getSplashAdListener();
        if (splashAdListener != null) {
            splashAdListener.onAdClose();
        }
    }

    private void adjustContainerSize() {
        try {
            int iScreenWidth = DisplayUtil.screenWidth(this);
            int iScreenHeight = DisplayUtil.screenHeight(this);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            boolean z = true;
            if (getResources().getConfiguration().orientation != 1) {
                z = false;
            }
            Log.d(this.TAG, "adjustContainerSize: screenWidth=" + iScreenWidth + ",screenHeight=" + iScreenHeight + ",isPortrait=" + z);
            if (z) {
                attributes.width = iScreenWidth;
                attributes.height = (int) (iScreenWidth * 1.5f);
                attributes.gravity = 80;
            } else {
                attributes.width = (int) (iScreenWidth * 0.5f);
                attributes.height = iScreenHeight;
                attributes.gravity = GravityCompat.END;
            }
            getWindow().setAttributes(attributes);
        } catch (Throwable unused) {
        }
    }

    private void blockAllQuickAppSchemes() {
        try {
            if (this.mIsWebDownload) {
                return;
            }
            this.mWebView.getSettings().setBlockNetworkImage(false);
            this.mWebView.getSettings().setBlockNetworkLoads(false);
        } catch (Throwable unused) {
        }
    }

    private boolean checkIntentQuickApp(Intent intent) {
        Intent intent2;
        if (intent == null) {
            return false;
        }
        try {
            String dataString = intent.getData() != null ? intent.getDataString() : null;
            if (dataString == null && "android.intent.action.CHOOSER".equals(intent.getAction()) && (intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT")) != null && intent2.getData() != null) {
                dataString = intent2.getDataString();
            }
            ALog.d(this.TAG, "checkIntentQuickApp: ...." + dataString);
            if (dataString == null || !isBlockedScheme(dataString)) {
                return false;
            }
            ALog.innerD(this.TAG, "❌ 阻止快应用Intent跳转 (forResult): " + dataString);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse createEmptyResponse() {
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream("<html><body>Blocked</body></html>".getBytes()));
    }

    private void functionAdLogic() {
        if (this.mIsOutFunction) {
            showInsertScreenAd();
        }
    }

    private int getNavigationBarHeight() {
        int identifier = getResources().getIdentifier(b.f6803b, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    public WebResourceResponse getResourceResponse(WebResourceRequest webResourceRequest) {
        try {
            String method = webResourceRequest.getMethod();
            String string = webResourceRequest.getUrl().toString();
            if (!method.equals("GET")) {
                return null;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            HttpURLConnection httpURLConnectionInterceptRedirect = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnectionInterceptRedirect.setRequestMethod(method);
            httpURLConnectionInterceptRedirect.setConnectTimeout(5000);
            httpURLConnectionInterceptRedirect.setDoInput(true);
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(string);
            for (String str : requestHeaders.keySet()) {
                httpURLConnectionInterceptRedirect.setRequestProperty(str, requestHeaders.get(str));
            }
            String strTrim = "";
            if (!TextUtils.isEmpty(cookie)) {
                httpURLConnectionInterceptRedirect.setRequestProperty(com.google.common.net.b.p, cookie.replaceAll(getPackageName(), ""));
            }
            httpURLConnectionInterceptRedirect.setRequestProperty(com.google.common.net.b.c1, this.mPkg);
            httpURLConnectionInterceptRedirect.setInstanceFollowRedirects(true);
            httpURLConnectionInterceptRedirect.connect();
            if (httpURLConnectionInterceptRedirect.getResponseCode() > 300 && httpURLConnectionInterceptRedirect.getResponseCode() < 400) {
                String headerField = httpURLConnectionInterceptRedirect.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    httpURLConnectionInterceptRedirect.disconnect();
                    httpURLConnectionInterceptRedirect = interceptRedirect(headerField, webResourceRequest);
                }
            }
            Map<String, List<String>> headerFields = httpURLConnectionInterceptRedirect.getHeaderFields();
            HashMap map = new HashMap();
            for (String str2 : headerFields.keySet()) {
                Iterator<String> it = headerFields.get(str2).iterator();
                while (it.hasNext()) {
                    map.put(str2, it.next());
                }
            }
            List<String> list = headerFields.get("set-cookie");
            if (list != null && list.size() > 0) {
                for (String str3 : list) {
                    if (!TextUtils.isEmpty(str3)) {
                        cookieManager.setCookie(string, str3.replaceAll(getPackageName(), ""));
                    }
                }
            }
            if (headerFields.get("Content-Type") != null && headerFields.get("Content-Type").size() > 0) {
                String lowerCase = headerFields.get("Content-Type").get(0).toLowerCase();
                if (lowerCase.contains("utf-8")) {
                    lowerCase = lowerCase.replaceAll("(?i)charset=utf-8", "");
                }
                if (lowerCase.contains("utf8")) {
                    lowerCase = lowerCase.replaceAll("(?i)charset=utf8", "");
                }
                strTrim = lowerCase.contains(l.b) ? lowerCase.replaceAll(l.b, "").trim() : lowerCase;
            }
            if (strTrim.contains("html")) {
                loadUrl(string);
                return null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(strTrim, "UTF-8", httpURLConnectionInterceptRedirect.getInputStream());
            webResourceResponse.setResponseHeaders(map);
            return webResourceResponse;
        } catch (Exception unused) {
            return null;
        }
    }

    private int getStatusBarHeightWithWindowInsets() {
        int identifier = getResources().getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void initIntentExtra() {
        this.mIsWebDownload = getIntent().getBooleanExtra("isDownload", false);
        this.mReportKey = getIntent().getStringExtra(REPORTKEY);
        this.mIsOutFunction = getIntent().getBooleanExtra(ISOUTFUNCTION, false);
        this.mIsShowSureDialog = getIntent().getBooleanExtra(ISSHOWSUREDIALOG, false);
        this.mPkg = getIntent().getStringExtra(PKG);
        this.toggleFullLandingPage = getIntent().getBooleanExtra(ISFULLLANDINGPAGE, true);
        this.landingPageAlpha = getIntent().getIntExtra(LANDINGPAGEALPHA, 0);
        this.isLandingVertical = getIntent().getBooleanExtra(ISLANDINGVERTICAL, true);
        this.isLandingPageFlowSystem = getIntent().getBooleanExtra(ISLANDINGPAGEFLOWSYSTEM, true);
    }

    private void initTouchParams() {
        try {
            this.mTouchMinor = eva.e().d(TOUCH_MINOR);
            this.mTouchMajor = eva.e().d(TOUCH_MAJOR);
        } catch (Throwable unused) {
        }
    }

    private void initView() {
        setViewSize();
        this.mBackIv = (ImageView) findViewById(R.id.ad_sdk_h5_back_iv);
        this.mTitleTv = (TextView) findViewById(R.id.ad_sdk_h5_title_tv);
        this.mWebView = (WebView) findViewById(R.id.ad_sdk_h5_wv);
        initWebView();
        this.mBackIv.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdSdkH5Activity.this.finish();
            }
        });
    }

    private void initWebView() {
        this.extraHeaders.put(com.google.common.net.b.c1, this.mPkg);
        this.mWebView.setVisibility(8);
        this.mWebView.getSettings().setSaveFormData(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDatabaseEnabled(true);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.mWebView.getSettings().setMixedContentMode(0);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.setFocusable(true);
        this.mWebView.setFocusableInTouchMode(true);
        this.mWebView.requestFocusFromTouch();
        this.mWebView.requestFocus();
        this.webViewClient = new MWebViewClient();
        this.webChromeClient = new MWebChromeClient();
        this.mWebView.setDownloadListener(null);
        this.mWebView.setWebViewClient(this.webViewClient);
        this.mWebView.setWebChromeClient(this.webChromeClient);
    }

    private HttpURLConnection interceptRedirect(String str, WebResourceRequest webResourceRequest) throws IOException {
        URL url = new URL(str);
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setDoInput(true);
        String cookie = CookieManager.getInstance().getCookie(str);
        for (String str2 : requestHeaders.keySet()) {
            httpURLConnection.setRequestProperty(str2, requestHeaders.get(str2));
        }
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.setRequestProperty(com.google.common.net.b.p, cookie.replaceAll(getPackageName(), ""));
        }
        httpURLConnection.setRequestProperty(com.google.common.net.b.c1, this.mPkg);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.connect();
        return (httpURLConnection.getResponseCode() <= 300 || httpURLConnection.getResponseCode() >= 400) ? httpURLConnection : interceptRedirect(httpURLConnection.getHeaderField("Location"), webResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBlockedScheme(String str) {
        if (!TextUtils.isEmpty(str) && !this.mIsWebDownload) {
            try {
                List<String> qList = FunctionConfig.instance().getQList();
                if (qList != null && !qList.isEmpty()) {
                    String lowerCase = str.toLowerCase();
                    String strDecode = URLDecoder.decode(lowerCase, "UTF-8");
                    for (String str2 : qList) {
                        if (!TextUtils.isEmpty(str2) && (lowerCase.contains(str2) || strDecode.contains(str2))) {
                            ALog.innerD(this.TAG, "检测到快应用: " + str2);
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void loadUrl(String str) {
        try {
            WebView webView = this.mWebView;
            if (webView == null || str == null) {
                return;
            }
            webView.loadUrl(str, this.extraHeaders);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean overrideUrlLoadingUrl(String str) {
        try {
            if (isBlockedScheme(str)) {
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("http")) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.obj = str;
                    this.mWebDownloadHandler.sendMessage(messageObtain);
                    return true;
                }
                if (str.endsWith(".apk") && this.mIsWebDownload) {
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 1;
                    messageObtain2.obj = str;
                    this.mWebDownloadHandler.sendMessage(messageObtain2);
                    ReportUtils.getInstance().h5ActionReport(this.mReportKey, 1);
                    return true;
                }
                ALog.innerD(this.TAG, "overrideUrlLoadingUrl: ............." + str);
                ReportUtils.getInstance().h5ActionReport(this.mReportKey, 0);
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private void setViewSize() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.llRoot);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ad_container);
        this.mAdContainer = linearLayout;
        if (Build.VERSION.SDK_INT >= 35) {
            linearLayout.setPadding(0, getStatusBarHeightWithWindowInsets(), 0, getNavigationBarHeight());
        }
        if (this.toggleFullLandingPage) {
            return;
        }
        if (!this.isLandingPageFlowSystem) {
            if (this.isLandingVertical) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(0);
            }
        }
        relativeLayout.setBackgroundColor(Color.argb(this.landingPageAlpha, 0, 0, 0));
        adjustContainerSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadDialog(final String str) {
        if (this.isShowingDialog) {
            return;
        }
        this.isShowingDialog = true;
        DialogUtils.show(this, "是否下载应用", new AdSdkH5Helper.DialogCallback() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Activity.5
            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void cancel() {
                AdSdkH5Activity.this.isShowingDialog = false;
            }

            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void sure() {
                AdSdkH5Activity.this.skipBrowserDownload(str);
                AdSdkH5Activity.this.isShowingDialog = false;
            }
        });
    }

    private void showInsertScreenAd() {
        String stringExtra = getIntent().getStringExtra(INFUNCTIONPOSID);
        JZNativeAd jZNativeAd = new JZNativeAd(this);
        jZNativeAd.setJZAdId(stringExtra);
        jZNativeAd.setInFunctionAd(true);
        jZNativeAd.setJZAdListener(new JZNativeAdListener() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Activity.4
            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClick(JZNativeAdInfo jZNativeAdInfo) {
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZNativeAdListener
            public void onAdClick(JZNativeAdInfo jZNativeAdInfo, String str) {
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClose(JZNativeAdInfo jZNativeAdInfo) {
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdExpose(JZNativeAdInfo jZNativeAdInfo) {
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdFailed(JZAdError jZAdError) {
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZNativeAdListener
            public void onAdReceive(List<JZNativeAdInfo> list) {
                try {
                    JZAdUtil.showJZNativeAdConvenient(AdSdkH5Activity.this, list.get(0), true, this);
                } catch (Throwable unused) {
                }
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZNativeAdListener
            public void onRenderFailed(JZNativeAdInfo jZNativeAdInfo, JZAdError jZAdError) {
            }
        });
        jZNativeAd.loadJZAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipBrowserDownload(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(805339136);
            startActivity(intent);
            ReportUtils.getInstance().h5ActionReport(this.mReportKey, 1);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipDeeplink(String str) {
        AdSdkH5Helper.skipDeeplink(this, str, "", this.mIsShowSureDialog, new AdSdkH5Helper.DialogCallback() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Activity.2
            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void cancel() {
            }

            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void sure() {
                ReportUtils.getInstance().deepLinkSuccessReport(AdSdkH5Activity.this.mReportKey);
                ReportUtils.getInstance().h5ActionReport(AdSdkH5Activity.this.mReportKey, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitle(String str) {
        if (str != null) {
            this.mTitleTv.setText(str);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mTouchMinor == 0.0f || this.mTouchMajor == 0.0f) {
                this.mTouchMinor = motionEvent.getTouchMinor();
                this.mTouchMajor = motionEvent.getTouchMajor();
                eva.e().g(TOUCH_MINOR, this.mTouchMinor);
                eva.e().g(TOUCH_MAJOR, this.mTouchMinor);
            }
        } catch (Throwable unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            WebView webView = this.mWebView;
            if (webView != null && webView.canGoBack()) {
                this.mWebView.goBack();
            } else {
                adClose();
                super.onBackPressed();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.toggleFullLandingPage) {
            return;
        }
        adjustContainerSize();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.jz_activity_ad_sdk_h5);
        if (getIntent() == null) {
            finish();
            return;
        }
        initIntentExtra();
        initTouchParams();
        initView();
        functionAdLogic();
        String stringExtra = getIntent().getStringExtra("url_str");
        loadUrl(stringExtra);
        ALog.d(this.TAG, "loadUrl:" + stringExtra);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            adClose();
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.onPause();
                this.mWebView.pauseTimers();
                this.mWebView.stopLoading();
                this.mWebView.loadUrl("about:blank");
                this.mWebView.clearHistory();
                this.mWebView.removeAllViews();
                ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mWebView);
                }
                this.mWebView.destroy();
                this.mWebView = null;
            }
            ReportUtils.getInstance().h5CloseReport(this.mReportKey);
            ReportUtils.getInstance().removeReport(this.mReportKey);
            this.mWebDownloadHandler.removeCallbacksAndMessages(null);
            super.onDestroy();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        ALog.d(this.TAG, "startActivities: ...." + intentArr);
        if (intentArr != null && intentArr.length > 0) {
            for (Intent intent : intentArr) {
                if (checkIntentQuickApp(intent)) {
                    return;
                }
            }
        }
        super.startActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        ALog.d(this.TAG, "startActivity: ....");
        super.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (checkIntentQuickApp(intent)) {
            return;
        }
        super.startActivityForResult(intent, i);
    }

    public class MWebViewClient extends WebViewClient {
        private MWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            ALog.innerD(AdSdkH5Activity.this.TAG, "onLoadResource: " + str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ALog.innerD(AdSdkH5Activity.this.TAG, "onPageFinished: ............." + str);
            try {
                ReportUtils.getInstance().h5loadCompleteReport(AdSdkH5Activity.this.mReportKey);
                if (str.equals(AdSdkH5Activity.this.getIntent().getStringExtra("url_str"))) {
                    return;
                }
                ReportUtils.getInstance().h5CloseReport(AdSdkH5Activity.this.mReportKey);
            } catch (Throwable unused) {
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AdSdkH5Activity.this.showWebView();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            ALog.innerD(AdSdkH5Activity.this.TAG, "onReceivedError errorCode:" + i + ",description:" + str);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                String string = webResourceRequest.getUrl().toString();
                if (!AdSdkH5Activity.this.isBlockedScheme(string)) {
                    WebResourceResponse resourceResponse = AdSdkH5Activity.this.getResourceResponse(webResourceRequest);
                    return resourceResponse != null ? resourceResponse : super.shouldInterceptRequest(webView, webResourceRequest);
                }
                ALog.innerD(AdSdkH5Activity.this.TAG, "拦截快应用scheme请求: " + string);
                return AdSdkH5Activity.this.createEmptyResponse();
            } catch (Exception unused) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ALog.innerD(AdSdkH5Activity.this.TAG, "shouldOverrideUrlLoading url:" + str);
            if (AdSdkH5Activity.this.overrideUrlLoadingUrl(str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (AdSdkH5Activity.this.overrideUrlLoadingUrl(webResourceRequest.getUrl().toString())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, @Nullable Bundle bundle) {
        ALog.d(this.TAG, "startActivity: ....");
        super.startActivity(intent, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(@NonNull Intent intent, int i, @Nullable Bundle bundle) {
        ALog.d(this.TAG, "startActivityForResult: ....");
        super.startActivityForResult(intent, i, bundle);
    }
}
