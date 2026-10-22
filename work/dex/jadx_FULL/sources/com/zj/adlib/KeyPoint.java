package com.zj.adlib;

import android.graphics.PointF;
import com.huachenjie.pose_estimation.data.BodyPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.es4, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/zj/adlib/es4;", "", "Lcom/huachenjie/pose_estimation/data/BodyPart;", "a", "Landroid/graphics/PointF;", "b", "", "c", "bodyPart", "coordinate", "score", "d", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/huachenjie/pose_estimation/data/BodyPart;", "f", "()Lcom/huachenjie/pose_estimation/data/BodyPart;", "Landroid/graphics/PointF;", y6b.f, "()Landroid/graphics/PointF;", "i", "(Landroid/graphics/PointF;)V", "F", y6b.g, "()F", "<init>", "(Lcom/huachenjie/pose_estimation/data/BodyPart;Landroid/graphics/PointF;F)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class KeyPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public PointF coordinate;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final BodyPart bodyPart;

    public KeyPoint(@NotNull BodyPart bodyPart, @NotNull PointF pointF, float f) {
        Intrinsics.checkNotNullParameter(bodyPart, "bodyPart");
        Intrinsics.checkNotNullParameter(pointF, "coordinate");
        this.bodyPart = bodyPart;
        this.coordinate = pointF;
        this.score = f;
    }

    public static /* synthetic */ KeyPoint e(KeyPoint keyPoint, BodyPart bodyPart, PointF pointF, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            bodyPart = keyPoint.bodyPart;
        }
        if ((i & 2) != 0) {
            pointF = keyPoint.coordinate;
        }
        if ((i & 4) != 0) {
            f = keyPoint.score;
        }
        return keyPoint.d(bodyPart, pointF, f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final BodyPart getBodyPart() {
        return this.bodyPart;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final PointF getCoordinate() {
        return this.coordinate;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    @NotNull
    public final KeyPoint d(@NotNull BodyPart bodyPart, @NotNull PointF coordinate, float score) {
        Intrinsics.checkNotNullParameter(bodyPart, "bodyPart");
        Intrinsics.checkNotNullParameter(coordinate, "coordinate");
        return new KeyPoint(bodyPart, coordinate, score);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyPoint)) {
            return false;
        }
        KeyPoint keyPoint = (KeyPoint) other;
        return this.bodyPart == keyPoint.bodyPart && Intrinsics.areEqual(this.coordinate, keyPoint.coordinate) && Intrinsics.areEqual(Float.valueOf(this.score), Float.valueOf(keyPoint.score));
    }

    @NotNull
    public final BodyPart f() {
        return this.bodyPart;
    }

    @NotNull
    public final PointF g() {
        return this.coordinate;
    }

    public final float h() {
        return this.score;
    }

    public int hashCode() {
        return (((this.bodyPart.hashCode() * 31) + this.coordinate.hashCode()) * 31) + Float.hashCode(this.score);
    }

    public final void i(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.coordinate = pointF;
    }

    @NotNull
    public String toString() {
        return "KeyPoint(bodyPart=" + this.bodyPart + ", coordinate=" + this.coordinate + ", score=" + this.score + ')';
    }
}
