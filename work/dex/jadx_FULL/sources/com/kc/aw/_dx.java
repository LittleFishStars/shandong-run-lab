package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dx {
    public static final Pattern _d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    public static final Pattern _e = Pattern.compile("GET /(.*) HTTP");
    public final String _a;
    public final long _b;
    public final boolean _c;

    public _dx(String str) {
        _hp._a(str);
        long j_a = _a(str);
        this._b = Math.max(0L, j_a);
        this._c = j_a >= 0;
        this._a = _b(str);
    }

    public static long _a(String str) {
        Matcher matcher = _d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static _dx _a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new _dx(sb.toString());
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    public static String _b(String str) {
        Matcher matcher = _e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("GetRequest{rangeOffset=");
        sb_a.append(this._b);
        sb_a.append(", partial=");
        sb_a.append(this._c);
        sb_a.append(", uri='");
        sb_a.append(this._a);
        sb_a.append('\'');
        sb_a.append('}');
        return sb_a.toString();
    }
}
