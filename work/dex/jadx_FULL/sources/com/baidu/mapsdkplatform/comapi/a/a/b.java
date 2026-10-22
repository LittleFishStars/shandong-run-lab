package com.baidu.mapsdkplatform.comapi.a.a;

import android.content.Context;
import android.os.Build;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.fl.saas.common.crash.CrashHandler;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f26679a = "";
    private static String b = "";
    private static String c = "";
    private Context d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles;
            if (e.b().a() == null) {
                return;
            }
            File file = new File(b.f26679a);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
                return;
            }
            try {
                Arrays.sort(fileArrListFiles, new c());
            } catch (Exception unused) {
            }
            int length = fileArrListFiles.length;
            if (length > 10) {
                length = 10;
            }
            for (int i = 0; i < length; i++) {
                File file2 = fileArrListFiles[i];
                if (!file2.isDirectory() && file2.exists() && file2.isFile() && file2.getName().contains(b.b)) {
                    if (file2.getName().endsWith(CrashHandler.FILE_NAME_SUFFIX)) {
                        b.this.b(file2);
                    } else if (file2.getName().endsWith(".zip") && file2.exists()) {
                        b.this.b(file2);
                    }
                }
            }
            if (fileArrListFiles.length > 10) {
                b.this.a(fileArrListFiles);
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.a.a.b$b, reason: collision with other inner class name */
    public static final class C0273b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f26681a = new b();
    }

    public static b c() {
        return C0273b.f26681a;
    }

    private void d() {
        File filesDir;
        Context context = this.d;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return;
        }
        String path = filesDir.getPath();
        if (path.isEmpty()) {
            return;
        }
        String str = path + File.separator + "crash";
        File file = new File(str);
        if (file.exists()) {
            f26679a = str;
        } else if (file.mkdir()) {
            f26679a = str;
        } else {
            f26679a = path;
        }
    }

    private HttpURLConnection e() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setConnectTimeout(10000);
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    private void f() {
        String str;
        String str2 = f26679a;
        if (str2 == null || str2.isEmpty() || (str = b) == null || str.isEmpty()) {
            return;
        }
        String str3 = f26679a + File.separator + b;
        com.baidu.mapsdkplatform.comapi.a.a.a.a().a(str3);
        JNIHandler.registerNativeHandler(str3);
    }

    private void g() {
        if (NetworkUtil.isNetworkAvailable(this.d)) {
            new Thread(new a()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[Catch: all -> 0x000f, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x000f, blocks: (B:7:0x000b, B:42:0x00ef, B:45:0x00f6, B:46:0x00fc, B:60:0x0112, B:63:0x0119, B:65:0x0121, B:66:0x0124, B:70:0x012a, B:73:0x0131, B:75:0x0139), top: B:106:0x0003 }] */
    public synchronized boolean b(File file) {
        HttpURLConnection httpURLConnectionE;
        OutputStream outputStream;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader = null;
        bufferedReader2 = null;
        InputStream inputStream2 = null;
        bufferedReader = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                httpURLConnectionE = e();
                if (httpURLConnectionE == null) {
                    if (httpURLConnectionE != null) {
                        try {
                            httpURLConnectionE.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                try {
                    httpURLConnectionE.connect();
                    outputStream = httpURLConnectionE.getOutputStream();
                    try {
                        outputStream.write(a(a(file).toString().getBytes()));
                        outputStream.write(a(("--bd_map_sdk_cc\r\nContent-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n\r\n").getBytes()));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = dataInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (inputStream != null && bufferedReader3 != null) {
                                try {
                                    inputStream.close();
                                    bufferedReader3.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (httpURLConnectionE != null) {
                                try {
                                    httpURLConnectionE.disconnect();
                                } catch (Exception unused4) {
                                }
                            }
                            return false;
                        }
                        outputStream.write(a(byteArrayOutputStream.toByteArray()));
                        dataInputStream.close();
                        byteArrayOutputStream.close();
                        outputStream.write(a("\r\n--bd_map_sdk_cc--\r\n".getBytes()));
                        outputStream.flush();
                        if (httpURLConnectionE.getResponseCode() == 200) {
                            inputStream = httpURLConnectionE.getInputStream();
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                try {
                                    try {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (true) {
                                            int i2 = bufferedReader.read();
                                            if (i2 == -1) {
                                                break;
                                            }
                                            stringBuffer.append((char) i2);
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                                            if (jSONObject.has("status") && jSONObject.getInt("status") == 0 && file.exists()) {
                                                file.delete();
                                            }
                                        } catch (Exception unused5) {
                                        }
                                        inputStream2 = inputStream;
                                    } catch (Exception unused6) {
                                        bufferedReader3 = bufferedReader;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused7) {
                                        }
                                    }
                                    if (inputStream != null && bufferedReader2 != null) {
                                        try {
                                            inputStream.close();
                                            bufferedReader2.close();
                                        } catch (Exception unused8) {
                                        }
                                    }
                                    if (httpURLConnectionE != null) {
                                        throw th;
                                    }
                                    try {
                                        httpURLConnectionE.disconnect();
                                        throw th;
                                    } catch (Exception unused9) {
                                        throw th;
                                    }
                                }
                            } catch (Exception unused10) {
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            bufferedReader = null;
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused11) {
                        }
                        if (inputStream2 != null && bufferedReader != null) {
                            try {
                                inputStream2.close();
                                bufferedReader.close();
                            } catch (Exception unused12) {
                            }
                        }
                        try {
                            httpURLConnectionE.disconnect();
                        } catch (Exception unused13) {
                        }
                        return true;
                    } catch (Exception unused14) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (Exception unused15) {
                    outputStream = null;
                    inputStream = outputStream;
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    inputStream = outputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        bufferedReader2.close();
                    }
                    if (httpURLConnectionE != null) {
                        throw th;
                    }
                    httpURLConnectionE.disconnect();
                    throw th;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        } catch (Exception unused16) {
            httpURLConnectionE = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnectionE = null;
            outputStream = null;
        }
    }

    public void a(Context context) {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            c = strArr[0];
        }
        this.d = context;
        String strG = f.g();
        if (strG.isEmpty()) {
            return;
        }
        if (strG.contains(LoginConstants.UNDER_LINE)) {
            strG = strG.replaceAll(LoginConstants.UNDER_LINE, "");
        }
        b = strG + LoginConstants.UNDER_LINE + f.n() + LoginConstants.UNDER_LINE;
        d();
        f();
        g();
    }

    public void a(String str, String str2) {
        JNIHandler.addLog(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length - 10; i++) {
            int i2 = i + 10;
            File file = fileArr[i2];
            if (file != null && file.exists()) {
                fileArr[i2].delete();
            }
        }
    }

    private StringBuilder a(File file) {
        String[] strArrSplit = file.getName().substring(0, file.getName().length() - 4).split(LoginConstants.UNDER_LINE);
        StringBuilder sb = new StringBuilder();
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
        sb.append("\r\n");
        sb.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + c));
        sb.append("\r\n");
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        String str = strArrSplit[0];
        if (str != null && !str.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"packname\"\r\n");
            sb.append("\r\n");
            sb.append(strArrSplit[0]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        String str2 = strArrSplit[1];
        if (str2 != null && !str2.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"version\"\r\n");
            sb.append("\r\n");
            sb.append(strArrSplit[1]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        String str3 = strArrSplit[2];
        if (str3 != null && !str3.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
            sb.append("\r\n");
            sb.append(strArrSplit[2]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        sb.append("Content-Disposition: form-data; name=\"os\"\r\n");
        sb.append("\r\n");
        sb.append("android");
        sb.append("\r\n");
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        return sb;
    }

    private byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        a(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }
}
