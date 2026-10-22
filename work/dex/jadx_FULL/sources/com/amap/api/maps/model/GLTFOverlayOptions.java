package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class GLTFOverlayOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final GLTFOverlayOptionsCreator CREATOR = new GLTFOverlayOptionsCreator();
    private int currentAnimationIndex;
    private BitmapDescriptor infoWindowView;
    private boolean isClick;
    private boolean isClickable;
    private boolean isDraggable;
    private double mAltitude;
    private LatLng mLatLng;
    private byte[] mModelData;
    private double mScale;
    private List<GLTFResourceIterm> mUriResources;
    private double mXDegree;
    private double mYDegree;
    private double mZDegree;
    private float maxZoom;
    private float minZoom;
    private String title;

    public GLTFOverlayOptions() {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.type = "GLTFOverlayOptions";
    }

    public GLTFOverlayOptions altitude(double d) {
        this.mAltitude = d;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public int getCurrentAnimationIndex() {
        return this.currentAnimationIndex;
    }

    public BitmapDescriptor getInfoWindowView() {
        return this.infoWindowView;
    }

    public LatLng getLatLng() {
        return this.mLatLng;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public byte[] getModelData() {
        return this.mModelData;
    }

    public double getScale() {
        return this.mScale;
    }

    public List<GLTFResourceIterm> getUriResources() {
        return this.mUriResources;
    }

    public double getXDegree() {
        return this.mXDegree;
    }

    public double getYDegree() {
        return this.mYDegree;
    }

    public double getZDegree() {
        return this.mZDegree;
    }

    public void infoWindowView(BitmapDescriptor bitmapDescriptor) {
        this.infoWindowView = bitmapDescriptor;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isInfoWindowShow() {
        return this.isClick;
    }

    public GLTFOverlayOptions latLng(LatLng latLng) {
        this.mLatLng = latLng;
        return this;
    }

    public GLTFOverlayOptions modelData(byte[] bArr) {
        if (bArr != null) {
            this.mModelData = bArr;
        }
        return this;
    }

    public GLTFOverlayOptions rotationDegree(double d, double d2, double d3) {
        this.mXDegree = d;
        this.mYDegree = d2;
        this.mZDegree = d3;
        return this;
    }

    public GLTFOverlayOptions scale(double d) {
        this.mScale = d;
        return this;
    }

    public void setClickable(boolean z) {
        this.isClickable = z;
    }

    public void setCurrentAnimationIndex(int i) {
        this.currentAnimationIndex = i;
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public void setZoomRange(float f, float f2) {
        this.minZoom = f;
        this.maxZoom = f2;
    }

    public void tapClick() {
        this.isClick = !this.isClick;
    }

    public GLTFOverlayOptions uriResources(List<GLTFResourceIterm> list) {
        this.mUriResources = list;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mLatLng, i);
        parcel.writeDouble(this.mZDegree);
        parcel.writeDouble(this.mXDegree);
        parcel.writeDouble(this.mYDegree);
        parcel.writeDouble(this.mAltitude);
        parcel.writeDouble(this.mScale);
        parcel.writeByteArray(this.mModelData);
        parcel.writeList(this.mUriResources);
        BitmapDescriptor bitmapDescriptor = this.infoWindowView;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i);
        }
        String str = this.title;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.currentAnimationIndex);
        parcel.writeFloat(this.minZoom);
        parcel.writeFloat(this.maxZoom);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLTFOverlayOptions m155clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        GLTFOverlayOptions gLTFOverlayOptions = new GLTFOverlayOptions();
        gLTFOverlayOptions.mLatLng = this.mLatLng.m157clone();
        gLTFOverlayOptions.mZDegree = this.mZDegree;
        gLTFOverlayOptions.mXDegree = this.mXDegree;
        gLTFOverlayOptions.mYDegree = this.mYDegree;
        gLTFOverlayOptions.mAltitude = this.mAltitude;
        gLTFOverlayOptions.mScale = this.mScale;
        gLTFOverlayOptions.mModelData = this.mModelData;
        gLTFOverlayOptions.mUriResources = this.mUriResources;
        gLTFOverlayOptions.isClickable = this.isClickable;
        gLTFOverlayOptions.isDraggable = this.isDraggable;
        BitmapDescriptor bitmapDescriptor = this.infoWindowView;
        if (bitmapDescriptor != null) {
            gLTFOverlayOptions.infoWindowView = bitmapDescriptor.m153clone();
        }
        String str = this.title;
        if (str != null) {
            gLTFOverlayOptions.title = str;
        }
        gLTFOverlayOptions.currentAnimationIndex = this.currentAnimationIndex;
        gLTFOverlayOptions.minZoom = this.minZoom;
        gLTFOverlayOptions.maxZoom = this.maxZoom;
        return gLTFOverlayOptions;
    }

    @JBindingExclude
    public GLTFOverlayOptions(LatLng latLng, double d, double d2, String str, List<GLTFResourceIterm> list) {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.mLatLng = latLng;
        this.mAltitude = d;
        this.mScale = d2;
        if (str != null) {
            this.mModelData = str.getBytes();
        } else {
            this.mModelData = "".getBytes();
        }
        this.mUriResources = list;
    }

    @JBindingExclude
    public GLTFOverlayOptions(Parcel parcel) {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.mLatLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mZDegree = parcel.readDouble();
        this.mXDegree = parcel.readDouble();
        this.mYDegree = parcel.readDouble();
        this.mAltitude = parcel.readDouble();
        this.mScale = parcel.readDouble();
        parcel.readByteArray(this.mModelData);
        this.mUriResources = parcel.readArrayList(GLTFResourceIterm.class.getClassLoader());
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.isClickable = zArr[0];
        this.isDraggable = zArr[1];
        this.infoWindowView = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.title = parcel.readString();
        this.currentAnimationIndex = parcel.readInt();
        this.minZoom = parcel.readFloat();
        this.maxZoom = parcel.readFloat();
    }
}
