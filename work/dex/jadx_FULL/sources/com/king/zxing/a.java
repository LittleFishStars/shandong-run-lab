package com.king.zxing;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import com.zj.adlib.mx6;
import com.zj.adlib.u15;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class a implements MediaPlayer.OnErrorListener, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f40018a = 0.1f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f15024a = 200;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f15025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPlayer f15026a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15027a;
    public boolean b;

    public a(Activity activity) {
        this.f15025a = activity;
        l();
    }

    public static boolean k(SharedPreferences sharedPreferences, Context context) {
        boolean z = sharedPreferences.getBoolean(mx6.h, false);
        if (!z || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z;
        }
        return false;
    }

    @TargetApi(19)
    public final MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(R.raw.zxl_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setOnErrorListener(this);
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.setLooping(false);
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                assetFileDescriptorOpenRawResourceFd.close();
                return mediaPlayer;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            u15.B(e);
            mediaPlayer.release();
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MediaPlayer mediaPlayer = this.f15026a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f15026a = null;
        }
    }

    public synchronized void g() {
        MediaPlayer mediaPlayer;
        if (this.f15027a && (mediaPlayer = this.f15026a) != null) {
            mediaPlayer.start();
        }
        if (this.b) {
            ((Vibrator) this.f15025a.getSystemService("vibrator")).vibrate(200L);
        }
    }

    public void h(boolean z) {
        this.f15027a = z;
    }

    public void j(boolean z) {
        this.b = z;
    }

    public synchronized void l() {
        k(PreferenceManager.getDefaultSharedPreferences(this.f15025a), this.f15025a);
        if (this.f15027a && this.f15026a == null) {
            this.f15025a.setVolumeControlStream(3);
            this.f15026a = a(this.f15025a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (i == 100) {
                this.f15025a.finish();
            } else {
                close();
                l();
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }
}
