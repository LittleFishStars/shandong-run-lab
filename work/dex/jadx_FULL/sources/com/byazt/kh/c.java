package com.byazt.kh;

import com.byazt.eg.da;
import com.byazt.eg.eo;
import com.byazt.eg.h;
import com.byazt.eg.rh;
import com.byazt.eg.sl;
import com.byazt.iq.sp;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_LIKE, 20})
public abstract class c {
    public static c c;

    public abstract int c(h.c cVar);

    public abstract com.byazt.iq.uj c(da daVar);

    public abstract com.byazt.iq.ve c(da daVar, com.byazt.eg.c cVar, sp spVar, eo eoVar);

    public abstract Socket c(da daVar, com.byazt.eg.c cVar, sp spVar);

    public abstract void c(rh.c cVar, String str);

    public abstract void c(rh.c cVar, String str, String str2);

    public abstract void c(sl slVar, SSLSocket sSLSocket, boolean z);

    public abstract boolean c(com.byazt.eg.c cVar, com.byazt.eg.c cVar2);

    public abstract boolean c(da daVar, com.byazt.iq.ve veVar);

    public abstract void tt(da daVar, com.byazt.iq.ve veVar);
}
