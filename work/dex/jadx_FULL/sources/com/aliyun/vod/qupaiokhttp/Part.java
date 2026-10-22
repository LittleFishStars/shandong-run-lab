package com.aliyun.vod.qupaiokhttp;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Part {
    private FileWrapper fileWrapper;
    private String key;
    private String value;

    public Part(String str, String str2) {
        setKey(str);
        setValue(str2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Part)) {
            Part part = (Part) obj;
            if (TextUtils.equals(part.getKey(), getKey()) && TextUtils.equals(part.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    public FileWrapper getFileWrapper() {
        return this.fileWrapper;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        if (str == null) {
            this.key = "";
        } else {
            this.key = str;
        }
    }

    public void setValue(String str) {
        if (str == null) {
            this.value = "";
        } else {
            this.value = str;
        }
    }

    public Part(String str, FileWrapper fileWrapper) {
        setKey(str);
        this.fileWrapper = fileWrapper;
    }
}
