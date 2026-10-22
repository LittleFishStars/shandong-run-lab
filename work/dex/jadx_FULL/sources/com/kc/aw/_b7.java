package com.kc.aw;

import android.view.View;
import com.kc.aw.activity.PtgRewardVideoPortraitActivity;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b7 implements View.OnClickListener {
    public final _b9 _a;

    public _b7(_b9 _b9Var) {
        this._a = _b9Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this._a.dismiss();
        _b9._a _aVar = this._a._h;
        if (_aVar != null) {
            _lm _lmVar = (_lm) _aVar;
            _la _laVar_a = _la._a();
            String str = _lmVar._c._a2;
            if (str == null) {
                _laVar_a.getClass();
            } else {
                List list = (List) _laVar_a._c.get(str);
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onSkippedVideo();
                    }
                }
            }
            _c._a()._a(_hj._a(_lmVar._c._b), _lmVar._a);
            _lmVar._c.getClass();
            _le _leVar = _lmVar._b;
            if (_leVar != null) {
                ((PtgRewardVideoPortraitActivity._a) _leVar)._a._a();
            }
        }
    }
}
