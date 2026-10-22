package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public final class MarkerOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f26125a;
    private LatLng gpsLatLng;
    private boolean isBelowMaskLayer;
    private LatLng latLng;
    private float rotate;
    private int screenX;
    private int screenY;
    private String snippet;
    private String title;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private float zIndex = 0.0f;
    private boolean isDraggable = false;
    private boolean isVisible = true;
    private float altitude = 0.0f;

    @JBindingExclude
    private boolean perspective = false;
    private int offsetX = 0;
    private int offsetY = 0;
    private List<BitmapDescriptor> bitmapDescriptors = new ArrayList();
    private int period = 20;
    private boolean isGps = false;
    private boolean isFlat = false;
    private boolean isRotatingMode = false;
    private float angleOffset = 0.0f;
    private boolean isViewMode = false;
    private float alpha = 1.0f;
    private boolean autoOverturn = false;
    private boolean infoWindowEnabled = true;
    private int dispLevel = 5;
    private MarkerUpdateFlags updateFlags = new MarkerUpdateFlags();

    @JBindingInclude
    public static class MarkerUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean latlngUpdate = false;
        protected boolean gpsLatLngUpdate = false;
        protected boolean bitmapDescriptorsUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
        }
    }

    public MarkerOptions() {
        this.type = "MarkerOptions";
    }

    private void a() {
        if (this.bitmapDescriptors == null) {
            try {
                this.bitmapDescriptors = new ArrayList();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b() {
        LatLng latLng;
        try {
            if (!this.isGps || (latLng = this.latLng) == null) {
                return;
            }
            double[] dArrA = com.autonavi.util.a.a(latLng.longitude, latLng.latitude);
            this.gpsLatLng = new LatLng(dArrA[1], dArrA[0]);
            this.updateFlags.gpsLatLngUpdate = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final MarkerOptions alpha(float f) {
        this.alpha = f;
        return this;
    }

    public final MarkerOptions altitude(float f) {
        this.altitude = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public final MarkerOptions angleOffset(float f) {
        this.angleOffset = f;
        return this;
    }

    public final MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.autoOverturn = z;
        return this;
    }

    public final MarkerOptions belowMaskLayer(boolean z) {
        this.isBelowMaskLayer = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final MarkerOptions displayLevel(int i) {
        this.dispLevel = i;
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.isDraggable = z;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAltitude() {
        return this.altitude;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getAngleOffset() {
        return this.angleOffset;
    }

    public final int getDisplayLevel() {
        return this.dispLevel;
    }

    public final BitmapDescriptor getIcon() {
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.bitmapDescriptors.get(0);
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return (ArrayList) this.bitmapDescriptors;
    }

    public final int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public final int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public final int getPeriod() {
        return this.period;
    }

    public final LatLng getPosition() {
        return this.latLng;
    }

    public final float getRotateAngle() {
        return this.rotate;
    }

    public final int getScreenX() {
        return this.screenX;
    }

    public final int getScreenY() {
        return this.screenY;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.bitmapDescriptors.clear();
            this.bitmapDescriptors.add(bitmapDescriptor);
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions infoWindowEnable(boolean z) {
        this.infoWindowEnabled = z;
        return this;
    }

    public final boolean isBelowMaskLayer() {
        return this.isBelowMaskLayer;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.autoOverturn;
    }

    public final boolean isInfoWindowEnable() {
        return this.infoWindowEnabled;
    }

    public final boolean isPerspective() {
        return this.perspective;
    }

    public final boolean isRotatingMode() {
        return this.isRotatingMode;
    }

    public final boolean isViewMode() {
        return this.isViewMode;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final MarkerOptions period(int i) {
        if (i <= 1) {
            this.period = 1;
        } else {
            this.period = i;
        }
        return this;
    }

    public final MarkerOptions perspective(boolean z) {
        this.perspective = z;
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        this.latLng = latLng;
        this.isViewMode = false;
        b();
        this.updateFlags.latlngUpdate = true;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final MarkerOptions rotateAngle(float f) {
        this.rotate = f;
        return this;
    }

    public final MarkerOptions rotatingIcons(ArrayList<BitmapDescriptor> arrayList, float f) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            if (f != 0.0f) {
                this.angleOffset = f;
            } else {
                this.angleOffset = 360.0f / arrayList.size();
            }
            this.isRotatingMode = true;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions setFlat(boolean z) {
        this.isFlat = z;
        return this;
    }

    public final MarkerOptions setGps(boolean z) {
        this.isGps = z;
        b();
        return this;
    }

    public final MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.offsetX = i;
        this.offsetY = i2;
        return this;
    }

    public final MarkerOptions setRotatingMode(boolean z) {
        this.isRotatingMode = z;
        return this;
    }

    public final void setScreenPosition(int i, int i2) {
        this.screenX = i;
        this.screenY = i2;
        this.isViewMode = true;
    }

    public final MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.latLng, i);
        parcel.writeString(this.title);
        parcel.writeString(this.snippet);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.autoOverturn, this.infoWindowEnabled, this.isBelowMaskLayer, this.isRotatingMode});
        parcel.writeString(this.f26125a);
        parcel.writeInt(this.period);
        parcel.writeList(this.bitmapDescriptors);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.alpha);
        parcel.writeInt(this.dispLevel);
        parcel.writeFloat(this.rotate);
        parcel.writeFloat(this.angleOffset);
        parcel.writeInt(this.screenX);
        parcel.writeInt(this.screenY);
        parcel.writeFloat(this.altitude);
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return;
        }
        parcel.writeParcelable(this.bitmapDescriptors.get(0), i);
    }

    public final MarkerOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final MarkerOptions m158clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.latLng = this.latLng;
        markerOptions.gpsLatLng = this.gpsLatLng;
        markerOptions.title = this.title;
        markerOptions.snippet = this.snippet;
        markerOptions.anchorU = this.anchorU;
        markerOptions.anchorV = this.anchorV;
        markerOptions.zIndex = this.zIndex;
        markerOptions.isDraggable = this.isDraggable;
        markerOptions.isVisible = this.isVisible;
        markerOptions.f26125a = this.f26125a;
        markerOptions.perspective = this.perspective;
        markerOptions.offsetX = this.offsetX;
        markerOptions.offsetY = this.offsetY;
        markerOptions.bitmapDescriptors = this.bitmapDescriptors;
        markerOptions.period = this.period;
        markerOptions.isGps = this.isGps;
        markerOptions.isFlat = this.isFlat;
        markerOptions.isRotatingMode = this.isRotatingMode;
        markerOptions.angleOffset = this.angleOffset;
        markerOptions.screenX = this.screenX;
        markerOptions.screenY = this.screenY;
        markerOptions.isViewMode = this.isViewMode;
        markerOptions.alpha = this.alpha;
        markerOptions.autoOverturn = this.autoOverturn;
        markerOptions.infoWindowEnabled = this.infoWindowEnabled;
        markerOptions.dispLevel = this.dispLevel;
        markerOptions.rotate = this.rotate;
        markerOptions.isBelowMaskLayer = this.isBelowMaskLayer;
        markerOptions.updateFlags = this.updateFlags;
        markerOptions.altitude = this.altitude;
        return markerOptions;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final MarkerUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }
}
