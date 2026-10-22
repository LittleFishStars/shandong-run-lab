package com.zj.adlib;

import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/zj/adlib/tl6;", "", "Landroidx/palette/graphics/Palette;", "palette", "", "b", "a", "c", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class tl6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final tl6 f44947a = new tl6();

    public final int a(@Nullable Palette palette) {
        if (palette == null) {
            return -16777216;
        }
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        if (vibrantSwatch != null) {
            return vibrantSwatch.getBodyTextColor();
        }
        Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
        if (lightVibrantSwatch != null) {
            return lightVibrantSwatch.getBodyTextColor();
        }
        Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
        if (darkVibrantSwatch != null) {
            return darkVibrantSwatch.getBodyTextColor();
        }
        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
        if (mutedSwatch != null) {
            return mutedSwatch.getBodyTextColor();
        }
        Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
        if (lightMutedSwatch != null) {
            return lightMutedSwatch.getBodyTextColor();
        }
        Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
        if (darkMutedSwatch != null) {
            return darkMutedSwatch.getBodyTextColor();
        }
        Palette.Swatch dominantSwatch = palette.getDominantSwatch();
        if (dominantSwatch != null) {
            return dominantSwatch.getBodyTextColor();
        }
        return -16777216;
    }

    public final int b(@Nullable Palette palette) {
        if (palette == null) {
            return 0;
        }
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        if (vibrantSwatch != null) {
            return vibrantSwatch.getRgb();
        }
        Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
        if (lightVibrantSwatch != null) {
            return lightVibrantSwatch.getRgb();
        }
        Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
        if (darkVibrantSwatch != null) {
            return darkVibrantSwatch.getRgb();
        }
        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
        if (mutedSwatch != null) {
            return mutedSwatch.getRgb();
        }
        Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
        if (lightMutedSwatch != null) {
            return lightMutedSwatch.getRgb();
        }
        Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
        if (darkMutedSwatch != null) {
            return darkMutedSwatch.getRgb();
        }
        Palette.Swatch dominantSwatch = palette.getDominantSwatch();
        if (dominantSwatch != null) {
            return dominantSwatch.getRgb();
        }
        return 0;
    }

    public final int c(@Nullable Palette palette) {
        if (palette == null) {
            return -16777216;
        }
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        if (vibrantSwatch != null) {
            return vibrantSwatch.getTitleTextColor();
        }
        Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
        if (lightVibrantSwatch != null) {
            return lightVibrantSwatch.getTitleTextColor();
        }
        Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
        if (darkVibrantSwatch != null) {
            return darkVibrantSwatch.getTitleTextColor();
        }
        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
        if (mutedSwatch != null) {
            return mutedSwatch.getTitleTextColor();
        }
        Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
        if (lightMutedSwatch != null) {
            return lightMutedSwatch.getTitleTextColor();
        }
        Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
        if (darkMutedSwatch != null) {
            return darkMutedSwatch.getTitleTextColor();
        }
        Palette.Swatch dominantSwatch = palette.getDominantSwatch();
        if (dominantSwatch != null) {
            return dominantSwatch.getTitleTextColor();
        }
        return -16777216;
    }
}
