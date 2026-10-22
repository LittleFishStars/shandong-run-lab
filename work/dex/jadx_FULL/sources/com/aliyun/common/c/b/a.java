package com.aliyun.common.c.b;

import android.content.Context;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends f {
    public a(Context context, String str) {
        AlivcEventReporter alivcEventReporterA = g.a(context);
        this.f25568a = alivcEventReporterA;
        if (alivcEventReporterA != null) {
            alivcEventReporterA.c(str);
            this.f25568a.d("crop");
        }
    }

    public int a(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("errorCode", String.valueOf(i));
        a(8003, map);
        return 0;
    }

    public int b(HashMap<String, String> map) {
        a(AVMDLDataLoader.KeyIsLiveGetCurrentBitRate, map);
        return 0;
    }

    public int c() {
        a(8002, new HashMap<>());
        return 0;
    }
}
