package com.beizi.fusion.unified;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BZUnifiedAdTemplateBeanModel {
    private String actionText;
    private String adBrand;
    private String creativeId;
    private String desc;
    private BZUnifiedAdImageInfo icon;
    private BZUnifiedAdImageInfo image;
    private List<BZUnifiedAdImageInfo> imageList;
    private String title;
    private BZUnifiedAdVideoInfo video;

    public String getActionText() {
        return this.actionText;
    }

    public String getAdBrand() {
        return this.adBrand;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getDesc() {
        return this.desc;
    }

    public BZUnifiedAdImageInfo getIcon() {
        return this.icon;
    }

    public BZUnifiedAdImageInfo getImage() {
        return this.image;
    }

    public List<BZUnifiedAdImageInfo> getImageList() {
        return this.imageList;
    }

    public String getTitle() {
        return this.title;
    }

    public BZUnifiedAdVideoInfo getVideo() {
        return this.video;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAdBrand(String str) {
        this.adBrand = str;
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIcon(BZUnifiedAdImageInfo bZUnifiedAdImageInfo) {
        this.icon = bZUnifiedAdImageInfo;
    }

    public void setImage(BZUnifiedAdImageInfo bZUnifiedAdImageInfo) {
        this.image = bZUnifiedAdImageInfo;
    }

    public void setImageList(List<BZUnifiedAdImageInfo> list) {
        this.imageList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(BZUnifiedAdVideoInfo bZUnifiedAdVideoInfo) {
        this.video = bZUnifiedAdVideoInfo;
    }
}
