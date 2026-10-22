package com.zj.adlib;

import android.graphics.Bitmap;
import android.util.Size;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.fv6, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003Ja\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0013\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b-\u0010!R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b.\u0010!R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b/\u0010!R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/zj/adlib/fv6;", "", "", "a", "Landroid/util/Size;", "b", "", "Lcom/zj/adlib/es4;", "c", "", "d", "e", "f", y6b.f, "Landroid/graphics/Bitmap;", y6b.g, "id", "imageSize", "keyPoints", "score", "cost", "imageProcessCost", "inferenceCost", "imageBitmap", "i", "", "toString", "hashCode", "other", "", "equals", "I", t.d, "()I", "s", "(I)V", "Landroid/util/Size;", j.b, "()Landroid/util/Size;", "Ljava/util/List;", "q", "()Ljava/util/List;", "F", "r", "()F", "k", "n", "p", "Landroid/graphics/Bitmap;", "m", "()Landroid/graphics/Bitmap;", "<init>", "(ILandroid/util/Size;Ljava/util/List;FIIILandroid/graphics/Bitmap;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PoseEstimationResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public int id;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @Nullable
    public final Bitmap imageBitmap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final Size imageSize;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final List<KeyPoint> keyPoints;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final int cost;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final int imageProcessCost;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    public final int inferenceCost;

    public PoseEstimationResult(int i, @NotNull Size size, @NotNull List<KeyPoint> list, float f, int i2, int i3, int i4, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(size, "imageSize");
        Intrinsics.checkNotNullParameter(list, "keyPoints");
        this.id = i;
        this.imageSize = size;
        this.keyPoints = list;
        this.score = f;
        this.cost = i2;
        this.imageProcessCost = i3;
        this.inferenceCost = i4;
        this.imageBitmap = bitmap;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final Size getImageSize() {
        return this.imageSize;
    }

    @NotNull
    public final List<KeyPoint> c() {
        return this.keyPoints;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getCost() {
        return this.cost;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoseEstimationResult)) {
            return false;
        }
        PoseEstimationResult poseEstimationResult = (PoseEstimationResult) other;
        return this.id == poseEstimationResult.id && Intrinsics.areEqual(this.imageSize, poseEstimationResult.imageSize) && Intrinsics.areEqual(this.keyPoints, poseEstimationResult.keyPoints) && Intrinsics.areEqual(Float.valueOf(this.score), Float.valueOf(poseEstimationResult.score)) && this.cost == poseEstimationResult.cost && this.imageProcessCost == poseEstimationResult.imageProcessCost && this.inferenceCost == poseEstimationResult.inferenceCost && Intrinsics.areEqual(this.imageBitmap, poseEstimationResult.imageBitmap);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getImageProcessCost() {
        return this.imageProcessCost;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getInferenceCost() {
        return this.inferenceCost;
    }

    @Nullable
    /* JADX INFO: renamed from: h, reason: from getter */
    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Integer.hashCode(this.id) * 31) + this.imageSize.hashCode()) * 31) + this.keyPoints.hashCode()) * 31) + Float.hashCode(this.score)) * 31) + Integer.hashCode(this.cost)) * 31) + Integer.hashCode(this.imageProcessCost)) * 31) + Integer.hashCode(this.inferenceCost)) * 31;
        Bitmap bitmap = this.imageBitmap;
        return iHashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    @NotNull
    public final PoseEstimationResult i(int id, @NotNull Size imageSize, @NotNull List<KeyPoint> keyPoints, float score, int cost, int imageProcessCost, int inferenceCost, @Nullable Bitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        Intrinsics.checkNotNullParameter(keyPoints, "keyPoints");
        return new PoseEstimationResult(id, imageSize, keyPoints, score, cost, imageProcessCost, inferenceCost, imageBitmap);
    }

    public final int k() {
        return this.cost;
    }

    public final int l() {
        return this.id;
    }

    @Nullable
    public final Bitmap m() {
        return this.imageBitmap;
    }

    public final int n() {
        return this.imageProcessCost;
    }

    @NotNull
    public final Size o() {
        return this.imageSize;
    }

    public final int p() {
        return this.inferenceCost;
    }

    @NotNull
    public final List<KeyPoint> q() {
        return this.keyPoints;
    }

    public final float r() {
        return this.score;
    }

    public final void s(int i) {
        this.id = i;
    }

    @NotNull
    public String toString() {
        return "PoseEstimationResult(id=" + this.id + ", imageSize=" + this.imageSize + ", keyPoints=" + this.keyPoints + ", score=" + this.score + ", cost=" + this.cost + ", imageProcessCost=" + this.imageProcessCost + ", inferenceCost=" + this.inferenceCost + ", imageBitmap=" + this.imageBitmap + ')';
    }

    public /* synthetic */ PoseEstimationResult(int i, Size size, List list, float f, int i2, int i3, int i4, Bitmap bitmap, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? -1 : i, size, list, f, i2, i3, i4, (i5 & 128) != 0 ? null : bitmap);
    }
}
