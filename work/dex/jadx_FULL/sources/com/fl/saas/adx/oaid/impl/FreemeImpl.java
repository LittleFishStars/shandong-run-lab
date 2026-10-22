package com.fl.saas.adx.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.fl.saas.adx.oaid.IGetter;
import com.fl.saas.adx.oaid.IOAID;
import com.fl.saas.adx.oaid.OAIDException;
import com.fl.saas.adx.oaid.OAIDLog;
import com.fl.saas.adx.oaid.com.android.creator.IdsSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FreemeImpl implements IOAID {
    private final Context context;

    public FreemeImpl(Context context) {
        this.context = context;
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.adx.oaid.impl.FreemeImpl.1
            @Override // com.fl.saas.adx.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (idsSupplierAsInterface != null) {
                    return idsSupplierAsInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
            }
        });
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
