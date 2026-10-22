package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class FontForm implements Serializable {
    private String banner;
    private String icon;
    private int id;
    private int level;
    private String md5;
    private String name;
    private int sort;
    private int type;
    private String url;

    public String getBanner() {
        return this.banner;
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

    public int getSort() {
        return this.sort;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBanner(String str) {
        this.banner = str;
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

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setName(String str) {
        this.name = str;
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
