package com.kc.dw.core.safe;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            safeOnClick(view);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }

    public void safeOnClick(View view) {
    }
}
