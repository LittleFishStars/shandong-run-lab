package com.aliyun.player;

import com.aliyun.player.source.LiveShift;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AliLiveShiftPlayer extends IPlayer {

    public interface OnSeekLiveCompletionListener {
        void onSeekLiveCompletion(long j);
    }

    public interface OnTimeShiftUpdaterListener {
        void onUpdater(long j, long j2, long j3);
    }

    long getCurrentLiveTime();

    long getCurrentTime();

    void seekToLiveTime(long j);

    void setDataSource(LiveShift liveShift);

    void setOnSeekLiveCompletionListener(OnSeekLiveCompletionListener onSeekLiveCompletionListener);

    void setOnTimeShiftUpdaterListener(OnTimeShiftUpdaterListener onTimeShiftUpdaterListener);
}
