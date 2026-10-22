package com.fl.saas.adx.base.innterNative;

import android.graphics.Bitmap;
import com.fl.saas.adx.api.mixNative.NativeAdAppInfo;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.base.bean.Size;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class NativeExpressMaterial implements NativeMaterial {
    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public NativeAdAppInfo getAdAppInfo() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final Bitmap getAdLogo() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final Bitmap getAdLogoBitmap() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final String getAdLogoUrl() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final String getCallToAction() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final String getIconUrl() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final List<String> getImageUrlList() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final String getMainImageUrl() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public Size getSize() {
        return new Size(0, 0);
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public final String getVideoUrl() {
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
    public boolean isNativeAppAd() {
        return false;
    }
}
