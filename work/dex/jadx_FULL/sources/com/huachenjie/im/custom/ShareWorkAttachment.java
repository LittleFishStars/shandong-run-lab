package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareWorkAttachment extends BaseAttachment {
    protected String coverUrl = "";
    protected int coverWidth = 0;
    protected int coverHeight = 0;
    protected String title = "";
    protected String channelName = "";
    protected String avatar = "";
    protected String nickName = "";
    protected int type = 0;
    protected String popularityValue = "";
    protected String worksNo = "";

    public String getAvatar() {
        return this.avatar;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getCoverHeight() {
        return this.coverHeight;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getCoverWidth() {
        return this.coverWidth;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 9;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPopularityValue() {
        return this.popularityValue;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getWorksNo() {
        return this.worksNo;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setCoverHeight(int i) {
        this.coverHeight = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCoverWidth(int i) {
        this.coverWidth = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPopularityValue(String str) {
        this.popularityValue = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setWorksNo(String str) {
        this.worksNo = str;
    }
}
