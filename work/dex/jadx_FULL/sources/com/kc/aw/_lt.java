package com.kc.aw;

import android.media.MediaPlayer;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lt implements MediaPlayer.OnCompletionListener {
    public final _lg _a;

    public _lt(_lg _lgVar) {
        this._a = _lgVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        _la _laVar_a = _la._a();
        String str = this._a._a2;
        if (str == null) {
            _laVar_a.getClass();
        } else {
            List list = (List) _laVar_a._c.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoComplete();
                }
            }
        }
        _lg _lgVar = this._a;
        _lgVar._x = true;
        _lgVar._a();
    }
}
