package com.kc.dw.core.ad.draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DrawAd extends a implements IDrawAd {
    public static final int DRAW_AD_TYPE_EXPRESS = 2;
    public static final int DRAW_AD_TYPE_NATIVE = 1;
    private b adWrapper;
    public IDrawVideoListener listener;

    @Keep
    public interface IDrawVideoListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        @Deprecated
        default void onVideoError(int i, int i2) {
        }

        default void onVideoError(int i, String str) {
        }

        void onVideoLoad();

        void pauseBtnClick();

        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    public DrawAd(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void bindAdToView(ViewGroup viewGroup, ViewGroup viewGroup2, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void destroy() {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public String getDescription() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }

    public IDrawVideoListener getDrawVideoListener() {
        return this.listener;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public long getDuration() {
        return 0L;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public String getIconUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public int getImageMode() {
        return 0;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public List<String> getImageUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public int getInteractionType() {
        return 0;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public String getSource() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public String getTitle() {
        return null;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public boolean isPlaying() {
        return false;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public boolean isShowEndFrame() {
        return false;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void pause() {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void render() {
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.adWrapper, new TypeMsg().setData(2));
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void resume() {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setActivityForDownloadApp(Activity activity) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setCanClickVideo(boolean z) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setOnDrawVideoListener(IDrawVideoListener iDrawVideoListener) {
        this.listener = iDrawVideoListener;
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setPauseIcon(Bitmap bitmap, int i) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.kc.dw.core.ad.draw.IDrawAd
    public void stop() {
    }
}
