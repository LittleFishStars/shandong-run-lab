package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.c;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface AdHttpProxy {
    c doGet(String str, Map<String, String> map);

    c doGetWithoutResponse(String str, Map<String, String> map, boolean z);

    c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder);

    c doPost(String str, Map<String, String> map, Map<String, String> map2);

    c doPost(String str, Map<String, String> map, JSONObject jSONObject);

    boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, @Nullable AdHttpResponseListener adHttpResponseListener);
}
