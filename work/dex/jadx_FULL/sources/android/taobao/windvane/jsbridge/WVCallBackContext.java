package android.taobao.windvane.jsbridge;

import android.os.Looper;
import android.taobao.windvane.b.g;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.d.b;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.o61;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVCallBackContext {
    private static final String TAG = "WVCallBackContext";
    private static j monitorService;
    private IJsApiFailedCallBack failedCallBack;
    private String instancename;
    private String methodname;
    private String objectname;
    private IJsApiSucceedCallBack succeedCallBack;
    private String token;
    private b webview;
    private boolean mNotiNavtive = false;
    private String mAction = null;

    public WVCallBackContext(b bVar) {
        this.webview = bVar;
    }

    private static void callback(final b bVar, String str, String str2) {
        if (TaoLog.getLogStatus() && EnvUtil.isDebug() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                TaoLog.e(TAG, "return param is not a valid json!\n" + str + "\n" + str2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String str3 = String.format(str, formatJsonString(str2));
            try {
                runOnUiThread(bVar, new Runnable() { // from class: android.taobao.windvane.jsbridge.WVCallBackContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.evaluateJavascript(str3);
                    }
                });
            } catch (Exception e) {
                TaoLog.w(TAG, e.getMessage());
            }
        } catch (Exception e2) {
            TaoLog.e(TAG, "callback error. " + e2.getMessage());
        }
    }

    private static String formatJsonString(String str) {
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

    private static void runOnUiThread(b bVar, Runnable runnable) {
        if (bVar == null || bVar.getView() == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        try {
            bVar._post(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void commitJsBridgeReturn(WVResult wVResult) {
        try {
            String str = "" + this.objectname + Consts.DOT + this.methodname;
            String str2 = wVResult.get("ret", "HY_FAILED_EMPTY");
            String str3 = wVResult.get("msg", "");
            b bVar = this.webview;
            String url = bVar == null ? "unknown" : bVar.getUrl();
            if (monitorService == null) {
                monitorService = (j) m.a().b(j.class);
            }
            j jVar = monitorService;
            if (jVar == null || jVar.g() == null) {
                return;
            }
            monitorService.g().c(str, str2, str3, url);
        } catch (Throwable unused) {
        }
    }

    public void error() {
        error("{}");
    }

    public void fireEvent(String str, String str2) {
        TaoLog.d(TAG, "call fireEvent ");
        g.a().a(3013, this.mAction, str, str2);
        callback(this.webview, String.format("window.WindVane && window.WindVane.fireEvent('%s', '%%s', %s);", str, null), str2);
    }

    public String getToken() {
        return this.token;
    }

    public b getWebview() {
        return this.webview;
    }

    public void setNeedfireNativeEvent(String str, boolean z) {
        this.mAction = str;
        this.mNotiNavtive = z;
        TaoLog.e(TAG, "setNeedfireNativeEvent : " + str);
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setWebview(b bVar) {
        this.webview = bVar;
    }

    public void success() {
        success(WVResult.RET_SUCCESS);
    }

    public void successAndKeepAlive(String str) {
        TaoLog.d(TAG, "call success and keep alive");
        IJsApiSucceedCallBack iJsApiSucceedCallBack = this.succeedCallBack;
        if (iJsApiSucceedCallBack == null || !(iJsApiSucceedCallBack instanceof IExtJsApiSuccessCallBack)) {
            callback(this.webview, String.format("javascript:window.WindVane&&window.WindVane.onSuccess('%s','%%s', true);", this.token), str);
        } else {
            ((IExtJsApiSuccessCallBack) iJsApiSucceedCallBack).successAndKeepAlive(str);
        }
    }

    public void error(WVResult wVResult) {
        if (wVResult != null) {
            error(wVResult.toJsonString());
            commitJsBridgeReturn(wVResult);
        }
    }

    public void success(WVResult wVResult) {
        if (wVResult != null) {
            wVResult.setSuccess();
            success(wVResult.toJsonString());
            commitJsBridgeReturn(wVResult);
        }
    }

    public static void fireEvent(b bVar, String str, String str2) {
        TaoLog.d(TAG, "call fireEvent ");
        g.a().a(3013, null, str, str2);
        callback(bVar, String.format("window.WindVane && window.WindVane.fireEvent('%s', '%%s', %s);", str, null), str2);
    }

    public WVCallBackContext(b bVar, String str, String str2, String str3) {
        this.webview = bVar;
        this.token = str;
        this.objectname = str2;
        this.methodname = str3;
    }

    public void error(String str) {
        String str2;
        TaoLog.d(TAG, "call error ");
        IJsApiFailedCallBack iJsApiFailedCallBack = this.failedCallBack;
        if (iJsApiFailedCallBack != null) {
            iJsApiFailedCallBack.fail(str);
            return;
        }
        if (this.mNotiNavtive) {
            g.a().a(3012, null, this.webview.getUrl(), this.mAction, str);
            this.mNotiNavtive = false;
            this.mAction = null;
        }
        try {
            Integer.valueOf(this.token);
            str2 = "javascript:window.WindVane&&window.WindVane.onFailure(%s,'%%s');";
        } catch (Throwable unused) {
            str2 = "javascript:window.WindVane&&window.WindVane.onSuccess('%s','%%s');";
        }
        callback(this.webview, String.format(str2, this.token), str);
    }

    public void success(String str) {
        String str2;
        TaoLog.d(TAG, "call success ");
        IJsApiSucceedCallBack iJsApiSucceedCallBack = this.succeedCallBack;
        if (iJsApiSucceedCallBack != null) {
            iJsApiSucceedCallBack.succeed(str);
            return;
        }
        if (this.mNotiNavtive) {
            g.a().a(3011, null, this.webview.getUrl(), this.mAction, str);
            this.mNotiNavtive = false;
            this.mAction = null;
        }
        try {
            Integer.valueOf(this.token);
            str2 = "javascript:window.WindVane&&window.WindVane.onSuccess(%s,'%%s');";
        } catch (Throwable unused) {
            str2 = "javascript:window.WindVane&&window.WindVane.onSuccess('%s','%%s');";
        }
        callback(this.webview, String.format(str2, this.token), str);
    }

    public void fireEvent(String str) {
        fireEvent(str, "{}");
    }

    public WVCallBackContext(b bVar, String str, String str2, String str3, IJsApiSucceedCallBack iJsApiSucceedCallBack, IJsApiFailedCallBack iJsApiFailedCallBack) {
        this.webview = bVar;
        this.token = str;
        this.objectname = str2;
        this.methodname = str3;
        this.failedCallBack = iJsApiFailedCallBack;
        this.succeedCallBack = iJsApiSucceedCallBack;
    }
}
