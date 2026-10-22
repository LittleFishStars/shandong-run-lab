package com.ipd.dsp.internal.v0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {
    public static final Pattern d = Pattern.compile("GET /(.*) HTTP");
    public static final Pattern e = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38563a;
    public final long b;
    public final boolean c;

    public d(String str) {
        long jA = a(str);
        this.b = Math.max(0L, jA);
        this.c = jA >= 0;
        this.f38563a = b(str);
    }

    public static d a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new d(sb.toString());
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    public final String b(String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    @NonNull
    public String toString() {
        return "GetRequest{uri='" + this.f38563a + "', rangeOffset=" + this.b + ", partial=" + this.c + '}';
    }

    public final long a(String str) {
        String strGroup;
        Matcher matcher = e.matcher(str);
        if (!matcher.find() || (strGroup = matcher.group(1)) == null) {
            return -1L;
        }
        return Long.parseLong(strGroup);
    }
}
