package com.ipd.dsp.internal.q;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import com.alibaba.baichuan.log.TLogConstant;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.Dsp;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class u {
    public static final String A = "PhotometricInterpretation";
    public static final String A0 = "SensitivityType";
    public static final String A1 = "GPSLongitude";
    public static final String A2 = "ImageProcessingIFDPointer";
    public static final short A3 = 10;
    public static final short A4 = 3;
    public static final int A5 = 1;
    public static final int A6 = 10;
    public static final byte A7 = -38;
    public static final String B = "Orientation";
    public static final String B0 = "StandardOutputSensitivity";
    public static final String B1 = "GPSAltitudeRef";
    public static final int B2 = 512;
    public static final short B3 = 11;
    public static final short B4 = 4;
    public static final int B5 = 5000;
    public static final int B6 = 11;
    public static final byte B7 = -31;
    public static final String C = "SamplesPerPixel";
    public static final String C0 = "RecommendedExposureIndex";
    public static final String C1 = "GPSAltitude";
    public static final int C2 = 0;
    public static final short C3 = 12;
    public static final short C4 = 0;
    public static final int C6 = 12;
    public static final byte C7 = -2;
    public static final String D = "PlanarConfiguration";
    public static final String D0 = "ISOSpeed";
    public static final String D1 = "GPSTimeStamp";
    public static final int D2 = 1;
    public static final short D3 = 13;
    public static final short D4 = 1;
    public static final String D5 = "FUJIFILMCCD-RAW";
    public static final int D6 = 13;
    public static final byte D7 = -39;
    public static final String E = "YCbCrSubSampling";
    public static final String E0 = "ISOSpeedLatitudeyyy";
    public static final String E1 = "GPSSatellites";
    public static final int E2 = 2;
    public static final short E3 = 14;
    public static final short E4 = 2;
    public static final int E5 = 84;
    public static final int E6 = 8192;
    public static final int E7 = 0;
    public static final String F = "YCbCrPositioning";
    public static final String F0 = "ISOSpeedLatitudezzz";
    public static final String F1 = "GPSStatus";
    public static final int F2 = 3;
    public static final short F3 = 15;
    public static final short F4 = 0;
    public static final int F7 = 1;
    public static final String G = "XResolution";
    public static final String G0 = "ShutterSpeedValue";
    public static final String G1 = "GPSMeasureMode";
    public static final int G2 = 4;
    public static final short G3 = 16;
    public static final short G4 = 0;
    public static final int G7 = 2;
    public static final String H = "YResolution";
    public static final String H0 = "ApertureValue";
    public static final String H1 = "GPSDOP";
    public static final int H2 = 5;
    public static final short H3 = 17;
    public static final short H4 = 0;
    public static final int H7 = 3;
    public static final String I = "ResolutionUnit";
    public static final String I0 = "BrightnessValue";
    public static final String I1 = "GPSSpeedRef";
    public static final int I2 = 6;
    public static final short I3 = 18;
    public static final short I4 = 0;
    public static final short I5 = 20306;
    public static final f[] I6;
    public static final int I7 = 4;
    public static final String J = "StripOffsets";
    public static final String J0 = "ExposureBiasValue";
    public static final String J1 = "GPSSpeed";
    public static final int J2 = 7;
    public static final short J3 = 19;
    public static final short J4 = 1;
    public static final short J5 = 21330;
    public static final f[] J6;
    public static final int J7 = 5;
    public static final String K = "RowsPerStrip";
    public static final String K0 = "MaxApertureValue";
    public static final String K1 = "GPSTrackRef";
    public static final int K2 = 8;
    public static final short K3 = 20;
    public static final short K4 = 2;
    public static final f[] K6;
    public static final int K7 = 6;
    public static final String L = "StripByteCounts";
    public static final String L0 = "SubjectDistance";
    public static final String L1 = "GPSTrack";
    public static final short L3 = 21;
    public static final short L4 = 0;
    public static final f[] L6;
    public static final int L7 = 7;
    public static final String M = "JPEGInterchangeFormat";
    public static final String M0 = "MeteringMode";
    public static final String M1 = "GPSImgDirectionRef";
    public static final short M3 = 22;
    public static final short M4 = 1;
    public static final int M5 = 8;
    public static final f[] M6;
    public static final int M7 = 8;
    public static final String N = "JPEGInterchangeFormatLength";
    public static final String N0 = "LightSource";
    public static final String N1 = "GPSImgDirection";
    public static final short N2 = 1;
    public static final short N3 = 23;
    public static final short N4 = 2;
    public static final int N5 = 12;
    public static final f N6;
    public static final int N7 = 9;
    public static final String O = "TransferFunction";
    public static final String O0 = "Flash";
    public static final String O1 = "GPSMapDatum";
    public static final short O2 = 2;
    public static final short O3 = 24;
    public static final short O4 = 3;
    public static final short O5 = 85;
    public static final f[] O6;
    public static final int O7 = 10;
    public static final String P = "WhitePoint";
    public static final String P0 = "SubjectArea";
    public static final String P1 = "GPSDestLatitudeRef";
    public static final short P2 = 1;
    public static final short P3 = 255;
    public static final String P4 = "N";
    public static final String P5 = "PENTAX";
    public static final f[] P6;
    public static final int P7 = 11;
    public static final String Q = "PrimaryChromaticities";
    public static final String Q0 = "FocalLength";
    public static final String Q1 = "GPSDestLatitude";
    public static final short Q2 = 2;
    public static final short Q3 = 1;
    public static final String Q4 = "S";
    public static final int Q5 = 6;
    public static final f[] Q6;
    public static final int Q7 = 12;
    public static final String R = "YCbCrCoefficients";
    public static final String R0 = "FlashEnergy";
    public static final String R1 = "GPSDestLongitudeRef";
    public static final short R2 = 2;
    public static final short R3 = 4;
    public static final String R4 = "E";
    public static final f[] R6;
    public static final int R7 = 13;
    public static final String S = "ReferenceBlackWhite";
    public static final String S0 = "SpatialFrequencyResponse";
    public static final String S1 = "GPSDestLongitude";
    public static final short S2 = 3;
    public static final short S3 = 6;
    public static final String S4 = "W";
    public static final int S6 = 0;
    public static final int S7 = 14;
    public static final String T = "DateTime";
    public static final String T0 = "FocalPlaneXResolution";
    public static final String T1 = "GPSDestBearingRef";
    public static final int T2 = 1;
    public static final short T3 = 8;
    public static final short T4 = 0;
    public static final int T6 = 1;
    public static final Pattern T7;
    public static final String U = "ImageDescription";
    public static final String U0 = "FocalPlaneYResolution";
    public static final String U1 = "GPSDestBearing";
    public static final int U2 = 65535;
    public static final short U3 = 16;
    public static final short U4 = 1;
    public static final int U6 = 2;
    public static final Pattern U7;
    public static final String V = "Make";
    public static final String V0 = "FocalPlaneResolutionUnit";
    public static final String V1 = "GPSDestDistanceRef";
    public static final short V2 = 0;
    public static final short V3 = 24;
    public static final String V4 = "A";
    public static final int V5 = 4;
    public static final int V6 = 3;
    public static final Pattern V7;
    public static final String W = "Model";
    public static final String W0 = "SubjectLocation";
    public static final String W1 = "GPSDestDistance";
    public static final short W2 = 1;
    public static final short W3 = 32;
    public static final String W4 = "V";
    public static final int W5 = 4;
    public static final int W6 = 4;
    public static final Pattern W7;
    public static final String X = "Software";
    public static final String X0 = "ExposureIndex";
    public static final String X1 = "GPSProcessingMethod";
    public static final short X2 = 2;
    public static final short X3 = 64;
    public static final String X4 = "2";
    public static final int X6 = 5;
    public static final int X7 = 19;
    public static final String Y = "Artist";
    public static final String Y0 = "SensingMethod";
    public static final String Y1 = "GPSAreaInformation";
    public static final short Y2 = 3;
    public static final short Y3 = 1;
    public static final String Y4 = "3";
    public static final int Y6 = 6;
    public static final String Z = "Copyright";
    public static final String Z0 = "FileSource";
    public static final String Z1 = "GPSDateStamp";
    public static final short Z2 = 4;
    public static final short Z3 = 2;
    public static final String Z4 = "K";
    public static final int Z5 = 4;
    public static final int Z6 = 7;
    public static final String a0 = "ExifVersion";
    public static final String a1 = "SceneType";
    public static final String a2 = "GPSDifferential";
    public static final short a3 = 5;
    public static final short a4 = 3;
    public static final String a5 = "M";
    public static final int a7 = 8;
    public static final String b0 = "FlashpixVersion";
    public static final String b1 = "CFAPattern";
    public static final String b2 = "GPSHPositioningError";
    public static final short b3 = 6;
    public static final short b4 = 4;
    public static final String b5 = "N";
    public static final int b7 = 9;
    public static final String c0 = "ColorSpace";
    public static final String c1 = "CustomRendered";
    public static final String c2 = "InteroperabilityIndex";
    public static final short c3 = 7;
    public static final short c4 = 5;
    public static final String c5 = "T";
    public static final byte c6 = 47;
    public static final f[][] c7;
    public static final String d0 = "Gamma";
    public static final String d1 = "ExposureMode";
    public static final String d2 = "ThumbnailImageLength";
    public static final short d3 = 8;
    public static final short d4 = 7;
    public static final String d5 = "M";
    public static final f[] d7;
    public static final String e0 = "PixelXDimension";
    public static final String e1 = "WhiteBalance";
    public static final String e2 = "ThumbnailImageWidth";
    public static final short e3 = 0;
    public static final short e4 = 8;
    public static final String e5 = "K";
    public static final HashMap<Integer, f>[] e7;
    public static final String f0 = "PixelYDimension";
    public static final String f1 = "DigitalZoomRatio";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f2 = "ThumbnailOrientation";
    public static final short f3 = 1;
    public static final short f4 = 0;
    public static final String f5 = "M";
    public static final HashMap<String, f>[] f7;
    public static final String g0 = "ComponentsConfiguration";
    public static final String g1 = "FocalLengthIn35mmFilm";
    public static final String g2 = "DNGVersion";
    public static final short g3 = 2;
    public static final short g4 = 1;
    public static final String g5 = "N";
    public static final HashSet<String> g7;
    public static final String h0 = "CompressedBitsPerPixel";
    public static final String h1 = "SceneCaptureType";
    public static final String h2 = "DefaultCropSize";
    public static final short h3 = 3;
    public static final short h4 = 2;
    public static final short h5 = 0;
    public static final HashMap<Integer, Integer> h7;
    public static final String i0 = "MakerNote";
    public static final String i1 = "GainControl";
    public static final String i2 = "ThumbnailImage";
    public static final short i3 = 4;
    public static final short i4 = 3;
    public static final short i5 = 1;
    public static final int i6 = 10;
    public static final Charset i7;
    public static final String j0 = "UserComment";
    public static final String j1 = "Contrast";
    public static final String j2 = "PreviewImageStart";
    public static final short j3 = 5;
    public static final short j4 = 1;
    public static final int j5 = 1;
    public static final int j6 = 4;
    public static final byte[] j7;
    public static final String k0 = "RelatedSoundFile";
    public static final String k1 = "Saturation";
    public static final String k2 = "PreviewImageLength";
    public static final short k3 = 6;
    public static final short k4 = 0;
    public static final int k5 = 2;
    public static final int k6 = 4;
    public static final byte[] k7;
    public static final String l0 = "DateTimeOriginal";
    public static final String l1 = "Sharpness";
    public static final String l2 = "AspectFrame";
    public static final short l3 = 7;
    public static final short l4 = 1;
    public static final int l5 = 6;
    public static SimpleDateFormat l6 = null;
    public static final byte l7 = -1;
    public static final String m0 = "DateTimeDigitized";
    public static final String m1 = "DeviceSettingDescription";
    public static final String m2 = "SensorBottomBorder";
    public static final short m3 = 0;
    public static final short m4 = 0;
    public static final int m5 = 7;
    public static SimpleDateFormat m6 = null;
    public static final String n0 = "OffsetTime";
    public static final String n1 = "SubjectDistanceRange";
    public static final String n2 = "SensorLeftBorder";
    public static final short n3 = 1;
    public static final short n4 = 1;
    public static final int n5 = 8;
    public static final short n6 = 18761;
    public static final byte n7 = -64;
    public static final String o0 = "OffsetTimeOriginal";
    public static final String o1 = "ImageUniqueID";
    public static final String o2 = "SensorRightBorder";
    public static final short o3 = 2;
    public static final short o4 = 2;
    public static final int o5 = 32773;
    public static final short o6 = 19789;
    public static final byte o7 = -63;
    public static final String p0 = "OffsetTimeDigitized";

    @Deprecated
    public static final String p1 = "CameraOwnerName";
    public static final String p2 = "SensorTopBorder";
    public static final short p3 = 3;

    @Deprecated
    public static final int p4 = 0;
    public static final int p5 = 34892;
    public static final byte p6 = 42;
    public static final byte p7 = -62;
    public static final String q0 = "SubSecTime";
    public static final String q1 = "CameraOwnerName";
    public static final String q2 = "ISO";
    public static final short q3 = 4;

    @Deprecated
    public static final int q4 = 1;
    public static final int q6 = 8;
    public static final byte q7 = -61;
    public static final String r0 = "SubSecTimeOriginal";
    public static final String r1 = "BodySerialNumber";
    public static final String r2 = "JpgFromRaw";
    public static final short r3 = 5;
    public static final short r4 = 0;
    public static final int r6 = 1;
    public static final byte r7 = -59;
    public static final String s0 = "SubSecTimeDigitized";
    public static final String s1 = "LensSpecification";
    public static final String s2 = "Xmp";
    public static final short s3 = 6;
    public static final short s4 = 1;
    public static final int s6 = 2;
    public static final byte s7 = -58;
    public static final String t0 = "ExposureTime";
    public static final String t1 = "LensMake";
    public static final String t2 = "NewSubfileType";
    public static final short t3 = 255;
    public static final short t4 = 0;
    public static final int t5 = 0;
    public static final int t6 = 3;
    public static final byte t7 = -57;
    public static final String u0 = "FNumber";
    public static final String u1 = "LensModel";
    public static final String u2 = "SubfileType";
    public static final short u3 = 0;
    public static final short u4 = 1;
    public static final int u5 = 1;
    public static final int u6 = 4;
    public static final byte u7 = -55;
    public static final String v = "ExifInterface";
    public static final String v0 = "ExposureProgram";
    public static final String v1 = "LensSerialNumber";
    public static final String v2 = "ExifIFDPointer";
    public static final short v3 = 1;
    public static final short v4 = 2;
    public static final int v5 = 2;
    public static final int v6 = 5;
    public static final byte v7 = -54;
    public static final String w = "ImageWidth";
    public static final String w0 = "SpectralSensitivity";
    public static final String w1 = "GPSVersionID";
    public static final String w2 = "GPSInfoIFDPointer";
    public static final short w3 = 2;
    public static final short w4 = 3;
    public static final int w5 = 6;
    public static final int w6 = 6;
    public static final byte w7 = -53;
    public static final String x = "ImageLength";

    @Deprecated
    public static final String x0 = "ISOSpeedRatings";
    public static final String x1 = "GPSLatitudeRef";
    public static final String x2 = "InteroperabilityIFDPointer";
    public static final short x3 = 3;
    public static final short x4 = 0;
    public static final int x5 = 0;
    public static final int x6 = 7;
    public static final byte x7 = -51;
    public static final String y = "BitsPerSample";
    public static final String y0 = "PhotographicSensitivity";
    public static final String y1 = "GPSLatitude";
    public static final String y2 = "SubIFDPointer";
    public static final short y3 = 4;
    public static final short y4 = 1;
    public static final int y5 = 1;
    public static final int y6 = 8;
    public static final byte y7 = -50;
    public static final String z = "Compression";
    public static final String z0 = "OECF";
    public static final String z1 = "GPSLongitudeRef";
    public static final String z2 = "CameraSettingsIFDPointer";
    public static final short z3 = 9;
    public static final short z4 = 2;
    public static final int z5 = 0;
    public static final int z6 = 9;
    public static final byte z7 = -49;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38515a;
    public FileDescriptor b;
    public AssetManager.AssetInputStream c;
    public int d;
    public boolean e;
    public final HashMap<String, d>[] f;
    public Set<Integer> g;
    public ByteOrder h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public byte[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public static final List<Integer> L2 = Arrays.asList(1, 6, 3, 8);
    public static final List<Integer> M2 = Arrays.asList(2, 7, 4, 5);
    public static final int[] q5 = {8, 8, 8};
    public static final int[] r5 = {4};
    public static final int[] s5 = {8};
    public static final byte m7 = -40;
    public static final byte[] C5 = {-1, m7, -1};
    public static final byte[] F5 = {102, 116, 121, 112};
    public static final byte[] G5 = {109, 105, 102, com.alibaba.ariver.resource.parser.a.e.j};
    public static final byte[] H5 = {104, 101, 105, 99};
    public static final byte[] K5 = {79, 76, 89, 77, 80, 0};
    public static final byte[] L5 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] R5 = {-119, 80, 78, 71, 13, 10, com.google.common.base.a.D, 10};
    public static final byte[] S5 = {101, 88, 73, 102};
    public static final byte[] T5 = {73, 72, 68, 82};
    public static final byte[] U5 = {73, 69, 78, 68};
    public static final byte[] X5 = {82, 73, 70, 70};
    public static final byte[] Y5 = {87, 69, 66, 80};
    public static final byte[] a6 = {69, 88, 73, 70};
    public static final byte[] b6 = {-99, 1, 42};
    public static final byte[] d6 = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] e6 = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] f6 = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] g6 = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] h6 = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] F6 = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] G6 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] H6 = {65, 83, 67, 73, 73, 0, 0, 0};

    public class a extends MediaDataSource {
        public long f;
        public final /* synthetic */ i g;

        public a(i iVar) {
            this.g = iVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.f;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + ((long) this.g.available())) {
                        return -1;
                    }
                    this.g.a(j);
                    this.f = j;
                }
                if (i2 > this.g.available()) {
                    i2 = this.g.available();
                }
                int i3 = this.g.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.f += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.f = -1L;
            return -1;
        }
    }

    public static class b extends InputStream implements DataInput {
        public static final ByteOrder j = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder k = ByteOrder.BIG_ENDIAN;
        public final DataInputStream f;
        public ByteOrder g;
        public int h;
        public byte[] i;

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public void a(ByteOrder byteOrder) {
            this.g = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f.available();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.h++;
            return this.f.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.h++;
            return this.f.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.h++;
            int i = this.f.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.h += 2;
            return this.f.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.h += i2;
            this.f.readFully(bArr, i, i2);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.h += 4;
            int i = this.f.read();
            int i2 = this.f.read();
            int i3 = this.f.read();
            int i4 = this.f.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == k) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.g);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.a(u.v, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.h += 8;
            int i = this.f.read();
            int i2 = this.f.read();
            int i3 = this.f.read();
            int i4 = this.f.read();
            int i5 = this.f.read();
            int i6 = this.f.read();
            int i7 = this.f.read();
            int i8 = this.f.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
            }
            if (byteOrder == k) {
                return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
            }
            throw new IOException("Invalid byte order: " + this.g);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.h += 2;
            int i = this.f.read();
            int i2 = this.f.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == k) {
                return (short) ((i << 8) + i2);
            }
            throw new IOException("Invalid byte order: " + this.g);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.h += 2;
            return this.f.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.h++;
            return this.f.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.h += 2;
            int i = this.f.read();
            int i2 = this.f.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (i2 << 8) + i;
            }
            if (byteOrder == k) {
                return (i << 8) + i2;
            }
            throw new IOException("Invalid byte order: " + this.g);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.h;
        }

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f = dataInputStream;
            dataInputStream.mark(0);
            this.h = 0;
            this.g = byteOrder;
        }

        public void a(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int iSkip = (int) this.f.skip(i3);
                if (iSkip <= 0) {
                    if (this.i == null) {
                        this.i = new byte[8192];
                    }
                    iSkip = this.f.read(this.i, 0, Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += iSkip;
            }
            this.h += i2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f.read(bArr, i, i2);
            this.h += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.h += bArr.length;
            this.f.readFully(bArr);
        }
    }

    public static class c extends FilterOutputStream {
        public final OutputStream f;
        public ByteOrder g;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f = outputStream;
            this.g = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.g = byteOrder;
        }

        public void b(int i) throws IOException {
            ByteOrder byteOrder = this.g;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f.write(i & 255);
                this.f.write((i >>> 8) & 255);
                this.f.write((i >>> 16) & 255);
                this.f.write((i >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f.write((i >>> 24) & 255);
                this.f.write((i >>> 16) & 255);
                this.f.write((i >>> 8) & 255);
                this.f.write(i & 255);
            }
        }

        public void c(int i) throws IOException {
            a((short) i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f.write(bArr);
        }

        public void a(int i) throws IOException {
            this.f.write(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f.write(bArr, i, i2);
        }

        public void a(short s) throws IOException {
            ByteOrder byteOrder = this.g;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f.write(s & 255);
                this.f.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f.write((s >>> 8) & 255);
                this.f.write(s & 255);
            }
        }

        public void a(long j) throws IOException {
            b((int) j);
        }
    }

    public static class d {
        public static final long e = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38516a;
        public final int b;
        public final long c;
        public final byte[] d;

        public d(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        public static d a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d b(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new d(3, iArr.length, byteBufferWrap.array());
        }

        public String c(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD == null) {
                return null;
            }
            if (objD instanceof String) {
                return (String) objD;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objD instanceof long[]) {
                long[] jArr = (long[]) objD;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objD instanceof int[]) {
                int[] iArr = (int[]) objD;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objD instanceof double[]) {
                double[] dArr = (double[]) objD;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objD instanceof h[])) {
                return null;
            }
            h[] hVarArr = (h[]) objD;
            while (i < hVarArr.length) {
                sb.append(hVarArr[i].f38518a);
                sb.append('/');
                sb.append(hVarArr[i].b);
                i++;
                if (i != hVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:198:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public Object d(ByteOrder byteOrder) throws Throwable {
            b bVar;
            byte b;
            byte b2;
            b bVar2 = null;
            try {
                bVar = new b(this.d);
                try {
                    bVar.a(byteOrder);
                    int length = 0;
                    switch (this.f38516a) {
                        case 1:
                        case 6:
                            byte[] bArr = this.d;
                            if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                String str = new String(bArr, u.i7);
                                try {
                                    bVar.close();
                                    return str;
                                } catch (IOException e2) {
                                    if (Dsp.isDebugLogEnable()) {
                                        com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e2);
                                    }
                                    return str;
                                }
                            }
                            String str2 = new String(new char[]{(char) (b + com.alibaba.ariver.resource.parser.a.e.i)});
                            try {
                                bVar.close();
                                return str2;
                            } catch (IOException e3) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e3);
                                }
                                return str2;
                            }
                        case 2:
                        case 7:
                            if (this.b >= u.H6.length) {
                                int i = 0;
                                while (true) {
                                    byte[] bArr2 = u.H6;
                                    if (i >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (this.d[i] == bArr2[i]) {
                                        i++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < this.b && (b2 = this.d[length]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            String string = sb.toString();
                            try {
                                bVar.close();
                                return string;
                            } catch (IOException e4) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e4);
                                }
                                return string;
                            }
                        case 3:
                            int[] iArr = new int[this.b];
                            while (length < this.b) {
                                iArr[length] = bVar.readUnsignedShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                return iArr;
                            } catch (IOException e5) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e5);
                                }
                                return iArr;
                            }
                        case 4:
                            long[] jArr = new long[this.b];
                            while (length < this.b) {
                                jArr[length] = bVar.b();
                                length++;
                            }
                            try {
                                bVar.close();
                                return jArr;
                            } catch (IOException e6) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e6);
                                }
                                return jArr;
                            }
                        case 5:
                            h[] hVarArr = new h[this.b];
                            while (length < this.b) {
                                hVarArr[length] = new h(bVar.b(), bVar.b());
                                length++;
                            }
                            try {
                                bVar.close();
                                return hVarArr;
                            } catch (IOException e7) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e7);
                                }
                                return hVarArr;
                            }
                        case 8:
                            int[] iArr2 = new int[this.b];
                            while (length < this.b) {
                                iArr2[length] = bVar.readShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                return iArr2;
                            } catch (IOException e8) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e8);
                                }
                                return iArr2;
                            }
                        case 9:
                            int[] iArr3 = new int[this.b];
                            while (length < this.b) {
                                iArr3[length] = bVar.readInt();
                                length++;
                            }
                            try {
                                bVar.close();
                                return iArr3;
                            } catch (IOException e9) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e9);
                                }
                                return iArr3;
                            }
                        case 10:
                            h[] hVarArr2 = new h[this.b];
                            while (length < this.b) {
                                hVarArr2[length] = new h(bVar.readInt(), bVar.readInt());
                                length++;
                            }
                            try {
                                bVar.close();
                                return hVarArr2;
                            } catch (IOException e10) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e10);
                                }
                                return hVarArr2;
                            }
                        case 11:
                            double[] dArr = new double[this.b];
                            while (length < this.b) {
                                dArr[length] = bVar.readFloat();
                                length++;
                            }
                            try {
                                bVar.close();
                                return dArr;
                            } catch (IOException e11) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e11);
                                }
                                return dArr;
                            }
                        case 12:
                            double[] dArr2 = new double[this.b];
                            while (length < this.b) {
                                dArr2[length] = bVar.readDouble();
                                length++;
                            }
                            try {
                                bVar.close();
                                return dArr2;
                            } catch (IOException e12) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e12);
                                }
                                return dArr2;
                            }
                        default:
                            try {
                                bVar.close();
                                return null;
                            } catch (IOException e13) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e13);
                                }
                                return null;
                            }
                    }
                } catch (IOException e14) {
                    e = e14;
                    try {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.e(u.v, "IOException occurred during reading a value", e);
                        }
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e15) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e15);
                                }
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bVar2 = bVar;
                        bVar = bVar2;
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e16) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.b(u.v, "IOException occurred while closing InputStream", e16);
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        bVar.close();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                bVar = null;
            } catch (Throwable th3) {
                th = th3;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        }

        public String toString() {
            return "(" + u.F6[this.f38516a] + ", data length:" + this.d.length + ")";
        }

        public d(int i, int i2, long j, byte[] bArr) {
            this.f38516a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }

        public static d a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static d b(int i, ByteOrder byteOrder) {
            return b(new int[]{i}, byteOrder);
        }

        public static d a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putInt(i);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d b(String str) {
            byte[] bytes = (str + (char) 0).getBytes(u.i7);
            return new d(2, bytes.length, bytes);
        }

        public static d b(h[] hVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[5] * hVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (h hVar : hVarArr) {
                byteBufferWrap.putInt((int) hVar.f38518a);
                byteBufferWrap.putInt((int) hVar.b);
            }
            return new d(5, hVarArr.length, byteBufferWrap.array());
        }

        public static d a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(u.i7);
            return new d(1, bytes.length, bytes);
        }

        public static d b(h hVar, ByteOrder byteOrder) {
            return b(new h[]{hVar}, byteOrder);
        }

        public int b(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD != null) {
                if (objD instanceof String) {
                    return Integer.parseInt((String) objD);
                }
                if (objD instanceof long[]) {
                    long[] jArr = (long[]) objD;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof int[]) {
                    int[] iArr = (int[]) objD;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public static d a(h[] hVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[10] * hVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (h hVar : hVarArr) {
                byteBufferWrap.putInt((int) hVar.f38518a);
                byteBufferWrap.putInt((int) hVar.b);
            }
            return new d(10, hVarArr.length, byteBufferWrap.array());
        }

        public static d a(h hVar, ByteOrder byteOrder) {
            return a(new h[]{hVar}, byteOrder);
        }

        public static d a(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[u.G6[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d : dArr) {
                byteBufferWrap.putDouble(d);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d a(double d, ByteOrder byteOrder) {
            return a(new double[]{d}, byteOrder);
        }

        public double a(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD != null) {
                if (objD instanceof String) {
                    return Double.parseDouble((String) objD);
                }
                if (objD instanceof long[]) {
                    long[] jArr = (long[]) objD;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof int[]) {
                    int[] iArr = (int[]) objD;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof double[]) {
                    double[] dArr = (double[]) objD;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof h[]) {
                    h[] hVarArr = (h[]) objD;
                    if (hVarArr.length == 1) {
                        return hVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int a() {
            return u.G6[this.f38516a] * this.b;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface g {
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f38518a;
        public final long b;

        public h(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        public double a() {
            return this.f38518a / this.b;
        }

        public String toString() {
            return this.f38518a + WVNativeCallbackUtil.SEPERATER + this.b;
        }

        public h(long j, long j2) {
            if (j2 == 0) {
                this.f38518a = 0L;
                this.b = 1L;
            } else {
                this.f38518a = j;
                this.b = j2;
            }
        }
    }

    static {
        f[] fVarArr = {new f("NewSubfileType", 254, 4), new f("SubfileType", 255, 4), new f("ImageWidth", 256, 3, 4), new f("ImageLength", 257, 3, 4), new f("BitsPerSample", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 3), new f("Compression", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new f("PhotometricInterpretation", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 3), new f("ImageDescription", 270, 2), new f("Make", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new f("Model", 272, 2), new f("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 3, 4), new f("Orientation", 274, 3), new f("SamplesPerPixel", MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new f("RowsPerStrip", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new f("StripByteCounts", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new f("XResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new f("YResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new f("PlanarConfiguration", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new f("ResolutionUnit", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new f("TransferFunction", 301, 3), new f("Software", 305, 2), new f("DateTime", 306, 2), new f("Artist", 315, 2), new f("WhitePoint", 318, 5), new f("PrimaryChromaticities", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new f(y2, 330, 4), new f("JPEGInterchangeFormat", 513, 4), new f("JPEGInterchangeFormatLength", 514, 4), new f("YCbCrCoefficients", 529, 5), new f("YCbCrSubSampling", MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new f("YCbCrPositioning", MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new f("ReferenceBlackWhite", MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new f("Copyright", 33432, 2), new f(v2, 34665, 4), new f(w2, 34853, 4), new f("SensorTopBorder", 4, 4), new f("SensorLeftBorder", 5, 4), new f("SensorBottomBorder", 6, 4), new f("SensorRightBorder", 7, 4), new f("ISO", 23, 3), new f("JpgFromRaw", 46, 7), new f("Xmp", 700, 1)};
        I6 = fVarArr;
        f[] fVarArr2 = {new f("ExposureTime", 33434, 5), new f("FNumber", 33437, 5), new f("ExposureProgram", 34850, 3), new f("SpectralSensitivity", 34852, 2), new f("PhotographicSensitivity", 34855, 3), new f("OECF", 34856, 7), new f("SensitivityType", 34864, 3), new f("StandardOutputSensitivity", 34865, 4), new f("RecommendedExposureIndex", 34866, 4), new f("ISOSpeed", 34867, 4), new f("ISOSpeedLatitudeyyy", 34868, 4), new f("ISOSpeedLatitudezzz", 34869, 4), new f("ExifVersion", 36864, 2), new f("DateTimeOriginal", 36867, 2), new f("DateTimeDigitized", 36868, 2), new f("OffsetTime", 36880, 2), new f("OffsetTimeOriginal", 36881, 2), new f("OffsetTimeDigitized", 36882, 2), new f("ComponentsConfiguration", 37121, 7), new f("CompressedBitsPerPixel", 37122, 5), new f("ShutterSpeedValue", 37377, 10), new f("ApertureValue", 37378, 5), new f("BrightnessValue", 37379, 10), new f("ExposureBiasValue", 37380, 10), new f("MaxApertureValue", 37381, 5), new f("SubjectDistance", 37382, 5), new f("MeteringMode", 37383, 3), new f("LightSource", 37384, 3), new f("Flash", 37385, 3), new f("FocalLength", 37386, 5), new f("SubjectArea", 37396, 3), new f("MakerNote", 37500, 7), new f("UserComment", 37510, 7), new f("SubSecTime", 37520, 2), new f("SubSecTimeOriginal", 37521, 2), new f("SubSecTimeDigitized", 37522, 2), new f("FlashpixVersion", 40960, 7), new f("ColorSpace", 40961, 3), new f("PixelXDimension", 40962, 3, 4), new f("PixelYDimension", 40963, 3, 4), new f("RelatedSoundFile", 40964, 2), new f(x2, 40965, 4), new f("FlashEnergy", 41483, 5), new f("SpatialFrequencyResponse", 41484, 7), new f("FocalPlaneXResolution", 41486, 5), new f("FocalPlaneYResolution", 41487, 5), new f("FocalPlaneResolutionUnit", 41488, 3), new f("SubjectLocation", 41492, 3), new f("ExposureIndex", 41493, 5), new f("SensingMethod", 41495, 3), new f("FileSource", 41728, 7), new f("SceneType", 41729, 7), new f("CFAPattern", 41730, 7), new f("CustomRendered", 41985, 3), new f("ExposureMode", 41986, 3), new f("WhiteBalance", 41987, 3), new f("DigitalZoomRatio", 41988, 5), new f("FocalLengthIn35mmFilm", 41989, 3), new f("SceneCaptureType", 41990, 3), new f("GainControl", 41991, 3), new f("Contrast", 41992, 3), new f("Saturation", 41993, 3), new f("Sharpness", 41994, 3), new f("DeviceSettingDescription", 41995, 7), new f("SubjectDistanceRange", 41996, 3), new f("ImageUniqueID", 42016, 2), new f("CameraOwnerName", 42032, 2), new f("BodySerialNumber", 42033, 2), new f("LensSpecification", 42034, 5), new f("LensMake", 42035, 2), new f("LensModel", 42036, 2), new f("Gamma", 42240, 5), new f("DNGVersion", 50706, 1), new f("DefaultCropSize", 50720, 3, 4)};
        J6 = fVarArr2;
        f[] fVarArr3 = {new f("GPSVersionID", 0, 1), new f("GPSLatitudeRef", 1, 2), new f("GPSLatitude", 2, 5, 10), new f("GPSLongitudeRef", 3, 2), new f("GPSLongitude", 4, 5, 10), new f("GPSAltitudeRef", 5, 1), new f("GPSAltitude", 6, 5), new f("GPSTimeStamp", 7, 5), new f("GPSSatellites", 8, 2), new f("GPSStatus", 9, 2), new f("GPSMeasureMode", 10, 2), new f("GPSDOP", 11, 5), new f("GPSSpeedRef", 12, 2), new f("GPSSpeed", 13, 5), new f("GPSTrackRef", 14, 2), new f("GPSTrack", 15, 5), new f("GPSImgDirectionRef", 16, 2), new f("GPSImgDirection", 17, 5), new f("GPSMapDatum", 18, 2), new f("GPSDestLatitudeRef", 19, 2), new f("GPSDestLatitude", 20, 5), new f("GPSDestLongitudeRef", 21, 2), new f("GPSDestLongitude", 22, 5), new f("GPSDestBearingRef", 23, 2), new f("GPSDestBearing", 24, 5), new f("GPSDestDistanceRef", 25, 2), new f("GPSDestDistance", 26, 5), new f("GPSProcessingMethod", 27, 7), new f("GPSAreaInformation", 28, 7), new f("GPSDateStamp", 29, 2), new f("GPSDifferential", 30, 3), new f("GPSHPositioningError", 31, 5)};
        K6 = fVarArr3;
        f[] fVarArr4 = {new f("InteroperabilityIndex", 1, 2)};
        L6 = fVarArr4;
        f[] fVarArr5 = {new f("NewSubfileType", 254, 4), new f("SubfileType", 255, 4), new f("ThumbnailImageWidth", 256, 3, 4), new f("ThumbnailImageLength", 257, 3, 4), new f("BitsPerSample", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 3), new f("Compression", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new f("PhotometricInterpretation", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 3), new f("ImageDescription", 270, 2), new f("Make", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new f("Model", 272, 2), new f("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 3, 4), new f("ThumbnailOrientation", 274, 3), new f("SamplesPerPixel", MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new f("RowsPerStrip", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new f("StripByteCounts", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new f("XResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new f("YResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new f("PlanarConfiguration", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new f("ResolutionUnit", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new f("TransferFunction", 301, 3), new f("Software", 305, 2), new f("DateTime", 306, 2), new f("Artist", 315, 2), new f("WhitePoint", 318, 5), new f("PrimaryChromaticities", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new f(y2, 330, 4), new f("JPEGInterchangeFormat", 513, 4), new f("JPEGInterchangeFormatLength", 514, 4), new f("YCbCrCoefficients", 529, 5), new f("YCbCrSubSampling", MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new f("YCbCrPositioning", MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new f("ReferenceBlackWhite", MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new f("Copyright", 33432, 2), new f(v2, 34665, 4), new f(w2, 34853, 4), new f("DNGVersion", 50706, 1), new f("DefaultCropSize", 50720, 3, 4)};
        M6 = fVarArr5;
        N6 = new f("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 3);
        f[] fVarArr6 = {new f("ThumbnailImage", 256, 7), new f(z2, 8224, 4), new f(A2, 8256, 4)};
        O6 = fVarArr6;
        f[] fVarArr7 = {new f("PreviewImageStart", 257, 4), new f("PreviewImageLength", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 4)};
        P6 = fVarArr7;
        f[] fVarArr8 = {new f("AspectFrame", 4371, 3)};
        Q6 = fVarArr8;
        f[] fVarArr9 = {new f("ColorSpace", 55, 3)};
        R6 = fVarArr9;
        c7 = new f[][]{fVarArr, fVarArr2, fVarArr3, fVarArr4, fVarArr5, fVarArr, fVarArr6, fVarArr7, fVarArr8, fVarArr9};
        d7 = new f[]{new f(y2, 330, 4), new f(v2, 34665, 4), new f(w2, 34853, 4), new f(x2, 40965, 4), new f(z2, 8224, 1), new f(A2, 8256, 1)};
        e7 = new HashMap[10];
        f7 = new HashMap[10];
        g7 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        h7 = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        i7 = charsetForName;
        j7 = p.h.getBytes(charsetForName);
        k7 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        l6 = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        m6 = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i8 = 0;
        while (true) {
            f[][] fVarArr10 = c7;
            if (i8 >= fVarArr10.length) {
                HashMap<Integer, Integer> map = h7;
                f[] fVarArr11 = d7;
                map.put(Integer.valueOf(fVarArr11[0].f38517a), 5);
                map.put(Integer.valueOf(fVarArr11[1].f38517a), 1);
                map.put(Integer.valueOf(fVarArr11[2].f38517a), 2);
                map.put(Integer.valueOf(fVarArr11[3].f38517a), 3);
                map.put(Integer.valueOf(fVarArr11[4].f38517a), 7);
                map.put(Integer.valueOf(fVarArr11[5].f38517a), 8);
                T7 = Pattern.compile(".*[1-9].*");
                U7 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                V7 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                W7 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            e7[i8] = new HashMap<>();
            f7[i8] = new HashMap<>();
            for (f fVar : fVarArr10[i8]) {
                e7[i8].put(Integer.valueOf(fVar.f38517a), fVar);
                f7[i8].put(fVar.b, fVar);
            }
            i8++;
        }
    }

    public u(@NonNull File file) throws Throwable {
        f[][] fVarArr = c7;
        this.f = new HashMap[fVarArr.length];
        this.g = new HashSet(fVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (file == null) {
            throw new NullPointerException("file cannot be null");
        }
        g(file.getAbsolutePath());
    }

    public static boolean a(int i8) {
        return i8 == 4 || i8 == 13 || i8 == 14;
    }

    public static boolean c(int i8) {
        return (i8 == 4 || i8 == 9 || i8 == 13 || i8 == 14) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean h(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("mimeType shouldn't be null");
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        byte b8 = -1;
        switch (lowerCase.hashCode()) {
            case -1875291391:
                if (lowerCase.equals("image/x-fuji-raf")) {
                    b8 = 0;
                }
                break;
            case -1635437028:
                if (lowerCase.equals("image/x-samsung-srw")) {
                    b8 = 1;
                }
                break;
            case -1594371159:
                if (lowerCase.equals("image/x-sony-arw")) {
                    b8 = 2;
                }
                break;
            case -1487464693:
                if (lowerCase.equals("image/heic")) {
                    b8 = 3;
                }
                break;
            case -1487464690:
                if (lowerCase.equals("image/heif")) {
                    b8 = 4;
                }
                break;
            case -1487394660:
                if (lowerCase.equals("image/jpeg")) {
                    b8 = 5;
                }
                break;
            case -1487018032:
                if (lowerCase.equals("image/webp")) {
                    b8 = 6;
                }
                break;
            case -1423313290:
                if (lowerCase.equals("image/x-adobe-dng")) {
                    b8 = 7;
                }
                break;
            case -985160897:
                if (lowerCase.equals("image/x-panasonic-rw2")) {
                    b8 = 8;
                }
                break;
            case -879258763:
                if (lowerCase.equals("image/png")) {
                    b8 = 9;
                }
                break;
            case -332763809:
                if (lowerCase.equals("image/x-pentax-pef")) {
                    b8 = 10;
                }
                break;
            case 1378106698:
                if (lowerCase.equals("image/x-olympus-orf")) {
                    b8 = 11;
                }
                break;
            case 2099152104:
                if (lowerCase.equals("image/x-nikon-nef")) {
                    b8 = 12;
                }
                break;
            case 2099152524:
                if (lowerCase.equals("image/x-nikon-nrw")) {
                    b8 = 13;
                }
                break;
            case 2111234748:
                if (lowerCase.equals("image/x-canon-cr2")) {
                    b8 = com.google.common.base.a.p;
                }
                break;
        }
        switch (b8) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return true;
            default:
                return false;
        }
    }

    @Nullable
    public String a(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarD = d(str);
        if (dVarD != null) {
            if (!g7.contains(str)) {
                return dVarD.c(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i8 = dVarD.f38516a;
                if (i8 != 5 && i8 != 10) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "GPS Timestamp format is not rational. format=" + dVarD.f38516a);
                    }
                    return null;
                }
                h[] hVarArr = (h[]) dVarD.d(this.h);
                if (hVarArr == null || hVarArr.length != 3) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "Invalid GPS Timestamp array. array=" + Arrays.toString(hVarArr));
                    }
                    return null;
                }
                Locale locale = Locale.getDefault();
                h hVar = hVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (hVar.f38518a / hVar.b));
                h hVar2 = hVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (hVar2.f38518a / hVar2.b));
                h hVar3 = hVarArr[2];
                return String.format(locale, "%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (hVar3.f38518a / hVar3.b)));
            }
            try {
                return Double.toString(dVarD.a(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public void b(@NonNull String str, @Nullable String str2) {
        f fVar;
        int i8;
        int i9;
        String str3 = str;
        String strReplaceAll = str2;
        if (str3 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = V7.matcher(strReplaceAll).find();
            boolean zFind2 = W7.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(v, "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll(c49.f40900a, u15.f19942b);
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i10 = 2;
        int i11 = 1;
        if (strReplaceAll != null && g7.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = U7.matcher(strReplaceAll);
                if (!matcher.find()) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "Invalid value for " + str3 + " : " + strReplaceAll);
                        return;
                    }
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new h(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "Invalid value for " + str3 + " : " + strReplaceAll);
                        return;
                    }
                    return;
                }
            }
        }
        int i12 = 0;
        int i13 = 0;
        while (i13 < c7.length) {
            if ((i13 != 4 || this.i) && (fVar = f7[i13].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair<Integer, Integer> pairE = e(strReplaceAll);
                    int i14 = -1;
                    if (fVar.c == ((Integer) pairE.first).intValue() || fVar.c == ((Integer) pairE.second).intValue()) {
                        i8 = fVar.c;
                    } else {
                        int i15 = fVar.d;
                        if (i15 == -1 || !(i15 == ((Integer) pairE.first).intValue() || fVar.d == ((Integer) pairE.second).intValue())) {
                            int i16 = fVar.c;
                            if (i16 == i11 || i16 == 7 || i16 == i10) {
                                i8 = i16;
                            } else if (Dsp.isDebugLogEnable()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str3);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = F6;
                                sb.append(strArr[fVar.c]);
                                sb.append(fVar.d == -1 ? "" : ", " + strArr[fVar.d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairE.first).intValue()]);
                                sb.append(((Integer) pairE.second).intValue() != -1 ? ", " + strArr[((Integer) pairE.second).intValue()] : "");
                                sb.append(")");
                                com.ipd.dsp.internal.c2.k.a(v, sb.toString());
                            }
                        } else {
                            i8 = fVar.d;
                        }
                    }
                    switch (i8) {
                        case 1:
                            i9 = i11;
                            this.f[i13].put(str3, d.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            i9 = i11;
                            this.f[i13].put(str3, d.b(strReplaceAll));
                            break;
                        case 3:
                            i9 = i11;
                            String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i17 = 0; i17 < strArrSplit.length; i17++) {
                                iArr[i17] = Integer.parseInt(strArrSplit[i17]);
                            }
                            this.f[i13].put(str3, d.b(iArr, this.h));
                            break;
                        case 4:
                            i9 = i11;
                            String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i18 = 0; i18 < strArrSplit2.length; i18++) {
                                jArr[i18] = Long.parseLong(strArrSplit2[i18]);
                            }
                            this.f[i13].put(str3, d.a(jArr, this.h));
                            break;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            h[] hVarArr = new h[strArrSplit3.length];
                            int i19 = 0;
                            while (i19 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i19].split(WVNativeCallbackUtil.SEPERATER, i14);
                                hVarArr[i19] = new h((long) Double.parseDouble(strArrSplit4[0]), (long) Double.parseDouble(strArrSplit4[1]));
                                i19++;
                                i14 = -1;
                            }
                            i9 = 1;
                            this.f[i13].put(str3, d.b(hVarArr, this.h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            i9 = i11;
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Data format isn't one of expected formats: " + i8);
                            }
                            break;
                        case 9:
                            String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i20 = 0; i20 < strArrSplit5.length; i20++) {
                                iArr2[i20] = Integer.parseInt(strArrSplit5[i20]);
                            }
                            this.f[i13].put(str3, d.a(iArr2, this.h));
                            i9 = 1;
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            h[] hVarArr2 = new h[strArrSplit6.length];
                            int i21 = i12;
                            while (i21 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i21].split(WVNativeCallbackUtil.SEPERATER, -1);
                                hVarArr2[i21] = new h((long) Double.parseDouble(strArrSplit7[i12]), (long) Double.parseDouble(strArrSplit7[i11]));
                                i21++;
                                strArrSplit6 = strArrSplit6;
                                i12 = 0;
                                i11 = 1;
                            }
                            this.f[i13].put(str3, d.a(hVarArr2, this.h));
                            i9 = 1;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i22 = i12; i22 < strArrSplit8.length; i22++) {
                                dArr[i22] = Double.parseDouble(strArrSplit8[i22]);
                            }
                            this.f[i13].put(str3, d.a(dArr, this.h));
                            break;
                    }
                } else {
                    this.f[i13].remove(str3);
                }
                i9 = i11;
            } else {
                i9 = i11;
            }
            i13++;
            i11 = i9;
            i10 = 2;
            i12 = 0;
        }
    }

    public void c() {
        int i8 = 1;
        switch (a("Orientation", 1)) {
            case 1:
                i8 = 4;
                break;
            case 2:
                i8 = 3;
                break;
            case 3:
                i8 = 2;
                break;
            case 4:
                break;
            case 5:
                i8 = 8;
                break;
            case 6:
                i8 = 7;
                break;
            case 7:
                i8 = 6;
                break;
            case 8:
                i8 = 5;
                break;
            default:
                i8 = 0;
                break;
        }
        b("Orientation", Integer.toString(i8));
    }

    @Nullable
    public final d d(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i8 = 0; i8 < c7.length; i8++) {
            d dVar = this.f[i8].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long e() {
        return a(a("DateTimeDigitized"), a("SubSecTimeDigitized"), a("OffsetTimeDigitized"));
    }

    public boolean f(@NonNull String str) {
        return d(str) != null;
    }

    @Nullable
    @SuppressLint({"AutoBoxing"})
    public Long g() {
        String strA = a("GPSDateStamp");
        String strA2 = a("GPSTimeStamp");
        if (strA != null && strA2 != null) {
            Pattern pattern = T7;
            if (pattern.matcher(strA).matches() || pattern.matcher(strA2).matches()) {
                String str = strA + ' ' + strA2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date date = l6.parse(str, parsePosition);
                    if (date == null && (date = m6.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(date.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    public int i() {
        switch (a("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] j() {
        int i8 = this.o;
        if (i8 == 6 || i8 == 7) {
            return l();
        }
        return null;
    }

    @Nullable
    public Bitmap k() throws Throwable {
        if (!this.i) {
            return null;
        }
        if (this.n == null) {
            this.n = l();
        }
        int i8 = this.o;
        if (i8 == 6 || i8 == 7) {
            return BitmapFactory.decodeByteArray(this.n, 0, this.m);
        }
        if (i8 == 1) {
            int length = this.n.length / 3;
            int[] iArr = new int[length];
            for (int i9 = 0; i9 < length; i9++) {
                byte[] bArr = this.n;
                int i10 = i9 * 3;
                iArr[i9] = (bArr[i10] << com.google.common.base.a.r) + (bArr[i10 + 1] << 8) + bArr[i10 + 2];
            }
            d dVar = this.f[4].get("ThumbnailImageLength");
            d dVar2 = this.f[4].get("ThumbnailImageWidth");
            if (dVar != null && dVar2 != null) {
                return Bitmap.createBitmap(iArr, dVar2.b(this.h), dVar.b(this.h), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0069 A[Catch: all -> 0x008c, Exception -> 0x008f, TRY_ENTER, TryCatch #8 {Exception -> 0x008f, all -> 0x008c, blocks: (B:29:0x0053, B:32:0x0069, B:34:0x0075, B:39:0x0080, B:40:0x0085, B:41:0x0086, B:42:0x008b), top: B:74:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0075 A[Catch: all -> 0x008c, Exception -> 0x008f, TRY_LEAVE, TryCatch #8 {Exception -> 0x008f, all -> 0x008c, blocks: (B:29:0x0053, B:32:0x0069, B:34:0x0075, B:39:0x0080, B:40:0x0085, B:41:0x0086, B:42:0x008b), top: B:74:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080 A[Catch: all -> 0x008c, Exception -> 0x008f, TRY_ENTER, TryCatch #8 {Exception -> 0x008f, all -> 0x008c, blocks: (B:29:0x0053, B:32:0x0069, B:34:0x0075, B:39:0x0080, B:40:0x0085, B:41:0x0086, B:42:0x008b), top: B:74:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[Catch: all -> 0x008c, Exception -> 0x008f, TryCatch #8 {Exception -> 0x008f, all -> 0x008c, blocks: (B:29:0x0053, B:32:0x0069, B:34:0x0075, B:39:0x0080, B:40:0x0085, B:41:0x0086, B:42:0x008b), top: B:74:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #4 {all -> 0x00b7, blocks: (B:56:0x00a3, B:58:0x00a9), top: B:70:0x00a3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    @Nullable
    public byte[] l() throws Throwable {
        FileDescriptor fileDescriptor;
        Exception e8;
        InputStream fileInputStream;
        FileDescriptor fileDescriptor2;
        Exception e9;
        byte[] bArr;
        InputStream inputStream = null;
        inputStream = null;
        FileDescriptor fileDescriptor3 = null;
        if (!this.i) {
            return null;
        }
        byte[] bArr2 = this.n;
        if (bArr2 != null) {
            return bArr2;
        }
        try {
            fileInputStream = this.c;
            try {
                if (fileInputStream != null) {
                    try {
                        if (!fileInputStream.markSupported()) {
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Cannot read thumbnail from inputstream without mark/reset support");
                            }
                            w.a((Closeable) fileInputStream);
                            return null;
                        }
                        fileInputStream.reset();
                    } catch (Exception e10) {
                        e9 = e10;
                        fileDescriptor2 = null;
                        try {
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Encountered exception while getting thumbnail", e9);
                            }
                            w.a((Closeable) fileInputStream);
                            if (fileDescriptor2 != null) {
                                w.a(fileDescriptor2);
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = fileInputStream;
                            fileDescriptor = fileDescriptor2;
                            fileInputStream = inputStream;
                            fileDescriptor3 = fileDescriptor;
                            w.a((Closeable) fileInputStream);
                            if (fileDescriptor3 != null) {
                                w.a(fileDescriptor3);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        w.a((Closeable) fileInputStream);
                        if (fileDescriptor3 != null) {
                            w.a(fileDescriptor3);
                        }
                        throw th;
                    }
                } else {
                    if (this.f38515a == null) {
                        FileDescriptor fileDescriptorB = w.a.b(this.b);
                        try {
                            w.a.a(fileDescriptorB, 0L, OsConstants.SEEK_SET);
                            fileDescriptor = fileDescriptorB;
                            fileInputStream = new FileInputStream(fileDescriptorB);
                            if (fileInputStream.skip(this.l + this.p) == this.l + this.p) {
                                throw new IOException("Corrupted image");
                            }
                            bArr = new byte[this.m];
                            if (fileInputStream.read(bArr) == this.m) {
                                throw new IOException("Corrupted image");
                            }
                            this.n = bArr;
                            w.a((Closeable) fileInputStream);
                            if (fileDescriptor != null) {
                                w.a(fileDescriptor);
                            }
                            return bArr;
                        } catch (Exception e11) {
                            e8 = e11;
                            fileDescriptor = fileDescriptorB;
                            fileInputStream = null;
                            Exception exc = e8;
                            fileDescriptor2 = fileDescriptor;
                            e9 = exc;
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Encountered exception while getting thumbnail", e9);
                            }
                            w.a((Closeable) fileInputStream);
                            if (fileDescriptor2 != null) {
                                w.a(fileDescriptor2);
                            }
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileDescriptor = fileDescriptorB;
                            fileInputStream = inputStream;
                            fileDescriptor3 = fileDescriptor;
                            w.a((Closeable) fileInputStream);
                            if (fileDescriptor3 != null) {
                                w.a(fileDescriptor3);
                            }
                            throw th;
                        }
                    }
                    fileInputStream = new FileInputStream(this.f38515a);
                }
                if (fileInputStream.skip(this.l + this.p) == this.l + this.p) {
                    throw new IOException("Corrupted image");
                }
                bArr = new byte[this.m];
                if (fileInputStream.read(bArr) == this.m) {
                    throw new IOException("Corrupted image");
                }
                this.n = bArr;
                w.a((Closeable) fileInputStream);
                if (fileDescriptor != null) {
                    w.a(fileDescriptor);
                }
                return bArr;
            } catch (Exception e12) {
                e8 = e12;
                Exception exc2 = e8;
                fileDescriptor2 = fileDescriptor;
                e9 = exc2;
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "Encountered exception while getting thumbnail", e9);
                }
                w.a((Closeable) fileInputStream);
                if (fileDescriptor2 != null) {
                    w.a(fileDescriptor2);
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = fileInputStream;
                fileInputStream = inputStream;
                fileDescriptor3 = fileDescriptor;
                w.a((Closeable) fileInputStream);
                if (fileDescriptor3 != null) {
                    w.a(fileDescriptor3);
                }
                throw th;
            }
            fileDescriptor = null;
        } catch (Exception e13) {
            e8 = e13;
            fileInputStream = null;
            fileDescriptor = null;
        } catch (Throwable th5) {
            th = th5;
            fileDescriptor = null;
        }
    }

    @Nullable
    public long[] m() {
        if (this.t) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        if (!this.i) {
            return null;
        }
        if (!this.j || this.k) {
            return new long[]{this.l + this.p, this.m};
        }
        return null;
    }

    public boolean n() {
        return this.i;
    }

    public boolean o() {
        int iA = a("Orientation", 1);
        return iA == 2 || iA == 7 || iA == 4 || iA == 5;
    }

    public boolean p() {
        if (!this.i) {
            return false;
        }
        int i8 = this.o;
        return i8 == 6 || i8 == 7;
    }

    public final void q() {
        for (int i8 = 0; i8 < this.f.length; i8++) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "The size of tag group[" + i8 + "]: " + this.f[i8].size());
            }
            for (Map.Entry<String, d> entry : this.f[i8].entrySet()) {
                d value = entry.getValue();
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.c(this.h) + "'");
                }
            }
        }
    }

    public void r() {
        b("Orientation", Integer.toString(1));
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00e6 A[Catch: all -> 0x010f, Exception -> 0x0111, TryCatch #17 {Exception -> 0x0111, all -> 0x010f, blocks: (B:62:0x00e2, B:64:0x00e6, B:67:0x00fe, B:66:0x00ef), top: B:130:0x00e2 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00ef A[Catch: all -> 0x010f, Exception -> 0x0111, TryCatch #17 {Exception -> 0x0111, all -> 0x010f, blocks: (B:62:0x00e2, B:64:0x00e6, B:67:0x00fe, B:66:0x00ef), top: B:130:0x00e2 }] */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0140: MOVE (r1 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:86:0x0140 */
    public void s() throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream3;
        Exception e8;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4;
        if (!a(this.d)) {
            throw new IOException("ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats.");
        }
        if (this.b == null && this.f38515a == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        if (this.i && this.j && !this.k) {
            throw new IOException("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
        }
        this.t = true;
        this.n = j();
        FileInputStream fileInputStream4 = null;
        try {
            File fileCreateTempFile = File.createTempFile("temp", TLogConstant.RUBBISH_DIR);
            if (this.f38515a != null) {
                fileInputStream = new FileInputStream(this.f38515a);
            } else {
                w.a.a(this.b, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(this.b);
            }
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    w.a(fileInputStream, fileOutputStream);
                    w.a((Closeable) fileInputStream);
                    w.a((Closeable) fileOutputStream);
                    try {
                        try {
                            try {
                                FileInputStream fileInputStream5 = new FileInputStream(fileCreateTempFile);
                                try {
                                    if (this.f38515a != null) {
                                        fileOutputStream2 = new FileOutputStream(this.f38515a);
                                    } else {
                                        w.a.a(this.b, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream2 = new FileOutputStream(this.b);
                                    }
                                    try {
                                        bufferedInputStream = new BufferedInputStream(fileInputStream5);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                            try {
                                                int i8 = this.d;
                                                if (i8 == 4) {
                                                    a(bufferedInputStream, bufferedOutputStream);
                                                } else if (i8 == 13) {
                                                    b(bufferedInputStream, bufferedOutputStream);
                                                } else if (i8 == 14) {
                                                    c(bufferedInputStream, bufferedOutputStream);
                                                }
                                                w.a((Closeable) bufferedInputStream);
                                                w.a((Closeable) bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                this.n = null;
                                            } catch (Exception e9) {
                                                e = e9;
                                                fileInputStream4 = fileInputStream5;
                                                try {
                                                    fileInputStream3 = new FileInputStream(fileCreateTempFile);
                                                    try {
                                                        if (this.f38515a != null) {
                                                            fileOutputStream3 = new FileOutputStream(this.f38515a);
                                                        } else {
                                                            w.a.a(this.b, 0L, OsConstants.SEEK_SET);
                                                            fileOutputStream3 = new FileOutputStream(this.b);
                                                        }
                                                        fileOutputStream2 = fileOutputStream3;
                                                        w.a(fileInputStream3, fileOutputStream2);
                                                        w.a((Closeable) fileInputStream3);
                                                        w.a((Closeable) fileOutputStream2);
                                                        throw new IOException("Failed to save new file", e);
                                                    } catch (Exception e10) {
                                                        e8 = e10;
                                                        try {
                                                            throw new IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e8);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            fileInputStream4 = fileInputStream3;
                                                            fileInputStream3 = fileInputStream4;
                                                            w.a((Closeable) fileInputStream3);
                                                            w.a((Closeable) fileOutputStream2);
                                                            throw th;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        w.a((Closeable) fileInputStream3);
                                                        w.a((Closeable) fileOutputStream2);
                                                        throw th;
                                                    }
                                                } catch (Exception e11) {
                                                    fileInputStream3 = fileInputStream4;
                                                    e8 = e11;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    fileInputStream3 = fileInputStream4;
                                                    w.a((Closeable) fileInputStream3);
                                                    w.a((Closeable) fileOutputStream2);
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e12) {
                                            fileInputStream4 = fileInputStream5;
                                            e = e12;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            w.a((Closeable) bufferedInputStream);
                                            w.a((Closeable) fileInputStream4);
                                            if (0 == 0) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e13) {
                                        fileOutputStream4 = fileOutputStream2;
                                        e = e13;
                                        fileInputStream4 = fileInputStream5;
                                        e = e;
                                        fileOutputStream2 = fileOutputStream4;
                                        fileInputStream3 = new FileInputStream(fileCreateTempFile);
                                        if (this.f38515a != null) {
                                            fileOutputStream3 = new FileOutputStream(this.f38515a);
                                        } else {
                                            w.a.a(this.b, 0L, OsConstants.SEEK_SET);
                                            fileOutputStream3 = new FileOutputStream(this.b);
                                        }
                                        fileOutputStream2 = fileOutputStream3;
                                        w.a(fileInputStream3, fileOutputStream2);
                                        w.a((Closeable) fileInputStream3);
                                        w.a((Closeable) fileOutputStream2);
                                        throw new IOException("Failed to save new file", e);
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                    fileOutputStream4 = null;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = null;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            fileOutputStream2 = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream4 = fileInputStream2;
                    }
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream4 = fileInputStream;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = fileInputStream4;
                        w.a((Closeable) fileInputStream);
                        w.a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    w.a((Closeable) fileInputStream);
                    w.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
                fileInputStream4 = fileInputStream;
                throw new IOException("Failed to copy original file to temp file", e);
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
                fileInputStream4 = fileInputStream;
                fileInputStream = fileInputStream4;
                w.a((Closeable) fileInputStream);
                w.a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
        } catch (Throwable th10) {
            th = th10;
            fileOutputStream = null;
        }
    }

    public final void t() throws Throwable {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        d dVar = this.f[1].get("PixelXDimension");
        d dVar2 = this.f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f[0].put("ImageWidth", dVar);
            this.f[0].put("ImageLength", dVar2);
        }
        if (this.f[4].isEmpty() && b(this.f[5])) {
            HashMap<String, d>[] mapArr = this.f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (!b(this.f[4]) && Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "No image meets the size requirements of a thumbnail image.");
        }
        a(0, "ThumbnailOrientation", "Orientation");
        a(0, "ThumbnailImageLength", "ImageLength");
        a(0, "ThumbnailImageWidth", "ImageWidth");
        a(5, "ThumbnailOrientation", "Orientation");
        a(5, "ThumbnailImageLength", "ImageLength");
        a(5, "ThumbnailImageWidth", "ImageWidth");
        a(4, "Orientation", "ThumbnailOrientation");
        a(4, "ImageLength", "ThumbnailImageLength");
        a(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public static class i extends b {
        public i(byte[] bArr) throws IOException {
            super(bArr);
            this.f.mark(Integer.MAX_VALUE);
        }

        public void a(long j) throws IOException {
            long j2 = this.h;
            if (j2 > j) {
                this.h = 0;
                this.f.reset();
            } else {
                j -= j2;
            }
            a((int) j);
        }

        public i(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long f() {
        return a(a("DateTimeOriginal"), a("SubSecTimeOriginal"), a("OffsetTimeOriginal"));
    }

    public final void i(String str) {
        for (int i8 = 0; i8 < c7.length; i8++) {
            this.f[i8].remove(str);
        }
    }

    @Nullable
    public long[] c(@NonNull String str) {
        if (str != null) {
            if (!this.t) {
                d dVarD = d(str);
                if (dVarD != null) {
                    return new long[]{dVarD.c, dVarD.d.length};
                }
                return null;
            }
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public double[] h() {
        String strA = a("GPSLatitude");
        String strA2 = a("GPSLatitudeRef");
        String strA3 = a("GPSLongitude");
        String strA4 = a("GPSLongitudeRef");
        if (strA == null || strA2 == null || strA3 == null || strA4 == null) {
            return null;
        }
        try {
            return new double[]{a(strA, strA2), a(strA3, strA4)};
        } catch (IllegalArgumentException unused) {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.f(v, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", strA, strA2, strA3, strA4));
            return null;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38517a;
        public final String b;
        public final int c;
        public final int d;

        public f(String str, int i, int i2) {
            this.b = str;
            this.f38517a = i;
            this.c = i2;
            this.d = -1;
        }

        public boolean a(int i) {
            int i2;
            int i3 = this.c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }

        public f(String str, int i, int i2, int i3) {
            this.b = str;
            this.f38517a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public final boolean e(byte[] bArr) throws IOException {
        byte[] bytes = D5.getBytes(Charset.defaultCharset());
        for (int i8 = 0; i8 < bytes.length; i8++) {
            if (bArr[i8] != bytes[i8]) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(byte[] bArr) throws IOException {
        try {
            b bVar = new b(bArr);
            try {
                ByteOrder byteOrderE = e(bVar);
                this.h = byteOrderE;
                bVar.a(byteOrderE);
                boolean z8 = bVar.readShort() == 85;
                bVar.close();
                return z8;
            } catch (Throwable th) {
                try {
                    bVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public u(@NonNull String str) throws Throwable {
        f[][] fVarArr = c7;
        this.f = new HashMap[fVarArr.length];
        this.g = new HashSet(fVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            g(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long d() {
        return a(a("DateTime"), a("SubSecTime"), a("OffsetTime"));
    }

    public void c(double d8) {
        String str = d8 >= AudioStats.AUDIO_AMPLITUDE_NONE ? "0" : "1";
        b("GPSAltitude", new h(Math.abs(d8)).toString());
        b("GPSAltitudeRef", str);
    }

    public final void e(i iVar) throws IOException {
        byte[] bArr = j7;
        iVar.a(bArr.length);
        byte[] bArr2 = new byte[iVar.available()];
        iVar.readFully(bArr2);
        this.p = bArr.length;
        a(bArr2, 0);
    }

    public final boolean c(byte[] bArr) throws IOException {
        try {
            b bVar = new b(bArr);
            try {
                ByteOrder byteOrderE = e(bVar);
                this.h = byteOrderE;
                bVar.a(byteOrderE);
                short s = bVar.readShort();
                boolean z8 = s == 20306 || s == 21330;
                bVar.close();
                return z8;
            } catch (Throwable th) {
                try {
                    bVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = R5;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    public final void g(String str) throws Throwable {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.c = null;
            this.f38515a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (a(fileInputStream2.getFD())) {
                        this.b = fileInputStream2.getFD();
                    } else {
                        this.b = null;
                    }
                    a(fileInputStream2);
                    w.a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    w.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public final void f(b bVar) throws Throwable {
        HashMap<String, d> map = this.f[4];
        d dVar = map.get("Compression");
        if (dVar != null) {
            int iB = dVar.b(this.h);
            this.o = iB;
            if (iB != 1) {
                if (iB == 6) {
                    a(bVar, map);
                    return;
                } else if (iB != 7) {
                    return;
                }
            }
            if (a(map)) {
                b(bVar, map);
                return;
            }
            return;
        }
        this.o = 6;
        a(bVar, map);
    }

    public u(@NonNull FileDescriptor fileDescriptor) throws Throwable {
        boolean z8;
        f[][] fVarArr = c7;
        this.f = new HashMap[fVarArr.length];
        this.g = new HashSet(fVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (fileDescriptor != null) {
            FileInputStream fileInputStream = null;
            this.c = null;
            this.f38515a = null;
            if (a(fileDescriptor)) {
                this.b = fileDescriptor;
                try {
                    fileDescriptor = w.a.b(fileDescriptor);
                    z8 = true;
                } catch (Exception e8) {
                    throw new IOException("Failed to duplicate file descriptor", e8);
                }
            } else {
                this.b = null;
                z8 = false;
            }
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);
                try {
                    a(fileInputStream2);
                    w.a((Closeable) fileInputStream2);
                    if (z8) {
                        w.a(fileDescriptor);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    w.a((Closeable) fileInputStream);
                    if (z8) {
                        w.a(fileDescriptor);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("fileDescriptor cannot be null");
        }
    }

    public final void d(i iVar) throws Throwable {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "getRw2Attributes starting with: " + iVar);
        }
        c(iVar);
        d dVar = this.f[0].get("JpgFromRaw");
        if (dVar != null) {
            a(new b(dVar.d), (int) dVar.c, 5);
        }
        d dVar2 = this.f[0].get("ISO");
        d dVar3 = this.f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f[1].put("PhotographicSensitivity", dVar2);
    }

    public final ByteOrder e(b bVar) throws IOException {
        short s = bVar.readShort();
        if (s == 18761) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s));
    }

    public final void c(i iVar) throws Throwable {
        d dVar;
        d((b) iVar);
        a(iVar, 0);
        c(iVar, 0);
        c(iVar, 5);
        c(iVar, 4);
        t();
        if (this.d != 8 || (dVar = this.f[1].get("MakerNote")) == null) {
            return;
        }
        i iVar2 = new i(dVar.d);
        iVar2.a(this.h);
        iVar2.a(6);
        a(iVar2, 9);
        d dVar2 = this.f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f[1].put("ColorSpace", dVar2);
        }
    }

    public int a(@NonNull String str, int i8) {
        if (str != null) {
            d dVarD = d(str);
            if (dVarD != null) {
                try {
                    return dVarD.b(this.h);
                } catch (NumberFormatException unused) {
                }
            }
            return i8;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public static Pair<Integer, Integer> e(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair<Integer, Integer> pairE = e(strArrSplit[0]);
            if (((Integer) pairE.first).intValue() == 2) {
                return pairE;
            }
            for (int i8 = 1; i8 < strArrSplit.length; i8++) {
                Pair<Integer, Integer> pairE2 = e(strArrSplit[i8]);
                int iIntValue = (((Integer) pairE2.first).equals(pairE.first) || ((Integer) pairE2.second).equals(pairE.first)) ? ((Integer) pairE.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairE.second).intValue() == -1 || !(((Integer) pairE2.first).equals(pairE.second) || ((Integer) pairE2.second).equals(pairE.second))) ? -1 : ((Integer) pairE.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (iIntValue == -1) {
                    pairE = new Pair<>(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairE = new Pair<>(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairE;
        }
        if (str.contains(WVNativeCallbackUtil.SEPERATER)) {
            String[] strArrSplit2 = str.split(WVNativeCallbackUtil.SEPERATER, -1);
            if (strArrSplit2.length == 2) {
                try {
                    long j = (long) Double.parseDouble(strArrSplit2[0]);
                    long j8 = (long) Double.parseDouble(strArrSplit2[1]);
                    if (j >= 0 && j8 >= 0) {
                        if (j <= 2147483647L && j8 <= 2147483647L) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        }
        try {
            try {
                long j9 = Long.parseLong(str);
                if (j9 >= 0 && j9 <= 65535) {
                    return new Pair<>(3, 4);
                }
                if (j9 < 0) {
                    return new Pair<>(9, -1);
                }
                return new Pair<>(4, -1);
            } catch (NumberFormatException unused2) {
                return new Pair<>(2, -1);
            }
        } catch (NumberFormatException unused3) {
            Double.parseDouble(str);
            return new Pair<>(12, -1);
        }
    }

    public final boolean g(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = X5;
            if (i8 >= bArr2.length) {
                int i9 = 0;
                while (true) {
                    byte[] bArr3 = Y5;
                    if (i9 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[X5.length + i9 + 4] != bArr3[i9]) {
                        return false;
                    }
                    i9++;
                }
            } else {
                if (bArr[i8] != bArr2[i8]) {
                    return false;
                }
                i8++;
            }
        }
    }

    public double a(@NonNull String str, double d8) {
        if (str != null) {
            d dVarD = d(str);
            if (dVarD != null) {
                try {
                    return dVarD.a(this.h);
                } catch (NumberFormatException unused) {
                }
            }
            return d8;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void a(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            for (int i8 = 0; i8 < c7.length; i8++) {
                try {
                    try {
                        this.f[i8] = new HashMap<>();
                    } catch (Throwable th) {
                        a();
                        if (Dsp.isDebugLogEnable()) {
                            q();
                        }
                        throw th;
                    }
                } catch (IOException | UnsupportedOperationException e8) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.e(v, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e8);
                    }
                    a();
                    if (Dsp.isDebugLogEnable()) {
                        q();
                        return;
                    }
                    return;
                }
            }
            if (!this.e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.d = a(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (c(this.d)) {
                i iVar = new i(inputStream);
                if (this.e) {
                    e(iVar);
                } else {
                    int i9 = this.d;
                    if (i9 == 12) {
                        a(iVar);
                    } else if (i9 == 7) {
                        b(iVar);
                    } else if (i9 == 10) {
                        d(iVar);
                    } else {
                        c(iVar);
                    }
                }
                iVar.a(this.p);
                f(iVar);
            } else {
                b bVar = new b(inputStream);
                int i10 = this.d;
                if (i10 == 4) {
                    a(bVar, 0, 0);
                } else if (i10 == 13) {
                    a(bVar);
                } else if (i10 == 9) {
                    b(bVar);
                } else if (i10 == 14) {
                    c(bVar);
                }
            }
            a();
            if (Dsp.isDebugLogEnable()) {
                q();
                return;
            }
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    public final void d(b bVar) throws IOException {
        ByteOrder byteOrderE = e(bVar);
        this.h = byteOrderE;
        bVar.a(byteOrderE);
        int unsignedShort = bVar.readUnsignedShort();
        int i8 = this.d;
        if (i8 != 7 && i8 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i9 = bVar.readInt();
        if (i9 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i9);
        }
        int i10 = i9 - 8;
        if (i10 > 0) {
            bVar.a(i10);
        }
    }

    public u(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public final void c(b bVar) throws Throwable {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "getWebpAttributes starting with: " + bVar);
        }
        bVar.a(ByteOrder.LITTLE_ENDIAN);
        bVar.a(X5.length);
        int i8 = bVar.readInt() + 8;
        byte[] bArr = Y5;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i9 = bVar.readInt();
                    int i10 = length + 8;
                    if (Arrays.equals(a6, bArr2)) {
                        byte[] bArr3 = new byte[i9];
                        if (bVar.read(bArr3) == i9) {
                            this.p = i10;
                            a(bArr3, 0);
                            f(new b(bArr3));
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + w.a(bArr2));
                        }
                    }
                    if (i9 % 2 == 1) {
                        i9++;
                    }
                    length = i10 + i9;
                    if (length == i8) {
                        return;
                    }
                    if (length <= i8) {
                        bVar.a(i9);
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    public u(@NonNull InputStream inputStream, int i8) throws IOException {
        f[][] fVarArr = c7;
        this.f = new HashMap[fVarArr.length];
        this.g = new HashSet(fVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f38515a = null;
            if (i8 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, j7.length);
                if (!b(bufferedInputStream)) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "Given data does not follow the structure of an Exif-only data.");
                        return;
                    }
                    return;
                } else {
                    this.e = true;
                    this.c = null;
                    this.b = null;
                    inputStream = bufferedInputStream;
                }
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.c = (AssetManager.AssetInputStream) inputStream;
                this.b = null;
            } else if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (a(fileInputStream.getFD())) {
                    this.c = null;
                    this.b = fileInputStream.getFD();
                } else {
                    this.c = null;
                    this.b = null;
                }
            } else {
                this.c = null;
                this.b = null;
            }
            a(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public final void c(InputStream inputStream, OutputStream outputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i8;
        int i9;
        int i10;
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = X5;
        w.a(bVar, cVar, bArr.length);
        byte[] bArr2 = Y5;
        bVar.a(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    c cVar2 = new c(byteArrayOutputStream, byteOrder);
                    int i11 = this.p;
                    if (i11 != 0) {
                        w.a(bVar, cVar2, (i11 - ((bArr.length + 4) + bArr2.length)) - 8);
                        bVar.a(4);
                        int i12 = bVar.readInt();
                        if (i12 % 2 != 0) {
                            i12++;
                        }
                        bVar.a(i12);
                        a(cVar2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (bVar.read(bArr3) == 4) {
                            byte[] bArr4 = d6;
                            boolean z8 = true;
                            if (Arrays.equals(bArr3, bArr4)) {
                                int i13 = bVar.readInt();
                                byte[] bArr5 = new byte[i13 % 2 == 1 ? i13 + 1 : i13];
                                bVar.read(bArr5);
                                byte b8 = (byte) (8 | bArr5[0]);
                                bArr5[0] = b8;
                                boolean z9 = ((b8 >> 1) & 1) == 1;
                                cVar2.write(bArr4);
                                cVar2.b(i13);
                                cVar2.write(bArr5);
                                if (z9) {
                                    a(bVar, cVar2, g6, null);
                                    while (true) {
                                        byte[] bArr6 = new byte[4];
                                        inputStream.read(bArr6);
                                        if (!Arrays.equals(bArr6, h6)) {
                                            break;
                                        } else {
                                            a(bVar, cVar2, bArr6);
                                        }
                                    }
                                    a(cVar2);
                                } else {
                                    a(bVar, cVar2, f6, e6);
                                    a(cVar2);
                                }
                            } else {
                                byte[] bArr7 = f6;
                                if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, e6)) {
                                    int i14 = bVar.readInt();
                                    int i15 = i14 % 2 == 1 ? i14 + 1 : i14;
                                    byte[] bArr8 = new byte[3];
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        bVar.read(bArr8);
                                        byte[] bArr9 = new byte[3];
                                        if (bVar.read(bArr9) == 3 && Arrays.equals(b6, bArr9)) {
                                            i8 = bVar.readInt();
                                            i15 -= 10;
                                            i10 = (i8 << 2) >> 18;
                                            i9 = (i8 << 18) >> 18;
                                            z8 = false;
                                        } else {
                                            throw new IOException("Encountered error while checking VP8 signature");
                                        }
                                    } else if (!Arrays.equals(bArr3, e6)) {
                                        i8 = 0;
                                        z8 = false;
                                        i9 = 0;
                                        i10 = 0;
                                    } else if (bVar.readByte() == 47) {
                                        i8 = bVar.readInt();
                                        i9 = (i8 & 16383) + 1;
                                        i10 = ((i8 & 268419072) >>> 14) + 1;
                                        if ((i8 & 268435456) == 0) {
                                            z8 = false;
                                        }
                                        i15 -= 5;
                                    } else {
                                        throw new IOException("Encountered error while checking VP8L signature");
                                    }
                                    cVar2.write(bArr4);
                                    cVar2.b(10);
                                    byte[] bArr10 = new byte[10];
                                    if (z8) {
                                        bArr10[0] = (byte) (bArr10[0] | com.google.common.base.a.r);
                                    }
                                    bArr10[0] = (byte) (bArr10[0] | 8);
                                    int i16 = i9 - 1;
                                    int i17 = i10 - 1;
                                    bArr10[4] = (byte) i16;
                                    bArr10[5] = (byte) (i16 >> 8);
                                    bArr10[6] = (byte) (i16 >> 16);
                                    bArr10[7] = (byte) i17;
                                    bArr10[8] = (byte) (i17 >> 8);
                                    bArr10[9] = (byte) (i17 >> 16);
                                    cVar2.write(bArr10);
                                    cVar2.write(bArr3);
                                    cVar2.b(i14);
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        cVar2.write(bArr8);
                                        cVar2.write(b6);
                                        cVar2.b(i8);
                                    } else if (Arrays.equals(bArr3, e6)) {
                                        cVar2.write(47);
                                        cVar2.b(i8);
                                    }
                                    w.a(bVar, cVar2, i15);
                                    a(cVar2);
                                }
                            }
                        } else {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                    }
                    w.a(bVar, cVar2);
                    int size = byteArrayOutputStream.size();
                    byte[] bArr11 = Y5;
                    cVar.b(size + bArr11.length);
                    cVar.write(bArr11);
                    byteArrayOutputStream.writeTo(cVar);
                    w.a((Closeable) byteArrayOutputStream);
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    w.a((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = byteArrayOutputStream2;
        }
    }

    public static boolean a(FileDescriptor fileDescriptor) {
        try {
            w.a.a(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!Dsp.isDebugLogEnable()) {
                return false;
            }
            com.ipd.dsp.internal.c2.k.a(v, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    @Deprecated
    public boolean a(float[] fArr) {
        double[] dArrH = h();
        if (dArrH == null) {
            return false;
        }
        fArr[0] = (float) dArrH[0];
        fArr[1] = (float) dArrH[1];
        return true;
    }

    public void a(Location location) {
        if (location == null) {
            return;
        }
        b("GPSProcessingMethod", location.getProvider());
        a(location.getLatitude(), location.getLongitude());
        c(location.getAltitude());
        b("GPSSpeedRef", "K");
        b("GPSSpeed", new h((location.getSpeed() * TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        String[] strArrSplit = l6.format(new Date(location.getTime())).split("\\s+", -1);
        b("GPSDateStamp", strArrSplit[0]);
        b("GPSTimeStamp", strArrSplit[1]);
    }

    public void a(double d8, double d9) {
        if (d8 >= -90.0d && d8 <= 90.0d && !Double.isNaN(d8)) {
            if (d9 >= -180.0d && d9 <= 180.0d && !Double.isNaN(d9)) {
                b("GPSLatitudeRef", d8 >= AudioStats.AUDIO_AMPLITUDE_NONE ? "N" : "S");
                b("GPSLatitude", a(Math.abs(d8)));
                b("GPSLongitudeRef", d9 >= AudioStats.AUDIO_AMPLITUDE_NONE ? "E" : "W");
                b("GPSLongitude", a(Math.abs(d9)));
                return;
            }
            throw new IllegalArgumentException("Longitude value " + d9 + " is not valid.");
        }
        throw new IllegalArgumentException("Latitude value " + d8 + " is not valid.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(@NonNull Long l) {
        if (l == null) {
            throw new NullPointerException("Timestamp should not be null.");
        }
        if (l.longValue() >= 0) {
            String string = Long.toString(l.longValue() % 1000);
            for (int length = string.length(); length < 3; length++) {
                string = "0" + string;
            }
            b("DateTime", l6.format(new Date(l.longValue())));
            b("SubSecTime", string);
            return;
        }
        throw new IllegalArgumentException("Timestamp should a positive value.");
    }

    public void b(int i8) {
        if (i8 % 90 == 0) {
            int iA = a("Orientation", 1);
            List<Integer> list = L2;
            int iIntValue = 0;
            if (list.contains(Integer.valueOf(iA))) {
                int iIndexOf = (list.indexOf(Integer.valueOf(iA)) + (i8 / 90)) % 4;
                iIntValue = list.get(iIndexOf + (iIndexOf < 0 ? 4 : 0)).intValue();
            } else {
                List<Integer> list2 = M2;
                if (list2.contains(Integer.valueOf(iA))) {
                    int iIndexOf2 = (list2.indexOf(Integer.valueOf(iA)) + (i8 / 90)) % 4;
                    iIntValue = list2.get(iIndexOf2 + (iIndexOf2 < 0 ? 4 : 0)).intValue();
                }
            }
            b("Orientation", Integer.toString(iIntValue));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public static Long a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null && T7.matcher(str).matches()) {
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date date = l6.parse(str, parsePosition);
                if (date == null && (date = m6.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = date.getTime();
                if (str3 != null) {
                    int i8 = 1;
                    String strSubstring = str3.substring(0, 1);
                    int i9 = Integer.parseInt(str3.substring(1, 3));
                    int i10 = Integer.parseInt(str3.substring(4, 6));
                    if (("+".equals(strSubstring) || c49.f40900a.equals(strSubstring)) && u15.f19942b.equals(str3.substring(3, 4)) && i9 <= 14) {
                        long j = ((((long) i9) * 60) + ((long) i10)) * 60000;
                        if (!c49.f40900a.equals(strSubstring)) {
                            i8 = -1;
                        }
                        time += j * ((long) i8);
                    }
                }
                if (str2 != null) {
                    time += w.a(str2);
                }
                return Long.valueOf(time);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public void b() {
        int i8 = 1;
        switch (a("Orientation", 1)) {
            case 1:
                i8 = 2;
                break;
            case 2:
                break;
            case 3:
                i8 = 4;
                break;
            case 4:
                i8 = 3;
                break;
            case 5:
                i8 = 6;
                break;
            case 6:
                i8 = 5;
                break;
            case 7:
                i8 = 8;
                break;
            case 8:
                i8 = 7;
                break;
            default:
                i8 = 0;
                break;
        }
        b("Orientation", Integer.toString(i8));
    }

    @Nullable
    public byte[] b(@NonNull String str) {
        if (str != null) {
            d dVarD = d(str);
            if (dVarD != null) {
                return dVarD.d;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public static double a(String str, String str2) {
        try {
            String[] strArrSplit = str.split(",", -1);
            String[] strArrSplit2 = strArrSplit[0].split(WVNativeCallbackUtil.SEPERATER, -1);
            double d8 = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split(WVNativeCallbackUtil.SEPERATER, -1);
            double d9 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split(WVNativeCallbackUtil.SEPERATER, -1);
            double d10 = d8 + (d9 / 60.0d) + ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d);
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new IllegalArgumentException();
                }
                return d10;
            }
            return -d10;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public double b(double d8) {
        double dA = a("GPSAltitude", -1.0d);
        int iA = a("GPSAltitudeRef", -1);
        if (dA < AudioStats.AUDIO_AMPLITUDE_NONE || iA < 0) {
            return d8;
        }
        return dA * ((double) (iA != 1 ? 1 : -1));
    }

    public static boolean b(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = C5;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    public static boolean b(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = j7;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr3 = j7;
            if (i8 >= bArr3.length) {
                return true;
            }
            if (bArr2[i8] != bArr3[i8]) {
                return false;
            }
            i8++;
        }
    }

    public final void b(b bVar) throws Throwable {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "getRafAttributes starting with: " + bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i8 = ByteBuffer.wrap(bArr).getInt();
        int i9 = ByteBuffer.wrap(bArr2).getInt();
        int i10 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i9];
        bVar.a(i8 - bVar.a());
        bVar.read(bArr4);
        a(new b(bArr4), i8, 5);
        bVar.a(i10 - bVar.a());
        bVar.a(ByteOrder.BIG_ENDIAN);
        int i11 = bVar.readInt();
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "numberOfDirectoryEntry: " + i11);
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == N6.f38517a) {
                short s = bVar.readShort();
                short s8 = bVar.readShort();
                d dVarB = d.b(s, this.h);
                d dVarB2 = d.b(s8, this.h);
                this.f[0].put("ImageLength", dVarB);
                this.f[0].put("ImageWidth", dVarB2);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "Updated to length: " + ((int) s) + ", width: " + ((int) s8));
                    return;
                }
                return;
            }
            bVar.a(unsignedShort2);
        }
    }

    public final String a(double d8) {
        long j = (long) d8;
        double d9 = d8 - j;
        long j8 = (long) (d9 * 60.0d);
        return j + "/1," + j8 + "/1," + Math.round((d9 - (j8 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    public final void c(i iVar, int i8) throws Throwable {
        d dVarB;
        d dVarB2;
        d dVar = this.f[i8].get("DefaultCropSize");
        d dVar2 = this.f[i8].get("SensorTopBorder");
        d dVar3 = this.f[i8].get("SensorLeftBorder");
        d dVar4 = this.f[i8].get("SensorBottomBorder");
        d dVar5 = this.f[i8].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
                int iB = dVar2.b(this.h);
                int iB2 = dVar4.b(this.h);
                int iB3 = dVar5.b(this.h);
                int iB4 = dVar3.b(this.h);
                if (iB2 <= iB || iB3 <= iB4) {
                    return;
                }
                d dVarB3 = d.b(iB2 - iB, this.h);
                d dVarB4 = d.b(iB3 - iB4, this.h);
                this.f[i8].put("ImageLength", dVarB3);
                this.f[i8].put("ImageWidth", dVarB4);
                return;
            }
            b(iVar, i8);
            return;
        }
        if (dVar.f38516a == 5) {
            h[] hVarArr = (h[]) dVar.d(this.h);
            if (hVarArr != null && hVarArr.length == 2) {
                dVarB = d.b(hVarArr[0], this.h);
                dVarB2 = d.b(hVarArr[1], this.h);
            } else {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(v, "Invalid crop size values. cropSize=" + Arrays.toString(hVarArr));
                    return;
                }
                return;
            }
        } else {
            int[] iArr = (int[]) dVar.d(this.h);
            if (iArr != null && iArr.length == 2) {
                dVarB = d.b(iArr[0], this.h);
                dVarB2 = d.b(iArr[1], this.h);
            } else {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(v, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                return;
            }
        }
        this.f[i8].put("ImageWidth", dVarB);
        this.f[i8].put("ImageLength", dVarB2);
    }

    public final int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (b(bArr)) {
            return 4;
        }
        if (e(bArr)) {
            return 9;
        }
        if (a(bArr)) {
            return 12;
        }
        if (c(bArr)) {
            return 7;
        }
        if (f(bArr)) {
            return 10;
        }
        if (d(bArr)) {
            return 13;
        }
        return g(bArr) ? 14 : 0;
    }

    public final boolean a(byte[] bArr) throws Throwable {
        long j;
        b bVar = null;
        try {
            try {
                b bVar2 = new b(bArr);
                try {
                    long length = bVar2.readInt();
                    byte[] bArr2 = new byte[4];
                    bVar2.read(bArr2);
                    if (!Arrays.equals(bArr2, F5)) {
                        bVar2.close();
                        return false;
                    }
                    if (length == 1) {
                        length = bVar2.readLong();
                        j = 16;
                        if (length < 16) {
                            bVar2.close();
                            return false;
                        }
                    } else {
                        j = 8;
                    }
                    if (length > bArr.length) {
                        length = bArr.length;
                    }
                    long j8 = length - j;
                    if (j8 < 8) {
                        bVar2.close();
                        return false;
                    }
                    byte[] bArr3 = new byte[4];
                    boolean z8 = false;
                    boolean z9 = false;
                    for (long j9 = 0; j9 < j8 / 4; j9++) {
                        if (bVar2.read(bArr3) != 4) {
                            bVar2.close();
                            return false;
                        }
                        if (j9 != 1) {
                            if (Arrays.equals(bArr3, G5)) {
                                z8 = true;
                            } else if (Arrays.equals(bArr3, H5)) {
                                z9 = true;
                            }
                            if (z8 && z9) {
                                bVar2.close();
                                return true;
                            }
                        }
                    }
                    bVar2.close();
                } catch (Exception e8) {
                    e = e8;
                    bVar = bVar2;
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, "Exception parsing HEIF file type box.", e);
                    }
                    if (bVar != null) {
                        bVar.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    if (bVar != null) {
                        bVar.close();
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b(i iVar) throws Throwable {
        int i8;
        int i9;
        c(iVar);
        d dVar = this.f[1].get("MakerNote");
        if (dVar != null) {
            i iVar2 = new i(dVar.d);
            iVar2.a(this.h);
            byte[] bArr = K5;
            byte[] bArr2 = new byte[bArr.length];
            iVar2.readFully(bArr2);
            iVar2.a(0L);
            byte[] bArr3 = L5;
            byte[] bArr4 = new byte[bArr3.length];
            iVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                iVar2.a(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                iVar2.a(12L);
            }
            a(iVar2, 6);
            d dVar2 = this.f[7].get("PreviewImageStart");
            d dVar3 = this.f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f[5].put("JPEGInterchangeFormat", dVar2);
                this.f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = this.f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.d(this.h);
                if (iArr != null && iArr.length == 4) {
                    int i10 = iArr[2];
                    int i11 = iArr[0];
                    if (i10 <= i11 || (i8 = iArr[3]) <= (i9 = iArr[1])) {
                        return;
                    }
                    int i12 = (i10 - i11) + 1;
                    int i13 = (i8 - i9) + 1;
                    if (i12 < i13) {
                        int i14 = i12 + i13;
                        i13 = i14 - i13;
                        i12 = i14 - i13;
                    }
                    d dVarB = d.b(i12, this.h);
                    d dVarB2 = d.b(i13, this.h);
                    this.f[0].put("ImageWidth", dVarB);
                    this.f[0].put("ImageLength", dVarB2);
                    return;
                }
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(v, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bd A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00df  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e2  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void a(com.ipd.dsp.internal.q.u.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipd.dsp.internal.q.u.a(com.ipd.dsp.internal.q.u$b, int, int):void");
    }

    public final void b(InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = R5;
        w.a(bVar, cVar, bArr.length);
        int i8 = this.p;
        if (i8 == 0) {
            int i9 = bVar.readInt();
            cVar.b(i9);
            w.a(bVar, cVar, i9 + 8);
        } else {
            w.a(bVar, cVar, (i8 - bArr.length) - 8);
            bVar.a(bVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                a(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.b((int) crc32.getValue());
                w.a((Closeable) byteArrayOutputStream2);
                w.a(bVar, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                w.a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void a(i iVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i8;
        if (Build.VERSION.SDK_INT >= 28) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    w.b.a(mediaMetadataRetriever, new a(iVar));
                    String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                    String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                    String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                    String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                    if ("yes".equals(strExtractMetadata6)) {
                        strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                        strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                        strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(strExtractMetadata7)) {
                        strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                        strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                        strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        strExtractMetadata = null;
                        strExtractMetadata2 = null;
                        strExtractMetadata3 = null;
                    }
                    if (strExtractMetadata != null) {
                        this.f[0].put("ImageWidth", d.b(Integer.parseInt(strExtractMetadata), this.h));
                    }
                    if (strExtractMetadata2 != null) {
                        this.f[0].put("ImageLength", d.b(Integer.parseInt(strExtractMetadata2), this.h));
                    }
                    if (strExtractMetadata3 != null) {
                        int i9 = Integer.parseInt(strExtractMetadata3);
                        if (i9 == 90) {
                            i8 = 6;
                        } else if (i9 != 180) {
                            i8 = i9 != 270 ? 1 : 8;
                        } else {
                            i8 = 3;
                        }
                        this.f[0].put("Orientation", d.b(i8, this.h));
                    }
                    if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                        int i10 = Integer.parseInt(strExtractMetadata4);
                        int i11 = Integer.parseInt(strExtractMetadata5);
                        if (i11 > 6) {
                            iVar.a(i10);
                            byte[] bArr = new byte[6];
                            if (iVar.read(bArr) == 6) {
                                int i12 = i10 + 6;
                                int i13 = i11 - 6;
                                if (Arrays.equals(bArr, j7)) {
                                    byte[] bArr2 = new byte[i13];
                                    if (iVar.read(bArr2) == i13) {
                                        this.p = i12;
                                        a(bArr2, 0);
                                    } else {
                                        throw new IOException("Can't read exif");
                                    }
                                } else {
                                    throw new IOException("Invalid identifier");
                                }
                            } else {
                                throw new IOException("Can't read identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                    }
                    mediaMetadataRetriever.release();
                    return;
                } catch (RuntimeException unused) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
                }
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        }
        throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
    }

    public final void b(i iVar, int i8) throws Throwable {
        d dVar = this.f[i8].get("ImageLength");
        d dVar2 = this.f[i8].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f[i8].get("JPEGInterchangeFormat");
            d dVar4 = this.f[i8].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iB = dVar3.b(this.h);
            int iB2 = dVar3.b(this.h);
            iVar.a(iB);
            byte[] bArr = new byte[iB2];
            iVar.read(bArr);
            a(new b(bArr), iB, i8);
        }
    }

    public final void b(b bVar, HashMap map) throws IOException {
        d dVar = (d) map.get("StripOffsets");
        d dVar2 = (d) map.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrA = w.a(dVar.d(this.h));
        long[] jArrA2 = w.a(dVar2.d(this.h));
        if (jArrA != null && jArrA.length != 0) {
            if (jArrA2 != null && jArrA2.length != 0) {
                if (jArrA.length != jArrA2.length) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.f(v, "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    return;
                }
                long j = 0;
                for (long j8 : jArrA2) {
                    j += j8;
                }
                int i8 = (int) j;
                byte[] bArr = new byte[i8];
                this.k = true;
                this.j = true;
                this.i = true;
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < jArrA.length; i11++) {
                    int i12 = (int) jArrA[i11];
                    int i13 = (int) jArrA2[i11];
                    if (i11 < jArrA.length - 1 && i12 + i13 != jArrA[i11 + 1]) {
                        this.k = false;
                    }
                    int i14 = i12 - i9;
                    if (i14 < 0) {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Invalid strip offset value");
                            return;
                        }
                        return;
                    }
                    long j9 = i14;
                    if (bVar.skip(j9) != j9) {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Failed to skip " + i14 + " bytes.");
                            return;
                        }
                        return;
                    }
                    int i15 = i9 + i14;
                    byte[] bArr2 = new byte[i13];
                    if (bVar.read(bArr2) != i13) {
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Failed to read " + i13 + " bytes.");
                            return;
                        }
                        return;
                    }
                    i9 = i15 + i13;
                    System.arraycopy(bArr2, 0, bArr, i10, i13);
                    i10 += i13;
                }
                this.n = bArr;
                if (this.k) {
                    this.l = (int) jArrA[0];
                    this.m = i8;
                    return;
                }
                return;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(v, "stripByteCounts should not be null or have zero length.");
                return;
            }
            return;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.f(v, "stripOffsets should not be null or have zero length.");
        }
    }

    public final void a(b bVar) throws Throwable {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "getPngAttributes starting with: " + bVar);
        }
        bVar.a(ByteOrder.BIG_ENDIAN);
        byte[] bArr = R5;
        bVar.a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i8 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i9 = length + 8;
                    if (i9 == 16 && !Arrays.equals(bArr2, T5)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (Arrays.equals(bArr2, U5)) {
                        return;
                    }
                    if (Arrays.equals(bArr2, S5)) {
                        byte[] bArr3 = new byte[i8];
                        if (bVar.read(bArr3) == i8) {
                            int i10 = bVar.readInt();
                            CRC32 crc32 = new CRC32();
                            crc32.update(bArr2);
                            crc32.update(bArr3);
                            if (((int) crc32.getValue()) == i10) {
                                this.p = i9;
                                a(bArr3, 0);
                                t();
                                f(new b(bArr3));
                                return;
                            }
                            throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i10 + ", calculated CRC value: " + crc32.getValue());
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + w.a(bArr2));
                    }
                    int i11 = i8 + 4;
                    bVar.a(i11);
                    length = i9 + i11;
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final boolean b(HashMap map) throws IOException {
        d dVar = (d) map.get("ImageLength");
        d dVar2 = (d) map.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.b(this.h) <= 512 && dVar2.b(this.h) <= 512;
    }

    public final void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.a(-1);
            if (bVar.readByte() == -40) {
                cVar.a(-40);
                d dVarRemove = (a("Xmp") == null || !this.u) ? null : this.f[0].remove("Xmp");
                cVar.a(-1);
                cVar.a(-31);
                a(cVar);
                if (dVarRemove != null) {
                    this.f[0].put("Xmp", dVarRemove);
                }
                byte[] bArr = new byte[4096];
                while (bVar.readByte() == -1) {
                    byte b8 = bVar.readByte();
                    if (b8 == -39 || b8 == -38) {
                        cVar.a(-1);
                        cVar.a((int) b8);
                        w.a(bVar, cVar);
                        return;
                    }
                    if (b8 != -31) {
                        cVar.a(-1);
                        cVar.a((int) b8);
                        int unsignedShort = bVar.readUnsignedShort();
                        cVar.c(unsignedShort);
                        int i8 = unsignedShort - 2;
                        if (i8 < 0) {
                            throw new IOException("Invalid length");
                        }
                        while (i8 > 0) {
                            int i9 = bVar.read(bArr, 0, Math.min(i8, 4096));
                            if (i9 < 0) {
                                break;
                            }
                            cVar.write(bArr, 0, i9);
                            i8 -= i9;
                        }
                    } else {
                        int unsignedShort2 = bVar.readUnsignedShort();
                        int i10 = unsignedShort2 - 2;
                        if (i10 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (i10 >= 6) {
                                if (bVar.read(bArr2) == 6) {
                                    if (Arrays.equals(bArr2, j7)) {
                                        bVar.a(unsignedShort2 - 8);
                                    }
                                } else {
                                    throw new IOException("Invalid exif");
                                }
                            }
                            cVar.a(-1);
                            cVar.a((int) b8);
                            cVar.c(unsignedShort2);
                            if (i10 >= 6) {
                                i10 = unsignedShort2 - 8;
                                cVar.write(bArr2);
                            }
                            while (i10 > 0) {
                                int i11 = bVar.read(bArr, 0, Math.min(i10, 4096));
                                if (i11 < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, i11);
                                i10 -= i11;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    public final void a(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = i7;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            a(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public final void a(b bVar, c cVar, byte[] bArr) throws IOException {
        int i8 = bVar.readInt();
        cVar.write(bArr);
        cVar.b(i8);
        if (i8 % 2 == 1) {
            i8++;
        }
        w.a(bVar, cVar, i8);
    }

    public final void a(byte[] bArr, int i8) throws IOException {
        i iVar = new i(bArr);
        d((b) iVar);
        a(iVar, i8);
    }

    public final void a() {
        String strA = a("DateTimeOriginal");
        if (strA != null && a("DateTime") == null) {
            this.f[0].put("DateTime", d.b(strA));
        }
        if (a("ImageWidth") == null) {
            this.f[0].put("ImageWidth", d.a(0L, this.h));
        }
        if (a("ImageLength") == null) {
            this.f[0].put("ImageLength", d.a(0L, this.h));
        }
        if (a("Orientation") == null) {
            this.f[0].put("Orientation", d.a(0L, this.h));
        }
        if (a("LightSource") == null) {
            this.f[1].put("LightSource", d.a(0L, this.h));
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:102:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:104:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:106:0x0303  */
    /* JADX WARN: Code duplicated, block: B:109:0x0310  */
    /* JADX WARN: Code duplicated, block: B:111:0x031a  */
    /* JADX WARN: Code duplicated, block: B:120:0x0346  */
    /* JADX WARN: Code duplicated, block: B:149:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0148  */
    /* JADX WARN: Code duplicated, block: B:50:0x0153  */
    /* JADX WARN: Code duplicated, block: B:52:0x015b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0167  */
    /* JADX WARN: Code duplicated, block: B:55:0x017f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0186  */
    /* JADX WARN: Code duplicated, block: B:60:0x0190  */
    /* JADX WARN: Code duplicated, block: B:61:0x0193  */
    /* JADX WARN: Code duplicated, block: B:63:0x0196  */
    /* JADX WARN: Code duplicated, block: B:66:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:74:0x021f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0222  */
    /* JADX WARN: Code duplicated, block: B:78:0x0225 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x0227  */
    /* JADX WARN: Code duplicated, block: B:81:0x022b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0237  */
    /* JADX WARN: Code duplicated, block: B:86:0x023c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0241  */
    /* JADX WARN: Code duplicated, block: B:91:0x024c  */
    /* JADX WARN: Code duplicated, block: B:94:0x026e  */
    /* JADX WARN: Code duplicated, block: B:96:0x027b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0286  */
    /* JADX WARN: Code duplicated, block: B:99:0x028c  */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x02b4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:54:0x0167, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x01ff, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:99:0x028c, please report this as an issue */
    public final void a(i iVar, int i8) throws IOException {
        long j;
        long j8;
        char c8;
        long j9;
        Integer num;
        long j10;
        int unsignedShort;
        long jB;
        int i9;
        this.g.add(Integer.valueOf(iVar.h));
        short s = iVar.readShort();
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "numberOfDirectoryEntry: " + ((int) s));
        }
        if (s <= 0) {
            return;
        }
        char c9 = 0;
        short s8 = 0;
        while (s8 < s) {
            int unsignedShort2 = iVar.readUnsignedShort();
            int unsignedShort3 = iVar.readUnsignedShort();
            int i10 = iVar.readInt();
            long jA = ((long) iVar.a()) + 4;
            f fVar = e7[i8].get(Integer.valueOf(unsignedShort2));
            if (Dsp.isDebugLogEnable()) {
                Locale locale = Locale.getDefault();
                Integer numValueOf = Integer.valueOf(i8);
                Integer numValueOf2 = Integer.valueOf(unsignedShort2);
                String str = fVar != null ? fVar.b : null;
                Integer numValueOf3 = Integer.valueOf(unsignedShort3);
                Integer numValueOf4 = Integer.valueOf(i10);
                Object[] objArr = new Object[5];
                objArr[c9] = numValueOf;
                objArr[1] = numValueOf2;
                objArr[2] = str;
                objArr[3] = numValueOf3;
                objArr[4] = numValueOf4;
                com.ipd.dsp.internal.c2.k.a(v, String.format(locale, "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
            }
            if (fVar == null) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "Skip the tag entry since tag number is not defined: " + unsignedShort2);
                }
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = G6;
                    if (unsignedShort3 < iArr.length) {
                        if (!fVar.a(unsignedShort3)) {
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Skip the tag entry since data format (" + F6[unsignedShort3] + ") is unexpected for tag: " + fVar.b);
                            }
                        } else {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = fVar.c;
                            }
                            j = jA;
                            j8 = ((long) i10) * ((long) iArr[unsignedShort3]);
                            if (j8 < 0 || j8 > 2147483647L) {
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(v, "Skip the tag entry since the number of components is invalid: " + i10);
                                }
                                c8 = c9;
                            } else {
                                c8 = 1;
                            }
                        }
                    }
                    if (c8 == 0) {
                        iVar.a(j);
                        s = s;
                        s8 = s8;
                    } else {
                        j9 = j;
                        if (j8 > 4) {
                            i9 = iVar.readInt();
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "seek to data offset: " + i9);
                            }
                            if (this.d == 7) {
                                if ("MakerNote".equals(fVar.b)) {
                                    this.q = i9;
                                } else if (i8 != 6 && "ThumbnailImage".equals(fVar.b)) {
                                    this.r = i9;
                                    this.s = i10;
                                    d dVarB = d.b(6, this.h);
                                    d dVarA = d.a(this.r, this.h);
                                    d dVarA2 = d.a(this.s, this.h);
                                    this.f[4].put("Compression", dVarB);
                                    this.f[4].put("JPEGInterchangeFormat", dVarA);
                                    this.f[4].put("JPEGInterchangeFormatLength", dVarA2);
                                }
                            }
                            iVar.a(i9);
                        } else {
                            s8 = s8;
                            j9 = j9;
                            i10 = i10;
                        }
                        num = h7.get(Integer.valueOf(unsignedShort2));
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "nextIfdType: " + num + " byteCount: " + j8);
                        }
                        if (num != null) {
                            if (unsignedShort3 == 3) {
                                unsignedShort = iVar.readUnsignedShort();
                            } else {
                                if (unsignedShort3 == 4) {
                                    jB = iVar.b();
                                } else if (unsignedShort3 == 8) {
                                    unsignedShort = iVar.readShort();
                                } else if (unsignedShort3 != 9 || unsignedShort3 == 13) {
                                    unsignedShort = iVar.readInt();
                                } else {
                                    jB = -1;
                                }
                                if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                                }
                                if (jB > 0) {
                                    if (!this.g.contains(Integer.valueOf((int) jB))) {
                                        iVar.a(jB);
                                        a(iVar, num.intValue());
                                    } else if (Dsp.isDebugLogEnable()) {
                                        com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                                    }
                                } else if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                                }
                                iVar.a(j9);
                            }
                            jB = unsignedShort;
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                            }
                            if (jB > 0) {
                                if (!this.g.contains(Integer.valueOf((int) jB))) {
                                    iVar.a(jB);
                                    a(iVar, num.intValue());
                                } else if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                                }
                            } else if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                            }
                            iVar.a(j9);
                        } else {
                            j10 = j9;
                            int iA = iVar.a() + this.p;
                            byte[] bArr = new byte[(int) j8];
                            iVar.readFully(bArr);
                            d dVar = new d(unsignedShort3, i10, iA, bArr);
                            this.f[i8].put(fVar.b, dVar);
                            if ("DNGVersion".equals(fVar.b)) {
                                this.d = 3;
                            }
                            if (((!"Make".equals(fVar.b) || "Model".equals(fVar.b)) && dVar.c(this.h).contains(P5)) || ("Compression".equals(fVar.b) && dVar.b(this.h) == 65535)) {
                                this.d = 8;
                            }
                            if (iVar.a() != j10) {
                                iVar.a(j10);
                            }
                        }
                    }
                    s8 = (short) (s8 + 1);
                    s = s;
                    c9 = 0;
                }
                j = jA;
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                c8 = c9;
                j8 = 0;
                if (c8 == 0) {
                    iVar.a(j);
                    s = s;
                    s8 = s8;
                } else {
                    j9 = j;
                    if (j8 > 4) {
                        i9 = iVar.readInt();
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "seek to data offset: " + i9);
                        }
                        if (this.d == 7) {
                            if ("MakerNote".equals(fVar.b)) {
                                this.q = i9;
                            } else if (i8 != 6) {
                            }
                        }
                        iVar.a(i9);
                    } else {
                        s8 = s8;
                        j9 = j9;
                        i10 = i10;
                    }
                    num = h7.get(Integer.valueOf(unsignedShort2));
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, "nextIfdType: " + num + " byteCount: " + j8);
                    }
                    if (num != null) {
                        if (unsignedShort3 == 3) {
                            unsignedShort = iVar.readUnsignedShort();
                        } else {
                            if (unsignedShort3 == 4) {
                                jB = iVar.b();
                            } else if (unsignedShort3 == 8) {
                                if (unsignedShort3 != 9) {
                                }
                                unsignedShort = iVar.readInt();
                            } else {
                                unsignedShort = iVar.readShort();
                            }
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                            }
                            if (jB > 0) {
                                if (!this.g.contains(Integer.valueOf((int) jB))) {
                                    iVar.a(jB);
                                    a(iVar, num.intValue());
                                } else if (Dsp.isDebugLogEnable()) {
                                    com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                                }
                            } else if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                            }
                            iVar.a(j9);
                        }
                        jB = unsignedShort;
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                        }
                        if (jB > 0) {
                            if (!this.g.contains(Integer.valueOf((int) jB))) {
                                iVar.a(jB);
                                a(iVar, num.intValue());
                            } else if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                            }
                        } else if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                        }
                        iVar.a(j9);
                    } else {
                        j10 = j9;
                        int iA2 = iVar.a() + this.p;
                        byte[] bArr2 = new byte[(int) j8];
                        iVar.readFully(bArr2);
                        d dVar2 = new d(unsignedShort3, i10, iA2, bArr2);
                        this.f[i8].put(fVar.b, dVar2);
                        if ("DNGVersion".equals(fVar.b)) {
                            this.d = 3;
                        }
                        if (!"Make".equals(fVar.b)) {
                        }
                        this.d = 8;
                        if (iVar.a() != j10) {
                            iVar.a(j10);
                        }
                    }
                }
                s8 = (short) (s8 + 1);
                s = s;
                c9 = 0;
            }
            j = jA;
            c8 = c9;
            j8 = 0;
            if (c8 == 0) {
                iVar.a(j);
                s = s;
                s8 = s8;
            } else {
                j9 = j;
                if (j8 > 4) {
                    i9 = iVar.readInt();
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, "seek to data offset: " + i9);
                    }
                    if (this.d == 7) {
                        if ("MakerNote".equals(fVar.b)) {
                            this.q = i9;
                        } else if (i8 != 6) {
                        }
                    }
                    iVar.a(i9);
                } else {
                    s8 = s8;
                    j9 = j9;
                    i10 = i10;
                }
                num = h7.get(Integer.valueOf(unsignedShort2));
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "nextIfdType: " + num + " byteCount: " + j8);
                }
                if (num != null) {
                    if (unsignedShort3 == 3) {
                        unsignedShort = iVar.readUnsignedShort();
                    } else {
                        if (unsignedShort3 == 4) {
                            jB = iVar.b();
                        } else if (unsignedShort3 == 8) {
                            if (unsignedShort3 != 9) {
                            }
                            unsignedShort = iVar.readInt();
                        } else {
                            unsignedShort = iVar.readShort();
                        }
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                        }
                        if (jB > 0) {
                            if (!this.g.contains(Integer.valueOf((int) jB))) {
                                iVar.a(jB);
                                a(iVar, num.intValue());
                            } else if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                            }
                        } else if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                        }
                        iVar.a(j9);
                    }
                    jB = unsignedShort;
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "Offset: %d, tagName: %s", Long.valueOf(jB), fVar.b));
                    }
                    if (jB > 0) {
                        if (!this.g.contains(Integer.valueOf((int) jB))) {
                            iVar.a(jB);
                            a(iVar, num.intValue());
                        } else if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jB + ")");
                        }
                    } else if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(v, "Skip jump into the IFD since its offset is invalid: " + jB);
                    }
                    iVar.a(j9);
                } else {
                    j10 = j9;
                    int iA3 = iVar.a() + this.p;
                    byte[] bArr3 = new byte[(int) j8];
                    iVar.readFully(bArr3);
                    d dVar3 = new d(unsignedShort3, i10, iA3, bArr3);
                    this.f[i8].put(fVar.b, dVar3);
                    if ("DNGVersion".equals(fVar.b)) {
                        this.d = 3;
                    }
                    if (!"Make".equals(fVar.b)) {
                    }
                    this.d = 8;
                    if (iVar.a() != j10) {
                        iVar.a(j10);
                    }
                }
            }
            s8 = (short) (s8 + 1);
            s = s;
            c9 = 0;
        }
        int i11 = iVar.readInt();
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, String.format("nextIfdOffset: %d", Integer.valueOf(i11)));
        }
        long j11 = i11;
        if (j11 > 0) {
            if (!this.g.contains(Integer.valueOf(i11))) {
                iVar.a(j11);
                if (this.f[4].isEmpty()) {
                    a(iVar, 4);
                    return;
                } else {
                    if (this.f[5].isEmpty()) {
                        a(iVar, 5);
                        return;
                    }
                    return;
                }
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "Stop reading file since re-reading an IFD may cause an infinite loop: " + i11);
                return;
            }
            return;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "Stop reading file since a wrong offset may cause an infinite loop: " + i11);
        }
    }

    public final void a(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get("JPEGInterchangeFormat");
        d dVar2 = (d) map.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iB = dVar.b(this.h);
        int iB2 = dVar2.b(this.h);
        if (this.d == 7) {
            iB += this.q;
        }
        if (iB > 0 && iB2 > 0) {
            this.i = true;
            if (this.f38515a == null && this.c == null && this.b == null) {
                byte[] bArr = new byte[iB2];
                bVar.skip(iB);
                bVar.read(bArr);
                this.n = bArr;
            }
            this.l = iB;
            this.m = iB2;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "Setting thumbnail attributes with offset: " + iB + ", length: " + iB2);
        }
    }

    public final boolean a(HashMap map) throws IOException {
        d dVar;
        int iB;
        d dVar2 = (d) map.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.d(this.h);
            int[] iArr2 = q5;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iB = dVar.b(this.h)) == 1 && Arrays.equals(iArr, s5)) || (iB == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!Dsp.isDebugLogEnable()) {
            return false;
        }
        com.ipd.dsp.internal.c2.k.a(v, "Unsupported data type value");
        return false;
    }

    public final int a(c cVar) throws IOException {
        f[][] fVarArr = c7;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (f fVar : d7) {
            i(fVar.b);
        }
        if (this.i) {
            if (this.j) {
                i("StripOffsets");
                i("StripByteCounts");
            } else {
                i("JPEGInterchangeFormat");
                i("JPEGInterchangeFormatLength");
            }
        }
        for (int i8 = 0; i8 < c7.length; i8++) {
            for (Object obj : this.f[i8].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f[i8].remove(entry.getKey());
                }
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(d7[1].b, d.a(0L, this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(d7[2].b, d.a(0L, this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(d7[3].b, d.a(0L, this.h));
        }
        if (this.i) {
            if (this.j) {
                this.f[4].put("StripOffsets", d.b(0, this.h));
                this.f[4].put("StripByteCounts", d.b(this.m, this.h));
            } else {
                this.f[4].put("JPEGInterchangeFormat", d.a(0L, this.h));
                this.f[4].put("JPEGInterchangeFormatLength", d.a(this.m, this.h));
            }
        }
        for (int i9 = 0; i9 < c7.length; i9++) {
            Iterator<Map.Entry<String, d>> it = this.f[i9].entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                int iA = it.next().getValue().a();
                if (iA > 4) {
                    i10 += iA;
                }
            }
            iArr2[i9] = iArr2[i9] + i10;
        }
        int size = 8;
        for (int i11 = 0; i11 < c7.length; i11++) {
            if (!this.f[i11].isEmpty()) {
                iArr[i11] = size;
                size += (this.f[i11].size() * 12) + 6 + iArr2[i11];
            }
        }
        if (this.i) {
            if (this.j) {
                this.f[4].put("StripOffsets", d.b(size, this.h));
            } else {
                this.f[4].put("JPEGInterchangeFormat", d.a(size, this.h));
            }
            this.l = size;
            size += this.m;
        }
        if (this.d == 4) {
            size += 8;
        }
        if (Dsp.isDebugLogEnable()) {
            for (int i12 = 0; i12 < c7.length; i12++) {
                com.ipd.dsp.internal.c2.k.a(v, String.format(Locale.getDefault(), "index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i12), Integer.valueOf(iArr[i12]), Integer.valueOf(this.f[i12].size()), Integer.valueOf(iArr2[i12]), Integer.valueOf(size)));
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(d7[1].b, d.a(iArr[1], this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(d7[2].b, d.a(iArr[2], this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(d7[3].b, d.a(iArr[3], this.h));
        }
        int i13 = this.d;
        if (i13 == 4) {
            cVar.c(size);
            cVar.write(j7);
        } else if (i13 == 13) {
            cVar.b(size);
            cVar.write(S5);
        } else if (i13 == 14) {
            cVar.write(a6);
            cVar.b(size);
        }
        cVar.a(this.h == ByteOrder.BIG_ENDIAN ? o6 : n6);
        cVar.a(this.h);
        cVar.c(42);
        cVar.a(8L);
        for (int i14 = 0; i14 < c7.length; i14++) {
            if (!this.f[i14].isEmpty()) {
                cVar.c(this.f[i14].size());
                int size2 = iArr[i14] + 2 + (this.f[i14].size() * 12) + 4;
                for (Map.Entry<String, d> entry2 : this.f[i14].entrySet()) {
                    int i15 = f7[i14].get(entry2.getKey()).f38517a;
                    d value = entry2.getValue();
                    int iA2 = value.a();
                    cVar.c(i15);
                    cVar.c(value.f38516a);
                    cVar.b(value.b);
                    if (iA2 > 4) {
                        cVar.a(size2);
                        size2 += iA2;
                    } else {
                        cVar.write(value.d);
                        if (iA2 < 4) {
                            while (iA2 < 4) {
                                cVar.a(0);
                                iA2++;
                            }
                        }
                    }
                }
                if (i14 == 0 && !this.f[4].isEmpty()) {
                    cVar.a(iArr[4]);
                } else {
                    cVar.a(0L);
                }
                Iterator<Map.Entry<String, d>> it2 = this.f[i14].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.i) {
            cVar.write(l());
        }
        if (this.d == 14 && size % 2 == 1) {
            cVar.a(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return size;
    }

    public final void a(int i8, int i9) throws Throwable {
        if (!this.f[i8].isEmpty() && !this.f[i9].isEmpty()) {
            d dVar = this.f[i8].get("ImageLength");
            d dVar2 = this.f[i8].get("ImageWidth");
            d dVar3 = this.f[i9].get("ImageLength");
            d dVar4 = this.f[i9].get("ImageWidth");
            if (dVar == null || dVar2 == null) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(v, "First image does not contain valid size information");
                    return;
                }
                return;
            }
            if (dVar3 != null && dVar4 != null) {
                int iB = dVar.b(this.h);
                int iB2 = dVar2.b(this.h);
                int iB3 = dVar3.b(this.h);
                int iB4 = dVar4.b(this.h);
                if (iB >= iB3 || iB2 >= iB4) {
                    return;
                }
                HashMap<String, d>[] mapArr = this.f;
                HashMap<String, d> map = mapArr[i8];
                mapArr[i8] = mapArr[i9];
                mapArr[i9] = map;
                return;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(v, "Second image does not contain valid size information");
                return;
            }
            return;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(v, "Cannot perform swap since only one image data exists");
        }
    }

    public final void a(int i8, String str, String str2) {
        if (this.f[i8].isEmpty() || this.f[i8].get(str) == null) {
            return;
        }
        HashMap<String, d> map = this.f[i8];
        map.put(str2, map.get(str));
        this.f[i8].remove(str);
    }
}
