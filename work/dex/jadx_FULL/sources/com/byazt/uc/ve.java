package com.byazt.uc;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alipay.sdk.m.y.l;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 54})
public class ve {

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 24})
    public static final class c {
        public static final ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    private X509TrustManager tt() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }

    private ve() {
    }

    public void c(String str, String str2, String str3, EventListener eventListener) throws Throwable {
        uj ujVar;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(c(tt()));
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(5000);
                    httpsURLConnection2.setHostnameVerifier(com.byazt.uc.c.c);
                    httpsURLConnection2.setRequestMethod("GET");
                    if (httpsURLConnection2.getResponseCode() == 200 && c(httpsURLConnection2.getInputStream(), str2, str3, eventListener)) {
                        eventListener.onEvent(0, new uj(str2 + WVNativeCallbackUtil.SEPERATER + str3));
                    }
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Exception e) {
                        ujVar = new uj(e.getMessage());
                        eventListener.onEvent(2, ujVar);
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpsURLConnection = httpsURLConnection2;
                    a.c(e);
                    eventListener.onEvent(1, new uj(e.getMessage()));
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e3) {
                            ujVar = new uj(e3.getMessage());
                            eventListener.onEvent(2, ujVar);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e4) {
                            eventListener.onEvent(2, new uj(e4.getMessage()));
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean c(InputStream inputStream, String str, String str2, EventListener eventListener) throws Throwable {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            inputStream.close();
                            try {
                                inputStream.close();
                                return true;
                            } catch (Exception unused2) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        eventListener.onEvent(3, new uj(e.getMessage()));
        a.tt("NetApi", "save error: ", e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused5) {
            }
        }
        try {
            inputStream.close();
        } catch (Exception unused6) {
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String c(boolean z, String str, byte[] bArr) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URL url = new URL(str);
            HttpsURLConnection.setDefaultSSLSocketFactory(c(tt()));
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                try {
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setHostnameVerifier(com.byazt.uc.c.c);
                    if (z && bArr != null && bArr.length != 0) {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        httpsURLConnection.setRequestMethod("POST");
                    } else {
                        httpsURLConnection.setRequestMethod("GET");
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        String str2 = new String(c(httpsURLConnection.getInputStream(), 1024), c(httpsURLConnection.getHeaderField("Content-Type"), "utf-8"));
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                        return str2;
                    }
                } catch (Exception e) {
                    e = e;
                    a.c(e);
                    if (httpsURLConnection != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Exception unused3) {
        }
        return null;
    }

    private static byte[] c(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i <= 0) {
            i = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String c(String str, String str2) {
        if (str != null) {
            String[] strArrSplit = str.split(l.b, 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory c(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }
}
