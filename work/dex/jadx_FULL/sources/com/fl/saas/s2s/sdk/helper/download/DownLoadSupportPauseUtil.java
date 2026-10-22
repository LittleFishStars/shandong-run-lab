package com.fl.saas.s2s.sdk.helper.download;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommClickHelper;
import com.fl.saas.s2s.sdk.helper.CommNotificationHelper;
import com.fl.saas.s2s.sdk.util.ApkUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.zj.adlib.c49;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownLoadSupportPauseUtil {
    public static final int DOWNLOAD_SUCCESS = 1002;
    public static final int MAX_REDIRECTION = 5;
    public static final int UPDATE_PROGRESS = 1001;
    public static String YD_CANCEL_DOWNLOAD = "YDActionCancelDownloadCheckUrl";
    public static String YD_CANCEL_LAST_DOWNLOAD = "YDActionCancelLastDownloadCheckUrl";
    public static String YD_DOWNLOAD_SUCCESS = "YDActionDownloadSuccess";
    public static String YD_PAUSE_DOWNLOAD = "YDActionPauseDownloadCheckUrl";
    public static String YD_START_DOWNLOAD = "YDActionStartDownloadCheckUrl";
    public static String YD_UPDATE_DOWNLOAD_PROGRESS = "YDActionUpdateProgress";
    private static DownloadAddReceiver adReceiver = new DownloadAddReceiver();
    private ActionReceiver actionReceiver;
    private AdInfoPoJo adInfoPoJo;
    private File file;
    private Handler handler;
    private Context mContext;
    private MyThread myThread;
    private String name;
    private CommNotificationHelper notificationHelper;
    private IProgress progressListener;
    private RandomAccessFile raf;
    private File rootFile;
    private long totalLength;
    private String urlPath;
    private boolean isDown = false;
    private long downSize = 0;
    private boolean isRegister = false;
    private final AtomicInteger redirectionCount = new AtomicInteger();

    public class ActionReceiver extends BroadcastReceiver {
        public ActionReceiver() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0073  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("downLoadUrl");
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_START_DOWNLOAD.equals(action)) {
                    if (DownLoadSupportPauseUtil.this.urlPath.equals(stringExtra)) {
                        DownLoadSupportPauseUtil.this.start();
                        return;
                    }
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD.equals(action)) {
                    if (DownLoadSupportPauseUtil.this.urlPath.equals(stringExtra)) {
                        DownLoadSupportPauseUtil.this.pause();
                        return;
                    }
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD.equals(action)) {
                    if (!DownLoadSupportPauseUtil.this.urlPath.equals(stringExtra)) {
                        return;
                    }
                    if (DownLoadSupportPauseUtil.this.progressListener != null) {
                        DownLoadSupportPauseUtil.this.progressListener.onCancel();
                    }
                } else {
                    if (!DownLoadSupportPauseUtil.YD_CANCEL_LAST_DOWNLOAD.equals(action)) {
                        return;
                    }
                    if (DownLoadSupportPauseUtil.this.progressListener != null) {
                        DownLoadSupportPauseUtil.this.progressListener.onCancel();
                    }
                }
                DownLoadSupportPauseUtil.this.destroy();
            }
        }
    }

    public interface IProgress {
        void onCancel();

        void onProgress(int i);

        void onSuccess(File file);
    }

    public class MyThread extends Thread {
        public MyThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            DownLoadSupportPauseUtil.this.downLoad();
        }
    }

    public DownLoadSupportPauseUtil(@NonNull Context context, @NonNull AdInfoPoJo adInfoPoJo, IProgress iProgress) {
        String strSubstring;
        this.mContext = context;
        this.adInfoPoJo = adInfoPoJo;
        this.progressListener = iProgress;
        this.urlPath = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
        if (!TextUtils.isEmpty(adInfoPoJo.app_package)) {
            StringBuilder sb = new StringBuilder();
            sb.append((adInfoPoJo.app_package + adInfoPoJo.app_version).replace(Consts.DOT, ""));
            sb.append(".apk");
            strSubstring = sb.toString();
        } else if (this.urlPath.endsWith(".apk")) {
            String str = this.urlPath;
            strSubstring = str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1, this.urlPath.length());
        } else {
            strSubstring = "temp.apk";
        }
        this.name = strSubstring;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1001) {
                    if (i == 1002) {
                        File file = (File) message.obj;
                        if (DownLoadSupportPauseUtil.this.progressListener != null) {
                            DownLoadSupportPauseUtil.this.progressListener.onSuccess(file);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int i2 = message.arg1;
                String str2 = (String) message.obj;
                if (DownLoadSupportPauseUtil.this.progressListener != null) {
                    DownLoadSupportPauseUtil.this.progressListener.onProgress(i2);
                }
                if (DownLoadSupportPauseUtil.this.notificationHelper != null) {
                    DownLoadSupportPauseUtil.this.notificationHelper.updateProgress(i2, str2);
                }
            }
        };
    }

    private void downLoadComplete() {
        this.isDown = false;
        Message messageObtainMessage = this.handler.obtainMessage();
        messageObtainMessage.what = 1002;
        messageObtainMessage.obj = this.file;
        this.handler.sendMessage(messageObtainMessage);
        AdInfoPoJo adInfoPoJo = this.adInfoPoJo;
        if (adInfoPoJo != null) {
            DownloadAddReceiver downloadAddReceiver = adReceiver;
            if (downloadAddReceiver != null) {
                downloadAddReceiver.setPoJo(adInfoPoJo);
            }
            CommClickHelper.getInstance().report(this.mContext, this.adInfoPoJo, 5);
        }
        ApkUtils.installAPk(this.mContext, this.file, this.adInfoPoJo);
        if (!this.isRegister && adReceiver != null && DeviceUtil.enableCollectAppInstallStatus) {
            adReceiver.registerX(this.mContext.getApplicationContext());
            this.isRegister = true;
        }
        destroy();
    }

    public SSLContext createSSLContext() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.2
                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void destroy() {
        if (this.isDown) {
            this.isDown = false;
            if (this.myThread != null) {
                ThreadPoolManager.getInstance().removeTask(this.myThread);
                this.myThread = null;
            }
        }
        CommNotificationHelper commNotificationHelper = this.notificationHelper;
        if (commNotificationHelper != null) {
            commNotificationHelper.cancel();
            this.notificationHelper = null;
        }
        ActionReceiver actionReceiver = this.actionReceiver;
        if (actionReceiver != null) {
            try {
                this.mContext.unregisterReceiver(actionReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.actionReceiver = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x01d3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [long] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public void downLoad() throws Throwable {
        ?? r2;
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        HttpURLConnection httpURLConnectionInnerRequest;
        this.redirectionCount.set(5);
        try {
            if (this.notificationHelper == null) {
                this.notificationHelper = new CommNotificationHelper(this.mContext, this.urlPath, this.adInfoPoJo.app_name);
            }
            ?? r1 = this.downSize;
            try {
                try {
                    if (r1 < 1) {
                        this.rootFile = this.mContext.getCacheDir();
                        File file = new File(this.rootFile, this.name);
                        this.file = file;
                        if (file.exists()) {
                            if ("temp.apk".equals(this.name)) {
                                this.file.delete();
                            } else {
                                this.downSize = this.file.length();
                            }
                        }
                        httpURLConnectionInnerRequest = innerRequest(Uri.parse(this.urlPath), this.downSize);
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.file, "rwd");
                        this.raf = randomAccessFile3;
                        randomAccessFile3.seek(this.downSize);
                        long contentLength = httpURLConnectionInnerRequest.getContentLength();
                        long j = this.downSize;
                        long j2 = contentLength + j;
                        this.totalLength = j2;
                        if (j == j2) {
                            downLoadComplete();
                            httpURLConnectionInnerRequest.disconnect();
                            RandomAccessFile randomAccessFile4 = this.raf;
                            if (randomAccessFile4 != null) {
                                try {
                                    randomAccessFile4.close();
                                    this.raf = null;
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        this.actionReceiver = new ActionReceiver();
                        try {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(YD_START_DOWNLOAD);
                            intentFilter.addAction(YD_PAUSE_DOWNLOAD);
                            intentFilter.addAction(YD_CANCEL_DOWNLOAD);
                            intentFilter.addAction(YD_CANCEL_LAST_DOWNLOAD);
                            if (Build.VERSION.SDK_INT > 33) {
                                this.mContext.registerReceiver(this.actionReceiver, intentFilter, 2);
                            } else {
                                this.mContext.registerReceiver(this.actionReceiver, intentFilter);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (r1 == this.totalLength) {
                            downLoadComplete();
                            RandomAccessFile randomAccessFile5 = this.raf;
                            if (randomAccessFile5 != null) {
                                try {
                                    randomAccessFile5.close();
                                    this.raf = null;
                                    return;
                                } catch (IOException unused2) {
                                    return;
                                }
                            }
                            return;
                        }
                        httpURLConnectionInnerRequest = innerRequest(Uri.parse(this.urlPath), this.downSize);
                        RandomAccessFile randomAccessFile6 = new RandomAccessFile(this.file, "rwd");
                        this.raf = randomAccessFile6;
                        randomAccessFile6.seek(this.downSize);
                        httpURLConnectionInnerRequest.connect();
                        this.notificationHelper.changeActionText(true);
                    }
                    InputStream inputStream2 = httpURLConnectionInnerRequest.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        long j3 = 0;
                        int i = 0;
                        while (true) {
                            int i2 = inputStream2.read(bArr);
                            if (i2 == -1 || !this.isDown) {
                                break;
                            }
                            this.raf.write(bArr, 0, i2);
                            long j4 = this.downSize + ((long) i2);
                            this.downSize = j4;
                            int i3 = (int) ((j4 * 100) / this.totalLength);
                            if (i3 != i && System.currentTimeMillis() - j3 > 1000) {
                                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                                String str = decimalFormat.format((this.totalLength / 1024.0d) / 1024.0d);
                                String str2 = decimalFormat.format((this.downSize / 1024.0d) / 1024.0d);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                Message messageObtainMessage = this.handler.obtainMessage();
                                messageObtainMessage.what = 1001;
                                messageObtainMessage.arg1 = i3;
                                messageObtainMessage.obj = str2 + "MB/" + str + "MB";
                                this.handler.sendMessage(messageObtainMessage);
                                j3 = jCurrentTimeMillis;
                            }
                            i = i3;
                        }
                        if (this.downSize >= this.totalLength) {
                            downLoadComplete();
                        }
                        httpURLConnectionInnerRequest.disconnect();
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                        randomAccessFile2 = this.raf;
                        if (randomAccessFile2 == null) {
                            return;
                        }
                    } catch (Exception e2) {
                        r2 = httpURLConnectionInnerRequest;
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            e.printStackTrace();
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            randomAccessFile2 = this.raf;
                            if (randomAccessFile2 == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            randomAccessFile = this.raf;
                            if (randomAccessFile != null) {
                                throw th;
                            }
                            try {
                                randomAccessFile.close();
                                this.raf = null;
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        r2 = httpURLConnectionInnerRequest;
                        th = th2;
                        inputStream = inputStream2;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        randomAccessFile = this.raf;
                        if (randomAccessFile != null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        this.raf = null;
                        throw th;
                    }
                } catch (Exception e3) {
                    inputStream = null;
                    r2 = r1;
                    e = e3;
                }
            } catch (Throwable th3) {
                inputStream = null;
                r2 = r1;
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
            r2 = 0;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            r2 = 0;
            inputStream = null;
        }
        try {
            randomAccessFile2.close();
            this.raf = null;
        } catch (IOException unused7) {
        }
    }

    public HttpURLConnection innerRequest(Uri uri, long j) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        if (uri != null && TextUtils.isEmpty(uri.toString())) {
            if (AdHttpUtils.getInstance().checkBlack(uri.toString())) {
                throw new DownloadException(0, "url is fail");
            }
        }
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext sSLContextCreateSSLContext = createSSLContext();
            if (sSLContextCreateSSLContext != null) {
                httpURLConnection = httpsURLConnection;
                httpsURLConnection.setSSLSocketFactory(sSLContextCreateSSLContext.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection = httpsURLConnection;
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", HlsPlaylistParser.V);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        if (j > 0) {
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 307) {
            switch (responseCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return httpURLConnection;
            }
        }
        if (this.redirectionCount.decrementAndGet() < 0) {
            throw new DownloadException(responseCode, "redirects too many times");
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (TextUtils.isEmpty(headerField) || AdHttpUtils.getInstance().checkRedirectBlack(headerField)) {
            throw new DownloadException(responseCode, "redirects too many times");
        }
        return innerRequest(Uri.parse(headerField), j);
    }

    public void pause() {
        if (this.isDown) {
            this.isDown = false;
            if (this.myThread != null) {
                ThreadPoolManager.getInstance().removeTask(this.myThread);
                this.myThread = null;
            }
        }
        CommNotificationHelper commNotificationHelper = this.notificationHelper;
        if (commNotificationHelper != null) {
            commNotificationHelper.changeActionText(false);
        }
    }

    public void start() {
        if (this.isDown) {
            return;
        }
        this.isDown = true;
        if (this.myThread == null) {
            this.myThread = new MyThread();
        }
        ThreadPoolManager.getInstance().addTask(this.myThread);
    }
}
