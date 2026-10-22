package com.igexin.sdk.message;

import android.text.TextUtils;
import com.igexin.sdk.Tag;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class QueryTagCmdMessage extends GTCmdMessage {
    private String code;
    private String sn;
    private Tag[] tags;

    public QueryTagCmdMessage(String str, String str2, String str3, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
        if (TextUtils.isEmpty(str3) || str3.equals("none")) {
            return;
        }
        String[] strArrSplit = str3.split(" ");
        Tag[] tagArr = new Tag[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            Tag tag = new Tag();
            tag.setName(strArrSplit[i2]);
            tagArr[i2] = tag;
        }
        this.tags = tagArr;
    }

    public String getCode() {
        return this.code;
    }

    public String getSn() {
        return this.sn;
    }

    public Tag[] getTags() {
        return this.tags;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setTags(Tag[] tagArr) {
        this.tags = tagArr;
    }
}
