package com.alibaba.triver.embed.video;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.alibaba.triver.triver_render.render.WVEmbedViewProvider;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoInitPoint implements AppStartPoint, Serializable {
    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        try {
            WVEmbedViewProvider.registerEmebedView("video", TriverEmbedVideoView.class.getCanonicalName());
            RVLogger.e("VideoInitPoint", "use TRiver default video");
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            RVLogger.e("VideoInitPoint", "TriverEmbedTBVideoView class not found : " + e.getMessage());
            WVEmbedViewProvider.registerEmebedView("video", TriverEmbedVideoView.class.getCanonicalName());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
