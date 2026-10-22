package android.taobao.windvane.jsbridge.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.d.b;
import android.taobao.windvane.jsbridge.IExtJsApiSuccessCallBack;
import android.taobao.windvane.jsbridge.IJsApiFailedCallBack;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginEntryManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.zj.adlib.o61;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVBridgeDelegateImpl implements IBridgeDelegateService {
    private static final String FAILURE_CALLBACK_PREFIX = "javascript:window.__windvane__&&window.__windvane__.onFailure&&window.__windvane__.onFailure";
    private static final String SUCCESS_CALLBACK_PREFIX = "javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess";
    private static final ExecutorService sExecutors = Executors.newFixedThreadPool(2);
    private WVPluginEntryManager entryManager;
    private b mWebview;

    /* JADX INFO: Access modifiers changed from: private */
    public String formatJsonString(String str) {
        if (str.contains("\u2028")) {
            try {
                str = str.replace("\u2028", "\\u2028");
            } catch (Exception unused) {
            }
        }
        if (str.contains("\u2029")) {
            try {
                str = str.replace("\u2029", "\\u2029");
            } catch (Exception unused2) {
            }
        }
        return str.replace(o61.h, "\\\\").replace("'", "\\'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCallbackJs(boolean z, String str, String str2) {
        if (z) {
            return "javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess('" + str + "','" + str2 + "');";
        }
        return "javascript:window.__windvane__&&window.__windvane__.onFailure&&window.__windvane__.onFailure('" + str + "','" + str2 + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                b bVar = this.mWebview;
                if (bVar != null) {
                    bVar.getView().post(runnable);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void addEntry(String str, Object obj) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.addEntry(str, obj);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void fireEvent(String str, String str2) {
        b bVar = this.mWebview;
        if (bVar == null) {
            TaoLog.e(IBridgeDelegateService.TAG, "cannot fireEvent for [webview=null]");
        } else {
            WVCallBackContext.fireEvent(bVar, str, str2);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public Object getEntry(String str) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager == null) {
            return null;
        }
        return wVPluginEntryManager.getEntry(str);
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void hybridCall(b bVar, String str) {
        if (this.mWebview == null) {
            TaoLog.e(IBridgeDelegateService.TAG, "cannot load for [webview=null]");
        } else {
            WVJsBridge.getInstance().callMethod(bVar, str);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void initBridge(Context context, b bVar) {
        WVJsBridge.getInstance().init();
        this.entryManager = new WVPluginEntryManager(context, bVar);
        this.mWebview = bVar;
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void loadUrl(String str) {
        b bVar = this.mWebview;
        if (bVar == null) {
            TaoLog.e(IBridgeDelegateService.TAG, "cannot load for [webview=null]");
        } else {
            bVar.loadUrl(str);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void nativeCall(String str, String str2, final String str3, final String str4) {
        final WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit == null || strArrSplit.length != 2) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.NO_METHOD);
            new WVCallBackContext(this.mWebview, str3, "", "", null, null).error(wVResult);
            return;
        }
        wVCallMethodContext.objectName = strArrSplit[0];
        wVCallMethodContext.methodName = strArrSplit[1];
        wVCallMethodContext.webview = this.mWebview;
        wVCallMethodContext.token = str3;
        wVCallMethodContext.params = str2;
        if (TextUtils.isEmpty(str2)) {
            wVCallMethodContext.params = "{}";
        }
        wVCallMethodContext.succeedCallBack = new IExtJsApiSuccessCallBack() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.1
            @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
            public void succeed(String str5) {
                if (TextUtils.isEmpty(str5)) {
                    str5 = "{}";
                }
                final String callbackJs = WVBridgeDelegateImpl.this.getCallbackJs(true, str3, WVBridgeDelegateImpl.this.formatJsonString(str5));
                WVBridgeDelegateImpl.this.runOnUiThread(new Runnable() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WVBridgeDelegateImpl.this.mWebview.evaluateJavascript(callbackJs);
                    }
                });
            }

            @Override // android.taobao.windvane.jsbridge.IExtJsApiSuccessCallBack
            public void successAndKeepAlive(String str5) {
                if (TextUtils.isEmpty(str5)) {
                    str5 = "{}";
                }
                final String str6 = "javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess('" + str3 + "','" + WVBridgeDelegateImpl.this.formatJsonString(str5) + "', true);";
                WVBridgeDelegateImpl.this.runOnUiThread(new Runnable() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WVBridgeDelegateImpl.this.mWebview.evaluateJavascript(str6);
                    }
                });
            }
        };
        wVCallMethodContext.failedCallBack = new IJsApiFailedCallBack() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.2
            @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
            public void fail(String str5) {
                if (TextUtils.isEmpty(str5)) {
                    str5 = "{}";
                }
                final String callbackJs = WVBridgeDelegateImpl.this.getCallbackJs(false, str3, WVBridgeDelegateImpl.this.formatJsonString(str5));
                WVBridgeDelegateImpl.this.runOnUiThread(new Runnable() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WVBridgeDelegateImpl.this.mWebview.evaluateJavascript(callbackJs);
                    }
                });
            }
        };
        sExecutors.submit(new Runnable() { // from class: android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl.3
            @Override // java.lang.Runnable
            public void run() {
                WVJsBridge.getInstance().callMethod(wVCallMethodContext, str4);
            }
        });
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void onActivityResult(int i, int i2, Intent intent) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void onDestroy() {
        WVJsBridge.getInstance().tryToRunTailBridges();
        this.entryManager.onDestroy();
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void onPause() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onPause();
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void onResume() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onResume();
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.taobao.windvane.base.IBridgeDelegateService
    public void setEnabled(boolean z) {
        WVJsBridge.getInstance().setEnabled(z);
    }
}
