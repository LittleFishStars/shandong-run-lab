package com.zj.adlib;

import android.net.Uri;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.util.media_picker.ImageCropConfig;
import com.huachenjie.common.util.media_picker.PickType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.yn6, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b'\b\u0082\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\bD\u0010EJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u0013HÆ\u0001J\t\u0010 \u001a\u00020\u001fHÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\u0013\u0010#\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0016\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0017\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0019\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102R$\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/zj/adlib/yn6;", "", "", "a", "Lcom/huachenjie/common/util/media_picker/PickType;", "b", "", "c", "Lcom/zj/adlib/u64;", "d", "Lcom/huachenjie/common/util/media_picker/a;", "e", "Lcom/zj/adlib/xn9;", "f", "Ljava/io/File;", y6b.f, "Landroid/net/Uri;", y6b.g, "i", "", "j", "pickType", "maxCount", "compress", "crop", "video", "cameraFile", "cameraUri", "cropDestinationUri", "awaitingCropResult", "k", "", "toString", "hashCode", "other", "equals", "Lcom/huachenjie/common/util/media_picker/PickType;", "t", "()Lcom/huachenjie/common/util/media_picker/PickType;", "I", "s", "()I", "Lcom/zj/adlib/u64;", "p", "()Lcom/zj/adlib/u64;", "Lcom/huachenjie/common/util/media_picker/a;", "q", "()Lcom/huachenjie/common/util/media_picker/a;", "Lcom/zj/adlib/xn9;", "u", "()Lcom/zj/adlib/xn9;", "Ljava/io/File;", "n", "()Ljava/io/File;", "w", "(Ljava/io/File;)V", "Landroid/net/Uri;", j.b, "()Landroid/net/Uri;", "x", "(Landroid/net/Uri;)V", "r", "y", "Z", "m", "()Z", "v", "(Z)V", "<init>", "(Lcom/huachenjie/common/util/media_picker/PickType;ILcom/zj/adlib/u64;Lcom/huachenjie/common/util/media_picker/a;Lcom/zj/adlib/xn9;Ljava/io/File;Landroid/net/Uri;Landroid/net/Uri;Z)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PendingSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxCount;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @Nullable
    public Uri cameraUri;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final PickType pickType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final ImageCropConfig crop;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final ImageCompressConfig compress;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final VideoPickConfig video;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @Nullable
    public File cameraFile;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public boolean awaitingCropResult;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @Nullable
    public Uri cropDestinationUri;

    public PendingSession() {
        this(null, 0, null, null, null, null, null, null, false, 511, null);
    }

    public PendingSession(@NotNull PickType pickType, int i, @NotNull ImageCompressConfig imageCompressConfig, @NotNull ImageCropConfig imageCropConfig, @NotNull VideoPickConfig videoPickConfig, @Nullable File file, @Nullable Uri uri, @Nullable Uri uri2, boolean z) {
        Intrinsics.checkNotNullParameter(pickType, "pickType");
        Intrinsics.checkNotNullParameter(imageCompressConfig, "compress");
        Intrinsics.checkNotNullParameter(imageCropConfig, "crop");
        Intrinsics.checkNotNullParameter(videoPickConfig, "video");
        this.pickType = pickType;
        this.maxCount = i;
        this.compress = imageCompressConfig;
        this.crop = imageCropConfig;
        this.video = videoPickConfig;
        this.cameraFile = file;
        this.cameraUri = uri;
        this.cropDestinationUri = uri2;
        this.awaitingCropResult = z;
    }

    public final void a() {
        this.cameraFile = null;
        this.cameraUri = null;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final PickType getPickType() {
        return this.pickType;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final ImageCompressConfig getCompress() {
        return this.compress;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: from getter */
    public final ImageCropConfig getCrop() {
        return this.crop;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingSession)) {
            return false;
        }
        PendingSession pendingSession = (PendingSession) other;
        return this.pickType == pendingSession.pickType && this.maxCount == pendingSession.maxCount && Intrinsics.areEqual(this.compress, pendingSession.compress) && Intrinsics.areEqual(this.crop, pendingSession.crop) && Intrinsics.areEqual(this.video, pendingSession.video) && Intrinsics.areEqual(this.cameraFile, pendingSession.cameraFile) && Intrinsics.areEqual(this.cameraUri, pendingSession.cameraUri) && Intrinsics.areEqual(this.cropDestinationUri, pendingSession.cropDestinationUri) && this.awaitingCropResult == pendingSession.awaitingCropResult;
    }

    @NotNull
    /* JADX INFO: renamed from: f, reason: from getter */
    public final VideoPickConfig getVideo() {
        return this.video;
    }

    @Nullable
    /* JADX INFO: renamed from: g, reason: from getter */
    public final File getCameraFile() {
        return this.cameraFile;
    }

    @Nullable
    /* JADX INFO: renamed from: h, reason: from getter */
    public final Uri getCameraUri() {
        return this.cameraUri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v20 */
    public int hashCode() {
        int iHashCode = ((((((((this.pickType.hashCode() * 31) + Integer.hashCode(this.maxCount)) * 31) + this.compress.hashCode()) * 31) + this.crop.hashCode()) * 31) + this.video.hashCode()) * 31;
        File file = this.cameraFile;
        int iHashCode2 = (iHashCode + (file == null ? 0 : file.hashCode())) * 31;
        Uri uri = this.cameraUri;
        int iHashCode3 = (iHashCode2 + (uri == null ? 0 : uri.hashCode())) * 31;
        Uri uri2 = this.cropDestinationUri;
        int iHashCode4 = (iHashCode3 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        boolean z = this.awaitingCropResult;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    @Nullable
    /* JADX INFO: renamed from: i, reason: from getter */
    public final Uri getCropDestinationUri() {
        return this.cropDestinationUri;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getAwaitingCropResult() {
        return this.awaitingCropResult;
    }

    @NotNull
    public final PendingSession k(@NotNull PickType pickType, int maxCount, @NotNull ImageCompressConfig compress, @NotNull ImageCropConfig crop, @NotNull VideoPickConfig video, @Nullable File cameraFile, @Nullable Uri cameraUri, @Nullable Uri cropDestinationUri, boolean awaitingCropResult) {
        Intrinsics.checkNotNullParameter(pickType, "pickType");
        Intrinsics.checkNotNullParameter(compress, "compress");
        Intrinsics.checkNotNullParameter(crop, "crop");
        Intrinsics.checkNotNullParameter(video, "video");
        return new PendingSession(pickType, maxCount, compress, crop, video, cameraFile, cameraUri, cropDestinationUri, awaitingCropResult);
    }

    public final boolean m() {
        return this.awaitingCropResult;
    }

    @Nullable
    public final File n() {
        return this.cameraFile;
    }

    @Nullable
    public final Uri o() {
        return this.cameraUri;
    }

    @NotNull
    public final ImageCompressConfig p() {
        return this.compress;
    }

    @NotNull
    public final ImageCropConfig q() {
        return this.crop;
    }

    @Nullable
    public final Uri r() {
        return this.cropDestinationUri;
    }

    public final int s() {
        return this.maxCount;
    }

    @NotNull
    public final PickType t() {
        return this.pickType;
    }

    @NotNull
    public String toString() {
        return "PendingSession(pickType=" + this.pickType + ", maxCount=" + this.maxCount + ", compress=" + this.compress + ", crop=" + this.crop + ", video=" + this.video + ", cameraFile=" + this.cameraFile + ", cameraUri=" + this.cameraUri + ", cropDestinationUri=" + this.cropDestinationUri + ", awaitingCropResult=" + this.awaitingCropResult + ")";
    }

    @NotNull
    public final VideoPickConfig u() {
        return this.video;
    }

    public final void v(boolean z) {
        this.awaitingCropResult = z;
    }

    public final void w(@Nullable File file) {
        this.cameraFile = file;
    }

    public final void x(@Nullable Uri uri) {
        this.cameraUri = uri;
    }

    public final void y(@Nullable Uri uri) {
        this.cropDestinationUri = uri;
    }

    public /* synthetic */ PendingSession(PickType pickType, int i, ImageCompressConfig imageCompressConfig, ImageCropConfig imageCropConfig, VideoPickConfig videoPickConfig, File file, Uri uri, Uri uri2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PickType.IMAGE : pickType, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? new ImageCompressConfig(0, 0, false, 7, null) : imageCompressConfig, (i2 & 8) != 0 ? new ImageCropConfig(false, 0.0f, 0.0f, 7, null) : imageCropConfig, (i2 & 16) != 0 ? new VideoPickConfig(0, 1, null) : videoPickConfig, (i2 & 32) != 0 ? null : file, (i2 & 64) != 0 ? null : uri, (i2 & 128) == 0 ? uri2 : null, (i2 & 256) == 0 ? z : false);
    }
}
