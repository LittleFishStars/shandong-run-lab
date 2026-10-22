package com.kc.aw.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.kc.aw._d3;
import com.kc.aw._f6;
import com.kc.aw._fa;
import com.kc.aw._fh;
import com.kc.aw._fj;
import com.kc.aw._fk;
import com.kc.aw._fm;
import com.kc.aw._h;
import com.kc.aw._h8;
import com.kc.aw._in;
import com.kc.aw._je;
import com.kc.aw._jf;
import com.kc.aw._k8;
import com.kc.aw._m1;
import com.kc.aw._mg;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdSlot;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgInteractionPortraitActivity extends Activity {
    public static final int _e = 0;
    public String _a;
    public _je _b;
    public FrameLayout _c;
    public final _a _d = new _a(this);

    @Keep
    public final class _a implements _f6 {
        public final PtgInteractionPortraitActivity _a;

        public _a(PtgInteractionPortraitActivity ptgInteractionPortraitActivity) {
            this._a = ptgInteractionPortraitActivity;
        }
    }

    @Keep
    public interface _b {
    }

    @Keep
    public interface _c {
        void _a();
    }

    public static void _a(Activity activity, _h _hVar, com.kc.aw.activity._a _aVar) {
        int i;
        Handler handler;
        _d3._c _cVar;
        Handler handler2;
        _d3._c _cVar2;
        if (_hVar._s()) {
            _k8 _k8Var_l = _hVar._l();
            String str = _k8Var_l._b;
            if (!TextUtils.isEmpty(str)) {
                _d3 _d3Var = new _d3(activity, new com.kc.aw.activity._c(_aVar));
                _d3Var._i = 3000;
                _d3Var._h = true;
                _d3Var.executeOnExecutor(_d3Var._f, str);
                int i2 = _d3Var._i;
                if (i2 <= 0 || (handler2 = _d3Var._a) == null || (_cVar2 = _d3Var._l) == null) {
                    return;
                }
                handler2.postDelayed(_cVar2, i2);
                return;
            }
            String str2 = _k8Var_l._a;
            _d3 _d3Var2 = new _d3(activity, new _d(_aVar));
            _d3Var2._g = true;
            _d3Var2._i = 3000;
            _d3Var2._h = true;
            _d3Var2.executeOnExecutor(_d3Var2._f, str2);
            i = _d3Var2._i;
            if (i <= 0 || (handler = _d3Var2._a) == null || (_cVar = _d3Var2._l) == null) {
                return;
            }
        } else {
            String str_b = _hVar._b();
            _d3 _d3Var3 = new _d3(activity, new _e(_aVar));
            _d3Var3._i = 3000;
            _d3Var3._h = true;
            _d3Var3.executeOnExecutor(_d3Var3._f, str_b);
            i = _d3Var3._i;
            if (i <= 0 || (handler = _d3Var3._a) == null || (_cVar = _d3Var3._l) == null) {
                return;
            }
        }
        handler.postDelayed(_cVar, i);
    }

    public void _a() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        _je _jeVar = this._b;
        if (_jeVar != null) {
            _fh _fhVar = _jeVar._a;
            if (_fhVar != null ? _fhVar._f : true) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        _a();
        super.onCreate(bundle);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        _h8._a().getClass();
        _h8._a(window);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this._a = intent.getStringExtra("advert_hash_code_key");
                try {
                    _fk _fkVar_a = _fk._a();
                    String str = this._a;
                    _f _fVar = new _f(this);
                    _fkVar_a.getClass();
                    if (!TextUtils.isEmpty(str)) {
                        if (_fkVar_a._f.contains(str)) {
                            _fkVar_a._f.remove(str);
                        }
                        _fkVar_a._f.put(str, _fVar);
                    }
                } catch (Exception unused) {
                }
            }
            _je _jeVar = new _je();
            this._b = _jeVar;
            String str2 = this._a;
            _a _aVar = this._d;
            _fh _fhVar = new _fh();
            _jeVar._a = _fhVar;
            _fhVar._c = str2;
            _fk _fkVar_a2 = _fk._a();
            if (_aVar != null) {
                _fkVar_a2.getClass();
                _fhVar._d = TextUtils.isEmpty(str2) ? null : _fkVar_a2._b.get(str2);
                _fk _fkVar_a3 = _fk._a();
                _fkVar_a3.getClass();
                AdSlot adSlot = TextUtils.isEmpty(str2) ? null : _fkVar_a3._c.get(str2);
                _fhVar._e = adSlot;
                if (_fhVar._d != null && adSlot != null) {
                    _fk _fkVar_a4 = _fk._a();
                    _fkVar_a4.getClass();
                    _fm _fmVar = TextUtils.isEmpty(str2) ? null : _fkVar_a4._a.get(str2);
                    if (_fmVar != null) {
                        _fhVar._a = _fmVar._a;
                        _fhVar._b = _fmVar._b;
                    }
                    PtgInteractionPortraitActivity ptgInteractionPortraitActivity = _aVar._a;
                    ptgInteractionPortraitActivity.setContentView(R.layout.aw_activity_interaction);
                    ptgInteractionPortraitActivity._c = (FrameLayout) ptgInteractionPortraitActivity.findViewById(R.id.ptgRootAdvertLayout);
                    try {
                        _fa _faVar = new _fa(this);
                        _fhVar._j = _faVar;
                        _faVar.setScreenType(_fhVar._a);
                        _fhVar._j.setScreenMode(_fhVar._b);
                        _fhVar._j.setAdvertInfo(_fhVar._d);
                        _fhVar._j.setAdvertHashCode(_fhVar._c);
                        _fhVar._j.setInteractionCallback(_aVar);
                        _fhVar._j.setAdvertActionCallback(new _fj(_fhVar, _aVar, this));
                        _fhVar._k = _fhVar._j._a();
                        _in _inVar = new _in(_fhVar._d, _fhVar._h);
                        _fhVar._g = _inVar;
                        View view = _fhVar._k;
                        _inVar._c = view;
                        _inVar._d = view;
                        _m1._a(view, view, null);
                        FrameLayout frameLayout = _aVar._a._c;
                        _fhVar._i = frameLayout;
                        frameLayout.removeAllViews();
                        _fhVar._i.addView(_fhVar._j);
                        return;
                    } catch (Exception e) {
                        StringBuilder sb_a = _jf._a("页面加载异常：");
                        sb_a.append(e.getMessage());
                        try {
                            _fk._a()._a(_fhVar._c, sb_a.toString());
                            _fhVar._f = true;
                            _aVar._a.onBackPressed();
                            _in _inVar2 = _fhVar._g;
                            if (_inVar2 != null) {
                                _inVar2._a(true);
                                _inVar2._c = null;
                                _inVar2._d = null;
                                _inVar2._n = null;
                                _fhVar._g = null;
                                return;
                            }
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
                _fk._a()._a(str2, "数据加载异常");
                if (isFinishing()) {
                    return;
                }
            } else {
                _fkVar_a2._a(str2, "资源异常");
                _fk._a()._a(str2);
                if (isFinishing()) {
                    return;
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        _fh _fhVar;
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        super.onDestroy();
        _fk _fkVar_a = _fk._a();
        String str = this._a;
        _fkVar_a.getClass();
        if (!TextUtils.isEmpty(str) && _fkVar_a._f.contains(str)) {
            _fkVar_a._f.remove(str);
        }
        _fk _fkVar_a2 = _fk._a();
        String str2 = this._a;
        _fkVar_a2.getClass();
        if (!TextUtils.isEmpty(str2) && (adInteractionListener = _fkVar_a2._d.get(str2)) != null) {
            adInteractionListener.onAdDismiss();
        }
        _fk._a()._a(this._a);
        _je _jeVar = this._b;
        if (_jeVar == null || (_fhVar = _jeVar._a) == null) {
            return;
        }
        _in _inVar = _fhVar._g;
        if (_inVar != null) {
            _inVar._a(true);
            _inVar._c = null;
            _inVar._d = null;
            _inVar._n = null;
            _fhVar._g = null;
        }
        _fa _faVar = _fhVar._j;
        if (_faVar != null) {
            _faVar._a = null;
            PtgVideoView ptgVideoView = _faVar._h;
            if (ptgVideoView != null) {
                ptgVideoView._b();
                _faVar._h = null;
            }
            _fhVar._j = null;
        }
        _fhVar._i = null;
        _jeVar._a = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        _fh _fhVar;
        _in _inVar;
        super.onPause();
        _je _jeVar = this._b;
        if (_jeVar == null || (_fhVar = _jeVar._a) == null || (_inVar = _fhVar._g) == null) {
            return;
        }
        _mg._a(_inVar._b);
    }

    @Override // android.app.Activity
    public final void onResume() {
        _fh _fhVar;
        _in _inVar;
        super.onResume();
        _je _jeVar = this._b;
        if (_jeVar == null || (_fhVar = _jeVar._a) == null || (_inVar = _fhVar._g) == null) {
            return;
        }
        _inVar._b();
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
