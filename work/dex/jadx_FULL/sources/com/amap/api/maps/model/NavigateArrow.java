package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private NavigateArrowOptions options;

    public NavigateArrow(IGlOverlayLayer iGlOverlayLayer, NavigateArrowOptions navigateArrowOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavigateArrow)) {
            try {
                return super.equals(obj) || ((NavigateArrow) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public int getSideColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getSideColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getTopColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean is3DModel() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.is3DModel();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void set3DModel(boolean z) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.set3DModel(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.setPoints(list);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.sideColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.topColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.width(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
