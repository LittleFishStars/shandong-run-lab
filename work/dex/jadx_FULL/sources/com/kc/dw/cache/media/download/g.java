package com.kc.dw.cache.media.download;

import com.huachenjie.common.constants.ErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f39231a = new ConcurrentHashMap<>();

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f39232a = -2147483648L;
        public long b = -2147483648L;
        public boolean c = true;
        public int d;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004f A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:9:0x0023, B:11:0x0027, B:14:0x0030, B:17:0x0038, B:19:0x003e, B:23:0x004f, B:25:0x0056, B:27:0x005a, B:30:0x006a), top: B:41:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    public boolean a(String str, long j, long j2, int i) {
        a aVar;
        long j3;
        long jMax;
        if (str == null) {
            str = "";
        }
        if (this.f39231a.containsKey(str)) {
            aVar = this.f39231a.get(str);
        } else {
            a aVar2 = new a();
            this.f39231a.put(str, aVar2);
            aVar = aVar2;
        }
        aVar.getClass();
        try {
            if (aVar.d == 0) {
                aVar.d = i;
            }
            boolean z = true;
            if (j2 > 0) {
                long j4 = aVar.b;
                int i2 = aVar.d;
                if (i2 == 0) {
                    i2 = ErrorCode.CHECK_START_RUN_ERROR.f;
                }
                if (j <= ((long) i2) + j4 || j <= (j2 / 4) * 3) {
                    j3 = aVar.f39232a;
                    if (j3 != 0 && aVar.c) {
                        aVar.c = false;
                        aVar.f39232a = j;
                        aVar.b = Math.max(aVar.b, j);
                        return false;
                    }
                    z = j3 != 0 && j > aVar.b;
                    aVar.f39232a = j;
                    jMax = Math.max(aVar.b, j);
                } else {
                    aVar.f39232a = j;
                    jMax = Math.max(j4, j);
                }
            } else {
                j3 = aVar.f39232a;
                if (j3 != 0) {
                }
                if (j3 != 0) {
                }
                aVar.f39232a = j;
                jMax = Math.max(aVar.b, j);
            }
            aVar.b = jMax;
            return z;
        } catch (Throwable th) {
            aVar.f39232a = j;
            aVar.b = Math.max(aVar.b, j);
            throw th;
        }
    }
}
