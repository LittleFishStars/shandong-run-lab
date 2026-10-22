package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ga {

    @Keep
    public final class _a implements _a3 {
        public final _a3 _a;

        public _a(_a3 _a3Var) {
            this._a = _a3Var;
        }

        @Override // com.kc.aw._a3
        public final void _a(String str) {
            _a3 _a3Var = this._a;
            if (_a3Var != null) {
                _a3Var._a(str);
            }
        }
    }

    public static void _a(Context context, _a3 _a3Var) {
        try {
            new _g9(context)._a(new _a(_a3Var));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
