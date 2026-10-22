package com.zj.adlib;

import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.nr, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003JE\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019¨\u0006!"}, d2 = {"Lcom/zj/adlib/nr;", "", "", "a", "b", "c", "d", "e", "f", "time", "x", "y", j.o, "acc", "mAcc", y6b.f, "", "toString", "", "hashCode", "other", "", "equals", "F", "k", "()F", t.d, "m", "n", "i", "j", "<init>", "(FFFFFF)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class AccData {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float time;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final float x;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final float y;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    public final float z;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    public final float acc;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    public final float mAcc;

    public AccData(float f, float f2, float f3, float f4, float f5, float f6) {
        this.time = f;
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.acc = f5;
        this.mAcc = f6;
    }

    public static /* synthetic */ AccData h(AccData accData, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = accData.time;
        }
        if ((i & 2) != 0) {
            f2 = accData.x;
        }
        float f7 = f2;
        if ((i & 4) != 0) {
            f3 = accData.y;
        }
        float f8 = f3;
        if ((i & 8) != 0) {
            f4 = accData.z;
        }
        float f9 = f4;
        if ((i & 16) != 0) {
            f5 = accData.acc;
        }
        float f10 = f5;
        if ((i & 32) != 0) {
            f6 = accData.mAcc;
        }
        return accData.g(f, f7, f8, f9, f10, f6);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final float getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getZ() {
        return this.z;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final float getAcc() {
        return this.acc;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccData)) {
            return false;
        }
        AccData accData = (AccData) other;
        return Float.compare(this.time, accData.time) == 0 && Float.compare(this.x, accData.x) == 0 && Float.compare(this.y, accData.y) == 0 && Float.compare(this.z, accData.z) == 0 && Float.compare(this.acc, accData.acc) == 0 && Float.compare(this.mAcc, accData.mAcc) == 0;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final float getMAcc() {
        return this.mAcc;
    }

    @NotNull
    public final AccData g(float time, float x, float y, float z, float acc, float mAcc) {
        return new AccData(time, x, y, z, acc, mAcc);
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.time) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.z)) * 31) + Float.hashCode(this.acc)) * 31) + Float.hashCode(this.mAcc);
    }

    public final float i() {
        return this.acc;
    }

    public final float j() {
        return this.mAcc;
    }

    public final float k() {
        return this.time;
    }

    public final float l() {
        return this.x;
    }

    public final float m() {
        return this.y;
    }

    public final float n() {
        return this.z;
    }

    @NotNull
    public String toString() {
        return "AccData(time=" + this.time + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", acc=" + this.acc + ", mAcc=" + this.mAcc + ")";
    }
}
