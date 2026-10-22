package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.j99, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/zj/adlib/j99;", "", "", "a", "b", "c", "d", "maxTorsoYDistance", "maxTorsoXDistance", "maxBodyYDistance", "maxBodyXDistance", "e", "", "toString", "", "hashCode", "other", "", "equals", "F", "j", "()F", "i", y6b.g, y6b.f, "<init>", "(FFFF)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class TorsoAndBodyDistance {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float maxTorsoYDistance;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final float maxTorsoXDistance;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final float maxBodyYDistance;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    public final float maxBodyXDistance;

    public TorsoAndBodyDistance(float f, float f2, float f3, float f4) {
        this.maxTorsoYDistance = f;
        this.maxTorsoXDistance = f2;
        this.maxBodyYDistance = f3;
        this.maxBodyXDistance = f4;
    }

    public static /* synthetic */ TorsoAndBodyDistance f(TorsoAndBodyDistance torsoAndBodyDistance, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = torsoAndBodyDistance.maxTorsoYDistance;
        }
        if ((i & 2) != 0) {
            f2 = torsoAndBodyDistance.maxTorsoXDistance;
        }
        if ((i & 4) != 0) {
            f3 = torsoAndBodyDistance.maxBodyYDistance;
        }
        if ((i & 8) != 0) {
            f4 = torsoAndBodyDistance.maxBodyXDistance;
        }
        return torsoAndBodyDistance.e(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final float getMaxTorsoYDistance() {
        return this.maxTorsoYDistance;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getMaxTorsoXDistance() {
        return this.maxTorsoXDistance;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getMaxBodyYDistance() {
        return this.maxBodyYDistance;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getMaxBodyXDistance() {
        return this.maxBodyXDistance;
    }

    @NotNull
    public final TorsoAndBodyDistance e(float maxTorsoYDistance, float maxTorsoXDistance, float maxBodyYDistance, float maxBodyXDistance) {
        return new TorsoAndBodyDistance(maxTorsoYDistance, maxTorsoXDistance, maxBodyYDistance, maxBodyXDistance);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TorsoAndBodyDistance)) {
            return false;
        }
        TorsoAndBodyDistance torsoAndBodyDistance = (TorsoAndBodyDistance) other;
        return Intrinsics.areEqual(Float.valueOf(this.maxTorsoYDistance), Float.valueOf(torsoAndBodyDistance.maxTorsoYDistance)) && Intrinsics.areEqual(Float.valueOf(this.maxTorsoXDistance), Float.valueOf(torsoAndBodyDistance.maxTorsoXDistance)) && Intrinsics.areEqual(Float.valueOf(this.maxBodyYDistance), Float.valueOf(torsoAndBodyDistance.maxBodyYDistance)) && Intrinsics.areEqual(Float.valueOf(this.maxBodyXDistance), Float.valueOf(torsoAndBodyDistance.maxBodyXDistance));
    }

    public final float g() {
        return this.maxBodyXDistance;
    }

    public final float h() {
        return this.maxBodyYDistance;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.maxTorsoYDistance) * 31) + Float.hashCode(this.maxTorsoXDistance)) * 31) + Float.hashCode(this.maxBodyYDistance)) * 31) + Float.hashCode(this.maxBodyXDistance);
    }

    public final float i() {
        return this.maxTorsoXDistance;
    }

    public final float j() {
        return this.maxTorsoYDistance;
    }

    @NotNull
    public String toString() {
        return "TorsoAndBodyDistance(maxTorsoYDistance=" + this.maxTorsoYDistance + ", maxTorsoXDistance=" + this.maxTorsoXDistance + ", maxBodyYDistance=" + this.maxBodyYDistance + ", maxBodyXDistance=" + this.maxBodyXDistance + ')';
    }
}
