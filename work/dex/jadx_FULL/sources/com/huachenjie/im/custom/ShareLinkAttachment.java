package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareLinkAttachment extends BaseAttachment {
    protected String title = "";
    protected String desc = "";
    protected String imageUrl = "";
    protected String link = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 100;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLink() {
        return this.link;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
