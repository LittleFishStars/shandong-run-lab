package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface TraceStatusListener {
    void onTraceStatus(List<TraceLocation> list, List<LatLng> list2, String str);
}
