package android.taobao.windvane.jsbridge;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.d.b;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.JSON;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@SuppressLint({"NewApi"})
public class WVJsBridge implements Handler.Callback {
    public static final int CALL_ALIAS = 7;
    public static final int CALL_DESTROY = 8;
    public static final int CALL_EXECUTE = 0;
    public static final int CALL_METHOD = 1;
    public static final int CLOSED = 4;
    public static final int ERROR_EXECUTE = 6;
    public static final int NO_CLASS = 5;
    public static final int NO_METHOD = 2;
    public static final int NO_PERMISSION = 3;
    public static boolean enableGetParamByJs = true;
    private static Handler mHandler;
    private static WVJsBridge mJsBridge;
    private boolean mSkipPreprocess;
    private boolean enabled = true;
    private boolean isInit = false;
    public ArrayList<WVCallMethodContext> mTailBridges = null;

    private WVJsBridge() {
        mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public static void aftercallMethod(WVCallMethodContext wVCallMethodContext, String str) {
        Map<String, String> originalPlugin = WVPluginManager.getOriginalPlugin(wVCallMethodContext.objectName, wVCallMethodContext.methodName);
        if (originalPlugin != null) {
            if (TaoLog.getLogStatus()) {
                TaoLog.i(IBridgeDelegateService.TAG, "call method through alias name. newObject: " + originalPlugin.get("name") + " newMethod: " + originalPlugin.get("method"));
            }
            wVCallMethodContext.objectName = originalPlugin.get("name");
            wVCallMethodContext.methodName = originalPlugin.get("method");
            startCall(7, wVCallMethodContext);
        }
        Object jsObject = wVCallMethodContext.webview.getJsObject(wVCallMethodContext.objectName);
        if (jsObject == null) {
            TaoLog.e(IBridgeDelegateService.TAG, "hybridCall: Plugin " + wVCallMethodContext.objectName + " didn't found, you should call WVPluginManager.registerPlugin first.");
            startCall(5, wVCallMethodContext);
            return;
        }
        if (jsObject instanceof WVApiPlugin) {
            TaoLog.i(IBridgeDelegateService.TAG, "call method=[" + wVCallMethodContext.objectName + Consts.DOT + wVCallMethodContext.methodName + "].");
            wVCallMethodContext.classinstance = jsObject;
            startCall(0, wVCallMethodContext);
            return;
        }
        if (jsObject instanceof String) {
            TaoLog.e(IBridgeDelegateService.TAG, "cannot call method for context is null");
            startCall(8, wVCallMethodContext);
            return;
        }
        try {
            if (wVCallMethodContext.methodName != null) {
                Method method = jsObject.getClass().getMethod(wVCallMethodContext.methodName, Object.class, String.class);
                if (method.isAnnotationPresent(WindVaneInterface.class)) {
                    wVCallMethodContext.classinstance = jsObject;
                    wVCallMethodContext.method = method;
                    startCall(1, wVCallMethodContext);
                } else {
                    TaoLog.w(IBridgeDelegateService.TAG, "hybridCall: Method " + wVCallMethodContext.methodName + " didn't has @WindVaneInterface annotation, obj=" + wVCallMethodContext.objectName);
                }
            }
        } catch (NoSuchMethodException unused) {
            TaoLog.e(IBridgeDelegateService.TAG, "hybridCall: Method " + wVCallMethodContext.methodName + " didn't found. It must has two parameter, Object.class and String.class, obj=" + wVCallMethodContext.objectName);
        }
    }

    public static WVJsBridge getInstance() {
        if (mJsBridge == null) {
            synchronized (WVJsBridge.class) {
                if (mJsBridge == null) {
                    mJsBridge = new WVJsBridge();
                }
            }
        }
        return mJsBridge;
    }

    private WVCallMethodContext getRequest(String str) {
        if (str != null && str.startsWith("hybrid://")) {
            try {
                WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
                int iIndexOf = str.indexOf(58, 9);
                wVCallMethodContext.objectName = str.substring(9, iIndexOf);
                int iIndexOf2 = str.indexOf(47, iIndexOf);
                wVCallMethodContext.token = str.substring(iIndexOf + 1, iIndexOf2);
                int iIndexOf3 = str.indexOf(63, iIndexOf2);
                if (iIndexOf3 > 0) {
                    wVCallMethodContext.methodName = str.substring(iIndexOf2 + 1, iIndexOf3);
                    String strSubstring = str.substring(iIndexOf3 + 1);
                    wVCallMethodContext.params = strSubstring;
                    if (TextUtils.isEmpty(strSubstring)) {
                        wVCallMethodContext.params = "{}";
                    }
                } else {
                    wVCallMethodContext.methodName = str.substring(iIndexOf2 + 1);
                }
                if (wVCallMethodContext.objectName.length() > 0 && wVCallMethodContext.token.length() > 0 && wVCallMethodContext.methodName.length() > 0) {
                    return wVCallMethodContext;
                }
            } catch (StringIndexOutOfBoundsException unused) {
            }
        }
        return null;
    }

    public static void startCall(int i, WVCallMethodContext wVCallMethodContext) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.obj = wVCallMethodContext;
        mHandler.sendMessage(messageObtain);
    }

