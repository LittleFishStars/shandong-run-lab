package com.byazt.va;

import android.text.TextUtils;
import com.alipay.sdk.m.t.e;
import com.byazt.gqp.a;
import com.byazt.gqp.da;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 116, 46})
public class n extends uj {
    public z c;

    public n(t tVar) {
        super(tVar);
        this.c = null;
    }

    public z n() {
        return this.c;
    }

    public void ve(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.c = z.c(da.c("application/json; charset=utf-8"), str);
    }

    public void c(JSONObject jSONObject) {
        this.c = z.c(da.c("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void c(Map<String, String> map) {
        com.byazt.gqp.n.c cVar = new com.byazt.gqp.n.c();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                cVar.c(str, map.get(str));
            }
        }
        this.c = cVar.c();
    }

    public void c(String str, byte[] bArr) {
        this.c = z.c(da.c(str), bArr);
    }

    public void c(final com.byazt.mh.c cVar) {
        try {
            yp.c cVar2 = new yp.c();
            if (TextUtils.isEmpty(this.f29124a)) {
                cVar.c(this, new IOException("Url is Empty"));
                return;
            }
            cVar2.c(this.f29124a);
            if (this.c == null) {
                if (cVar != null) {
                    cVar.c(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                c(cVar2);
                cVar2.c((Object) tt());
                this.ve.c(cVar2.c(this.c).tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.va.n.1
                    @Override // com.byazt.gqp.ve
                    public void onFailure(com.byazt.gqp.tt ttVar, IOException iOException) {
                        com.byazt.mh.c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.c(n.this, iOException);
                        }
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.byazt.gqp.ve
                    public void onResponse(com.byazt.gqp.tt ttVar, m mVar) throws IOException {
                        com.byazt.hm.tt ttVar2;
                        com.byazt.mh.c cVar3 = cVar;
                        if (cVar3 != null) {
                            if (mVar == null) {
                                cVar3.c(n.this, new IOException("No response"));
                                return;
                            }
                            com.byazt.hm.tt ttVar3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                a aVarSp = mVar.sp();
                                if (aVarSp != null) {
                                    for (int i = 0; i < aVarSp.c(); i++) {
                                        String strC = aVarSp.c(i);
                                        String strTt = aVarSp.tt(i);
                                        map.put(strC, strTt);
                                        if (strC != null && strC.equalsIgnoreCase(e.f)) {
                                            map.put(e.f, strTt == null ? "" : strTt.toLowerCase());
                                        }
                                    }
                                }
                                try {
                                    if (com.byazt.lf.c.c(map)) {
                                        byte[] bArrUj = mVar.a().uj();
                                        ttVar2 = new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, null, mVar.tt(), mVar.c());
                                        ttVar2.c(bArrUj);
                                    } else if (n.this.sp) {
                                        byte[] bArrUj2 = mVar.a().uj();
                                        n nVar = n.this;
                                        ttVar2 = new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, new String(bArrUj2, nVar.c(nVar.c(mVar.a()))), mVar.tt(), mVar.c());
                                        ttVar2.c(bArrUj2);
                                    } else {
                                        ttVar2 = new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, mVar.a().tt(), mVar.tt(), mVar.c());
                                    }
                                    n.this.c(ttVar2, mVar);
                                } catch (Throwable th) {
                                    th = th;
                                    ttVar3 = ttVar2;
                                    ttVar2 = ttVar3;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (ttVar2 != null) {
                                cVar.c(n.this, ttVar2);
                                return;
                            }
                            com.byazt.mh.c cVar4 = cVar;
                            n nVar2 = n.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            cVar4.c(nVar2, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            cVar.c(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.byazt.va.uj
    public com.byazt.hm.tt c() {
        com.byazt.hm.tt ttVar;
        try {
            yp.c cVar = new yp.c();
            if (TextUtils.isEmpty(this.f29124a)) {
                com.byazt.lf.n.c("PostExecutor", "execute: Url is Empty");
                return new com.byazt.hm.tt(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            cVar.c(this.f29124a);
            if (this.c == null) {
                com.byazt.lf.n.c("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.byazt.hm.tt(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            c(cVar);
            cVar.c((Object) tt());
            m mVarTt = this.ve.c(cVar.c(this.c).tt()).tt();
            if (mVarTt == null) {
                return null;
            }
            HashMap map = new HashMap();
            a aVarSp = mVarTt.sp();
            if (aVarSp != null) {
                for (int i = 0; i < aVarSp.c(); i++) {
                    String strC = aVarSp.c(i);
                    String strTt = aVarSp.tt(i);
                    map.put(strC, strTt);
                    if (strC != null && strC.equalsIgnoreCase(e.f)) {
                        map.put(e.f, strTt == null ? "" : strTt.toLowerCase());
                    }
                }
            }
            if (com.byazt.lf.c.c(map)) {
                byte[] bArrUj = mVarTt.a().uj();
                ttVar = new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, null, mVarTt.tt(), mVarTt.c());
                ttVar.c(bArrUj);
            } else if (this.sp) {
                byte[] bArrUj2 = mVarTt.a().uj();
                ttVar = new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, new String(bArrUj2, c(c(mVarTt.a()))), mVarTt.tt(), mVarTt.c());
                ttVar.c(bArrUj2);
            } else {
                ttVar = new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, mVarTt.a().tt(), mVarTt.tt(), mVarTt.c());
            }
            c(ttVar, mVarTt);
            return ttVar;
        } catch (Throwable th) {
            return new com.byazt.hm.tt(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset c(da daVar) {
        try {
            return daVar != null ? daVar.c(com.byazt.na.da.c) : com.byazt.na.da.c;
        } catch (Exception unused) {
            return com.byazt.na.da.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public da c(nu nuVar) {
        try {
            return nuVar.n();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.hm.tt ttVar, m mVar) {
        if (ttVar == null || mVar == null) {
            return;
        }
        ttVar.c(mVar.x());
    }
}
