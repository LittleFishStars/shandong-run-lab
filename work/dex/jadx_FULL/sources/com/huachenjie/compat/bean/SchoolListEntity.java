package com.huachenjie.compat.bean;

import com.huachenjie.common.bean.SchoolInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class SchoolListEntity {
    private boolean hasNext;
    private List<SchoolInfo> list;

    public List<SchoolInfo> getList() {
        return this.list;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public void setList(List<SchoolInfo> list) {
        this.list = list;
    }
}
