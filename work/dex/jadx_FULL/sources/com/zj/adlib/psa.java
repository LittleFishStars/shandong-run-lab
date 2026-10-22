package com.zj.adlib;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class psa implements IInfoWindowManager, IInfoWindowAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f44053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IGlOverlayLayer f18935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qja f18936a;
    public final String f = "PopupOverlay";

    public psa(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.f44053a = context;
        this.f18935a = iGlOverlayLayer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void hideInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f18935a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.f18935a;
        if (iGlOverlayLayer != null && motionEvent != null) {
            Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(motionEvent.getX()), Double.valueOf(motionEvent.getY())});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f18935a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(qja qjaVar) {
        synchronized (this) {
            this.f18936a = qjaVar;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAppearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackColor(int i) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackEnable(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackScale(float f, float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowDisappearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        IGlOverlayLayer iGlOverlayLayer = this.f18935a;
        if (iGlOverlayLayer != null && basePointOverlay != null) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void startAnimation() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
    }
}
