package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class GiftGivingAttachment extends BaseAttachment {
    protected int count;
    protected int itemCode;
    protected int type;
    protected String itemImgUrl = "";
    protected String itemName = "";
    protected String itemDescription = "";
    protected String geneType = "";
    protected String createBy = "";
    protected String recordCode = "";
    protected String sendFriendCode = "";

    public int getCount() {
        return this.count;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 0;
    }

    public String getGeneType() {
        return this.geneType;
    }

    public int getItemCode() {
        return this.itemCode;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public String getItemImgUrl() {
        return this.itemImgUrl;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public String getSendFriendCode() {
        return this.sendFriendCode;
    }

    public int getType() {
        return this.type;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCreateBy(String str) {
        this.createBy = str;
    }

    public void setGeneType(String str) {
        this.geneType = str;
    }

    public void setItemCode(int i) {
        this.itemCode = i;
    }

    public void setItemDescription(String str) {
        this.itemDescription = str;
    }

    public void setItemImgUrl(String str) {
        this.itemImgUrl = str;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public void setRecordCode(String str) {
        this.recordCode = str;
    }

    public void setSendFriendCode(String str) {
        this.sendFriendCode = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
