package com.byazt.xy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2098, 20})
public class c implements uj {
    public final HttpURLConnection c;

    public c(HttpURLConnection httpURLConnection) {
        this.c = httpURLConnection;
    }

    @Override // com.byazt.xy.uj
    public boolean c() {
        try {
            return this.c.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.disconnect();
    }

    @Override // com.byazt.xy.uj
    public InputStream tt() throws IOException {
        return this.c.getInputStream();
    }

    @Override // com.byazt.xy.uj
    public String uj() {
        try {
            if (c()) {
                return null;
            }
            return "Unable to fetch " + this.c.getURL() + ". Failed with " + this.c.getResponseCode() + "\n" + c(this.c);
        } catch (IOException e) {
            com.byazt.kk.a.c("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // com.byazt.xy.uj
    public String ve() {
        return this.c.getContentType();
    }

    private String c(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
