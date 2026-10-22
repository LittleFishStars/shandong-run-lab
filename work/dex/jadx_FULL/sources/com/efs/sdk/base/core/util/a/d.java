package com.efs.sdk.base.core.util.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f29615a;
    private List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> b;

    public d(@NonNull String str) {
        b bVar = new b();
        this.f29615a = bVar;
        bVar.f29613a = str;
    }

    public final d a(@NonNull Map<String, String> map) {
        this.f29615a.b = map;
        return this;
    }

    public final d a(String str, String str2) {
        b bVar = this.f29615a;
        if (bVar.f == null) {
            bVar.f = new HashMap(5);
        }
        this.f29615a.f.put(str, str2);
        return this;
    }

    public final d a(@NonNull AbsHttpListener absHttpListener) {
        if (this.b == null) {
            this.b = new ArrayList(5);
        }
        this.b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.f29615a);
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> list = this.b;
        if (list != null && list.size() > 0) {
            cVar.a(this.b);
        }
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
