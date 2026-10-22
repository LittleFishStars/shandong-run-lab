package com.aliyun.player.nativeclass;

import android.content.Context;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.source.LiveSts;
import com.aliyun.player.source.StsInfo;
import com.aliyun.player.source.VidAuth;
import com.aliyun.player.source.VidMps;
import com.aliyun.player.source.VidSts;
import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JniSaasPlayer extends JniUrlPlayer {
    private static final String TAG = "JniSaasPlayer";
    private AliPlayer.OnVerifyTimeExpireCallback mOnVerifyTimeExpireCallback;

    static {
        f.b();
    }

    public JniSaasPlayer(Context context) {
        super(context);
        this.mOnVerifyTimeExpireCallback = null;
    }

    public static void loadClass() {
    }

    private native void nSetDataSource(LiveSts liveSts);

    private native void nSetDataSource(VidAuth vidAuth);

    private native void nSetDataSource(VidMps vidMps);

    private native void nSetDataSource(VidSts vidSts);

    private native void nUpdateStsInfo(StsInfo stsInfo);

    private native void nUpdateVidAuth(VidAuth vidAuth);

    public int onVerifyAuthCallback(Object obj) {
        VidAuth vidAuth = (VidAuth) obj;
        AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOnVerifyTimeExpireCallback;
        return (onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifyAuth(vidAuth) : AliPlayer.Status.Invalid).ordinal();
    }

    public int onVerifyStsCallback(Object obj) {
        StsInfo stsInfo = (StsInfo) obj;
        AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOnVerifyTimeExpireCallback;
        return (onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifySts(stsInfo) : AliPlayer.Status.Invalid).ordinal();
    }

    public void setDataSource(LiveSts liveSts) {
        nSetDataSource(liveSts);
    }

    public void setDataSource(VidAuth vidAuth) {
        nSetDataSource(vidAuth);
    }

    public void setDataSource(VidMps vidMps) {
        nSetDataSource(vidMps);
    }

    public void setDataSource(VidSts vidSts) {
        nSetDataSource(vidSts);
    }

    public void setOnVerifyTimeExpireCallback(AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback) {
        this.mOnVerifyTimeExpireCallback = onVerifyTimeExpireCallback;
    }

    public void updateStsInfo(StsInfo stsInfo) {
        nUpdateStsInfo(stsInfo);
    }

    public void updateVidAuth(VidAuth vidAuth) {
        nUpdateVidAuth(vidAuth);
    }
}
