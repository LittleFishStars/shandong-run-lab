package com.byazt.ete;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 66})
public class t extends com.byazt.nc.ve {
    public a c;

    public t(ic icVar) {
        if (icVar == null) {
            return;
        }
        this.c = icVar.rh();
    }

    @Override // com.byazt.nc.ve
    public String getAppName() {
        a aVar = this.c;
        return aVar == null ? "" : aVar.yp();
    }

    @Override // com.byazt.nc.ve
    public String getAppVersion() {
        a aVar = this.c;
        return aVar == null ? "" : aVar.n();
    }

    @Override // com.byazt.nc.ve
    public String getDeveloperName() {
        a aVar = this.c;
        return aVar == null ? "" : aVar.sp();
    }

    @Override // com.byazt.nc.ve
    public String getFunctionDescUrl() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.i();
    }

    @Override // com.byazt.nc.ve
    public String getPermissionUrl() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.tt();
    }

    @Override // com.byazt.nc.ve
    public Map<String, String> getPermissionsMap() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // com.byazt.nc.ve
    public String getPrivacyUrl() {
        a aVar = this.c;
        return aVar == null ? "" : aVar.x();
    }

    @Override // com.byazt.nc.ve
    public String getRegNumber() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.da();
    }

    @Override // com.byazt.nc.ve
    public String getRegUrl() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.sl();
    }
}
