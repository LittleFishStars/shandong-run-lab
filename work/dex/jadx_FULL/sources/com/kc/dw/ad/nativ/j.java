package com.kc.dw.ad.nativ;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.core.safe.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39134a;

    public j(NormalMediaView normalMediaView) {
        this.f39134a = normalMediaView;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    @Override // com.kc.dw.core.safe.g
    public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        String str2;
        MediaPlayer.OnInfoListener onInfoListener;
        NormalMediaView normalMediaView = this.f39134a;
        if (!normalMediaView.b.j) {
            return true;
        }
        if (i != 701) {
            if (i == 702) {
                normalMediaView.c.b(R.id.ms_progress_loading).d(8);
                str = this.f39134a.f39125a;
                str2 = "MediaPlayer.MEDIA_INFO_BUFFERING_END";
            }
            onInfoListener = this.f39134a.A;
            if (onInfoListener != null) {
                onInfoListener.onInfo(mediaPlayer, i, i2);
            }
            return true;
        }
        normalMediaView.c.b(R.id.ms_progress_loading).d(0);
        str = this.f39134a.f39125a;
        str2 = "MediaPlayer.MEDIA_INFO_BUFFERING_START";
        LogUtil.d(str, str2);
        onInfoListener = this.f39134a.A;
        if (onInfoListener != null) {
            onInfoListener.onInfo(mediaPlayer, i, i2);
        }
        return true;
    }
}
