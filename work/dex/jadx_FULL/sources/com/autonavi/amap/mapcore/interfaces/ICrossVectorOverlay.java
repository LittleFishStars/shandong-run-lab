package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z);

    void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener);

    void setVisible(boolean z);
}
