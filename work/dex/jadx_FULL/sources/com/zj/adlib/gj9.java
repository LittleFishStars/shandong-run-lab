package com.zj.adlib;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AudioStats;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.a;
import com.google.common.base.b;
import com.google.common.collect.ImmutableList;
import com.google.common.math.c;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gj9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static HashMap<String, String> f16788a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f16789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f16790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f16791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f16792a;
    public static final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f16793b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f16794b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String[] f16795b;
    public static final String c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Pattern f16796c;
    public static final String d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final Pattern f16797d;
    public static final String e = "Util";
    public static final String f = "format=m3u8-aapl";
    public static final String g = "format=mpd-time-csf";

    static {
        int i = Build.VERSION.SDK_INT;
        f41922a = i;
        String str = Build.DEVICE;
        f16787a = str;
        String str2 = Build.MANUFACTURER;
        b = str2;
        String str3 = Build.MODEL;
        c = str3;
        d = str + ", " + str3 + ", " + str2 + ", " + i;
        f16790a = new byte[0];
        f16789a = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f16793b = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f16796c = Pattern.compile("%([A-Fa-f0-9]{2})");
        f16797d = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f16792a = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", t.n, "fre", "fr", "geo", "ka", "ice", p3.g, "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", RVParams.SHOW_REPORT_BTN, "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f16795b = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f16791a = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f16794b = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, MatroskaExtractor.T, 233, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 251, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 216, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, go6.g, 209, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 213, 210, 255, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 241, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 227, 228, 237, 234, 183, 176, 185, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 184, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, c.f6376a, 163, 164, 249, 254, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 240, 229, 226, 235, 236, 193, 198, 207, 200, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 204, 203, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 225, 232, 239, 250, 253, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE};
    }

    public static Handler A() {
        return B(null);
    }

    public static byte[] A0(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean A1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static Handler B(@Nullable Handler.Callback callback) {
        return x(Y(), callback);
    }

    public static int B0(Uri uri) {
        int iE0;
        String scheme = uri.getScheme();
        if (scheme != null && a.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iE0 = E0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iE0;
        }
        Matcher matcher = f16797d.matcher((CharSequence) sb0.g(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains(g)) {
                return 0;
            }
            if (strGroup.contains(f)) {
                return 2;
            }
        }
        return 1;
    }

    public static byte[] B1(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static HashMap<String, String> C() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> map = new HashMap<>(iSOLanguages.length + f16792a.length);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f16792a;
            if (i >= strArr.length) {
                return map;
            }
            map.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    @Deprecated
    public static int C0(Uri uri, @Nullable String str) {
        return TextUtils.isEmpty(str) ? B0(uri) : E0(str);
    }

    public static String C1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i] & a.q, 16));
        }
        return sb.toString();
    }

    public static File D(Context context, String str) throws IOException {
        File fileE = E(context, str);
        fileE.delete();
        fileE.mkdir();
        return fileE;
    }

    @Deprecated
    public static int D0(String str) {
        return B0(Uri.parse("file:///" + str));
    }

    public static long D1(int i, int i2) {
        return E1(i2) | (E1(i) << 32);
    }

    public static File E(Context context, String str) throws IOException {
        return File.createTempFile(str, null, (File) sb0.g(context.getCacheDir()));
    }

    public static int E0(String str) {
        String strG = a.g(str);
        strG.hashCode();
        switch (strG) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static long E1(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String F(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (r1(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) + length);
        while (i2 > 0) {
            int i4 = i + 1;
            char cCharAt = str.charAt(i);
            if (r1(cCharAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(cCharAt));
                i2--;
            } else {
                sb.append(cCharAt);
            }
            i = i4;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        return sb.toString();
    }

    public static int F0(Uri uri, @Nullable String str) {
        if (str == null) {
            return B0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static CharSequence F1(CharSequence charSequence, int i) {
        return charSequence.length() <= i ? charSequence : charSequence.subSequence(0, i);
    }

    public static Uri G(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f16797d.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static boolean G0(om6 om6Var, om6 om6Var2, @Nullable Inflater inflater) {
        if (om6Var.a() <= 0) {
            return false;
        }
        if (om6Var2.b() < om6Var.a()) {
            om6Var2.c(om6Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(om6Var.d(), om6Var.e(), om6Var.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(om6Var2.d(), iInflate, om6Var2.b() - iInflate);
                if (inflater.finished()) {
                    om6Var2.R(iInflate);
                    inflater.reset();
                    return true;
                }
                if (!inflater.needsDictionary() && !inflater.needsInput()) {
                    if (iInflate == om6Var2.b()) {
                        om6Var2.c(om6Var2.b() * 2);
                    }
                }
                inflater.reset();
                return false;
            } catch (DataFormatException unused) {
                inflater.reset();
                return false;
            } catch (Throwable th) {
                inflater.reset();
                throw th;
            }
        }
    }

    @Nullable
    public static String G1(String str) {
        int length = str.length();
        int iEnd = 0;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '%') {
                i++;
            }
        }
        if (i == 0) {
            return str;
        }
        int i3 = length - (i * 2);
        StringBuilder sb = new StringBuilder(i3);
        Matcher matcher = f16796c.matcher(str);
        while (i > 0 && matcher.find()) {
            char c2 = (char) Integer.parseInt((String) sb0.g(matcher.group(1)), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            i--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i3) {
            return null;
        }
        return sb.toString();
    }

    public static String H(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean H0(Context context) {
        return f41922a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static long H1(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static String I(byte[] bArr) {
        return new String(bArr, b.c);
    }

    public static boolean I0(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static void I1(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String J(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, b.c);
    }

    public static boolean J0(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    @RequiresApi(21)
    public static int K(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static boolean K0(int i) {
        return i == 10 || i == 13;
    }

    @Nullable
    public static String L(int i) {
        if (i == 0) {
            return "application/dash+xml";
        }
        if (i == 1) {
            return "application/vnd.ms-sstr+xml";
        }
        if (i != 2) {
            return null;
        }
        return "application/x-mpegURL";
    }

    public static boolean L0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static int M(int i) {
        if (i != 0) {
            return (i == 1 || i == 2 || i == 4 || i == 5 || i == 8) ? 4 : 2;
        }
        return 1;
    }

    public static boolean M0(Uri uri) {
        if (!"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return false;
        }
        String str = pathSegments.get(0);
        return "external".equals(str) || "external_primary".equals(str);
    }

    public static int N(int i) {
        if (i == 12) {
            return f41922a >= 32 ? 743676 : 0;
        }
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM;
            case 6:
                return MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            case 7:
                return 1276;
            case 8:
                int i2 = f41922a;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    @RequiresApi(api = 24)
    public static boolean N0(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) sb0.g(uri.getHost()));
    }

    public static int O(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 1) {
            return 13;
        }
        if (i == 2) {
            return 6;
        }
        int i2 = 4;
        if (i != 4) {
            i2 = 5;
            if (i != 5) {
                return i != 8 ? 1 : 3;
            }
        }
        return i2;
    }

    public static boolean O0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Player.b P(Player player, Player.b bVar) {
        boolean zIsPlayingAd = player.isPlayingAd();
        boolean zIsCurrentMediaItemSeekable = player.isCurrentMediaItemSeekable();
        boolean zHasPreviousMediaItem = player.hasPreviousMediaItem();
        boolean zHasNextMediaItem = player.hasNextMediaItem();
        boolean zIsCurrentMediaItemLive = player.isCurrentMediaItemLive();
        boolean zIsCurrentMediaItemDynamic = player.isCurrentMediaItemDynamic();
        boolean zW = player.a0().w();
        boolean z = false;
        Player.b.a aVarE = new Player.b.a().b(bVar).e(4, !zIsPlayingAd).e(5, zIsCurrentMediaItemSeekable && !zIsPlayingAd).e(6, zHasPreviousMediaItem && !zIsPlayingAd).e(7, !zW && (zHasPreviousMediaItem || !zIsCurrentMediaItemLive || zIsCurrentMediaItemSeekable) && !zIsPlayingAd).e(8, zHasNextMediaItem && !zIsPlayingAd).e(9, !zW && (zHasNextMediaItem || (zIsCurrentMediaItemLive && zIsCurrentMediaItemDynamic)) && !zIsPlayingAd).e(10, !zIsPlayingAd).e(11, zIsCurrentMediaItemSeekable && !zIsPlayingAd);
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            z = true;
        }
        return aVarE.e(12, z).f();
    }

    public static /* synthetic */ Thread P0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int Q(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static int Q0(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static byte[] R(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static int R0(long[] jArr, long j) {
        for (int i = 0; i < jArr.length; i++) {
            if (jArr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    public static int S(@Nullable String str, int i) {
        int i2 = 0;
        for (String str2 : w1(str)) {
            if (i == bp5.n(str2)) {
                i2++;
            }
        }
        return i2;
    }

    @RequiresApi(18)
    public static long S0(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            throw new NoSuchElementException();
        }
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < sparseLongArray.size(); i++) {
            jMax = Math.max(jMax, sparseLongArray.valueAt(i));
        }
        return jMax;
    }

    @Nullable
    public static String T(@Nullable String str, int i) {
        String[] strArrW1 = w1(str);
        if (strArrW1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrW1) {
            if (i == bp5.n(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String T0(String str) {
        int i = 0;
        while (true) {
            String[] strArr = f16795b;
            if (i >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i])) {
                return strArr[i + 1] + str.substring(strArr[i].length());
            }
            i += 2;
        }
    }

    public static String U(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static boolean U0(Activity activity, Uri uri) {
        return f41922a >= 23 && (L0(uri) || M0(uri)) && n1(activity);
    }

    public static String V(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return a.j(networkCountryIso);
            }
        }
        return a.j(Locale.getDefault().getCountry());
    }

    public static boolean V0(Activity activity, Uri... uriArr) {
        if (f41922a < 23) {
            return false;
        }
        for (Uri uri : uriArr) {
            if (U0(activity, uri)) {
                return true;
            }
        }
        return false;
    }

    public static Point W(Context context) {
        DisplayManager displayManager;
        Display display = (f41922a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) sb0.g((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return X(context, display);
    }

    public static boolean W0(Activity activity, g... gVarArr) {
        if (f41922a < 23) {
            return false;
        }
        for (g gVar : gVarArr) {
            g.h hVar = gVar.f3327a;
            if (hVar != null) {
                if (U0(activity, hVar.f30751a)) {
                    return true;
                }
                ImmutableList<g.l> immutableList = gVar.f3327a.f3369a;
                for (int i = 0; i < immutableList.size(); i++) {
                    if (U0(activity, immutableList.get(i).f3379a)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Point X(Context context, Display display) {
        if (display.getDisplayId() == 0 && O0(context)) {
            String strW0 = f41922a < 28 ? w0("sys.display-size") : w0("vendor.display-size");
            if (!TextUtils.isEmpty(strW0)) {
                try {
                    String[] strArrU1 = u1(strW0.trim(), "x");
                    if (strArrU1.length == 2) {
                        int i = Integer.parseInt(strArrU1[0]);
                        int i2 = Integer.parseInt(strArrU1[1]);
                        if (i > 0 && i2 > 0) {
                            return new Point(i, i2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.d(e, "Invalid display size: " + strW0);
            }
            if ("Sony".equals(b) && c.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(sd6.b, 2160);
            }
        }
        Point point = new Point();
        int i3 = f41922a;
        if (i3 >= 23) {
            d0(display, point);
        } else if (i3 >= 17) {
            c0(display, point);
        } else {
            b0(display, point);
        }
        return point;
    }

    @RequiresApi(18)
    public static long X0(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            throw new NoSuchElementException();
        }
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < sparseLongArray.size(); i++) {
            jMin = Math.min(jMin, sparseLongArray.valueAt(i));
        }
        return jMin;
    }

    public static Looper Y() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static <T> void Y0(List<T> list, int i, int i2, int i3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i4 = (i2 - i) - 1; i4 >= 0; i4--) {
            arrayDeque.addFirst(list.remove(i + i4));
        }
        list.addAll(Math.min(i3, list.size()), arrayDeque);
    }

    public static Uri Z(String str, String str2) {
        return Uri.parse("data:" + str + ";base64," + Base64.encodeToString(str2.getBytes(), 2));
    }

    public static long Z0(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static Locale a0() {
        return f41922a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    public static ExecutorService a1(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.zj.adlib.bj9
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return gj9.P0(str, runnable);
            }
        });
    }

    public static long b(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    public static void b0(Display display, Point point) {
        display.getSize(point);
    }

    public static String b1(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strG = a.g(str);
        String str2 = v1(strG, c49.f40900a)[0];
        if (f16788a == null) {
            f16788a = C();
        }
        String str3 = f16788a.get(str2);
        if (str3 != null) {
            strG = str3 + strG.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? T0(strG) : strG;
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @RequiresApi(17)
    public static void c0(Display display, Point point) {
        display.getRealSize(point);
    }

    public static <T> T[] c1(T[] tArr, T t) {
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length + 1);
        objArrCopyOf[tArr.length] = t;
        return (T[]) l(objArrCopyOf);
    }

    public static <T extends Comparable<? super T>> int d(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int iBinarySearch = Collections.binarySearch(list, t);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t) == 0);
            i = z ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? Math.min(list.size() - 1, i) : i;
    }

    @RequiresApi(23)
    public static void d0(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static <T> T[] d1(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static int e(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(iArr, i);
        if (iBinarySearch < 0) {
            i2 = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= iArr.length) {
                    break;
                }
            } while (iArr[iBinarySearch] == i);
            i2 = z ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? Math.min(iArr.length - 1, i2) : i2;
    }

    @Nullable
    public static UUID e0(String str) {
        String strG = a.g(str);
        strG.hashCode();
        switch (strG) {
            case "playready":
                return C.f2008e;
            case "widevine":
                return C.f2005d;
            case "clearkey":
                return C.f2002c;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static <T> T[] e1(T[] tArr, int i) {
        sb0.a(i <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static int f(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j);
            i = z ? iBinarySearch - 1 : iBinarySearch;
        }
        return z2 ? Math.min(jArr.length - 1, i) : i;
    }

    public static int f0(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return 6003;
        }
        switch (i) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static <T> T[] f1(T[] tArr, int i, int i2) {
        sb0.a(i >= 0);
        sb0.a(i2 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i, i2);
    }

    public static int g(q25 q25Var, long j, boolean z, boolean z2) {
        int i;
        int iC = q25Var.c() - 1;
        int i2 = 0;
        while (i2 <= iC) {
            int i3 = (i2 + iC) >>> 1;
            if (q25Var.b(i3) < j) {
                i2 = i3 + 1;
            } else {
                iC = i3 - 1;
            }
        }
        if (z && (i = iC + 1) < q25Var.c() && q25Var.b(i) == j) {
            return i;
        }
        if (z2 && iC == -1) {
            return 0;
        }
        return iC;
    }

    public static int g0(@Nullable String str) {
        String[] strArrU1;
        int length;
        if (str == null || (length = (strArrU1 = u1(str, LoginConstants.UNDER_LINE)).length) < 2) {
            return 0;
        }
        String str2 = strArrU1[length - 1];
        boolean z = length >= 3 && "neg".equals(strArrU1[length - 2]);
        try {
            int i = Integer.parseInt((String) sb0.g(str2));
            return z ? -i : i;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static <T> void g1(List<T> list, T[] tArr) {
        sb0.i(list.size() == tArr.length);
        list.toArray(tArr);
    }

    public static <T extends Comparable<? super T>> int h(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int iBinarySearch = Collections.binarySearch(list, t);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t) == 0);
            i = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static String h0(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long h1(String str) throws ParserException {
        Matcher matcher = f16789a.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedContainer("Invalid date/time format: " + str, null);
        }
        int i = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if (c49.f40900a.equals(matcher.group(11))) {
                i *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i != 0 ? timeInMillis - (((long) i) * 60000) : timeInMillis;
    }

    public static int i(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(iArr, i);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (iArr[iBinarySearch] == i);
            i2 = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    public static int i0(String str) {
        int length = str.length();
        sb0.a(length <= 4);
        int iCharAt = 0;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt << 8) | str.charAt(i);
        }
        return iCharAt;
    }

    public static long i1(String str) {
        Matcher matcher = f16793b.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d3 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d4 = d3 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d5 = d4 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d6 = d5 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d7 = d6 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        if (strGroup6 != null) {
            d2 = Double.parseDouble(strGroup6);
        }
        long j = (long) ((d7 + d2) * 1000.0d);
        return zIsEmpty ? -j : j;
    }

    public static int j(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j);
            i = z ? iBinarySearch + 1 : iBinarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static String j0(Locale locale) {
        return f41922a >= 21 ? k0(locale) : locale.toString();
    }

    public static boolean j1(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T k(@Nullable T t) {
        return t;
    }

    @RequiresApi(21)
    public static String k0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static boolean k1(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] l(T[] tArr) {
        return tArr;
    }

    public static long l0(long j, float f2) {
        return f2 == 1.0f ? j : Math.round(j * ((double) f2));
    }

    public static void l1(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                l1(file2);
            }
        }
        file.delete();
    }

    public static int m(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static long m0(long j) {
        return j == -9223372036854775807L ? System.currentTimeMillis() : j + SystemClock.elapsedRealtime();
    }

    public static <T> void m1(List<T> list, int i, int i2) {
        if (i < 0 || i2 > list.size() || i > i2) {
            throw new IllegalArgumentException();
        }
        if (i != i2) {
            list.subList(i, i2).clear();
        }
    }

    public static long n(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int n0(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    @RequiresApi(api = 23)
    public static boolean n1(Activity activity) {
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    public static boolean o(g... gVarArr) {
        if (f41922a < 24) {
            return true;
        }
        for (g gVar : gVarArr) {
            g.h hVar = gVar.f3327a;
            if (hVar != null) {
                if (N0(hVar.f30751a)) {
                    return false;
                }
                for (int i = 0; i < gVar.f3327a.f3369a.size(); i++) {
                    if (N0(gVar.f3327a.f3369a.get(i).f3379a)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static d o0(int i, int i2, int i3) {
        return new d.b().e0("audio/raw").H(i2).f0(i3).Y(i).E();
    }

    public static long o1(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        return (long) (j * (j2 / j3));
    }

    public static void p(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int p0(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 * 2;
    }

    public static long[] p1(List<Long> list, long j, long j2) {
        int size = list.size();
        long[] jArr = new long[size];
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < size) {
                jArr[i] = list.get(i).longValue() / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d2 = j / j2;
            while (i < size) {
                jArr[i] = (long) (list.get(i).longValue() * d2);
                i++;
            }
        } else {
            long j4 = j / j2;
            while (i < size) {
                jArr[i] = list.get(i).longValue() * j4;
                i++;
            }
        }
        return jArr;
    }

    public static int q(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static long q0(long j, float f2) {
        return f2 == 1.0f ? j : Math.round(j / ((double) f2));
    }

    public static void q1(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
            return;
        }
        if (j2 >= j || j % j2 != 0) {
            double d2 = j / j2;
            while (i < jArr.length) {
                jArr[i] = (long) (jArr[i] * d2);
                i++;
            }
            return;
        }
        long j4 = j / j2;
        while (i < jArr.length) {
            jArr[i] = jArr[i] * j4;
            i++;
        }
    }

    public static float r(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static int r0(int i) {
        if (i == 13) {
            return 1;
        }
        switch (i) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static boolean r1(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static int s(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static String s0(StringBuilder sb, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        String str = j < 0 ? c49.f40900a : "";
        long jAbs = (Math.abs(j) + 500) / 1000;
        long j2 = jAbs % 60;
        long j3 = (jAbs / 60) % 60;
        long j4 = jAbs / 3600;
        sb.setLength(0);
        return j4 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j3), Long.valueOf(j2)).toString();
    }

    public static void s1(Throwable th) throws Throwable {
        t1(th);
    }

    public static long t(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static String[] t0() {
        String[] strArrU0 = u0();
        for (int i = 0; i < strArrU0.length; i++) {
            strArrU0[i] = b1(strArrU0[i]);
        }
        return strArrU0;
    }

    public static <T extends Throwable> void t1(Throwable th) throws Throwable {
        throw th;
    }

    public static boolean u(Object[] objArr, @Nullable Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String[] u0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f41922a >= 24 ? v0(configuration) : new String[]{j0(configuration.locale)};
    }

    public static String[] u1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int v(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = f16791a[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    @RequiresApi(24)
    public static String[] v0(Configuration configuration) {
        return u1(configuration.getLocales().toLanguageTags(), ",");
    }

    public static String[] v1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static int w(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = f16794b[i3 ^ (bArr[i] & 255)];
            i++;
        }
        return i3;
    }

    @Nullable
    public static String w0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class).invoke(cls, str);
        } catch (Exception e2) {
            Log.e(e, "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static String[] w1(@Nullable String str) {
        return TextUtils.isEmpty(str) ? new String[0] : u1(str.trim(), "(\\s*,\\s*)");
    }

    public static Handler x(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static String x0(int i) {
        switch (i) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i < 10000) {
                    return "?";
                }
                return "custom (" + i + ")";
        }
    }

    @Nullable
    public static ComponentName x1(Context context, Intent intent) {
        return f41922a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static Handler y() {
        return z(null);
    }

    public static String y0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + WVNativeCallbackUtil.SEPERATER + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ab3.c;
    }

    public static long y1(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static Handler z(@Nullable Handler.Callback callback) {
        return x((Looper) sb0.k(Looper.myLooper()), callback);
    }

    public static byte[] z0(String str) {
        return str.getBytes(b.c);
    }

    public static long z1(long... jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }
}
