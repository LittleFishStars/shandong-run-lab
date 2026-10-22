package com.byazt.cb;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 20})
public class c extends ContentObserver {
    public Context c;
    public InterfaceC0373c tt;

    /* JADX INFO: renamed from: com.byazt.cb.c$c, reason: collision with other inner class name */
    public interface InterfaceC0373c {
        void c(int i);
    }

    public c(Context context, Handler handler, InterfaceC0373c interfaceC0373c) {
        super(handler);
        this.c = context;
        this.tt = interfaceC0373c;
    }

    @Override // android.database.ContentObserver
    public void onChange(final boolean z, final Uri uri) {
        super.onChange(z, uri);
        x.c(new sp("brightness onChange") { // from class: com.byazt.cb.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (uri.equals(Settings.System.getUriFor("screen_brightness"))) {
                    try {
                        int i = Settings.System.getInt(c.this.c.getContentResolver(), "screen_brightness", 0);
                        if (c.this.tt != null) {
                            c.this.tt.c(i);
                        }
                    } catch (Throwable th) {
                        m.uj("BrightnessObserver", "get screen brightness error: ".concat(String.valueOf(th)));
                    }
                }
            }
        });
    }

    public void c() {
        this.c.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this);
    }

    public void tt() {
        this.c.getContentResolver().unregisterContentObserver(this);
    }
}
