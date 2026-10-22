package com.byazt.nm;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.byazt.nc.u;
import com.byazt.nr.m;
import com.byazt.omf.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 54})
public class ve {

    @com.byazt.zqa.c(c = {0, 1, 585, 24})
    public static class c extends com.byazt.yl.ve {
        public com.byazt.nc.i da;
        public int sl;
        public com.byazt.lsp.c x = new com.byazt.lsp.c(0 == true ? 1 : 0) { // from class: com.byazt.nm.ve.c.3
            @Override // com.byazt.lsp.c
            public void c(View view, u uVar) {
                if (c.this.f29207a != null) {
                    c.this.f29207a.c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void tt(View view, u uVar) {
                if (c.this.f29207a != null) {
                    c.this.f29207a.c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void c(u uVar) {
                if (c.this.f29207a != null) {
                    c.this.f29207a.c();
                }
            }
        };
        public com.byazt.bf.c i = new com.byazt.bf.c(0 == true ? 1 : 0) { // from class: com.byazt.nm.ve.c.4
            @Override // com.byazt.bf.c
            public void c(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.c();
                }
            }

            @Override // com.byazt.bf.c
            public void n(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.n();
                }
            }

            @Override // com.byazt.bf.c
            public void tt(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.tt();
                }
            }

            @Override // com.byazt.bf.c
            public void uj(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.uj();
                }
            }

            @Override // com.byazt.bf.c
            public void ve(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.ve();
                }
            }

