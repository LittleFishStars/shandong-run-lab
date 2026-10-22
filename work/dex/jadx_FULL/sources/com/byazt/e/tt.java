package com.byazt.e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28440a;
    public Context c;
    public int da;
    public View i;
    public String n;
    public Drawable sp;
    public String tt;
    public String uj;
    public String ve;
    public InterfaceC0394tt x;

    @com.byazt.zqa.c(c = {0, 1, 443, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28441a;
        public View c;
        public InterfaceC0394tt da;
        public Drawable i;
        public String n;
        public String sp;
        public int tt;
        public String uj;
        public Context ve;
        public boolean x;

        public c(Context context) {
            this.ve = context;
        }

        public c c(String str) {
            this.uj = str;
            return this;
        }

        public c tt(String str) {
            this.n = str;
            return this;
        }

        public c uj(String str) {
            this.sp = str;
            return this;
        }

        public c ve(String str) {
            this.f28441a = str;
            return this;
        }

        public c c(boolean z) {
            this.x = z;
            return this;
        }

        public c c(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public c c(InterfaceC0394tt interfaceC0394tt) {
            this.da = interfaceC0394tt;
            return this;
        }

        public c c(int i) {
            this.tt = i;
            return this;
        }

        public tt c() {
            return new tt(this);
        }
    }

    /* JADX INFO: renamed from: com.byazt.e.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0394tt {
        void c(DialogInterface dialogInterface);

        void tt(DialogInterface dialogInterface);

        void ve(DialogInterface dialogInterface);
    }

    private tt(c cVar) {
        this.f28440a = true;
        this.c = cVar.ve;
        this.tt = cVar.uj;
        this.ve = cVar.n;
        this.uj = cVar.f28441a;
        this.n = cVar.sp;
        this.f28440a = cVar.x;
        this.sp = cVar.i;
        this.x = cVar.da;
        this.i = cVar.c;
        this.da = cVar.tt;
    }
}
