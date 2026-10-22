package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a buk;
    private com.kwai.adclient.kscommerciallogger.a.b bul;
    private JSONObject bum;
    private boolean bun;
    private boolean isDebug;

    /* JADX INFO: renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    public static final class C1313a {
        private static a buo;

        public static a Yf() {
            if (buo == null) {
                buo = new a((byte) 0);
            }
            return buo;
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a Yf() {
        return C1313a.Yf();
    }

    private void b(@NonNull c cVar) {
        if (this.buk != null) {
            if (cVar.Yj() != null) {
                String str = cVar.Yj().value;
            }
            if (cVar.Yk() != null) {
                cVar.Yk().getValue();
            }
            cVar.Yn();
            b.A(cVar.Yl());
            b.A(cVar.Ym());
        }
    }

    public final JSONObject Yg() {
        return this.bum;
    }

    public final boolean Yh() {
        return this.bun;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        this.buk = aVar;
        this.bul = bVar;
        this.bum = jSONObject;
        this.isDebug = z;
        this.bun = z2;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private a() {
        this.isDebug = false;
        this.bun = false;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.bul;
        if (bVar != null) {
            bVar.O(cVar.Yi(), cVar.toString());
        }
    }
}
