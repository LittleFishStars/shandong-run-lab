package com.alibaba.triver.kit.api.widget;

import android.content.Context;
import android.view.View;
import com.alibaba.triver.kit.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class Action {
    public static final int BOTTOM = 3;
    public static final int CENTER = 2;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public int location;

    public void attatchPage(Page page) {
    }

    public abstract View getView(Context context);

    public boolean isDark(String str) {
        return "dark".equalsIgnoreCase(str);
    }

    public void onDestroy() {
    }

    public void onHide() {
    }

    public void onShow() {
    }

    public void setStyle(String str) {
    }
}
