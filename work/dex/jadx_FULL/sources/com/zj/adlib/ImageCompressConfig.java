package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.u64, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/u64;", "", "", "j", "", "a", "b", "", "c", "maxWidth", "maxSizeKb", "allowGif", "d", "toString", "hashCode", "other", "equals", "I", y6b.g, "()I", y6b.f, "Z", "f", "()Z", "i", "shouldCompress", "<init>", "(IIZ)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ImageCompressConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxWidth;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public final boolean allowGif;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final int maxSizeKb;

    public ImageCompressConfig() {
        this(0, 0, false, 7, null);
    }

    public ImageCompressConfig(int i, int i2, boolean z) {
        this.maxWidth = i;
        this.maxSizeKb = i2;
        this.allowGif = z;
    }

    public static /* synthetic */ ImageCompressConfig e(ImageCompressConfig imageCompressConfig, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageCompressConfig.maxWidth;
        }
        if ((i3 & 2) != 0) {
            i2 = imageCompressConfig.maxSizeKb;
        }
        if ((i3 & 4) != 0) {
            z = imageCompressConfig.allowGif;
        }
        return imageCompressConfig.d(i, i2, z);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getMaxSizeKb() {
        return this.maxSizeKb;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getAllowGif() {
        return this.allowGif;
    }

    @NotNull
    public final ImageCompressConfig d(int maxWidth, int maxSizeKb, boolean allowGif) {
        return new ImageCompressConfig(maxWidth, maxSizeKb, allowGif);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageCompressConfig)) {
            return false;
        }
        ImageCompressConfig imageCompressConfig = (ImageCompressConfig) other;
        return this.maxWidth == imageCompressConfig.maxWidth && this.maxSizeKb == imageCompressConfig.maxSizeKb && this.allowGif == imageCompressConfig.allowGif;
    }

    public final boolean f() {
        return this.allowGif;
    }

    public final int g() {
        return this.maxSizeKb;
    }

    public final int h() {
        return this.maxWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.maxWidth) * 31) + Integer.hashCode(this.maxSizeKb)) * 31;
        boolean z = this.allowGif;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean i() {
        return this.maxWidth > 0 || this.maxSizeKb > 0;
    }

    @Nullable
    public final String j() {
        if (this.maxWidth < 0) {
            return "imageMaxWidth must be >= 0";
        }
        if (this.maxSizeKb < 0) {
            return "imageMaxSize must be >= 0";
        }
        return null;
    }

    @NotNull
    public String toString() {
        return "ImageCompressConfig(maxWidth=" + this.maxWidth + ", maxSizeKb=" + this.maxSizeKb + ", allowGif=" + this.allowGif + ")";
    }

    public /* synthetic */ ImageCompressConfig(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }
}
