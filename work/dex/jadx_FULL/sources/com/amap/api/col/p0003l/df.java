package com.amap.api.col.p0003l;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.a7b;
import com.zj.adlib.gia;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.q4b;
import com.zj.adlib.qwb;
import com.zj.adlib.zwa;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class df extends db {
    public df() {
        setProxy(q4b.c(gia.f41914a));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    public static String a(String str) {
        String strB = b(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String strA = l4b.a();
        stringBuffer.append("&ts=".concat(String.valueOf(strA)));
        stringBuffer.append("&scode=" + l4b.c(gia.f41914a, strA, strB));
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String[] strArrSplit = str.split("&");
        Arrays.sort(strArrSplit);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(c(str2));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.length() > 1 ? (String) string.subSequence(0, string.length() - 1) : str;
    }

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            a7b.m(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            a7b.m(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003l.hs
    public String getIPV6URL() {
        String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : zwa.y(url);
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", qwb.b);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.5.0", "3dmap"));
        hashtable.put("x-INFO", l4b.b(gia.f41914a));
        hashtable.put(CachedContentIndex.a.e, j4b.j(gia.f41914a));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.hs
    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
