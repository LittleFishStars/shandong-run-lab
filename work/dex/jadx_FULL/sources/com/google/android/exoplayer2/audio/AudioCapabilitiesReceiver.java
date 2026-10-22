package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.qe0;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AudioCapabilitiesReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final BroadcastReceiver f30533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f2353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f2354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f2355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public qe0 f2356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2357a;

    public final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        public HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            AudioCapabilitiesReceiver.this.c(qe0.d(context, intent));
        }
    }

    public interface Listener {
        void a(qe0 qe0Var);
    }

    public final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f30535a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Uri f2358a;

        public b(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f30535a = contentResolver;
            this.f2358a = uri;
        }

        public void a() {
            this.f30535a.registerContentObserver(this.f2358a, false, this);
        }

        public void b() {
            this.f30535a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.c(qe0.c(audioCapabilitiesReceiver.f2352a));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.f2352a = applicationContext;
        this.f2354a = (Listener) sb0.g(listener);
        Handler handlerA = gj9.A();
        this.f2353a = handlerA;
        this.f30533a = gj9.f41922a >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
        Uri uriG = qe0.g();
        this.f2355a = uriG != null ? new b(handlerA, applicationContext.getContentResolver(), uriG) : null;
    }

    public final void c(qe0 qe0Var) {
        if (!this.f2357a || qe0Var.equals(this.f2356a)) {
            return;
        }
        this.f2356a = qe0Var;
        this.f2354a.a(qe0Var);
    }

    public qe0 d() {
        if (this.f2357a) {
            return (qe0) sb0.g(this.f2356a);
        }
        this.f2357a = true;
        b bVar = this.f2355a;
        if (bVar != null) {
            bVar.a();
        }
        Intent intentRegisterReceiver = null;
        if (this.f30533a != null) {
            intentRegisterReceiver = this.f2352a.registerReceiver(this.f30533a, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f2353a);
        }
        qe0 qe0VarD = qe0.d(this.f2352a, intentRegisterReceiver);
        this.f2356a = qe0VarD;
        return qe0VarD;
    }

    public void e() {
        if (this.f2357a) {
            this.f2356a = null;
            BroadcastReceiver broadcastReceiver = this.f30533a;
            if (broadcastReceiver != null) {
                this.f2352a.unregisterReceiver(broadcastReceiver);
            }
            b bVar = this.f2355a;
            if (bVar != null) {
                bVar.b();
            }
            this.f2357a = false;
        }
    }
}
