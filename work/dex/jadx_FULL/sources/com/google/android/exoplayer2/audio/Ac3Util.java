package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.blankj.utilcode.util.ThreadUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.gj9;
import com.zj.adlib.hs5;
import com.zj.adlib.ky5;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Ac3Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30531a = 80000;
    public static final int b = 768000;
    public static final int c = 3062500;
    public static final int d = 16;
    public static final int e = 10;
    public static final int f = 256;
    public static final int g = 1536;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f2345a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f2346b = {48000, com.google.android.exoplayer2.source.i.K, com.google.android.exoplayer2.video.spherical.a.h};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f2347c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f2348d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int[] f2349e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, hs5.f, 640};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int[] f2350f = {69, 87, 104, 121, 139, 174, 208, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, TTAdConstant.LIVE_FEED_URL_CODE, ky5.j, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {
        public static final int f = -1;
        public static final int g = 0;
        public static final int h = 1;
        public static final int i = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30532a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f2351a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        public SyncFrameInfo(@Nullable String str, int i2, int i3, int i4, int i5, int i6) {
            this.f2351a = str;
            this.f30532a = i2;
            this.c = i3;
            this.b = i4;
            this.d = i5;
            this.e = i6;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((gj9.Q(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - iPosition;
            }
        }
        return -1;
    }

    public static int b(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = f2346b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f2350f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = f2349e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static com.google.android.exoplayer2.d c(om6 om6Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i = f2346b[(om6Var.G() & 192) >> 6];
        int iG = om6Var.G();
        int i2 = f2348d[(iG & 56) >> 3];
        if ((iG & 4) != 0) {
            i2++;
        }
        return new com.google.android.exoplayer2.d.b().S(str).e0("audio/ac3").H(i2).f0(i).M(drmInitData).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & ThreadUtils.d) >> 3) > 10) {
            return f2345a[((byteBuffer.get(byteBuffer.position() + 4) & u.n7) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & com.alibaba.ariver.resource.parser.a.e.i) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static SyncFrameInfo e(nm6 nm6Var) {
        int iB;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        int iH;
        int i5;
        int i6;
        int i7;
        int i8;
        int iE = nm6Var.e();
        nm6Var.s(40);
        boolean z = nm6Var.h(5) > 10;
        nm6Var.q(iE);
        int i9 = -1;
        if (z) {
            nm6Var.s(16);
            int iH2 = nm6Var.h(2);
            if (iH2 == 0) {
                i9 = 0;
            } else if (iH2 == 1) {
                i9 = 1;
            } else if (iH2 == 2) {
                i9 = 2;
            }
            nm6Var.s(3);
            iB = (nm6Var.h(11) + 1) * 2;
            int iH3 = nm6Var.h(2);
            if (iH3 == 3) {
                i = f2347c[nm6Var.h(2)];
                i5 = 6;
                iH = 3;
            } else {
                iH = nm6Var.h(2);
                i5 = f2345a[iH];
                i = f2346b[iH3];
            }
            i3 = i5 * 256;
            int iH4 = nm6Var.h(3);
            boolean zG = nm6Var.g();
            i2 = f2348d[iH4] + (zG ? 1 : 0);
            nm6Var.s(10);
            if (nm6Var.g()) {
                nm6Var.s(8);
            }
            if (iH4 == 0) {
                nm6Var.s(5);
                if (nm6Var.g()) {
                    nm6Var.s(8);
                }
            }
            if (i9 == 1 && nm6Var.g()) {
                nm6Var.s(16);
            }
            if (nm6Var.g()) {
                if (iH4 > 2) {
                    nm6Var.s(2);
                }
                if ((iH4 & 1) == 0 || iH4 <= 2) {
                    i7 = 6;
                } else {
                    i7 = 6;
                    nm6Var.s(6);
                }
                if ((iH4 & 4) != 0) {
                    nm6Var.s(i7);
                }
                if (zG && nm6Var.g()) {
                    nm6Var.s(5);
                }
                if (i9 == 0) {
                    if (nm6Var.g()) {
                        i8 = 6;
                        nm6Var.s(6);
                    } else {
                        i8 = 6;
                    }
                    if (iH4 == 0 && nm6Var.g()) {
                        nm6Var.s(i8);
                    }
                    if (nm6Var.g()) {
                        nm6Var.s(i8);
                    }
                    int iH5 = nm6Var.h(2);
                    if (iH5 == 1) {
                        nm6Var.s(5);
                    } else if (iH5 == 2) {
                        nm6Var.s(12);
                    } else if (iH5 == 3) {
                        int iH6 = nm6Var.h(5);
                        if (nm6Var.g()) {
                            nm6Var.s(5);
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                nm6Var.s(4);
                            }
                            if (nm6Var.g()) {
                                if (nm6Var.g()) {
                                    nm6Var.s(4);
                                }
                                if (nm6Var.g()) {
                                    nm6Var.s(4);
                                }
                            }
                        }
                        if (nm6Var.g()) {
                            nm6Var.s(5);
                            if (nm6Var.g()) {
                                nm6Var.s(7);
                                if (nm6Var.g()) {
                                    nm6Var.s(8);
                                }
                            }
                        }
                        nm6Var.s((iH6 + 2) * 8);
                        nm6Var.c();
                    }
                    if (iH4 < 2) {
                        if (nm6Var.g()) {
                            nm6Var.s(14);
                        }
                        if (iH4 == 0 && nm6Var.g()) {
                            nm6Var.s(14);
                        }
                    }
                    if (nm6Var.g()) {
                        if (iH == 0) {
                            nm6Var.s(5);
                        } else {
                            for (int i10 = 0; i10 < i5; i10++) {
                                if (nm6Var.g()) {
                                    nm6Var.s(5);
                                }
                            }
                        }
                    }
                }
            }
            if (nm6Var.g()) {
                nm6Var.s(5);
                if (iH4 == 2) {
                    nm6Var.s(4);
                }
                if (iH4 >= 6) {
                    nm6Var.s(2);
                }
                if (nm6Var.g()) {
                    nm6Var.s(8);
                }
                if (iH4 == 0 && nm6Var.g()) {
                    nm6Var.s(8);
                }
                if (iH3 < 3) {
                    nm6Var.r();
                }
            }
            if (i9 == 0 && iH != 3) {
                nm6Var.r();
            }
            if (i9 == 2 && (iH == 3 || nm6Var.g())) {
                i6 = 6;
                nm6Var.s(6);
            } else {
                i6 = 6;
            }
            str = (nm6Var.g() && nm6Var.h(i6) == 1 && nm6Var.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i9;
        } else {
            nm6Var.s(32);
            int iH7 = nm6Var.h(2);
            String str2 = iH7 == 3 ? null : "audio/ac3";
            iB = b(iH7, nm6Var.h(6));
            nm6Var.s(8);
            int iH8 = nm6Var.h(3);
            if ((iH8 & 1) != 0 && iH8 != 1) {
                nm6Var.s(2);
            }
            if ((iH8 & 4) != 0) {
                nm6Var.s(2);
            }
            if (iH8 == 2) {
                nm6Var.s(2);
            }
            int[] iArr = f2346b;
            i = iH7 < iArr.length ? iArr[iH7] : -1;
            i2 = f2348d[iH8] + (nm6Var.g() ? 1 : 0);
            i3 = 1536;
            i4 = -1;
            str = str2;
        }
        return new SyncFrameInfo(str, i4, i2, i, iB, i3);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & ThreadUtils.d) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return b((b2 & u.n7) >> 6, b2 & 63);
    }

    public static com.google.android.exoplayer2.d g(om6 om6Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        om6Var.T(2);
        int i = f2346b[(om6Var.G() & 192) >> 6];
        int iG = om6Var.G();
        int i2 = f2348d[(iG & 14) >> 1];
        if ((iG & 1) != 0) {
            i2++;
        }
        if (((om6Var.G() & 30) >> 1) > 0 && (2 & om6Var.G()) != 0) {
            i2 += 2;
        }
        return new com.google.android.exoplayer2.d.b().S(str).e0((om6Var.a() <= 0 || (om6Var.G() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc").H(i2).f0(i).M(drmInitData).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                return 40 << ((bArr[(b2 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
