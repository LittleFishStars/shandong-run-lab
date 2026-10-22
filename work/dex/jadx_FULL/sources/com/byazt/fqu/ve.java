package com.byazt.fqu;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1010, 54})
public class ve implements LocationProvider {
    public ValueSet c;

    public ve(ValueSet valueSet) {
        this.c = valueSet == null ? com.byazt.rl.ve.c : valueSet;
    }

    public static SparseArray<Object> c(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        veVarC.c(262001, locationProvider.getLatitude());
        veVarC.c(262002, locationProvider.getLongitude());
        return veVarC.tt().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.c.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.c.doubleValue(262002);
    }
}
