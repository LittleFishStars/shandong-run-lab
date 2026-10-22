package com.alibaba.ariver.commonability.core.b.a;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends c {
    @Override // com.alibaba.ariver.commonability.core.b.a.c
    public void a(com.alibaba.ariver.commonability.core.a.a aVar, float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", (Object) Float.valueOf((-f) / 10.0f));
        jSONObject.put("y", (Object) Float.valueOf((-f2) / 10.0f));
        jSONObject.put(j.o, (Object) Float.valueOf((-f3) / 10.0f));
        aVar.a(jSONObject, 1);
    }
}
