package com.kc.aw;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bv extends Handler {
    public final long _a = 1000;
    public final _bw._a _b;
    public final _bw _c;

    public _bv(_bw _bwVar, _n0 _n0Var) {
        this._c = _bwVar;
        this._b = _n0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            _bw _bwVar = this._c;
            long j = _bwVar._b;
            if (j <= 0) {
                _bwVar._c = false;
                _bw._a _aVar = this._b;
                if (_aVar != null) {
                    ((_n0) _aVar)._a();
                    return;
                }
                return;
            }
            long j2 = j - this._a;
            _bwVar._b = j2;
            _bw._a _aVar2 = this._b;
            if (_aVar2 != null) {
                _mz _mzVar = ((_n0) _aVar2)._a;
                _mzVar._b = j2;
                TextView textView = _mzVar._e;
                if (textView != null) {
                    textView.setText(String.valueOf((j2 / 1000) + 1));
                }
            }
            sendEmptyMessageDelayed(1, this._a);
        }
    }
}
