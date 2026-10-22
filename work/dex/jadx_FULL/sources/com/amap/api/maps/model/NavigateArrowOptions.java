package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.math.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public final class NavigateArrowOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f26126a;
    private float width = 10.0f;
    private int topColor = Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 87, 235, 204);
    private int sideColor = Color.argb(c.f6376a, 0, 172, 146);
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean is3DModel = false;
    private int arrowLineInnerResId = 111;
    private int arrowLineOuterResId = 222;
    private int arrowLineShadowResId = 333;
    private final List<LatLng> points = new ArrayList();

    public NavigateArrowOptions() {
        this.type = "NavigateArrowOptions";
    }

    public final NavigateArrowOptions add(LatLng latLng) {
        this.points.add(latLng);
        return this;
    }

    public final NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.points.add(it.next());
        }
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final int getSideColor() {
        return this.sideColor;
    }

    public final int getTopColor() {
        return this.topColor;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean is3DModel() {
        return this.is3DModel;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final NavigateArrowOptions set3DModel(boolean z) {
        this.is3DModel = z;
        return this;
    }

    public final void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list == null || (list2 = this.points) == list) {
            return;
        }
        try {
            list2.clear();
            this.points.addAll(list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final NavigateArrowOptions sideColor(int i) {
        this.sideColor = i;
        return this;
    }

    public final NavigateArrowOptions topColor(int i) {
        this.topColor = i;
        return this;
    }

    public final NavigateArrowOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final NavigateArrowOptions width(float f) {
        this.width = f;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.topColor);
        parcel.writeInt(this.sideColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f26126a);
        parcel.writeByte(this.is3DModel ? (byte) 1 : (byte) 0);
    }

    public final NavigateArrowOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public final NavigateArrowOptions add(LatLng... latLngArr) {
        this.points.addAll(Arrays.asList(latLngArr));
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final NavigateArrowOptions m160clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        navigateArrowOptions.points.addAll(this.points);
        navigateArrowOptions.width = this.width;
        navigateArrowOptions.topColor = this.topColor;
        navigateArrowOptions.sideColor = this.sideColor;
        navigateArrowOptions.zIndex = this.zIndex;
        navigateArrowOptions.isVisible = this.isVisible;
        navigateArrowOptions.is3DModel = this.is3DModel;
        navigateArrowOptions.f26126a = this.f26126a;
        navigateArrowOptions.arrowLineInnerResId = this.arrowLineInnerResId;
        navigateArrowOptions.arrowLineOuterResId = this.arrowLineOuterResId;
        navigateArrowOptions.arrowLineShadowResId = this.arrowLineShadowResId;
        return navigateArrowOptions;
    }
}
