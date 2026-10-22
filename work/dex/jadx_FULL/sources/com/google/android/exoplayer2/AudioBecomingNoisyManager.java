package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AudioBecomingNoisyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f30471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioBecomingNoisyReceiver f1971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1972a;

    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30472a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final EventListener f1973a;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.f30472a = handler;
            this.f1973a = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f30472a.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.f1972a) {
                this.f1973a.onAudioBecomingNoisy();
            }
        }
    }

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f30471a = context.getApplicationContext();
        this.f1971a = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z) {
        if (z && !this.f1972a) {
            this.f30471a.registerReceiver(this.f1971a, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f1972a = true;
        } else {
            if (z || !this.f1972a) {
                return;
            }
            this.f30471a.unregisterReceiver(this.f1971a);
            this.f1972a = false;
        }
    }
}
