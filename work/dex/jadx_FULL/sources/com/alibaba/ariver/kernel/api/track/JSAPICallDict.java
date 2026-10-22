package com.alibaba.ariver.kernel.api.track;

import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class JSAPICallDict {
    private final Map<String, JSAPICallRecord> mMap = new ConcurrentHashMap();

    @Nullable
    public JSAPICallRecord getRecord(String str) {
        return this.mMap.get(str);
    }

    public List<JSAPICallRecord> getRecords() {
        return new ArrayList(this.mMap.values());
    }

    public JSAPICallRecord newRecord(String str, String str2, boolean z) {
        JSAPICallRecord jSAPICallRecord = new JSAPICallRecord(EventTrackerUtils.getTrackerIdWithIndex(TrackId.Stub_API_CALL, str2), str2);
        if (z) {
            jSAPICallRecord.setStart(SystemClock.elapsedRealtime());
        }
        this.mMap.put(str, jSAPICallRecord);
        return jSAPICallRecord;
    }

    public int size() {
        return this.mMap.size();
    }

    public Map<String, String> toMap() {
        HashMap map = new HashMap();
        for (JSAPICallRecord jSAPICallRecord : this.mMap.values()) {
            map.put(jSAPICallRecord.getTrackId(), jSAPICallRecord.toString());
        }
        return map;
    }
}
