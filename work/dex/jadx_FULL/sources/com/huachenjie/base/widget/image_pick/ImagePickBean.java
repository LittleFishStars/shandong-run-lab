package com.huachenjie.base.widget.image_pick;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ImagePickBean implements MultiItemEntity {
    private String addTip = "上传图片";
    private Object extendedParams;
    private int height;
    private String localPath;
    private int type;
    private String url;
    private int width;

    public ImagePickBean(int type) {
        this.type = type;
    }

    public String getAddTip() {
        return this.addTip;
    }

    public Object getExtendedParams() {
        return this.extendedParams;
    }

    public int getHeight() {
        return this.height;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAddTip(String addTip) {
        this.addTip = addTip;
    }

    public void setExtendedParams(Object extendedParams) {
        this.extendedParams = extendedParams;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ImagePickBean(int type, String url, int width, int height) {
        this.type = type;
        this.url = url;
        this.localPath = url;
        this.width = width;
        this.height = height;
    }
}
