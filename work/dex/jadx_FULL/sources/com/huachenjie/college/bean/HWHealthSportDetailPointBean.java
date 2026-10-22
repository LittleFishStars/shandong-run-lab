package com.huachenjie.college.bean;

import androidx.camera.video.AudioStats;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/college/bean/HWHealthSportDetailPointBean;", "", "sampleTime", "", "longitude", "", "latitude", "precision", "altitude", "(JDDDD)V", "getAltitude", "()D", "getLatitude", "getLongitude", "getPrecision", "getSampleTime", "()J", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HWHealthSportDetailPointBean {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final double precision;
    private final long sampleTime;

    public HWHealthSportDetailPointBean() {
        this(0L, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    }

    public HWHealthSportDetailPointBean(long j, double d, double d2, double d3, double d4) {
        this.sampleTime = j;
        this.longitude = d;
        this.latitude = d2;
        this.precision = d3;
        this.altitude = d4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSampleTime() {
        return this.sampleTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getPrecision() {
        return this.precision;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getAltitude() {
        return this.altitude;
    }

    @NotNull
    public final HWHealthSportDetailPointBean copy(long sampleTime, double longitude, double latitude, double precision, double altitude) {
        return new HWHealthSportDetailPointBean(sampleTime, longitude, latitude, precision, altitude);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HWHealthSportDetailPointBean)) {
            return false;
        }
        HWHealthSportDetailPointBean hWHealthSportDetailPointBean = (HWHealthSportDetailPointBean) other;
        return this.sampleTime == hWHealthSportDetailPointBean.sampleTime && Double.compare(this.longitude, hWHealthSportDetailPointBean.longitude) == 0 && Double.compare(this.latitude, hWHealthSportDetailPointBean.latitude) == 0 && Double.compare(this.precision, hWHealthSportDetailPointBean.precision) == 0 && Double.compare(this.altitude, hWHealthSportDetailPointBean.altitude) == 0;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getPrecision() {
        return this.precision;
    }

    public final long getSampleTime() {
        return this.sampleTime;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.sampleTime) * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.precision)) * 31) + Double.hashCode(this.altitude);
    }

    @NotNull
    public String toString() {
        return "HWHealthSportDetailPointBean(sampleTime=" + this.sampleTime + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", precision=" + this.precision + ", altitude=" + this.altitude + ')';
    }

    public /* synthetic */ HWHealthSportDetailPointBean(long j, double d, double d2, double d3, double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0.0d : d, (i & 4) != 0 ? 0.0d : d2, (i & 8) != 0 ? 0.0d : d3, (i & 16) == 0 ? d4 : AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
