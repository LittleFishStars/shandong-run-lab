package com.byazt.cb;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.byazt.omf.gt;
import com.byazt.qqc.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 13})
public class tt extends com.byazt.qqc.c {
    public Window c;
    public final String tt = "xgc_prop_bright";
    public final float ve = 255.0f;
    public final int uj = -1;

    public tt(Window window) {
        this.c = window;
        if (ve.c().n() == -2.0f) {
            ve.c().c(n() / 255.0f);
        }
    }

    public void c(double d) {
        tt(d);
    }

    public int n() {
        return Settings.System.getInt(gt.getContext().getContentResolver(), "screen_brightness", 0);
    }

    @Override // com.byazt.qqc.c
    public void tt(int i) {
        tt(-1.0d);
    }

    @Override // com.byazt.qqc.c
    public JSONObject uj() {
        return gt.tt().pn();
    }

    @Override // com.byazt.qqc.c
    public boolean ve() {
        if (this.c == null) {
            return true;
        }
        double dN = ve.c().n();
        return dN >= 0.95d || dN <= 0.05d;
    }

    private void tt(double d) {
        WindowManager.LayoutParams attributes = this.c.getAttributes();
        if (attributes != null) {
            if (d != -1.0d) {
                d = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(d, 1.0d));
                if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d = -1.0d;
                }
            }
            attributes.screenBrightness = (float) d;
            this.c.setAttributes(attributes);
        }
    }

    public float c(Window window) {
        return window.getAttributes().screenBrightness;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c A[PHI: r7
      0x001c: PHI (r7v3 double) = (r7v1 double), (r7v2 double) binds: [B:8:0x001a, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.qqc.c
    public boolean c(int i) {
        double dTt;
        JSONObject jSONObjectUj = uj();
        if (jSONObjectUj == null) {
            return false;
        }
        ve.c();
        if (i == 1) {
            dTt = jSONObjectUj.optDouble("value", AudioStats.AUDIO_AMPLITUDE_NONE);
            double d = 1.0d;
            if (dTt >= 1.0d) {
                dTt = d;
            } else {
                d = -1.0d;
                if (dTt <= -1.0d) {
                    dTt = d;
                }
            }
        } else {
            if (i != 2) {
                return false;
            }
            dTt = ve.c().tt();
            if (dTt == -2.0d) {
                return false;
            }
        }
        if (dTt == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return false;
        }
        if (c(this.c) == -1.0f) {
            c(((double) (n() / 255.0f)) + dTt);
        }
        return true;
    }

    @Override // com.byazt.qqc.c
    public boolean tt() {
        return ve.c().ve();
    }
}
