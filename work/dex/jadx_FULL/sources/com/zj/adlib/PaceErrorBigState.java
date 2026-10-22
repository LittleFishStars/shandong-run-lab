package com.zj.adlib;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.yk6, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J;\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\t\u0010\u0010\u001a\u00020\bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/zj/adlib/yk6;", "", "", "a", "b", "", "c", "d", "", "e", "visible", "isTooFast", "totalSecs", "isSilence", "limitText", "f", "toString", "hashCode", "other", "equals", "Z", "j", "()Z", t.d, "I", "i", "()I", "k", "Ljava/lang/String;", y6b.g, "()Ljava/lang/String;", "<init>", "(ZZIZLjava/lang/String;)V", "run_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PaceErrorBigState {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int totalSecs;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final String limitText;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    public final boolean visible;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final boolean isTooFast;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final boolean isSilence;

    public PaceErrorBigState() {
        this(false, false, 0, false, null, 31, null);
    }

    public PaceErrorBigState(boolean z, boolean z2, int i, boolean z3, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "limitText");
        this.visible = z;
        this.isTooFast = z2;
        this.totalSecs = i;
        this.isSilence = z3;
        this.limitText = str;
    }

    public static /* synthetic */ PaceErrorBigState g(PaceErrorBigState paceErrorBigState, boolean z, boolean z2, int i, boolean z3, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = paceErrorBigState.visible;
        }
        if ((i2 & 2) != 0) {
            z2 = paceErrorBigState.isTooFast;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            i = paceErrorBigState.totalSecs;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z3 = paceErrorBigState.isSilence;
        }
        boolean z5 = z3;
        if ((i2 & 16) != 0) {
            str = paceErrorBigState.limitText;
        }
        return paceErrorBigState.f(z, z4, i3, z5, str);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsTooFast() {
        return this.isTooFast;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getTotalSecs() {
        return this.totalSecs;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIsSilence() {
        return this.isSilence;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getLimitText() {
        return this.limitText;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaceErrorBigState)) {
            return false;
        }
        PaceErrorBigState paceErrorBigState = (PaceErrorBigState) other;
        return this.visible == paceErrorBigState.visible && this.isTooFast == paceErrorBigState.isTooFast && this.totalSecs == paceErrorBigState.totalSecs && this.isSilence == paceErrorBigState.isSilence && Intrinsics.areEqual(this.limitText, paceErrorBigState.limitText);
    }

    @NotNull
    public final PaceErrorBigState f(boolean visible, boolean isTooFast, int totalSecs, boolean isSilence, @NotNull String limitText) {
        Intrinsics.checkNotNullParameter(limitText, "limitText");
        return new PaceErrorBigState(visible, isTooFast, totalSecs, isSilence, limitText);
    }

    @NotNull
    public final String h() {
        return this.limitText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        boolean z = this.visible;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isTooFast;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode = (((i + r2) * 31) + Integer.hashCode(this.totalSecs)) * 31;
        boolean z3 = this.isSilence;
        return ((iHashCode + (z3 ? 1 : z3)) * 31) + this.limitText.hashCode();
    }

    public final int i() {
        return this.totalSecs;
    }

    public final boolean j() {
        return this.visible;
    }

    public final boolean k() {
        return this.isSilence;
    }

    public final boolean l() {
        return this.isTooFast;
    }

    @NotNull
    public String toString() {
        return "PaceErrorBigState(visible=" + this.visible + ", isTooFast=" + this.isTooFast + ", totalSecs=" + this.totalSecs + ", isSilence=" + this.isSilence + ", limitText=" + this.limitText + ')';
    }

    public /* synthetic */ PaceErrorBigState(boolean z, boolean z2, int i, boolean z3, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) == 0 ? z3 : false, (i2 & 16) != 0 ? "" : str);
    }
}
