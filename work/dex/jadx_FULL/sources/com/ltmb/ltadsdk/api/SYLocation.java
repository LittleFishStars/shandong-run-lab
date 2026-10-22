package com.ltmb.ltadsdk.api;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/ltmb/ltadsdk/api/SYLocation;", "", "", "getSendProvider", "a", "I", "getProvider", "()I", "setProvider", "(I)V", "provider", "", "b", "D", "getLatitude", "()D", "setLatitude", "(D)V", "latitude", "c", "getLongitude", "setLongitude", "longitude", "", "d", "J", "getLocationTime", "()J", "setLocationTime", "(J)V", "locationTime", "<init>", "(IDDJ)V", "Companion", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYLocation {
    public static final int PROVIDER_BD = 2;
    public static final int PROVIDER_GD = 1;
    public static final int PROVIDER_SYSTEM = 4;
    public static final int PROVIDER_TX = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int provider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public double latitude;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public double longitude;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public long locationTime;

    public SYLocation() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, 15, null);
    }

    public SYLocation(int i, double d, double d2, long j) {
        this.provider = i;
        this.latitude = d;
        this.longitude = d2;
        this.locationTime = j;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final long getLocationTime() {
        return this.locationTime;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int getProvider() {
        return this.provider;
    }

    public final int getSendProvider() {
        int i = this.provider;
        if (i == 1 || i == 3) {
            return 0;
        }
        return i == 2 ? 2 : 1;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final void setLocationTime(long j) {
        this.locationTime = j;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public final void setProvider(int i) {
        this.provider = i;
    }

    public /* synthetic */ SYLocation(int i, double d, double d2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0d : d, (i2 & 4) == 0 ? d2 : AudioStats.AUDIO_AMPLITUDE_NONE, (i2 & 8) != 0 ? 0L : j);
    }
}
