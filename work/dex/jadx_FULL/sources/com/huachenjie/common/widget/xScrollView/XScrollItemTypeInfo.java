package com.huachenjie.common.widget.xScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class XScrollItemTypeInfo {
    private int itemType;
    private int layoutResId;

    public XScrollItemTypeInfo(int type, int resId) {
        this.itemType = type;
        this.layoutResId = resId;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int getLayoutResId() {
        return this.layoutResId;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public void setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
    }
}
