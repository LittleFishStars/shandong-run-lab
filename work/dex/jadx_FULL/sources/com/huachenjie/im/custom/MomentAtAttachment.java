package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class MomentAtAttachment extends BaseAttachment {
    protected String atUserAccId = "";
    protected String atAppUserName = "";
    protected String content = "";

    public String getAtAppUserName() {
        return this.atAppUserName;
    }

    public String getAtUserAccId() {
        return this.atUserAccId;
    }

    public String getContent() {
        return this.content;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 5;
    }

    public void setAtAppUserName(String str) {
        this.atAppUserName = str;
    }

    public void setAtUserAccId(String str) {
        this.atUserAccId = str;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
