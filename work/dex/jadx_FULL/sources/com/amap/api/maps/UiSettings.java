package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public final float getLogoMarginRate(int i) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isLogoEnable() {
        try {
            return this.uiSettingsDelegate.isLogoEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final void setAllGesturesEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGestureScaleByMapCenter(boolean z) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorSwitchEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoCenter(int i, int i2) {
    }

    public final void setLogoEnable(boolean z) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i, float f) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i, f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateGesturesEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTiltGesturesEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
