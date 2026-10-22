package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaPlayer f39188a;
    public final a b;

    public b(a aVar, MediaPlayer mediaPlayer) {
        this.b = aVar;
        this.f39188a = mediaPlayer;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        super.safeRun();
        a aVar = this.b;
        a.a(aVar, this.f39188a, aVar.e[0]);
    }
}
