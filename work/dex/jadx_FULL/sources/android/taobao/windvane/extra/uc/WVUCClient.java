package android.taobao.windvane.extra.uc;

import android.taobao.windvane.base.m;
import android.taobao.windvane.d.b;
import android.taobao.windvane.extra.service.a;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import com.uc.webview.export.extension.UCClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCClient extends UCClient {
    private a embedService = (a) m.a().b(a.class);
    protected b webView;

    public WVUCClient(b bVar) {
        this.webView = bVar;
    }

    public String getCachedFilePath(String str) {
        return "";
    }

    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        a aVar = this.embedService;
        if (aVar == null) {
            TaoLog.i("EmbedView", "please register embed service");
            return null;
        }
        if (aVar.a()) {
            return this.embedService.a(embedViewConfig, iEmbedViewContainer, this.webView);
        }
        TaoLog.i("EmbedView", "embed is closed, please open it");
        return null;
    }

    public void onWebViewEvent(WebView webView, int i, Object obj) {
        super.onWebViewEvent(webView, i, obj);
    }
}
