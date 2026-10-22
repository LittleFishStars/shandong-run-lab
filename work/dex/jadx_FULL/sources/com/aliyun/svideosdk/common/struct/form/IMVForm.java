package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class IMVForm implements Serializable {
    private List<AspectForm> aspectList;
    private int cat;
    private long duration;
    private String icon;
    private int id;
    private String key;
    private int level;
    private String name;
    private String previewMp4;
    private String previewPic;
    private int sort;
    private String tag;
    private int type;

    public List<AspectForm> getAspectList() {
        return this.aspectList;
    }

    public int getCat() {
        return this.cat;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getPreviewMp4() {
        return this.previewMp4;
    }

    public String getPreviewPic() {
        return this.previewPic;
    }

    public int getSort() {
        return this.sort;
    }

    public String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public void setAspectList(List<AspectForm> list) {
        this.aspectList = list;
    }

    public void setCat(int i) {
        this.cat = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPreviewMp4(String str) {
        this.previewMp4 = str;
    }

    public void setPreviewPic(String str) {
        this.previewPic = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
