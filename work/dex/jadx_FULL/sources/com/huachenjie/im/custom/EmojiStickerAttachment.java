package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class EmojiStickerAttachment extends BaseAttachment {
    protected String emojiUrl = "";
    protected int width = 0;
    protected int height = 0;

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 2;
    }

    public String getEmojiUrl() {
        return this.emojiUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setEmojiUrl(String str) {
        this.emojiUrl = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
