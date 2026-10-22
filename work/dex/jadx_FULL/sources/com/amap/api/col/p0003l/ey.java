package com.amap.api.col.p0003l;

import android.content.Context;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.amap.api.maps.AMapException;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.c4b;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.q4b;
import com.zj.adlib.qwb;
import com.zj.adlib.r4b;
import com.zj.adlib.zwa;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ey<T, V> extends db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f25936a;
    public Context b;
    public String f;
    public int K = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f835b = false;

    public ey(Context context, T t) {
        c(context, t);
    }

    private void c(Context context, T t) {
        this.b = context;
        this.f25936a = t;
        this.K = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V n() throws ex {
        V vD = null;
        int i = 0;
        while (i < this.K) {
            try {
                setProxy(q4b.c(this.b));
                vD = this.f835b ? d(makeHttpRequestNeedHeader()) : e(makeHttpRequest());
                i = this.K;
            } catch (ex e) {
                i++;
                if (i >= this.K) {
                    throw new ex(e.a());
                }
            } catch (ff e2) {
                i++;
                if (i >= this.K) {
                    if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e2.a()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new ex("http或socket连接失败 - ConnectionException");
                    }
                    throw new ex(e2.a());
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new ex("http或socket连接失败 - ConnectionException");
                    }
                    throw new ex(e2.a());
                }
            } catch (Throwable unused2) {
                throw new ex(AlibcProtocolConstant.UNKNOWN_ERROR);
            }
        }
        return vD;
    }

    public V a(i9b i9bVar) throws ex {
        return null;
    }

    public abstract V a(String str) throws ex;

    public V a(byte[] bArr) throws ex {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        c4b.c(str);
        return a(str);
    }

    public abstract String c();

    public final V d(i9b i9bVar) throws ex {
        return a(i9bVar);
    }

    public final V e(byte[] bArr) throws ex {
        return a(bArr);
    }

    @Override // com.amap.api.col.p0003l.hs
    public Map<String, String> getRequestHead() {
        r4b r4bVarT = zwa.t();
        String strE = r4bVarT != null ? r4bVarT.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", qwb.b);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", strE, "3dmap"));
        hashtable.put("X-INFO", l4b.i(this.b));
        hashtable.put(CachedContentIndex.a.e, j4b.j(this.b));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public final V m() throws ex {
        if (this.f25936a == null) {
            return null;
        }
        try {
            return n();
        } catch (ex e) {
            zwa.D(e);
            throw e;
        }
    }
}
