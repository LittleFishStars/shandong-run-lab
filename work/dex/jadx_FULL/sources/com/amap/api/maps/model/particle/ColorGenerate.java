package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public abstract class ColorGenerate {

    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @JBindingExclude
    protected final int TYPE_RANDOMCOLORBETWEENTWOCONSTANTS = 0;
    protected int type = -1;

    public abstract float[] getColor();
}
