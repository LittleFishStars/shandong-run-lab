package com.amap.api.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"ViewConstructor"})
public class SwipeDismissView extends RelativeLayout {
    protected WearMapView.OnDismissCallback onDismissCallback;

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    public void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view) {
        super(context, attributeSet, i);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }
}
