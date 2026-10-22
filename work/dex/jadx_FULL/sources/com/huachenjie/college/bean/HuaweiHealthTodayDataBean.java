package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.c49;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/college/bean/HuaweiHealthTodayDataBean;", "", "steps", "", "distanceKm", "", "activeCalories", "heartRateBpm", "sleepMinutes", "(ILjava/lang/String;Ljava/lang/String;II)V", "getActiveCalories", "()Ljava/lang/String;", "getDistanceKm", "getHeartRateBpm", "()I", "getSleepMinutes", "sleepMinutesStr", "getSleepMinutesStr", "getSteps", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuaweiHealthTodayDataBean {

    @NotNull
    private final String activeCalories;

    @NotNull
    private final String distanceKm;
    private final int heartRateBpm;
    private final int sleepMinutes;
    private final int steps;

    public HuaweiHealthTodayDataBean() {
        this(0, null, null, 0, 0, 31, null);
    }

    public HuaweiHealthTodayDataBean(int i, @NotNull String str, @NotNull String str2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "distanceKm");
        Intrinsics.checkNotNullParameter(str2, "activeCalories");
        this.steps = i;
        this.distanceKm = str;
        this.activeCalories = str2;
        this.heartRateBpm = i2;
        this.sleepMinutes = i3;
    }

    public static /* synthetic */ HuaweiHealthTodayDataBean copy$default(HuaweiHealthTodayDataBean huaweiHealthTodayDataBean, int i, String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = huaweiHealthTodayDataBean.steps;
        }
        if ((i4 & 2) != 0) {
            str = huaweiHealthTodayDataBean.distanceKm;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            str2 = huaweiHealthTodayDataBean.activeCalories;
        }
        String str4 = str2;
        if ((i4 & 8) != 0) {
            i2 = huaweiHealthTodayDataBean.heartRateBpm;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = huaweiHealthTodayDataBean.sleepMinutes;
        }
        return huaweiHealthTodayDataBean.copy(i, str3, str4, i5, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSteps() {
        return this.steps;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActiveCalories() {
        return this.activeCalories;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeartRateBpm() {
        return this.heartRateBpm;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSleepMinutes() {
        return this.sleepMinutes;
    }

    @NotNull
    public final HuaweiHealthTodayDataBean copy(int steps, @NotNull String distanceKm, @NotNull String activeCalories, int heartRateBpm, int sleepMinutes) {
        Intrinsics.checkNotNullParameter(distanceKm, "distanceKm");
        Intrinsics.checkNotNullParameter(activeCalories, "activeCalories");
        return new HuaweiHealthTodayDataBean(steps, distanceKm, activeCalories, heartRateBpm, sleepMinutes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuaweiHealthTodayDataBean)) {
            return false;
        }
        HuaweiHealthTodayDataBean huaweiHealthTodayDataBean = (HuaweiHealthTodayDataBean) other;
        return this.steps == huaweiHealthTodayDataBean.steps && Intrinsics.areEqual(this.distanceKm, huaweiHealthTodayDataBean.distanceKm) && Intrinsics.areEqual(this.activeCalories, huaweiHealthTodayDataBean.activeCalories) && this.heartRateBpm == huaweiHealthTodayDataBean.heartRateBpm && this.sleepMinutes == huaweiHealthTodayDataBean.sleepMinutes;
    }

    @NotNull
    public final String getActiveCalories() {
        return this.activeCalories;
    }

    @NotNull
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    public final int getHeartRateBpm() {
        return this.heartRateBpm;
    }

    public final int getSleepMinutes() {
        return this.sleepMinutes;
    }

    @NotNull
    public final String getSleepMinutesStr() {
        int i = this.sleepMinutes;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%02dH%02dM", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.steps) * 31) + this.distanceKm.hashCode()) * 31) + this.activeCalories.hashCode()) * 31) + Integer.hashCode(this.heartRateBpm)) * 31) + Integer.hashCode(this.sleepMinutes);
    }

    @NotNull
    public String toString() {
        return "HuaweiHealthTodayDataBean(steps=" + this.steps + ", distanceKm=" + this.distanceKm + ", activeCalories=" + this.activeCalories + ", heartRateBpm=" + this.heartRateBpm + ", sleepMinutes=" + this.sleepMinutes + ')';
    }

    public /* synthetic */ HuaweiHealthTodayDataBean(int i, String str, String str2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? c49.f40900a : str, (i4 & 4) == 0 ? str2 : c49.f40900a, (i4 & 8) != 0 ? -1 : i2, (i4 & 16) != 0 ? -1 : i3);
    }
}
