package com.byazt.va;

import android.text.TextUtils;
import com.byazt.gqp.a;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 116, 20})
public class c extends uj {
    public c(t tVar) {
        super(tVar);
    }

    public void c(final com.byazt.mh.c cVar) {
        try {
            yp.c cVar2 = new yp.c();
            cVar2.c((Object) tt());
            tt("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.f29124a)) {
                cVar.c(this, new IOException("Url is Empty"));
                return;
            }
            cVar2.c(this.f29124a);
            c(cVar2);
            this.ve.c(cVar2.c().tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.va.c.1
                @Override // com.byazt.gqp.ve
                public void onFailure(com.byazt.gqp.tt ttVar, IOException iOException) {
                    com.byazt.mh.c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.c(c.this, iOException);
                    }
                }

                @Override // com.byazt.gqp.ve
                public void onResponse(com.byazt.gqp.tt ttVar, m mVar) throws IOException {
                    if (cVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (mVar == null) {
                        return;
                    }
                    com.byazt.hm.tt ttVar2 = new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, null, mVar.tt(), mVar.c());
                    if (!mVar.uj()) {
                        cVar.c(c.this, ttVar2);
                        return;
                    }
                    InputStream inputStream = null;
                    try {
                        a aVarSp = mVar.sp();
                        if (aVarSp != null) {
                            for (int i = 0; i < aVarSp.c(); i++) {
                                map.put(aVarSp.c(i), aVarSp.tt(i));
                            }
                        }
                        int iIntValue = Long.valueOf(mVar.a().c()).intValue();
                        byte[] bArr = new byte[iIntValue];
                        InputStream inputStreamVe = mVar.a().ve();
                        try {
                            if (inputStreamVe.read(bArr) == iIntValue) {
                                ttVar2.c(bArr);
                            } else {
                                ttVar2 = new com.byazt.hm.tt(false, mVar.ve(), "Byte opt fail", map, null, mVar.tt(), mVar.c());
                            }
                            cVar.c(c.this, ttVar2);
                            try {
                                inputStreamVe.close();
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamVe;
                            try {
                                com.byazt.nr.m.c(th);
                                cVar.c(c.this, new IOException(th.getMessage()));
                            } finally {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            });
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    @Override // com.byazt.va.uj
    public com.byazt.hm.tt c() {
        InputStream inputStreamVe;
        try {
            yp.c cVar = new yp.c();
            cVar.c((Object) tt());
            tt("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.f29124a)) {
                com.byazt.nr.m.uj("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            cVar.c(this.f29124a);
            c(cVar);
            m mVarTt = this.ve.c(cVar.c().tt()).tt();
            if (mVarTt == null || !mVarTt.uj()) {
                return null;
            }
            HashMap map = new HashMap();
            a aVarSp = mVarTt.sp();
            if (aVarSp != null) {
                for (int i = 0; i < aVarSp.c(); i++) {
                    map.put(aVarSp.c(i), aVarSp.tt(i));
                }
            }
            long jC = mVarTt.a().c();
            byte[] bArr = new byte[Long.valueOf(jC).intValue()];
            inputStreamVe = mVarTt.a().ve();
            try {
                if (inputStreamVe.read(bArr) == jC) {
                    com.byazt.hm.tt ttVar = new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, null, mVarTt.tt(), mVarTt.c());
                    ttVar.c(bArr);
                    try {
                        inputStreamVe.close();
                    } catch (Throwable unused) {
                    }
                    return ttVar;
                }
                com.byazt.hm.tt ttVar2 = new com.byazt.hm.tt(false, mVarTt.ve(), "Byte opt fail", map, null, mVarTt.tt(), mVarTt.c());
                try {
                    inputStreamVe.close();
                } catch (Throwable unused2) {
                }
                return ttVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    com.byazt.nr.m.c(th);
                    return null;
                } finally {
                    if (inputStreamVe != null) {
                        try {
                            inputStreamVe.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamVe = null;
        }
    }
}
