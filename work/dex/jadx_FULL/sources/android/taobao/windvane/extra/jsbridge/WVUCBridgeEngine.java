package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.d.b;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.JavascriptInterface;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCBridgeEngine implements Serializable {
    private b webView;

    public WVUCBridgeEngine(b bVar) {
        this.webView = bVar;
    }

    @JavascriptInterface
    public void nativeCall(String str, String str2, String str3, String str4) {
        TaoLog.i(IBridgeDelegateService.TAG, "WVJSPlugin __windvane__ call " + str);
        b bVar = this.webView;
        IBridgeDelegateService bridgeDelegate = bVar == null ? null : bVar.getBridgeDelegate();
        if (bridgeDelegate != null) {
            bridgeDelegate.nativeCall(str, str2, str3, str4);
        } else {
            TaoLog.i(IBridgeDelegateService.TAG, "no jsbridge service found");
        }
    }

    @JavascriptInterface
    public String version() {
        TaoLog.i(IBridgeDelegateService.TAG, "WVJSPlugin __windvane__ version 8.5.0");
        return "8.5.0";
    }

    @JavascriptInterface
    public String windVaneCoreJs() {
        return IBridgeDelegateService.WINDVANE_CORE_JS;
    }
}
