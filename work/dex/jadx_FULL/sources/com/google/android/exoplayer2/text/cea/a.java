package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Log;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.bf1;
import com.zj.adlib.cv8;
import com.zj.adlib.gj9;
import com.zj.adlib.go6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends CeaDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31009a = "Cea608Decoder";
    public static final byte c = -4;
    public static final byte d = 32;
    public static final byte e = 33;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final long f4546e = 16000;
    public static final byte f = 36;
    public static final byte g = 37;
    public static final byte h = 38;
    public static final byte i = 39;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final int f4550i = 4;
    public static final byte j = 41;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final int f4551j = 2;
    public static final byte k = 42;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final int f4552k = 1;
    public static final byte l = 43;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final int f4553l = 0;
    public static final byte m = 44;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final int f4554m = 1;
    public static final byte n = 45;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final int f4555n = 0;
    public static final byte o = 46;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final int f4556o = 1;
    public static final byte p = 47;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static final int f4557p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 7;
    public static final int u = 8;
    public static final int v = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte f4558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public List<Cue> f4562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4563a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte f4564b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public List<Cue> f4565b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4566b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f4567c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f4568c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4569c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f4570d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f4571d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final int f4572e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f4573f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f4574g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f4542a = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] b = {0, 4, 8, 12, 16, 20, 24, 28};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f4544c = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f4545d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 209, 241, 9632};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int[] f4547e = {174, 176, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, MatroskaExtractor.T, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 251};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int[] f4548f = {193, 201, 211, 218, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 187};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final int[] f4549g = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 227, 205, 204, 236, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 123, 125, 92, 94, 95, 124, 126, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 228, go6.g, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 165, 164, 9474, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 229, 216, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 9484, 9488, 9492, 9496};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean[] f4543a = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f4560a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<C0694a> f4561a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public C0694a f4559a = new C0694a(0, 4);

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public int f4575h = 0;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.text.cea.a$a, reason: collision with other inner class name */
    public static final class C0694a {
        public static final int f = 32;
        public static final int g = 15;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31010a;
        public int b;
        public int c;
        public int d;
        public int e;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<C0695a> f4577a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List<SpannableString> f4578b = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final StringBuilder f4576a = new StringBuilder();

        /* JADX INFO: renamed from: com.google.android.exoplayer2.text.cea.a$a$a, reason: collision with other inner class name */
        public static class C0695a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f31011a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final boolean f4579a;
            public int b;

            public C0695a(int i, boolean z, int i2) {
                this.f31011a = i;
                this.f4579a = z;
                this.b = i2;
            }
        }

        public C0694a(int i, int i2) {
            j(i);
            this.e = i2;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.f4576a.length() < 32) {
                this.f4576a.append(c);
            }
        }

        public void f() {
            int length = this.f4576a.length();
            if (length > 0) {
                this.f4576a.delete(length - 1, length);
                for (int size = this.f4577a.size() - 1; size >= 0; size--) {
                    C0695a c0695a = this.f4577a.get(size);
                    int i = c0695a.b;
                    if (i != length) {
                        return;
                    }
                    c0695a.b = i - 1;
                }
            }
        }

        @Nullable
        public Cue g(int i) {
            float f2;
            int i2 = this.b + this.c;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.f4578b.size(); i4++) {
                spannableStringBuilder.append(gj9.F1(this.f4578b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(gj9.F1(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.d != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.d != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f2 = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.f31010a;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.d == 1) {
                i6 -= this.e - 1;
            }
            return new Cue.b().A(spannableStringBuilder).B(Layout.Alignment.ALIGN_NORMAL).t(i6, 1).w(f2).x(i).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4576a);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.f4577a.size()) {
                C0695a c0695a = this.f4577a.get(i5);
                boolean z2 = c0695a.f4579a;
                int i7 = c0695a.f31011a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = a.f4544c[i7];
                    }
                    z = z3;
                }
                int i8 = c0695a.b;
                i5++;
                if (i8 != (i5 < this.f4577a.size() ? this.f4577a.get(i5).b : length)) {
                    if (i != -1 && !z2) {
                        q(spannableStringBuilder, i, i8);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        o(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        n(spannableStringBuilder, i6, i8, i3);
                        i3 = i4;
                        i6 = i8;
                    }
                }
            }
            if (i != -1 && i != length) {
                q(spannableStringBuilder, i, length);
            }
            if (i2 != -1 && i2 != length) {
                o(spannableStringBuilder, i2, length);
            }
            if (i6 != length) {
                n(spannableStringBuilder, i6, length, i3);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.f4577a.isEmpty() && this.f4578b.isEmpty() && this.f4576a.length() == 0;
        }

        public void j(int i) {
            this.d = i;
            this.f4577a.clear();
            this.f4578b.clear();
            this.f4576a.setLength(0);
            this.f31010a = 15;
            this.b = 0;
            this.c = 0;
        }

        public void k() {
            this.f4578b.add(h());
            this.f4576a.setLength(0);
            this.f4577a.clear();
            int iMin = Math.min(this.e, this.f31010a);
            while (this.f4578b.size() >= iMin) {
                this.f4578b.remove(0);
            }
        }

        public void l(int i) {
            this.d = i;
        }

        public void m(int i) {
            this.e = i;
        }

        public void p(int i, boolean z) {
            this.f4577a.add(new C0695a(i, z, this.f4576a.length()));
        }
    }

    public a(String str, int i2, long j2) {
        this.f4568c = j2 > 0 ? j2 * 1000 : -9223372036854775807L;
        this.f4567c = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.f4572e = 0;
            this.f4570d = 0;
        } else if (i2 == 2) {
            this.f4572e = 1;
            this.f4570d = 0;
        } else if (i2 == 3) {
            this.f4572e = 0;
            this.f4570d = 1;
        } else if (i2 != 4) {
            Log.n(f31009a, "Invalid channel. Defaulting to CC1.");
            this.f4572e = 0;
            this.f4570d = 0;
        } else {
            this.f4572e = 1;
            this.f4570d = 1;
        }
        C(0);
        B();
        this.f4569c = true;
        this.f4571d = -9223372036854775807L;
    }

    public static char f(byte b2) {
        return (char) f4545d[(b2 & 127) - 32];
    }

    public static int g(byte b2) {
        return (b2 >> 3) & 1;
    }

    public static char i(byte b2) {
        return (char) f4548f[b2 & 31];
    }

    public static char j(byte b2) {
        return (char) f4549g[b2 & 31];
    }

    public static char k(byte b2, byte b3) {
        return (b2 & 1) == 0 ? i(b3) : j(b3);
    }

    public static char l(byte b2) {
        return (char) f4547e[b2 & com.google.common.base.a.q];
    }

    public static boolean p(byte b2) {
        return (b2 & 224) == 0;
    }

    public static boolean q(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    public static boolean r(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    public static boolean s(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    public static boolean t(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & u.n7) == 64;
    }

    public static boolean u(byte b2) {
        return (b2 & 240) == 16;
    }

    public static boolean w(byte b2) {
        return (b2 & 247) == 20;
    }

    public static boolean x(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    public static boolean y(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    public static boolean z(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    public final void A(byte b2, byte b3) {
        if (z(b2)) {
            this.f4569c = false;
            return;
        }
        if (w(b2)) {
            if (b3 != 32 && b3 != 47) {
                switch (b3) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b3) {
                            case 42:
                            case 43:
                                this.f4569c = false;
                                break;
                        }
                }
            }
            this.f4569c = true;
        }
    }

    public final void B() {
        this.f4559a.j(this.f4573f);
        this.f4561a.clear();
        this.f4561a.add(this.f4559a);
    }

    public final void C(int i2) {
        int i3 = this.f4573f;
        if (i3 == i2) {
            return;
        }
        this.f4573f = i2;
        if (i2 == 3) {
            for (int i4 = 0; i4 < this.f4561a.size(); i4++) {
                this.f4561a.get(i4).l(i2);
            }
            return;
        }
        B();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.f4562a = Collections.emptyList();
        }
    }

    public final void D(int i2) {
        this.f4574g = i2;
        this.f4559a.m(i2);
    }

    public final boolean E() {
        return (this.f4568c == -9223372036854775807L || this.f4571d == -9223372036854775807L || getPositionUs() - this.f4571d < this.f4568c) ? false : true;
    }

    public final boolean F(byte b2) {
        if (p(b2)) {
            this.f4575h = g(b2);
        }
        return this.f4575h == this.f4572e;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ cv8 dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    /* JADX INFO: renamed from: b */
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        SubtitleOutputBuffer availableOutputBuffer;
        SubtitleOutputBuffer subtitleOutputBufferDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (subtitleOutputBufferDequeueOutputBuffer != null) {
            return subtitleOutputBufferDequeueOutputBuffer;
        }
        if (!E() || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.f4562a = Collections.emptyList();
        this.f4571d = -9223372036854775807L;
        availableOutputBuffer.k(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ void queueInputBuffer(cv8 cv8Var) throws SubtitleDecoderException {
        super.queueInputBuffer(cv8Var);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        List<Cue> list = this.f4562a;
        this.f4565b = list;
        return new bf1((List) sb0.g(list));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(cv8 cv8Var) {
        boolean z;
        ByteBuffer byteBuffer = (ByteBuffer) sb0.g(((DecoderInputBuffer) cv8Var).f2588a);
        this.f4560a.Q(byteBuffer.array(), byteBuffer.limit());
        boolean z2 = false;
        while (true) {
            int iA = this.f4560a.a();
            int i2 = this.f4567c;
            if (iA < i2) {
                break;
            }
            byte bG = i2 == 2 ? (byte) -4 : (byte) this.f4560a.G();
            int iG = this.f4560a.G();
            int iG2 = this.f4560a.G();
            if ((bG & 2) == 0 && (bG & 1) == this.f4570d) {
                byte b2 = (byte) (iG & 127);
                byte b3 = (byte) (iG2 & 127);
                if (b2 != 0 || b3 != 0) {
                    boolean z3 = this.f4563a;
                    if ((bG & 4) == 4) {
                        boolean[] zArr = f4543a;
                        if (zArr[iG] && zArr[iG2]) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    this.f4563a = z;
                    if (!v(z, b2, b3)) {
                        if (this.f4563a) {
                            A(b2, b3);
                            if (this.f4569c && F(b2)) {
                                if (!p(b2)) {
                                    this.f4559a.e(f(b2));
                                    if ((b3 & 224) != 0) {
                                        this.f4559a.e(f(b3));
                                    }
                                } else if (x(b2, b3)) {
                                    this.f4559a.e(l(b3));
                                } else if (q(b2, b3)) {
                                    this.f4559a.f();
                                    this.f4559a.e(k(b2, b3));
                                } else if (r(b2, b3)) {
                                    m(b3);
                                } else if (t(b2, b3)) {
                                    o(b2, b3);
                                } else if (y(b2, b3)) {
                                    this.f4559a.c = b3 - 32;
                                } else if (s(b2, b3)) {
                                    n(b3);
                                }
                                z2 = true;
                            }
                        } else if (z3) {
                            B();
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            int i3 = this.f4573f;
            if (i3 == 1 || i3 == 3) {
                this.f4562a = h();
                this.f4571d = getPositionUs();
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.f4562a = null;
        this.f4565b = null;
        C(0);
        D(4);
        B();
        this.f4563a = false;
        this.f4566b = false;
        this.f4558a = (byte) 0;
        this.f4564b = (byte) 0;
        this.f4575h = 0;
        this.f4569c = true;
        this.f4571d = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return f31009a;
    }

    public final List<Cue> h() {
        int size = this.f4561a.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueG = this.f4561a.get(i2).g(Integer.MIN_VALUE);
            arrayList.add(cueG);
            if (cueG != null) {
                iMin = Math.min(iMin, cueG.M);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Cue cue = (Cue) arrayList.get(i3);
            if (cue != null) {
                if (cue.M != iMin) {
                    cue = (Cue) sb0.g(this.f4561a.get(i3).g(iMin));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.f4562a != this.f4565b;
    }

    public final void m(byte b2) {
        this.f4559a.e(' ');
        this.f4559a.p((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    public final void n(byte b2) {
        if (b2 == 32) {
            C(2);
            return;
        }
        if (b2 == 41) {
            C(3);
            return;
        }
        switch (b2) {
            case 37:
                C(1);
                D(2);
                break;
            case 38:
                C(1);
                D(3);
                break;
            case 39:
                C(1);
                D(4);
                break;
            default:
                int i2 = this.f4573f;
                if (i2 != 0) {
                    if (b2 != 33) {
                        switch (b2) {
                            case 44:
                                this.f4562a = Collections.emptyList();
                                int i3 = this.f4573f;
                                if (i3 == 1 || i3 == 3) {
                                    B();
                                }
                                break;
                            case 45:
                                if (i2 == 1 && !this.f4559a.i()) {
                                    this.f4559a.k();
                                    break;
                                }
                                break;
                            case 46:
                                B();
                                break;
                            case 47:
                                this.f4562a = h();
                                B();
                                break;
                        }
                    } else {
                        this.f4559a.f();
                        break;
                    }
                }
                break;
        }
    }

    public final void o(byte b2, byte b3) {
        int i2 = f4542a[b2 & 7];
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.f4559a.f31010a) {
            if (this.f4573f != 1 && !this.f4559a.i()) {
                C0694a c0694a = new C0694a(this.f4573f, this.f4574g);
                this.f4559a = c0694a;
                this.f4561a.add(c0694a);
            }
            this.f4559a.f31010a = i2;
        }
        boolean z = (b3 & com.google.common.base.a.r) == 16;
        boolean z2 = (b3 & 1) == 1;
        int i3 = (b3 >> 1) & 7;
        this.f4559a.p(z ? 8 : i3, z2);
        if (z) {
            this.f4559a.b = b[i3];
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j2) {
        super.setPositionUs(j2);
    }

    public final boolean v(boolean z, byte b2, byte b3) {
        if (!z || !u(b2)) {
            this.f4566b = false;
        } else {
            if (this.f4566b && this.f4558a == b2 && this.f4564b == b3) {
                this.f4566b = false;
                return true;
            }
            this.f4566b = true;
            this.f4558a = b2;
            this.f4564b = b3;
        }
        return false;
    }
}
