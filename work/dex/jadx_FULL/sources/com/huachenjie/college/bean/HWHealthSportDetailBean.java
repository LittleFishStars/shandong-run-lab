package com.huachenjie.college.bean;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bG\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0014\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000fHÆ\u0003J\t\u0010K\u001a\u00020\rHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\u0014HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\t\u0010R\u001a\u00020\u0014HÆ\u0003J\t\u0010S\u001a\u00020\u0014HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0014HÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\u0014HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\u0014HÆ\u0003J\t\u0010[\u001a\u00020\u0014HÆ\u0003J\t\u0010\\\u001a\u00020\u000fHÆ\u0003J\t\u0010]\u001a\u00020#HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\rHÆ\u0003J¡\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#HÆ\u0001J\u0013\u0010f\u001a\u00020\u000f2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020\rHÖ\u0001J\t\u0010i\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u0018\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0011\u0010!\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u001c\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0011\u0010\u001a\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b@\u0010(R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00106R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00106R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bE\u0010&R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0011\u0010\u001f\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bG\u0010(R\u0011\u0010 \u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bH\u0010(¨\u0006j"}, d2 = {"Lcom/huachenjie/college/bean/HWHealthSportDetailBean;", "", HWHealthSportDetailActivity.x, "", "groupMonth", "", "sportType", "sportName", "logoUrl", "dataSource", "startTime", "distanceKm", "skipNum", "", "deducted", "", "deductionType", "endTime", "activeTimeSeconds", "calories", "", "averageHeartRate", "steps", "averagePaceSecondsPerKm", "averageStepRate", "averageStepLengthMeter", "speedKmPerHour", "maxSkippingTimes", "skipSpeed", "swimmingStroke", "pullTimes", "swimmingStrokeRate", "swolf", "hasLocation", "locationJson", "Lcom/huachenjie/college/bean/HWHealthSportDetailLocationBean;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IZIJIFFIFFFFIFLjava/lang/String;IFFZLcom/huachenjie/college/bean/HWHealthSportDetailLocationBean;)V", "getActiveTimeSeconds", "()I", "getAverageHeartRate", "()F", "getAveragePaceSecondsPerKm", "getAverageStepLengthMeter", "getAverageStepRate", "getCalories", "getDataSource", "()Ljava/lang/String;", "getDeducted", "()Z", "setDeducted", "(Z)V", "getDeductionType", "getDistanceKm", "getEndTime", "()J", "getGroupMonth", "getHasLocation", "getLocationJson", "()Lcom/huachenjie/college/bean/HWHealthSportDetailLocationBean;", "getLogoUrl", "getMaxSkippingTimes", "getPullTimes", "getSkipNum", "getSkipSpeed", "getSpeedKmPerHour", "getSportName", "getSportRecordCode", "getSportType", "getStartTime", "getSteps", "getSwimmingStroke", "getSwimmingStrokeRate", "getSwolf", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HWHealthSportDetailBean {
    private final int activeTimeSeconds;
    private final float averageHeartRate;
    private final float averagePaceSecondsPerKm;
    private final float averageStepLengthMeter;
    private final float averageStepRate;
    private final float calories;

    @NotNull
    private final String dataSource;
    private boolean deducted;
    private final int deductionType;

    @NotNull
    private final String distanceKm;
    private final long endTime;

    @NotNull
    private final String groupMonth;
    private final boolean hasLocation;

    @NotNull
    private final HWHealthSportDetailLocationBean locationJson;

    @NotNull
    private final String logoUrl;
    private final int maxSkippingTimes;
    private final int pullTimes;
    private final int skipNum;
    private final float skipSpeed;
    private final float speedKmPerHour;

    @NotNull
    private final String sportName;
    private final long sportRecordCode;

    @NotNull
    private final String sportType;
    private final long startTime;
    private final int steps;

    @NotNull
    private final String swimmingStroke;
    private final float swimmingStrokeRate;
    private final float swolf;

    public HWHealthSportDetailBean(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j2, @NotNull String str6, int i, boolean z, int i2, long j3, int i3, float f, float f2, int i4, float f3, float f4, float f5, float f6, int i5, float f7, @NotNull String str7, int i6, float f8, float f9, boolean z2, @NotNull HWHealthSportDetailLocationBean hWHealthSportDetailLocationBean) {
        Intrinsics.checkNotNullParameter(str, "groupMonth");
        Intrinsics.checkNotNullParameter(str2, "sportType");
        Intrinsics.checkNotNullParameter(str3, "sportName");
        Intrinsics.checkNotNullParameter(str4, "logoUrl");
        Intrinsics.checkNotNullParameter(str5, "dataSource");
        Intrinsics.checkNotNullParameter(str6, "distanceKm");
        Intrinsics.checkNotNullParameter(str7, "swimmingStroke");
        Intrinsics.checkNotNullParameter(hWHealthSportDetailLocationBean, "locationJson");
        this.sportRecordCode = j;
        this.groupMonth = str;
        this.sportType = str2;
        this.sportName = str3;
        this.logoUrl = str4;
        this.dataSource = str5;
        this.startTime = j2;
        this.distanceKm = str6;
        this.skipNum = i;
        this.deducted = z;
        this.deductionType = i2;
        this.endTime = j3;
        this.activeTimeSeconds = i3;
        this.calories = f;
        this.averageHeartRate = f2;
        this.steps = i4;
        this.averagePaceSecondsPerKm = f3;
        this.averageStepRate = f4;
        this.averageStepLengthMeter = f5;
        this.speedKmPerHour = f6;
        this.maxSkippingTimes = i5;
        this.skipSpeed = f7;
        this.swimmingStroke = str7;
        this.pullTimes = i6;
        this.swimmingStrokeRate = f8;
        this.swolf = f9;
        this.hasLocation = z2;
        this.locationJson = hWHealthSportDetailLocationBean;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSportRecordCode() {
        return this.sportRecordCode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getDeducted() {
        return this.deducted;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getDeductionType() {
        return this.deductionType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getActiveTimeSeconds() {
        return this.activeTimeSeconds;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getCalories() {
        return this.calories;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getAverageHeartRate() {
        return this.averageHeartRate;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getSteps() {
        return this.steps;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getAveragePaceSecondsPerKm() {
        return this.averagePaceSecondsPerKm;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getAverageStepRate() {
        return this.averageStepRate;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final float getAverageStepLengthMeter() {
        return this.averageStepLengthMeter;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGroupMonth() {
        return this.groupMonth;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final float getSpeedKmPerHour() {
        return this.speedKmPerHour;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getMaxSkippingTimes() {
        return this.maxSkippingTimes;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final float getSkipSpeed() {
        return this.skipSpeed;
    }

    @NotNull
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getSwimmingStroke() {
        return this.swimmingStroke;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getPullTimes() {
        return this.pullTimes;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final float getSwimmingStrokeRate() {
        return this.swimmingStrokeRate;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final float getSwolf() {
        return this.swolf;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getHasLocation() {
        return this.hasLocation;
    }

    @NotNull
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final HWHealthSportDetailLocationBean getLocationJson() {
        return this.locationJson;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSportType() {
        return this.sportType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSportName() {
        return this.sportName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDataSource() {
        return this.dataSource;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSkipNum() {
        return this.skipNum;
    }

    @NotNull
    public final HWHealthSportDetailBean copy(long sportRecordCode, @NotNull String groupMonth, @NotNull String sportType, @NotNull String sportName, @NotNull String logoUrl, @NotNull String dataSource, long startTime, @NotNull String distanceKm, int skipNum, boolean deducted, int deductionType, long endTime, int activeTimeSeconds, float calories, float averageHeartRate, int steps, float averagePaceSecondsPerKm, float averageStepRate, float averageStepLengthMeter, float speedKmPerHour, int maxSkippingTimes, float skipSpeed, @NotNull String swimmingStroke, int pullTimes, float swimmingStrokeRate, float swolf, boolean hasLocation, @NotNull HWHealthSportDetailLocationBean locationJson) {
        Intrinsics.checkNotNullParameter(groupMonth, "groupMonth");
        Intrinsics.checkNotNullParameter(sportType, "sportType");
        Intrinsics.checkNotNullParameter(sportName, "sportName");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(distanceKm, "distanceKm");
        Intrinsics.checkNotNullParameter(swimmingStroke, "swimmingStroke");
        Intrinsics.checkNotNullParameter(locationJson, "locationJson");
        return new HWHealthSportDetailBean(sportRecordCode, groupMonth, sportType, sportName, logoUrl, dataSource, startTime, distanceKm, skipNum, deducted, deductionType, endTime, activeTimeSeconds, calories, averageHeartRate, steps, averagePaceSecondsPerKm, averageStepRate, averageStepLengthMeter, speedKmPerHour, maxSkippingTimes, skipSpeed, swimmingStroke, pullTimes, swimmingStrokeRate, swolf, hasLocation, locationJson);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HWHealthSportDetailBean)) {
            return false;
        }
        HWHealthSportDetailBean hWHealthSportDetailBean = (HWHealthSportDetailBean) other;
        return this.sportRecordCode == hWHealthSportDetailBean.sportRecordCode && Intrinsics.areEqual(this.groupMonth, hWHealthSportDetailBean.groupMonth) && Intrinsics.areEqual(this.sportType, hWHealthSportDetailBean.sportType) && Intrinsics.areEqual(this.sportName, hWHealthSportDetailBean.sportName) && Intrinsics.areEqual(this.logoUrl, hWHealthSportDetailBean.logoUrl) && Intrinsics.areEqual(this.dataSource, hWHealthSportDetailBean.dataSource) && this.startTime == hWHealthSportDetailBean.startTime && Intrinsics.areEqual(this.distanceKm, hWHealthSportDetailBean.distanceKm) && this.skipNum == hWHealthSportDetailBean.skipNum && this.deducted == hWHealthSportDetailBean.deducted && this.deductionType == hWHealthSportDetailBean.deductionType && this.endTime == hWHealthSportDetailBean.endTime && this.activeTimeSeconds == hWHealthSportDetailBean.activeTimeSeconds && Float.compare(this.calories, hWHealthSportDetailBean.calories) == 0 && Float.compare(this.averageHeartRate, hWHealthSportDetailBean.averageHeartRate) == 0 && this.steps == hWHealthSportDetailBean.steps && Float.compare(this.averagePaceSecondsPerKm, hWHealthSportDetailBean.averagePaceSecondsPerKm) == 0 && Float.compare(this.averageStepRate, hWHealthSportDetailBean.averageStepRate) == 0 && Float.compare(this.averageStepLengthMeter, hWHealthSportDetailBean.averageStepLengthMeter) == 0 && Float.compare(this.speedKmPerHour, hWHealthSportDetailBean.speedKmPerHour) == 0 && this.maxSkippingTimes == hWHealthSportDetailBean.maxSkippingTimes && Float.compare(this.skipSpeed, hWHealthSportDetailBean.skipSpeed) == 0 && Intrinsics.areEqual(this.swimmingStroke, hWHealthSportDetailBean.swimmingStroke) && this.pullTimes == hWHealthSportDetailBean.pullTimes && Float.compare(this.swimmingStrokeRate, hWHealthSportDetailBean.swimmingStrokeRate) == 0 && Float.compare(this.swolf, hWHealthSportDetailBean.swolf) == 0 && this.hasLocation == hWHealthSportDetailBean.hasLocation && Intrinsics.areEqual(this.locationJson, hWHealthSportDetailBean.locationJson);
    }

    public final int getActiveTimeSeconds() {
        return this.activeTimeSeconds;
    }

    public final float getAverageHeartRate() {
        return this.averageHeartRate;
    }

    public final float getAveragePaceSecondsPerKm() {
        return this.averagePaceSecondsPerKm;
    }

    public final float getAverageStepLengthMeter() {
        return this.averageStepLengthMeter;
    }

    public final float getAverageStepRate() {
        return this.averageStepRate;
    }

    public final float getCalories() {
        return this.calories;
    }

    @NotNull
    public final String getDataSource() {
        return this.dataSource;
    }

    public final boolean getDeducted() {
        return this.deducted;
    }

    public final int getDeductionType() {
        return this.deductionType;
    }

    @NotNull
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getGroupMonth() {
        return this.groupMonth;
    }

    public final boolean getHasLocation() {
        return this.hasLocation;
    }

    @NotNull
    public final HWHealthSportDetailLocationBean getLocationJson() {
        return this.locationJson;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final int getMaxSkippingTimes() {
        return this.maxSkippingTimes;
    }

    public final int getPullTimes() {
        return this.pullTimes;
    }

    public final int getSkipNum() {
        return this.skipNum;
    }

    public final float getSkipSpeed() {
        return this.skipSpeed;
    }

    public final float getSpeedKmPerHour() {
        return this.speedKmPerHour;
    }

    @NotNull
    public final String getSportName() {
        return this.sportName;
    }

    public final long getSportRecordCode() {
        return this.sportRecordCode;
    }

    @NotNull
    public final String getSportType() {
        return this.sportType;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getSteps() {
        return this.steps;
    }

    @NotNull
    public final String getSwimmingStroke() {
        return this.swimmingStroke;
    }

    public final float getSwimmingStrokeRate() {
        return this.swimmingStrokeRate;
    }

    public final float getSwolf() {
        return this.swolf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((Long.hashCode(this.sportRecordCode) * 31) + this.groupMonth.hashCode()) * 31) + this.sportType.hashCode()) * 31) + this.sportName.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.dataSource.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + this.distanceKm.hashCode()) * 31) + Integer.hashCode(this.skipNum)) * 31;
        boolean z = this.deducted;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((((((((((((((((((((((((iHashCode + r1) * 31) + Integer.hashCode(this.deductionType)) * 31) + Long.hashCode(this.endTime)) * 31) + Integer.hashCode(this.activeTimeSeconds)) * 31) + Float.hashCode(this.calories)) * 31) + Float.hashCode(this.averageHeartRate)) * 31) + Integer.hashCode(this.steps)) * 31) + Float.hashCode(this.averagePaceSecondsPerKm)) * 31) + Float.hashCode(this.averageStepRate)) * 31) + Float.hashCode(this.averageStepLengthMeter)) * 31) + Float.hashCode(this.speedKmPerHour)) * 31) + Integer.hashCode(this.maxSkippingTimes)) * 31) + Float.hashCode(this.skipSpeed)) * 31) + this.swimmingStroke.hashCode()) * 31) + Integer.hashCode(this.pullTimes)) * 31) + Float.hashCode(this.swimmingStrokeRate)) * 31) + Float.hashCode(this.swolf)) * 31;
        boolean z2 = this.hasLocation;
        return ((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.locationJson.hashCode();
    }

    public final void setDeducted(boolean z) {
        this.deducted = z;
    }

    @NotNull
    public String toString() {
        return "HWHealthSportDetailBean(sportRecordCode=" + this.sportRecordCode + ", groupMonth=" + this.groupMonth + ", sportType=" + this.sportType + ", sportName=" + this.sportName + ", logoUrl=" + this.logoUrl + ", dataSource=" + this.dataSource + ", startTime=" + this.startTime + ", distanceKm=" + this.distanceKm + ", skipNum=" + this.skipNum + ", deducted=" + this.deducted + ", deductionType=" + this.deductionType + ", endTime=" + this.endTime + ", activeTimeSeconds=" + this.activeTimeSeconds + ", calories=" + this.calories + ", averageHeartRate=" + this.averageHeartRate + ", steps=" + this.steps + ", averagePaceSecondsPerKm=" + this.averagePaceSecondsPerKm + ", averageStepRate=" + this.averageStepRate + ", averageStepLengthMeter=" + this.averageStepLengthMeter + ", speedKmPerHour=" + this.speedKmPerHour + ", maxSkippingTimes=" + this.maxSkippingTimes + ", skipSpeed=" + this.skipSpeed + ", swimmingStroke=" + this.swimmingStroke + ", pullTimes=" + this.pullTimes + ", swimmingStrokeRate=" + this.swimmingStrokeRate + ", swolf=" + this.swolf + ", hasLocation=" + this.hasLocation + ", locationJson=" + this.locationJson + ')';
    }

    public /* synthetic */ HWHealthSportDetailBean(long j, String str, String str2, String str3, String str4, String str5, long j2, String str6, int i, boolean z, int i2, long j3, int i3, float f, float f2, int i4, float f3, float f4, float f5, float f6, int i5, float f7, String str7, int i6, float f8, float f9, boolean z2, HWHealthSportDetailLocationBean hWHealthSportDetailLocationBean, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0L : j, (i7 & 2) != 0 ? "" : str, (i7 & 4) != 0 ? "" : str2, (i7 & 8) != 0 ? "" : str3, (i7 & 16) != 0 ? "" : str4, (i7 & 32) != 0 ? "" : str5, (i7 & 64) != 0 ? 0L : j2, (i7 & 128) != 0 ? "" : str6, (i7 & 256) != 0 ? 0 : i, (i7 & 512) != 0 ? false : z, (i7 & 1024) != 0 ? 0 : i2, (i7 & 2048) != 0 ? 0L : j3, (i7 & 4096) != 0 ? 0 : i3, (i7 & 8192) != 0 ? 0.0f : f, (i7 & 16384) != 0 ? 0.0f : f2, (32768 & i7) != 0 ? 0 : i4, (65536 & i7) != 0 ? 0.0f : f3, (131072 & i7) != 0 ? 0.0f : f4, (262144 & i7) != 0 ? 0.0f : f5, (524288 & i7) != 0 ? 0.0f : f6, (1048576 & i7) != 0 ? 0 : i5, (2097152 & i7) != 0 ? 0.0f : f7, (4194304 & i7) != 0 ? "" : str7, (8388608 & i7) != 0 ? 0 : i6, (16777216 & i7) != 0 ? 0.0f : f8, (33554432 & i7) != 0 ? 0.0f : f9, (i7 & TTAdConstant.KEY_CLICK_AREA) != 0 ? false : z2, hWHealthSportDetailLocationBean);
    }
}
