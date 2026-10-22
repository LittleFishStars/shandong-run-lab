package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.model.BasePointOverlay;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.zj.adlib.qja;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IInfoWindowAction {
    void hideInfoWindow();

    boolean isInfoWindowShown();

    boolean onInfoWindowTap(MotionEvent motionEvent);

    void redrawInfoWindow();

    void setInfoWindowAdapterManager(qja qjaVar);

    void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;
}
