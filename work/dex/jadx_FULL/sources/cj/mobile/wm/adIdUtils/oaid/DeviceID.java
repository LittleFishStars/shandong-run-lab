package cj.mobile.wm.adIdUtils.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.impl.OAIDFactory;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class DeviceID implements IGetter {
    public Application application;
    public String oaid;

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException(dexc.dexa("PBJE!jt!fnquz")));
            return;
        }
        this.oaid = str;
        OAIDLog.print(dexc.dexa("poPBJEHfuDpnqmfuf!pbje>") + this.oaid);
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
        OAIDLog.printE(dexc.dexa("poPBJEHfuFssps!fssps>") + exc.toString());
    }
}
