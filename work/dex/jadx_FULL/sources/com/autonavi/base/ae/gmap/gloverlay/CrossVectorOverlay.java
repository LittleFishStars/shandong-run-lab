package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.TypedValue;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class CrossVectorOverlay extends BaseMapOverlay<GLCrossVector, Object> implements ICrossVectorOverlay {
    AVectorCrossAttr attr;
    private CrossOverlay.GenerateCrossImageListener imageListener;
    private boolean isImageMode;
    private CrossOverlay.OnCrossVectorUpdateListener updateListener;

    public CrossVectorOverlay(int i, Context context, IAMap iAMap) {
        super(i, context, iAMap);
        this.isImageMode = false;
        this.attr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawVectorFailed(int i) {
        CrossOverlay.GenerateCrossImageListener generateCrossImageListener;
        if (this.isImageMode && (generateCrossImageListener = this.imageListener) != null) {
            generateCrossImageListener.onGenerateComplete(null, i);
        }
        if (this.updateListener != null) {
            CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
            updateItem.dataUpdateFlag = i;
            this.updateListener.onUpdate(0, updateItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImageMode(boolean z) {
        T t = this.mGLOverlay;
        if (t != 0) {
            ((GLCrossVector) t).initTextureCallback(this, z);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void addItem(Object obj) {
    }

    public void addOverlayTexture(Bitmap bitmap, int i, int i2) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i;
        gLTextureProperty.mAnchor = i2;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        this.mMapView.addOverlayTexture(this.mEngineID, gLTextureProperty);
    }

    public int createOverlayTexture(Bitmap bitmap) {
        return this.mMapView.createOverlayTexture(this.mEngineID, bitmap);
    }

    public int dipToPixel(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            return i;
        }
    }

    @JBindingInclude
    public void imageContentResult(int[] iArr, int i, int i2) {
        if (iArr == null) {
            drawVectorFailed(-1);
        } else if (this.imageListener != null) {
            Bitmap bitmapO = zwa.o(iArr, i, i2);
            this.imageListener.onGenerateComplete(bitmapO, bitmapO != null ? 0 : -1);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void iniGLOverlay() {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.1
                @Override // java.lang.Runnable
                public void run() {
                    CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                    crossVectorOverlay.mGLOverlay = new GLCrossVector(crossVectorOverlay.mEngineID, crossVectorOverlay.mMapView, hashCode());
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void remove() {
        this.imageListener = null;
        setVisible(false);
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.5
                @Override // java.lang.Runnable
                public void run() {
                    CrossVectorOverlay.this.releaseInstance();
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void resumeMarker(final Bitmap bitmap) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.2
                @Override // java.lang.Runnable
                public void run() {
                    int iCreateOverlayTexture = CrossVectorOverlay.this.createOverlayTexture(bitmap);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setArrowResId(false, iCreateOverlayTexture);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setCarResId(iCreateOverlayTexture);
                    BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
                    int iCreateOverlayTexture2 = CrossVectorOverlay.this.createOverlayTexture(bitmapDescriptorFromAsset != null ? bitmapDescriptorFromAsset.getBitmap() : null);
                    if (iCreateOverlayTexture2 != -1) {
                        ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setBackgroundResId(iCreateOverlayTexture2);
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.attr = aVectorCrossAttr;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public int setData(final byte[] bArr) {
        IAMapDelegate iAMapDelegate;
        if (this.attr == null) {
            AVectorCrossAttr aVectorCrossAttr = new AVectorCrossAttr();
            this.attr = aVectorCrossAttr;
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, this.mMapView.getMapWidth(), (this.mMapView.getMapHeight() * 4) / 11);
            this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
            this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
            this.attr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
            this.attr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            this.attr.dayMode = false;
        }
        if (bArr == null || this.attr == null || (iAMapDelegate = this.mMapView) == null) {
            return -1;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.4
            @Override // java.lang.Runnable
            public void run() {
                CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                crossVectorOverlay.initImageMode(crossVectorOverlay.isImageMode);
                CrossVectorOverlay crossVectorOverlay2 = CrossVectorOverlay.this;
                GLCrossVector gLCrossVector = (GLCrossVector) crossVectorOverlay2.mGLOverlay;
                AVectorCrossAttr aVectorCrossAttr2 = crossVectorOverlay2.attr;
                byte[] bArr2 = bArr;
                int iAddVectorItem = gLCrossVector.addVectorItem(aVectorCrossAttr2, bArr2, bArr2.length);
                if (iAddVectorItem != 0) {
                    CrossVectorOverlay.this.drawVectorFailed(iAddVectorItem);
                } else if (CrossVectorOverlay.this.updateListener != null) {
                    CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
                    updateItem.dataUpdateFlag = iAddVectorItem;
                    CrossVectorOverlay.this.updateListener.onUpdate(0, updateItem);
                }
            }
        });
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.imageListener = generateCrossImageListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setImageMode(boolean z) {
        this.isImageMode = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        this.updateListener = onCrossVectorUpdateListener;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay, com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setVisible(final boolean z) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.3
                @Override // java.lang.Runnable
                public void run() {
                    T t = CrossVectorOverlay.this.mGLOverlay;
                    if (t != 0) {
                        ((GLCrossVector) t).setVisible(z);
                    }
                }
            });
        }
    }
}
