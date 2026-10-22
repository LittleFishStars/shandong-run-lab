package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.activity.PtgInteractionPortraitActivity;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fk {
    public static _fk _g;
    public final ConcurrentHashMap<String, _fm> _a = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, _h> _b = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, AdSlot> _c = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgInteractionAd.AdInteractionListener> _d = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgVideoAdListener> _e = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgInteractionPortraitActivity._c> _f = new ConcurrentHashMap<>();

    public static _fk _a() {
        if (_g == null) {
            synchronized (_fk.class) {
                try {
                    if (_g == null) {
                        _g = new _fk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return _g;
    }

    public final void _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this._a.remove(str);
        this._b.remove(str);
        this._c.remove(str);
        this._d.remove(str);
        this._e.remove(str);
        this._f.remove(str);
    }

    public final void _a(String str, String str2) {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        if (TextUtils.isEmpty(str) || (adInteractionListener = this._d.get(str)) == null) {
            return;
        }
        AdErrorImpl adErrorImpl = new AdErrorImpl();
        adErrorImpl._c = PtgApiProvider.providerName;
        adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
        adErrorImpl._e = str2;
        adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
        adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_1;
        adInteractionListener.onRenderError(adErrorImpl);
    }
}
