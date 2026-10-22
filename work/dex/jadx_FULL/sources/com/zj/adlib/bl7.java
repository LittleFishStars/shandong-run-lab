package com.zj.adlib;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.VisibleForTesting;
import com.alipay.sdk.m.y.l;
import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bl7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f15565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f15566a;

    public bl7(long j, int i, Uri uri) {
        this.f15565a = j;
        this.f40775a = i;
        this.f15566a = uri;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    public static ImmutableList<bl7> a(String str, Uri uri) throws ParserException {
        byte b;
        ImmutableList.a aVar = new ImmutableList.a();
        String[] strArrU1 = gj9.u1(str, ",");
        int length = strArrU1.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArrU1[i2];
            String[] strArrU2 = gj9.u1(str2, l.b);
            int length2 = strArrU2.length;
            int i3 = i;
            Uri uriB = null;
            int i4 = -1;
            long j = -9223372036854775807L;
            while (i3 < length2) {
                String str3 = strArrU2[i3];
                try {
                    String[] strArrV1 = gj9.v1(str3, "=");
                    String str4 = strArrV1[i];
                    String str5 = strArrV1[1];
                    int iHashCode = str4.hashCode();
                    String[] strArr = strArrU1;
                    if (iHashCode != 113759) {
                        if (iHashCode != 116079) {
                            if (iHashCode == 1524180539 && str4.equals("rtptime")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str4.equals("url")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (str4.equals("seq")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        uriB = b(str5, uri);
                    } else if (b == 1) {
                        i4 = Integer.parseInt(str5);
                    } else {
                        if (b != 2) {
                            throw ParserException.createForMalformedManifest(str4, null);
                        }
                        j = Long.parseLong(str5);
                    }
                    i3++;
                    strArrU1 = strArr;
                    i = 0;
                } catch (Exception e) {
                    throw ParserException.createForMalformedManifest(str3, e);
                }
            }
            String[] strArr2 = strArrU1;
            if (uriB != null && uriB.getScheme() != null) {
                long j2 = j;
                if (i4 != -1 || j2 != -9223372036854775807L) {
                    aVar.a(new bl7(j2, i4, uriB));
                    i2++;
                    strArrU1 = strArr2;
                    i = 0;
                }
            }
            throw ParserException.createForMalformedManifest(str2, null);
        }
        return aVar.e();
    }

    @VisibleForTesting
    public static Uri b(String str, Uri uri) {
        sb0.a(((String) sb0.g(uri.getScheme())).equals("rtsp"));
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        Uri uri3 = Uri.parse("rtsp://" + str);
        String string = uri.toString();
        if (((String) sb0.g(uri3.getHost())).equals(uri.getHost())) {
            return uri3;
        }
        if (string.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            return rh9.f(string, str);
        }
        return rh9.f(string + WVNativeCallbackUtil.SEPERATER, str);
    }
}
