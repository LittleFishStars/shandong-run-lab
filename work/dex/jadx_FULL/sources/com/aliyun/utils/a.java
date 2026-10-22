package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a {
    private static final int CONNECTION_TIMEOUT = 10000;

    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    private void doHttpGet(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        InputStream inputStream = null;
        try {
            try {
                URL url = new URL(str);
                if (url.openConnection() instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() == 200) {
                            errorStream = httpURLConnection.getInputStream();
                            handleOKInputStream(errorStream);
                        } else {
                            errorStream = httpURLConnection.getErrorStream();
                            handleErrorInputStream(errorStream);
                        }
                        if (errorStream != null) {
                            try {
                                errorStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        Logger.w("HttpClientUtil", e.getMessage());
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                    httpURLConnection.disconnect();
                }
                return;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
                inputStream.close();
            }
            if (str != 0) {
                throw th;
            }
            str.disconnect();
            throw th;
        }
        Logger.w("HttpClientUtil", e.getMessage());
        if (0 != 0) {
            inputStream.close();
        }
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.disconnect();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    private void doHttpsGet(String str) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        InputStream errorStream;
        InputStream inputStream = null;
        try {
            try {
                URL url = new URL(str);
                if (url.openConnection() instanceof HttpsURLConnection) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    try {
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setConnectTimeout(10000);
                        httpsURLConnection.setReadTimeout(10000);
                        httpsURLConnection.connect();
                        if (httpsURLConnection.getResponseCode() == 200) {
                            errorStream = httpsURLConnection.getInputStream();
                            handleOKInputStream(errorStream);
                        } else {
                            errorStream = httpsURLConnection.getErrorStream();
                            handleErrorInputStream(errorStream);
                        }
                        if (errorStream != null) {
                            try {
                                errorStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        Logger.d("HttpClientUtil", e.getMessage());
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpsURLConnection == null) {
                            return;
                        }
                    }
                    httpsURLConnection.disconnect();
                }
                return;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
                inputStream.close();
            }
            if (str != 0) {
                throw th;
            }
            str.disconnect();
            throw th;
        }
        Logger.d("HttpClientUtil", e.getMessage());
        if (0 != 0) {
            inputStream.close();
        }
        if (httpsURLConnection == null) {
            return;
        }
        httpsURLConnection.disconnect();
    }

    public void doGet(String str) throws Throwable {
        if (str.startsWith("https://")) {
            doHttpsGet(str);
        } else if (str.startsWith("http://")) {
            doHttpGet(str);
        }
    }

    public abstract void handleErrorInputStream(InputStream inputStream);

    public abstract void handleOKInputStream(InputStream inputStream);
}
