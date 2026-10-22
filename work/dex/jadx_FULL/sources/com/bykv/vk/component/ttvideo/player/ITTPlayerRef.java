package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.view.Surface;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.utils.HardWareInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public abstract class ITTPlayerRef {
    public static synchronized ITTPlayerRef create(Context context, TTPlayerClient tTPlayerClient, HashMap<Integer, Integer> map) {
        TTPlayerRef tTPlayerRefCreate;
        if (HardWareInfo.getCpuFamily() == 1) {
            tTPlayerRefCreate = TTPlayerRef.create(tTPlayerClient, context);
            if (tTPlayerRefCreate != null && TTPlayerConfiger.isPrintInfo()) {
                m.c(TTPlayerConfiger.TAG, "---------->ttplayer on<------------");
            }
        } else {
            tTPlayerRefCreate = null;
        }
        if (tTPlayerRefCreate == null) {
            m.c(TTPlayerConfiger.TAG, TTPlayerConfiger.getValue(16, "not find start service info."));
            if (map == null || map.get(100).intValue() != 1) {
                if (!TTPlayerConfiger.getValue(7, false) && TTPlayerConfiger.getValue(10, 0) < 3) {
                    TTPlayerConfiger.setValue(7, true);
                }
            } else if (map.get(7).intValue() == 0 && map.get(10).intValue() < 3) {
                map.put(7, 1);
            }
        }
        return tTPlayerRefCreate;
    }

    public abstract void close();

    public abstract Context getContext();

    public abstract double getDoubleOption(int i, double d);

    public abstract float getFloatOption(int i, float f);

    public abstract int getIntOption(int i, int i2);

    public abstract int getLifeId();

    public abstract long getLongOption(int i, long j);

    public abstract Object getObjectOption(int i);

    public abstract String getStringOption(int i);

    public abstract int getType();

    public void invalid() {
    }

    public abstract boolean isValid();

    public abstract void mouseEvent(int i, int i2, int i3);

    public abstract void pause();

    public abstract void prepare();

    public abstract void prevClose();

    public abstract void release();

    public abstract void reset();

    public abstract void rotateCamera(float f, float f2);

    public abstract void seekTo(int i);

    public abstract void setAudioProcessor(AudioProcessor audioProcessor);

    public abstract void setCacheFile(String str, int i);

    public abstract void setDataSource(IMediaDataSource iMediaDataSource);

    public abstract void setDataSource(String str);

    public abstract void setDataSourceFd(int i);

    public abstract int setDoubleOption(int i, double d);

    public abstract int setFloatOption(int i, float f);

    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    public abstract int setIntOption(int i, int i2);

    public abstract void setLoadControl(LoadControl loadControl);

    public abstract int setLongOption(int i, long j);

    public abstract void setLooping(int i);

    public abstract void setMaskInfo(MaskInfo maskInfo);

    public abstract void setMediaTransport(MediaTransport mediaTransport);

    public abstract void setNotifyState(long j);

    public abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener);

    public abstract int setStringOption(int i, String str);

    public abstract void setSubInfo(SubInfo subInfo);

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f, float f2);

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int i, int i2);

    public abstract void takeScreenshot();
}
