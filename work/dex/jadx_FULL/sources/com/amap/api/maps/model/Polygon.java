package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Polygon extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolygonOptions options;

    public Polygon(IGlOverlayLayer iGlOverlayLayer, PolygonOptions polygonOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polygonOptions;
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

    public final boolean contains(LatLng latLng) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsPolygonContainsPoint(this.options, latLng);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Polygon)) {
            try {
                return super.equals(obj) || ((Polygon) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final int getFillColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getFillColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getHoleOptions();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final List<LatLng> getPoints() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getStrokeColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final float getStrokeWidth() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable unused) {
            return super.hashCode();
        }
    }

    public final boolean isVisible() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFillColor(int i) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        if (list == null) {
            try {
                list = new ArrayList<>();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.options.setHoleOptions(list);
        a();
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.options.setPoints(list);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            this.options.strokeWidth(f);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