    public void callMethod(b bVar, String str) {
        callMethod(bVar, str, null, null);
    }

    public void destroy() {
        this.isInit = false;
    }

    public void exCallMethod(WVPluginEntryManager wVPluginEntryManager, WVCallMethodContext wVCallMethodContext, IJsApiFailedCallBack iJsApiFailedCallBack, IJsApiSucceedCallBack iJsApiSucceedCallBack) {
        if (wVCallMethodContext != null) {
            wVCallMethodContext.failedCallBack = iJsApiFailedCallBack;
            wVCallMethodContext.succeedCallBack = iJsApiSucceedCallBack;
            String str = wVCallMethodContext.objectName;
            if (str != null) {
                Object entry = wVPluginEntryManager.getEntry(str);
                wVCallMethodContext.classinstance = entry;
                if (!(entry instanceof WVApiPlugin)) {
                    startCall(2, wVCallMethodContext);
                } else {
                    TaoLog.i(IBridgeDelegateService.TAG, "call new method execute.");
                    startCall(0, wVCallMethodContext);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        WVCallMethodContext wVCallMethodContext = (WVCallMethodContext) message.obj;
        if (wVCallMethodContext == null) {
            TaoLog.e(IBridgeDelegateService.TAG, "CallMethodContext is null, and do nothing.");
            return false;
        }
        WVCallBackContext wVCallBackContext = new WVCallBackContext(wVCallMethodContext.webview, wVCallMethodContext.token, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.succeedCallBack, wVCallMethodContext.failedCallBack);
        String str = "{}";
        switch (message.what) {
            case 0:
                if (((WVApiPlugin) wVCallMethodContext.classinstance).executeSafe(wVCallMethodContext.methodName, TextUtils.isEmpty(wVCallMethodContext.params) ? "{}" : wVCallMethodContext.params, wVCallBackContext)) {
                    try {
                        ConcurrentHashMap<String, Integer> concurrentHashMap = b.f21207a;
                        String str2 = wVCallMethodContext.objectName + Consts.DOT + wVCallMethodContext.methodName;
                        concurrentHashMap.put(str2, concurrentHashMap.containsKey(str2) ? Integer.valueOf(concurrentHashMap.get(str2).intValue() + 1) : 1);
                        break;
                    } catch (Exception unused) {
                    }
                } else {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.w(IBridgeDelegateService.TAG, "WVApiPlugin execute failed.object:" + wVCallMethodContext.objectName + ", method: " + wVCallMethodContext.methodName);
                    }
                    startCall(6, wVCallMethodContext);
                }
                return true;
            case 1:
                Object obj = wVCallMethodContext.classinstance;
                try {
                    Method method = wVCallMethodContext.method;
                    Object[] objArr = new Object[2];
                    objArr[0] = wVCallBackContext;
                    if (!TextUtils.isEmpty(wVCallMethodContext.params)) {
                        str = wVCallMethodContext.params;
                    }
                    objArr[1] = str;
                    method.invoke(obj, objArr);
                    break;
                } catch (Exception e) {
                    TaoLog.e(IBridgeDelegateService.TAG, "call method " + wVCallMethodContext.method + " exception. " + e.getMessage());
                }
                return true;
            case 2:
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.NO_METHOD);
                StringBuilder sb = new StringBuilder();
                sb.append("No Method Error: method=[");
                sb.append(wVCallMethodContext.objectName);
                sb.append(Consts.DOT);
                sb.append(wVCallMethodContext.methodName);
                sb.append("]");
                sb.append(",url=[");
                sb.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb.append("]");
                wVResult.addData("msg", sb.toString());
                wVCallBackContext.error(wVResult);
                return true;
            case 3:
                WVResult wVResult2 = new WVResult();
                wVResult2.setResult(WVResult.NO_PERMISSION);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("method=[");
                sb2.append(wVCallMethodContext.objectName);
                sb2.append(Consts.DOT);
                sb2.append(wVCallMethodContext.methodName);
                sb2.append("]");
                sb2.append(",url=[");
                sb2.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb2.append("]");
                wVResult2.addData("msg", sb2.toString());
                wVCallBackContext.error(wVResult2);
                return true;
            case 4:
                WVResult wVResult3 = new WVResult();
                wVResult3.setResult(WVResult.CLOSED);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("method=[");
                sb3.append(wVCallMethodContext.objectName);
                sb3.append(Consts.DOT);
                sb3.append(wVCallMethodContext.methodName);
                sb3.append("]");
                sb3.append(",url=[");
                sb3.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb3.append("]");
                wVResult3.addData("msg", sb3.toString());
                wVCallBackContext.error(wVResult3);
                return true;
            case 5:
                WVResult wVResult4 = new WVResult();
                wVResult4.setResult(WVResult.NO_METHOD);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No Class Error: method=[");
                sb4.append(wVCallMethodContext.objectName);
                sb4.append(Consts.DOT);
                sb4.append(wVCallMethodContext.methodName);
                sb4.append("]");
                sb4.append(",url=[");
                sb4.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb4.append("]");
                wVResult4.addData("msg", sb4.toString());
                wVCallBackContext.error(wVResult4);
                return true;
            case 6:
                WVResult wVResult5 = new WVResult();
                wVResult5.setResult(WVResult.NO_METHOD);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Execute error:method=[");
                sb5.append(wVCallMethodContext.objectName);
                sb5.append(Consts.DOT);
                sb5.append(wVCallMethodContext.methodName);
                sb5.append("]");
                sb5.append(",url=[");
                sb5.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb5.append("]");
                wVResult5.addData("msg", sb5.toString());
                wVCallBackContext.error(wVResult5);
                return true;
            case 7:
                WVResult wVResult6 = new WVResult();
                wVResult6.setResult("CALL_ALIAS");
                wVResult6.addData("msg", wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                wVResult6.setSuccess();
                wVCallBackContext.commitJsBridgeReturn(wVResult6);
                return true;
            case 8:
                WVResult wVResult7 = new WVResult();
                wVResult7.setResult(WVResult.FAIL);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Null Context Error:");
                sb6.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                wVResult7.addData("msg", sb6.toString());
                wVCallBackContext.error(wVResult7);
                return true;
            default:
                return false;
        }
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void skipPreprocess() {
        this.mSkipPreprocess = true;
    }

    public void tryToRunTailBridges() {
        ArrayList<WVCallMethodContext> arrayList = this.mTailBridges;
        if (arrayList != null) {
            for (WVCallMethodContext wVCallMethodContext : arrayList) {
                aftercallMethod(wVCallMethodContext, "");
                TaoLog.i(IBridgeDelegateService.TAG, "excute TailJSBridge : " + wVCallMethodContext.objectName + " : " + wVCallMethodContext.methodName);
            }
            this.mTailBridges.clear();
            this.mTailBridges = null;
        }
    }

    private void callMethod(b bVar, String str, IJsApiSucceedCallBack iJsApiSucceedCallBack, IJsApiFailedCallBack iJsApiFailedCallBack) {
        boolean z;
        if (TaoLog.getLogStatus()) {
            TaoLog.d(IBridgeDelegateService.TAG, "hybridCall: url=" + str);
        }
        if (!this.isInit) {
            TaoLog.w(IBridgeDelegateService.TAG, "jsbridge is not initApi.");
            return;
        }
        final WVCallMethodContext request = getRequest(str);
        if (request == null) {
            TaoLog.w(IBridgeDelegateService.TAG, "url format error and call canceled. url=" + str);
            return;
        }
        request.webview = bVar;
        if (iJsApiSucceedCallBack != null) {
            request.succeedCallBack = iJsApiSucceedCallBack;
        }
        if (iJsApiFailedCallBack != null) {
            request.failedCallBack = iJsApiFailedCallBack;
        }
        final String url = bVar.getUrl();
        if (enableGetParamByJs) {
            try {
                JSON.parse(request.params);
                z = false;
            } catch (Throwable th) {
                j jVar = (j) m.a().b(j.class);
                if (jVar != null && jVar.g() != null) {
                    jVar.g().d(url, th.getMessage(), request.params, request.objectName + Consts.DOT + request.methodName);
                }
                z = true;
            }
            if (z) {
                bVar.evaluateJavascript(String.format("javascript:window.WindVane&&window.WindVane.getParam(%s);", request.token), new ValueCallback<String>() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        if (str2.startsWith("\"")) {
                            str2 = JSON.parse(str2).toString();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            request.params = str2;
                        }
                        new AsyncTask<Void, Integer, Void>() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.1.1
                            @Override // android.os.AsyncTask
                            public Void doInBackground(Void... voidArr) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                WVJsBridge.this.callMethod(request, url);
                                return null;
                            }
                        }.execute(new Void[0]);
                    }
                });
                return;
            }
        }
        new AsyncTask<Void, Integer, Void>() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.2
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                WVJsBridge.this.callMethod(request, url);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void callMethod(WVCallMethodContext wVCallMethodContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(IBridgeDelegateService.TAG, "hybridCall-obj:" + wVCallMethodContext.objectName + " method:" + wVCallMethodContext.methodName + " param:" + wVCallMethodContext.params + " sid:" + wVCallMethodContext.token);
        }
        if (this.enabled && wVCallMethodContext.webview != null) {
            if (!this.mSkipPreprocess) {
                if (WVJsbridgeService.getPagePreprocessors() != null && !WVJsbridgeService.getPagePreprocessors().isEmpty()) {
                    for (WVJSAPIPageAuth wVJSAPIPageAuth : WVJsbridgeService.getPagePreprocessors()) {
                        if (wVJSAPIPageAuth.needAuth(wVCallMethodContext.webview)) {
                            if (wVJSAPIPageAuth.apiAuthCheck(str, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params)) {
                                aftercallMethod(wVCallMethodContext, str);
                                return;
                            } else {
                                startCall(3, wVCallMethodContext);
                                return;
                            }
                        }
                    }
                }
                if (WVJsbridgeService.getJSBridgePreprocessors() != null && !WVJsbridgeService.getJSBridgePreprocessors().isEmpty()) {
                    Iterator<WVJSAPIAuthCheck> it = WVJsbridgeService.getJSBridgePreprocessors().iterator();
                    while (it.hasNext()) {
                        if (!it.next().apiAuthCheck(str, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params)) {
                            TaoLog.w(IBridgeDelegateService.TAG, "preprocessor call fail, hybridCall cancel.");
                            startCall(3, wVCallMethodContext);
                            return;
                        }
                    }
                }
                if (WVJsbridgeService.getJSBridgeayncPreprocessors() != null && !WVJsbridgeService.getJSBridgeayncPreprocessors().isEmpty()) {
                    Iterator<WVAsyncAuthCheck> it2 = WVJsbridgeService.getJSBridgeayncPreprocessors().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().AsyncapiAuthCheck(str, wVCallMethodContext, new WVAsyncAuthCheckCallBackforJsBridge())) {
                            TaoLog.w(IBridgeDelegateService.TAG, "enter  WVAsyncAuthCheck preprocessor  ");
                            return;
                        }
                    }
                }
            }
            aftercallMethod(wVCallMethodContext, str);
            return;
        }
        TaoLog.w(IBridgeDelegateService.TAG, "jsbridge is closed.");
        startCall(4, wVCallMethodContext);
    }
}
