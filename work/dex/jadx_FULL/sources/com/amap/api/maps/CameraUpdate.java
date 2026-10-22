package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CameraUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AbstractCameraUpdateMessage f26106a;

    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.f26106a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.f26106a;
    }
}
