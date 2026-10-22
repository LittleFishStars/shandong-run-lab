package com.kc.aw;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ca implements Runnable {
    public final _c9 _a;

    public _ca(_c9 _c9Var) {
        this._a = _c9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str_a;
        try {
            Signature signature = PtgAdSdk.getContext().getPackageManager().getPackageInfo(PtgAdSdk.getContext().getPackageName(), 64).signatures[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(signature.toByteArray());
            str_a = _cb._a(messageDigest.digest());
            try {
                str_a = !TextUtils.isEmpty(str_a) ? URLEncoder.encode(str_a, "UTF-8") : "";
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        _c9 _c9Var = this._a;
        if (_c9Var != null) {
            _c9Var._A = str_a;
        }
    }
}
