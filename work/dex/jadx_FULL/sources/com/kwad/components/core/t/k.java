package com.kwad.components.core.t;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k {
    private static final ConcurrentHashMap<Integer, a> alD = new ConcurrentHashMap<>();
    public static final long alE = com.kwad.sdk.core.config.e.KJ().longValue() * 1000;
    private static final Map<Integer, bi> alF = new ConcurrentHashMap();
    private static Map<Integer, Long> alG = new HashMap();

    public static class a {
        private long Kk;
        private final com.kwad.sdk.components.t alI;
        private final AtomicInteger alJ;
        private long alK;
        private long alL;
        private long alM;

        public a(com.kwad.sdk.components.t tVar, long j, long j2, long j3, long j4) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.alJ = atomicInteger;
            this.alI = tVar;
            atomicInteger.set(1);
            this.alK = j;
            this.Kk = j2;
            this.alL = j3;
            this.alM = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wS() {
            this.alJ.incrementAndGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int wT() {
            return this.alJ.decrementAndGet();
        }

        public final long wN() {
            return this.alK;
        }

        public final long wO() {
            return this.Kk;
        }

        public final long wP() {
            return this.alL;
        }

        public final long wQ() {
            return this.alM;
        }

        public final com.kwad.sdk.components.t wR() {
            return this.alI;
        }
    }

    public static void a(Integer num, com.kwad.sdk.components.t tVar, long j, long j2, long j3, long j4) {
        if (tVar == null && (num == null || num.intValue() == 0)) {
            return;
        }
        try {
            e(num);
            ConcurrentHashMap<Integer, a> concurrentHashMap = alD;
            a aVar = concurrentHashMap.get(num);
            if (aVar != null) {
                aVar.wS();
            } else {
                concurrentHashMap.put(num, new a(tVar, j, j2, j3, j4));
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    @Nullable
    public static a b(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = alD.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.wS();
                return aVar;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static void c(Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        try {
            a aVar = alD.get(num);
            if (aVar == null || aVar.wT() != 0) {
                return;
            }
            d(num);
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static void d(final Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        e(num);
        bi biVar = new bi() { // from class: com.kwad.components.core.t.k.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a aVar = (a) k.alD.get(num);
                if (aVar != null) {
                    aVar.alI.onDestroy();
                }
                k.alG.remove(num);
                k.alD.remove(num);
            }
        };
        alF.put(num, biVar);
        by.runOnUiThreadDelay(biVar, alE);
    }

    private static void e(Integer num) {
        Map<Integer, bi> map = alF;
        bi biVar = map.get(num);
        if (biVar != null) {
            by.b(biVar);
            map.remove(num);
        }
    }

    @Nullable
    public static com.kwad.sdk.components.t a(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = alD.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.wS();
                return aVar.alI;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }
}
