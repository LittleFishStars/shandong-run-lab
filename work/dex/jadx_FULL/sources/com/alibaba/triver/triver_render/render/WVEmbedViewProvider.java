package com.alibaba.triver.triver_render.render;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.taobao.avplayer.embed.TriverEmbedTBVideoView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WVEmbedViewProvider implements EmbedViewProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25200a = "WVEmbedViewProvider";
    private static final String b = "video";
    private static Map<String, Class> c = new ConcurrentHashMap();
    private Bundle d;

    public WVEmbedViewProvider(Bundle bundle) {
        this.d = bundle;
    }

    private IEmbedView a(Node node) {
        App appB = b(node);
        if (appB == null || !TROrangeController.useTBVideoSDK(appB)) {
            return null;
        }
        try {
            return (IEmbedView) TriverEmbedTBVideoView.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static App b(Node node) {
        if (node instanceof App) {
            return (App) node;
        }
        if (node instanceof Page) {
            return ((Page) node).getApp();
        }
        return null;
    }

    public static void registerEmebedView(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            c.put(str, Class.forName(str2));
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.EmbedViewProvider
    public IEmbedView createEmbedView(String str, Node node) {
        Class cls;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if ("video".equals(str)) {
                IEmbedView iEmbedViewA = a(node);
                if (iEmbedViewA != null) {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("EmbedView", "create tbVideo view");
                    return iEmbedViewA;
                }
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("EmbedView", "use TRiver video view");
            }
            RVLogger.e(f25200a, "create view for type:" + str);
            if (c.containsKey(str) && (cls = c.get(str)) != null) {
                return (IEmbedView) cls.newInstance();
            }
            if (!com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a.equalsIgnoreCase(str)) {
                RVLogger.e(f25200a, "Can't create view for type:" + str);
                return null;
            }
            Bundle bundle = this.d;
            if (bundle == null || !bundle.containsKey(TRiverConstants.KEY_ENABLE_SKIA)) {
                return new com.alibaba.triver.triver_render.view.canvas.tinyapp.b();
            }
            try {
                return (IEmbedView) Class.forName("com.alibaba.triver.flutter.canvas.EmbedFCanvasView").newInstance();
            } catch (Throwable th) {
                RVLogger.e(f25200a, "create FCanvas view failed.", th);
                return null;
            }
        } catch (Throwable th2) {
            RVLogger.e(f25200a, "unexpected error", th2);
        }
    }
}
