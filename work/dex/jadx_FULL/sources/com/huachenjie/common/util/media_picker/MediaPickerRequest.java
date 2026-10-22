package com.huachenjie.common.util.media_picker;

import com.zj.adlib.ImageCompressConfig;
import com.zj.adlib.VideoPickConfig;
import com.zj.adlib.fq6;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.b, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B3\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/huachenjie/common/util/media_picker/b;", "", "", "E", "Lcom/huachenjie/common/util/media_picker/PickType;", "a", "", "b", "Lcom/zj/adlib/u64;", "c", "Lcom/huachenjie/common/util/media_picker/a;", "d", "Lcom/zj/adlib/xn9;", "e", "type", "maxCount", "compressConfig", "cropConfig", "videoConfig", "f", "toString", "hashCode", "other", "", "equals", "Lcom/huachenjie/common/util/media_picker/PickType;", "getType", "()Lcom/huachenjie/common/util/media_picker/PickType;", "I", "j", "()I", "Lcom/zj/adlib/u64;", y6b.g, "()Lcom/zj/adlib/u64;", "Lcom/huachenjie/common/util/media_picker/a;", "i", "()Lcom/huachenjie/common/util/media_picker/a;", "Lcom/zj/adlib/xn9;", "k", "()Lcom/zj/adlib/xn9;", "p", "()Z", "isMultiple", "<init>", "(Lcom/huachenjie/common/util/media_picker/PickType;ILcom/zj/adlib/u64;Lcom/huachenjie/common/util/media_picker/a;Lcom/zj/adlib/xn9;)V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMediaPickerContract.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaPickerContract.kt\ncom/huachenjie/common/util/media_picker/MediaPickerRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
public final /* data */ class MediaPickerRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public final int maxCount;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final PickType type;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final ImageCropConfig cropConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final ImageCompressConfig compressConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final VideoPickConfig videoConfig;

    /* JADX INFO: renamed from: com.huachenjie.common.util.media_picker.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0007J.\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0007J8\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/common/util/media_picker/b$a;", "", "", "imageMaxWidth", "imageMaxSize", "", "needCrop", "", "aspectRatioX", "aspectRatioY", "allowGif", "Lcom/huachenjie/common/util/media_picker/b;", "r", "maxDurationSeconds", "u", "max", "d", "w", "maxVideoDurationSeconds", "j", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MediaPickerRequest e(Companion companion, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            if ((i4 & 8) != 0) {
                z = false;
            }
            return companion.d(i, i2, i3, z);
        }

        public static /* synthetic */ MediaPickerRequest k(Companion companion, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
            return companion.j(i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? false : z);
        }

        public static /* synthetic */ MediaPickerRequest s(Companion companion, int i, int i2, boolean z, float f, float f2, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            if ((i3 & 8) != 0) {
                f = 1.0f;
            }
            if ((i3 & 16) != 0) {
                f2 = 1.0f;
            }
            if ((i3 & 32) != 0) {
                z2 = false;
            }
            return companion.r(i, i2, z, f, f2, z2);
        }

        public static /* synthetic */ MediaPickerRequest v(Companion companion, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return companion.u(i);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest a(int i) {
            return e(this, i, 0, 0, false, 14, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest b(int i, int i2) {
            return e(this, i, i2, 0, false, 12, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest c(int i, int i2, int i3) {
            return e(this, i, i2, i3, false, 8, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest d(int max, int imageMaxWidth, int imageMaxSize, boolean allowGif) {
            return new MediaPickerRequest(PickType.IMAGE, max, new ImageCompressConfig(imageMaxWidth, imageMaxSize, allowGif), new ImageCropConfig(false, 0.0f, 0.0f, 7, null), null, 16, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest f(int i) {
            return k(this, i, 0, 0, 0, false, 30, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest g(int i, int i2) {
            return k(this, i, i2, 0, 0, false, 28, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest h(int i, int i2, int i3) {
            return k(this, i, i2, i3, 0, false, 24, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest i(int i, int i2, int i3, int i4) {
            return k(this, i, i2, i3, i4, false, 16, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest j(int max, int imageMaxWidth, int imageMaxSize, int maxVideoDurationSeconds, boolean allowGif) {
            return new MediaPickerRequest(PickType.IMAGE_AND_VIDEO, max, new ImageCompressConfig(imageMaxWidth, imageMaxSize, allowGif), new ImageCropConfig(false, 0.0f, 0.0f, 7, null), new VideoPickConfig(maxVideoDurationSeconds), null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest l() {
            return s(this, 0, 0, false, 0.0f, 0.0f, false, 63, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest m(int i) {
            return s(this, i, 0, false, 0.0f, 0.0f, false, 62, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest n(int i, int i2) {
            return s(this, i, i2, false, 0.0f, 0.0f, false, 60, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest o(int i, int i2, boolean z) {
            return s(this, i, i2, z, 0.0f, 0.0f, false, 56, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest p(int i, int i2, boolean z, float f) {
            return s(this, i, i2, z, f, 0.0f, false, 48, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest q(int i, int i2, boolean z, float f, float f2) {
            return s(this, i, i2, z, f, f2, false, 32, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest r(int imageMaxWidth, int imageMaxSize, boolean needCrop, float aspectRatioX, float aspectRatioY, boolean allowGif) {
            return new MediaPickerRequest(PickType.IMAGE, 1, new ImageCompressConfig(imageMaxWidth, imageMaxSize, allowGif), needCrop ? ImageCropConfig.INSTANCE.d(aspectRatioX, aspectRatioY) : new ImageCropConfig(false, 0.0f, 0.0f, 7, null), null, 16, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest t() {
            return v(this, 0, 1, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MediaPickerRequest u(int maxDurationSeconds) {
            return new MediaPickerRequest(PickType.VIDEO, 1, new ImageCompressConfig(0, 0, false, 7, null), new ImageCropConfig(false, 0.0f, 0.0f, 7, null), new VideoPickConfig(maxDurationSeconds), null);
        }

        @JvmStatic
        @NotNull
        public final MediaPickerRequest w(int max) {
            return new MediaPickerRequest(PickType.VIDEO, max, new ImageCompressConfig(0, 0, false, 7, null), new ImageCropConfig(false, 0.0f, 0.0f, 7, null), null, 16, null);
        }
    }

    public MediaPickerRequest(PickType pickType, int i, ImageCompressConfig imageCompressConfig, ImageCropConfig imageCropConfig, VideoPickConfig videoPickConfig) {
        this.type = pickType;
        this.maxCount = i;
        this.compressConfig = imageCompressConfig;
        this.cropConfig = imageCropConfig;
        this.videoConfig = videoPickConfig;
    }

    public /* synthetic */ MediaPickerRequest(PickType pickType, int i, ImageCompressConfig imageCompressConfig, ImageCropConfig imageCropConfig, VideoPickConfig videoPickConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pickType, i, imageCompressConfig, imageCropConfig, videoPickConfig);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest A(int i, int i2, boolean z, float f, float f2) {
        return INSTANCE.q(i, i2, z, f, f2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest B(int i, int i2, boolean z, float f, float f2, boolean z2) {
        return INSTANCE.r(i, i2, z, f, f2, z2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest C() {
        return INSTANCE.t();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest D(int i) {
        return INSTANCE.u(i);
    }

    @JvmStatic
    @NotNull
    public static final MediaPickerRequest F(int i) {
        return INSTANCE.w(i);
    }

    public static /* synthetic */ MediaPickerRequest g(MediaPickerRequest mediaPickerRequest, PickType pickType, int i, ImageCompressConfig imageCompressConfig, ImageCropConfig imageCropConfig, VideoPickConfig videoPickConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pickType = mediaPickerRequest.type;
        }
        if ((i2 & 2) != 0) {
            i = mediaPickerRequest.maxCount;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            imageCompressConfig = mediaPickerRequest.compressConfig;
        }
        ImageCompressConfig imageCompressConfig2 = imageCompressConfig;
        if ((i2 & 8) != 0) {
            imageCropConfig = mediaPickerRequest.cropConfig;
        }
        ImageCropConfig imageCropConfig2 = imageCropConfig;
        if ((i2 & 16) != 0) {
            videoPickConfig = mediaPickerRequest.videoConfig;
        }
        return mediaPickerRequest.f(pickType, i3, imageCompressConfig2, imageCropConfig2, videoPickConfig);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest l(int i) {
        return INSTANCE.a(i);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest m(int i, int i2) {
        return INSTANCE.b(i, i2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest n(int i, int i2, int i3) {
        return INSTANCE.c(i, i2, i3);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest o(int i, int i2, int i3, boolean z) {
        return INSTANCE.d(i, i2, i3, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest q(int i) {
        return INSTANCE.f(i);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest r(int i, int i2) {
        return INSTANCE.g(i, i2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest s(int i, int i2, int i3) {
        return INSTANCE.h(i, i2, i3);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest t(int i, int i2, int i3, int i4) {
        return INSTANCE.i(i, i2, i3, i4);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest u(int i, int i2, int i3, int i4, boolean z) {
        return INSTANCE.j(i, i2, i3, i4, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest v() {
        return INSTANCE.l();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest w(int i) {
        return INSTANCE.m(i);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest x(int i, int i2) {
        return INSTANCE.n(i, i2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest y(int i, int i2, boolean z) {
        return INSTANCE.o(i, i2, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MediaPickerRequest z(int i, int i2, boolean z, float f) {
        return INSTANCE.p(i, i2, z, f);
    }

    @Nullable
    public final String E() {
        if (this.maxCount < 1) {
            return "maxCount must be >= 1";
        }
        if (p()) {
            int iE = fq6.f41732a.e();
            int i = this.maxCount;
            if (!(2 <= i && i <= iE)) {
                return "maxCount must be in 2.." + iE + " for multiple selection";
            }
        }
        String strJ = this.compressConfig.j();
        if (strJ != null) {
            return strJ;
        }
        String strF = this.videoConfig.f();
        if (strF != null) {
            return strF;
        }
        if (!this.cropConfig.l()) {
            return null;
        }
        if (p()) {
            return "Crop is only supported for single image selection";
        }
        if (this.type != PickType.IMAGE) {
            return "Crop is only supported for images";
        }
        if (this.cropConfig.j() <= 0.0f || this.cropConfig.k() <= 0.0f) {
            return "Crop aspect ratio must be positive";
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final PickType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    /* JADX INFO: renamed from: c, reason: from getter */
    public final ImageCompressConfig getCompressConfig() {
        return this.compressConfig;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final ImageCropConfig getCropConfig() {
        return this.cropConfig;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: from getter */
    public final VideoPickConfig getVideoConfig() {
        return this.videoConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaPickerRequest)) {
            return false;
        }
        MediaPickerRequest mediaPickerRequest = (MediaPickerRequest) other;
        return this.type == mediaPickerRequest.type && this.maxCount == mediaPickerRequest.maxCount && Intrinsics.areEqual(this.compressConfig, mediaPickerRequest.compressConfig) && Intrinsics.areEqual(this.cropConfig, mediaPickerRequest.cropConfig) && Intrinsics.areEqual(this.videoConfig, mediaPickerRequest.videoConfig);
    }

    @NotNull
    public final MediaPickerRequest f(@NotNull PickType type, int maxCount, @NotNull ImageCompressConfig compressConfig, @NotNull ImageCropConfig cropConfig, @NotNull VideoPickConfig videoConfig) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(compressConfig, "compressConfig");
        Intrinsics.checkNotNullParameter(cropConfig, "cropConfig");
        Intrinsics.checkNotNullParameter(videoConfig, "videoConfig");
        return new MediaPickerRequest(type, maxCount, compressConfig, cropConfig, videoConfig);
    }

    @NotNull
    public final PickType getType() {
        return this.type;
    }

    @NotNull
    public final ImageCompressConfig h() {
        return this.compressConfig;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + Integer.hashCode(this.maxCount)) * 31) + this.compressConfig.hashCode()) * 31) + this.cropConfig.hashCode()) * 31) + this.videoConfig.hashCode();
    }

    @NotNull
    public final ImageCropConfig i() {
        return this.cropConfig;
    }

    public final int j() {
        return this.maxCount;
    }

    @NotNull
    public final VideoPickConfig k() {
        return this.videoConfig;
    }

    public final boolean p() {
        return this.maxCount > 1;
    }

    @NotNull
    public String toString() {
        return "MediaPickerRequest(type=" + this.type + ", maxCount=" + this.maxCount + ", compressConfig=" + this.compressConfig + ", cropConfig=" + this.cropConfig + ", videoConfig=" + this.videoConfig + ")";
    }

    public /* synthetic */ MediaPickerRequest(PickType pickType, int i, ImageCompressConfig imageCompressConfig, ImageCropConfig imageCropConfig, VideoPickConfig videoPickConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(pickType, i, imageCompressConfig, imageCropConfig, (i2 & 16) != 0 ? new VideoPickConfig(0, 1, null) : videoPickConfig);
    }
}
