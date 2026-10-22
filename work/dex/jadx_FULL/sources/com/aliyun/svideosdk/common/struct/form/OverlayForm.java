package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class OverlayForm implements Serializable {
    private String description;
    private String icon;
    private int id;
    private int isNew;
    private int level;
    private String name;
    List<PasterForm> pasterList;
    private String preview;
    private int sort;

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int getIsNew() {
        return this.isNew;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public List<PasterForm> getPasterList() {
        return this.pasterList;
    }

    public String getPreview() {
        return this.preview;
    }

    public int getSort() {
        return this.sort;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsNew(int i) {
        this.isNew = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPasterList(List<PasterForm> list) {
        this.pasterList = list;
    }

    public void setPreview(String str) {
        this.preview = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }
}
