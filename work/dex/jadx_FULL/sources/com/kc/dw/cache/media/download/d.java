package com.kc.dw.cache.media.download;

import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.b.a f39228a;
    public final long b;
    public final String c;
    public final Object d;
    public final RandomAccessFile e;
    public final c.b f;

    public d(c.b bVar, c.b.a aVar, long j, String str, Object obj, RandomAccessFile randomAccessFile) {
        this.f = bVar;
        this.f39228a = aVar;
        this.b = j;
        this.c = str;
        this.d = obj;
        this.e = randomAccessFile;
    }

    public void onFailure(Call call, IOException iOException) {
        c.b.a aVar = this.f39228a;
        if (aVar != null) {
            ((c.a) aVar).a(2, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    public void onResponse(Call call, Response response) throws IOException {
        boolean z;
        long j;
        try {
            LogUtil.d("c", "onResponse code:" + response.code());
            if (response.code() == 404 || response.code() >= 500) {
                c.b.a aVar = this.f39228a;
                if (aVar != null) {
                    ((c.a) aVar).a(3, "resp code：" + response.code());
                }
            } else {
                this.f.f39227a = response.body().byteStream();
                Headers headers = response.headers();
                if (headers == null || headers.size() == 0) {
                    z = false;
                } else {
                    String str = headers.get("Accept-Ranges");
                    String str2 = headers.get("Content-Range");
                    if ("bytes".equalsIgnoreCase(str) || !TextUtils.isEmpty(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                long jContentLength = response.body().contentLength();
                if (z) {
                    j = this.b;
                    jContentLength += j;
                } else {
                    LogUtil.e("c", "service don`t support range. " + this.c);
                    j = 0;
                }
                c.b.a aVar2 = this.f39228a;
                if (aVar2 != null) {
                    c.a aVar3 = (c.a) aVar2;
                    aVar3.f39226a.i = z;
                    aVar3.f39226a.h = jContentLength;
                    f fVar = aVar3.f39226a.k;
                    if (fVar != null) {
                        fVar.a(jContentLength);
                    }
                }
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = this.f.f39227a.read(bArr, 0, 8192);
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (this.d) {
                        this.e.seek(j);
                        this.e.write(bArr, 0, i2);
                    }
                    j += (long) i2;
                    c.b.a aVar4 = this.f39228a;
                    if (aVar4 != null && j >= ((long) i) * 8192 * 2) {
                        i++;
                        int iFloor = (int) Math.floor((j / jContentLength) * 100.0d);
                        f fVar2 = ((c.a) aVar4).f39226a.k;
                        if (fVar2 != null) {
                            fVar2.a(j, iFloor);
                        }
                    }
                }
                LogUtil.dev("c", "download finish. isSupportRange:" + z + "  rangeStart:" + this.b + " location:" + j);
                c.b.a aVar5 = this.f39228a;
                if (aVar5 != null) {
                    f fVar3 = ((c.a) aVar5).f39226a.k;
                    if (fVar3 != null) {
                        fVar3.a(j, 100);
                    }
                    c.a aVar6 = (c.a) this.f39228a;
                    aVar6.f39226a.close();
                    f fVar4 = aVar6.f39226a.k;
                    if (fVar4 != null) {
                        fVar4.a();
                    }
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                String str3 = "unknown0.";
                try {
                    str3 = "unknown0." + th.toString();
                } catch (Exception unused) {
                }
                c.b.a aVar7 = this.f39228a;
                if (aVar7 != null) {
                    ((c.a) aVar7).a(9, str3);
                }
            } finally {
                this.f.a();
            }
        }
    }
}
