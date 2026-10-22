package com.byazt.lq;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.nc.da;
import com.byazt.nc.i;
import com.byazt.nc.n;
import com.byazt.nc.sp;
import com.byazt.nc.t;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 51, 20})
public abstract class c extends i {
    public final da c;

    public c(da daVar) {
        this.c = daVar;
    }

    @Override // com.byazt.nc.u
    public void destroy() {
        this.c.destroy();
    }

    @Override // com.byazt.nc.u
    public Bitmap getAdLogo() {
        return this.c.getAdLogo();
    }

    @Override // com.byazt.nc.u
    public View getAdView() {
        return this.c.getAdView();
    }

    @Override // com.byazt.nc.da
    public int getAdViewHeight() {
        return this.c.getAdViewHeight();
    }

    @Override // com.byazt.nc.da
    public int getAdViewWidth() {
        return this.c.getAdViewWidth();
    }

    @Override // com.byazt.nc.u
    public int getAppCommentNum() {
        return this.c.getAppCommentNum();
    }

    @Override // com.byazt.nc.u
    public int getAppScore() {
        return this.c.getAppScore();
    }

    @Override // com.byazt.nc.u
    public int getAppSize() {
        return this.c.getAppSize();
    }

    @Override // com.byazt.nc.u
    public String getButtonText() {
        return this.c.getButtonText();
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.ve getComplianceInfo() {
        return this.c.getComplianceInfo();
    }

    @Override // com.byazt.nc.da
    public com.byazt.yh.c getCustomVideo() {
        return this.c.getCustomVideo();
    }

    @Override // com.byazt.nc.u
    public String getDescription() {
        return this.c.getDescription();
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(Activity activity) {
        return this.c.getDislikeDialog(activity);
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.uj getDislikeInfo() {
        return this.c.getDislikeInfo();
    }

    @Override // com.byazt.nc.u
    public n getDownloadStatusController() {
        return this.c.getDownloadStatusController();
    }

    public da getFeedAd() {
        return this.c;
    }

    @Override // com.byazt.nc.u
    public t getIcon() {
        return this.c.getIcon();
    }

    @Override // com.byazt.nc.u
    public List<t> getImageList() {
        return this.c.getImageList();
    }

    @Override // com.byazt.nc.u
    public int getImageMode() {
        return this.c.getImageMode();
    }

    @Override // com.byazt.nc.u
    public int getInteractionType() {
        return this.c.getInteractionType();
    }

    @Override // com.byazt.nc.u
    public Map<String, Object> getMediaExtraInfo() {
        return this.c.getMediaExtraInfo();
    }

    @Override // com.byazt.nc.u
    public String getSource() {
        return this.c.getSource();
    }

    @Override // com.byazt.nc.u
    public String getTitle() {
        return this.c.getTitle();
    }

    @Override // com.byazt.nc.u
    public t getVideoCoverImage() {
        return this.c.getVideoCoverImage();
    }

    @Override // com.byazt.nc.da
    public double getVideoDuration() {
        return this.c.getVideoDuration();
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
        this.c.loss(d, str, str2);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, View view, com.byazt.lsp.c cVar) {
        this.c.registerViewForInteraction(viewGroup, view, cVar);
    }

    @Override // com.byazt.nc.u
    public void render() {
        this.c.render();
    }

    @Override // com.byazt.nc.u
    public void setActivityForDownloadApp(Activity activity) {
        this.c.setActivityForDownloadApp(activity);
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        this.c.setAdInteractionListener(ttVar);
    }

    @Override // com.byazt.nc.u
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        this.c.setDislikeCallback(activity, cVar);
    }

    @Override // com.byazt.nc.u
    public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
        this.c.setDislikeDialog(dialog, numArr);
    }

    @Override // com.byazt.nc.u
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        this.c.setDownloadListener(veVar);
    }

    @Override // com.byazt.nc.u
    public void setExpressRenderListener(com.byazt.lsp.ve veVar) {
        this.c.setExpressRenderListener(veVar);
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
        this.c.setPrice(d);
    }

    @Override // com.byazt.nc.da
    public void setVideoAdListener(com.byazt.bf.c cVar) {
        this.c.setVideoAdListener(cVar);
    }

    @Override // com.byazt.nc.da
    public void setVideoRewardListener(com.byazt.bf.tt ttVar) {
        this.c.setVideoRewardListener(ttVar);
    }

    @Override // com.byazt.nc.u
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.byazt.nc.u
    public void uploadDislikeEvent(String str) {
        this.c.uploadDislikeEvent(str);
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
        this.c.win(d);
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(Dialog dialog, Integer[] numArr) {
        return this.c.getDislikeDialog(dialog, numArr);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.lsp.c cVar) {
        this.c.registerViewForInteraction(viewGroup, list, list2, cVar);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.lsp.c cVar) {
        this.c.registerViewForInteraction(viewGroup, list, list2, view, cVar);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.lsp.c cVar) {
        this.c.registerViewForInteraction(viewGroup, list, list2, list3, view, cVar);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.lsp.c cVar) {
        this.c.registerViewForInteraction(viewGroup, list, list2, list3, list4, view, cVar);
    }
}
