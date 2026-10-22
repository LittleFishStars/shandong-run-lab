package com.aliyun.player;

import android.content.Context;
import com.aliyun.player.nativeclass.JniListPlayerBase;
import com.aliyun.player.nativeclass.JniSaasListPlayer;
import com.aliyun.player.source.LiveSts;
import com.aliyun.player.source.PlayAuthInfo;
import com.aliyun.player.source.StsInfo;
import com.aliyun.player.source.VidAuth;
import com.aliyun.player.source.VidMps;
import com.aliyun.player.source.VidSts;
import com.cicada.player.utils.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class ApsaraVideoListPlayer extends UrlVideoListPlayer implements AliListPlayer, AliPlayer {
    private static final String TAG = "NativePlayerBase_ApsaraVideListPlayer";
    private ApsaraVideoPlayer mSaaSPrerenderPlayer;
    private ApsaraVideoPlayer mSaasVideoPlayer;

    public ApsaraVideoListPlayer(Context context, String str) {
        super(context, str);
        this.mSaasVideoPlayer = null;
        this.mSaaSPrerenderPlayer = null;
    }

    @Override // com.aliyun.player.AliListPlayer
    public void addVid(String str, String str2) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasListPlayer) {
            Logger.v(TAG, "addVid = " + str + " , uid = " + str2);
            ((JniSaasListPlayer) corePlayer).addVid(str, str2);
        }
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public JniListPlayerBase createListPlayer(Context context, String str, long j, long j2) {
        return new JniSaasListPlayer(context, j, j2);
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public long getCurrentPlayerIndex() {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return 0L;
        }
        Logger.v(TAG, "getCurrentPlayerIndex  ");
        return ((JniSaasListPlayer) corePlayer).getCurrentPlayerIndex();
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public IPlayer getNativePlayer(Context context, String str) {
        if (this.mSaasVideoPlayer == null) {
            this.mSaasVideoPlayer = new ApsaraVideoPlayer(context, str);
        }
        return this.mSaasVideoPlayer;
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.UrlListPlayer
    public IPlayer getPreRenderPlayer() {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return null;
        }
        Logger.v(TAG, "getPreRenderPlayer  ");
        return getCurrentPrerenderPlayer(((JniSaasListPlayer) corePlayer).getPreRenderPlayerIndex());
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public IPlayer getPrerenderPlayer(Context context, String str) {
        if (this.mSaaSPrerenderPlayer == null) {
            this.mSaaSPrerenderPlayer = new ApsaraVideoPlayer(context, str);
        }
        return this.mSaaSPrerenderPlayer;
    }

    @Override // com.aliyun.player.AliPlayer
    public void invokeComponent(String str) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).invokeComponent(str);
        }
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveTo(String str, PlayAuthInfo playAuthInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveTo playauth uid = " + str);
        return ((JniSaasListPlayer) corePlayer).moveTo(str, playAuthInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveTo(String str, StsInfo stsInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveTo sts uid = " + str);
        return ((JniSaasListPlayer) corePlayer).moveTo(str, stsInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNext(PlayAuthInfo playAuthInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToNext playauth ");
        return ((JniSaasListPlayer) corePlayer).moveToNext(playAuthInfo, false);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNext(StsInfo stsInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToNext sts ");
        return ((JniSaasListPlayer) corePlayer).moveToNext(stsInfo, false);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNextWithPrerendered(PlayAuthInfo playAuthInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToNextWithPrerendered playauth ");
        return ((JniSaasListPlayer) corePlayer).moveToNext(playAuthInfo, true);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNextWithPrerendered(StsInfo stsInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToNextWithPrerendered sts ");
        return ((JniSaasListPlayer) corePlayer).moveToNext(stsInfo, true);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToPrev(PlayAuthInfo playAuthInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToPrev playauth ");
        return ((JniSaasListPlayer) corePlayer).moveToPrev(playAuthInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToPrev(StsInfo stsInfo) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof JniSaasListPlayer)) {
            return false;
        }
        Logger.v(TAG, "moveToPrev sts ");
        return ((JniSaasListPlayer) corePlayer).moveToPrev(stsInfo);
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(LiveSts liveSts) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).setDataSource(liveSts);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(VidAuth vidAuth) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).setDataSource(vidAuth);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(VidMps vidMps) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).setDataSource(vidMps);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(VidSts vidSts) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).setDataSource(vidSts);
        }
    }

    @Override // com.aliyun.player.AliListPlayer
    public void setDefinition(String str) {
        JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasListPlayer) {
            Logger.v(TAG, "setDefinition = " + str);
            ((JniSaasListPlayer) corePlayer).setDefinition(str);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setOnVerifyTimeExpireCallback(AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).setOnVerifyTimeExpireCallback(onVerifyTimeExpireCallback);
        }
    }

    @Override // com.aliyun.player.AVPLBase, com.aliyun.player.IPlayer
    public void stop() {
        super.stop();
        JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasListPlayer) {
            ((JniSaasListPlayer) corePlayer).stop();
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateStsInfo(StsInfo stsInfo) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).updateStsInfo(stsInfo);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateVidAuth(VidAuth vidAuth) {
        IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof ApsaraVideoPlayer) {
            ((ApsaraVideoPlayer) nativePlayer).updateVidAuth(vidAuth);
        }
    }
}
