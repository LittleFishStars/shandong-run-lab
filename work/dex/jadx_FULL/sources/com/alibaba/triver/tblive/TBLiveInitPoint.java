package com.alibaba.triver.tblive;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.triver_render.render.WVEmbedViewProvider;
import com.taobao.media.TriverEmbedLiveView;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBLiveInitPoint implements AppStartPoint, Serializable {
    public static final String TAOLIVE_SHOW_MINILIVE_ACTION = "com.taobao.taolive.miniLiveRoom.action";

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        try {
            WVEmbedViewProvider.registerEmebedView("live-player", TriverEmbedLiveView.class.getCanonicalName());
        } catch (Throwable th) {
            RVLogger.w("TBLiveInitPoint", Log.getStackTraceString(th));
        }
        try {
            WVEmbedViewProvider.registerEmebedView("live-pusher", Class.forName("com.taobao.embedpush.TriverEmbedLivePusherView").getCanonicalName());
            RVLogger.e("TBLiveInitPoint", "use TriverEmbedLivePusher");
        } catch (Throwable th2) {
            RVLogger.w(Log.getStackTraceString(th2));
            RVLogger.e("TBLiveInitPoint", "TriverEmbedLivePusherView class not found : " + th2.getMessage());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
