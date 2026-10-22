package com.kwad.sdk.b;

import com.kuaishou.weapon.p0.IWeaponInitParams;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class b implements IWeaponInitParams {
    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean getAPPLISTSwitch() {
        return !be.readInstalledPackagesDisable();
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getAppKey() {
        return "400000";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getChannel() {
        return "";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getDeviceId() {
        return bt.getDeviceId();
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean getPrivacySwitch() {
        return true;
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getProductName() {
        return "ksadsdk";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getSecKey() {
        return "f12536c198aee4d8198aad2300827430";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getUserId() {
        return "";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean isLoadSo() {
        return com.kwad.framework.a.a.ayL.booleanValue();
    }
}
