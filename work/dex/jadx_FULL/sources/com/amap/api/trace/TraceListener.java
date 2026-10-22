package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface TraceListener {
    void onFinished(int i, List<LatLng> list, int i2, int i3);

    void onRequestFailed(int i, String str);

    void onTraceProcessing(int i, int i2, List<LatLng> list);
}
