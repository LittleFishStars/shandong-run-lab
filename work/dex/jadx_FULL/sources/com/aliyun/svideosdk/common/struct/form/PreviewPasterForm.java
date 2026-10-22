package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class PreviewPasterForm implements Serializable {
    private int fontId;
    private String icon;
    private int id;
    private boolean isLocalRes;
    private int level;
    private String md5;
    private String name;
    private String path;
    private String preview;
    private int sort;
    private int type;
    private String url;

    public int getFontId() {
        return this.fontId;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getPreview() {
        return this.preview;
    }

    public int getSort() {
        return this.sort;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isLocalRes() {
        return this.isLocalRes;
    }

    public void setFontId(int i) {
        this.fontId = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setLocalRes(boolean z) {
        this.isLocalRes = z;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPreview(String str) {
        this.preview = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
