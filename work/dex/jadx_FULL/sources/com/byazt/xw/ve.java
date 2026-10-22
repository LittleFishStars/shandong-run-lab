package com.byazt.xw;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 226, 54})
public class ve extends com.byazt.dw.uj {
    public com.byazt.me.c c;

    public ve(com.byazt.me.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.dw.uj
    public Map<String, Object> getAppInfoExtra() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.da();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getAppName() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.ve();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getAuthorName() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.uj();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getFunctionDescUrl() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.tt();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public long getPackageSizeBytes() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.n();
        }
        return 0L;
    }

    @Override // com.byazt.dw.uj
    public Map<String, String> getPermissionsMap() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.sp();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getPermissionsUrl() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getPrivacyAgreement() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.x();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getRegUrl() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // com.byazt.dw.uj
    public String getVersionName() {
        com.byazt.me.c cVar = this.c;
        if (cVar != null) {
            return cVar.i();
        }
        return null;
    }
}
