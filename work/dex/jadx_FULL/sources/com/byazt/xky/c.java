package com.byazt.xky;

import android.content.Context;
import com.byazt.bzd.sl;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.oz.n;
import com.byazt.rc.uj;
import com.byazt.yj.a;
import com.byazt.yj.my;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 169, 20})
public class c {
    public static com.byazt.lz.ve c() {
        return new com.byazt.lz.ve() { // from class: com.byazt.xky.c.1
            @Override // com.byazt.lz.ve
            public boolean a() {
                return p.ve;
            }

            @Override // com.byazt.lz.ve
            public com.byazt.dna.c c() {
                return com.byazt.vxy.c.n();
            }

            @Override // com.byazt.lz.ve
            public boolean n() {
                return gt.tt().mk();
            }

            @Override // com.byazt.lz.ve
            public Map<String, Object> sp() {
                return com.byazt.qh.ve.da();
            }

            @Override // com.byazt.lz.ve
            public int tt() {
                return 7611;
            }

            @Override // com.byazt.lz.ve
            public boolean uj() {
                return x.m().d();
            }

            @Override // com.byazt.lz.ve
            public int ve() {
                return p.uj;
            }

            @Override // com.byazt.lz.ve
            public boolean x() {
                return false;
            }
        };
    }

    public static Context getContext() {
        return gt.getContext();
    }

    public static my tt() {
        return new n.c().c(new com.byazt.ep.c(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, CachedContentIndex.f31137a), 5242880), 524288, 41943040L, true, true, new File(sl.a()))).c(com.byazt.bwm.n.c()).c(new com.byazt.yj.n() { // from class: com.byazt.xky.c.2
            private Map<String, String> c(a aVar, m mVar) {
                HashMap map = new HashMap();
                if (aVar.tt()) {
                    com.byazt.gqp.a aVarSp = mVar.sp();
                    int iC = aVarSp.c();
                    for (int i = 0; i < iC; i++) {
                        String strC = aVarSp.c(i);
                        String strTt = aVarSp.tt(i);
                        if (strC != null) {
                            map.put(strC, strTt);
                        }
                    }
                }
                return map;
            }

            @Override // com.byazt.yj.n
            public uj call(a aVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                t tVarA = com.byazt.hy.n.c().tt().a();
                yp ypVarTt = new yp.c().c(aVar.c()).c().c("csj_client_source_from", "2").tt();
                m mVar = null;
                com.byazt.rc.n nVar = aVar.ve() ? new com.byazt.rc.n() : null;
                if (nVar != null) {
                    nVar.c(jCurrentTimeMillis);
                }
                try {
                    m mVarTt = tVarA.c(ypVarTt).tt();
                    if (nVar != null) {
                        try {
                            nVar.tt(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            mVar = mVarTt;
                            try {
                                return c(nVar, th);
                            } finally {
                                com.byazt.as.tt.c(mVar);
                            }
                        }
                    }
                    if (aVar.uj() != null) {
                        aVar.uj().onStep(3, null);
                    }
                    Map<String, String> mapC = c(aVar, mVarTt);
                    byte[] bArrUj = mVarTt.a().uj();
                    mapC.put("image_size", String.valueOf(bArrUj == null ? 0 : bArrUj.length));
                    uj ujVar = new uj(mVarTt.ve(), bArrUj, "", mapC);
                    if (nVar != null) {
                        nVar.ve(System.currentTimeMillis());
                    }
                    ujVar.c(nVar);
                    com.byazt.as.tt.c(mVarTt);
                    return ujVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private uj c(com.byazt.rc.n nVar, Throwable th) {
                com.byazt.nr.m.tt("ImageConfig", th.getMessage());
                if (nVar != null) {
                    nVar.ve(System.currentTimeMillis());
                }
                uj ujVar = new uj(0, th, "net failed");
                ujVar.c(nVar);
                return ujVar;
            }
        }).c();
    }
}
