package com.kc.openset.video;

import androidx.fragment.app.Fragment;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class VideoContentResultImp implements VideoContentResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f39993a;
    private VideoTubeManager b;
    private VideoContentManager c;

    public VideoContentResultImp(Fragment fragment, VideoContentManager videoContentManager) {
        this.f39993a = fragment;
        this.c = videoContentManager;
    }

    public VideoContentResultImp(Fragment fragment, VideoTubeManager videoTubeManager) {
        this.f39993a = fragment;
        this.b = videoTubeManager;
    }

    @Override // com.kc.openset.video.VideoContentResult
    public void destroy() {
        this.f39993a = null;
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            videoTubeManager.a();
            this.b = null;
        }
        VideoContentManager videoContentManager = this.c;
        if (videoContentManager != null) {
            videoContentManager.a();
            this.c = null;
        }
    }

    @Override // com.kc.openset.video.VideoContentResult
    public Fragment getFragment() {
        return this.f39993a;
    }

    @Override // com.kc.openset.video.VideoContentResult
    public boolean onBackPress() {
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            return videoTubeManager.c();
        }
        VideoContentManager videoContentManager = this.c;
        if (videoContentManager != null) {
            return videoContentManager.c();
        }
        return false;
    }

    @Override // com.kc.openset.video.VideoContentResult
    public void onHiddenChanged(boolean z) {
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            videoTubeManager.a(z);
        }
    }

    @Override // com.kc.openset.video.VideoContentResult
    public void onPause() {
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            videoTubeManager.d();
        }
    }

    @Override // com.kc.openset.video.VideoContentResult
    public void onResume() {
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            videoTubeManager.e();
        }
    }

    @Override // com.kc.openset.video.VideoContentResult
    public void setUserVisibleHint(boolean z) {
        VideoTubeManager videoTubeManager = this.b;
        if (videoTubeManager != null) {
            videoTubeManager.b(z);
        }
    }
}
