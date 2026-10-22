package com.fl.saas.base.widget;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FlowView extends RelativeLayout {
    private RenderListener mRenderListener;

    public FlowView(Context context) {
        super(context);
    }

    public void render() {
        this.mRenderListener.render();
    }

    public void setRenderListener(RenderListener renderListener) {
        this.mRenderListener = renderListener;
    }
}
