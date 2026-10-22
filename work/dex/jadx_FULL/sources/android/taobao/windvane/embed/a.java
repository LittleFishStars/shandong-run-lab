package android.taobao.windvane.embed;

import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a implements android.taobao.windvane.extra.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f21212a;

    public a(boolean z) {
        this.f21212a = z;
    }

    @Override // android.taobao.windvane.extra.service.a
    public void a(boolean z) {
        this.f21212a = z;
    }

    @Override // android.taobao.windvane.extra.service.a
    public boolean a() {
        return this.f21212a;
    }

    @Override // android.taobao.windvane.extra.service.a
    public IEmbedView a(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer, android.taobao.windvane.d.b bVar) {
        Map map = embedViewConfig.mObjectParam;
        if (map != null && map.containsKey("viewType")) {
            TaoLog.i("EmbedView", "get EmbedView");
            BaseEmbedView baseEmbedViewCreateEV = WVEVManager.createEV(map.containsKey("bridgeId") ? (String) map.get("bridgeId") : "", (String) map.get("viewType"), bVar, embedViewConfig);
            if (baseEmbedViewCreateEV == null) {
                TaoLog.e("EmbedView", "failed to create embedView");
            } else {
                iEmbedViewContainer.setOnParamChangedListener(baseEmbedViewCreateEV);
                iEmbedViewContainer.setOnStateChangedListener(baseEmbedViewCreateEV);
                iEmbedViewContainer.setOnVisibilityChangedListener(baseEmbedViewCreateEV);
                return baseEmbedViewCreateEV;
            }
        } else {
            TaoLog.e("EmbedView", "viewType should not be lost");
        }
        c cVar = new c();
        cVar.init("", "empty", bVar, null);
        return cVar;
    }
}
