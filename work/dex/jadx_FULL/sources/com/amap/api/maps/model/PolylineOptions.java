package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public final class PolylineOptions extends BaseOptions implements Parcelable {

    @JBindingExclude
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    @JBindingExclude
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;

    @JBindingExclude
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f26128a;

    @JBindingExclude
    private List<Integer> colorValues;

    @JBindingExclude
    private List<Integer> customIndexs;
    private BitmapDescriptor customTexture;
    private List<BitmapDescriptor> customTextureList;
    private BitmapDescriptor eraseTexture;
    private BitmapDescriptor footPrintTexture;
    private int[] jniColorValues;
    private int[] jniCustomIndexes;
    private float width = 10.0f;
    private int color = -16777216;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isUseTexture = true;
    private boolean isGeodesic = false;
    private boolean isDottedLine = false;
    private boolean isGradient = false;
    private float transparency = 1.0f;
    private boolean isAboveMaskLayer = false;
    private int dottedLineType = 0;

    @JBindingExclude
    private LineCapType lineCapType = LineCapType.LineCapRound;

    @JBindingExclude
    private LineJoinType lineJoinType = LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private float shownRatio = -1.0f;
    private float shownRangeBegin = -1.0f;
    private float shownRangeEnd = -1.0f;
    private float footPrintGap = 100.0f;
    private boolean eraseVisible = false;
    private int eraseColor = -7829368;
    private float shownPolylineRangeBegin = 0.0f;
    private float shownPolylineRangeEnd = 0.0f;
    private boolean showPolylineRangeEnable = false;
    private PolylineUpdateFlags updateFlags = new PolylineUpdateFlags();
    private final List<LatLng> points = new ArrayList();

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i) {
            this.type = i;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i) {
            LineCapType[] lineCapTypeArrValues = values();
            return lineCapTypeArrValues[Math.max(0, Math.min(i, lineCapTypeArrValues.length))];
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i) {
            this.type = i;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i) {
            LineJoinType[] lineJoinTypeArrValues = values();
            return lineJoinTypeArrValues[Math.max(0, Math.min(i, lineJoinTypeArrValues.length))];
        }
    }

    @JBindingInclude
    public static class PolylineUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isCustomIndexesUpdated = false;
        protected boolean isCustomTextureListUpdated = false;
        protected boolean isColorValuesUpdated = false;
        protected boolean footPrintBDUpdate = false;
        protected boolean eraseUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }
    }

    public PolylineOptions() {
        this.type = "PolylineOptions";
    }

    public final PolylineOptions aboveMaskLayer(boolean z) {
        this.isAboveMaskLayer = z;
        return this;
    }

    public final PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            try {
                this.points.add(latLng);
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final PolylineOptions colorValues(List<Integer> list) {
        try {
            this.colorValues = list;
            this.jniColorValues = new int[list.size()];
            int i = 0;
            while (true) {
                int[] iArr = this.jniColorValues;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = list.get(i).intValue();
                i++;
            }
            this.updateFlags.isColorValuesUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.isGeodesic = z;
        return this;
    }

    public final int getColor() {
        return this.color;
    }

    public final List<Integer> getColorValues() {
        return this.colorValues;
    }

    public final BitmapDescriptor getCustomTexture() {
        return this.customTexture;
    }

    public final List<Integer> getCustomTextureIndex() {
        return this.customIndexs;
    }

    public final List<BitmapDescriptor> getCustomTextureList() {
        return this.customTextureList;
    }

    public final int getDottedLineType() {
        return this.dottedLineType;
    }

    public final int getEraseColor() {
        return this.eraseColor;
    }

    public final BitmapDescriptor getEraseTexture() {
        return this.eraseTexture;
    }

    public final boolean getEraseVisible() {
        return this.eraseVisible;
    }

    public final float getFootPrintGap() {
        return this.footPrintGap;
    }

    public final BitmapDescriptor getFootPrintTexture() {
        return this.footPrintTexture;
    }

    public final LineCapType getLineCapType() {
        return this.lineCapType;
    }

    public final LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getPolylineShownRangeBegin() {
        return this.shownPolylineRangeBegin;
    }

    public final float getPolylineShownRangeEnd() {
        return this.shownPolylineRangeEnd;
    }

    public final float getShownRangeBegin() {
        return this.shownRangeBegin;
    }

    public final float getShownRangeEnd() {
        return this.shownRangeEnd;
    }

    public final float getShownRatio() {
        return this.shownRatio;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isAboveMaskLayer() {
        return this.isAboveMaskLayer;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }

    public final boolean isShowPolylineRangeEnable() {
        return this.showPolylineRangeEnable;
    }

    public final boolean isUseGradient() {
        return this.isGradient;
    }

    public final boolean isUseTexture() {
        return this.isUseTexture;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolylineOptions lineCapType(LineCapType lineCapType) {
        if (lineCapType != null) {
            this.lineCapType = lineCapType;
            this.nLineCapType = lineCapType.getTypeValue();
        }
        return this;
    }

    public final PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.lineJoinType = lineJoinType;
            this.nLineJoinType = lineJoinType.getTypeValue();
        }
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.customTexture = bitmapDescriptor;
        return this;
    }

    public final PolylineOptions setCustomTextureIndex(List<Integer> list) {
        try {
            this.customIndexs = list;
            this.jniCustomIndexes = new int[list.size()];
            int i = 0;
            while (true) {
                int[] iArr = this.jniCustomIndexes;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = list.get(i).intValue();
                i++;
            }
            PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
            polylineUpdateFlags.isCustomIndexesUpdated = true;
            polylineUpdateFlags.isCustomTextureListUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    public final PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.customTextureList = list;
        PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
        polylineUpdateFlags.isCustomTextureListUpdated = true;
        polylineUpdateFlags.isCustomIndexesUpdated = true;
        return this;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.isDottedLine = z;
        return this;
    }

    public final PolylineOptions setDottedLineType(int i) {
        this.dottedLineType = i == 0 ? 0 : 1;
        return this;
    }

    public final PolylineOptions setEraseColor(boolean z, int i) {
        this.eraseVisible = z;
        this.eraseColor = i;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final PolylineOptions setEraseTexture(boolean z, BitmapDescriptor bitmapDescriptor) {
        this.eraseVisible = z;
        this.eraseTexture = bitmapDescriptor;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final PolylineOptions setFootPrintGap(float f) {
        this.footPrintGap = f;
        return this;
    }

    public final PolylineOptions setFootPrintTexture(BitmapDescriptor bitmapDescriptor) {
        this.footPrintTexture = bitmapDescriptor;
        this.updateFlags.footPrintBDUpdate = true;
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
            this.updateFlags.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final PolylineOptions setPolylineShowRange(float f, float f2) {
        this.shownPolylineRangeBegin = f;
        this.shownPolylineRangeEnd = f2;
        return this;
    }

    public final PolylineOptions setShownRange(float f, float f2) {
        this.shownRangeBegin = f;
        this.shownRangeEnd = f2;
        showPolylineRangeEnabled(true);
        setPolylineShowRange(f, f2);
        return this;
    }

    public final PolylineOptions setShownRatio(float f) {
        this.shownRatio = f;
        setPolylineShowRange(0.0f, f);
        showPolylineRangeEnabled(true);
        return this;
    }

    public final PolylineOptions setUseTexture(boolean z) {
        this.isUseTexture = z;
        return this;
    }

    public final PolylineOptions showPolylineRangeEnabled(boolean z) {
        this.showPolylineRangeEnable = z;
        return this;
    }

    public final PolylineOptions transparency(float f) {
        this.transparency = f;
        return this;
    }

    public final PolylineOptions useGradient(boolean z) {
        this.isGradient = z;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final PolylineOptions width(float f) {
        this.width = f;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.color);
        parcel.writeInt(this.dottedLineType);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.transparency);
        parcel.writeString(this.f26128a);
        parcel.writeInt(this.lineCapType.getTypeValue());
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        BitmapDescriptor bitmapDescriptor = this.customTexture;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i);
        }
        List<BitmapDescriptor> list = this.customTextureList;
        if (list != null) {
            parcel.writeList(list);
        }
        List<Integer> list2 = this.customIndexs;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        List<Integer> list3 = this.colorValues;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.shownRatio);
    }

    public final PolylineOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final PolylineUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
