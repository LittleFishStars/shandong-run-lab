package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class HeatMapLayerOptions extends BaseOptions {

    @JBindingExclude
    public static final Gradient DEFAULT_GRADIENT;

    @JBindingExclude
    private static final int[] DEFAULT_GRADIENT_COLORS;

    @JBindingExclude
    private static final float[] DEFAULT_GRADIENT_START_POINTS;

    @JBindingExclude
    public static final double DEFAULT_OPACITY = 0.6d;

    @JBindingExclude
    public static final int DEFAULT_RADIUS = 12;

    @JBindingExclude
    public static final int TYPE_GRID = 1;

    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;

    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private int[] mColors;

    @JBindingExclude
    private Collection<WeightedLatLng> mData;
    private double mLatitude;
    private float[] mStartPoints;
    private double[] pointList;

    @JBindingExclude
    private Gradient mGradient = DEFAULT_GRADIENT;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private double maxIntensity = AudioStats.AUDIO_AMPLITUDE_NONE;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float mGap = 0.0f;
    private int mType = 2;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    private static Collection<WeightedLatLng> a(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public HeatMapLayerOptions data(Collection<LatLng> collection) {
        return weightedData(a(collection));
    }

    public HeatMapLayerOptions gap(float f) {
        this.mGap = f;
        return this;
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public HeatMapLayerOptions gradient(Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions maxIntensity(double d) {
        this.maxIntensity = d;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float f) {
        this.maxZoom = f;
        return this;
    }

    public HeatMapLayerOptions minZoom(float f) {
        this.minZoom = f;
        return this;
    }

    public HeatMapLayerOptions opacity(float f) {
        this.mOpacity = Math.max(0.0f, Math.min(f, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float f) {
        this.mSize = f;
        return this;
    }

    public HeatMapLayerOptions type(int i) {
        this.mType = i;
        return this;
    }

    public HeatMapLayerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public HeatMapLayerOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    private void a() {
        Collection<WeightedLatLng> data;
        LatLng latLng;
        if (!this.isPointsUpdated || (data = getData()) == null) {
            return;
        }
        this.pointList = new double[data.size() * 3];
        double d = Double.NaN;
        int i = 0;
        double d2 = Double.NaN;
        for (WeightedLatLng weightedLatLng : data) {
            if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                double[] dArr = this.pointList;
                int i2 = i * 3;
                double d3 = latLng.latitude;
                dArr[i2] = d3;
                dArr[i2 + 1] = latLng.longitude;
                dArr[i2 + 2] = weightedLatLng.intensity;
                i++;
                if (Double.isNaN(d)) {
                    d = d3;
                }
                if (Double.isNaN(d2)) {
                    d2 = d3;
                }
                if (d3 > d2) {
                    d2 = d3;
                }
                if (d3 < d) {
                    d = d3;
                }
            } else {
                Log.e("mapcore", "read file failed");
            }
        }
        this.mLatitude = (Double.isNaN(d) || Double.isNaN(d2)) ? AudioStats.AUDIO_AMPLITUDE_NONE : (d + d2) / 2.0d;
    }
}
