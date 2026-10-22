package com.kc.aw;

import android.content.Context;
import android.content.SharedPreferences;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ju implements Runnable {
    public final Context _a;
    public final String _b = "aw_sdk_config";
    public final String _c = "ptg_sensor_status";
    public final boolean _d;

    public _ju(Context context, boolean z) {
        this._a = context;
        this._d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences sharedPreferences_b = _jw._b(this._a, this._b);
        if (sharedPreferences_b == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences_b.edit();
            editorEdit.putBoolean(this._c, this._d);
            _jw._a(editorEdit);
        } catch (Exception e) {
            e.getMessage();
            Map map = (Map) _jw._b.get(this._b);
            if (map != null) {
                map.remove(this._c);
            }
        }
    }
}
