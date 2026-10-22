package com.hailiang.advlib.open;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class JFIdentifierManager implements b {
    private static volatile JFIdentifierManager manager;
    private b iIdentifier;
    private String mOAID = "";

    private JFIdentifierManager() {
        this.iIdentifier = null;
        try {
            this.iIdentifier = new a();
        } catch (Throwable unused) {
        }
    }

    public static JFIdentifierManager getInstance() {
        if (manager == null) {
            synchronized (JFIdentifierManager.class) {
                try {
                    if (manager == null) {
                        manager = new JFIdentifierManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return manager;
    }

    private boolean isSpecialVale(String str) {
        return str.equals("00000000000000000000000000000000") || str.equals("00000000-0000-0000-0000-000000000000");
    }

    @Override // com.hailiang.advlib.open.b
    public void acquireOAID(Context context) {
        b bVar = this.iIdentifier;
        if (bVar != null) {
            bVar.acquireOAID(context);
        }
    }

    @Override // com.hailiang.advlib.open.b
    public void asyncAcquireOAID(Context context) {
        b bVar = this.iIdentifier;
        if (bVar != null) {
            bVar.asyncAcquireOAID(context);
        }
    }

    @Override // com.hailiang.advlib.open.b
    public String getOaid() {
        b bVar = this.iIdentifier;
        return bVar != null ? bVar.getOaid() : this.mOAID;
    }

    @Override // com.hailiang.advlib.open.b
    public void setIsCanUseOaid(Context context, boolean z) {
        b bVar = this.iIdentifier;
        if (bVar != null) {
            bVar.setIsCanUseOaid(context, z);
        }
    }

    @Override // com.hailiang.advlib.open.b
    public void setOaid(String str) {
        b bVar = this.iIdentifier;
        if (bVar != null) {
            bVar.setOaid(str);
        } else {
            if (TextUtils.isEmpty(str) || isSpecialVale(str) || !TextUtils.isEmpty(this.mOAID)) {
                return;
            }
            this.mOAID = str;
        }
    }
}
