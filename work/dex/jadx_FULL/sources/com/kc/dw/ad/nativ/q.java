package com.kc.dw.ad.nativ;

import android.media.MediaPlayer;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q extends com.kc.dw.core.safe.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39141a;

    public q(NormalMediaView normalMediaView) {
        this.f39141a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.f
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        NativeAdMediaListener nativeAdMediaListener;
        LogUtil.e(this.f39141a.f39125a, "MediaPlayer onError" + i + " " + i2);
        h hVar = this.f39141a.z;
        if (hVar != null && (nativeAdMediaListener = ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f39488a) != null) {
            nativeAdMediaListener.onVideoError();
        }
        a aVar = this.f39141a.B;
        if (aVar != null) {
            aVar.onAdRenderFail("MediaPlayer onError", i);
        }
        this.f39141a.c();
        return true;
    }
}
