package com.huachenjie.common.util.media_picker;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.a, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/common/util/media_picker/a;", "", "", "a", "", "b", "c", "enabled", "aspectRatioX", "aspectRatioY", "d", "", "toString", "", "hashCode", "other", "equals", "Z", t.d, "()Z", "F", "j", "()F", "k", "<init>", "(ZFF)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ImageCropConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public final float aspectRatioX;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public final boolean enabled;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final float aspectRatioY;

    /* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/util/media_picker/a$a;", "", "Lcom/huachenjie/common/util/media_picker/a;", "a", "", "aspectRatioX", "aspectRatioY", "d", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImageCropConfig e(Companion companion, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 1.0f;
            }
            if ((i & 2) != 0) {
                f2 = 1.0f;
            }
            return companion.d(f, f2);
        }

        @JvmStatic
        @NotNull
        public final ImageCropConfig a() {
            return new ImageCropConfig(false, 0.0f, 0.0f, 7, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ImageCropConfig b() {
            return e(this, 0.0f, 0.0f, 3, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ImageCropConfig c(float f) {
            return e(this, f, 0.0f, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ImageCropConfig d(float aspectRatioX, float aspectRatioY) {
            return new ImageCropConfig(true, aspectRatioX, aspectRatioY);
        }
    }

    public ImageCropConfig() {
        this(false, 0.0f, 0.0f, 7, null);
    }

    public ImageCropConfig(boolean z, float f, float f2) {
        this.enabled = z;
        this.aspectRatioX = f;
        this.aspectRatioY = f2;
    }

    public static /* synthetic */ ImageCropConfig e(ImageCropConfig imageCropConfig, boolean z, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = imageCropConfig.enabled;
        }
        if ((i & 2) != 0) {
            f = imageCropConfig.aspectRatioX;
        }
        if ((i & 4) != 0) {
            f2 = imageCropConfig.aspectRatioY;
        }
        return imageCropConfig.d(z, f, f2);
    }

    @JvmStatic
    @NotNull
    public static final ImageCropConfig f() {
        return INSTANCE.a();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ImageCropConfig g() {
        return INSTANCE.b();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ImageCropConfig h(float f) {
        return INSTANCE.c(f);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ImageCropConfig i(float f, float f2) {
        return INSTANCE.d(f, f2);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getAspectRatioX() {
        return this.aspectRatioX;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getAspectRatioY() {
        return this.aspectRatioY;
    }

    @NotNull
    public final ImageCropConfig d(boolean enabled, float aspectRatioX, float aspectRatioY) {
        return new ImageCropConfig(enabled, aspectRatioX, aspectRatioY);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageCropConfig)) {
            return false;
        }
        ImageCropConfig imageCropConfig = (ImageCropConfig) other;
        return this.enabled == imageCropConfig.enabled && Float.compare(this.aspectRatioX, imageCropConfig.aspectRatioX) == 0 && Float.compare(this.aspectRatioY, imageCropConfig.aspectRatioY) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Float.hashCode(this.aspectRatioX)) * 31) + Float.hashCode(this.aspectRatioY);
    }

    public final float j() {
        return this.aspectRatioX;
    }

    public final float k() {
        return this.aspectRatioY;
    }

    public final boolean l() {
        return this.enabled;
    }

    @NotNull
    public String toString() {
        return "ImageCropConfig(enabled=" + this.enabled + ", aspectRatioX=" + this.aspectRatioX + ", aspectRatioY=" + this.aspectRatioY + ")";
    }

    public /* synthetic */ ImageCropConfig(boolean z, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? 1.0f : f2);
    }
}
