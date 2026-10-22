package com.zj.adlib;

import com.amap.api.maps.model.LatLng;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/zj/adlib/gz3;", "", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", SQLiteMTAHelper.TABLE_POINT, "Lcom/amap/api/maps/model/LatLng;", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class gz3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final gz3 f42014a = new gz3();

    @Nullable
    public final LatLng a(@Nullable HCJLatLng point) {
        if (point == null) {
            return null;
        }
        return new LatLng(point.lat, point.lng);
    }
}
