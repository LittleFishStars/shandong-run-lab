package com.kc.aw.activity;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f implements PtgInteractionPortraitActivity._c {
    public final PtgInteractionPortraitActivity _a;

    public _f(PtgInteractionPortraitActivity ptgInteractionPortraitActivity) {
        this._a = ptgInteractionPortraitActivity;
    }

    @Override // com.kc.aw.activity.PtgInteractionPortraitActivity._c
    public final void _a() {
        try {
            if (this._a.isFinishing()) {
                return;
            }
            this._a.finish();
        } catch (Exception unused) {
        }
    }
}
