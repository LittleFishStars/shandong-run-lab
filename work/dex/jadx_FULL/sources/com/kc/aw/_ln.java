package com.kc.aw;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.kc.aw.activity.PtgRewardVideoPortraitActivity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ln implements View.OnClickListener {
    public final _le _a;
    public final Activity _b;
    public final _lg _c;

    public _ln(_lg _lgVar, PtgRewardVideoPortraitActivity._a _aVar, Activity activity) {
        this._c = _lgVar;
        this._a = _aVar;
        this._b = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = this._c._I;
        int i = 0;
        if (textView != null) {
            Object tag = textView.getTag();
            int iIntValue = tag instanceof Integer ? ((Integer) tag).intValue() : 0;
            if (iIntValue >= 0) {
                i = iIntValue;
            }
        }
        long j = (long) (_lg._aa / 1000.0f);
        if (i == 0) {
            _c._a()._a(_hj._a(this._c._b), j);
            _le _leVar = this._a;
            if (_leVar != null) {
                ((PtgRewardVideoPortraitActivity._a) _leVar)._a._a();
                return;
            }
            return;
        }
        _lg _lgVar = this._c;
        Activity activity = this._b;
        _le _leVar2 = this._a;
        String str = "再看" + i + "秒可领奖励";
        if (_lgVar._a9 == null) {
            _b9 _b9Var = new _b9(activity);
            _lgVar._a9 = _b9Var;
            _b9Var._g = str;
            TextView textView2 = _b9Var._d;
            if (textView2 != null) {
                textView2.setText(str);
            }
            _lgVar._a9.setOnDismissListener(new _ll(_lgVar));
            _b9 _b9Var2 = _lgVar._a9;
            _b9Var2._h = new _lm(_lgVar, j, _leVar2);
            _b9Var2.setOnKeyListener(new _lo());
            _lgVar._a9.show();
        }
    }
}
