package com.igexin.push.d.a;

import com.igexin.c.a.b.d;
import com.igexin.c.a.d.a.e;
import com.igexin.push.d.c.f;
import com.igexin.push.d.c.h;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.m;
import com.igexin.push.d.c.n;
import com.igexin.push.d.c.p;
import com.igexin.push.d.c.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38088a = "CommandFilter";

    public a(String str, d dVar) {
        super(str, (byte) 0);
        a(dVar);
    }

    private static boolean a(com.igexin.push.d.c.a aVar, com.igexin.push.d.c.c cVar) {
        String string;
        if (aVar.b != 26) {
            return false;
        }
        n nVar = (n) cVar;
        if (nVar.d() && nVar.f != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) nVar.f);
                if (jSONObject.has("action") && (string = jSONObject.getString("action")) != null && string.equals(com.igexin.push.core.b.G)) {
                    return true;
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("CommandFilter|" + e.toString(), new Object[0]);
            }
        }
        return false;
    }

    private static e c(Object obj) throws Exception {
        com.igexin.push.d.c.c fVar;
        if (obj == null) {
            return null;
        }
        com.igexin.push.d.c.a aVar = (com.igexin.push.d.c.a) obj;
        byte b = aVar.b;
        if (b == 0) {
            fVar = new f();
        } else if (b == 5) {
            fVar = new k();
        } else if (b == 9) {
            fVar = new p();
        } else if (b == 20) {
            fVar = new q();
        } else if (b == 26) {
            fVar = new n();
        } else if (b != 37) {
            fVar = b != 97 ? null : new h();
        } else {
            fVar = new m();
        }
        int i = aVar.f;
        if ((i != 1 && i != 7) || fVar == null) {
            return null;
        }
        fVar.a(aVar.e);
        if (aVar.f != 7) {
            if (a(aVar, fVar)) {
                return fVar;
            }
            return null;
        }
        if (aVar.g != 32 || a(aVar, fVar)) {
            return fVar;
        }
        com.igexin.c.a.c.a.a(f38088a, "version = 7 and enc type = 0x20, redirect = false");
        return null;
    }

    @Override // com.igexin.c.a.b.d
    public final Object a(Object obj) throws Exception {
        if (obj instanceof com.igexin.push.d.c.c) {
            com.igexin.push.d.c.c cVar = (com.igexin.push.d.c.c) obj;
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.b = (byte) cVar.m;
            aVar.a(cVar.b());
            aVar.c = cVar.n;
            aVar.d = cVar.o;
            return aVar;
        }
        if (!(obj instanceof com.igexin.push.d.c.c[])) {
            return null;
        }
        com.igexin.push.d.c.c[] cVarArr = (com.igexin.push.d.c.c[]) obj;
        com.igexin.push.d.c.a[] aVarArr = new com.igexin.push.d.c.a[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
            aVarArr[i] = aVar2;
            com.igexin.push.d.c.c cVar2 = cVarArr[i];
            aVar2.b = (byte) cVar2.m;
            aVar2.a(cVar2.b());
        }
        return aVarArr;
    }

    @Override // com.igexin.c.a.b.d
    public final /* synthetic */ Object b(Object obj) throws Exception {
        return c(obj);
    }
}
