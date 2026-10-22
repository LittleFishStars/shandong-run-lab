package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsVideoPlayConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class VideoPlayConfigImpl implements KsVideoPlayConfig {
    private static final long serialVersionUID = -7203854889686049813L;
    private boolean showLandscape;
    private String showScene;
    private boolean skipThirtySecond;
    private boolean videoSoundEnable = true;

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.a(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public String getShowScene() {
        return this.showScene;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isShowLandscape() {
        return this.showLandscape;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isSkipThirtySecond() {
        return this.skipThirtySecond;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowLandscape(boolean z) {
        this.showLandscape = z;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowScene(String str) {
        this.showScene = str;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setSkipThirtySecond(boolean z) {
        this.skipThirtySecond = z;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        this.videoSoundEnable = z;
    }
}
