package com.alibaba.appmonitor.event;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends d {
    public int count;
    public double value;

    public synchronized void a(double d, Long l) {
        this.value += d;
        this.count++;
        super.c(l);
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public synchronized void fill(Object... objArr) {
        super.fill(objArr);
        this.value = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.count = 0;
    }

    @Override // com.alibaba.appmonitor.event.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        jSONObjectA.put("count", (Object) Integer.valueOf(this.count));
        jSONObjectA.put("value", (Object) Double.valueOf(this.value));
        return jSONObjectA;
    }
}
