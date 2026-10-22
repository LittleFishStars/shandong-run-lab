package com.amap.api.maps.model;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.it;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.zj.adlib.ywa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Marker extends BasePointOverlay {
    private IPoint geoPoint;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable;
    private boolean isInfoWindowEnable;
    private boolean isRemoved;
    private boolean isUseAnimation;
    private Animation mCurAnimation;
    private Animation.AnimationListener mCurAnimationListener;
    private a mCurInnerAnimationListener;
    private Object object;
    private MarkerOptions options;
    private LatLng viewModeLatLng;
    private DPoint viewModeLatLngDp;

    public class a implements Animation.AnimationListener {
        private final it b;
        private final it c;

        public /* synthetic */ a(Marker marker, Animation.AnimationListener animationListener, byte b) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            ywa.a().b(this.c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            ywa.a().b(this.b);
        }

        private a(final Animation.AnimationListener animationListener) {
            this.b = new it() { // from class: com.amap.api.maps.model.Marker.a.1
                @Override // com.amap.api.col.p0003l.it
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.c = new it() { // from class: com.amap.api.maps.model.Marker.a.2
                @Override // com.amap.api.col.p0003l.it
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }
    }

    public Marker(IGlOverlayLayer iGlOverlayLayer, MarkerOptions markerOptions, String str) {
        super(str);
        this.isRemoved = false;
        this.viewModeLatLngDp = new DPoint();
        this.viewModeLatLng = null;
        this.isUseAnimation = false;
        this.mCurAnimation = null;
        this.mCurAnimationListener = null;
        this.mCurInnerAnimationListener = null;
        this.isClickable = true;
        this.isInfoWindowEnable = true;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = markerOptions;
    }

    private Object a(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void destroy() {
        try {
            remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Marker)) {
            try {
                MarkerOptions markerOptions = this.options;
                return markerOptions != null && markerOptions.equals(((Marker) obj).options) && this.overlayName.equals(((Marker) obj).overlayName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final float getAlpha() {
        Object objA;
        if (this.options != null) {
            return (!this.isUseAnimation || (objA = a("getAlpha", null)) == null) ? this.options.getAlpha() : ((Double) objA).floatValue();
        }
        return 1.0f;
    }

    public final float getAltitude() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getAltitude();
            }
            return 0.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public final float getAnchorU() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public final float getAnchorV() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public final int getDisplayLevel() {
        return 5;
    }

    public final IPoint getGeoPoint() {
        if (this.geoPoint == null) {
            this.geoPoint = new IPoint();
        }
        LatLng position = getPosition();
        if (position != null) {
            VirtualEarthProjection.latLongToPixels(position.latitude, position.longitude, 20, this.geoPoint);
        }
        return this.geoPoint;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.options.getIcons();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final Object getObject() {
        return this.object;
    }

    public final MarkerOptions getOptions() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions;
        }
        return null;
    }

    public final int getPeriod() {
        try {
            return this.options.getPeriod();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final LatLng getPosition() {
        Object objA;
        try {
            if (this.options != null) {
                if (!isViewMode()) {
                    return (!this.isUseAnimation || (objA = a("getPosition", null)) == null) ? this.options.getPosition() : (LatLng) objA;
                }
                this.glOverlayLayerRef.get().getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);
                LatLng latLng = this.viewModeLatLng;
                if (latLng != null) {
                    double d = latLng.latitude;
                    DPoint dPoint = this.viewModeLatLngDp;
                    if (d == dPoint.y && latLng.longitude == dPoint.x) {
                        return latLng;
                    }
                }
                DPoint dPoint2 = this.viewModeLatLngDp;
                return new LatLng(dPoint2.y, dPoint2.x);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final float getRotateAngle() {
        if (this.options == null) {
            return 0.0f;
        }
        if (this.isUseAnimation) {
            Object objA = a("getRotateAngle", null);
            Log.e("mapcore", "getRotateAngle ".concat(String.valueOf(objA)));
            if (objA != null) {
                return ((Double) objA).floatValue();
            }
        }
        return this.options.getRotateAngle();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getSnippet() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getTitle() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public final int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        String str = this.overlayName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public final void hideInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.hideInfoWindow(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isClickable() {
        Object objA = a("isClickable", null);
        return objA instanceof Boolean ? ((Boolean) objA).booleanValue() : this.isClickable;
    }

    public final boolean isDraggable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    public final boolean isFlat() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.options;
        return markerOptions != null ? markerOptions.isInfoWindowEnable() : this.isInfoWindowEnable;
    }

    public final boolean isInfoWindowShown() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return false;
        }
        Object objA = a("isInfoWindowShown", null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    public final boolean isPerspective() {
        return false;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isViewMode() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isVisible() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void remove() {
        try {
            if (isInfoWindowShown()) {
                hideInfoWindow();
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            this.isRemoved = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlpha(float f) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.alpha(f);
            a();
        }
    }

    public final void setAltitude(float f) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.altitude(f);
                a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setAnchor(float f, float f2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                Animation.AnimationListener animationListener = this.mCurAnimationListener;
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.mCurAnimation = animation;
        this.isUseAnimation = animation != null;
        a("setAnimation", new Object[]{animation});
        if (animation != null) {
            animation.resetUpdateFlags();
        }
    }

    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mCurAnimationListener = animationListener;
        a aVar = new a(this, animationListener, (byte) 0);
        this.mCurInnerAnimationListener = aVar;
        if (this.mCurAnimation != null) {
            a("setAnimationListener", new Object[]{aVar});
        }
    }

    public final void setAutoOverturnInfoWindow(boolean z) {
    }

    public final void setBelowMaskLayer(boolean z) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.belowMaskLayer(z);
            a();
        }
    }

    public final void setClickable(boolean z) {
        this.isClickable = z;
        a("setClickable", new Object[]{Boolean.valueOf(z)});
    }

    public final void setDisplayLevel(int i) {
    }

    public final void setDraggable(boolean z) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFixingPointEnable(boolean z) {
    }

    public final void setFlat(boolean z) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.setFlat(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setGeoPoint(IPoint iPoint) {
        this.geoPoint = iPoint;
        if (iPoint != null) {
            DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            LatLng latLng = new LatLng(dPointPixelsToLatLong.y, dPointPixelsToLatLong.x, false);
            dPointPixelsToLatLong.recycle();
            this.options.position(latLng);
            a();
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.options.icons(arrayList);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowEnable(boolean z) {
        this.isInfoWindowEnable = z;
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z);
            a();
        }
    }

    public final void setMarkerOptions(MarkerOptions markerOptions) {
        this.options = markerOptions;
        a();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setObject(Object obj) {
        this.object = obj;
    }

    public final void setPeriod(int i) {
        try {
            this.options.period(i);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPerspective(boolean z) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setPosition(LatLng latLng) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionByPixels(int i, int i2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.setScreenPosition(i, i2);
            a();
        }
    }

    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setRotateAngle(float f) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateAngleNotUpdate(float f) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setSnippet(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setTitle(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setToTop() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.set2Top(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setVisible(boolean z) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void showInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.showInfoWindow(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean startAnimation() {
        Object objA = a("startAnimation", null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }
}
