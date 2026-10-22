package com.alibaba.triver.open.prefetch.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.open.prefetch.context.HttpPrefetchContext;
import com.alibaba.triver.open.prefetch.context.ImagePrefetchContext;
import com.alibaba.triver.open.prefetch.context.MtopPrefetchContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    public static c a(String str, JSONObject jSONObject, PrefectchCallback prefectchCallback) {
        byte b;
        ImagePrefetchContext imagePrefetchContext;
        try {
            String string = jSONObject.getString("type");
            int iHashCode = string.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode != 3362248) {
                    if (iHashCode == 100313435 && string.equals("image")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (string.equals("mtop")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (string.equals("http")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                MtopPrefetchContext mtopPrefetchContext = (MtopPrefetchContext) JSON.toJavaObject(jSONObject, MtopPrefetchContext.class);
                if (mtopPrefetchContext != null) {
                    return new MtopPrefetchTask(mtopPrefetchContext, prefectchCallback);
                }
                return null;
            }
            if (b != 1) {
                if (b == 2 && (imagePrefetchContext = (ImagePrefetchContext) JSON.toJavaObject(jSONObject, ImagePrefetchContext.class)) != null) {
                    return new b(imagePrefetchContext, prefectchCallback);
                }
                return null;
            }
            HttpPrefetchContext httpPrefetchContext = (HttpPrefetchContext) JSON.toJavaObject(jSONObject, HttpPrefetchContext.class);
            if (httpPrefetchContext != null) {
                return new a(httpPrefetchContext, prefectchCallback);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
