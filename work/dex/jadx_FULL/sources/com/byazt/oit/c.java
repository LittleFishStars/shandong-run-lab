package com.byazt.oit;

import android.content.Context;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.byazt.omf.rl;
import com.byazt.pop.ve;
import com.byazt.yih.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 176, 20})
public class c {
    public static void c(View view, ic icVar, Context context) {
        if (icVar == null) {
            return;
        }
        if (context == null) {
            context = gt.getContext();
        }
        String strTt = nb.tt(icVar);
        com.byazt.hkv.c cVar = new com.byazt.hkv.c(context, icVar, strTt, nb.uj(strTt));
        ve veVarC = c(icVar, context, strTt);
        if (veVarC != null) {
            ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(veVarC);
        }
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c((com.byazt.nat.c.InterfaceC0470c) rl.ve(icVar.lw(), com.byazt.nat.c.InterfaceC0470c.class));
        cVar.c(view, new da());
    }

    private static ve tt(ic icVar, Context context, String str) {
        if (icVar.i() != 4) {
            return null;
        }
        com.byazt.wz.c cVarC = x.c(context, icVar, str);
        final String strUj = icVar.uj();
        cVarC.c(new com.byazt.pop.c() { // from class: com.byazt.oit.c.1
            @Override // com.byazt.pop.c
            public void c() {
                com.byazt.nt.c.c(strUj);
            }

            @Override // com.byazt.pop.c
            public void tt(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.tt(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void ve(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.ve(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void c(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.c(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void c(long j, String str2, String str3) {
                com.byazt.nt.c.tt(strUj);
            }

            @Override // com.byazt.pop.c
            public void c(String str2, String str3) {
                com.byazt.nt.c.ve(strUj);
            }
        });
        cVarC.c();
        return cVarC;
    }

    private static ve c(ic icVar, Context context, String str) {
        if (icVar == null) {
            return null;
        }
        ve veVar = (ve) rl.ve(icVar.lw(), ve.class);
        if (veVar != null) {
            icVar.lw();
        }
        if (veVar != null) {
            return veVar;
        }
        ve veVarTt = tt(icVar, context, str);
        rl.tt(icVar.lw(), veVarTt, ve.class);
        icVar.lw();
        return veVarTt;
    }
}
