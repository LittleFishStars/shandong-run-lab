package com.huachenjie.base.widget.calendar;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class Month implements Serializable {
    private int count;
    private int diff;
    private int month;
    private int year;

    public int getCount() {
        return this.count;
    }

    public int getDiff() {
        return this.diff;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
