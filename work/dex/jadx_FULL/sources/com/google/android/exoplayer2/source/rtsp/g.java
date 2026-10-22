package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import com.zj.adlib.zk7;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30975a = 60000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4413a = "RTSP/1.0";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f4414a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f4415b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Pattern f4416c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);
    public static final Pattern d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");
    public static final Pattern e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");
    public static final Pattern f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");
    public static final String b = new String(new byte[]{10});
    public static final String c = new String(new byte[]{13, 10});

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30976a;
        public final String b;

        public a(String str, String str2) {
            this.f30976a = str;
            this.b = str2;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30977a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4417a;

        public b(String str, long j) {
            this.f4417a = str;
            this.f30977a = j;
        }
    }

    public static void a(boolean z, @Nullable String str) throws ParserException {
        if (!z) {
            throw ParserException.createForMalformedManifest(str, null);
        }
    }

    public static byte[] b(List<String> list) {
        return com.google.common.base.d.p(c).k(list).getBytes(RtspMessageChannel.b);
    }

    public static String c(int i) {
        if (i == 200) {
            return "OK";
        }
        if (i == 461) {
            return "Unsupported Transport";
        }
        if (i == 500) {
            return "Internal Server Error";
        }
        if (i == 505) {
            return "RTSP Version Not Supported";
        }
        if (i == 301) {
            return "Move Permanently";
        }
        if (i == 302) {
            return "Move Temporarily";
        }
        if (i == 400) {
            return "Bad Request";
        }
        if (i == 401) {
            return "Unauthorized";
        }
        if (i == 404) {
            return "Not Found";
        }
        if (i == 405) {
            return "Method Not Allowed";
        }
        switch (i) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME /* 454 */:
                return "Session Not Found";
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME /* 455 */:
                return "Method Not Valid In This State";
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME /* 456 */:
                return "Header Field Not Valid";
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME /* 457 */:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] d(String str) {
        return str.getBytes(RtspMessageChannel.b);
    }

    public static boolean e(List<String> list) {
        return f4415b.matcher(list.get(0)).matches();
    }

    public static boolean f(String str) {
        return f4414a.matcher(str).matches() || f4415b.matcher(str).matches();
    }

    public static long g(String str) throws ParserException {
        try {
            Matcher matcher = f4416c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) sb0.g(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e2) {
            throw ParserException.createForMalformedManifest(str, e2);
        }
    }

    public static int h(String str) throws ParserException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw ParserException.createForMalformedManifest(str, e2);
        }
    }

    public static int i(String str) {
        str.hashCode();
        switch (str) {
            case "RECORD":
                return 8;
            case "TEARDOWN":
                return 12;
            case "GET_PARAMETER":
                return 3;
            case "OPTIONS":
                return 4;
            case "PLAY_NOTIFY":
                return 7;
            case "PLAY":
                return 6;
            case "REDIRECT":
                return 9;
            case "SET_PARAMETER":
                return 11;
            case "PAUSE":
                return 5;
            case "SETUP":
                return 10;
            case "ANNOUNCE":
                return 1;
            case "DESCRIBE":
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ImmutableList<Integer> j(@Nullable String str) {
        if (str == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        for (String str2 : gj9.u1(str, ",\\s?")) {
            aVar.a(Integer.valueOf(i(str2)));
        }
        return aVar.e();
    }

    public static RtspRequest k(List<String> list) {
        Matcher matcher = f4414a.matcher(list.get(0));
        sb0.a(matcher.matches());
        int i = i((String) sb0.g(matcher.group(1)));
        Uri uri = Uri.parse((String) sb0.g(matcher.group(2)));
        int iIndexOf = list.indexOf("");
        sb0.a(iIndexOf > 0);
        return new RtspRequest(uri, i, new d.b().c(list.subList(1, iIndexOf)).e(), com.google.common.base.d.p(c).k(list.subList(iIndexOf + 1, list.size())));
    }

    public static zk7 l(List<String> list) {
        Matcher matcher = f4415b.matcher(list.get(0));
        sb0.a(matcher.matches());
        int i = Integer.parseInt((String) sb0.g(matcher.group(1)));
        int iIndexOf = list.indexOf("");
        sb0.a(iIndexOf > 0);
        return new zk7(i, new d.b().c(list.subList(1, iIndexOf)).e(), com.google.common.base.d.p(c).k(list.subList(iIndexOf + 1, list.size())));
    }

    public static b m(String str) throws ParserException {
        long j;
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedManifest(str, null);
        }
        String str2 = (String) sb0.g(matcher.group(1));
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            try {
                j = ((long) Integer.parseInt(strGroup)) * 1000;
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedManifest(str, e2);
            }
        } else {
            j = 60000;
        }
        return new b(str2, j);
    }

    @Nullable
    public static a n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(u15.f19942b)) {
            return null;
        }
        String[] strArrV1 = gj9.v1(userInfo, u15.f19942b);
        return new a(strArrV1[0], strArrV1[1]);
    }

    public static c o(String str) throws ParserException {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return new c(2, (String) sb0.g(matcher.group(1)), (String) sb0.g(matcher.group(3)), com.google.common.base.l.g(matcher.group(4)));
        }
        Matcher matcher2 = f.matcher(str);
        if (matcher2.matches()) {
            return new c(1, (String) sb0.g(matcher2.group(1)), "", "");
        }
        throw ParserException.createForMalformedManifest("Invalid WWW-Authenticate header " + str, null);
    }

    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) sb0.g(uri.getAuthority());
        sb0.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(gj9.u1(str, "@")[1]).build();
    }

    public static ImmutableList<String> q(RtspRequest rtspRequest) {
        sb0.a(rtspRequest.f4390a.e(d.n) != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(gj9.H("%s %s %s", t(rtspRequest.f30967a), rtspRequest.f4389a, f4413a));
        ImmutableListMultimap<String, String> immutableListMultimapB = rtspRequest.f4390a.b();
        UnmodifiableIterator<String> it = immutableListMultimapB.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            ImmutableList<String> immutableList = immutableListMultimapB.get(next);
            for (int i = 0; i < immutableList.size(); i++) {
                aVar.a(gj9.H("%s: %s", next, immutableList.get(i)));
            }
        }
        aVar.a("");
        aVar.a(rtspRequest.f4391a);
        return aVar.e();
    }

    public static ImmutableList<String> r(zk7 zk7Var) {
        sb0.a(zk7Var.f21081a.e(d.n) != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(gj9.H("%s %s %s", f4413a, Integer.valueOf(zk7Var.f46283a), c(zk7Var.f46283a)));
        ImmutableListMultimap<String, String> immutableListMultimapB = zk7Var.f21081a.b();
        UnmodifiableIterator<String> it = immutableListMultimapB.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            ImmutableList<String> immutableList = immutableListMultimapB.get(next);
            for (int i = 0; i < immutableList.size(); i++) {
                aVar.a(gj9.H("%s: %s", next, immutableList.get(i)));
            }
        }
        aVar.a("");
        aVar.a(zk7Var.f21082a);
        return aVar.e();
    }

    public static String[] s(String str) {
        String str2 = c;
        if (!str.contains(str2)) {
            str2 = b;
        }
        return gj9.u1(str, str2);
    }

    public static String t(int i) {
        switch (i) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
