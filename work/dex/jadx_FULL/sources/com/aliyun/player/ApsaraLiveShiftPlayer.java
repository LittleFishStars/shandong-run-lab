package com.aliyun.player;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.aliyun.liveshift.LiveTimeUpdater;
import com.aliyun.player.nativeclass.JniSaasPlayer;
import com.aliyun.player.nativeclass.NativePlayerBase;
import com.aliyun.player.source.LiveShift;
import com.aliyun.player.source.UrlSource;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class ApsaraLiveShiftPlayer extends AVPBase implements AliLiveShiftPlayer {
    public static final int SeekLive = 10;
    private IPlayer.OnLoadingStatusListener innerOnLoadingStatusListener;
    private IPlayer.OnStateChangedListener innerOnStateChangedListener;
    private long liveSeekOffset;
    private long liveSeekToTime;
    private LiveShift liveShiftSource;
    private LiveTimeUpdater liveTimeUpdater;
    private IPlayer.OnLoadingStatusListener mOnLoadingStatusListener;
    private IPlayer.OnPreparedListener mOnPreparedListener;
    private IPlayer.OnStateChangedListener mOnStateChangedListener;
    private AliLiveShiftPlayer.OnSeekLiveCompletionListener mOutSeekLiveCompletionListener;
    private AliLiveShiftPlayer.OnTimeShiftUpdaterListener mOutTimeShiftUpdaterListener;
    private int status;
    private int statusWhenSeek;
    private InnerTimeShiftUpdaterListener timeShiftUpdaterListener;

    public static class InnerOnLoadingStatusListener implements IPlayer.OnLoadingStatusListener {
        private WeakReference<ApsaraLiveShiftPlayer> playerWR;

        public InnerOnLoadingStatusListener(ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingBegin();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingEnd();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i, float f) {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onLoadingProgress(i, f);
            }
        }
    }

    public static class InnerPreparedListener implements IPlayer.OnPreparedListener {
        private WeakReference<ApsaraLiveShiftPlayer> playerWR;

        public InnerPreparedListener(ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnPreparedListener
        public void onPrepared() {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onPrepared();
            }
        }
    }

    public static class InnerStateChangedListener implements IPlayer.OnStateChangedListener {
        private WeakReference<ApsaraLiveShiftPlayer> playerWR;

        public InnerStateChangedListener(ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerWR = new WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.IPlayer.OnStateChangedListener
        public void onStateChanged(int i) {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerWR.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onStateChanged(i);
            }
        }
    }

    public static class InnerTimeShiftUpdaterListener implements AliLiveShiftPlayer.OnTimeShiftUpdaterListener {
        private WeakReference<ApsaraLiveShiftPlayer> playerReference;

        public InnerTimeShiftUpdaterListener(ApsaraLiveShiftPlayer apsaraLiveShiftPlayer) {
            this.playerReference = new WeakReference<>(apsaraLiveShiftPlayer);
        }

        @Override // com.aliyun.player.AliLiveShiftPlayer.OnTimeShiftUpdaterListener
        public void onUpdater(long j, long j2, long j3) {
            ApsaraLiveShiftPlayer apsaraLiveShiftPlayer = this.playerReference.get();
            if (apsaraLiveShiftPlayer != null) {
                apsaraLiveShiftPlayer.onUpdater(j, j2, j3);
            }
        }
    }

    public ApsaraLiveShiftPlayer(Context context, String str) {
        super(context, str);
        this.liveSeekToTime = -1L;
        this.liveSeekOffset = -1L;
        this.liveShiftSource = null;
        this.liveTimeUpdater = null;
        this.timeShiftUpdaterListener = null;
        this.mOutSeekLiveCompletionListener = null;
        this.mOnPreparedListener = null;
        this.mOnStateChangedListener = null;
        this.innerOnStateChangedListener = new InnerStateChangedListener(this);
        this.mOnLoadingStatusListener = null;
        this.innerOnLoadingStatusListener = new InnerOnLoadingStatusListener(this);
        this.mOutTimeShiftUpdaterListener = null;
        this.timeShiftUpdaterListener = new InnerTimeShiftUpdaterListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingBegin() {
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.pauseUpdater();
        }
        IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingBegin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingEnd() {
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.resumeUpdater();
        }
        IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingProgress(int i, float f) {
        IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingProgress(i, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared() {
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.stopUpdater();
        } else {
            LiveTimeUpdater liveTimeUpdater2 = new LiveTimeUpdater(this.mContext, this.liveShiftSource);
            this.liveTimeUpdater = liveTimeUpdater2;
            liveTimeUpdater2.setUpdaterListener(this.timeShiftUpdaterListener);
        }
        this.liveTimeUpdater.setConfig(getConfig());
        this.liveTimeUpdater.setStartPlayTime(this.liveSeekToTime);
        this.liveTimeUpdater.startUpdater();
        int i = this.status;
        this.status = 2;
        if (i != 10) {
            IPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
                return;
            }
            return;
        }
        if (this.statusWhenSeek == 3) {
            start();
        } else if (isAutoPlay()) {
            this.liveTimeUpdater.resumeUpdater();
        } else {
            this.liveTimeUpdater.pauseUpdater();
        }
        AliLiveShiftPlayer.OnSeekLiveCompletionListener onSeekLiveCompletionListener = this.mOutSeekLiveCompletionListener;
        if (onSeekLiveCompletionListener != null) {
            onSeekLiveCompletionListener.onSeekLiveCompletion(this.liveSeekToTime);
        }
        this.liveSeekToTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChanged(int i) {
        if (i != 2) {
            this.status = i;
        }
        IPlayer.OnStateChangedListener onStateChangedListener = this.mOnStateChangedListener;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdater(long j, long j2, long j3) {
        AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener = this.mOutTimeShiftUpdaterListener;
        if (onTimeShiftUpdaterListener != null) {
            onTimeShiftUpdaterListener.onUpdater(j, j2, j3);
        }
    }

    @Override // com.aliyun.player.AVPBase
    public NativePlayerBase createAlivcMediaPlayer(Context context) {
        return new JniSaasPlayer(context);
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public long getCurrentLiveTime() {
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            return liveTimeUpdater.getLiveTime();
        }
        return 0L;
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public long getCurrentTime() {
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            return liveTimeUpdater.getPlayTime();
        }
        return 0L;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void pause() {
        super.pause();
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.pauseUpdater();
        }
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void seekToLiveTime(long j) {
        StringBuilder sb;
        String str;
        int i = this.status;
        if (i == 10 || this.liveShiftSource == null) {
            return;
        }
        this.statusWhenSeek = i;
        this.status = 10;
        this.liveSeekToTime = j;
        long currentLiveTime = getCurrentLiveTime() - this.liveSeekToTime;
        this.liveSeekOffset = currentLiveTime;
        if (currentLiveTime < 0) {
            this.liveSeekOffset = 0L;
            this.liveSeekToTime = getCurrentLiveTime();
        }
        String url = this.liveShiftSource.getUrl();
        if (this.liveSeekToTime > 0 && this.liveSeekOffset > 0) {
            String query = Uri.parse(url).getQuery();
            if (url.endsWith("?") || url.endsWith("&")) {
                sb = new StringBuilder();
                sb.append(url);
                str = "lhs_offset_unix_s_0=";
            } else if (TextUtils.isEmpty(query)) {
                sb = new StringBuilder();
                sb.append(url);
                str = "?lhs_offset_unix_s_0=";
            } else {
                sb = new StringBuilder();
                sb.append(url);
                str = "&lhs_offset_unix_s_0=";
            }
            sb.append(str);
            sb.append(this.liveSeekOffset);
            sb.append("&lhs_start=1&aliyunols=on");
            url = sb.toString();
        }
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(url);
        NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasPlayer) {
            ((JniSaasPlayer) corePlayer).setDataSource(urlSource);
            corePlayer.prepare();
        }
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setDataSource(LiveShift liveShift) {
        this.liveShiftSource = liveShift;
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(liveShift.getUrl());
        NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof JniSaasPlayer) {
            ((JniSaasPlayer) corePlayer).setDataSource(urlSource);
        }
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnLoadingStatusListener(IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLoadingStatusListener = onLoadingStatusListener;
        super.setOnLoadingStatusListener(this.innerOnLoadingStatusListener);
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        super.setOnPreparedListener(new InnerPreparedListener(this));
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setOnSeekLiveCompletionListener(AliLiveShiftPlayer.OnSeekLiveCompletionListener onSeekLiveCompletionListener) {
        this.mOutSeekLiveCompletionListener = onSeekLiveCompletionListener;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void setOnStateChangedListener(IPlayer.OnStateChangedListener onStateChangedListener) {
        this.mOnStateChangedListener = onStateChangedListener;
        super.setOnStateChangedListener(this.innerOnStateChangedListener);
    }

    @Override // com.aliyun.player.AliLiveShiftPlayer
    public void setOnTimeShiftUpdaterListener(AliLiveShiftPlayer.OnTimeShiftUpdaterListener onTimeShiftUpdaterListener) {
        this.mOutTimeShiftUpdaterListener = onTimeShiftUpdaterListener;
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void start() {
        super.start();
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.resumeUpdater();
        }
    }

    @Override // com.aliyun.player.AVPBase, com.aliyun.player.IPlayer
    public void stop() {
        super.stop();
        LiveTimeUpdater liveTimeUpdater = this.liveTimeUpdater;
        if (liveTimeUpdater != null) {
            liveTimeUpdater.stopUpdater();
        }
    }
}
