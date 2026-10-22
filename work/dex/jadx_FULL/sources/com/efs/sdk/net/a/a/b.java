package com.efs.sdk.net.a.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, Long> f29908a = new HashMap();

    public static long a(f.b bVar) {
        try {
            byte[] bArrD = bVar.d();
            if (bArrD != null) {
                return bArrD.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(str);
        cVarA.j = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains("json")) {
                ByteArrayOutputStream byteArrayOutputStreamA = a(inputStream, cVarA, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                try {
                    byteArrayOutputStreamA.close();
                } catch (IOException e) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e)));
                }
                return byteArrayInputStream;
            }
        }
        cVarA.m = 0L;
        return inputStream;
    }

    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.c cVar, String str) {
        BufferedReader bufferedReader;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e)));
            }
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if ("gzip".equals(str)) {
            bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line + '\n');
        }
        String string = sb.toString();
        try {
            if (NetManager.getNetConfigManager().getNetResponseBodyCollectState() && string.getBytes().length < 10240 && (cVar.j.contains(ze1.g) || cVar.j.contains("application/x-www-form-urlencoded") || cVar.j.contains("text/plain"))) {
                cVar.k = string;
            }
        } catch (Throwable unused) {
        }
        cVar.m = string.getBytes().length;
        return byteArrayOutputStream;
    }
}
