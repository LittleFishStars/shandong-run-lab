package com.byazt.gu;

import android.text.TextUtils;
import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.p;
import com.byazt.eg.qy;
import com.byazt.eg.rl;
import com.byazt.eg.yv;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 34})
public class a extends t {
    public gu t;
    public com.byazt.gqp.uj u;

    public a(t.c cVar) {
        super(cVar);
        c(cVar);
        this.u = new sp(this.t);
    }

    private void c(t.c cVar) {
        gu.c cVar2 = new gu.c();
        cVar2.gr = (int) cVar.ve;
        cVar2.d = cVar.uj;
        cVar2.zm = (int) cVar.n;
        cVar2.eo = cVar.f28585a;
        cVar2.yv = (int) cVar.sp;
        cVar2.zb = cVar.x;
        cVar2.h = cVar.da;
        cVar2.md = cVar.sl;
        cVar2.c(new ve(cVar.tt));
        List<com.byazt.gqp.i> list = cVar.c;
        if (list != null && !list.isEmpty()) {
            for (final com.byazt.gqp.i iVar : list) {
                cVar2.c(new gt() { // from class: com.byazt.gu.a.1
                    @Override // com.byazt.eg.gt
                    public h c(gt.c cVar3) throws IOException {
                        return ((i) iVar.c(new n(cVar3))).c;
                    }
                });
            }
        }
        this.t = cVar2.c();
    }

    private boolean tt(z zVar) {
        byte[] bArr;
        return zVar != null && zVar.f28588a == z.c.BYTE_ARRAY_TYPE && (bArr = zVar.n) != null && bArr.length > 0;
    }

    private boolean ve(z zVar) {
        return (zVar == null || zVar.f28588a != z.c.STRING_TYPE || TextUtils.isEmpty(zVar.uj)) ? false : true;
    }

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.uj c() {
        return this.u;
    }

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.tt c(yp ypVar) {
        if (ypVar == null) {
            return null;
        }
        yv.c cVar = new yv.c();
        cVar.c(ypVar.c());
        if (ypVar.tt() != null) {
            cVar.c(ypVar.tt().c());
        }
        if (ypVar.a() != null) {
            if (ve(ypVar.a())) {
                cVar.c(ypVar.ve(), p.c(rl.c(ypVar.a().ve.toString()), ypVar.a().uj));
            } else if (c(ypVar.a())) {
                cVar.c(ypVar.ve(), new qy.c().c(qy.n).c(ypVar.a().tt(), ypVar.a().c(), p.c(rl.c("multipart/form-data"), ypVar.a().n)).c());
            } else if (tt(ypVar.a())) {
                cVar.c(ypVar.ve(), p.c(rl.c(ypVar.a().ve.toString()), ypVar.a().n));
            }
        }
        if (ypVar.n() != null && ypVar.n().c) {
            cVar.c(new com.byazt.eg.uj.c().c().ve());
        }
        if (ypVar.uj() != null && ypVar.uj().size() > 0) {
            for (Map.Entry<String, List<String>> entry : ypVar.uj().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    cVar.c(entry.getKey(), it.next());
                }
            }
        }
        return new uj(this.t.c(cVar.c()));
    }

    private boolean c(z zVar) {
        byte[] bArr;
        return zVar != null && zVar.f28588a == z.c.FILE_TYPE && (bArr = zVar.n) != null && bArr.length > 0;
    }
}
