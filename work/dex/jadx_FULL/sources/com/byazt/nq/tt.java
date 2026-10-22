package com.byazt.nq;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.ete.ma;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.va.uj;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1006, 13})
public class tt {
    public static volatile tt c;

    public interface c {
    }

    private void tt(String str, String str2, String str3, String str4, String str5) {
        com.byazt.nq.c cVar = new com.byazt.nq.c();
        cVar.ve(str).n(str3).uj(str4).tt(str2).c(str5).c(Long.valueOf(System.currentTimeMillis()));
        ve.c().c(cVar, false);
        tt();
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public void c(ma maVar, String str, String str2) {
        if (maVar == null) {
            return;
        }
        if (TextUtils.isEmpty(maVar.c())) {
            m.uj("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + LoginConstants.UNDER_LINE + maVar.c();
        final String strVe = maVar.ve();
        final String strTt = maVar.tt();
        final String strUj = maVar.uj();
        if (TextUtils.isEmpty(str) && str2.equals("ad")) {
            str = x.m().rl();
        }
        final String str4 = str;
        n.c(new sp("saveUGenTemplate") { // from class: com.byazt.nq.tt.1
            @Override // java.lang.Runnable
            public void run() {
                tt.this.c(str3, strVe, strTt, strUj, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        int iAb = gt.tt().ab();
        if (iAb <= 0) {
            iAb = 100;
        }
        List<com.byazt.nq.c> listTt = ve.c().tt();
        if (listTt == null || listTt.isEmpty() || iAb >= listTt.size()) {
            if (listTt != null) {
                listTt.size();
                return;
            }
            return;
        }
        int size = (int) (listTt.size() - (iAb * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.byazt.nq.c cVar : listTt) {
            treeMap.put(cVar.uj(), cVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.byazt.nq.c cVar2 = (com.byazt.nq.c) entry.getValue();
                if (cVar2 != null) {
                    hashSet.add(cVar2.c());
                }
            }
        }
        c(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, String str4, String str5) {
        if (c(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            tt(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            c(str2, str, str3, str5, (c) null);
        } else {
            tt(str2, str3, str5, str4, str);
        }
    }

    private void c(final String str, final String str2, final String str3, final String str4, final c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        veVarVe.c(str);
        veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.nq.tt.2
            @Override // com.byazt.mh.c
            public void c(uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar != null && ttVar.i()) {
                    String strN = ttVar.n();
                    if (TextUtils.isEmpty(strN)) {
                        return;
                    }
                    ve.c().c(new com.byazt.nq.c().c(str2).tt(str3).ve(str).n(str4).uj(strN).c(Long.valueOf(System.currentTimeMillis())), false);
                    tt.this.tt();
                    if (cVar != null) {
                        try {
                            new JSONObject(strN);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.byazt.mh.c
            public void c(uj ujVar, IOException iOException) {
                if (cVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.byazt.nq.c> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ve.c().c(str);
    }

    public String c(String str, String str2, String str3) {
        com.byazt.nq.c cVarC = c(str + LoginConstants.UNDER_LINE + str2, str3);
        if (cVarC == null) {
            return null;
        }
        c(cVarC);
        return cVarC.n();
    }

    private com.byazt.nq.c c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return ve.c().c(str, str2);
    }

    private void c(final com.byazt.nq.c cVar) {
        cVar.c(Long.valueOf(System.currentTimeMillis()));
        n.c(new sp("updateTmplTime") { // from class: com.byazt.nq.tt.3
            @Override // java.lang.Runnable
            public void run() {
                ve.c().c(cVar, true);
            }
        }, 10);
    }

    public void c(Set<String> set) {
        try {
            ve.c().c(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
