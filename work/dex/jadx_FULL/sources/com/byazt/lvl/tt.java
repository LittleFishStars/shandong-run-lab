package com.byazt.lvl;

import android.text.TextUtils;
import com.byazt.aas.md;
import com.byazt.vif.uj;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_LBSRISK_GET_WUA_FAILED, 13})
public class tt {
    public com.byazt.dj.tt c(String str, String str2) {
        try {
            return md.c(uj.c(str, "full_reward_adslot").get(str2, (String) null), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void c(String str, com.byazt.dj.tt ttVar) {
        if (ttVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                uj.c(ttVar.or(), "full_reward_adslot").put(str, md.c(ttVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
