package com.amap.api.maps;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SwipeDismissView f26109a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f26109a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.f26109a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        WearMapView.OnDismissCallback onDismissCallback = this.f26109a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onNotifySwipe();
        }
    }
}
