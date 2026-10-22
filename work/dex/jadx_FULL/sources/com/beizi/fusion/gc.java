package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface gc extends ya {

    public enum a implements xa {
        AD_EXPOSURE(501, "ad exposure"),
        ADN_RECOGNIZE(64, "adn recognize"),
        AD_VIEW_SHOWN(67, "ad view shown"),
        AD_VIEW_PAUSE(68, "ad view pause"),
        AD_VIEW_DETACHED(69, "ad view detached");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27347a;
        private final String b;

        a(int i, String str) {
            this.f27347a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f27347a;
        }
    }

    void a(View view);

    void b(View view);

    void b(xa xaVar, View view);

    void c(xa xaVar, View view);
}
