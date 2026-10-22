package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    public static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f, float f2, @NonNull Arrangement arrangement) {
        float extraSmallSize = getExtraSmallSize(context) + f;
        float f3 = extraSmallSize / 2.0f;
        float f4 = 0.0f - f3;
        float f5 = (arrangement.largeSize / 2.0f) + 0.0f;
        float fMax = Math.max(0, arrangement.largeCount - 1);
        float f6 = arrangement.largeSize;
        float f7 = (fMax * f6) + f5;
        float f8 = (f6 / 2.0f) + f7;
        int i = arrangement.mediumCount;
        if (i > 0) {
            f7 = (arrangement.mediumSize / 2.0f) + f8;
        }
        if (i > 0) {
            f8 = (arrangement.mediumSize / 2.0f) + f7;
        }
        float f9 = arrangement.smallCount > 0 ? f8 + (arrangement.smallSize / 2.0f) : f7;
        float f10 = f2 + f3;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(extraSmallSize, f6, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(arrangement.largeSize).addKeyline(f4, childMaskPercentage, extraSmallSize).addKeylineRange(f5, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builderAddKeylineRange.addKeyline(f7, childMaskPercentage3, arrangement.mediumSize);
        }
        int i2 = arrangement.smallCount;
        if (i2 > 0) {
            builderAddKeylineRange.addKeylineRange(f9, childMaskPercentage2, arrangement.smallSize, i2);
        }
        builderAddKeylineRange.addKeyline(f10, childMaskPercentage, extraSmallSize);
        return builderAddKeylineRange.build();
    }

    public static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    public static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    public static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    public static int maxValue(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }
}
