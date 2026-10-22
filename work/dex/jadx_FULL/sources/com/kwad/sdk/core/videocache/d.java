package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.az;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class d {
    private static final Pattern aZR = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aZS = Pattern.compile("GET /(.*) HTTP");
    public final long aZT;
    public final boolean aZU;
    public final String uri;

    private d(String str) {
        az.hY(str);
        long jFv = fv(str);
        this.aZT = Math.max(0L, jFv);
        this.aZU = jFv >= 0;
        this.uri = fw(str);
    }

    public static d b(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new d(sb.toString());
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    private static long fv(String str) {
        Matcher matcher = aZR.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String fw(String str) {
        Matcher matcher = aZS.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aZT + ", partial=" + this.aZU + ", uri='" + this.uri + "'}";
    }
}
