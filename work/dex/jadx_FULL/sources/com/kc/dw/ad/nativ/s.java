package com.kc.dw.ad.nativ;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s extends com.kc.dw.core.safe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39144a;

    public s(NormalMediaView normalMediaView) {
        this.f39144a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.e
    public void a(MediaPlayer mediaPlayer) {
        NormalMediaView normalMediaView = this.f39144a;
        int i = NormalMediaView.W;
        normalMediaView.e();
    }
}
