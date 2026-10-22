package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareChannelAttachment extends BaseAttachment {
    protected String channelName = "";
    protected String channelNo = "";
    protected String coverUrl = "";
    protected String channelUserValue = "";
    protected String popularityValue = "";
    protected List<String> avatarList = new ArrayList();

    public List<String> getAvatarList() {
        return this.avatarList;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getChannelNo() {
        return this.channelNo;
    }

    public String getChannelUserValue() {
        return this.channelUserValue;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 10;
    }

    public String getPopularityValue() {
        return this.popularityValue;
    }

    public void setAvatarList(List<String> list) {
        this.avatarList = list;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setChannelNo(String str) {
        this.channelNo = str;
    }

    public void setChannelUserValue(String str) {
        this.channelUserValue = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setPopularityValue(String str) {
        this.popularityValue = str;
    }
}
