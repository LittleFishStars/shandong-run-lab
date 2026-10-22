package androidx.camera.core;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ZoomState {
    float getLinearZoom();

    float getMaxZoomRatio();

    float getMinZoomRatio();

    float getZoomRatio();
}
