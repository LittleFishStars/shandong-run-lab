package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class t4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t4b f44846a;
    public static final String b = s4b.v("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f19703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f19704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f19706a;

    public class a extends Thread {
        public final /* synthetic */ int K;
        public final /* synthetic */ String f;

        public a(String str, int i) {
            this.f = str;
            this.K = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String strH = l6b.h(this.f);
            if (TextUtils.isEmpty(strH)) {
                return;
            }
            if ((this.K & 1) > 0) {
                try {
                    if (Settings.System.canWrite(t4b.this.f19703a)) {
                        Settings.System.putString(t4b.this.f19703a.getContentResolver(), t4b.this.f19705a, strH);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.K & 16) > 0) {
                v4b.b(t4b.this.f19703a, t4b.this.f19705a, strH);
            }
            if ((this.K & 256) > 0) {
                SharedPreferences.Editor editorEdit = t4b.this.f19703a.getSharedPreferences(t4b.b, 0).edit();
                editorEdit.putString(t4b.this.f19705a, strH);
                editorEdit.apply();
            }
        }
    }

    public t4b(Context context) {
        this.f19703a = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.f19704a = new b(Looper.getMainLooper(), this);
        } else {
            this.f19704a = new b(this);
        }
    }

    public static t4b b(Context context) {
        if (f44846a == null) {
            synchronized (t4b.class) {
                if (f44846a == null) {
                    f44846a = new t4b(context);
                }
            }
        }
        return f44846a;
    }

    public final void d(String str) {
        this.f19705a = str;
    }

    public final synchronized void e(String str, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i).start();
            return;
        }
        String strH = l6b.h(str);
        if (!TextUtils.isEmpty(strH)) {
            if ((i & 1) > 0) {
                try {
                    Settings.System.putString(this.f19703a.getContentResolver(), this.f19705a, strH);
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                v4b.b(this.f19703a, this.f19705a, strH);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor editorEdit = this.f19703a.getSharedPreferences(b, 0).edit();
                editorEdit.putString(this.f19705a, strH);
                editorEdit.apply();
            }
        }
    }

    public final void g(String str) {
        List<String> list = this.f19706a;
        if (list != null) {
            list.clear();
            this.f19706a.add(str);
        }
        e(str, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME);
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<t4b> f44848a;

        public b(t4b t4bVar) {
            this.f44848a = new WeakReference<>(t4bVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            t4b t4bVar = this.f44848a.get();
            if (t4bVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            t4bVar.e((String) obj, message.what);
        }

        public b(Looper looper, t4b t4bVar) {
            super(looper);
            this.f44848a = new WeakReference<>(t4bVar);
        }
    }
}
