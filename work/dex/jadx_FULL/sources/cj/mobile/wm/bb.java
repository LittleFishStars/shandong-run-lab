package cj.mobile.wm;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class bb extends ContentObserver {
    public String dexa;
    public int dexb;
    public ab dexc;

    public bb(ab abVar, int i, String str) {
        super(null);
        this.dexc = abVar;
        this.dexb = i;
        this.dexa = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ab abVar = this.dexc;
        if (abVar != null) {
            abVar.dexa(this.dexb, this.dexa);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
