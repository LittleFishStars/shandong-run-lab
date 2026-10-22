package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends AbsHttpListener {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29561a = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* bridge */ /* synthetic */ void a(@NonNull com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, @Nullable HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@NonNull HttpResponse httpResponse) {
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = Integer.parseInt(str);
            f fVar = f.a.f29604a;
            if (fVar.b == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "config_coverage", fVar.f29603a.c);
            bVar.put("cver", Integer.valueOf(i));
            fVar.b.send(bVar);
        }
    }

    private b() {
    }

    public static b a() {
        return a.f29561a;
    }

    private static void a(@NonNull HttpResponse httpResponse) {
        f.a.f29604a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
