package com.kc.aw.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.aw._fk;
import com.kc.aw._fm;
import com.kc.aw._h;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a implements PtgInteractionPortraitActivity._b {
    public final Activity _a;
    public final _h _b;
    public final AdSlot _c;

    public _a(Activity activity, _h _hVar, AdSlot adSlot) {
        this._a = activity;
        this._b = _hVar;
        this._c = adSlot;
    }

    public final void _a() {
        _h _hVar;
        if (this._a == null || (_hVar = this._b) == null || this._c == null) {
            return;
        }
        _fm _fmVar = _hVar._C;
        _fk _fkVar_a = _fk._a();
        String strValueOf = String.valueOf(this._b.hashCode());
        _h _hVar2 = this._b;
        AdSlot adSlot = this._c;
        _fkVar_a.getClass();
        if (!TextUtils.isEmpty(strValueOf)) {
            if (_fmVar != null) {
                _fkVar_a._a.putIfAbsent(strValueOf, _fmVar);
            }
            _fkVar_a._b.putIfAbsent(strValueOf, _hVar2);
            _fkVar_a._c.putIfAbsent(strValueOf, adSlot);
        }
        Intent intent = new Intent(this._a, (Class<?>) PtgInteractionPortraitActivity.class);
        if (_fmVar != null && _fmVar._a == 1) {
            intent = new Intent(this._a, (Class<?>) PtgInteractionLandscapeActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("advert_hash_code_key", String.valueOf(this._b.hashCode()));
        this._a.startActivity(intent);
    }

    public final void _a(String str) {
        if (this._b != null) {
            _fk._a()._a(String.valueOf(this._b.hashCode()), str);
            _fk._a()._a(String.valueOf(this._b.hashCode()));
        }
    }
}
