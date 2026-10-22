package com.kc.dw.cache.media.download;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f39233a = new ConcurrentHashMap<>();

    @Keep
    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39234a;

        public a(String str) {
            this.f39234a = str;
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a() {
            try {
                h.f39233a.remove(this.f39234a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(int i, String str) {
            try {
                h.f39233a.remove(this.f39234a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j) {
        }

        @Override // com.kc.dw.cache.media.download.f
        public void a(long j, int i) {
        }
    }

    public static b a(String str, f fVar) {
        try {
            String strB = com.kc.dw.core.bquery.c.b(str);
            ConcurrentHashMap<String, b> concurrentHashMap = f39233a;
            if (concurrentHashMap.containsKey(strB)) {
                b bVar = concurrentHashMap.get(strB);
                bVar.a(fVar);
                return bVar;
            }
            b bVarA = new e(str, new a(strB)).a(fVar);
            concurrentHashMap.put(strB, bVarA);
            ((e) bVarA).c();
            return bVarA;
        } catch (Throwable th) {
            th.printStackTrace();
            fVar.a(9, "unknown4." + str);
            return null;
        }
    }
}
