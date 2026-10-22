package com.byazt.gu;

import com.byazt.dna.z;
import com.byazt.gqp.u;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 13})
public class tt implements c {
    private String tt(com.byazt.gqp.tt ttVar) throws NullPointerException {
        return ttVar.c().tt().toString();
    }

    @Override // com.byazt.gu.c
    public void c(com.byazt.gqp.tt ttVar, InetSocketAddress inetSocketAddress, Proxy proxy, u uVar, IOException iOException) {
        try {
            ((z) com.byazt.ut.uj.getService("event")).onExceptionEvent("okhttp_connectFailed", c(ttVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gu.c
    public void c(com.byazt.gqp.tt ttVar, IOException iOException) {
        try {
            ((z) com.byazt.ut.uj.getService("event")).onExceptionEvent("okhttp_callFailed", c(ttVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject c(com.byazt.gqp.tt ttVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", tt(ttVar));
        return jSONObject;
    }
}
