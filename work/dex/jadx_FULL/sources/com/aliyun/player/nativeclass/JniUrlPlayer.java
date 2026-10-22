package com.aliyun.player.nativeclass;

import android.content.Context;
import com.aliyun.player.source.BitStreamSource;
import com.aliyun.player.source.UrlSource;
import com.aliyun.utils.f;
import com.cicada.player.utils.NativeUsed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JniUrlPlayer extends NativePlayerBase {
    private static final String TAG = "JniUrlPlayer";
    private BitStreamSource.ReadCallback mReadCallback;
    private BitStreamSource.SeekCallback mSeekCallback;

    static {
        f.b();
    }

    public JniUrlPlayer(Context context) {
        super(context);
        this.mReadCallback = null;
        this.mSeekCallback = null;
    }

    public static void loadClass() {
    }

    private native void nEnableDowngrade(UrlSource urlSource, PlayerConfig playerConfig);

    @NativeUsed
    private int nRead(byte[] bArr) {
        BitStreamSource.ReadCallback readCallback = this.mReadCallback;
        if (readCallback != null) {
            return readCallback.read(bArr);
        }
        return -22;
    }

    @NativeUsed
    private long nSeek(long j, int i) {
        BitStreamSource.SeekCallback seekCallback = this.mSeekCallback;
        if (seekCallback != null) {
            return seekCallback.seek(j, i);
        }
        return -22L;
    }

    private native void nSetDataSource(BitStreamSource bitStreamSource);

    private native void nSetDataSource(UrlSource urlSource);

    public void enableDowngrade(UrlSource urlSource, PlayerConfig playerConfig) {
        nEnableDowngrade(urlSource, playerConfig);
    }

    public void setDataSource(BitStreamSource bitStreamSource) {
        this.mReadCallback = bitStreamSource.getReadCallback();
        this.mSeekCallback = bitStreamSource.getSeekCallback();
        nSetDataSource(bitStreamSource);
    }

    public void setDataSource(UrlSource urlSource) {
        nSetDataSource(urlSource);
    }
}
