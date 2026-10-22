package com.kc.dw.core.safe;

import android.content.DialogInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            safeOnClick(dialogInterface, i);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }

    public void safeOnClick(DialogInterface dialogInterface, int i) {
    }
}