            @Override // com.byazt.bf.c
            public void c(int i, int i2) {
                if (c.this.tt != null) {
                    c.this.tt.c(new com.byazt.pp.c(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            @Override // com.byazt.bf.c
            public void c(long j, long j2) {
                if (c.this.tt != null) {
                    c.this.tt.c(j, j2);
                }
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public c(com.byazt.nc.i iVar, boolean z) {
            Map<String, Object> mediaExtraInfo;
            this.da = iVar;
            com.byazt.nc.ve complianceInfo = iVar.getComplianceInfo();
            if (complianceInfo != null) {
                setAppName(complianceInfo.getAppName());
                setAuthorName(complianceInfo.getDeveloperName());
                setPrivacyAgreement(complianceInfo.getPrivacyUrl());
                setVersionName(complianceInfo.getAppVersion());
                HashMap map = new HashMap();
                Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
                if (permissionsMap != null && permissionsMap.size() > 0) {
                    map.putAll(permissionsMap);
                }
                setPermissionsMap(map);
                if (com.byazt.xf.tt.c("5.1.0.0")) {
                    setPermissionsUrl(complianceInfo.getPermissionUrl());
                }
                if (com.byazt.xf.tt.c("5.4.0.3")) {
                    setFunctionDescUrl(complianceInfo.getFunctionDescUrl());
                }
                if (com.byazt.xf.tt.c("6.8.1.6")) {
                    setRegUrl(complianceInfo.getRegUrl());
                }
                setRegNumber(complianceInfo.getRegNumber());
            }
            setTitle(iVar.getTitle());
            setAdDescription(iVar.getDescription());
            setActionText(iVar.getButtonText());
            setIconUrl(iVar.getIcon() != null ? iVar.getIcon().getImageUrl() : null);
            setImageMode(iVar.getImageMode());
            setInteractionType(iVar.getInteractionType());
            setSource(iVar.getSource());
            setRating(iVar.getAppScore());
            setIsAppDownload(iVar.getInteractionType() == 4);
            setExpressAd(false);
            if (iVar.getImageMode() == 16 || iVar.getImageMode() == 3 || iVar.getImageMode() == 2 || iVar.getImageMode() == 131) {
                if (iVar.getImageList() != null && !iVar.getImageList().isEmpty() && iVar.getImageList().get(0) != null) {
                    com.byazt.nc.t tVar = iVar.getImageList().get(0);
                    setImageUrl(tVar.getImageUrl());
                    setImageHeight(tVar.getHeight());
                    setImageWidth(tVar.getWidth());
                }
            } else if (iVar.getImageMode() != 4) {
                com.byazt.nc.t videoCoverImage = iVar.getVideoCoverImage();
                if (videoCoverImage == null && iVar.getImageList() != null && !iVar.getImageList().isEmpty() && iVar.getImageList().get(0) != null) {
                    videoCoverImage = iVar.getImageList().get(0);
                }
                if (videoCoverImage != null) {
                    setImageUrl(videoCoverImage.getImageUrl());
                    setImageHeight(videoCoverImage.getHeight());
                    setImageWidth(videoCoverImage.getWidth());
                }
            } else if (iVar.getImageList() != null && iVar.getImageList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.nc.t> it = iVar.getImageList().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImageUrl());
                }
                setImages(arrayList);
            }
            if (z && (mediaExtraInfo = iVar.getMediaExtraInfo()) != null) {
                double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                com.byazt.eu.tt.c("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：".concat(String.valueOf(dC)));
                setCpm(dC <= AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : dC);
            }
            this.da.setVideoAdListener(this.i);
            putExtraMsg(MediationConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(MediationConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            putExtraMsg("duration", Double.valueOf(this.da.getVideoDuration()));
            Map<String, Object> mediaExtraInfo2 = this.da.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg(mediaExtraInfo2);
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.byazt.yl.ve
        public void cancelDownload() {
            com.byazt.nc.i iVar = this.da;
            if (iVar == null || iVar.getDownloadStatusController() == null) {
                return;
            }
            this.da.getDownloadStatusController().cancelDownload();
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                return com.byazt.xf.tt.tt(iVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public Bitmap getAdLogo() {
            if (this.da == null) {
                return super.getAdLogo();
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getAdLogo = " + this.da.getAdLogo());
            return this.da.getAdLogo();
        }

        @Override // com.byazt.yl.ve
        public int getAppCommentNum() {
            if (this.da == null) {
                return super.getAppCommentNum();
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getAppCommentNum = " + this.da.getAppCommentNum());
            return this.da.getAppCommentNum();
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                return com.byazt.xf.tt.c(iVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            if (this.da == null) {
                return super.getDislikeDialog(activity);
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.da.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getDislikeInfo");
            return this.da.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public int getDownloadStatus() {
            return this.sl;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.n getDownloadStatusController() {
            com.byazt.nc.i iVar = this.da;
            if (iVar == null) {
                return super.getDownloadStatusController();
            }
            com.byazt.nc.n downloadStatusController = iVar.getDownloadStatusController();
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getDownloadStatusController = ".concat(String.valueOf(downloadStatusController)));
            return downloadStatusController;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.me.n getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new com.byazt.me.n() { // from class: com.byazt.nm.ve.c.2
                    @Override // com.byazt.me.n
                    public void c(long j) {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoPause(j);
                    }

                    @Override // com.byazt.me.n
                    public void tt(long j) {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoContinue(j);
                    }

                    @Override // com.byazt.me.n
                    public void ve(long j) {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoBreak(j);
                    }

                    @Override // com.byazt.me.n
                    public void c() {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.byazt.me.n
                    public void tt() {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.byazt.me.n
                    public void c(int i, int i2) {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoStartError(i, i2);
                    }

                    @Override // com.byazt.me.n
                    public void c(long j, int i, int i2) {
                        if (c.this.da == null || c.this.da.getCustomVideo() == null) {
                            return;
                        }
                        c.this.da.getCustomVideo().reportVideoError(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            com.byazt.nc.i iVar = this.da;
            if (iVar == null || (mediaExtraInfo = iVar.getMediaExtraInfo()) == null) {
                return null;
            }
            setMediaExtraInfo(mediaExtraInfo);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            com.byazt.nc.i iVar = this.da;
            return iVar != null ? com.byazt.xf.tt.ve(iVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.t getVideoCoverImage() {
            if (this.da == null) {
                return super.getVideoCoverImage();
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getVideoCoverImage = " + this.da.getVideoCoverImage());
            return this.da.getVideoCoverImage();
        }

        @Override // com.byazt.yl.ve
        public double getVideoDuration() {
            if (this.da == null) {
                return super.getVideoDuration();
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getVideoDuration = " + this.da.getVideoDuration());
            return this.da.getVideoDuration();
        }

        @Override // com.byazt.yl.ve
        public int getVideoHeight() {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                return iVar.getAdViewHeight();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public String getVideoUrl() {
            com.byazt.nc.i iVar;
            if (!isUseCustomVideo() || (iVar = this.da) == null || iVar.getCustomVideo() == null) {
                return null;
            }
            return this.da.getCustomVideo().getVideoUrl();
        }

        @Override // com.byazt.yl.ve
        public View getVideoView() {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getVideoView = " + this.da.getAdView());
            return this.da.getAdView();
        }

        @Override // com.byazt.yl.ve
        public int getVideoWidth() {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                return iVar.getAdViewWidth();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.da == null;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDislike() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setVideoAdListener(null);
                this.da = null;
            }
        }

        @Override // com.byazt.yl.ve
        public void pauseAppDownload() {
            com.byazt.nc.i iVar = this.da;
            if (iVar == null || iVar.getDownloadStatusController() == null || this.sl != 2) {
                return;
            }
            this.da.getDownloadStatusController().changeDownloadStatus();
        }

        @Override // com.byazt.yl.ve
        public void registerView(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.registerView(viewGroup, list, list2, list3, list4, view);
            c(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.byazt.yl.ve
        public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.nc.i iVar;
            View adView;
            com.byazt.nc.i iVar2;
            View viewFindViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, list4);
            c(viewGroup, null, list, list2, list3, null);
            com.byazt.nc.i iVar3 = this.da;
            if (iVar3 != null && iVar3.getAdLogo() != null && daVar != null && (viewFindViewById = viewGroup.findViewById(daVar.t)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.da.getAdLogo());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.eu.a.tt(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.byazt.eu.a.tt(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.da.getAdLogo());
                }
            }
            if ((isUseCustomVideo() && (iVar2 = this.da) != null && iVar2.getCustomVideo() != null && !TextUtils.isEmpty(this.da.getCustomVideo().getVideoUrl())) || daVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(daVar.sp)) == null || (iVar = this.da) == null || (adView = iVar.getAdView()) == null) {
                return;
            }
            removeSelfFromParent(adView);
            frameLayout.removeAllViews();
            frameLayout.addView(adView, -1, -1);
        }

        @Override // com.byazt.yl.ve
        public void resumeAppDownload() {
            com.byazt.nc.i iVar = this.da;
            if (iVar == null || iVar.getDownloadStatusController() == null || this.sl != 3) {
                return;
            }
            this.da.getDownloadStatusController().changeDownloadStatus();
        }

        @Override // com.byazt.yl.ve
        public void setActivityForDownloadApp(Activity activity) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : setActivityForDownloadApp  activity = ".concat(String.valueOf(activity)));
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setActivityForDownloadApp(activity);
            }
        }

        @Override // com.byazt.yl.ve
        public void setCanInterruptVideoPlay(boolean z) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setCanInterruptVideoPlay(z);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.da.setDislikeCallback(activity, cVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.da.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDownloadListener(com.byazt.ocd.ve veVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(veVar)));
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setDownloadListener(veVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDrawVideoListener(com.byazt.uz.c cVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : setDrawVideoListener pluginDrawVideoListener = ".concat(String.valueOf(cVar)));
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setDrawVideoListener(cVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setPauseIcon(Bitmap bitmap, int i) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : setPauseIcon bitmap = " + bitmap + " i = " + i);
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                iVar.setPauseIcon(bitmap, i);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.da.uploadDislikeEvent(str);
            }
        }

        private void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.byazt.nc.i iVar = this.da;
            if (iVar != null) {
                try {
                    iVar.setVideoRewardListener(new com.byazt.bf.tt(null) { // from class: com.byazt.nm.ve.c.1
                        @Override // com.byazt.bf.tt
                        public void c(int i) {
                            if (c.this.n != null) {
                                c.this.n.c(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    m.c(th);
                }
                this.da.registerViewForInteraction(viewGroup, list, list2, list3, list4, view, this.x);
            }
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.da.getDislikeDialog(dialog, numArr);
        }
    }

    public void c(final boolean z, h hVar, com.byazt.dj.tt ttVar, final com.byazt.sp.tt ttVar2) {
        if (hVar == null || ttVar2 == null) {
            return;
        }
        hVar.loadDrawFeedAd(ttVar, new com.byazt.nh.tt(null) { // from class: com.byazt.nm.ve.1
            @Override // com.byazt.nh.tt
            public void c(int i, String str) {
                ttVar2.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.tt
            public void c(List<com.byazt.nc.i> list) {
                if (list == null || list.isEmpty()) {
                    ttVar2.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.nc.i> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new c(it.next(), z));
                }
                ttVar2.notifyLoadSuccess(arrayList);
            }
        });
    }
}
