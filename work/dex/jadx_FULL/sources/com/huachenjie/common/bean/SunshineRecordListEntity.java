package com.huachenjie.common.bean;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SunshineRecordListEntity {
    private boolean hasNext;
    private List<DailySunshineRecord> list;
    private int pageNum;

    public List<DailySunshineRecord> getList() {
        return this.list;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setList(List<DailySunshineRecord> list) {
        this.list = list;
    }

    public SunshineRecordListEntity setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }
}
