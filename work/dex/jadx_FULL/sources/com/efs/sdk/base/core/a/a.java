package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    private static volatile long b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29559a;

    /* JADX INFO: renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    public static class C0619a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f29560a = new a(0);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0619a.f29560a;
    }

    public static long b() {
        return b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + b;
    }

    private a() {
        this.f29559a = true;
    }

    @NonNull
    public final HttpResponse a(String str, c cVar, File file, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.f29559a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        dVarA.f29615a.d = file;
        com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVar.h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.o);
        return dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    @NonNull
    public final HttpResponse a(@NonNull String str, @NonNull c cVar, @NonNull byte[] bArr, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.f29559a) {
            Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        com.efs.sdk.base.core.util.a.b bVar = dVarA.f29615a;
        bVar.c = bArr;
        bVar.g = true;
        com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVar.h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.o);
        return dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    private static String a(@NonNull String str, @NonNull c cVar) {
        String str2;
        byte b2 = cVar.g;
        if (b2 == 1) {
            str2 = "/apm_logs";
        } else if (b2 != 2) {
            str2 = b2 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload";
        } else {
            str2 = "/perf_upload";
        }
        return str + str2;
    }

    public static void a(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j - b()) > 1500000) {
                b = j - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }
}
