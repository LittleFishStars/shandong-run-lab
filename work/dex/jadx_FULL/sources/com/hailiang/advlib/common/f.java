package com.hailiang.advlib.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.dv9;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f32567a = true;
    private static String b;
    private static int c;

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MessageDigest f32568a;

        public a() {
            try {
                this.f32568a = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
        }

        public String a() {
            MessageDigest messageDigest = this.f32568a;
            if (messageDigest == null) {
                return null;
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        }

        public void a(byte[] bArr, int i) {
            MessageDigest messageDigest = this.f32568a;
            if (messageDigest != null) {
                messageDigest.update(bArr, 0, i);
            }
        }
    }

    public static int a(Context context) {
        int i = c;
        if (i > 0) {
            return i;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    int i2 = packageInfo.versionCode;
                    c = i2;
                    return i2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file == null) {
            Log.e("byteMD5", "getFileMd5 cannot proceed null!");
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String strA = a(fileInputStream, 0, -1);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return strA;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String a(InputStream inputStream, int i, int i2) {
        if (inputStream == null) {
            Log.e("byteMD5", "byteMD5 cannot proceed null!");
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            try {
                if (i2 == -1) {
                    while (true) {
                        int i3 = inputStream.read(bArr);
                        if (i3 <= -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i3);
                    }
                } else {
                    while (i2 > 0) {
                        int i4 = i2 < 1024 ? inputStream.read(bArr, 0, i2) : inputStream.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i4);
                        i2 -= i4;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (str2 != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", ze1.g);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.close();
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new IOException("Unexpected response code: " + responseCode);
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                    return string;
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (httpURLConnection == null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z) {
                sb.append('?');
                z = true;
            } else if (z) {
                sb.append(dv9.d);
            }
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                sb.append(key);
                sb.append(com.alipay.sdk.m.p.a.h);
                try {
                    sb.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    sb.append("none");
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void a(boolean z) {
        f32567a = z;
    }

    public static void a(byte[] bArr, int i, int[] iArr) {
        int i2 = iArr[0];
        if (i2 < 512) {
            int iMin = Math.min(i, 512 - i2);
            for (int i3 = 0; i3 < iMin; i3++) {
                bArr[i3] = (byte) (bArr[i3] - 1);
            }
            iArr[0] = iArr[0] + iMin;
        }
    }

    public static boolean a() {
        try {
            Class.forName("androidx.appcompat.app.AppCompatActivity");
            return f32567a;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return j;
            }
            while (i < 512) {
                bArr[i] = (byte) (bArr[i] - 1);
                i++;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    b = str;
                    return str;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String c(Context context) {
        try {
            return (String) d.g(ProcessUtils.ACTIVITY_THREAD).b(TRiverConstants.KEY_CURRENT_PROCESS_NAME).c();
        } catch (Throwable unused) {
            return null;
        }
    }
}
