package com.alibaba.alibcwebview.jsbridge;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.AlibcPluginManager;
import com.alibaba.alibcwebview.container.BCWebView;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23722a = "a";
    private static Handler b;
    private static volatile a c;
    private boolean d = true;
    private boolean e;

    private a() {
        b = new Handler(Looper.getMainLooper(), this);
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        e eVar = (e) message.obj;
        if (eVar == null) {
            AlibcLogger.e(f23722a, "BCCallMethodContext is null, do nothing");
            return false;
        }
        b bVar = new b(eVar.f23730a, eVar.g, eVar.d, eVar.e);
        int i = message.what;
        if (i == 0) {
            if (!((AlibcApiPlugin) eVar.c).execute(eVar.e, TextUtils.isEmpty(eVar.f) ? "{}" : eVar.f, bVar)) {
                AlibcLogger.e(f23722a, "AlibcApiPlugin execute failed. method: " + eVar.e);
                a(2, eVar);
            }
            return true;
        }
        if (i == 2) {
            bVar.fail(a(AlibcJsEnum.NO_METHOD));
            return true;
        }
        if (i == 3) {
            bVar.fail(a(AlibcJsEnum.NO_PERMISSION));
            return true;
        }
        if (i != 4) {
            return false;
        }
        bVar.fail(a(AlibcJsEnum.CLOSED));
        return true;
    }

    public static boolean a(WebView webView, ConsoleMessage consoleMessage) {
        try {
            String strMessage = consoleMessage.message();
            if (!TextUtils.isEmpty(strMessage)) {
                Uri uri = Uri.parse(strMessage);
                if (strMessage.startsWith("bcNativeCallback")) {
                    String strSubstring = strMessage.substring(strMessage.indexOf(WVNativeCallbackUtil.SEPERATER) + 1);
                    int iIndexOf = strSubstring.indexOf(WVNativeCallbackUtil.SEPERATER);
                    String strSubstring2 = strSubstring.substring(0, iIndexOf);
                    String strSubstring3 = strSubstring.substring(iIndexOf + 1);
                    ValueCallback<String> valueCallbackA = d.a(strSubstring2);
                    if (valueCallbackA != null) {
                        valueCallbackA.onReceiveValue(strSubstring3);
                        d.b(strSubstring2);
                    } else {
                        Log.e(f23722a, "NativeCallback failed: " + strSubstring3);
                    }
                    return true;
                }
                if ("bchybrid".equals(uri.getScheme())) {
                    a().a(webView, strMessage);
                    return true;
                }
            } else {
                AlibcLogger.e(f23722a, "onConsoleMessage: transfer data is null");
            }
        } catch (Exception e) {
            AlibcLogger.e(f23722a, "onConsoleMessage: data handle exception: msg = " + e.getMessage());
        }
        return false;
    }

    public static boolean a(WebView webView, String str, String str2, JsPromptResult jsPromptResult) {
        if (str2 == null || !str2.equals("bc_hybrid:")) {
            return false;
        }
        a().a(webView, str);
        jsPromptResult.confirm("");
        return true;
    }

    private static void a(int i, e eVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.obj = eVar;
        b.sendMessage(messageObtain);
    }

    private void a(WebView webView, String str) {
        final e eVarA = a(str);
        if (eVarA == null) {
            AlibcLogger.e(f23722a, "url format error and call canceled. url=" + str);
            return;
        }
        eVarA.f23730a = (BCWebView) webView;
        final String url = webView.getUrl();
        ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibcwebview.jsbridge.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a(a.this, eVarA);
            }
        });
    }

    private static e a(String str) {
        if (str != null && str.startsWith("bchybrid:///")) {
            try {
                e eVar = new e();
                int iIndexOf = str.indexOf(u15.f19942b, 12);
                eVar.d = str.substring(12, iIndexOf);
                int iIndexOf2 = str.indexOf(WVNativeCallbackUtil.SEPERATER, iIndexOf);
                eVar.g = str.substring(iIndexOf + 1, iIndexOf2);
                int iIndexOf3 = str.indexOf("?", iIndexOf2);
                if (iIndexOf3 > 0) {
                    eVar.e = str.substring(iIndexOf2 + 1, iIndexOf3);
                    eVar.f = str.substring(iIndexOf3 + 1);
                } else {
                    eVar.e = str.substring(iIndexOf2 + 1);
                }
                if (eVar.d.length() > 0 && eVar.g.length() > 0 && eVar.e.length() > 0) {
                    return eVar;
                }
            } catch (StringIndexOutOfBoundsException e) {
                AlibcLogger.e(f23722a, "string handle exception: " + e.getMessage());
            }
        }
        return null;
    }

    private static Map<String, Object> a(AlibcJsEnum alibcJsEnum) {
        HashMap map = new HashMap(16);
        map.put("code", Integer.valueOf(alibcJsEnum.getCode()));
        map.put("msg", alibcJsEnum.getMsg());
        return map;
    }

    public static /* synthetic */ void a(a aVar, e eVar) {
        String str = String.format("callMethod-obj:%s method:%s param:%s sid:%s", eVar.d, eVar.e, eVar.f, eVar.g);
        String str2 = f23722a;
        AlibcLogger.d(str2, str);
        if (aVar.d && eVar.f23730a != null) {
            if (!aVar.e) {
                Iterator<AlibcJsBridgeService.AlibcJSAPIAuthCheck> it = AlibcJsBridgeService.a().iterator();
                while (it.hasNext()) {
                    if (!it.next().a()) {
                        AlibcLogger.w(f23722a, "preProcessor call failed, callMethod cancel");
                        a(3, eVar);
                        return;
                    }
                }
            }
            AlibcApiPlugin alibcApiPluginInitPlugin = AlibcPluginManager.initPlugin(eVar.d, eVar.b, eVar.f23730a);
            if (alibcApiPluginInitPlugin != null) {
                eVar.c = alibcApiPluginInitPlugin;
                a(0, eVar);
                return;
            }
            AlibcLogger.w(f23722a, "callMethod: Plugin " + eVar.d + " didn't found, you should call AlibcPluginManager.registerPlugin first.");
            a(2, eVar);
            return;
        }
        AlibcLogger.w(str2, "jsBridge id closed");
        a(4, eVar);
    }
}
