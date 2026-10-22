package com.kc.aw;

import android.content.Context;
import android.widget.LinearLayout;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _al extends LinearLayout implements _ai {
    public _t _a;
    public AdSlot _b;

    public _al(Context context) {
        super(context);
        _a(context);
    }

    public abstract void _a(Context context);

    @Override // com.kc.aw._ai
    public final boolean _a() {
        return _fp._a(getContext());
    }

    @Override // com.kc.aw._ai
    public final boolean _b() {
        return !hasWindowFocus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public abstract void setAd(_h _hVar);

    public void setAdClickListener(_j _jVar) {
    }

    public void setAdRenderListener(_t _tVar) {
        this._a = _tVar;
    }

    public void setAdShowListener(_u _uVar) {
    }

    public void setAdvertSlot(AdSlot adSlot) {
        this._b = adSlot;
    }

    public abstract /* synthetic */ void setVisibilityChanged(_aj._a _aVar);
}
