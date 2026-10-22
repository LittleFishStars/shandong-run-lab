package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.PtgSDKConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nb implements Runnable {
    public final Context _a;
    public final PtgSDKConfig _b;

    public _nb(Context context, PtgSDKConfig ptgSDKConfig) {
        this._a = context;
        this._b = ptgSDKConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ArrayList arrayList = _nd._a;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_et) it.next())._a(this._a, this._b);
            }
            _ng _ngVar = _nd._b;
            if (_ngVar != null) {
                _ngVar._a(this._a, this._b);
            }
        } catch (Exception unused) {
        }
    }
}
