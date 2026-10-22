package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends e implements h {
    private String RU;
    private long RV;
    private String RW;
    private Context mContext;

    private void ao(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPQ)) {
                jSONObject.put("64_level", 1);
            }
            com.kwad.sdk.core.f.c.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        com.kwad.sdk.core.f.c.a(context, new com.kwad.sdk.core.f.a() { // from class: com.kwad.components.core.f.a.1
            @Override // com.kwad.sdk.core.f.a
            public final void aw(String str) {
                c.d("initGId onSuccess", "deviceInfo：" + str);
                a.this.qP();
                a.this.au(str);
            }

            @Override // com.kwad.sdk.core.f.a
            public final void onFailed(int i, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(String str) {
        if (this.mContext == null || br.isNullString(str) || br.isEquals(qU(), str)) {
            return;
        }
        this.RW = str;
        ai.ao(this.mContext, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qP() {
        String strDr = ai.dr(this.mContext);
        String strWK = bt.WK();
        if (TextUtils.isEmpty(strDr)) {
            ai.ah(this.mContext, strWK);
            return;
        }
        if (TextUtils.equals(strDr, strWK)) {
            return;
        }
        this.RU = "";
        this.RV = 0L;
        this.RW = "";
        ai.ae(this.mContext, "");
        ai.d(this.mContext, this.RV);
        ai.ao(this.mContext, this.RW);
        ai.ah(this.mContext, strWK);
    }

    private String qS() {
        if (TextUtils.isEmpty(this.RU)) {
            this.RU = ai.dm(this.mContext);
        }
        return this.RU;
    }

    private long qT() {
        if (this.RV == 0) {
            this.RV = ai.dp(this.mContext);
        }
        return this.RV;
    }

    private String qU() {
        if (TextUtils.isEmpty(this.RW)) {
            this.RW = ai.du(this.mContext);
        }
        return this.RW;
    }

    @Override // com.kwad.sdk.components.h
    public final void F(long j) {
        if (this.mContext == null || j <= 0 || j == qT()) {
            return;
        }
        this.RV = j;
        ai.d(this.mContext, j);
    }

    @Override // com.kwad.sdk.components.h
    public final void av(String str) {
        if (this.mContext == null || br.isNullString(str) || br.isEquals(qS(), str)) {
            return;
        }
        try {
            this.RU = str;
            ai.ae(this.mContext, str);
            com.kwad.sdk.core.f.c.setEgid(this.mContext, str);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        try {
            this.mContext = context;
            ao(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.h
    public final String qQ() {
        return (com.kwad.sdk.core.config.e.JO() || System.currentTimeMillis() >= qT() || TextUtils.isEmpty(qS())) ? qU() : "";
    }

    @Override // com.kwad.sdk.components.h
    public final com.kwad.sdk.core.a.h qR() {
        return new com.kwad.sdk.core.a.a();
    }
}
