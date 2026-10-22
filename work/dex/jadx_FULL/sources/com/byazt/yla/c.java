package com.byazt.yla;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2157, 20})
public class c extends com.byazt.nc.ve {
    public com.byazt.yl.ve c;

    public c(com.byazt.yl.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.nc.ve
    public String getAppName() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getAppName();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getAppVersion() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getVersionName();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getDeveloperName() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getAuthorName();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getFunctionDescUrl() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getFunctionDescUrl();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getPermissionUrl() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getPermissionsUrl();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public Map<String, String> getPermissionsMap() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getPermissionsMap();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getPrivacyUrl() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getPrivacyAgreement();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getRegNumber() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getRegNumber();
        }
        return null;
    }

    @Override // com.byazt.nc.ve
    public String getRegUrl() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.getRegUrl();
        }
        return null;
    }
}
