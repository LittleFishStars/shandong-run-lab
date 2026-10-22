package com.alibaba.sdk.android.oss.model;

import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CopyObjectResult extends OSSResult {
    private String etag;
    private Date lastModified;

    public String getETag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }
}
