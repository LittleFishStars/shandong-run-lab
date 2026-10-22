package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.cea.b;
import com.google.android.exoplayer2.util.Log;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.bf1;
import com.zj.adlib.cv8;
import com.zj.adlib.en1;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.px6;
import com.zj.adlib.sb0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends CeaDecoder {
    public static final int A = 24;
    public static final int A0 = 123;
    public static final int B = 31;
    public static final int B0 = 124;
    public static final int C = 128;
    public static final int C0 = 125;
    public static final int D = 129;
    public static final int D0 = 126;
    public static final int E = 130;
    public static final int E0 = 127;
    public static final int F = 131;
    public static final int G = 132;
    public static final int H = 133;
    public static final int I = 134;
    public static final int J = 135;
    public static final int K = 136;
    public static final int L = 137;
    public static final int M = 138;
    public static final int N = 139;
    public static final int O = 140;
    public static final int P = 141;
    public static final int Q = 142;
    public static final int R = 143;
    public static final int S = 144;
    public static final int T = 145;
    public static final int U = 146;
    public static final int V = 151;
    public static final int W = 152;
    public static final int X = 153;
    public static final int Y = 154;
    public static final int Z = 155;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31012a = "Cea708Decoder";
    public static final int a0 = 156;
    public static final int b0 = 157;
    public static final int c0 = 158;
    public static final int d0 = 159;
    public static final int e0 = 127;
    public static final int f = 8;
    public static final int f0 = 32;
    public static final int g = 2;
    public static final int g0 = 33;
    public static final int h = 3;
    public static final int h0 = 37;
    public static final int i = 4;
    public static final int i0 = 42;
    public static final int j = 31;
    public static final int j0 = 44;
    public static final int k = 127;
    public static final int k0 = 48;
    public static final int l = 159;
    public static final int l0 = 49;
    public static final int m = 255;
    public static final int m0 = 50;
    public static final int n = 31;
    public static final int n0 = 51;
    public static final int o = 127;
    public static final int o0 = 52;
    public static final int p = 159;
    public static final int p0 = 53;
    public static final int q = 255;
    public static final int q0 = 57;
    public static final int r = 0;
    public static final int r0 = 58;
    public static final int s = 3;
    public static final int s0 = 60;
    public static final int t = 8;
    public static final int t0 = 61;
    public static final int u = 12;
    public static final int u0 = 63;
    public static final int v = 13;
    public static final int v0 = 118;
    public static final int w = 14;
    public static final int w0 = 119;
    public static final int x = 16;
    public static final int x0 = 120;
    public static final int y = 17;
    public static final int y0 = 121;
    public static final int z = 23;
    public static final int z0 = 122;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public C0696b f4580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f4581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public List<Cue> f4584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final C0696b[] f4586a;

    @Nullable
    public List<Cue> b;
    public final int d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f4583a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f4582a = new nm6();
    public int c = -1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Comparator<a> f31013a = new Comparator() { // from class: com.zj.adlib.af1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.a.c((b.a) obj, (b.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f4587a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Cue f4588a;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            Cue.b bVarZ = new Cue.b().A(charSequence).B(alignment).t(f, i).u(i2).w(f2).x(i3).z(f3);
            if (z) {
                bVarZ.E(i4);
            }
            this.f4588a = bVarZ.a();
            this.f4587a = i5;
        }

        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f4587a, aVar.f4587a);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.text.cea.b$b, reason: collision with other inner class name */
    public static final class C0696b {
        public static final int A = 1;
        public static final int B = 2;
        public static final int C = 3;
        public static final int D = 0;
        public static final int E = 3;
        public static final int F = h(2, 2, 2, 0);
        public static final int G;
        public static final int H;
        public static final int I = 1;
        public static final int J = 0;
        public static final int K = 1;
        public static final int L = 2;
        public static final int M = 3;
        public static final int N = 4;
        public static final int O = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f31014a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final boolean[] f4589a;
        public static final int[] b;
        public static final int[] c;
        public static final int[] d;
        public static final int[] e;
        public static final int[] f;
        public static final int[] g;
        public static final int q = 99;
        public static final int r = 74;
        public static final int s = 209;
        public static final int t = 4;
        public static final int u = 15;
        public static final int v = 0;
        public static final int w = 1;
        public static final int x = 2;
        public static final int y = 3;
        public static final int z = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4590a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4593a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f4594b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4595b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4596c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4597c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f4598d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4599d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public int f4600e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public int f4601f;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        public int f4602g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<SpannableString> f4592a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SpannableStringBuilder f4591a = new SpannableStringBuilder();

        static {
            int iH = h(0, 0, 0, 0);
            G = iH;
            int iH2 = h(0, 0, 0, 3);
            H = iH2;
            f31014a = new int[]{0, 0, 0, 0, 0, 2, 0};
            b = new int[]{0, 0, 0, 0, 0, 0, 2};
            c = new int[]{3, 3, 3, 3, 3, 3, 1};
            f4589a = new boolean[]{false, false, false, true, true, true, false};
            d = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            e = new int[]{0, 1, 2, 3, 4, 3, 4};
            f = new int[]{0, 0, 0, 0, 0, 3, 3};
            g = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public C0696b() {
            l();
        }

        public static int g(int i, int i2, int i3) {
            return h(i, i2, i3, 0);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0021  */
        public static int h(int i, int i2, int i3, int i4) {
            int i5;
            sb0.c(i, 0, 4);
            sb0.c(i2, 0, 4);
            sb0.c(i3, 0, 4);
            sb0.c(i4, 0, 4);
            if (i4 == 0 || i4 == 1) {
                i5 = 255;
            } else if (i4 == 2) {
                i5 = 127;
            } else if (i4 != 3) {
                i5 = 255;
            } else {
                i5 = 0;
            }
            return Color.argb(i5, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.f4591a.append(c2);
                return;
            }
            this.f4592a.add(d());
            this.f4591a.clear();
            if (this.j != -1) {
                this.j = 0;
            }
            if (this.k != -1) {
                this.k = 0;
            }
            if (this.l != -1) {
                this.l = 0;
            }
            if (this.n != -1) {
                this.n = 0;
            }
            while (true) {
                if ((!this.f4599d || this.f4592a.size() < this.f4600e) && this.f4592a.size() < 15) {
                    return;
                } else {
                    this.f4592a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f4591a.length();
            if (length > 0) {
                this.f4591a.delete(length - 1, length);
            }
        }

        @Nullable
        public a c() {
            Layout.Alignment alignment;
            float f2;
            float f3;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.f4592a.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f4592a.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i2 = this.f4601f;
            if (i2 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i2 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f4601f);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f4597c) {
                f2 = this.f4596c / 99.0f;
                f3 = this.f4594b / 99.0f;
            } else {
                f2 = this.f4596c / 209.0f;
                f3 = this.f4594b / 74.0f;
            }
            float f4 = (f2 * 0.9f) + 0.05f;
            float f5 = (f3 * 0.9f) + 0.05f;
            int i3 = this.f4598d;
            return new a(spannableStringBuilder, alignment2, f5, 0, i3 / 3 == 0 ? 0 : i3 / 3 == 1 ? 1 : 2, f4, i3 % 3 == 0 ? 0 : i3 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.i != G, this.i, this.f4590a);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4591a);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.j != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.j, length, 33);
                }
                if (this.k != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.k, length, 33);
                }
                if (this.l != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.m), this.l, length, 33);
                }
                if (this.n != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.o), this.n, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f4592a.clear();
            this.f4591a.clear();
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.n = -1;
            this.p = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i, boolean z5, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f4593a = true;
            this.f4595b = z2;
            this.f4599d = z3;
            this.f4590a = i;
            this.f4597c = z5;
            this.f4594b = i2;
            this.f4596c = i3;
            this.f4598d = i6;
            int i9 = i4 + 1;
            if (this.f4600e != i9) {
                this.f4600e = i9;
                while (true) {
                    if ((!z3 || this.f4592a.size() < this.f4600e) && this.f4592a.size() < 15) {
                        break;
                    } else {
                        this.f4592a.remove(0);
                    }
                }
            }
            if (i7 != 0 && this.f4602g != i7) {
                this.f4602g = i7;
                int i10 = i7 - 1;
                q(d[i10], H, f4589a[i10], 0, b[i10], c[i10], f31014a[i10]);
            }
            if (i8 == 0 || this.h == i8) {
                return;
            }
            this.h = i8;
            int i11 = i8 - 1;
            m(0, 1, 1, false, false, f[i11], e[i11]);
            n(F, g[i11], G);
        }

        public boolean i() {
            return this.f4593a;
        }

        public boolean j() {
            return !i() || (this.f4592a.isEmpty() && this.f4591a.length() == 0);
        }

        public boolean k() {
            return this.f4595b;
        }

        public void l() {
            e();
            this.f4593a = false;
            this.f4595b = false;
            this.f4590a = 4;
            this.f4597c = false;
            this.f4594b = 0;
            this.f4596c = 0;
            this.f4598d = 0;
            this.f4600e = 15;
            this.f4599d = true;
            this.f4601f = 0;
            this.f4602g = 0;
            this.h = 0;
            int i = G;
            this.i = i;
            this.m = F;
            this.o = i;
        }

        public void m(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            if (this.j != -1) {
                if (!z2) {
                    this.f4591a.setSpan(new StyleSpan(2), this.j, this.f4591a.length(), 33);
                    this.j = -1;
                }
            } else if (z2) {
                this.j = this.f4591a.length();
            }
            if (this.k == -1) {
                if (z3) {
                    this.k = this.f4591a.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.f4591a.setSpan(new UnderlineSpan(), this.k, this.f4591a.length(), 33);
                this.k = -1;
            }
        }

        public void n(int i, int i2, int i3) {
            if (this.l != -1 && this.m != i) {
                this.f4591a.setSpan(new ForegroundColorSpan(this.m), this.l, this.f4591a.length(), 33);
            }
            if (i != F) {
                this.l = this.f4591a.length();
                this.m = i;
            }
            if (this.n != -1 && this.o != i2) {
                this.f4591a.setSpan(new BackgroundColorSpan(this.o), this.n, this.f4591a.length(), 33);
            }
            if (i2 != G) {
                this.n = this.f4591a.length();
                this.o = i2;
            }
        }

        public void o(int i, int i2) {
            if (this.p != i) {
                a('\n');
            }
            this.p = i;
        }

        public void p(boolean z2) {
            this.f4595b = z2;
        }

        public void q(int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
            this.i = i;
            this.f4601f = i6;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31015a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f4603a;
        public final int b;
        public int c = 0;

        public c(int i, int i2) {
            this.f31015a = i;
            this.b = i2;
            this.f4603a = new byte[(i2 * 2) - 1];
        }
    }

    public b(int i2, @Nullable List<byte[]> list) {
        this.d = i2 == -1 ? 1 : i2;
        this.f4585a = list != null && en1.i(list);
        this.f4586a = new C0696b[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f4586a[i3] = new C0696b();
        }
        this.f4580a = this.f4586a[0];
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ cv8 dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    @Nullable
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ void queueInputBuffer(cv8 cv8Var) throws SubtitleDecoderException {
        super.queueInputBuffer(cv8Var);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        List<Cue> list = this.f4584a;
        this.b = list;
        return new bf1((List) sb0.g(list));
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(cv8 cv8Var) {
        ByteBuffer byteBuffer = (ByteBuffer) sb0.g(((DecoderInputBuffer) cv8Var).f2588a);
        this.f4583a.Q(byteBuffer.array(), byteBuffer.limit());
        while (this.f4583a.a() >= 3) {
            int iG = this.f4583a.G() & 7;
            int i2 = iG & 3;
            boolean z2 = (iG & 4) == 4;
            byte bG = (byte) this.f4583a.G();
            byte bG2 = (byte) this.f4583a.G();
            if (i2 == 2 || i2 == 3) {
                if (z2) {
                    if (i2 == 3) {
                        e();
                        int i3 = (bG & u.n7) >> 6;
                        int i4 = this.c;
                        if (i4 != -1 && i3 != (i4 + 1) % 4) {
                            u();
                            Log.n(f31012a, "Sequence number discontinuity. previous=" + this.c + " current=" + i3);
                        }
                        this.c = i3;
                        int i5 = bG & 63;
                        if (i5 == 0) {
                            i5 = 64;
                        }
                        c cVar = new c(i3, i5);
                        this.f4581a = cVar;
                        byte[] bArr = cVar.f4603a;
                        int i6 = cVar.c;
                        cVar.c = i6 + 1;
                        bArr[i6] = bG2;
                    } else {
                        sb0.a(i2 == 2);
                        c cVar2 = this.f4581a;
                        if (cVar2 == null) {
                            Log.d(f31012a, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.f4603a;
                            int i7 = cVar2.c;
                            int i8 = i7 + 1;
                            bArr2[i7] = bG;
                            cVar2.c = i8 + 1;
                            bArr2[i8] = bG2;
                        }
                    }
                    c cVar3 = this.f4581a;
                    if (cVar3.c == (cVar3.b * 2) - 1) {
                        e();
                    }
                }
            }
        }
    }

    public final void e() {
        if (this.f4581a == null) {
            return;
        }
        t();
        this.f4581a = null;
    }

    public final List<Cue> f() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f4586a[i2].j() && this.f4586a[i2].k() && (aVarC = this.f4586a[i2].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.f31013a);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(((a) arrayList.get(i3)).f4588a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.f4584a = null;
        this.b = null;
        this.e = 0;
        this.f4580a = this.f4586a[0];
        u();
        this.f4581a = null;
    }

    public final void g(int i2) {
        if (i2 != 0) {
            if (i2 == 3) {
                this.f4584a = f();
            }
            if (i2 == 8) {
                this.f4580a.b();
                return;
            }
            switch (i2) {
                case 12:
                    u();
                    break;
                case 13:
                    this.f4580a.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        Log.n(f31012a, "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        this.f4582a.s(8);
                    } else if (i2 >= 24 && i2 <= 31) {
                        Log.n(f31012a, "Currently unsupported COMMAND_P16 Command: " + i2);
                        this.f4582a.s(16);
                    } else {
                        Log.n(f31012a, "Invalid C0 command: " + i2);
                    }
                    break;
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return f31012a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void h(int i2) {
        int i3 = 1;
        switch (i2) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i4 = i2 + com.alipay.sdk.m.p.a.g;
                if (this.e != i4) {
                    this.e = i4;
                    this.f4580a = this.f4586a[i4];
                }
                break;
            case 136:
                while (i3 <= 8) {
                    if (this.f4582a.g()) {
                        this.f4586a[8 - i3].e();
                    }
                    i3++;
                }
                break;
            case 137:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.f4582a.g()) {
                        this.f4586a[8 - i5].p(true);
                    }
                }
                break;
            case 138:
                while (i3 <= 8) {
                    if (this.f4582a.g()) {
                        this.f4586a[8 - i3].p(false);
                    }
                    i3++;
                }
                break;
            case 139:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.f4582a.g()) {
                        C0696b c0696b = this.f4586a[8 - i6];
                        c0696b.p(!c0696b.k());
                    }
                }
                break;
            case 140:
                while (i3 <= 8) {
                    if (this.f4582a.g()) {
                        this.f4586a[8 - i3].l();
                    }
                    i3++;
                }
                break;
            case 141:
                this.f4582a.s(8);
                break;
            case 142:
                break;
            case 143:
                u();
                break;
            case 144:
                if (this.f4580a.i()) {
                    p();
                } else {
                    this.f4582a.s(16);
                }
                break;
            case 145:
                if (this.f4580a.i()) {
                    q();
                } else {
                    this.f4582a.s(24);
                }
                break;
            case 146:
                if (this.f4580a.i()) {
                    r();
                } else {
                    this.f4582a.s(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                Log.n(f31012a, "Invalid C1 command: " + i2);
                break;
            case 151:
                if (this.f4580a.i()) {
                    s();
                } else {
                    this.f4582a.s(32);
                }
                break;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i7 = i2 - 152;
                k(i7);
                if (this.e != i7) {
                    this.e = i7;
                    this.f4580a = this.f4586a[i7];
                }
                break;
        }
    }

    public final void i(int i2) {
        if (i2 <= 7) {
            return;
        }
        if (i2 <= 15) {
            this.f4582a.s(8);
        } else if (i2 <= 23) {
            this.f4582a.s(16);
        } else if (i2 <= 31) {
            this.f4582a.s(24);
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.f4584a != this.b;
    }

    public final void j(int i2) {
        if (i2 <= 135) {
            this.f4582a.s(32);
            return;
        }
        if (i2 <= 143) {
            this.f4582a.s(40);
        } else if (i2 <= 159) {
            this.f4582a.s(2);
            this.f4582a.s(this.f4582a.h(6) * 8);
        }
    }

    public final void k(int i2) {
        C0696b c0696b = this.f4586a[i2];
        this.f4582a.s(2);
        boolean zG = this.f4582a.g();
        boolean zG2 = this.f4582a.g();
        boolean zG3 = this.f4582a.g();
        int iH = this.f4582a.h(3);
        boolean zG4 = this.f4582a.g();
        int iH2 = this.f4582a.h(7);
        int iH3 = this.f4582a.h(8);
        int iH4 = this.f4582a.h(4);
        int iH5 = this.f4582a.h(4);
        this.f4582a.s(2);
        int iH6 = this.f4582a.h(6);
        this.f4582a.s(2);
        c0696b.f(zG, zG2, zG3, iH, zG4, iH2, iH3, iH5, iH6, iH4, this.f4582a.h(3), this.f4582a.h(3));
    }

    public final void l(int i2) {
        if (i2 == 127) {
            this.f4580a.a((char) 9835);
        } else {
            this.f4580a.a((char) (i2 & 255));
        }
    }

    public final void m(int i2) {
        this.f4580a.a((char) (i2 & 255));
    }

    public final void n(int i2) {
        if (i2 == 32) {
            this.f4580a.a(' ');
        }
        if (i2 == 33) {
            this.f4580a.a((char) 160);
            return;
        }
        if (i2 == 37) {
            this.f4580a.a((char) 8230);
            return;
        }
        if (i2 == 42) {
            this.f4580a.a((char) 352);
            return;
        }
        if (i2 == 44) {
            this.f4580a.a((char) 338);
            return;
        }
        if (i2 == 63) {
            this.f4580a.a((char) 376);
            return;
        }
        if (i2 == 57) {
            this.f4580a.a((char) 8482);
            return;
        }
        if (i2 == 58) {
            this.f4580a.a((char) 353);
            return;
        }
        if (i2 == 60) {
            this.f4580a.a((char) 339);
            return;
        }
        if (i2 == 61) {
            this.f4580a.a((char) 8480);
            return;
        }
        switch (i2) {
            case 48:
                this.f4580a.a((char) 9608);
                break;
            case 49:
                this.f4580a.a((char) 8216);
                break;
            case 50:
                this.f4580a.a((char) 8217);
                break;
            case 51:
                this.f4580a.a((char) 8220);
                break;
            case 52:
                this.f4580a.a((char) 8221);
                break;
            case 53:
                this.f4580a.a((char) 8226);
                break;
            default:
                switch (i2) {
                    case 118:
                        this.f4580a.a((char) 8539);
                        break;
                    case 119:
                        this.f4580a.a((char) 8540);
                        break;
                    case 120:
                        this.f4580a.a((char) 8541);
                        break;
                    case 121:
                        this.f4580a.a((char) 8542);
                        break;
                    case 122:
                        this.f4580a.a(px6.d);
                        break;
                    case 123:
                        this.f4580a.a((char) 9488);
                        break;
                    case 124:
                        this.f4580a.a(px6.b);
                        break;
                    case 125:
                        this.f4580a.a((char) 9472);
                        break;
                    case 126:
                        this.f4580a.a((char) 9496);
                        break;
                    case 127:
                        this.f4580a.a(px6.f44079a);
                        break;
                    default:
                        Log.n(f31012a, "Invalid G2 character: " + i2);
                        break;
                }
                break;
        }
    }

    public final void o(int i2) {
        if (i2 == 160) {
            this.f4580a.a((char) 13252);
            return;
        }
        Log.n(f31012a, "Invalid G3 character: " + i2);
        this.f4580a.a('_');
    }

    public final void p() {
        this.f4580a.m(this.f4582a.h(4), this.f4582a.h(2), this.f4582a.h(2), this.f4582a.g(), this.f4582a.g(), this.f4582a.h(3), this.f4582a.h(3));
    }

    public final void q() {
        int iH = C0696b.h(this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2));
        int iH2 = C0696b.h(this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2));
        this.f4582a.s(2);
        this.f4580a.n(iH, iH2, C0696b.g(this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2)));
    }

    public final void r() {
        this.f4582a.s(4);
        int iH = this.f4582a.h(4);
        this.f4582a.s(2);
        this.f4580a.o(iH, this.f4582a.h(6));
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s() {
        int iH = C0696b.h(this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2));
        int iH2 = this.f4582a.h(2);
        int iG = C0696b.g(this.f4582a.h(2), this.f4582a.h(2), this.f4582a.h(2));
        if (this.f4582a.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f4582a.g();
        int iH3 = this.f4582a.h(2);
        int iH4 = this.f4582a.h(2);
        int iH5 = this.f4582a.h(2);
        this.f4582a.s(8);
        this.f4580a.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j2) {
        super.setPositionUs(j2);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    public final void t() {
        c cVar = this.f4581a;
        if (cVar.c != (cVar.b * 2) - 1) {
            Log.b(f31012a, "DtvCcPacket ended prematurely; size is " + ((this.f4581a.b * 2) - 1) + ", but current index is " + this.f4581a.c + " (sequence number " + this.f4581a.f31015a + ");");
        }
        nm6 nm6Var = this.f4582a;
        c cVar2 = this.f4581a;
        nm6Var.p(cVar2.f4603a, cVar2.c);
        boolean z2 = false;
        while (this.f4582a.b() > 0) {
            int iH = this.f4582a.h(3);
            int iH2 = this.f4582a.h(5);
            if (iH == 7) {
                this.f4582a.s(2);
                iH = this.f4582a.h(6);
                if (iH < 7) {
                    Log.n(f31012a, "Invalid extended service number: " + iH);
                }
            }
            if (iH2 == 0) {
                if (iH == 0) {
                    break;
                }
                Log.n(f31012a, "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                break;
            }
            if (iH != this.d) {
                this.f4582a.t(iH2);
            } else {
                int iE = this.f4582a.e() + (iH2 * 8);
                while (this.f4582a.e() < iE) {
                    int iH3 = this.f4582a.h(8);
                    if (iH3 == 16) {
                        int iH4 = this.f4582a.h(8);
                        if (iH4 <= 31) {
                            i(iH4);
                        } else {
                            if (iH4 <= 127) {
                                n(iH4);
                            } else if (iH4 <= 159) {
                                j(iH4);
                            } else if (iH4 <= 255) {
                                o(iH4);
                            } else {
                                Log.n(f31012a, "Invalid extended command: " + iH4);
                            }
                            z2 = true;
                        }
                    } else if (iH3 <= 31) {
                        g(iH3);
                    } else {
                        if (iH3 <= 127) {
                            l(iH3);
                        } else if (iH3 <= 159) {
                            h(iH3);
                        } else if (iH3 <= 255) {
                            m(iH3);
                        } else {
                            Log.n(f31012a, "Invalid base command: " + iH3);
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            this.f4584a = f();
        }
    }

    public final void u() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f4586a[i2].l();
        }
    }
}
