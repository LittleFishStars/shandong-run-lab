package com.kc.dw.cache.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.kc.dw.cache.d;
import com.kc.dw.core.bquery.f;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.x;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f39220a;

    @Keep
    public class a implements f<File> {
        public a(b bVar) {
        }

        public void a(int i, String str) {
            ConcurrentHashMap<String, com.kc.dw.cache.image.a> concurrentHashMap = com.kc.dw.cache.b.f39219a;
            LogUtil.w("b", "image file save error");
        }
    }

    public b(c cVar) {
        this.f39220a = cVar;
    }

    @Override // com.kc.dw.core.utils.x
    public void onFailure(IOException iOException) {
        c.a(this.f39220a, 2);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    @Override // com.kc.dw.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        int i;
        try {
            if (httpResponse.isSuccessful()) {
                c cVar = this.f39220a;
                synchronized (cVar.c) {
                    Iterator<SoftReference<d>> it = cVar.f39221a.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().get().a();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    i = 3;
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray != null) {
                        com.kc.dw.core.bquery.c.a(this.f39220a.b, responseBody, new a(this));
                        c.a(this.f39220a, bitmapDecodeByteArray, responseBody);
                        return;
                    }
                    i = 4;
                }
            } else {
                i = 3;
            }
            c.a(this.f39220a, i);
        } catch (Throwable unused) {
            c.a(this.f39220a, 9);
        }
    }
}
