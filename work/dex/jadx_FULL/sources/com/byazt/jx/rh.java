package com.byazt.jx;

import android.graphics.Paint;
import com.byazt.zy.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.go6;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 115})
public class rh implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.kd.tt f28708a;
    public final String c;
    public final boolean da;
    public final float i;
    public final com.byazt.kd.uj n;
    public final c sp;
    public final com.byazt.kd.tt tt;
    public final com.byazt.kd.c uj;
    public final List<com.byazt.kd.tt> ve;
    public final tt x;

    /* JADX INFO: renamed from: com.byazt.jx.rh$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, go6.g, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] tt;

        static {
            int[] iArr = new int[tt.values().length];
            tt = iArr;
            try {
                iArr[tt.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tt[tt.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tt[tt.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c.values().length];
            c = iArr2;
            try {
                iArr2[c.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[c.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[c.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum c {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap c() {
            int i = AnonymousClass1.c[ordinal()];
            if (i != 1) {
                return i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum tt {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join c() {
            int i = AnonymousClass1.tt[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public rh(String str, com.byazt.kd.tt ttVar, List<com.byazt.kd.tt> list, com.byazt.kd.c cVar, com.byazt.kd.uj ujVar, com.byazt.kd.tt ttVar2, c cVar2, tt ttVar3, float f, boolean z) {
        this.c = str;
        this.tt = ttVar;
        this.ve = list;
        this.uj = cVar;
        this.n = ujVar;
        this.f28708a = ttVar2;
        this.sp = cVar2;
        this.x = ttVar3;
        this.i = f;
        this.da = z;
    }

    public com.byazt.kd.tt a() {
        return this.tt;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new gt(xVar, veVar, this);
    }

    public boolean da() {
        return this.da;
    }

    public float i() {
        return this.i;
    }

    public List<com.byazt.kd.tt> n() {
        return this.ve;
    }

    public c sp() {
        return this.sp;
    }

    public com.byazt.kd.c tt() {
        return this.uj;
    }

    public com.byazt.kd.tt uj() {
        return this.f28708a;
    }

    public com.byazt.kd.uj ve() {
        return this.n;
    }

    public tt x() {
        return this.x;
    }

    public String c() {
        return this.c;
    }
}
