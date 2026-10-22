package com.zj.adlib;

import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.huachenjie.common.bean.GeoFenceDetail;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¨\u0006\f"}, d2 = {"Lcom/zj/adlib/ye3;", "", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", SQLiteMTAHelper.TABLE_POINT, "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "geoFenceList", "", "", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFenceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FenceUtils.kt\ncom/huachenjie/run/utils/FenceUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,26:1\n1855#2,2:27\n*S KotlinDebug\n*F\n+ 1 FenceUtils.kt\ncom/huachenjie/run/utils/FenceUtils\n*L\n18#1:27,2\n*E\n"})
public final class ye3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ye3 f46013a = new ye3();

    @Nullable
    public final Map<String, GeoFenceDetail> a(@Nullable HCJLatLng point, @Nullable List<? extends GeoFenceDetail> geoFenceList) {
        HashMap map = new HashMap();
        List<? extends GeoFenceDetail> list = geoFenceList;
        if (list == null || list.isEmpty()) {
            return map;
        }
        HCJMapUtils hCJMapUtilsCreateMapUtils = HCJMapEntry.getInstance().createMapUtils();
        Intrinsics.checkNotNullExpressionValue(hCJMapUtilsCreateMapUtils, "getInstance().createMapUtils()");
        if (geoFenceList != null) {
            for (GeoFenceDetail geoFenceDetail : geoFenceList) {
                if (hCJMapUtilsCreateMapUtils.containsLocation(point, geoFenceDetail.getFenceList(), false)) {
                    String fenceCode = geoFenceDetail.getFenceCode();
                    Intrinsics.checkNotNullExpressionValue(fenceCode, "it.fenceCode");
                    map.put(fenceCode, geoFenceDetail);
                }
            }
        }
        return map;
    }
}
