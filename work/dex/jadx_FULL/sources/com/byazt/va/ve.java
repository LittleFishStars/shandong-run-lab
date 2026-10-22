package com.byazt.va;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.gqp.a;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.sp;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 116, 54})
public class ve extends uj {
    public static final com.byazt.gqp.c c = new com.byazt.gqp.c.C0416c().c().tt();
    public static final com.byazt.gqp.c tt = new com.byazt.gqp.c.C0416c().tt();
    public Map<String, String> da;
    public boolean i;
    public com.byazt.gqp.c x;

    public ve(t tVar) {
        super(tVar);
        this.x = c;
        this.i = false;
        this.da = new HashMap();
    }

    public void c(String str, String str2) {
        if (str == null) {
            com.byazt.lf.n.c("GetExecutor", "name cannot be null !!!");
        } else {
            this.da.put(str, str2);
        }
    }

    public void c(final com.byazt.mh.c cVar) {
        try {
            yp.c cVar2 = new yp.c();
            if (this.i) {
                cVar2.c(this.f29124a);
            } else {
                sp.c cVar3 = new sp.c();
                Uri uri = Uri.parse(this.f29124a);
                cVar3.c(uri.getScheme());
                cVar3.tt(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    cVar3.ve(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.da.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.da.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        cVar3.c(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                cVar2.c(cVar3.tt());
            }
            c(cVar2);
            cVar2.c(this.x);
            cVar2.c((Object) tt());
            this.ve.c(cVar2.c().tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.va.ve.1
                @Override // com.byazt.gqp.ve
                public void onFailure(com.byazt.gqp.tt ttVar, IOException iOException) {
                    com.byazt.mh.c cVar4 = cVar;
                    if (cVar4 != null) {
                        cVar4.c(ve.this, iOException);
                    }
                }

                @Override // com.byazt.gqp.ve
                public void onResponse(com.byazt.gqp.tt ttVar, m mVar) throws IOException {
                    if (cVar != null) {
                        HashMap map = new HashMap();
                        if (mVar != null) {
                            a aVarSp = mVar.sp();
                            if (aVarSp != null) {
                                for (int i = 0; i < aVarSp.c(); i++) {
                                    map.put(aVarSp.c(i), aVarSp.tt(i));
                                }
                            }
                            nu nuVarA = mVar.a();
                            cVar.c(ve.this, new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, nuVarA == null ? "" : nuVarA.tt(), mVar.tt(), mVar.c()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.byazt.lf.n.c()) {
                com.byazt.nr.m.c(th);
            }
            if (cVar != null) {
                cVar.c(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.va.uj
    public com.byazt.hm.tt c() {
        try {
            yp.c cVar = new yp.c();
            String strTt = "";
            if (this.i) {
                cVar.c(this.f29124a);
            } else {
                sp.c cVar2 = new sp.c();
                Uri uri = Uri.parse(this.f29124a);
                cVar2.c(uri.getScheme());
                cVar2.tt(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    cVar2.ve(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.da.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.da.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        cVar2.c(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                cVar.c(cVar2.tt());
            }
            c(cVar);
            cVar.c(this.x);
            cVar.c((Object) tt());
            m mVarTt = this.ve.c(cVar.c().tt()).tt();
            if (mVarTt == null) {
                return null;
            }
            HashMap map = new HashMap();
            a aVarSp = mVarTt.sp();
            if (aVarSp != null) {
                for (int i = 0; i < aVarSp.c(); i++) {
                    map.put(aVarSp.c(i), aVarSp.tt(i));
                }
            }
            nu nuVarA = mVarTt.a();
            if (nuVarA != null) {
                strTt = nuVarA.tt();
            }
            return new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, strTt, mVarTt.tt(), mVarTt.c());
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }
}
