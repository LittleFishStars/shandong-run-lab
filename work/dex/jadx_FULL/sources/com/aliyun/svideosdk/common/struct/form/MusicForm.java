package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class MusicForm implements Serializable {
    private int category;
    private int id;
    private int level;
    private String name;
    private int sort;
    private String url;

    public int getCategory() {
        return this.category;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public int getSort() {
        return this.sort;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
