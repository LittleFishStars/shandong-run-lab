package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.kc.aw.download.beans.RequestInfo;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cx implements _d2._b {
    public final _eu _a;
    public final String _b;
    public final String _c;
    public final Context _d;
    public final _h _e;
    public final String _f;
    public final AdSlot _g;

    public _cx(_lg._d _dVar, String str, String str2, Context context, _h _hVar, String str3, AdSlot adSlot) {
        this._a = _dVar;
        this._b = str;
        this._c = str2;
        this._d = context;
        this._e = _hVar;
        this._f = str3;
        this._g = adSlot;
    }

    public final void _a(int i, int i2, String str) {
        _d7._a _aVar;
        Logger.d("PTG_QM_TAG result " + i + " - " + i2);
        boolean z = true;
        if (2 != i) {
            if (1 == i) {
                _h _hVar = this._e;
                if (_hVar != null) {
                    _hVar._a = 1;
                }
                _b2._a(this._d, _hVar, this._g);
                return;
            }
            _eu _euVar = this._a;
            if (_euVar != null) {
                ((_lg._d) _euVar)._a(str);
                return;
            }
            return;
        }
        _d7 _d7Var = _d7._b;
        String str2 = this._b;
        String str3 = this._c;
        _d7Var.getClass();
        RequestInfo requestInfo = new RequestInfo(str3);
        requestInfo._d = 10;
        requestInfo._g = null;
        requestInfo._a = str2;
        requestInfo._b = ".apk";
        requestInfo._f = new _d5(str3, str2);
        requestInfo._h = true;
        HashMap map = _d7._d;
        synchronized (map) {
            _aVar = (_d7._a) map.get(com.kc.aw.lib.utils._a._c(requestInfo._c));
        }
        if (_aVar != null && (_aVar._b.isEmpty() ^ true)) {
            Context context = this._d;
            WeakReference<Toast> weakReference = _nn._a;
            Context applicationContext = context.getApplicationContext();
            Toast toast = _nn._a.get();
            if (toast != null) {
                toast.cancel();
            }
            Toast toastMakeText = Toast.makeText(applicationContext, "正在下载中...", 0);
            toastMakeText.show();
            _nn._a = new WeakReference<>(toastMakeText);
            return;
        }
        Context context2 = this._d;
        _h _hVar2 = this._e;
        String str4 = this._f;
        String str5 = this._c;
        _eu _euVar2 = this._a;
        boolean z2 = _h2._b(PtgAdSdk.getContext()) == 0;
        if ((!z2 || PtgAdSdk.getConfig()._k) && (z2 || PtgAdSdk.getConfig()._l)) {
            z = false;
        }
        if (!(context2 instanceof Activity) || !z) {
            _d2._a(context2, _hVar2, str4, str5);
            return;
        }
        Activity activity = (Activity) context2;
        String str6 = "是否开始下载" + str4;
        _cy _cyVar = new _cy(context2, _hVar2, str4, str5, _euVar2);
        _cr _crVar = _8._a;
        if (_crVar != null) {
            _crVar.dismiss();
            _8._a = null;
        }
        _cr _crVar2 = new _cr(activity);
        _8._a = _crVar2;
        _crVar2._f = str6;
        TextView textView = _crVar2._d;
        if (textView != null) {
            textView.setText(str6);
        }
        _8._a.setOnDismissListener(new _5(_cyVar));
        _cr _crVar3 = _8._a;
        _crVar3._g = new _6(_cyVar);
        _crVar3.setOnKeyListener(new _7());
        Logger.d("PTG_QM_TAG show() ");
        _8._a.show();
    }
}
