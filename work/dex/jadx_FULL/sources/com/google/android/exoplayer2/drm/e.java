package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.ar8;
import com.zj.adlib.b72;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.ze1;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements MediaDrmCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30608a = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f2681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f2682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f2683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2684a;

    public e(@Nullable String str, DataSource.Factory factory) {
        this(str, false, factory);
    }

    public static byte[] e(DataSource.Factory factory, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        ar8 ar8Var = new ar8(factory.a());
        DataSpec dataSpecA = new DataSpec.b().k(str).f(map).e(2).d(bArr).c(1).a();
        int i = 0;
        DataSpec dataSpecA2 = dataSpecA;
        while (true) {
            try {
                b72 b72Var = new b72(ar8Var, dataSpecA2);
                try {
                    try {
                        byte[] bArrB1 = gj9.B1(b72Var);
                        gj9.p(b72Var);
                        return bArrB1;
                    } catch (HttpDataSource.InvalidResponseCodeException e) {
                        String strF = f(e, i);
                        if (strF == null) {
                            throw e;
                        }
                        i++;
                        dataSpecA2 = dataSpecA2.a().k(strF).a();
                        gj9.p(b72Var);
                    }
                } catch (Throwable th) {
                    gj9.p(b72Var);
                    throw th;
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(dataSpecA, (Uri) sb0.g(ar8Var.g()), ar8Var.getResponseHeaders(), ar8Var.d(), e2);
            }
        }
    }

    @Nullable
    public static String f(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
        Map<String, List<String>> map;
        List<String> list;
        int i2 = invalidResponseCodeException.responseCode;
        if (!((i2 == 307 || i2 == 308) && i < 5) || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String strB = keyRequest.b();
        if (this.f2684a || TextUtils.isEmpty(strB)) {
            strB = this.f2682a;
        }
        if (TextUtils.isEmpty(strB)) {
            throw new MediaDrmCallbackException(new DataSpec.b().j(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.f2008e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.f2002c.equals(uuid) ? ze1.g : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        map.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f2683a) {
            map.putAll(this.f2683a);
        }
        return e(this.f2681a, strB, keyRequest.a(), map);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] b(UUID uuid, ExoMediaDrm.c cVar) throws MediaDrmCallbackException {
        return e(this.f2681a, cVar.b() + "&signedRequest=" + gj9.I(cVar.a()), null, Collections.emptyMap());
    }

    public void c() {
        synchronized (this.f2683a) {
            this.f2683a.clear();
        }
    }

    public void d(String str) {
        sb0.g(str);
        synchronized (this.f2683a) {
            this.f2683a.remove(str);
        }
    }

    public void g(String str, String str2) {
        sb0.g(str);
        sb0.g(str2);
        synchronized (this.f2683a) {
            this.f2683a.put(str, str2);
        }
    }

    public e(@Nullable String str, boolean z, DataSource.Factory factory) {
        sb0.a((z && TextUtils.isEmpty(str)) ? false : true);
        this.f2681a = factory;
        this.f2682a = str;
        this.f2684a = z;
        this.f2683a = new HashMap();
    }
}
