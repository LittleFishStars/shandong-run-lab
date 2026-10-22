package com.amap.api.maps.model;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Circle extends BaseOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WeakReference<IGlOverlayLayer> f26116a;
    private CircleOptions options;

    public Circle(IGlOverlayLayer iGlOverlayLayer, CircleOptions circleOptions, String str) {
        super(str);
        this.f26116a = new WeakReference<>(iGlOverlayLayer);
        this.options = circleOptions;
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.f26116a.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public final boolean contains(LatLng latLng) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.f26116a.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsCircleContainPoint(this.options, latLng);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Circle)) {
            try {
                return super.equals(obj) || ((Circle) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final LatLng getCenter() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getCenter();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getFillColor() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getFillColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getHoleOptions();
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

    public final double getRadius() {
        try {
            CircleOptions circleOptions = this.options;
            return circleOptions != null ? circleOptions.getRadius() : AudioStats.AUDIO_AMPLITUDE_NONE;
        } catch (Throwable th) {
            th.printStackTrace();
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public final int getStrokeColor() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getStrokeDottedLineType() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeDottedLineType();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public final float getStrokeWidth() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getZIndex();
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
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final boolean isVisible() {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.f26116a.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCenter(LatLng latLng) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.center(latLng);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFillColor(int i) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.fillColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        if (list != null) {
            try {
                synchronized (list) {
                    try {
                        this.options.getHoleOptions().clear();
                        this.options.addHoles(list);
                        a();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void setRadius(double d) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.radius(d);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.strokeColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeDottedLineType(int i) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.setStrokeDottedLineType(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.strokeWidth(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
