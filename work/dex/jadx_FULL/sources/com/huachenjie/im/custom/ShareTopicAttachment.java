package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareTopicAttachment extends BaseAttachment {
    protected String subjectName = "";
    protected String subjectImg = "";
    protected String subjectNo = "";
    protected String popularityValue = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 11;
    }

    public String getPopularityValue() {
        return this.popularityValue;
    }

    public String getSubjectImg() {
        return this.subjectImg;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public String getSubjectNo() {
        return this.subjectNo;
    }

    public void setPopularityValue(String str) {
        this.popularityValue = str;
    }

    public void setSubjectImg(String str) {
        this.subjectImg = str;
    }

    public void setSubjectName(String str) {
        this.subjectName = str;
    }

    public void setSubjectNo(String str) {
        this.subjectNo = str;
    }
}
