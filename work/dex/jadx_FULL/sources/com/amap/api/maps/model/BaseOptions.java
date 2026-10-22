package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    @JBindingInclude
    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate = false;

        public void reset() {
            this.zIndexUpdate = false;
        }
    }

    public BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    public Object method1(Object... objArr) {
        return null;
    }

    public Object method2(Object... objArr) {
        return null;
    }

    @JBindingExclude
    public void resetUpdateFlags() {
    }
}
