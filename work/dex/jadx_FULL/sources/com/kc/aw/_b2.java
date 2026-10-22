package com.kc.aw;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.activity.PtgLaunchActivity;
import com.kc.aw.activity.PtgWebActivity;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b2 {
    public static void _a(Context context, _aj _ajVar, _h _hVar, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, _j _jVar) {
        _k _kVar;
        _n9 _n9Var;
        String str;
        _n9 _n9Var2;
        _k _kVar2;
        _n9 _n9Var3 = new _n9();
        if (_hVar == null) {
            return;
        }
        _k _kVar3 = _hVar._q;
        if (_kVar3 != null) {
            int i = _kVar3._a;
            _n9Var3._a = i == 0 || i == 2;
            _n9Var3._c = i == 1 || i == 2;
            _n9Var3._e = _kVar3._j;
            boolean z_c = _kVar3._c();
            _n9Var3._b = _kVar3._d(z_c);
            _n9Var3._d = _kVar3._b(z_c);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = String.valueOf(_hVar.hashCode());
        if (textView != null) {
            _m1._a(frameLayout, textView, null);
            textView.setVisibility(_n9Var3._a ? 0 : 4);
            textView.setOnClickListener(new _n4(_n9Var3, _ajVar, _hVar, strValueOf, _jVar));
        }
        if (frameLayout != null) {
            _m1._a(frameLayout, frameLayout, textView);
            frameLayout.setEnabled(_n9Var3._b);
            frameLayout.setOnClickListener(new _n5(_n9Var3, _ajVar, _hVar, strValueOf, _jVar));
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(_n9Var3._c ? 0 : 8);
        }
        if (!_n9Var3._a(_kVar3)) {
            _kVar = _kVar3;
            _n9Var = _n9Var3;
            str = strValueOf;
            if (_n9Var._c || _n9Var._d) {
                _mf _mfVar_a = _mf._a(str, false, _kVar);
                strValueOf = str;
                _n9Var2 = _n9Var;
                _kVar2 = _kVar;
                _mg._a(context, new _n7(_n9Var, linearLayout, _mfVar_a, jCurrentTimeMillis, _ajVar, _hVar, str, _kVar, false, _jVar), _mfVar_a);
            } else {
                strValueOf = str;
                _n9Var2 = _n9Var;
                _kVar2 = _kVar;
            }
        } else if (1 == _n9Var3._e) {
            _mf _mfVar_a2 = _mf._a(strValueOf, true, _kVar3);
            _mg._a(context, new _n7(_n9Var3, linearLayout, _mfVar_a2, jCurrentTimeMillis, _ajVar, _hVar, strValueOf, _kVar3, true, _jVar), _mfVar_a2);
            _kVar2 = _kVar3;
            _n9Var2 = _n9Var3;
        } else {
            _kVar = _kVar3;
            _n9Var = _n9Var3;
            str = strValueOf;
            if (_kVar != null) {
                if (_n9Var._h == null) {
                    _n9Var._h = new _n8(_n9Var, _kVar, textView);
                }
                _n9Var._g.removeCallbacks(_n9Var._h);
                _n9Var._g.postDelayed(_n9Var._h, _kVar._a());
            }
            strValueOf = str;
            _n9Var2 = _n9Var;
            _kVar2 = _kVar;
        }
        if (_ajVar != null) {
            _ajVar.setVisibilityChanged(new _n6(_n9Var2, _kVar2, context, _hVar, _ajVar, linearLayout, _jVar, strValueOf, jCurrentTimeMillis));
        }
    }

    public static void _a(Context context, _h _hVar, AdSlot adSlot) {
        if (_hVar._x) {
            PtgAdProxy.onAdClicked(_hVar, adSlot);
        }
        int i = _hVar._a;
        if (i == 1) {
            if (!TextUtils.isEmpty(_hVar._d)) {
                int i2 = PtgLaunchActivity._b;
                try {
                    String str_a = _jj._a(new _jh(_hVar, adSlot));
                    Intent intent = new Intent(context, (Class<?>) PtgLaunchActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra("cache_id", str_a);
                    context.startActivity(intent);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (TextUtils.isEmpty(_hVar._i)) {
                return;
            }
        } else if (i != 2 || _o9._a(context, _hVar, adSlot) || TextUtils.isEmpty(_hVar._i)) {
            return;
        }
        PtgWebActivity._a(context, _hVar);
    }
}
