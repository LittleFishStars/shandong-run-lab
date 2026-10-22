package com.alibaba.ariver.commonability.device.jsapi.sensor;

import android.content.Context;
import com.alibaba.ariver.commonability.core.b.a.b;
import com.alibaba.ariver.commonability.core.b.a.c;
import com.alibaba.ariver.commonability.core.b.a.d;
import com.alibaba.ariver.commonability.core.b.a.e;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends e {
    public static final int d = -10;
    private e e;
    private e f;
    private e g;
    private e h;

    private e b(int i) {
        if (i == -10) {
            return this.h;
        }
        if (i == 4) {
            return this.e;
        }
        if (i == 1) {
            return this.f;
        }
        if (i != 2) {
            return null;
        }
        return this.g;
    }

    public void a(int i, com.alibaba.ariver.commonability.core.a.a aVar) {
        e eVarB = b(i);
        if (eVarB == null) {
            return;
        }
        eVarB.a(aVar);
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    @Deprecated
    public void a(Context context, JSONObject jSONObject) {
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    @Deprecated
    public void a(com.alibaba.ariver.commonability.core.a.a aVar) {
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void c() {
        b();
        a();
    }

    public void a(int i) {
        e eVar;
        if (i == -10) {
            e eVar2 = this.h;
            if (eVar2 != null) {
                eVar2.b();
                return;
            }
            return;
        }
        if (i == 4) {
            e eVar3 = this.e;
            if (eVar3 != null) {
                eVar3.b();
                return;
            }
            return;
        }
        if (i != 1) {
            if (i == 2 && (eVar = this.g) != null) {
                eVar.b();
                return;
            }
            return;
        }
        e eVar4 = this.f;
        if (eVar4 != null) {
            eVar4.b();
        }
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void b() {
        a(1);
        a(4);
        a(2);
        a(-10);
    }

    public e a(int i, Context context, JSONObject jSONObject) {
        e eVar;
        if (i == -10) {
            if (this.h == null) {
                this.h = new com.alibaba.ariver.commonability.core.b.a.a();
            }
            eVar = this.h;
        } else if (i == 4) {
            if (this.e == null) {
                this.e = new d();
            }
            eVar = this.e;
        } else if (i == 1) {
            if (this.f == null) {
                this.f = new b();
            }
            eVar = this.f;
        } else if (i != 2) {
            eVar = null;
        } else {
            if (this.g == null) {
                this.g = new c();
            }
            eVar = this.g;
        }
        eVar.b(context, jSONObject);
        return eVar;
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a() {
        this.h = null;
        this.g = null;
        this.f = null;
        this.e = null;
    }
}
