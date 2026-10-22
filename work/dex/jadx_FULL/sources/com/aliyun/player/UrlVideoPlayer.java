package com.aliyun.player;

import android.content.Context;
import com.aliyun.player.nativeclass.JniSaasPlayer;
import com.aliyun.player.nativeclass.JniUrlPlayer;
import com.aliyun.player.nativeclass.NativePlayerBase;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.source.BitStreamSource;
import com.aliyun.player.source.UrlSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UrlVideoPlayer extends AVPBase implements UrlPlayer {
    public UrlVideoPlayer(Context context, String str) {
        super(context, str);
    }

    @Override // com.aliyun.player.AVPBase
    public NativePlayerBase createAlivcMediaPlayer(Context context) {
        return new JniUrlPlayer(context);
    }

    @Override // com.aliyun.player.UrlPlayer
    public void enableDowngrade(UrlSource urlSource, PlayerConfig playerConfig) {
        NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasPlayer) {
            ((JniSaasPlayer) corePlayer).enableDowngrade(urlSource, playerConfig);
        }
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(BitStreamSource bitStreamSource) {
        NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasPlayer) {
            ((JniSaasPlayer) corePlayer).setDataSource(bitStreamSource);
        }
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(UrlSource urlSource) {
        NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasPlayer) {
            ((JniSaasPlayer) corePlayer).setDataSource(urlSource);
        }
    }
}
