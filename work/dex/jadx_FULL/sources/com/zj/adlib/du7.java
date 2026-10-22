package com.zj.adlib;

import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.video.spherical.a;
import com.google.common.math.d;
import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class du7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41275a = "1.30";
    public static final /* synthetic */ boolean b = false;
    public static final int h = 65536;
    public static final int i = 97;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double f16077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hn8 f16080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteOrder f16081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double[] f16083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double[][] f16084a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public double f16085b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f16086b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16087b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f16088c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f16073a = {0, 48000, i.K, 37800, a.h, 22050, 48000, i.K};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f16075b = {1, 16, 20, 16, 16, 15, 16, 15};
    public static final int[] c = {8, 18, 27, 8, 8, 8, 10, 9};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final double[][] f16076b = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final double[] f16074b = {0.7d, 0.9d, 0.18d};

    public du7() {
        this.f16081a = ByteOrder.LITTLE_ENDIAN;
        this.f16080a = new hn8();
        this.f16077a = 170.0d;
        this.f16085b = 100.0d;
        this.f16078a = 65536;
        this.f16082a = false;
    }

    public static void i(String[] strArr) throws Exception {
        new du7(strArr);
    }

    public final int a(double d) {
        return (int) (d >= AudioStats.AUDIO_AMPLITUDE_NONE ? d + 0.5d : d - 0.5d);
    }

    public final double b(double d) {
        if (d <= 21.0d) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (d > 50.0d) {
            return (d - 8.7d) * 0.1102d;
        }
        double d2 = d - 21.0d;
        return (Math.pow(d2, 0.4d) * 0.5842d) + (d2 * 0.07886d);
    }

    public int c(double d, double[] dArr, int i2, int i3) {
        int i4;
        double dA;
        if (i2 == 1) {
            double[] dArr2 = this.f16083a;
            int i5 = this.f;
            this.f = i5 + 1;
            double d2 = d + dArr2[i5 & 65535];
            int i6 = this.d;
            if (d2 < i6) {
                double d3 = d2 / ((double) i6);
                double d4 = dArr[0];
                if (d4 >= d3) {
                    d3 = d4;
                }
                dArr[0] = d3;
                d2 = i6;
            }
            int i7 = this.e;
            if (d2 > i7) {
                double d5 = d2 / ((double) i7);
                double d6 = dArr[0];
                if (d6 >= d5) {
                    d5 = d6;
                }
                dArr[0] = d5;
                d2 = i7;
            }
            return a(d2);
        }
        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int i8 = 0;
        while (true) {
            i4 = this.f16088c;
            if (i8 >= i4) {
                break;
            }
            d7 += f16076b[this.f16086b][i8] * this.f16084a[i3][i8];
            i8++;
        }
        double d8 = d + d7;
        double[] dArr3 = this.f16083a;
        int i9 = this.f;
        this.f = i9 + 1;
        double d9 = dArr3[65535 & i9] + d8;
        for (int i10 = i4 - 2; i10 >= 0; i10--) {
            double[] dArr4 = this.f16084a[i3];
            dArr4[i10 + 1] = dArr4[i10];
        }
        int i11 = this.d;
        if (d9 < i11) {
            double d10 = d9 / ((double) i11);
            double d11 = dArr[0];
            if (d11 >= d10) {
                d10 = d11;
            }
            dArr[0] = d10;
            dA = i11;
            double[] dArr5 = this.f16084a[i3];
            double d12 = dA - d8;
            dArr5[0] = d12;
            if (d12 > 1.0d) {
                dArr5[0] = 1.0d;
            }
            if (dArr5[0] < -1.0d) {
                dArr5[0] = -1.0d;
            }
        } else {
            int i12 = this.e;
            if (d9 > i12) {
                double d13 = d9 / ((double) i12);
                double d14 = dArr[0];
                if (d14 >= d13) {
                    d13 = d14;
                }
                dArr[0] = d13;
                dA = i12;
                double[] dArr6 = this.f16084a[i3];
                double d15 = dA - d8;
                dArr6[0] = d15;
                if (d15 > 1.0d) {
                    dArr6[0] = 1.0d;
                }
                if (dArr6[0] < -1.0d) {
                    dArr6[0] = -1.0d;
                }
            } else {
                dA = a(d9);
                this.f16084a[i3][0] = dA - d8;
            }
        }
        return (int) dA;
    }

    /* JADX WARN: Code duplicated, block: B:240:0x07a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:241:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:243:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:246:0x07d9 A[EDGE_INSN: B:246:0x07d9->B:247:0x07df BREAK  A[LOOP:3: B:58:0x02cc->B:275:0x08ba]] */
    /* JADX WARN: Code duplicated, block: B:248:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:250:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:252:0x0806  */
    /* JADX WARN: Code duplicated, block: B:254:0x080d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:255:0x080f  */
    /* JADX WARN: Code duplicated, block: B:257:0x0820  */
    /* JADX WARN: Code duplicated, block: B:261:0x0854  */
    /* JADX WARN: Code duplicated, block: B:264:0x0872  */
    /* JADX WARN: Code duplicated, block: B:267:0x0878 A[LOOP:14: B:266:0x0876->B:267:0x0878, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:270:0x0891 A[LOOP:15: B:269:0x088f->B:270:0x0891, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:273:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:274:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:282:0x07c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:0x0832 A[SYNTHETIC] */
    public double d(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z, int i8) throws IOException {
        int i9;
        int i10;
        double d2;
        double[] dArr;
        double d3;
        double d4;
        int i11;
        double d5;
        int i12;
        int i13;
        double[] dArr2;
        int[] iArr;
        int i14;
        int[] iArr2;
        int i15;
        int i16;
        int[] iArr3;
        double[][] dArr3;
        int i17;
        int i18;
        int i19;
        double[] dArr4;
        ByteBuffer byteBuffer;
        int i20;
        int i21;
        char c2;
        du7 du7Var;
        int i22;
        int iA;
        char c3;
        int i23;
        ByteBuffer byteBuffer2;
        int iA2;
        char c4;
        int i24;
        char c5;
        int i25;
        int i26;
        int i27;
        int i28;
        int[] iArr4;
        int iA3;
        char c6;
        int i29;
        int i30;
        double d6;
        int i31;
        int i32;
        int i33;
        int i34;
        double d7;
        int iFloor;
        int i35;
        int i36 = i6;
        double[] dArr5 = {AudioStats.AUDIO_AMPLITUDE_NONE};
        int i37 = this.f16078a;
        double d8 = this.f16077a;
        int iF = f(i5, i36);
        int i38 = i36 / iF;
        if (i38 == 1) {
            i9 = 1;
        } else if (i38 % 2 == 0) {
            i9 = 2;
        } else {
            if (i38 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i38)));
            }
            i9 = 3;
        }
        int i39 = i5 * i9;
        double d9 = d8 <= 21.0d ? 0.9222d : (d8 - 7.95d) / 14.36d;
        int i40 = 1;
        while (true) {
            int i41 = i37 * i40;
            if (i41 % 2 == 0) {
                i41--;
            }
            i10 = i41;
            d2 = i39;
            dArr = dArr5;
            double d10 = (d2 * d9) / ((double) (i10 - 1));
            d3 = i36;
            d4 = (d3 - d10) / 2.0d;
            i11 = i9;
            if (d10 < this.f16085b) {
                break;
            }
            i40 *= 2;
            i36 = i6;
            dArr5 = dArr;
            i9 = i11;
        }
        double dB = b(d8);
        double dA = s34.a(dB);
        int i42 = 1;
        while (i42 < i10) {
            i42 *= 2;
        }
        int i43 = i42 * 2;
        double[] dArr6 = new double[i43];
        int i44 = i10 / 2;
        int i45 = -i44;
        while (i45 <= i44) {
            int i46 = i45;
            int i47 = i11;
            int i48 = i43;
            double[] dArr7 = dArr6;
            dArr7[i45 + i44] = ((((q(i45, i10, dB, dA) * g(i46, d4, d2)) * d2) / ((double) i5)) / ((double) i48)) * 2.0d;
            i45 = i46 + 1;
            i11 = i47;
            i43 = i48;
            dArr6 = dArr7;
            i10 = i10;
            i44 = i44;
        }
        int i49 = i45;
        double[] dArr8 = dArr6;
        int i50 = i11;
        int i51 = i10;
        int i52 = i43;
        int[] iArr5 = new int[(int) (Math.sqrt(i52) + 2.0d)];
        iArr5[0] = 0;
        int i53 = i52 / 2;
        double[] dArr9 = new double[i53];
        this.f16080a.I(i52, 1, dArr8, iArr5, dArr9);
        if (i50 == 1) {
            int[] iArr6 = {i5 / i36};
            double[][] dArr10 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 1, 1);
            dArr10[0][0] = 1.0d;
            i17 = (i5 / iF) * i36;
            dArr2 = dArr9;
            i14 = i53;
            d5 = d2;
            iArr2 = new int[]{0};
            i18 = 1;
            i12 = 1;
            dArr3 = dArr10;
            iArr3 = iArr6;
            i16 = i49;
            i13 = i39;
            iArr = iArr5;
            i15 = 1;
        } else {
            double d11 = this.f16077a;
            int i54 = (i5 / iF) * i36;
            double[] dArr11 = dArr9;
            int i55 = i5 / 2;
            int i56 = (i39 / 2) - i55;
            int[] iArr7 = iArr5;
            int i57 = i53;
            double d12 = ((double) (i56 * 2)) / 2.0d;
            d5 = d2;
            double d13 = ((double) i55) + (((double) i56) / 2.0d);
            double d14 = d11 > 21.0d ? (d11 - 7.95d) / 14.36d : 0.9222d;
            double d15 = i54;
            long j = d.e;
            int i58 = (int) (((d15 / d12) * d14) + 1.0d);
            if (i58 % 2 == 0) {
                i58++;
            }
            i12 = i58;
            double dB2 = b(d11);
            double dA2 = s34.a(dB2);
            int i59 = i54 / i39;
            int i60 = (i12 / i59) + 1;
            int[] iArr8 = new int[i59];
            for (int i61 = 0; i61 < i59; i61++) {
                int i62 = i59 - (((i54 / i36) * i61) % i59);
                iArr8[i61] = i62;
                if (i62 == i59) {
                    iArr8[i61] = 0;
                }
            }
            int[] iArr9 = new int[i59];
            int i63 = 0;
            while (i63 < i59) {
                int i64 = (((i54 / i36) - iArr8[i63]) / i59) + 1;
                iArr9[i63] = i64;
                int i65 = i63 + 1;
                if (iArr8[i65 == i59 ? 0 : i65] == 0) {
                    iArr9[i63] = i64 - 1;
                }
                i63 = i65;
            }
            double[][] dArr12 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i59, i60);
            int i66 = i12 / 2;
            int i67 = -i66;
            while (i67 <= i66) {
                int i68 = i67 + i66;
                int i69 = i67;
                dArr12[i68 % i59][i68 / i59] = ((q(i67, i12, dB2, dA2) * g(i69, d13, d15)) * d15) / d5;
                i67 = i69 + 1;
                i66 = i66;
                iArr9 = iArr9;
                i54 = i54;
                i59 = i59;
                iArr8 = iArr8;
                dArr11 = dArr11;
                j = d.e;
                i57 = i57;
                iArr7 = iArr7;
                i39 = i39;
            }
            i13 = i39;
            dArr2 = dArr11;
            iArr = iArr7;
            i14 = i57;
            int i70 = i59;
            iArr2 = iArr8;
            i15 = i60;
            i16 = i67;
            iArr3 = iArr9;
            dArr3 = dArr12;
            i17 = i54;
            i18 = i70;
        }
        l();
        int[] iArr10 = {i, i52};
        int i71 = i2;
        double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr10);
        int i72 = i15 + 1;
        int i73 = i72 + i14;
        double[][] dArr14 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i71, i73);
        int i74 = ((i14 / i50) + i50 + 1) * i71;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i74 * i3);
        int i75 = i15;
        int i76 = i18;
        double[][] dArr15 = dArr3;
        int[] iArr11 = iArr3;
        double d16 = i5;
        long j2 = d.e;
        double d17 = ((((double) i14) * d3) / d16) + 1.0d;
        int i77 = i4 * i71;
        double d18 = i77;
        int i78 = i72;
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) (d17 * d18));
        double[] dArr16 = new double[i74];
        int i79 = i16;
        double[] dArr17 = new double[(int) (((double) i71) * d17)];
        double d19 = d18;
        int i80 = (int) (((((double) i51) / 2.0d) / (d5 / d3)) + ((((double) i12) / 2.0d) / (((double) i17) / d3)));
        ByteBuffer byteBuffer3 = byteBufferAllocate;
        int i81 = 0;
        int i82 = 0;
        int i83 = 0;
        int i84 = 0;
        int i85 = 0;
        boolean z2 = true;
        int i86 = i7;
        int i87 = 0;
        while (true) {
            int i88 = (((i14 + 0) - 1) / i50) + 1;
            int i89 = i82;
            if (i88 + i81 > i86) {
                i88 = i86 - i81;
            }
            byteBuffer3.position(0);
            double d20 = d19;
            int i90 = i3 * i71;
            int i91 = i86;
            byteBuffer3.limit(i90 * i88);
            byte[] bArr = new byte[byteBuffer3.limit()];
            int i92 = i80;
            int i93 = inputStream.read(bArr);
            int i94 = i84;
            int i95 = i93 < 0 ? 0 : i93;
            int i96 = i95 < byteBuffer3.limit() ? ((i95 / i3) * i71) + i81 : i91;
            byteBuffer3.limit(i95);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(i95);
            byteBufferWrap.flip();
            int i97 = i95 / i90;
            if (i3 != 1) {
                if (i3 == 2) {
                    dArr4 = dArr17;
                    byteBuffer = byteBufferAllocate2;
                    i20 = i14;
                    i21 = 0;
                    while (i21 < i97 * i71) {
                        dArr16[(i71 * 0) + i21] = ((double) byteBufferWrap.order(this.f16081a).asShortBuffer().get(i21)) * 3.051850947599719E-5d;
                        i21++;
                        i83 = i83;
                    }
                } else if (i3 == 3) {
                    i21 = 0;
                    while (i21 < i97 * i71) {
                        int i98 = i21 * 3;
                        dArr16[(i71 * 0) + i21] = ((double) (((byteBufferWrap.get(i98 + 1) & 255) << 8) | ((byteBufferWrap.get(i98) & 255) << 0) | ((byteBufferWrap.get(i98 + 2) & 255) << 16))) * 1.1920930376163766E-7d;
                        i21++;
                        i14 = i14;
                        byteBufferAllocate2 = byteBufferAllocate2;
                        dArr17 = dArr17;
                    }
                    dArr4 = dArr17;
                    byteBuffer = byteBufferAllocate2;
                    i20 = i14;
                } else if (i3 != 4) {
                    i19 = i83;
                    dArr4 = dArr17;
                    byteBuffer = byteBufferAllocate2;
                    i20 = i14;
                    i21 = i79;
                    i85 = i85;
                } else {
                    i21 = 0;
                    while (i21 < i97 * i71) {
                        dArr16[(i71 * 0) + i21] = ((double) byteBufferWrap.order(this.f16081a).getInt(i21)) * 4.656612875245797E-10d;
                        i21++;
                        i85 = i85;
                    }
                    i85 = i85;
                    i19 = i83;
                    dArr4 = dArr17;
                    byteBuffer = byteBufferAllocate2;
                    i20 = i14;
                }
                i19 = i83;
            } else {
                i19 = i83;
                dArr4 = dArr17;
                byteBuffer = byteBufferAllocate2;
                i85 = i85;
                i20 = i14;
                i21 = 0;
                while (i21 < i97 * i71) {
                    dArr16[(i71 * 0) + i21] = ((double) ((byteBufferWrap.get(i21) & 255) + com.alipay.sdk.m.p.a.g)) * 0.007874015748031496d;
                    i21++;
                }
            }
            while (i21 < i71 * i88) {
                dArr16[i21] = 0.0d;
                i21++;
            }
            int i99 = i81 + i97;
            boolean z3 = inputStream.available() < 0 || i99 >= i96;
            int i100 = i89;
            int i101 = i94;
            int i102 = 0;
            while (i102 < i71) {
                int i103 = 0;
                int i104 = 0;
                while (i103 < i20) {
                    dArr13[i102][i103] = dArr16[(i104 * i71) + i102];
                    int i105 = i103 + 1;
                    while (true) {
                        i35 = i103 + i50;
                        if (i105 < i35) {
                            dArr13[i102][i105] = 0.0d;
                            i105++;
                        }
                    }
                    i104++;
                    i103 = i35;
                }
                int i106 = i52;
                for (int i107 = i20; i107 < i106; i107++) {
                    dArr13[i102][i107] = 0.0d;
                }
                this.f16080a.I(i106, 1, dArr13[i102], iArr, dArr2);
                double[] dArr18 = dArr13[i102];
                dArr18[0] = dArr8[0] * dArr18[0];
                dArr18[1] = dArr8[1] * dArr18[1];
                for (int i108 = 1; i108 < i20; i108++) {
                    int i109 = i108 * 2;
                    double d21 = dArr8[i109];
                    double[] dArr19 = dArr13[i102];
                    double d22 = dArr19[i109];
                    int i110 = i109 + 1;
                    double d23 = dArr8[i110];
                    double d24 = dArr19[i110];
                    dArr19[i109] = (d21 * d22) - (d23 * d24);
                    dArr19[i110] = (d23 * d22) + (d21 * d24);
                }
                this.f16080a.I(i106, -1, dArr13[i102], iArr, dArr2);
                int i111 = 0;
                while (i111 < i20) {
                    double[] dArr20 = dArr14[i102];
                    int i112 = i78 + i111;
                    dArr20[i112] = dArr20[i112] + dArr13[i102][i111];
                    i111++;
                }
                int i113 = i17 / i13;
                int i114 = i19 / i113;
                if (i19 % i113 != 0) {
                    i114++;
                }
                int length = (dArr14[0].length * i102) + i114;
                int i115 = i111;
                i101 = 0;
                int i116 = i89;
                for (char c7 = 0; length - (dArr14[c7].length * i102) < i20 + 1; c7 = 0) {
                    int i117 = iArr2[i116];
                    int i118 = iArr11[i116] + length;
                    ByteBuffer byteBuffer4 = byteBufferWrap;
                    int i119 = i116 + 1;
                    double[] dArr21 = dArr16;
                    int i120 = i76;
                    i116 = i119 == i120 ? 0 : i119;
                    i76 = i120;
                    double d25 = 0.0d;
                    int i121 = i75;
                    int i122 = 0;
                    while (i122 < i121) {
                        double d26 = dArr15[i117][i122];
                        int i123 = i117;
                        double[] dArr22 = dArr14[0];
                        d25 += d26 * dArr14[length / dArr22.length][length % dArr22.length];
                        length++;
                        i122++;
                        i117 = i123;
                    }
                    dArr4[(i101 * i71) + 0 + i102] = d25;
                    i101++;
                    i115 = i122;
                    length = i118;
                    i75 = i121;
                    byteBufferWrap = byteBuffer4;
                    dArr16 = dArr21;
                }
                i102++;
                i100 = i116;
                i21 = i115;
                dArr16 = dArr16;
                i52 = i106;
            }
            ByteBuffer byteBuffer5 = byteBufferWrap;
            int i124 = i52;
            double[] dArr23 = dArr16;
            i75 = i75;
            int i125 = i19 + ((i17 / i6) * i101);
            byteBuffer.clear();
            if (z) {
                i21 = 0;
                while (i21 < i101 * i71) {
                    double d27 = dArr4[i21];
                    if (d27 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        d27 = -d27;
                    }
                    double d28 = dArr[0];
                    if (d28 >= d27) {
                        d27 = d28;
                    }
                    dArr[0] = d27;
                    byteBuffer.asDoubleBuffer().put(i21, dArr4[i21]);
                    i21++;
                }
                c2 = 2;
            } else {
                if (i4 == 1) {
                    i78 = i78;
                    i124 = i124;
                    i75 = i75;
                    i100 = i100;
                    iArr = iArr;
                    byteBuffer = byteBuffer;
                    c2 = 2;
                    du7Var = this;
                    double d29 = d * 127.0d;
                    i22 = 0;
                    int i126 = 0;
                    while (i22 < i101 * i71) {
                        if (i8 != 0) {
                            iA = c(dArr4[i22] * d29, dArr, i8, i126);
                        } else {
                            iA = du7Var.a(dArr4[i22] * d29);
                            if (iA < -128) {
                                double d30 = ((double) iA) / (-128.0d);
                                c3 = 0;
                                double d31 = dArr[0];
                                if (d31 >= d30) {
                                    d30 = d31;
                                }
                                dArr[0] = d30;
                                iA = -128;
                            } else {
                                c3 = 0;
                            }
                            if (127 < iA) {
                                double d32 = ((double) iA) / 127.0d;
                                double d33 = dArr[c3];
                                if (d33 >= d32) {
                                    d32 = d33;
                                }
                                dArr[c3] = d32;
                                iA = 127;
                            }
                        }
                        byteBuffer.put(i22, (byte) (iA + 128));
                        int i127 = i126 + 1;
                        i126 = i127 == i71 ? 0 : i127;
                        i22++;
                    }
                } else if (i4 != 2) {
                    char c8 = 3;
                    if (i4 != 3) {
                        c2 = 2;
                    } else {
                        double d34 = d * 8388607.0d;
                        int i128 = 0;
                        int i129 = 0;
                        while (i128 < i101 * i71) {
                            if (i8 != 0) {
                                c5 = c8;
                                i25 = i128;
                                i27 = i75;
                                i28 = i100;
                                iArr4 = iArr;
                                i24 = i78;
                                i26 = i124;
                                iA3 = c(dArr4[i128] * d34, dArr, i8, i129);
                            } else {
                                i24 = i78;
                                c5 = c8;
                                i25 = i128;
                                i26 = i124;
                                i27 = i75;
                                i28 = i100;
                                iArr4 = iArr;
                                iA3 = a(dArr4[i25] * d34);
                                if (iA3 < -8388608) {
                                    double d35 = ((double) iA3) / (-8388608.0d);
                                    c6 = 0;
                                    double d36 = dArr[0];
                                    if (d36 >= d35) {
                                        d35 = d36;
                                    }
                                    dArr[0] = d35;
                                    iA3 = -8388608;
                                } else {
                                    c6 = 0;
                                }
                                if (8388607 < iA3) {
                                    double d37 = ((double) iA3) / 8388607.0d;
                                    double d38 = dArr[c6];
                                    if (d38 >= d37) {
                                        d37 = d38;
                                    }
                                    dArr[c6] = d37;
                                    iA3 = 8388607;
                                }
                            }
                            int i130 = i25 * 3;
                            ByteBuffer byteBuffer6 = byteBuffer;
                            byteBuffer6.put(i130, (byte) (iA3 & 255));
                            int i131 = iA3 >> 8;
                            byteBuffer6.put(i130 + 1, (byte) (i131 & 255));
                            byteBuffer6.put(i130 + 2, (byte) ((i131 >> 8) & 255));
                            int i132 = i129 + 1;
                            i129 = i132 == i71 ? 0 : i132;
                            i128 = i25 + 1;
                            byteBuffer = byteBuffer6;
                            i100 = i28;
                            iArr = iArr4;
                            i124 = i26;
                            c8 = c5;
                            i75 = i27;
                            i78 = i24;
                        }
                        i78 = i78;
                        i124 = i124;
                        i75 = i75;
                        i100 = i100;
                        iArr = iArr;
                        c2 = 2;
                        du7Var = this;
                        i22 = i128;
                        byteBuffer = byteBuffer;
                    }
                } else {
                    i78 = i78;
                    c2 = 2;
                    i124 = i124;
                    i75 = i75;
                    i100 = i100;
                    iArr = iArr;
                    ByteBuffer byteBuffer7 = byteBuffer;
                    du7Var = this;
                    double d39 = d * 32767.0d;
                    int i133 = 0;
                    int i134 = 0;
                    while (i133 < i101 * i71) {
                        if (i8 != 0) {
                            i23 = i133;
                            byteBuffer2 = byteBuffer7;
                            iA2 = c(dArr4[i133] * d39, dArr, i8, i134);
                        } else {
                            i23 = i133;
                            byteBuffer2 = byteBuffer7;
                            iA2 = du7Var.a(dArr4[i23] * d39);
                            if (iA2 < -32768) {
                                double d40 = ((double) iA2) / (-32768.0d);
                                c4 = 0;
                                double d41 = dArr[0];
                                if (d41 >= d40) {
                                    d40 = d41;
                                }
                                dArr[0] = d40;
                                iA2 = -32768;
                            } else {
                                c4 = 0;
                            }
                            if (32767 < iA2) {
                                double d42 = ((double) iA2) / 32767.0d;
                                double d43 = dArr[c4];
                                if (d43 >= d42) {
                                    d42 = d43;
                                }
                                dArr[c4] = d42;
                                iA2 = 32767;
                            }
                        }
                        byteBuffer2.order(du7Var.f16081a).asShortBuffer().put(i23, (short) iA2);
                        int i135 = i134 + 1;
                        i134 = i135 == i71 ? 0 : i135;
                        i133 = i23 + 1;
                        byteBuffer7 = byteBuffer2;
                    }
                    i22 = i133;
                    byteBuffer = byteBuffer7;
                }
                if (z2) {
                    i29 = i85;
                    i30 = i92;
                    if (i101 < i30) {
                        i30 -= i101;
                        i85 = i29;
                    } else if (z3) {
                        d6 = (((double) i99) * d3) / d16;
                        if (d6 + 2.0d > (i29 + i101) - i30) {
                            byteBuffer.position(i77 * i30);
                            byteBuffer.limit((int) (d20 * ((((Math.floor(d6) + 2.0d) + ((double) i29)) + ((double) i101)) - ((double) i30))));
                            du7Var.writeBuffers(outputStream, byteBuffer);
                            break;
                        }
                        byteBuffer.position(i77 * i30);
                        int i136 = i101 - i30;
                        byteBuffer.limit(i77 * i136);
                        du7Var.writeBuffers(outputStream, byteBuffer);
                        i85 = i29 + i136;
                    } else {
                        i99 = i99;
                        byteBuffer.position(i77 * i30);
                        byteBuffer.limit(i77 * i101);
                        du7Var.writeBuffers(outputStream, byteBuffer);
                        i85 = i29 + (i101 - i30);
                        z2 = false;
                    }
                } else {
                    if (z3) {
                        d7 = (((double) i99) * d3) / d16;
                        i85 += i101;
                        if (d7 + 2.0d > i85) {
                            byteBuffer.position(0);
                            iFloor = (int) (((Math.floor(d7) + 2.0d) - ((double) i85)) * d20);
                            if (iFloor > 0) {
                                break;
                            }
                            byteBuffer.limit(iFloor);
                            du7Var.writeBuffers(outputStream, byteBuffer);
                            break;
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(i77 * i101);
                        du7Var.writeBuffers(outputStream, byteBuffer);
                    } else {
                        byteBuffer.position(0);
                        byteBuffer.limit(i77 * i101);
                        du7Var.writeBuffers(outputStream, byteBuffer);
                        i85 += i101;
                    }
                    i30 = i92;
                }
                int i137 = i17 / i13;
                i31 = (i125 - 1) / i137;
                if (i31 > i20) {
                    i31 = i20;
                }
                i71 = i2;
                i32 = 0;
                while (i32 < i71) {
                    double[] dArr24 = dArr14[i32];
                    System.arraycopy(dArr24, i31, dArr24, 0, i73 - i31);
                    i32++;
                    i30 = i30;
                }
                int i138 = i30;
                int i139 = i125 - (i31 * i137);
                for (i33 = 0; i33 < i71; i33++) {
                    System.arraycopy(dArr13[i33], i20, dArr14[i33], i78, i20);
                }
                int i140 = i78;
                i87++;
                if ((i87 & 7) == 7) {
                    int i141 = i99;
                    i34 = i141;
                    du7Var.m(((double) i141) / ((double) i96));
                } else {
                    i34 = i99;
                }
                i83 = i139;
                i81 = i34;
                i78 = i140;
                i86 = i96;
                i84 = i101;
                i79 = i22;
                i80 = i138;
                byteBuffer3 = byteBuffer5;
                i82 = i100;
                dArr16 = dArr23;
                i52 = i124;
                d19 = d20;
                dArr17 = dArr4;
                j2 = d.e;
                i14 = i20;
                byteBufferAllocate2 = byteBuffer;
                iArr = iArr;
            }
            du7Var = this;
            i22 = i21;
            if (z2) {
                if (z3) {
                    d7 = (((double) i99) * d3) / d16;
                    i85 += i101;
                    if (d7 + 2.0d > i85) {
                        byteBuffer.position(0);
                        iFloor = (int) (((Math.floor(d7) + 2.0d) - ((double) i85)) * d20);
                        if (iFloor > 0) {
                            break;
                        }
                        byteBuffer.limit(iFloor);
                        du7Var.writeBuffers(outputStream, byteBuffer);
                        break;
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(i77 * i101);
                    du7Var.writeBuffers(outputStream, byteBuffer);
                } else {
                    byteBuffer.position(0);
                    byteBuffer.limit(i77 * i101);
                    du7Var.writeBuffers(outputStream, byteBuffer);
                    i85 += i101;
                }
                i30 = i92;
            } else {
                i29 = i85;
                i30 = i92;
                if (i101 < i30) {
                    i30 -= i101;
                    i85 = i29;
                } else if (z3) {
                    d6 = (((double) i99) * d3) / d16;
                    if (d6 + 2.0d > (i29 + i101) - i30) {
                        byteBuffer.position(i77 * i30);
                        byteBuffer.limit((int) (d20 * ((((Math.floor(d6) + 2.0d) + ((double) i29)) + ((double) i101)) - ((double) i30))));
                        du7Var.writeBuffers(outputStream, byteBuffer);
                        break;
                    }
                    byteBuffer.position(i77 * i30);
                    int i1310 = i101 - i30;
                    byteBuffer.limit(i77 * i1310);
                    du7Var.writeBuffers(outputStream, byteBuffer);
                    i85 = i29 + i1310;
                } else {
                    i99 = i99;
                    byteBuffer.position(i77 * i30);
                    byteBuffer.limit(i77 * i101);
                    du7Var.writeBuffers(outputStream, byteBuffer);
                    i85 = i29 + (i101 - i30);
                    z2 = false;
                }
            }
            int i1311 = i17 / i13;
            i31 = (i125 - 1) / i1311;
            if (i31 > i20) {
                i31 = i20;
            }
            i71 = i2;
            i32 = 0;
            while (i32 < i71) {
                double[] dArr25 = dArr14[i32];
                System.arraycopy(dArr25, i31, dArr25, 0, i73 - i31);
                i32++;
                i30 = i30;
            }
            int i1312 = i30;
            int i1313 = i125 - (i31 * i1311);
            while (i33 < i71) {
                System.arraycopy(dArr13[i33], i20, dArr14[i33], i78, i20);
            }
            int i142 = i78;
            i87++;
            if ((i87 & 7) == 7) {
                int i143 = i99;
                i34 = i143;
                du7Var.m(((double) i143) / ((double) i96));
            } else {
                i34 = i99;
            }
            i83 = i1313;
            i81 = i34;
            i78 = i142;
            i86 = i96;
            i84 = i101;
            i79 = i22;
            i80 = i1312;
            byteBuffer3 = byteBuffer5;
            i82 = i100;
            dArr16 = dArr23;
            i52 = i124;
            d19 = d20;
            dArr17 = dArr4;
            j2 = d.e;
            i14 = i20;
            byteBufferAllocate2 = byteBuffer;
            iArr = iArr;
        }
        du7Var.m(1.0d);
        return dArr[0];
    }

    public final void e(int i2) {
        throw new IllegalStateException("unknown error " + i2);
    }

    public final int f(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    public final double g(int i2, double d, double d2) {
        double d3 = 1.0d / d2;
        return d * 2.0d * d3 * n(((double) i2) * 6.283185307179586d * d * d3);
    }

    public byte[] getDataFromByteBuffer(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    public int h(int i2, int i3, int i4, int i5, int i6, int i7, double d) {
        int i8;
        int[] iArr = new int[97];
        int i9 = 1;
        while (i9 < 6 && i2 != f16073a[i9]) {
            i9++;
        }
        int i10 = 0;
        if ((i6 == 3 || i6 == 4) && i9 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i2));
        }
        if (i6 == 2 || i9 == 6) {
            i9 = 0;
        }
        if (i6 == 4 && (i9 == 1 || i9 == 2)) {
            i9 += 5;
        }
        this.f16086b = i9;
        this.f16084a = new double[i3][];
        this.f16088c = f16075b[i9];
        for (int i11 = 0; i11 < i3; i11++) {
            this.f16084a[i11] = new double[this.f16088c];
        }
        this.d = i4;
        this.e = i5;
        this.f16083a = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i12 = 0; i12 < 97; i12++) {
            iArr[i12] = random.nextInt();
        }
        if (i7 != 0) {
            if (i7 == 1) {
                int i13 = 0;
                while (i13 < 65536) {
                    int iNextInt = random.nextInt() % 97;
                    int i14 = iArr[iNextInt];
                    iArr[iNextInt] = random.nextInt();
                    int iNextInt2 = random.nextInt() % 97;
                    int i15 = iArr[iNextInt2];
                    iArr[iNextInt2] = random.nextInt();
                    this.f16083a[i13] = d * ((((double) i14) / 2.147483647E9d) - (((double) i15) / 2.147483647E9d));
                    i13++;
                    i10 = 0;
                }
            } else if (i7 == 2) {
                boolean z = false;
                double dSqrt = AudioStats.AUDIO_AMPLITUDE_NONE;
                double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                for (int i16 = 0; i16 < 65536; i16++) {
                    if (z) {
                        this.f16083a[i16] = d * dSqrt * Math.sin(d2);
                        z = false;
                    } else {
                        int iNextInt3 = random.nextInt() % 97;
                        double d3 = ((double) iArr[iNextInt3]) / 2.147483647E9d;
                        iArr[iNextInt3] = random.nextInt();
                        if (d3 == 1.0d) {
                            d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                        dSqrt = Math.sqrt(Math.log(1.0d - d3) * (-2.0d));
                        int iNextInt4 = random.nextInt() % 97;
                        double d4 = ((double) iArr[iNextInt4]) / 2.147483647E9d;
                        iArr[iNextInt4] = random.nextInt();
                        d2 = 6.283185307179586d * d4;
                        this.f16083a[i16] = d * dSqrt * Math.cos(d2);
                        z = true;
                    }
                }
            }
            i8 = i10;
        } else {
            for (int i17 = 0; i17 < 65536; i17++) {
                int iNextInt5 = random.nextInt() % 97;
                int i18 = iArr[iNextInt5];
                iArr[iNextInt5] = random.nextInt();
                this.f16083a[i17] = ((((double) i18) / 2.147483647E9d) - 0.5d) * d;
            }
            i8 = 0;
        }
        this.f = i8;
        if (i6 == 0 || i6 == 1) {
            return 1;
        }
        return c[this.f16086b];
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0128  */
    /* JADX WARN: Code duplicated, block: B:27:0x012c  */
    /* JADX WARN: Code duplicated, block: B:29:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0131  */
    /* JADX WARN: Code duplicated, block: B:32:0x0134  */
    /* JADX WARN: Code duplicated, block: B:33:0x013c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0145  */
    /* JADX WARN: Code duplicated, block: B:36:0x0159  */
    /* JADX WARN: Code duplicated, block: B:38:0x0188  */
    /* JADX WARN: Code duplicated, block: B:40:0x0196  */
    /* JADX WARN: Code duplicated, block: B:41:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:44:0x01be  */
    /* JADX WARN: Code duplicated, block: B:46:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:50:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x0201  */
    /* JADX WARN: Code duplicated, block: B:57:0x0209  */
    /* JADX WARN: Code duplicated, block: B:61:0x021f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0222  */
    /* JADX WARN: Code duplicated, block: B:65:0x022c  */
    /* JADX WARN: Code duplicated, block: B:71:0x023f A[EDGE_INSN: B:71:0x023f->B:68:0x023f BREAK  A[LOOP:0: B:7:0x002a->B:66:0x0232], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0232 A[SYNTHETIC] */
    public double j(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, double d, int i5, boolean z, int i6) throws IOException {
        ByteBuffer byteBufferWrap;
        double d2;
        double d3;
        double d4;
        double d5;
        ByteBuffer byteBuffer;
        double d6;
        int i7;
        double d7;
        double d8;
        ByteBuffer byteBuffer2;
        int i8;
        double d9;
        int iA;
        double d10;
        int iA2;
        double d11;
        int iA3;
        double d12;
        double d13;
        int i9 = 1;
        double[] dArr = {AudioStats.AUDIO_AMPLITUDE_NONE};
        l();
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(8) : null;
        int i10 = 4;
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i5 * i2;
            if (i11 >= i13) {
                dArr = dArr;
                break;
            }
            if (i3 != i9) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        byteBufferAllocate2.position(0);
                        byteBufferAllocate2.limit(3);
                        byte[] bArr = new byte[byteBufferAllocate2.limit()];
                        inputStream.read(bArr);
                        byteBufferWrap = ByteBuffer.wrap(bArr);
                        byteBufferWrap.position(byteBufferWrap.limit());
                        byteBufferWrap.flip();
                        d12 = ((byteBufferWrap.get(0) & 255) << 0) | ((byteBufferWrap.get(1) & 255) << 8) | ((byteBufferWrap.get(2) & 255) << 16);
                        d13 = 1.1920930376163766E-7d;
                    } else if (i3 != i10) {
                        byteBuffer = byteBufferAllocate2;
                        i11 = i11;
                        dArr = dArr;
                        d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
                    } else {
                        byteBufferAllocate2.position(0);
                        byteBufferAllocate2.limit(i10);
                        byte[] bArr2 = new byte[byteBufferAllocate2.limit()];
                        inputStream.read(bArr2);
                        byteBufferWrap = ByteBuffer.wrap(bArr2);
                        byteBufferWrap.position(byteBufferWrap.limit());
                        byteBufferWrap.flip();
                        d13 = 4.656612875245797E-10d;
                        d12 = byteBufferWrap.order(this.f16081a).asIntBuffer().get(0);
                    }
                    d4 = d12 * d13;
                    i11 = i11;
                    d5 = d4;
                    byteBuffer = byteBufferWrap;
                } else {
                    byteBufferAllocate2.position(0);
                    byteBufferAllocate2.limit(2);
                    byte[] bArr3 = new byte[byteBufferAllocate2.limit()];
                    inputStream.read(bArr3);
                    byteBufferWrap = ByteBuffer.wrap(bArr3);
                    byteBufferWrap.position(byteBufferWrap.limit());
                    byteBufferWrap.flip();
                    d3 = 3.051850947599719E-5d;
                    d2 = byteBufferWrap.order(this.f16081a).asShortBuffer().get(0);
                }
                if (inputStream.available() == 0) {
                    break;
                }
                d6 = d5 * d;
                if (z) {
                    i13 = i13;
                    ByteBuffer byteBuffer3 = byteBufferAllocate;
                    i7 = 4;
                    if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        d7 = d6;
                    } else {
                        d7 = -d6;
                    }
                    d8 = dArr[0];
                    if (d8 >= d7) {
                        d7 = d8;
                    }
                    dArr[0] = d7;
                    byteBuffer2 = byteBuffer3;
                    byteBuffer2.position(0);
                    byteBuffer2.putDouble(d6);
                    byteBuffer2.flip();
                    writeBuffers(outputStream, byteBuffer2);
                } else {
                    if (i4 != 1) {
                        i13 = i13;
                        byteBufferAllocate = byteBufferAllocate;
                        i7 = 4;
                        d9 = d6 * 127.0d;
                        if (i6 != 0) {
                            iA = c(d9, dArr, i6, i12);
                        } else {
                            iA = a(d9);
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(1);
                        byteBuffer.put(0, (byte) (iA + 128));
                        byteBuffer.flip();
                        writeBuffers(outputStream, byteBuffer);
                    } else if (i4 != 2) {
                        i13 = i13;
                        byteBufferAllocate = byteBufferAllocate;
                        i7 = 4;
                        d10 = d6 * 32767.0d;
                        if (i6 != 0) {
                            iA2 = c(d10, dArr, i6, i12);
                        } else {
                            iA2 = a(d10);
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(2);
                        byteBuffer.asShortBuffer().put(0, (short) iA2);
                        byteBuffer.flip();
                        writeBuffers(outputStream, byteBuffer);
                    } else if (i4 != 3) {
                        i13 = i13;
                        byteBufferAllocate = byteBufferAllocate;
                        i7 = 4;
                    } else {
                        d11 = d6 * 8388607.0d;
                        if (i6 != 0) {
                            i7 = 4;
                            iA3 = c(d11, dArr, i6, i12);
                        } else {
                            i7 = 4;
                            iA3 = a(d11);
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(3);
                        byteBuffer.put(0, (byte) (iA3 & 255));
                        int i14 = iA3 >> 8;
                        byteBuffer.put(1, (byte) (i14 & 255));
                        byteBuffer.put(2, (byte) ((i14 >> 8) & 255));
                        byteBuffer.flip();
                        writeBuffers(outputStream, byteBuffer);
                    }
                    byteBuffer2 = byteBufferAllocate;
                }
                i8 = i12 + 1;
                if (i8 == i2) {
                    i12 = 0;
                } else {
                    i12 = i8;
                }
                i11++;
                if ((262143 & i11) == 0) {
                    m(((double) i11) / ((double) i13));
                }
                byteBufferAllocate = byteBuffer2;
                byteBufferAllocate2 = byteBuffer;
                i10 = i7;
                dArr = dArr;
                i9 = 1;
            } else {
                byteBufferAllocate2.position(0);
                byteBufferAllocate2.limit(1);
                byte[] bArr4 = new byte[byteBufferAllocate2.limit()];
                inputStream.read(bArr4);
                byteBufferWrap = ByteBuffer.wrap(bArr4);
                byteBufferWrap.position(byteBufferWrap.limit());
                byteBufferWrap.flip();
                d2 = byteBufferWrap.get(0) + UnsignedBytes.f32243a;
                d3 = 0.007874015748031496d;
            }
            d4 = d3 * d2;
            d5 = d4;
            byteBuffer = byteBufferWrap;
            if (inputStream.available() == 0) {
                break;
                break;
            }
            d6 = d5 * d;
            if (z) {
                if (i4 != 1) {
                    i13 = i13;
                    byteBufferAllocate = byteBufferAllocate;
                    i7 = 4;
                    d9 = d6 * 127.0d;
                    if (i6 != 0) {
                        iA = c(d9, dArr, i6, i12);
                    } else {
                        iA = a(d9);
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(1);
                    byteBuffer.put(0, (byte) (iA + 128));
                    byteBuffer.flip();
                    writeBuffers(outputStream, byteBuffer);
                } else if (i4 != 2) {
                    i13 = i13;
                    byteBufferAllocate = byteBufferAllocate;
                    i7 = 4;
                    d10 = d6 * 32767.0d;
                    if (i6 != 0) {
                        iA2 = c(d10, dArr, i6, i12);
                    } else {
                        iA2 = a(d10);
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(2);
                    byteBuffer.asShortBuffer().put(0, (short) iA2);
                    byteBuffer.flip();
                    writeBuffers(outputStream, byteBuffer);
                } else if (i4 != 3) {
                    i13 = i13;
                    byteBufferAllocate = byteBufferAllocate;
                    i7 = 4;
                } else {
                    d11 = d6 * 8388607.0d;
                    if (i6 != 0) {
                        i7 = 4;
                        iA3 = c(d11, dArr, i6, i12);
                    } else {
                        i7 = 4;
                        iA3 = a(d11);
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(3);
                    byteBuffer.put(0, (byte) (iA3 & 255));
                    int i15 = iA3 >> 8;
                    byteBuffer.put(1, (byte) (i15 & 255));
                    byteBuffer.put(2, (byte) ((i15 >> 8) & 255));
                    byteBuffer.flip();
                    writeBuffers(outputStream, byteBuffer);
                }
                byteBuffer2 = byteBufferAllocate;
            } else {
                i13 = i13;
                ByteBuffer byteBuffer4 = byteBufferAllocate;
                i7 = 4;
                if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d7 = d6;
                } else {
                    d7 = -d6;
                }
                d8 = dArr[0];
                if (d8 >= d7) {
                    d7 = d8;
                }
                dArr[0] = d7;
                byteBuffer2 = byteBuffer4;
                byteBuffer2.position(0);
                byteBuffer2.putDouble(d6);
                byteBuffer2.flip();
                writeBuffers(outputStream, byteBuffer2);
            }
            i8 = i12 + 1;
            if (i8 == i2) {
                i12 = 0;
            } else {
                i12 = i8;
            }
            i11++;
            if ((262143 & i11) == 0) {
                m(((double) i11) / ((double) i13));
            }
            byteBufferAllocate = byteBuffer2;
            byteBufferAllocate2 = byteBuffer;
            i10 = i7;
            dArr = dArr;
            i9 = 1;
        }
        m(1.0d);
        return dArr[0];
    }

    public final void k(int i2) {
    }

    public final void l() {
        this.f16079a = System.currentTimeMillis();
        this.f16087b = 0L;
        this.g = -1;
    }

    public final void m(double d) {
        if (this.f16082a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f16079a;
        int i2 = d == AudioStats.AUDIO_AMPLITUDE_NONE ? 0 : (int) ((jCurrentTimeMillis * (1.0d - d)) / d);
        int i3 = (int) (d * 100.0d);
        if (i3 != this.g || jCurrentTimeMillis != this.f16087b) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i3));
            this.g = i3;
        }
        if (jCurrentTimeMillis != this.f16087b) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i2));
            this.f16087b = jCurrentTimeMillis;
        }
        System.err.printf(b85.b, new Object[0]);
        System.err.flush();
    }

    public final double n(double d) {
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    /* JADX WARN: Code duplicated, block: B:247:0x07f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:248:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:250:0x0808  */
    /* JADX WARN: Code duplicated, block: B:253:0x0833 A[EDGE_INSN: B:253:0x0833->B:254:0x0839 BREAK  A[LOOP:6: B:54:0x0246->B:272:0x08f7]] */
    /* JADX WARN: Code duplicated, block: B:255:0x083d  */
    /* JADX WARN: Code duplicated, block: B:256:0x0854  */
    /* JADX WARN: Code duplicated, block: B:258:0x085f  */
    /* JADX WARN: Code duplicated, block: B:261:0x086a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:262:0x086c  */
    /* JADX WARN: Code duplicated, block: B:264:0x0882  */
    /* JADX WARN: Code duplicated, block: B:268:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:271:0x08f1  */
    /* JADX WARN: Code duplicated, block: B:286:0x081c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x0897 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:0x08f7 A[SYNTHETIC] */
    public double o(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z, int i8) throws IOException {
        int i9;
        int i10;
        double d2;
        int i11;
        int i12;
        double[] dArr;
        int i13;
        int i14;
        int i15;
        double[] dArr2;
        int i16;
        char c2;
        int i17;
        int i18;
        ByteBuffer byteBuffer;
        int i19;
        int iA;
        char c3;
        int i20;
        int i21;
        int i22;
        ByteBuffer byteBuffer2;
        int iA2;
        char c4;
        int i23;
        int i24;
        ByteBuffer byteBuffer3;
        int i25;
        char c5;
        double[] dArr3;
        int i26;
        int iA3;
        char c6;
        int i27;
        int i28;
        int i29;
        int i30;
        double d3;
        double d4;
        int i31;
        int iFloor;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36 = i6;
        double[] dArr4 = {AudioStats.AUDIO_AMPLITUDE_NONE};
        int i37 = this.f16078a;
        double d5 = this.f16077a;
        int iF = i5 / f(i5, i36);
        int i38 = iF * i36;
        int i39 = i38 / i36;
        if (i39 == 1) {
            i9 = 1;
        } else if (i39 % 2 == 0) {
            i9 = 2;
        } else {
            if (i39 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i39)));
            }
            i9 = 3;
        }
        int i40 = i36 * i9;
        int i41 = i5 / 2;
        int i42 = (i40 / 2) - i41;
        double d6 = i41;
        double d7 = d6 + (((double) i42) / 2.0d);
        double d8 = i38;
        int i43 = (int) (((d8 / (((double) (i42 * 2)) / 2.0d)) * (d5 <= 21.0d ? 0.9222d : (d5 - 7.95d) / 14.36d)) + 1.0d);
        if (i43 % 2 == 0) {
            i43++;
        }
        int i44 = i43;
        double dB = b(d5);
        double dA = s34.a(dB);
        int i45 = i38 / i5;
        int i46 = (i44 / i45) + 1;
        int i47 = i45 * i9;
        int[] iArr = new int[i47];
        for (int i48 = 0; i48 < i47; i48++) {
            int i49 = i45 - (((i38 / i40) * i48) % i45);
            iArr[i48] = i49;
            if (i49 == i45) {
                iArr[i48] = 0;
            }
        }
        int[] iArr2 = new int[i47];
        int i50 = 0;
        while (i50 < i47) {
            int i51 = i47;
            iArr2[i50] = iArr[i50] < i38 / i40 ? i2 : 0;
            if (iArr[i50] == i45) {
                iArr[i50] = 0;
            }
            i50++;
            i47 = i51;
        }
        int i52 = i47;
        boolean z2 = false;
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i45, i46);
        int i53 = i44 / 2;
        int i54 = -i53;
        while (i54 <= i53) {
            int i55 = i54 + i53;
            int i56 = i52;
            int i57 = i54;
            dArr5[i55 % i45][i55 / i45] = ((q(i54, i44, dB, dA) * g(i57, d7, d8)) * d8) / ((double) i5);
            i54 = i57 + 1;
            i40 = i40;
            i53 = i53;
            dArr4 = dArr4;
            i38 = i38;
            iArr2 = iArr2;
            iArr = iArr;
            i52 = i56;
            i46 = i46;
            z2 = false;
            i44 = i44;
        }
        int[] iArr3 = iArr;
        int i58 = i53;
        int[] iArr4 = iArr2;
        int i59 = i38;
        double[] dArr6 = dArr4;
        int i60 = i46;
        int i61 = i52;
        int i62 = i40;
        double d9 = this.f16077a;
        double d10 = d9 > 21.0d ? (d9 - 7.95d) / 14.36d : 0.9222d;
        int i63 = 1;
        while (true) {
            int i64 = i37 * i63;
            if (i64 % 2 == 0) {
                i64--;
            }
            i10 = i64;
            d2 = i62;
            i11 = i45;
            if ((d2 * d10) / ((double) (i10 - 1)) < this.f16085b) {
                break;
            }
            i63 *= 2;
            i36 = i6;
            i45 = i11;
            d6 = d6;
            i61 = i61;
        }
        double dB2 = b(d9);
        double dA2 = s34.a(dB2);
        int i65 = 1;
        while (i65 < i10) {
            i65 *= 2;
        }
        int i66 = i65 * 2;
        double[] dArr7 = new double[i66];
        int i67 = i10 / 2;
        int i68 = -i67;
        while (i68 <= i67) {
            int i69 = i68;
            int i70 = i66;
            double[] dArr8 = dArr7;
            double d11 = d2;
            dArr8[i68 + i67] = ((q(i68, i10, dB2, dA2) * g(i69, d6, d11)) / ((double) i70)) * 2.0d;
            i68 = i69 + 1;
            i66 = i70;
            i67 = i67;
            dArr7 = dArr8;
            d2 = d11;
        }
        int i71 = i68;
        int i72 = i66;
        double[] dArr9 = dArr7;
        double d12 = d2;
        int[] iArr5 = new int[(int) (Math.sqrt(i72) + 2.0d)];
        iArr5[0] = 0;
        int i73 = i72 / 2;
        double[] dArr10 = new double[i73];
        this.f16080a.I(i72, 1, dArr9, iArr5, dArr10);
        l();
        int i74 = (i73 / i9) + 1;
        double[][] dArr11 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i2, i74);
        double[][] dArr12 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i2, i72);
        int i75 = i60;
        int i76 = (i73 + i75) * i2;
        int i77 = i3;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i76 * i77);
        int i78 = i74 * i2;
        int i79 = i72;
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i78 * i4);
        double[] dArr13 = new double[i76];
        double[] dArr14 = new double[i78];
        int i80 = (int) ((((double) i10) / 2.0d) / ((double) (i62 / i36)));
        ByteBuffer byteBuffer4 = byteBufferAllocate2;
        int i81 = (i58 / i11) + 1;
        int i82 = 0;
        int i83 = 0;
        int i84 = 0;
        int i85 = 0;
        boolean z3 = true;
        int i86 = 0;
        int i87 = 0;
        ByteBuffer byteBuffer5 = byteBufferAllocate;
        int i88 = i7;
        int i89 = 0;
        while (true) {
            double[] dArr15 = dArr14;
            int[] iArr6 = iArr5;
            int i90 = i73;
            int i91 = i79;
            double d13 = i5;
            int iFloor2 = (int) (((Math.floor((((double) i73) * d13) / d12) + 1.0d) + ((double) i75)) - ((double) i81));
            int i92 = iFloor2 + i82 > i88 ? i88 - i82 : iFloor2;
            byteBuffer5.position(0);
            int i93 = i77 * i2;
            byteBuffer5.limit(Math.min(byteBuffer5.limit(), i92 * i93));
            byte[] bArr = new byte[byteBuffer5.limit()];
            int i94 = inputStream.read(bArr);
            int i95 = i88;
            int i96 = i94 < 0 ? 0 : i94;
            int i97 = i96 < byteBuffer5.limit() ? ((i96 / i77) * i2) + i82 : i95;
            byteBuffer5.limit(i96);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(i96);
            byteBufferWrap.flip();
            int i98 = i96 / i93;
            if (i77 == 1) {
                i12 = i75;
                dArr = dArr10;
                i13 = i97;
                i14 = 0;
                while (i14 < i98 * i2) {
                    dArr13[(i2 * i81) + i14] = (((double) byteBufferWrap.get(i14)) - 128.0d) * 0.007874015748031496d;
                    i14++;
                }
            } else if (i77 == 2) {
                i12 = i75;
                dArr = dArr10;
                i13 = i97;
                i14 = 0;
                while (i14 < i98 * i2) {
                    dArr13[(i2 * i81) + i14] = ((double) byteBufferWrap.order(this.f16081a).asShortBuffer().get(i14)) * 3.051850947599719E-5d;
                    i14++;
                }
            } else if (i77 == 3) {
                i12 = i75;
                i14 = 0;
                while (i14 < i98 * i2) {
                    int i99 = i14 * 3;
                    dArr13[(i2 * i81) + i14] = ((double) ((byteBufferWrap.get(i99 + 2) << com.google.common.base.a.r) | (byteBufferWrap.get(i99 + 1) << 8) | (byteBufferWrap.get(i99) << 0))) * 1.1920930376163766E-7d;
                    i14++;
                    i97 = i97;
                    dArr10 = dArr10;
                }
                dArr = dArr10;
                i13 = i97;
            } else if (i77 != 4) {
                i12 = i75;
                dArr = dArr10;
                i13 = i97;
                i14 = i71;
            } else {
                int i100 = 0;
                while (i100 < i98 * i2) {
                    dArr13[(i2 * i81) + i100] = ((double) byteBufferWrap.order(this.f16081a).asIntBuffer().get(i100)) * 4.656612875245797E-10d;
                    i100++;
                    i75 = i75;
                }
                i12 = i75;
                dArr = dArr10;
                i13 = i97;
                i14 = i100;
            }
            while (i14 < i2 * iFloor2) {
                dArr13[(i2 * i81) + i14] = 0.0d;
                i14++;
            }
            int i101 = i81 + iFloor2;
            int i102 = i82 + i98;
            int i103 = i13;
            boolean z4 = i102 >= i103;
            int i104 = ((((i87 - 1) * i5) + i59) / i59) * i2;
            int i105 = i89;
            int i106 = i14;
            int i107 = i83;
            int i108 = i85;
            int i109 = 0;
            while (i109 < i2) {
                int i110 = i104 + i109;
                int i111 = i12;
                if (i111 == 7) {
                    i32 = i90;
                    i33 = i104;
                    i34 = i61;
                    i35 = i89;
                    for (int i112 = 0; i112 < i32; i112++) {
                        int i113 = iArr3[i35];
                        double[] dArr16 = dArr12[i109];
                        double[] dArr17 = dArr5[i113];
                        dArr16[i112] = (dArr17[0] * dArr13[i110 + (i2 * 0)]) + (dArr17[1] * dArr13[i110 + (i2 * 1)]) + (dArr17[2] * dArr13[i110 + (i2 * 2)]) + (dArr17[3] * dArr13[i110 + (i2 * 3)]) + (dArr17[4] * dArr13[i110 + (i2 * 4)]) + (dArr17[5] * dArr13[i110 + (i2 * 5)]) + (dArr17[6] * dArr13[i110 + (i2 * 6)]);
                        i110 += iArr4[i35];
                        i35++;
                        if (i35 == i34) {
                            i35 = 0;
                        }
                    }
                } else if (i111 != 9) {
                    i35 = i89;
                    i32 = i90;
                    int i114 = 0;
                    while (i114 < i32) {
                        int i115 = iArr3[i35];
                        int i116 = i104;
                        int i117 = i110;
                        double d14 = 0.0d;
                        for (int i118 = 0; i118 < i111; i118++) {
                            d14 += dArr5[i115][i118] * dArr13[i117];
                            i117 += i2;
                        }
                        dArr12[i109][i114] = d14;
                        i110 += iArr4[i35];
                        int i119 = i35 + 1;
                        int i120 = i61;
                        if (i119 == i120) {
                            i119 = 0;
                        }
                        i114++;
                        i61 = i120;
                        i35 = i119;
                        i104 = i116;
                    }
                    i33 = i104;
                    i34 = i61;
                } else {
                    i32 = i90;
                    i33 = i104;
                    i34 = i61;
                    int i121 = i89;
                    for (int i122 = 0; i122 < i32; i122++) {
                        int i123 = iArr3[i121];
                        double[] dArr18 = dArr12[i109];
                        double[] dArr19 = dArr5[i123];
                        dArr18[i122] = (dArr19[0] * dArr13[i110 + (i2 * 0)]) + (dArr19[1] * dArr13[i110 + (i2 * 1)]) + (dArr19[2] * dArr13[i110 + (i2 * 2)]) + (dArr19[3] * dArr13[i110 + (i2 * 3)]) + (dArr19[4] * dArr13[i110 + (i2 * 4)]) + (dArr19[5] * dArr13[i110 + (i2 * 5)]) + (dArr19[6] * dArr13[i110 + (i2 * 6)]) + (dArr19[7] * dArr13[i110 + (i2 * 7)]) + (dArr19[8] * dArr13[i110 + (i2 * 8)]);
                        i110 += iArr4[i121];
                        int i124 = i121 + 1;
                        i121 = i124 == i34 ? 0 : i124;
                    }
                    i35 = i121;
                }
                for (int i125 = i32; i125 < i91; i125++) {
                    dArr12[i109][i125] = 0.0d;
                }
                this.f16080a.I(i91, 1, dArr12[i109], iArr6, dArr);
                double[] dArr20 = dArr12[i109];
                dArr20[0] = dArr9[0] * dArr20[0];
                dArr20[1] = dArr9[1] * dArr20[1];
                for (int i126 = 1; i126 < i32; i126++) {
                    int i127 = i126 * 2;
                    double d15 = dArr9[i127];
                    double[] dArr21 = dArr12[i109];
                    double d16 = dArr21[i127];
                    int i128 = i127 + 1;
                    double d17 = dArr9[i128];
                    double d18 = dArr21[i128];
                    dArr21[i127] = (d15 * d16) - (d17 * d18);
                    dArr21[i128] = (d17 * d16) + (d15 * d18);
                }
                this.f16080a.I(i91, -1, dArr12[i109], iArr6, dArr);
                int i129 = i83;
                int i130 = 0;
                while (i129 < i32) {
                    dArr15[i109 + (i130 * i2)] = dArr11[i109][i130] + dArr12[i109][i129];
                    i129 += i9;
                    i130++;
                }
                int i131 = i129 - i32;
                int i132 = 0;
                while (i129 < i91) {
                    dArr11[i109][i132] = dArr12[i109][i129];
                    i129 += i9;
                    i132++;
                }
                i109++;
                i61 = i34;
                i12 = i111;
                i104 = i33;
                i108 = i130;
                i106 = i129;
                i90 = i32;
                i105 = i35;
                i107 = i131;
            }
            char c7 = 7;
            int i133 = i90;
            int i134 = i61;
            int i135 = i12;
            int i136 = i87 + ((i133 * iF) / i9);
            byteBuffer4.clear();
            if (z) {
                i106 = 0;
                while (i106 < i108 * i2) {
                    int i137 = i91;
                    double[] dArr22 = dArr13;
                    double d19 = dArr15[i106];
                    if (d19 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        d19 = -d19;
                    }
                    double d20 = dArr6[0];
                    if (d20 >= d19) {
                        d19 = d20;
                    }
                    dArr6[0] = d19;
                    byteBuffer4.asDoubleBuffer().put(i106, dArr15[i106]);
                    i106++;
                    dArr13 = dArr22;
                    i91 = i137;
                    i134 = i134;
                }
                i15 = i91;
                i16 = i134;
                c2 = 3;
                dArr2 = dArr13;
            } else {
                i15 = i91;
                dArr2 = dArr13;
                i16 = i134;
                if (i4 == 1) {
                    i105 = i105;
                    c2 = 3;
                    i17 = i108;
                    ByteBuffer byteBuffer6 = byteBuffer4;
                    i18 = i107;
                    byteBuffer = byteBuffer6;
                    double d21 = d * 127.0d;
                    i19 = 0;
                    int i138 = 0;
                    while (i19 < i17 * i2) {
                        if (i8 != 0) {
                            iA = c(dArr15[i19] * d21, dArr6, i8, i138);
                        } else {
                            iA = a(dArr15[i19] * d21);
                            if (iA < -128) {
                                double d22 = ((double) iA) / (-128.0d);
                                c3 = 0;
                                double d23 = dArr6[0];
                                if (d23 >= d22) {
                                    d22 = d23;
                                }
                                dArr6[0] = d22;
                                iA = -128;
                            } else {
                                c3 = 0;
                            }
                            if (127 < iA) {
                                double d24 = ((double) iA) / 127.0d;
                                double d25 = dArr6[c3];
                                if (d25 >= d24) {
                                    d24 = d25;
                                }
                                dArr6[c3] = d24;
                                iA = 127;
                            }
                        }
                        byteBuffer.put(i19, (byte) (iA + 128));
                        int i139 = i138 + 1;
                        i138 = i139 == i2 ? 0 : i139;
                        i19++;
                    }
                } else if (i4 != 2) {
                    char c8 = 3;
                    if (i4 != 3) {
                        i15 = i15;
                        c2 = 3;
                        dArr2 = dArr2;
                    } else {
                        double d26 = d * 8388607.0d;
                        i106 = 0;
                        int i140 = 0;
                        while (i106 < i108 * i2) {
                            if (i8 != 0) {
                                i25 = i15;
                                c5 = c8;
                                i23 = i106;
                                int i141 = i135;
                                dArr3 = dArr2;
                                byteBuffer3 = byteBufferWrap;
                                i24 = i141;
                                i26 = i108;
                                iA3 = c(dArr15[i106] * d26, dArr6, i8, i140);
                            } else {
                                i23 = i106;
                                i24 = i135;
                                byteBuffer3 = byteBufferWrap;
                                i25 = i15;
                                c5 = c8;
                                dArr3 = dArr2;
                                i26 = i108;
                                iA3 = a(dArr15[i23] * d26);
                                if (iA3 < -8388608) {
                                    double d27 = ((double) iA3) / (-8388608.0d);
                                    c6 = 0;
                                    double d28 = dArr6[0];
                                    if (d28 >= d27) {
                                        d27 = d28;
                                    }
                                    dArr6[0] = d27;
                                    iA3 = -8388608;
                                } else {
                                    c6 = 0;
                                }
                                if (8388607 < iA3) {
                                    double d29 = ((double) iA3) / 8388607.0d;
                                    double d30 = dArr6[c6];
                                    if (d30 >= d29) {
                                        d29 = d30;
                                    }
                                    dArr6[c6] = d29;
                                    iA3 = 8388607;
                                }
                            }
                            int i142 = i23 * 3;
                            ByteBuffer byteBuffer7 = byteBuffer4;
                            byteBuffer7.put(i142, (byte) (iA3 & 255));
                            int i143 = iA3 >> 8;
                            byteBuffer7.put(i142 + 1, (byte) (i143 & 255));
                            byteBuffer7.put(i142 + 2, (byte) ((i143 >> 8) & 255));
                            int i144 = i140 + 1;
                            i140 = i144 == i2 ? 0 : i144;
                            i106 = i23 + 1;
                            byteBuffer4 = byteBuffer7;
                            dArr2 = dArr3;
                            i108 = i26;
                            c8 = c5;
                            i15 = i25;
                            byteBufferWrap = byteBuffer3;
                            i135 = i24;
                            c7 = 7;
                        }
                        i135 = i135;
                        byteBufferWrap = byteBufferWrap;
                        i15 = i15;
                        c2 = c8;
                        dArr2 = dArr2;
                        i17 = i108;
                        i105 = i105;
                    }
                    ByteBuffer byteBuffer8 = byteBuffer4;
                    i18 = i107;
                    byteBuffer = byteBuffer8;
                    if (z3) {
                        i27 = i106;
                        i28 = i86;
                        i29 = i80;
                        if (i17 < i29) {
                            i80 = i29 - i17;
                            i86 = i28;
                            i30 = i27;
                        } else if (z4) {
                            i30 = i27;
                            d3 = (((double) i102) * ((double) i6)) / d13;
                            if (d3 + 2.0d <= (i28 + i17) - i29) {
                                int i145 = i4 * i2;
                                byteBuffer.position(i145 * i29);
                                byteBuffer.limit((int) (((double) i145) * ((((Math.floor(d3) + 2.0d) + ((double) i28)) + ((double) i17)) - ((double) i29))));
                                writeBuffers(outputStream, byteBuffer);
                                break;
                            }
                            int i146 = i4 * i2;
                            byteBuffer.position(i146 * i29);
                            int i147 = i17 - i29;
                            byteBuffer.limit(i146 * i147);
                            writeBuffers(outputStream, byteBuffer);
                            i86 = i28 + i147;
                            i80 = i29;
                        } else {
                            i102 = i102;
                            i30 = i27;
                            int i148 = i4 * i2;
                            byteBuffer.position(i148 * i29);
                            byteBuffer.limit(i148 * i17);
                            writeBuffers(outputStream, byteBuffer);
                            i86 = i28 + (i17 - i29);
                            i80 = i29;
                            z3 = false;
                        }
                        int i149 = (i136 - 1) / i11;
                        i81 = i101 - i149;
                        System.arraycopy(dArr2, i2 * i149, dArr2, 0, i2 * i81);
                        i87 = i136 - (i149 * i11);
                        int i150 = i84 + 1;
                        i82 = i102;
                        if ((i84 & 7) == 7) {
                            m(((double) i82) / ((double) i103));
                        }
                        i77 = i3;
                        i84 = i150;
                        dArr13 = dArr2;
                        i88 = i103;
                        i73 = i133;
                        i79 = i15;
                        i89 = i105;
                        dArr14 = dArr15;
                        iArr5 = iArr6;
                        dArr10 = dArr;
                        i75 = i135;
                        i71 = i30;
                        i61 = i16;
                        i83 = i18;
                        i85 = i17;
                        byteBuffer4 = byteBuffer;
                        byteBuffer5 = byteBufferWrap;
                    } else {
                        if (z4) {
                            d4 = (((double) i102) * ((double) i6)) / d13;
                            i31 = i86 + i17;
                            i27 = i106;
                            if (d4 + 2.0d <= i31) {
                                byteBuffer.position(0);
                                iFloor = (int) (((double) (i4 * i2)) * ((Math.floor(d4) + 2.0d) - ((double) i86)));
                                if (iFloor <= 0) {
                                    break;
                                }
                                byteBuffer.limit(iFloor);
                                writeBuffers(outputStream, byteBuffer);
                                break;
                            }
                            byteBuffer.position(0);
                            byteBuffer.limit(i4 * i2 * i17);
                            writeBuffers(outputStream, byteBuffer);
                            i86 = i31;
                        } else {
                            i27 = i106;
                            byteBuffer.position(0);
                            byteBuffer.limit(i4 * i2 * i17);
                            writeBuffers(outputStream, byteBuffer);
                            i86 += i17;
                        }
                        i30 = i27;
                    }
                    int i1410 = (i136 - 1) / i11;
                    i81 = i101 - i1410;
                    System.arraycopy(dArr2, i2 * i1410, dArr2, 0, i2 * i81);
                    i87 = i136 - (i1410 * i11);
                    int i151 = i84 + 1;
                    i82 = i102;
                    if ((i84 & 7) == 7) {
                        m(((double) i82) / ((double) i103));
                    }
                    i77 = i3;
                    i84 = i151;
                    dArr13 = dArr2;
                    i88 = i103;
                    i73 = i133;
                    i79 = i15;
                    i89 = i105;
                    dArr14 = dArr15;
                    iArr5 = iArr6;
                    dArr10 = dArr;
                    i75 = i135;
                    i71 = i30;
                    i61 = i16;
                    i83 = i18;
                    i85 = i17;
                    byteBuffer4 = byteBuffer;
                    byteBuffer5 = byteBufferWrap;
                } else {
                    c2 = 3;
                    i17 = i108;
                    ByteBuffer byteBuffer9 = byteBuffer4;
                    double d31 = d * 32767.0d;
                    int i152 = 0;
                    int i153 = 0;
                    while (i152 < i17 * i2) {
                        if (i8 != 0) {
                            i20 = i105;
                            i22 = i152;
                            i21 = i107;
                            byteBuffer2 = byteBuffer9;
                            iA2 = c(dArr15[i152] * d31, dArr6, i8, i153);
                        } else {
                            i20 = i105;
                            i21 = i107;
                            i22 = i152;
                            byteBuffer2 = byteBuffer9;
                            iA2 = a(dArr15[i22] * d31);
                            if (iA2 < -32768) {
                                double d32 = ((double) iA2) / (-32768.0d);
                                c4 = 0;
                                double d33 = dArr6[0];
                                if (d33 >= d32) {
                                    d32 = d33;
                                }
                                dArr6[0] = d32;
                                iA2 = -32768;
                            } else {
                                c4 = 0;
                            }
                            if (32767 < iA2) {
                                double d34 = ((double) iA2) / 32767.0d;
                                double d35 = dArr6[c4];
                                if (d35 >= d34) {
                                    d34 = d35;
                                }
                                dArr6[c4] = d34;
                                iA2 = 32767;
                            }
                        }
                        byteBuffer2.order(this.f16081a).asShortBuffer().put(i22, (short) iA2);
                        int i154 = i153 + 1;
                        i153 = i154 == i2 ? 0 : i154;
                        i152 = i22 + 1;
                        byteBuffer9 = byteBuffer2;
                        i105 = i20;
                        i107 = i21;
                    }
                    i105 = i105;
                    i18 = i107;
                    i19 = i152;
                    byteBuffer = byteBuffer9;
                }
                i106 = i19;
                if (z3) {
                    if (z4) {
                        d4 = (((double) i102) * ((double) i6)) / d13;
                        i31 = i86 + i17;
                        i27 = i106;
                        if (d4 + 2.0d <= i31) {
                            byteBuffer.position(0);
                            iFloor = (int) (((double) (i4 * i2)) * ((Math.floor(d4) + 2.0d) - ((double) i86)));
                            if (iFloor <= 0) {
                                break;
                            }
                            byteBuffer.limit(iFloor);
                            writeBuffers(outputStream, byteBuffer);
                            break;
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(i4 * i2 * i17);
                        writeBuffers(outputStream, byteBuffer);
                        i86 = i31;
                    } else {
                        i27 = i106;
                        byteBuffer.position(0);
                        byteBuffer.limit(i4 * i2 * i17);
                        writeBuffers(outputStream, byteBuffer);
                        i86 += i17;
                    }
                    i30 = i27;
                } else {
                    i27 = i106;
                    i28 = i86;
                    i29 = i80;
                    if (i17 < i29) {
                        i80 = i29 - i17;
                        i86 = i28;
                        i30 = i27;
                    } else if (z4) {
                        i30 = i27;
                        d3 = (((double) i102) * ((double) i6)) / d13;
                        if (d3 + 2.0d <= (i28 + i17) - i29) {
                            int i1411 = i4 * i2;
                            byteBuffer.position(i1411 * i29);
                            byteBuffer.limit((int) (((double) i1411) * ((((Math.floor(d3) + 2.0d) + ((double) i28)) + ((double) i17)) - ((double) i29))));
                            writeBuffers(outputStream, byteBuffer);
                            break;
                        }
                        int i1412 = i4 * i2;
                        byteBuffer.position(i1412 * i29);
                        int i1413 = i17 - i29;
                        byteBuffer.limit(i1412 * i1413);
                        writeBuffers(outputStream, byteBuffer);
                        i86 = i28 + i1413;
                        i80 = i29;
                    } else {
                        i102 = i102;
                        i30 = i27;
                        int i1414 = i4 * i2;
                        byteBuffer.position(i1414 * i29);
                        byteBuffer.limit(i1414 * i17);
                        writeBuffers(outputStream, byteBuffer);
                        i86 = i28 + (i17 - i29);
                        i80 = i29;
                        z3 = false;
                    }
                    int i1415 = (i136 - 1) / i11;
                    i81 = i101 - i1415;
                    System.arraycopy(dArr2, i2 * i1415, dArr2, 0, i2 * i81);
                    i87 = i136 - (i1415 * i11);
                    int i155 = i84 + 1;
                    i82 = i102;
                    if ((i84 & 7) == 7) {
                        m(((double) i82) / ((double) i103));
                    }
                    i77 = i3;
                    i84 = i155;
                    dArr13 = dArr2;
                    i88 = i103;
                    i73 = i133;
                    i79 = i15;
                    i89 = i105;
                    dArr14 = dArr15;
                    iArr5 = iArr6;
                    dArr10 = dArr;
                    i75 = i135;
                    i71 = i30;
                    i61 = i16;
                    i83 = i18;
                    i85 = i17;
                    byteBuffer4 = byteBuffer;
                    byteBuffer5 = byteBufferWrap;
                }
                int i1416 = (i136 - 1) / i11;
                i81 = i101 - i1416;
                System.arraycopy(dArr2, i2 * i1416, dArr2, 0, i2 * i81);
                i87 = i136 - (i1416 * i11);
                int i156 = i84 + 1;
                i82 = i102;
                if ((i84 & 7) == 7) {
                    m(((double) i82) / ((double) i103));
                }
                i77 = i3;
                i84 = i156;
                dArr13 = dArr2;
                i88 = i103;
                i73 = i133;
                i79 = i15;
                i89 = i105;
                dArr14 = dArr15;
                iArr5 = iArr6;
                dArr10 = dArr;
                i75 = i135;
                i71 = i30;
                i61 = i16;
                i83 = i18;
                i85 = i17;
                byteBuffer4 = byteBuffer;
                byteBuffer5 = byteBufferWrap;
            }
            i17 = i108;
            ByteBuffer byteBuffer10 = byteBuffer4;
            i18 = i107;
            byteBuffer = byteBuffer10;
            if (z3) {
                if (z4) {
                    d4 = (((double) i102) * ((double) i6)) / d13;
                    i31 = i86 + i17;
                    i27 = i106;
                    if (d4 + 2.0d <= i31) {
                        byteBuffer.position(0);
                        iFloor = (int) (((double) (i4 * i2)) * ((Math.floor(d4) + 2.0d) - ((double) i86)));
                        if (iFloor <= 0) {
                            break;
                        }
                        byteBuffer.limit(iFloor);
                        writeBuffers(outputStream, byteBuffer);
                        break;
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(i4 * i2 * i17);
                    writeBuffers(outputStream, byteBuffer);
                    i86 = i31;
                } else {
                    i27 = i106;
                    byteBuffer.position(0);
                    byteBuffer.limit(i4 * i2 * i17);
                    writeBuffers(outputStream, byteBuffer);
                    i86 += i17;
                }
                i30 = i27;
            } else {
                i27 = i106;
                i28 = i86;
                i29 = i80;
                if (i17 < i29) {
                    i80 = i29 - i17;
                    i86 = i28;
                    i30 = i27;
                } else if (z4) {
                    i30 = i27;
                    d3 = (((double) i102) * ((double) i6)) / d13;
                    if (d3 + 2.0d <= (i28 + i17) - i29) {
                        int i1417 = i4 * i2;
                        byteBuffer.position(i1417 * i29);
                        byteBuffer.limit((int) (((double) i1417) * ((((Math.floor(d3) + 2.0d) + ((double) i28)) + ((double) i17)) - ((double) i29))));
                        writeBuffers(outputStream, byteBuffer);
                        break;
                    }
                    int i1418 = i4 * i2;
                    byteBuffer.position(i1418 * i29);
                    int i1419 = i17 - i29;
                    byteBuffer.limit(i1418 * i1419);
                    writeBuffers(outputStream, byteBuffer);
                    i86 = i28 + i1419;
                    i80 = i29;
                } else {
                    i102 = i102;
                    i30 = i27;
                    int i14110 = i4 * i2;
                    byteBuffer.position(i14110 * i29);
                    byteBuffer.limit(i14110 * i17);
                    writeBuffers(outputStream, byteBuffer);
                    i86 = i28 + (i17 - i29);
                    i80 = i29;
                    z3 = false;
                }
                int i14111 = (i136 - 1) / i11;
                i81 = i101 - i14111;
                System.arraycopy(dArr2, i2 * i14111, dArr2, 0, i2 * i81);
                i87 = i136 - (i14111 * i11);
                int i157 = i84 + 1;
                i82 = i102;
                if ((i84 & 7) == 7) {
                    m(((double) i82) / ((double) i103));
                }
                i77 = i3;
                i84 = i157;
                dArr13 = dArr2;
                i88 = i103;
                i73 = i133;
                i79 = i15;
                i89 = i105;
                dArr14 = dArr15;
                iArr5 = iArr6;
                dArr10 = dArr;
                i75 = i135;
                i71 = i30;
                i61 = i16;
                i83 = i18;
                i85 = i17;
                byteBuffer4 = byteBuffer;
                byteBuffer5 = byteBufferWrap;
            }
            int i14112 = (i136 - 1) / i11;
            i81 = i101 - i14112;
            System.arraycopy(dArr2, i2 * i14112, dArr2, 0, i2 * i81);
            i87 = i136 - (i14112 * i11);
            int i158 = i84 + 1;
            i82 = i102;
            if ((i84 & 7) == 7) {
                m(((double) i82) / ((double) i103));
            }
            i77 = i3;
            i84 = i158;
            dArr13 = dArr2;
            i88 = i103;
            i73 = i133;
            i79 = i15;
            i89 = i105;
            dArr14 = dArr15;
            iArr5 = iArr6;
            dArr10 = dArr;
            i75 = i135;
            i71 = i30;
            i61 = i16;
            i83 = i18;
            i85 = i17;
            byteBuffer4 = byteBuffer;
            byteBuffer5 = byteBufferWrap;
        }
        m(1.0d);
        return dArr6[0];
    }

    public final void p() {
        System.err.printf("http://shibatch.sourceforge.net/\n\n", new Object[0]);
        System.err.printf("usage: ssrc [<options>] <source wav file> <destination wav file>\n", new Object[0]);
        System.err.printf("options : --rate <sampling rate>     output sample rate\n", new Object[0]);
        System.err.printf("          --att <attenuation(dB)>    attenuate signal\n", new Object[0]);
        System.err.printf("          --bits <number of bits>    output quantization bit length\n", new Object[0]);
        System.err.printf("          --tmpfile <file name>      specify temporal file\n", new Object[0]);
        System.err.printf("          --twopass                  two pass processing to avoid clipping\n", new Object[0]);
        System.err.printf("          --normalize                normalize the wave file\n", new Object[0]);
        System.err.printf("          --quiet                    nothing displayed except error\n", new Object[0]);
        System.err.printf("          --dither [<type>]          dithering\n", new Object[0]);
        System.err.printf("                                       0 : no dither\n", new Object[0]);
        System.err.printf("                                       1 : no noise shaping\n", new Object[0]);
        System.err.printf("                                       2 : triangular spectral shape\n", new Object[0]);
        System.err.printf("                                       3 : ATH based noise shaping\n", new Object[0]);
        System.err.printf("                                       4 : less dither amplitude than type 3\n", new Object[0]);
        System.err.printf("          --pdf <type> [<amp>]       select p.d.f. of noise\n", new Object[0]);
        System.err.printf("                                       0 : rectangular\n", new Object[0]);
        System.err.printf("                                       1 : triangular\n", new Object[0]);
        System.err.printf("                                       2 : Gaussian\n", new Object[0]);
        System.err.printf("          --profile <type>           specify profile\n", new Object[0]);
        System.err.printf("                                       standard : the default quality\n", new Object[0]);
        System.err.printf("                                       fast     : fast, not so bad quality\n", new Object[0]);
    }

    public final double q(double d, int i2, double d2, double d3) {
        double d4 = 4.0d * d * d;
        double d5 = ((double) i2) - 1.0d;
        return s34.a(d2 * Math.sqrt(1.0d - (d4 / (d5 * d5)))) / d3;
    }

    public void writeBuffers(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(getDataFromByteBuffer(byteBuffer));
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:283:0x07df  */
    /* JADX WARN: Code duplicated, block: B:285:0x07f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:286:0x07f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:287:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:288:0x0800 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:289:0x0802  */
    /* JADX WARN: Code duplicated, block: B:290:0x0811  */
    /* JADX WARN: Code duplicated, block: B:292:0x083c  */
    /* JADX WARN: Code duplicated, block: B:294:0x0844  */
    /* JADX WARN: Code duplicated, block: B:295:0x0853  */
    /* JADX WARN: Code duplicated, block: B:298:0x0873  */
    /* JADX WARN: Code duplicated, block: B:300:0x087b  */
    /* JADX WARN: Code duplicated, block: B:301:0x088b  */
    /* JADX WARN: Code duplicated, block: B:305:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:306:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:309:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:313:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:314:0x08d6  */
    /* JADX WARN: Code duplicated, block: B:317:0x08e0  */
    /* JADX WARN: Code duplicated, block: B:331:0x0990  */
    /* JADX WARN: Code duplicated, block: B:382:0x08b8 A[SYNTHETIC] */
    public du7(String[] strArr) throws IOException {
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        int i5;
        int i6;
        int iH;
        String str3;
        double d;
        FileOutputStream fileOutputStream;
        du7 du7Var;
        String str4;
        int i7;
        String str5;
        du7 du7Var2;
        File fileCreateTempFile;
        String str6;
        FileOutputStream fileOutputStream2;
        File file;
        int i8;
        int i9;
        double d2;
        double d3;
        int i10;
        double d4;
        int i11;
        int i12;
        int i13;
        int i14;
        int length;
        File file2;
        FileChannel channel;
        ByteBuffer byteBufferAllocate;
        int i15;
        int i16;
        char c2;
        double d5;
        int i17;
        ByteBuffer byteBuffer;
        FileOutputStream fileOutputStream3;
        int iA;
        int i18;
        int iA2;
        FileOutputStream fileOutputStream4;
        int iA3;
        double d6;
        double d7;
        char c3;
        int i19;
        char c4;
        double d8;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        du7 du7Var3 = this;
        du7Var3.f16081a = ByteOrder.LITTLE_ENDIAN;
        du7Var3.f16080a = new hn8();
        du7Var3.f16077a = 170.0d;
        du7Var3.f16085b = 100.0d;
        du7Var3.f16078a = 65536;
        du7Var3.f16082a = false;
        double d9 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double[] dArr = {AudioStats.AUDIO_AMPLITUDE_NONE};
        String str7 = null;
        double d10 = 0.18d;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z = false;
        boolean z2 = false;
        double d11 = 0.0d;
        int i28 = -1;
        int i29 = -1;
        for (int i30 = 0; i25 < strArr.length && strArr[i25].charAt(i30) == '-'; i30 = 0) {
            if (strArr[i25].equals("--rate")) {
                i25++;
                i29 = Integer.parseInt(strArr[i25]);
            } else if (strArr[i25].equals("--att")) {
                i25++;
                d11 = Float.parseFloat(strArr[i25]);
            } else if (strArr[i25].equals("--bits")) {
                i25++;
                int i31 = Integer.parseInt(strArr[i25]);
                if (i31 != 8 && i31 != 16 && i31 != 24) {
                    throw new IllegalArgumentException("Error: Only 8bit, 16bit and 24bit PCM are supported.");
                }
                i28 = i31 / 8;
            } else {
                if (strArr[i25].equals("--twopass")) {
                    i23 = 1;
                    z = true;
                } else if (strArr[i25].equals("--normalize")) {
                    i23 = 1;
                    z = true;
                    z2 = true;
                } else if (strArr[i25].equals("--dither")) {
                    i24 = i25 + 1;
                    try {
                        i27 = Integer.parseInt(strArr[i24]);
                        if (i27 < 0 || i27 > 4) {
                            throw new IllegalArgumentException("unrecognized dither type : " + strArr[i24]);
                        }
                        i25 = i24;
                    } catch (NumberFormatException unused) {
                        i23 = 1;
                        i27 = -1;
                    }
                } else if (strArr[i25].equals("--pdf")) {
                    i25++;
                    try {
                        i26 = Integer.parseInt(strArr[i25]);
                        if (i26 >= 0 && i26 <= 2) {
                            i24 = i25 + 1;
                            try {
                                d10 = Double.parseDouble(strArr[i24]);
                                i25 = i24;
                            } catch (NumberFormatException unused2) {
                                d10 = f16074b[i26];
                            }
                        } else {
                            throw new IllegalArgumentException("unrecognized p.d.f. type : " + strArr[i25]);
                        }
                    } catch (NumberFormatException unused3) {
                        throw new IllegalArgumentException("unrecognized p.d.f. type : " + strArr[i25]);
                    }
                } else if (strArr[i25].equals("--quiet")) {
                    i23 = 1;
                    du7Var3.f16082a = true;
                } else if (strArr[i25].equals("--tmpfile")) {
                    i25++;
                    str7 = strArr[i25];
                } else if (strArr[i25].equals("--profile")) {
                    i25++;
                    if (strArr[i25].equals("fast")) {
                        du7Var3.f16077a = 96.0d;
                        du7Var3.f16085b = 8000.0d;
                        du7Var3.f16078a = 1024;
                    } else if (!strArr[i25].equals("standard")) {
                        throw new IllegalArgumentException("unrecognized profile : " + strArr[i25]);
                    }
                } else {
                    throw new IllegalArgumentException("unrecognized option : " + strArr[i25]);
                }
                i25 += i23;
            }
            i23 = 1;
            i25 += i23;
        }
        if (!du7Var3.f16082a) {
            System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
        }
        if (strArr.length - i25 == 2) {
            String str8 = strArr[i25];
            String str9 = strArr[i25 + 1];
            try {
                FileInputStream fileInputStream = new FileInputStream(str8);
                ByteBuffer byteBufferOrder = ByteBuffer.allocate(256).order(ByteOrder.LITTLE_ENDIAN);
                byteBufferOrder.limit(36);
                fileInputStream.getChannel().read(byteBufferOrder);
                byteBufferOrder.flip();
                System.err.println("p: " + byteBufferOrder.position() + ", l: " + byteBufferOrder.limit());
                if (byteBufferOrder.get() != 82) {
                    i2 = 1;
                    du7Var3.e(1);
                } else {
                    i2 = 1;
                }
                if (byteBufferOrder.get() != 73) {
                    du7Var3.e(i2);
                }
                if (byteBufferOrder.get() != 70) {
                    du7Var3.e(i2);
                }
                if (byteBufferOrder.get() != 70) {
                    du7Var3.e(i2);
                }
                byteBufferOrder.getInt();
                if (byteBufferOrder.get() != 87) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 65) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 86) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 69) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 102) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 109) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 116) {
                    du7Var3.e(2);
                }
                if (byteBufferOrder.get() != 32) {
                    du7Var3.e(2);
                }
                int i32 = byteBufferOrder.getInt();
                if (byteBufferOrder.getShort() == 1) {
                    short s = byteBufferOrder.getShort();
                    int i33 = byteBufferOrder.getInt();
                    int i34 = byteBufferOrder.getInt();
                    if ((i34 % i33) * s != 0) {
                        du7Var3.e(4);
                    }
                    byteBufferOrder.getShort();
                    byteBufferOrder.getShort();
                    int i35 = i34 / (i33 * s);
                    if (i32 > 16) {
                        byteBufferOrder.position(0);
                        byteBufferOrder.limit(2);
                        fileInputStream.read(du7Var3.getDataFromByteBuffer(byteBufferOrder));
                        byteBufferOrder.flip();
                        fileInputStream.getChannel().position(fileInputStream.getChannel().position() + ((long) byteBufferOrder.getShort()));
                    }
                    int i36 = 0;
                    while (true) {
                        byteBufferOrder.position(i36);
                        byteBufferOrder.limit(8);
                        fileInputStream.getChannel().read(byteBufferOrder);
                        byteBufferOrder.flip();
                        byte b2 = byteBufferOrder.get();
                        byte b3 = byteBufferOrder.get();
                        byte b4 = byteBufferOrder.get();
                        byte b5 = byteBufferOrder.get();
                        str = str7;
                        i3 = byteBufferOrder.getInt();
                        ByteBuffer byteBuffer2 = byteBufferOrder;
                        i4 = i26;
                        str2 = str9;
                        System.err.printf("chunk: %c%c%c%c\n", Integer.valueOf(b2), Integer.valueOf(b3), Integer.valueOf(b4), Integer.valueOf(b5));
                        if ((b2 == 100 && b3 == 97 && b4 == 116 && b5 == 97) || fileInputStream.getChannel().position() == fileInputStream.getChannel().size()) {
                            break;
                        }
                        fileInputStream.getChannel().position(fileInputStream.getChannel().position() + ((long) i3));
                        byteBufferOrder = byteBuffer2;
                        i36 = 0;
                        i33 = i33;
                        i27 = i27;
                        str7 = str;
                        i26 = i4;
                        d11 = d11;
                        du7Var3 = this;
                        str9 = str2;
                        i35 = i35;
                    }
                    if (fileInputStream.getChannel().position() == fileInputStream.getChannel().size()) {
                        throw new IllegalStateException("Couldn't find data chank");
                    }
                    if (i35 != 1 && i35 != 2 && i35 != 3 && i35 != 4) {
                        throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
                    }
                    if (i28 == -1) {
                        int i37 = i35 != 1 ? i35 : 2;
                        i5 = i37 == 4 ? 3 : i37;
                    } else {
                        i5 = i28;
                    }
                    int i38 = i29 == -1 ? i33 : i29;
                    int i39 = i27 == -1 ? i5 < i35 ? i5 == 1 ? 4 : 3 : 1 : i27;
                    String str10 = "\n";
                    if (du7Var3.f16082a) {
                        i6 = i3;
                    } else {
                        String[] strArr2 = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
                        String[] strArr3 = {"rectangular", "triangular", "gaussian"};
                        System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i33), Integer.valueOf(i38));
                        System.err.printf("attenuation : %gdB\n", Double.valueOf(d11));
                        System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i35 * 8), Integer.valueOf(i5 * 8));
                        System.err.printf("nchannels : %d\n", Integer.valueOf(s));
                        i6 = i3;
                        System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i3), Double.valueOf(((((double) i3) / ((double) i35)) / ((double) s)) / ((double) i33)));
                        if (i39 == 0) {
                            i22 = 0;
                            System.err.printf("dither type : none\n", new Object[0]);
                        } else {
                            i22 = 0;
                            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr2[i39], strArr3[i4], Double.valueOf(d10));
                        }
                        str10 = "\n";
                        System.err.printf(str10, new Object[i22]);
                    }
                    try {
                        FileOutputStream fileOutputStream5 = new FileOutputStream(new File(str2));
                        ByteBuffer byteBufferOrder2 = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferOrder2.put("RIFF".getBytes());
                        byteBufferOrder2.putInt(0);
                        byteBufferOrder2.put("WAVEfmt ".getBytes());
                        byteBufferOrder2.putInt(16);
                        byteBufferOrder2.putShort((short) 1);
                        byteBufferOrder2.putShort(s);
                        byteBufferOrder2.putInt(i38);
                        byteBufferOrder2.putInt(i38 * s * i5);
                        byteBufferOrder2.putShort((short) (i5 * s));
                        byteBufferOrder2.putShort((short) (i5 * 8));
                        byteBufferOrder2.put("data".getBytes());
                        byteBufferOrder2.putInt(0);
                        byteBufferOrder2.flip();
                        du7Var3.writeBuffers(fileOutputStream5, byteBufferOrder2);
                        if (i39 != 0) {
                            if (i5 == 1) {
                                i20 = com.alipay.sdk.m.p.a.g;
                                i21 = 127;
                            } else {
                                i20 = 0;
                                i21 = 0;
                            }
                            if (i5 == 2) {
                                i20 = -32768;
                                i21 = 32767;
                            }
                            if (i5 == 3) {
                                i20 = -8388608;
                                i21 = 8388607;
                            }
                            if (i5 == 4) {
                                i20 = Integer.MIN_VALUE;
                                i21 = Integer.MAX_VALUE;
                            }
                            iH = h(i38, s, i20, i21, i39, i4, d10);
                        } else {
                            iH = 0;
                        }
                        if (z) {
                            if (!du7Var3.f16082a) {
                                System.err.printf("Pass 1\n", new Object[0]);
                            }
                            try {
                                if (str != null) {
                                    fileCreateTempFile = new File(str);
                                } else {
                                    fileCreateTempFile = File.createTempFile("ssrc_", ".tmp");
                                }
                                File file3 = fileCreateTempFile;
                                FileOutputStream fileOutputStream6 = new FileOutputStream(file3);
                                if (z2) {
                                    if (i33 < i38) {
                                        fileOutputStream2 = fileOutputStream6;
                                        i9 = i5;
                                        d8 = 10.0d;
                                        i8 = iH;
                                        str6 = str10;
                                        file = file3;
                                        str3 = str2;
                                        double dO = o(fileInputStream, fileOutputStream6, s, i35, 8, i33, i38, 1.0d, (i6 / i35) / s, z, i39);
                                        i10 = 0;
                                        dArr[0] = dO;
                                    } else {
                                        str6 = str10;
                                        fileOutputStream2 = fileOutputStream6;
                                        file = file3;
                                        i8 = iH;
                                        i9 = i5;
                                        str3 = r9;
                                        d8 = 10.0d;
                                        if (i33 > i38) {
                                            i10 = 0;
                                            dArr[0] = d(fileInputStream, fileOutputStream2, s, i35, 8, i33, i38, 1.0d, (i6 / i35) / s, z, i39);
                                        } else {
                                            i10 = 0;
                                            dArr[0] = j(fileInputStream, fileOutputStream2, s, i35, 8, 1.0d, (i6 / i35) / s, z, i39);
                                        }
                                    }
                                    d3 = d8;
                                    d2 = d11;
                                } else {
                                    str6 = str10;
                                    fileOutputStream2 = fileOutputStream6;
                                    file = file3;
                                    i8 = iH;
                                    i9 = i5;
                                    str3 = r9;
                                    if (i33 < i38) {
                                        double d12 = d11;
                                        d2 = d12;
                                        i10 = 0;
                                        dArr[0] = o(fileInputStream, fileOutputStream2, s, i35, 8, i33, i38, Math.pow(10.0d, (-d12) / 20.0d), (i6 / i35) / s, z, i39);
                                    } else {
                                        d2 = d11;
                                        if (i33 > i38) {
                                            i10 = 0;
                                            dArr[0] = d(fileInputStream, fileOutputStream2, s, i35, 8, i33, i38, Math.pow(10.0d, (-d2) / 20.0d), (i6 / i35) / s, z, i39);
                                        } else {
                                            d3 = 10.0d;
                                            i10 = 0;
                                            dArr[0] = j(fileInputStream, fileOutputStream2, s, i35, 8, Math.pow(10.0d, (-d2) / 20.0d), (i6 / i35) / s, z, i39);
                                        }
                                    }
                                    d3 = 10.0d;
                                }
                                fileOutputStream2.close();
                                double d13 = d3;
                                if (!this.f16082a) {
                                    PrintStream printStream = System.err;
                                    Object[] objArr = new Object[1];
                                    objArr[i10] = Double.valueOf(Math.log10(dArr[i10]) * 20.0d);
                                    printStream.printf("\npeak : %gdB\n", objArr);
                                }
                                if (z2 || dArr[i10] >= Math.pow(d13, (-d2) / 20.0d)) {
                                    d4 = 1.0d;
                                    dArr[i10] = dArr[i10] * Math.pow(d13, d2 / 20.0d);
                                } else {
                                    d4 = 1.0d;
                                    dArr[i10] = 1.0d;
                                }
                                if (!this.f16082a) {
                                    System.err.printf("\nPass 2\n", new Object[i10]);
                                }
                                if (i39 != 0) {
                                    i11 = i9;
                                    if (i11 != 1) {
                                        i13 = 2;
                                        if (i11 != 2) {
                                            i12 = 3;
                                            if (i11 == 3) {
                                                if (z2) {
                                                    i19 = i8;
                                                    c4 = 0;
                                                } else {
                                                    c4 = 0;
                                                    double d14 = dArr[0];
                                                    i19 = i8;
                                                    if (d14 < ((double) (8388607 - i19)) / 8388607.0d) {
                                                        d9 = (d4 / d14) * 8388607.0d;
                                                    }
                                                }
                                                d7 = (d4 / dArr[c4]) * ((double) (8388607 - i19));
                                                d9 = d7;
                                            }
                                        } else {
                                            int i40 = i8;
                                            i12 = 3;
                                            if (z2) {
                                                c3 = 0;
                                            } else {
                                                double d15 = dArr[0];
                                                if (d15 >= ((double) (32767 - i40)) / 32767.0d) {
                                                    c3 = 0;
                                                } else {
                                                    d9 = (d4 / d15) * 32767.0d;
                                                }
                                            }
                                            d6 = (d4 / dArr[c3]) * ((double) (32767 - i40));
                                            d9 = d6;
                                        }
                                    } else {
                                        int i41 = i8;
                                        char c5 = 0;
                                        i12 = 3;
                                        i13 = 2;
                                        if (!z2) {
                                            double d16 = dArr[0];
                                            if (d16 >= ((double) (127 - i41)) / 127.0d) {
                                                c5 = 0;
                                            } else {
                                                d7 = (d4 / d16) * 127.0d;
                                                d9 = d7;
                                            }
                                        }
                                        d6 = (d4 / dArr[c5]) * ((double) (127 - i41));
                                        d9 = d6;
                                    }
                                } else {
                                    i11 = i9;
                                    i12 = 3;
                                    i13 = 2;
                                    if (i11 == 1) {
                                        i14 = 0;
                                        d9 = (d4 / dArr[0]) * 127.0d;
                                    } else if (i11 == 2) {
                                        i14 = 0;
                                        d9 = (d4 / dArr[0]) * 32767.0d;
                                    } else if (i11 == 3) {
                                        i14 = 0;
                                        d9 = (d4 / dArr[0]) * 8388607.0d;
                                    }
                                    this.f = i14;
                                    l();
                                    length = (int) (file.length() / 8);
                                    file2 = file;
                                    channel = new FileInputStream(file2).getChannel();
                                    byteBufferAllocate = ByteBuffer.allocate(8);
                                    i15 = 0;
                                    i16 = 0;
                                    while (i15 < length) {
                                        byteBufferAllocate.clear();
                                        channel.read(byteBufferAllocate);
                                        byteBufferAllocate.flip();
                                        d5 = byteBufferAllocate.getDouble() * d9;
                                        i17 = i15 + 1;
                                        if (i11 != 1) {
                                            if (i11 != i13) {
                                                i17 = i17;
                                                byteBufferAllocate = byteBufferAllocate;
                                                FileOutputStream fileOutputStream7 = fileOutputStream5;
                                                if (i39 != 0) {
                                                    iA2 = c(d5, dArr, i39, i16);
                                                } else {
                                                    iA2 = a(d5);
                                                }
                                                ByteBuffer byteBufferOrder3 = ByteBuffer.allocate(i13).order(ByteOrder.LITTLE_ENDIAN);
                                                byteBufferOrder3.putShort((short) iA2);
                                                byteBufferOrder3.flip();
                                                fileOutputStream4 = fileOutputStream7;
                                                writeBuffers(fileOutputStream4, byteBufferOrder3);
                                            } else if (i11 != i12) {
                                                i17 = i17;
                                                byteBuffer = byteBufferAllocate;
                                                fileOutputStream3 = fileOutputStream5;
                                            } else {
                                                if (i39 != 0) {
                                                    iA3 = c(d5, dArr, i39, i16);
                                                } else {
                                                    iA3 = a(d5);
                                                }
                                                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i12);
                                                byteBufferAllocate2.put((byte) (iA3 & 255));
                                                int i42 = iA3 >> 8;
                                                byteBufferAllocate2.put((byte) (i42 & 255));
                                                byteBufferAllocate2.put((byte) ((i42 >> 8) & 255));
                                                byteBufferAllocate2.flip();
                                                fileOutputStream4 = fileOutputStream5;
                                                writeBuffers(fileOutputStream4, byteBufferAllocate2);
                                            }
                                            byteBuffer = byteBufferAllocate;
                                            fileOutputStream3 = fileOutputStream4;
                                        } else {
                                            i17 = i17;
                                            byteBuffer = byteBufferAllocate;
                                            fileOutputStream3 = fileOutputStream5;
                                            if (i39 != 0) {
                                                iA = c(d5, dArr, i39, i16);
                                            } else {
                                                iA = a(d5);
                                            }
                                            ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(1);
                                            byteBufferAllocate3.put((byte) (iA + 128));
                                            byteBufferAllocate3.flip();
                                            writeBuffers(fileOutputStream3, byteBufferAllocate3);
                                        }
                                        i18 = i16 + 1;
                                        if (i18 == s) {
                                            i16 = 0;
                                        } else {
                                            i16 = i18;
                                        }
                                        if ((262143 & i17) == 0) {
                                            m(((double) i17) / ((double) length));
                                        }
                                        byteBufferAllocate = byteBuffer;
                                        i15 = i17;
                                        fileOutputStream5 = fileOutputStream3;
                                        d4 = 1.0d;
                                    }
                                    double d17 = d4;
                                    FileOutputStream fileOutputStream8 = fileOutputStream5;
                                    m(d17);
                                    if (this.f16082a) {
                                        c2 = 0;
                                    } else {
                                        c2 = 0;
                                        System.err.printf(str6, new Object[0]);
                                    }
                                    channel.close();
                                    if (!file2.delete()) {
                                        PrintStream printStream2 = System.err;
                                        Object[] objArr2 = new Object[1];
                                        objArr2[c2] = file2;
                                        printStream2.printf("Failed to remove %s\n", objArr2);
                                    }
                                    d = d17;
                                    fileOutputStream = fileOutputStream8;
                                    du7Var = this;
                                    i7 = 0;
                                }
                                i14 = 0;
                                this.f = i14;
                                l();
                                length = (int) (file.length() / 8);
                                file2 = file;
                                channel = new FileInputStream(file2).getChannel();
                                byteBufferAllocate = ByteBuffer.allocate(8);
                                i15 = 0;
                                i16 = 0;
                                while (i15 < length) {
                                    byteBufferAllocate.clear();
                                    channel.read(byteBufferAllocate);
                                    byteBufferAllocate.flip();
                                    d5 = byteBufferAllocate.getDouble() * d9;
                                    i17 = i15 + 1;
                                    if (i11 != 1) {
                                        if (i11 != i13) {
                                            i17 = i17;
                                            byteBufferAllocate = byteBufferAllocate;
                                            FileOutputStream fileOutputStream9 = fileOutputStream5;
                                            if (i39 != 0) {
                                                iA2 = c(d5, dArr, i39, i16);
                                            } else {
                                                iA2 = a(d5);
                                            }
                                            ByteBuffer byteBufferOrder4 = ByteBuffer.allocate(i13).order(ByteOrder.LITTLE_ENDIAN);
                                            byteBufferOrder4.putShort((short) iA2);
                                            byteBufferOrder4.flip();
                                            fileOutputStream4 = fileOutputStream9;
                                            writeBuffers(fileOutputStream4, byteBufferOrder4);
                                        } else if (i11 != i12) {
                                            i17 = i17;
                                            byteBuffer = byteBufferAllocate;
                                            fileOutputStream3 = fileOutputStream5;
                                        } else {
                                            if (i39 != 0) {
                                                iA3 = c(d5, dArr, i39, i16);
                                            } else {
                                                iA3 = a(d5);
                                            }
                                            ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(i12);
                                            byteBufferAllocate4.put((byte) (iA3 & 255));
                                            int i43 = iA3 >> 8;
                                            byteBufferAllocate4.put((byte) (i43 & 255));
                                            byteBufferAllocate4.put((byte) ((i43 >> 8) & 255));
                                            byteBufferAllocate4.flip();
                                            fileOutputStream4 = fileOutputStream5;
                                            writeBuffers(fileOutputStream4, byteBufferAllocate4);
                                        }
                                        byteBuffer = byteBufferAllocate;
                                        fileOutputStream3 = fileOutputStream4;
                                    } else {
                                        i17 = i17;
                                        byteBuffer = byteBufferAllocate;
                                        fileOutputStream3 = fileOutputStream5;
                                        if (i39 != 0) {
                                            iA = c(d5, dArr, i39, i16);
                                        } else {
                                            iA = a(d5);
                                        }
                                        ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(1);
                                        byteBufferAllocate5.put((byte) (iA + 128));
                                        byteBufferAllocate5.flip();
                                        writeBuffers(fileOutputStream3, byteBufferAllocate5);
                                    }
                                    i18 = i16 + 1;
                                    if (i18 == s) {
                                        i16 = 0;
                                    } else {
                                        i16 = i18;
                                    }
                                    if ((262143 & i17) == 0) {
                                        m(((double) i17) / ((double) length));
                                    }
                                    byteBufferAllocate = byteBuffer;
                                    i15 = i17;
                                    fileOutputStream5 = fileOutputStream3;
                                    d4 = 1.0d;
                                }
                                double d18 = d4;
                                FileOutputStream fileOutputStream10 = fileOutputStream5;
                                m(d18);
                                if (this.f16082a) {
                                    c2 = 0;
                                    System.err.printf(str6, new Object[0]);
                                } else {
                                    c2 = 0;
                                }
                                channel.close();
                                if (!file2.delete()) {
                                    PrintStream printStream3 = System.err;
                                    Object[] objArr3 = new Object[1];
                                    objArr3[c2] = file2;
                                    printStream3.printf("Failed to remove %s\n", objArr3);
                                }
                                d = d18;
                                fileOutputStream = fileOutputStream10;
                                du7Var = this;
                                i7 = 0;
                            } catch (IOException unused4) {
                                throw new IllegalStateException("cannot open temporary file.");
                            }
                        } else {
                            du7 du7Var4 = du7Var3;
                            int i44 = i5;
                            double d19 = d11;
                            str3 = r9;
                            String str11 = str10;
                            if (i33 < i38) {
                                d = 1.0d;
                                fileOutputStream = fileOutputStream5;
                                str5 = str11;
                                du7Var2 = du7Var4;
                                double dO2 = o(fileInputStream, fileOutputStream5, s, i35, i44, i33, i38, Math.pow(10.0d, (-d19) / 20.0d), (i6 / i35) / s, z, i39);
                                i7 = 0;
                                dArr[0] = dO2;
                            } else {
                                d = 1.0d;
                                fileOutputStream = fileOutputStream5;
                                if (i33 > i38) {
                                    str5 = str11;
                                    du7Var2 = du7Var4;
                                    double d20 = d(fileInputStream, fileOutputStream, s, i35, i44, i33, i38, Math.pow(10.0d, (-d19) / 20.0d), (i6 / i35) / s, z, i39);
                                    i7 = 0;
                                    dArr[0] = d20;
                                } else {
                                    du7Var = du7Var4;
                                    str4 = str11;
                                    i7 = 0;
                                    dArr[0] = j(fileInputStream, fileOutputStream, s, i35, i44, Math.pow(10.0d, (-d19) / 20.0d), (i6 / i35) / s, z, i39);
                                }
                                if (!du7Var.f16082a) {
                                    System.err.printf(str4, new Object[i7]);
                                }
                            }
                            str4 = str5;
                            du7Var = du7Var2;
                            if (!du7Var.f16082a) {
                                System.err.printf(str4, new Object[i7]);
                            }
                        }
                        if (i39 != 0) {
                            du7Var.k(s);
                        }
                        if (!z) {
                            double d21 = dArr[i7];
                            if (d21 > d && !du7Var.f16082a) {
                                PrintStream printStream4 = System.err;
                                Object[] objArr4 = new Object[1];
                                objArr4[i7] = Double.valueOf(Math.log10(d21) * 20.0d);
                                printStream4.printf("clipping detected : %gdB\n", objArr4);
                            }
                        }
                        fileOutputStream.close();
                        File file4 = new File(str3);
                        int length2 = (int) file4.length();
                        FileChannel channel2 = new RandomAccessFile(file4, "rw").getChannel();
                        ByteBuffer byteBufferOrder5 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferOrder5.position(0);
                        byteBufferOrder5.limit(4);
                        byteBufferOrder5.putInt(length2 - 8);
                        byteBufferOrder5.flip();
                        channel2.write(byteBufferOrder5, 4L);
                        byteBufferOrder5.position(0);
                        byteBufferOrder5.limit(4);
                        byteBufferOrder5.putInt(length2 - 44);
                        byteBufferOrder5.flip();
                        channel2.write(byteBufferOrder5, 40L);
                        channel2.close();
                        return;
                    } catch (IOException unused5) {
                        throw new IllegalArgumentException("cannot open output file.");
                    }
                }
                throw new IllegalStateException("Error: Only PCM is supported.");
            } catch (IOException unused6) {
                throw new IllegalArgumentException("cannot open input file.");
            }
        }
        p();
        throw new IllegalStateException("too few arguments");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006c A[PHI: r5
      0x006c: PHI (r5v1 int) = (r5v0 int), (r5v13 int) binds: [B:18:0x005f, B:22:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x022c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0237  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: No SSA var for result arg: (r2 I:??) from 0x0071: PHI (r2 I:??) = (r28v0 int A[IMMUTABLE_TYPE, METHOD_ARGUMENT]), (r2v27 int) binds: [B:25:0x006e, B:26:0x0070] A[DONT_GENERATE, DONT_INLINE, REMOVE]
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:100)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:353)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:284)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:82)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public du7(java.io.InputStream r25, java.io.OutputStream r26, int r27, int r28, int r29, int r30, int r31, int r32, double r33, int r35, boolean r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zj.adlib.du7.<init>(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, int, double, int, boolean):void");
    }
}
