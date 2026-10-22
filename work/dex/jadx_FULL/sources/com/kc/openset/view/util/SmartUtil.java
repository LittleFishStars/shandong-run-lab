package com.kc.openset.view.util;

import android.content.res.Resources;
import android.view.animation.Interpolator;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class SmartUtil implements Interpolator {
    public static int INTERPOLATOR_DECELERATE = 1;
    private static final float VISCOUS_FLUID_NORMALIZE;
    private static final float VISCOUS_FLUID_OFFSET;
    private static final float VISCOUS_FLUID_SCALE = 8.0f;
    private static float density;
    private int type;

    static {
        OSETSDKProtected.interface11(5084);
        density = Resources.getSystem().getDisplayMetrics().density;
        float fViscousFluid = 1.0f / viscousFluid(1.0f);
        VISCOUS_FLUID_NORMALIZE = fViscousFluid;
        VISCOUS_FLUID_OFFSET = 1.0f - (fViscousFluid * viscousFluid(1.0f));
    }

    public SmartUtil(int i) {
        this.type = i;
    }

    public static int dp2px(float f) {
        return (int) ((f * density) + 0.5f);
    }

    public static float px2dp(int i) {
        return i / density;
    }

    private static float viscousFluid(float f) {
        float f2 = f * 8.0f;
        return f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (this.type == INTERPOLATOR_DECELERATE) {
            float f2 = 1.0f - f;
            return 1.0f - (f2 * f2);
        }
        float fViscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f);
        return fViscousFluid > 0.0f ? fViscousFluid + VISCOUS_FLUID_OFFSET : fViscousFluid;
    }
}
