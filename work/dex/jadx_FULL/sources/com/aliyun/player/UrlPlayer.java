package com.aliyun.player;

import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.source.BitStreamSource;
import com.aliyun.player.source.UrlSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface UrlPlayer extends IPlayer {
    void enableDowngrade(UrlSource urlSource, PlayerConfig playerConfig);

    void setDataSource(BitStreamSource bitStreamSource);

    void setDataSource(UrlSource urlSource);
}
