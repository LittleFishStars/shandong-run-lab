package com.kc.dw.ad.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements z.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f39096a;
    public final g b;

    public d(g gVar, Activity activity) {
        this.b = gVar;
        this.f39096a = activity;
    }

    @Override // com.kc.dw.core.utils.z.k
    public void fail() {
        LogUtil.d("NativeInterstitialAd", "videoLinkValid=false");
        this.b.i = System.currentTimeMillis();
        try {
            if (!TextUtils.isEmpty(this.b.a().getVideo_cover())) {
                this.b.a().setAdPatternType(1);
                this.b.a().getImageUrls()[0] = this.b.a().getVideo_cover();
                g0.b(this.b.a().getMonitorUrl());
                g gVar = this.b;
                Activity activity = this.f39096a;
                String video_cover = gVar.a().getVideo_cover();
                if (gVar.h == 0) {
                    gVar.h = System.currentTimeMillis();
                }
                c0.a(video_cover, new f(gVar, video_cover, activity));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.kc.dw.core.service.logrecord.a.a(5, "f4", this.b.f39103a, new LoadResState().setFail(3));
        a aVar = this.b.b;
        if (aVar != null) {
            ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).onAdRenderFail("插屏视频渲染失败", com.kc.dw.core.exception.b.c.intValue());
        }
    }

    @Override // com.kc.dw.core.utils.z.k
    public void success() {
        LogUtil.d("NativeInterstitialAd", "videoLinkValid=true");
        g gVar = this.b;
        gVar.getClass();
        ExecutorService executorService = f0.f39362a;
        f0.b.f39363a.a(new e(gVar));
    }
}
