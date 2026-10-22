package com.zj.adlib;

import androidx.constraintlayout.motion.widget.Key;
import com.kuaishou.weapon.p0.t;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.xa9, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Lcom/zj/adlib/xa9;", "", "", "a", "", "b", "c", "d", "e", "buffer", "width", "height", "format", Key.ROTATION, "f", "", "toString", "hashCode", "other", "", "equals", "[B", y6b.g, "()[B", "I", t.d, "()I", "j", "i", "k", "<init>", "([BIIII)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class TrackingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int width;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final byte[] buffer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final int height;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final int format;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    public final int rotation;

    public TrackingInfo(@NotNull byte[] bArr, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.buffer = bArr;
        this.width = i;
        this.height = i2;
        this.format = i3;
        this.rotation = i4;
    }

    public static /* synthetic */ TrackingInfo g(TrackingInfo trackingInfo, byte[] bArr, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr = trackingInfo.buffer;
        }
        if ((i5 & 2) != 0) {
            i = trackingInfo.width;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = trackingInfo.height;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = trackingInfo.format;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = trackingInfo.rotation;
        }
        return trackingInfo.f(bArr, i6, i7, i8, i4);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final byte[] getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackingInfo)) {
            return false;
        }
        TrackingInfo trackingInfo = (TrackingInfo) other;
        return Intrinsics.areEqual(this.buffer, trackingInfo.buffer) && this.width == trackingInfo.width && this.height == trackingInfo.height && this.format == trackingInfo.format && this.rotation == trackingInfo.rotation;
    }

    @NotNull
    public final TrackingInfo f(@NotNull byte[] buffer, int width, int height, int format, int rotation) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new TrackingInfo(buffer, width, height, format, rotation);
    }

    @NotNull
    public final byte[] h() {
        return this.buffer;
    }

    public int hashCode() {
        return (((((((Arrays.hashCode(this.buffer) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.format)) * 31) + Integer.hashCode(this.rotation);
    }

    public final int i() {
        return this.format;
    }

    public final int j() {
        return this.height;
    }

    public final int k() {
        return this.rotation;
    }

    public final int l() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "TrackingInfo(buffer=" + Arrays.toString(this.buffer) + ", width=" + this.width + ", height=" + this.height + ", format=" + this.format + ", rotation=" + this.rotation + ')';
    }
}
