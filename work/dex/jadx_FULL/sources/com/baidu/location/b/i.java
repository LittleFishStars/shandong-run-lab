package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.baidu.location.Jni;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.zj.adlib.u15;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i {
    public static String f = "0";
    private static i j;
    private Handler I;
    private int k = 1;
    private double l = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double r = 3.5d;
    private double s = 3.0d;
    private double t = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private b A = null;
    private boolean B = false;
    private boolean C = false;
    private int D = 0;
    private float E = 0.0f;
    private float F = 0.0f;
    private long G = 0;
    private int H = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f26358a = 0;
    Location b = null;
    Location c = null;
    StringBuilder d = null;
    long e = 0;
    private byte[] J = new byte[4];
    private byte[] K = null;
    private int L = 0;
    private List<Byte> M = null;
    private boolean N = false;
    int g = 0;
    double h = 116.22345545d;
    double i = 40.245667323d;

    public static class a implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private URL f26361a;

        public a(URL url) {
            this.f26361a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f26361a.getHost().equals(str);
        }
    }

    public class b extends com.baidu.location.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26362a = null;

        public b() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.eh = com.baidu.location.e.d.t;
            String strEncode = Jni.encode(this.f26362a);
            this.f26362a = null;
            this.el.put("q", strEncode);
        }

        public void a(String str) {
            this.f26362a = str;
            b(com.baidu.location.e.d.t);
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            String str;
            if (z && (str = this.ej) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("prod", com.baidu.location.e.b.e);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    i.this.e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    private i() {
        this.I = null;
        this.I = new Handler();
    }

    public static i a() {
        if (j == null) {
            j = new i();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file, String str) {
        String string = UUID.randomUUID().toString();
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(com.baidu.location.e.h.k());
            URL url = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Charset", "utf-8");
            httpsURLConnection.setHostnameVerifier(new a(url));
            httpsURLConnection.setRequestProperty("connection", "close");
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string);
            if (file == null || !file.exists()) {
                return "0";
            }
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(string);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: application/octet-stream; charset=utf-8");
            sb.append("\r\n");
            stringBuffer.append(sb.toString());
            stringBuffer.append("\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, i);
            }
            fileInputStream.close();
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(("--" + string + "--\r\n").getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            outputStream.close();
            httpsURLConnection.disconnect();
            int i2 = this.y + 400;
            this.y = i2;
            c(i2);
            return responseCode == 200 ? "1" : "0";
        } catch (MalformedURLException | IOException unused) {
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    private boolean a(String str, Context context) {
        return true;
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    private byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte bNextInt = (byte) new SecureRandom().nextInt(255);
        byte bNextInt2 = (byte) new SecureRandom().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ bNextInt);
            i++;
            i2++;
        }
        bArr[i2] = bNextInt;
        bArr[i2 + 1] = bNextInt2;
        return bArr;
    }

    private String b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void b(int i) {
        byte[] bArrA = a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.M.add(Byte.valueOf(bArrA[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        c(location);
        h();
    }

    private void c() {
        if (this.N) {
            return;
        }
        this.N = true;
        d(com.baidu.location.e.b.e);
        j();
        d();
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.e.g.f26474a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.g.f26474a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (b("%d_%02d_%02d") + u15.f19942b + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.f26358a < this.H || location == null) {
            return;
        }
        if (location.hasSpeed() && location.getSpeed() > this.E) {
            this.E = location.getSpeed();
        }
        try {
            if (this.M == null) {
                this.M = new ArrayList();
                i();
                d(location);
            } else {
                e(location);
            }
        } catch (Exception unused) {
        }
        this.L++;
    }

    private void c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.z = jSONObject.getLong("uptime");
                }
                k();
            } catch (JSONException unused) {
            }
        }
    }

    private void d() {
        String[] strArrSplit = "9.6.4.3".split("\\.");
        int length = strArrSplit.length;
        byte[] bArr = this.J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.J[i] = (byte) (Integer.valueOf(strArrSplit[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.K = a(com.baidu.location.e.b.e + u15.f19942b + com.baidu.location.e.b.a().c);
    }

    private void d(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        if (i > 0) {
            this.M.add((byte) 32);
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (i2 > 0) {
            this.M.add(Byte.valueOf(UnsignedBytes.f32243a));
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
        }
        this.b = location;
    }

    private void d(String str) {
        try {
            File file = new File(com.baidu.location.e.g.f26474a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int i = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int i2 = randomAccessFile.readInt();
                if (i2 < 4096) {
                    byte[] bArr = new byte[i2];
                    randomAccessFile.read(bArr, 0, i2);
                    String str2 = new String(bArr);
                    if (str2.contains(b("%d_%02d_%02d")) && str2.contains(u15.f19942b)) {
                        try {
                            String[] strArrSplit = str2.split(u15.f19942b);
                            if (strArrSplit.length > 1) {
                                this.y = Integer.valueOf(strArrSplit[1]).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                for (int i3 = 1; i3 <= i; i3++) {
                    randomAccessFile.seek(i3 * 2048);
                    int i4 = randomAccessFile.readInt();
                    if (i4 <= 4096) {
                        byte[] bArr2 = new byte[i4];
                        randomAccessFile.read(bArr2, 0, i4);
                        String str3 = new String(bArr2);
                        if (str != null && str3.contains(str)) {
                            c(str3);
                            break;
                        }
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0113 A[PHI: r2
      0x0113: PHI (r2v21 byte) = (r2v18 byte), (r2v30 byte) binds: [B:35:0x0111, B:30:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    private void e(Location location) {
        byte bearing;
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.b.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.b.getLatitude()) * 1000000.0d);
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        char c = longitude > 0 ? (char) 0 : (char) 1;
        int iAbs = Math.abs(longitude);
        char c2 = latitude > 0 ? (char) 0 : (char) 1;
        int iAbs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.c = this.b;
        }
        this.b = location;
        if (this.c != null && location.getTime() > this.c.getTime() && this.b.getTime() - this.c.getTime() < 5000) {
            long time = this.b.getTime() - this.c.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.b.getAltitude(), this.b.getLongitude(), this.c.getLatitude(), this.c.getLongitude(), fArr);
            double speed = ((fArr[0] - (this.c.getSpeed() * time)) * 2.0f) / (time * time);
            if (speed > this.F) {
                this.F = (float) speed;
            }
        }
        this.M.add(Byte.valueOf((byte) (iAbs & 255)));
        this.M.add(Byte.valueOf((byte) ((iAbs & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)));
        this.M.add(Byte.valueOf((byte) (iAbs2 & 255)));
        this.M.add(Byte.valueOf((byte) ((iAbs2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)));
        if (i > 0) {
            bearing = c2 > 0 ? (byte) 96 : (byte) 32;
            if (c > 0) {
                bearing = (byte) (bearing | UnsignedBytes.f32243a);
            }
        } else {
            bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c2 > 0) {
                bearing = (byte) (bearing | SignedBytes.f32242a);
            }
            if (c > 0) {
                bearing = (byte) (bearing | UnsignedBytes.f32243a);
            }
        }
        this.M.add(Byte.valueOf(bearing));
        if (i2 > 0) {
            this.M.add(Byte.valueOf(UnsignedBytes.f32243a));
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            File file = new File(com.baidu.location.e.g.f26474a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.g.f26474a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(2L);
            int i = randomAccessFile2.readInt();
            int i2 = 1;
            while (i2 <= i) {
                randomAccessFile2.seek(i2 * 2048);
                int i3 = randomAccessFile2.readInt();
                byte[] bArr = new byte[i3];
                randomAccessFile2.read(bArr, 0, i3);
                if (new String(bArr).contains(com.baidu.location.e.b.e)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= i) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i2);
            }
            randomAccessFile2.seek(i2 * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #4 {Exception -> 0x005c, blocks: (B:25:0x0054, B:27:0x0059), top: B:35:0x0054 }] */
    private boolean e() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(com.baidu.location.e.h.f() + File.separator + "gflk.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        fileLockTryLock = channel.tryLock();
                    } catch (Exception unused) {
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } catch (Exception unused2) {
                                throw th;
                            }
                        } else if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                    if (fileLockTryLock != null) {
                        fileLockTryLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    randomAccessFile.close();
                } catch (Exception unused3) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        return z;
    }

    private boolean f() {
        if (this.B) {
            if (!this.C) {
                if (this.E >= this.t) {
                    return true;
                }
                this.C = true;
                this.D = 0 + this.p;
                return true;
            }
            if (this.E >= this.t) {
                this.D = 0;
                this.C = false;
                return true;
            }
            int i = this.D + this.p;
            this.D = i;
            if (i <= this.u || System.currentTimeMillis() - this.G > this.v * 1000) {
                return true;
            }
        } else {
            if (this.E >= this.r || this.F >= this.s) {
                this.B = true;
                return true;
            }
            if (this.w == 1 && System.currentTimeMillis() - this.G > this.x * 1000) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.M = null;
        this.e = 0L;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }

    private void h() {
        if (this.e == 0 || System.currentTimeMillis() - this.e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
            return;
        }
        if (this.n == 1 && !f()) {
            g();
            return;
        }
        if (com.baidu.location.e.b.e.equals("com.ubercab.driver")) {
            if (e()) {
                g();
                return;
            }
        } else if (!a(com.baidu.location.e.b.e, com.baidu.location.f.getServiceContext())) {
            g();
            return;
        }
        List<Byte> list = this.M;
        if (list != null) {
            try {
                int size = list.size();
                this.M.set(0, Byte.valueOf((byte) (size & 255)));
                this.M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.M.set(3, Byte.valueOf((byte) (this.L & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.M.get(i).byteValue();
                }
                File file = new File(com.baidu.location.e.h.h(), "baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.exists()) {
                    File file2 = new File(file, "intime.dat");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        new Thread() { // from class: com.baidu.location.b.i.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                i.this.a(new File(com.baidu.location.e.h.h() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
                            }
                        }.start();
                    } catch (Exception unused) {
                    }
                }
                g();
                this.G = System.currentTimeMillis();
            } catch (Exception unused2) {
            }
        }
    }

    private void i() {
        List<Byte> list;
        byte b2;
        this.M.add((byte) 0);
        this.M.add((byte) 0);
        if (f.equals("0")) {
            list = this.M;
            b2 = -82;
        } else {
            list = this.M;
            b2 = -66;
        }
        list.add(Byte.valueOf(b2));
        this.M.add((byte) 0);
        this.M.add(Byte.valueOf(this.J[0]));
        this.M.add(Byte.valueOf(this.J[1]));
        this.M.add(Byte.valueOf(this.J[2]));
        this.M.add(Byte.valueOf(this.J[3]));
        int length = this.K.length;
        this.M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.M.add(Byte.valueOf(this.K[i]));
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.A == null) {
                this.A = new b();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.e.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.b.a().c());
            stringBuffer.append("&cnloc=");
            stringBuffer.append(l.a().b());
            this.A.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    public void a(final Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && this.m.contains(com.baidu.location.c.b.a(com.baidu.location.c.f.a().g()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.I.post(new Runnable() { // from class: com.baidu.location.b.i.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.b(location);
                    }
                });
            }
        }
    }

    public void b() {
        if (this.N) {
            this.N = false;
            g();
        }
    }
}
