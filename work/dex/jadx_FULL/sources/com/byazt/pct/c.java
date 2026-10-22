package com.byazt.pct;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.MainThread;
import com.zj.adlib.bv9;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 20})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sp f28935a;
    public Context c;
    public Handler sp;
    public u tt;
    public String uj;
    public x ve;
    public volatile boolean n = false;
    public final Map<String, sp> x = new HashMap();

    public abstract String c();

    public abstract void c(da daVar);

    @AnyThread
    public abstract void c(String str);

    public abstract Context getContext(da daVar);

    public void invokeMethod(final String str) {
        if (this.n) {
            return;
        }
        tt().post(new Runnable() { // from class: com.byazt.pct.c.1
            @Override // java.lang.Runnable
            public void run() {
                m mVarC;
                if (c.this.n) {
                    return;
                }
                try {
                    mVarC = c.this.c(new JSONObject(str));
                } catch (Exception e) {
                    i.tt("Exception thrown while parsing function.", e);
                    mVarC = null;
                }
                if (!m.c(mVarC)) {
                    c.this.c(mVarC);
                    return;
                }
                i.c("By pass invalid call: ".concat(String.valueOf(mVarC)));
                if (mVarC != null) {
                    c.this.tt(gr.c(new rh(mVarC.c, "Failed to parse invocation.")), mVarC);
                }
            }
        });
    }

    public Handler tt() {
        if (this.sp == null) {
            this.sp = new Handler(Looper.getMainLooper());
        }
        return this.sp;
    }

    public void ve() {
        this.f28935a.c();
        Iterator<sp> it = this.x.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        tt().removeCallbacksAndMessages(null);
        this.n = true;
    }

    public void c(Looper looper) {
        if (looper == null) {
            return;
        }
        this.sp = new Handler(looper);
    }

    public void c(String str, m mVar) {
        c(str);
    }

    @MainThread
    public final void c(m mVar) {
        if (this.n) {
            return;
        }
        String strC = c();
        if (strC == null) {
            strC = "";
        }
        sp spVarTt = tt(mVar.sp);
        if (spVarTt == null) {
            i.tt("Received call with unknown namespace, ".concat(String.valueOf(mVar)));
            if (this.tt != null) {
                c();
            }
            tt(gr.c(new rh(-4, "Namespace " + mVar.sp + " unknown.")), mVar);
            return;
        }
        a aVar = new a();
        aVar.tt = strC;
        aVar.c = this.c;
        aVar.ve = spVarTt;
        try {
            sp.c cVarC = spVarTt.c(mVar, aVar);
            if (cVarC == null) {
                i.tt("Received call but not registered, ".concat(String.valueOf(mVar)));
                tt(gr.c(new rh(-2, "Function " + mVar.uj + " is not registered.")), mVar);
                return;
            }
            if (cVarC.c) {
                tt(cVarC.tt, mVar);
            }
        } catch (Exception e) {
            i.c("call finished with error, ".concat(String.valueOf(mVar)), e);
            tt(gr.c(e), mVar);
        }
    }

    public final void tt(String str, m mVar) {
        JSONObject jSONObject;
        if (this.n) {
            return;
        }
        if (TextUtils.isEmpty(mVar.f28937a)) {
            i.c("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith(bv9.b) || !str.endsWith("}")) {
            i.c(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        c(z.c().c("__msg_type", RenderCallContext.TYPE_CALLBACK).c("__callback_id", mVar.f28937a).c("__params", jSONObject).tt(), mVar);
    }

    private sp tt(String str) {
        if (!TextUtils.equals(str, this.uj) && !TextUtils.isEmpty(str)) {
            return this.x.get(str);
        }
        return this.f28935a;
    }

    public final void c(da daVar, rl rlVar) {
        this.c = getContext(daVar);
        this.ve = daVar.uj;
        this.tt = daVar.i;
        this.f28935a = new sp(daVar, this, rlVar);
        this.uj = daVar.sl;
        c(daVar);
    }

    public final <T> void c(String str, T t) {
        if (this.n) {
            return;
        }
        String strC = this.ve.c(t);
        i.c("Sending js event: ".concat(String.valueOf(str)));
        c("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + strC + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m c(JSONObject jSONObject) {
        String strOptString;
        if (this.n) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return m.c().c(string2).tt(string).ve(strOptString3).uj(strOptString).n(strOptString2).a(strOptString4).sp(jSONObject.optString("__iframe_url")).c();
        } catch (JSONException e) {
            i.tt("Failed to create call.", e);
            return m.c(strOptString2, -1);
        }
    }
}
