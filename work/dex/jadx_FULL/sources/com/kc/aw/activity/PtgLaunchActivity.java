package com.kc.aw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.kc.aw._fn;
import com.kc.aw._jh;
import com.kc.aw._ji;
import com.kc.aw._jj;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgLaunchActivity extends Activity {
    public static final int _b = 0;
    public _ji _a;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            _jh _jhVar = (_jh) _jj._a.remove(getIntent().getStringExtra("cache_id"));
            if (_jhVar != null) {
                this._a = new _ji(this, _jhVar._b, _jhVar._a);
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        _ji _jiVar = this._a;
        if (_jiVar != null) {
            _fn _fnVar = _jiVar._a;
            if (_fnVar != null) {
                _fnVar._a = null;
                _fnVar._b = null;
                _jiVar._a = null;
            }
            this._a = null;
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        _fn _fnVar;
        super.onPause();
        _ji _jiVar = this._a;
        if (_jiVar == null || (_fnVar = _jiVar._a) == null) {
            return;
        }
        _fnVar._d = true;
    }

    @Override // android.app.Activity
    public final void onResume() {
        _fn _fnVar;
        super.onResume();
        _ji _jiVar = this._a;
        if (_jiVar == null || (_fnVar = _jiVar._a) == null) {
            return;
        }
        try {
            if (_fnVar._d) {
                if (!_fnVar._e) {
                    _fnVar._f = false;
                    _fnVar._j = -4104;
                    _fnVar._a(this);
                } else if (!isFinishing()) {
                    finish();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        _fn _fnVar;
        super.onStop();
        _ji _jiVar = this._a;
        if (_jiVar == null || (_fnVar = _jiVar._a) == null) {
            return;
        }
        try {
            _fnVar._e = true;
            if (_fnVar._f) {
                _fnVar._f = false;
                _fnVar._b();
            }
            if (isFinishing()) {
                return;
            }
            finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 1) && !isFinishing()) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }
}
