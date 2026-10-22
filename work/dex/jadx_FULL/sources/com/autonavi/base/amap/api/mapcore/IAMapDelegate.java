package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003l.k;
import com.amap.api.maps.AMap;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import com.zj.adlib.qja;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i, GLTextureProperty gLTextureProperty);

    void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String str, boolean z, int i);

    void changeMapLogo(int i, boolean z);

    void changeSize(int i, int i2);

    void changeSurface(int i, GL10 gl10, int i2, int i3);

    float checkZoomLevel(float f) throws RemoteException;

    void clearTileCache();

    String createId(String str);

    int createOverlayTexture(int i, Bitmap bitmap);

    void createSurface(int i, GL10 gl10, EGLConfig eGLConfig);

    void geo2Latlng(int i, int i2, DPoint dPoint);

    void geo2Map(int i, int i2, FPoint fPoint);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int i);

    CameraPosition getCameraPositionPrj(boolean z);

    Context getContext();

    k getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int i, IPoint iPoint);

    IGlOverlayLayer getGlOverlayLayer();

    qja getInfoWindowDelegate();

    void getLatLng2Map(double d, double d2, FPoint fPoint);

    void getLatLng2Pixel(double d, double d2, IPoint iPoint);

    float getLogoMarginRate(int i);

    int getLogoPosition();

    float getMapAngle(int i);

    LatLngBounds getMapBounds(LatLng latLng, float f, float f2, float f3);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int i, int i2, IPoint iPoint);

    void getPixel2LatLng(int i, int i2, DPoint dPoint);

    float getPreciseLevel(int i);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i);

    boolean isLockMapCameraDegree(int i);

    boolean isUseAnchor();

    void latlon2Geo(double d, double d2, IPoint iPoint);

    void map2Geo(float f, float f2, IPoint iPoint);

    void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    boolean onDoubleTap(int i, MotionEvent motionEvent);

    void onLongPress(int i, MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i, MotionEvent motionEvent);

    void pixel2Map(int i, int i2, PointF pointF);

    void post(Runnable runnable);

    void redrawInfoWindow();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(String str);

    boolean removeGLOverlay(String str) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z, byte[] bArr);

    void setGestureStatus(int i, int i2);

    void setHideLogoEnble(boolean z);

    void setLogoBottomMargin(int i);

    void setLogoLeftMargin(int i);

    void setLogoMarginRate(int i, float f);

    void setLogoPosition(int i);

    void setMapCustomEnable(boolean z, boolean z2);

    void setMapEnable(boolean z);

    void setMapWidgetListener(AMapWidgetListener aMapWidgetListener);

    void setTerrainAuth(boolean z);

    void setZoomPosition(int i);

    void showCompassEnabled(boolean z);

    void showIndoorSwitchControlsEnabled(boolean z);

    void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;

    void showLogoEnabled(boolean z);

    void showMyLocationButtonEnabled(boolean z);

    void showMyLocationOverlay(Location location) throws RemoteException;

    void showScaleEnabled(boolean z);

    void showZoomControlsEnabled(boolean z);

    float toMapLenWithWin(int i);

    void zoomOut(int i);
}
