package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.header.internal.pathview.PathsView;
import com.zj.adlib.qk8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FlyView extends PathsView {
    public FlyView(Context context) {
        this(context, null);
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.parserColors(-1);
        if (!this.mPathsDrawable.f("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z")) {
            this.mPathsDrawable.c(2, 3, 20, 18);
        }
        int iD = qk8.d(25.0f);
        this.mPathsDrawable.setBounds(0, 0, iD, iD);
    }
}
