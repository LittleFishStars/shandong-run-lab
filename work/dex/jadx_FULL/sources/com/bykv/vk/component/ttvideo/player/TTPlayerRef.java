package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.os.RemoteException;
import android.view.Surface;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = "TTPlayerRef";
    private static String mAppPath;
    private static String mLoadErr;
    private TTPlayerClient mClient;
    private Context mContext;
    private long mId = System.currentTimeMillis();
    private TTPlayer mPlayer;

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0020 A[Catch: all -> 0x006a, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:20:0x003a, B:25:0x0049, B:26:0x0061, B:24:0x0045, B:27:0x0062, B:28:0x0069, B:21:0x003f, B:16:0x002b), top: B:38:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0024 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:20:0x003a, B:25:0x0049, B:26:0x0061, B:24:0x0045, B:27:0x0062, B:28:0x0069, B:21:0x003f, B:16:0x002b), top: B:38:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[Catch: all -> 0x006a, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:20:0x003a, B:25:0x0049, B:26:0x0061, B:24:0x0045, B:27:0x0062, B:28:0x0069, B:21:0x003f, B:16:0x002b), top: B:38:0x0003, inners: #0, #1, #2 }] */
    public static final synchronized TTPlayerRef create(TTPlayerClient tTPlayerClient, Context context) {
        TTPlayerRef tTPlayerRef;
        String string;
        if (mAppPath == null) {
            mAppPath = TTPlayerConfiger.getAppFileCachePath(context);
            try {
                if (TTPlayer.getAppPath() == null) {
                    TTPlayer.setTempFileDir(mAppPath);
                    if (mLoadErr != null) {
                        throw new UnsatisfiedLinkError(mLoadErr);
                    }
                    tTPlayerRef = new TTPlayerRef(context);
                    tTPlayerRef.mClient = tTPlayerClient;
                    try {
                        TTPlayer tTPlayer = new TTPlayer(context, tTPlayerRef.mId);
                        tTPlayerRef.mPlayer = tTPlayer;
                        tTPlayer.setNotifyer(tTPlayerRef);
                    } catch (Throwable th) {
                        StringBuffer stringBuffer = new StringBuffer();
                        try {
                            string = TTPlayerLibraryLoader.getErrorInfo();
                        } catch (Throwable th2) {
                            string = th2.toString();
                        }
                        stringBuffer.append(th.toString());
                        stringBuffer.append(",player:");
                        stringBuffer.append(string);
                        throw new RuntimeException(stringBuffer.toString());
                    }
                } else {
                    if (mLoadErr != null) {
                        throw new UnsatisfiedLinkError(mLoadErr);
                    }
                    tTPlayerRef = new TTPlayerRef(context);
                    tTPlayerRef.mClient = tTPlayerClient;
                    TTPlayer tTPlayer2 = new TTPlayer(context, tTPlayerRef.mId);
                    tTPlayerRef.mPlayer = tTPlayer2;
                    tTPlayer2.setNotifyer(tTPlayerRef);
                }
            } catch (UnsatisfiedLinkError e) {
                mLoadErr = e.getMessage();
            }
        } else {
            if (mLoadErr != null) {
                throw new UnsatisfiedLinkError(mLoadErr);
            }
            tTPlayerRef = new TTPlayerRef(context);
            tTPlayerRef.mClient = tTPlayerClient;
            TTPlayer tTPlayer3 = new TTPlayer(context, tTPlayerRef.mId);
            tTPlayerRef.mPlayer = tTPlayer3;
            tTPlayer3.setNotifyer(tTPlayerRef);
        }
        throw th;
        return tTPlayerRef;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public double getDoubleOption(int i, double d) {
        return this.mPlayer.getDoubleOption(i, d);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public float getFloatOption(int i, float f) {
        return this.mPlayer.getFloatOption(i, f);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getIntOption(int i, int i2) {
        return this.mPlayer.getIntOption(i, i2);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public long getLongOption(int i, long j) {
        return this.mPlayer.getLongOption(i, j);
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public Object getObjectOption(int i) {
        return this.mPlayer.getObjectValue(i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public String getStringOption(int i) {
        return this.mPlayer.getStringOption(i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handleErrorNotify(long j, int i, int i2, String str) {
        this.mClient.onPlayLogInfo(i, i2, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handlePlayerNotify(long j, int i, int i2, int i3, String str) {
        this.mClient.onPlayerNotify(i, i2, i3, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public boolean isValid() {
        return this.mPlayer != null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void mouseEvent(int i, int i2, int i3) {
        this.mPlayer.mouseEvent(i, i2, i3);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void release() {
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        tTPlayer.release();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void rotateCamera(float f, float f2) {
        this.mPlayer.rotateCamera(f, f2);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mPlayer.setAudioProcessor(audioProcessor);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setCacheFile(String str, int i) {
        this.mPlayer.setCacheFile(str, i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSource(String str) {
        this.mPlayer.setDataSource(str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSourceFd(int i) {
        this.mPlayer.setDataSourceFd(i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setDoubleOption(int i, double d) {
        return this.mPlayer.setDoubleOption(i, d);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setFloatOption(int i, float f) {
        return this.mPlayer.setFloatOption(i, f);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mPlayer.setFrameMetadataListener(frameMetadataListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setIntOption(int i, int i2) {
        try {
            return this.mPlayer.setIntOption(i, i2);
        } catch (RemoteException e) {
            m.c(e);
            return -1;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setLoadControl(LoadControl loadControl) {
        this.mPlayer.setLoadControl(loadControl);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setLongOption(int i, long j) {
        return this.mPlayer.setLongOption(i, j);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setLooping(int i) {
        this.mPlayer.setLooping(i);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setMaskInfo(MaskInfo maskInfo) {
        this.mPlayer.setMaskInfo(maskInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setMediaTransport(MediaTransport mediaTransport) {
        this.mPlayer.setMediaTransport(mediaTransport);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setNotifyState(long j) {
        this.mPlayer.setNotifyerState(j);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mPlayer.setOnScreenshotListener(onScreenshotListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setStringOption(int i, String str) {
        return this.mPlayer.setStringOption(i, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setSubInfo(SubInfo subInfo) {
        this.mPlayer.setSubInfo(subInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setVolume(float f, float f2) {
        this.mPlayer.setVolume(f, f2);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void switchStream(int i, int i2) {
        this.mPlayer.switchStream(i, i2);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mPlayer.setDataSource(iMediaDataSource);
    }
}
