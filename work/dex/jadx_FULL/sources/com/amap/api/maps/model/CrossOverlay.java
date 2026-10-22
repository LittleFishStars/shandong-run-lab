package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ICrossVectorOverlay f26118a;

    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i);
    }

    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i, UpdateItem updateItem);
    }

    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, ICrossVectorOverlay iCrossVectorOverlay) {
        this.f26118a = iCrossVectorOverlay;
    }

    public void remove() {
        ICrossVectorOverlay iCrossVectorOverlay = this.f26118a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.f26118a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.f26118a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f26118a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f26118a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f26118a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f26118a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
