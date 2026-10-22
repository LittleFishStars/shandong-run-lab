package com.byazt.xgx;

import com.byazt.omf.rh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1109, 34})
public abstract class a {
    public static final String c = "a";
    public final Set<String> tt = new HashSet(1);

    /* JADX INFO: renamed from: com.byazt.xgx.a$5, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1109, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION})
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[uj.values().length];
            c = iArr;
            try {
                iArr[uj.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[uj.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[uj.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void c();

    public abstract void c(String str);

    public final synchronized boolean c(String str, int i) {
        try {
            if (i == 0) {
                return c(str, uj.GRANTED);
            }
            return c(str, uj.DENIED);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean tt(String str) {
        return true;
    }

    public final synchronized boolean c(final String str, uj ujVar) {
        this.tt.remove(str);
        int i = AnonymousClass5.c[ujVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                rh.a().post(new Runnable() { // from class: com.byazt.xgx.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (tt(str)) {
                    if (this.tt.isEmpty()) {
                        rh.a().post(new Runnable() { // from class: com.byazt.xgx.a.3
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.c();
                            }
                        });
                        return true;
                    }
                } else {
                    rh.a().post(new Runnable() { // from class: com.byazt.xgx.a.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.tt.isEmpty()) {
            rh.a().post(new Runnable() { // from class: com.byazt.xgx.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.c();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void c(String[] strArr) {
        Collections.addAll(this.tt, strArr);
    }
}
