package com.kc.dw.ad.reward;

import android.media.MediaPlayer;
import com.kc.dw.ad.a0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h extends com.kc.dw.core.safe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39159a;

    public h(FullScreenMediaView fullScreenMediaView) {
        this.f39159a = fullScreenMediaView;
    }

    @Override // com.kc.dw.core.safe.e
    public void a(MediaPlayer mediaPlayer) {
        a0.b bVar;
        FullScreenMediaView fullScreenMediaView = this.f39159a;
        fullScreenMediaView.q = false;
        fullScreenMediaView.c.setVisibility(8);
        fullScreenMediaView.d();
        if (fullScreenMediaView.g <= 0 && (bVar = fullScreenMediaView.f) != null) {
            bVar.onKeepTimeFinished();
        }
        Iterator<a0.a> it = fullScreenMediaView.r.iterator();
        while (it.hasNext()) {
            it.next().onCompleted();
        }
        com.kc.dw.ad.nativ.h hVar = fullScreenMediaView.h;
        if (hVar != null) {
            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).a();
        }
    }
}
