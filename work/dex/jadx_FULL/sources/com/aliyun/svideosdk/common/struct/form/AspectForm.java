package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class AspectForm {
    private int aspect;
    private String download;
    private String md5;
    private String path;

    public int getAspect() {
        return this.aspect;
    }

    public String getDownload() {
        return this.download;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPath() {
        return this.path;
    }

    public void setAspect(int i) {
        this.aspect = i;
    }

    public void setDownload(String str) {
        this.download = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
