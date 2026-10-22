package com.zj.adlib;

import androidx.camera.video.AudioStats;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0005\"\u0018\u0010\n\u001a\u00020\b*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\t*\u001c\b\u0002\u0010\f\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b2\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b*\u001c\b\u0002\u0010\u000e\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r2\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r*\u001c\b\u0002\u0010\u0010\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f2\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f*\u001c\b\u0002\u0010\u0012\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011¨\u0006\u0013"}, d2 = {"", "a", "F", "RUNNING_ROUTE_WIDTH_DP", "", "Ljava/lang/String;", "RUNNING_ROUTE_COLOR", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "", "(Lhuachenjie/sdk/map/lib_base/HCJLatLng;)Z", "isValid", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoBitmapDescriptor;", "OverlayIcon", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", "OverlayMarker", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "OverlayPolyline", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolylineOptions;", "OverlayPolylineOptions", "run_release"}, k = 2, mv = {1, 8, 0})
public final class xj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f45832a = 4.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f20670a = "#FF3BCD69";

    public static final boolean a(@NotNull HCJLatLng hCJLatLng) {
        Intrinsics.checkNotNullParameter(hCJLatLng, "<this>");
        return !(hCJLatLng.lat == AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
