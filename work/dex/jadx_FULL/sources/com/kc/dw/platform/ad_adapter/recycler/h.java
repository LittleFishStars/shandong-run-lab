package com.kc.dw.platform.ad_adapter.recycler;

import android.view.ViewGroup;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h implements NativeAdMediaListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f39493a;
    public final i b;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f39494a;

        public a(h hVar) {
            this.f39494a = hVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            if (this.f39494a.f39493a.getVisibility() != 0) {
                this.f39494a.f39493a.setVisibility(0);
            }
        }
    }

    public h(i iVar, ViewGroup viewGroup) {
        this.b = iVar;
        this.f39493a = viewGroup;
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoCompleted() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoCompleted();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoError() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoError(-1, "视频加载出错");
        }
        this.b.a(-1, "视频加载出错");
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoLoaded() {
        LogUtil.e("i", "onVideoLoaded");
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoLoaded();
        }
        this.b.d();
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoPause() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoPause();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoResume() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoResume();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
    public void onVideoStart() {
        LogUtil.d("i", "onVideoStart");
        this.f39493a.postDelayed(new a(this), 2000L);
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoStart();
        }
    }
}
