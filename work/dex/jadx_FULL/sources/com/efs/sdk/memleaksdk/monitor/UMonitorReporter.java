package com.efs.sdk.memleaksdk.monitor;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface UMonitorReporter {
    void onJavaHeap(File file, JSONObject jSONObject);
}
