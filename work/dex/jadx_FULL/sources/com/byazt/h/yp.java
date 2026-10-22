package com.byazt.h;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 215})
public class yp {
    public final JSONObject c;
    public int tt;

    private yp(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    private int m() {
        return this.c.optInt("url_balance", 2);
    }

    public boolean a() {
        return this.c.optInt("segment_mode", 1) == 0;
    }

    public void c(int i) {
        this.tt = tt(i);
    }

    public long da() {
        long jOptInt = this.c.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long i() {
        long jOptInt = ((long) this.c.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < sp()) {
            return -1L;
        }
        return jOptInt;
    }

    public int n() {
        return this.c.optInt("buffer_size", 8192);
    }

    public long sl() {
        long jOptInt = this.c.optInt("read_timeout", -1);
        if (jOptInt >= ExoPlayerImplInternal.f) {
            return jOptInt;
        }
        return -1L;
    }

    public long sp() {
        long jOptInt = ((long) this.c.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public int t() {
        return this.c.optInt("ip_strategy", 0);
    }

    public boolean tt() {
        return m() > 0;
    }

    public float u() {
        return (float) this.c.optDouble("main_ratio", AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public int uj() {
        return this.c.optInt("buffer_count", 512);
    }

    public boolean ve() {
        return m() == 1;
    }

    public long x() {
        long jOptInt = ((long) this.c.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public int yp() {
        return this.c.optInt("ratio_segment", 0);
    }

    public float z() {
        return Math.min(Math.max(0.0f, (float) this.c.optDouble("poor_speed_ratio", AudioStats.AUDIO_AMPLITUDE_NONE)), 1.0f);
    }

    private int tt(int i) {
        int iOptInt = this.c.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return m() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (m() > 0) {
            return i;
        }
        return 1;
    }

    public int c() {
        return this.tt;
    }

    @NonNull
    public static yp c(@NonNull JSONObject jSONObject) {
        return new yp(jSONObject);
    }
}
