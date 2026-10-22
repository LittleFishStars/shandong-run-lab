package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareEmojiAttachment extends BaseAttachment {
    protected String emojiBagCode = "";
    protected String emojiBagName = "";
    protected String emojiUrl = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 4;
    }

    public String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    public String getEmojiBagName() {
        return this.emojiBagName;
    }

    public String getEmojiUrl() {
        return this.emojiUrl;
    }

    public void setEmojiBagCode(String str) {
        this.emojiBagCode = str;
    }

    public void setEmojiBagName(String str) {
        this.emojiBagName = str;
    }

    public void setEmojiUrl(String str) {
        this.emojiUrl = str;
    }
}
