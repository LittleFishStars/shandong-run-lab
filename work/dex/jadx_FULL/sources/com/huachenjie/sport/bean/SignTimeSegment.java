package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/bean/SignTimeSegment;", "", "endTime", "", "startTime", "(Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "getStartTime", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignTimeSegment {

    @NotNull
    private final String endTime;

    @NotNull
    private final String startTime;

    public SignTimeSegment(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "endTime");
        Intrinsics.checkNotNullParameter(str2, "startTime");
        this.endTime = str;
        this.startTime = str2;
    }

    public static /* synthetic */ SignTimeSegment copy$default(SignTimeSegment signTimeSegment, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signTimeSegment.endTime;
        }
        if ((i & 2) != 0) {
            str2 = signTimeSegment.startTime;
        }
        return signTimeSegment.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final SignTimeSegment copy(@NotNull String endTime, @NotNull String startTime) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        return new SignTimeSegment(endTime, startTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignTimeSegment)) {
            return false;
        }
        SignTimeSegment signTimeSegment = (SignTimeSegment) other;
        return Intrinsics.areEqual(this.endTime, signTimeSegment.endTime) && Intrinsics.areEqual(this.startTime, signTimeSegment.startTime);
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (this.endTime.hashCode() * 31) + this.startTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "SignTimeSegment(endTime=" + this.endTime + ", startTime=" + this.startTime + ')';
    }
}
