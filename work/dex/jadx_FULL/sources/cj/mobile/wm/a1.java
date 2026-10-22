package cj.mobile.wm;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.c49;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a1 extends Handler {
    public final r0 dexb;
    public long dexc;
    public File dexj;
    public volatile boolean dexk;
    public volatile boolean dexl;
    public final x0 dexm;
    public final int dexa = 4;
    public volatile boolean dexd = false;
    public final AtomicInteger dexe = new AtomicInteger(0);
    public final AtomicInteger dexf = new AtomicInteger(0);
    public final AtomicInteger dexg = new AtomicInteger(0);
    public long dexn = 0;
    public long dexo = 0;
    public String dexp = "";
    public long[] dexh = new long[4];
    public final File[] dexi = new File[4];

    public class dexa extends Thread {
        public int dexa;
        public String dexb;
        public File dexc;
        public long dexd;
        public long dexe;
        public long dexf;
        public long[] dexg;

        public dexa(int i, long[] jArr, String str, File file, long j, long j2, long j3) {
            this.dexa = i;
            this.dexb = str;
            this.dexc = file;
            this.dexd = j;
            this.dexg = jArr;
            this.dexe = j2;
            this.dexf = j3;
        }

        private void dexa() {
            a1.this.obtainMessage(4).sendToTarget();
        }

        private void dexb() {
            a1.this.obtainMessage(2).sendToTarget();
        }

        private void dexc() {
            a1.this.obtainMessage(3).sendToTarget();
        }

        private void dexd() {
            a1.this.obtainMessage(1).sendToTarget();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                long j = this.dexe;
                File file = new File(a1.this.dexb.dexa(), "thread" + this.dexa + LoginConstants.UNDER_LINE + a1.this.dexb.dexg() + ".cache");
                a1.this.dexi[this.dexa] = file;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                if (file.exists()) {
                    try {
                        j = Integer.parseInt(randomAccessFile.readLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.dexc, "rwd");
                randomAccessFile2.seek(j);
                HashMap map = new HashMap();
                map.put("Range", "bytes=" + j + c49.f40900a + this.dexf);
                Log.e("DownloadTask", "DownloadThread ... threadId = " + this.dexa + " , newStartIndex = " + j + " , startPosition = " + this.dexe + " , endPosition = " + this.dexf);
                InputStream inputStream = a1.this.dexa(this.dexb, (HashMap<String, String>) map).getInputStream();
                byte[] bArr = new byte[4096];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 == -1) {
                        Log.e("DownloadTask", "DownloadThread ... threadId = " + this.dexa + " , mProgress = " + this.dexg[this.dexa]);
                        randomAccessFile2.close();
                        inputStream.close();
                        a1.this.dexa(file);
                        dexb();
                        return;
                    }
                    if (a1.this.dexl) {
                        randomAccessFile2.close();
                        a1 a1Var = a1.this;
                        File[] fileArr = new File[1];
                        fileArr[i] = file;
                        a1Var.dexa(fileArr);
                        dexa();
                        return;
                    }
                    if (a1.this.dexk) {
                        dexc();
                        return;
                    }
                    randomAccessFile2.write(bArr, i, i3);
                    int i4 = i2 + i3;
                    long j2 = ((long) i4) + j;
                    randomAccessFile.seek(0L);
                    randomAccessFile.write((j2 + "").getBytes("UTF-8"));
                    this.dexg[this.dexa] = j2 - this.dexe;
                    dexd();
                    i2 = i4;
                    i = 0;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public a1(r0 r0Var, x0 x0Var) {
        this.dexb = r0Var;
        this.dexm = x0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection dexa(String str, HashMap<String, String> map) {
        HttpURLConnection httpURLConnectionDexb = dexb(new URL(str));
        httpURLConnectionDexb.setInstanceFollowRedirects(false);
        try {
            for (String str2 : map.keySet()) {
                httpURLConnectionDexb.setRequestProperty(str2, map.get(str2));
            }
            int responseCode = httpURLConnectionDexb.getResponseCode();
            if (responseCode == 301 || responseCode == 302) {
                String headerField = httpURLConnectionDexb.getHeaderField("Location");
                httpURLConnectionDexb.disconnect();
                return dexa(headerField, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpURLConnectionDexb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(File... fileArr) {
        for (File file : fileArr) {
            if (file != null) {
                file.delete();
            }
        }
    }

    private boolean dexa(AtomicInteger atomicInteger) {
        return atomicInteger.incrementAndGet() % 4 != 0;
    }

    private HttpURLConnection dexb(URL url) {
        HttpURLConnection httpURLConnectionDexa = dexa(url);
        httpURLConnectionDexa.setConnectTimeout(5000);
        httpURLConnectionDexa.setReadTimeout(5000);
        httpURLConnectionDexa.setUseCaches(false);
        httpURLConnectionDexa.setDoInput(true);
        return httpURLConnectionDexa;
    }

    private boolean dexc() {
        for (long j : this.dexh) {
            if (j == 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexd() {
        String strDexe = this.dexb.dexe();
        try {
            HttpURLConnection httpURLConnectionDexa = dexa(strDexe, new HashMap<>());
            int responseCode = httpURLConnectionDexa.getResponseCode();
            Log.e("DownloadTask", "start ... , respCode = " + responseCode);
            if (responseCode != 200) {
                dexe();
                x0 x0Var = this.dexm;
                if (x0Var != null) {
                    x0Var.a(responseCode, "文件问题");
                    return;
                }
                return;
            }
            long contentLength = httpURLConnectionDexa.getContentLength();
            this.dexc = contentLength;
            if (contentLength <= 0) {
                Log.e("DownloadTask", "start ... , respCode = " + responseCode + " , mFileLength = " + this.dexc);
                x0 x0Var2 = this.dexm;
                if (x0Var2 != null) {
                    x0Var2.a(10001, "file length is 0");
                    return;
                }
                return;
            }
            f1.dexa("DownloadTask", "start ... , respCode = " + responseCode + " , mFileLength = " + this.dexc);
            String strDexa = this.dexb.dexa();
            StringBuilder sb = new StringBuilder();
            sb.append(this.dexb.dexg());
            sb.append(".tmp");
            File file = new File(strDexa, sb.toString());
            this.dexj = file;
            if (!file.getParentFile().exists()) {
                this.dexj.getParentFile().mkdirs();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.dexj, "rw");
            randomAccessFile.setLength(this.dexc);
            randomAccessFile.close();
            long j = this.dexc;
            long j2 = j / 4;
            long j3 = j % 4;
            int i = 0;
            for (int i2 = 4; i < i2; i2 = 4) {
                long j4 = ((long) i) * j2;
                int i3 = i + 1;
                long j5 = (((long) i3) * j2) - 1;
                if (i == 3) {
                    j5 += j3;
                }
                InsightProxy.getInstance().getThreadPoolProxy().dexa("DownloadThread", new dexa(i, this.dexh, strDexe, this.dexj, j2, j4, j5));
                strDexe = strDexe;
                i = i3;
                j2 = j2;
            }
            x0 x0Var3 = this.dexm;
            if (x0Var3 != null) {
                x0Var3.a();
            }
        } catch (Exception unused) {
            dexe();
            sendEmptyMessage(4);
        }
    }

    private void dexe() {
        this.dexk = false;
        this.dexl = false;
        this.dexd = false;
    }

    public HttpURLConnection dexa(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public void dexa() {
        this.dexk = true;
        this.dexd = false;
    }

    public synchronized void dexb() {
        Log.e("DownloadTask", "start: " + this.dexd + "\t" + this.dexb.dexe());
        if (this.dexd) {
            return;
        }
        this.dexd = true;
        InsightProxy.getInstance().getThreadPoolProxy().dexa("Downloader", new Runnable() { // from class: com.zj.adlib.iha
            @Override // java.lang.Runnable
            public final void run() {
                this.f42360a.dexd();
            }
        });
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.dexm == null) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                if (dexa(this.dexg)) {
                    return;
                }
                this.dexj.renameTo(new File(this.dexb.dexa(), this.dexb.dexg()));
                dexe();
                this.dexm.dexa(1, "");
                return;
            }
            if (i == 3) {
                if (dexa(this.dexf)) {
                    return;
                }
                dexe();
                this.dexm.b();
                return;
            }
            if (i == 4 && !dexa(this.dexe)) {
                dexe();
                this.dexh = new long[4];
                this.dexm.c();
                return;
            }
            return;
        }
        long j = 0;
        for (long j2 : this.dexh) {
            j += j2;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.dexn;
        if (j3 == 0) {
            this.dexn = jCurrentTimeMillis;
            this.dexo = j;
            this.dexp = "";
        } else {
            long j4 = jCurrentTimeMillis - j3;
            if (j4 > 1000) {
                this.dexn = jCurrentTimeMillis;
                float f = ((j - this.dexo) * 1.0f) / j4;
                if (f > 0.0f) {
                    this.dexp = String.format("%.1f", Float.valueOf(f));
                    this.dexo = j;
                }
            }
        }
        if (dexc()) {
            HashMap map = new HashMap();
            map.put("downloadSpeed", this.dexp);
            this.dexm.dexa(j, this.dexc, map);
        }
    }
}
