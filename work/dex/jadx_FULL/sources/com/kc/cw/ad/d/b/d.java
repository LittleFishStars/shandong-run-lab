package com.kc.cw.ad.d.b;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {
    /* JADX WARN: Code duplicated, block: B:113:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x00dd A[EXC_TOP_SPLITTER, PHI: r3 r4 r5 r8 r9
      0x00dd: PHI (r3v6 java.io.OutputStream) = (r3v5 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v19 java.io.OutputStream) binds: [B:68:0x00db, B:87:0x0104, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r4v6 ??) = (r4v5 ??), (r4v8 ??), (r4v14 ??) binds: [B:68:0x00db, B:87:0x0104, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r5v4 ??) = (r5v3 ??), (r5v6 ??) binds: [B:68:0x00db, B:87:0x0104] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r8v15 'e' ??) = (r8v14 'e' ??), (r8v20 'e' ??), (r8v22 'e' ??) binds: [B:68:0x00db, B:87:0x0104, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r9v7 ??) = (r9v6 ??), (r9v9 ??), (r9v16 ??) binds: [B:68:0x00db, B:87:0x0104, B:44:0x00a4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00cb A[Catch: Exception -> 0x00d7, TryCatch #5 {Exception -> 0x00d7, blocks: (B:59:0x00c6, B:61:0x00cb, B:63:0x00d0, B:64:0x00d3), top: B:113:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d0 A[Catch: Exception -> 0x00d7, TryCatch #5 {Exception -> 0x00d7, blocks: (B:59:0x00c6, B:61:0x00cb, B:63:0x00d0, B:64:0x00d3), top: B:113:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f4 A[Catch: Exception -> 0x0100, TryCatch #9 {Exception -> 0x0100, blocks: (B:78:0x00ef, B:80:0x00f4, B:82:0x00f9, B:83:0x00fc), top: B:115:0x00ef }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f9 A[Catch: Exception -> 0x0100, TryCatch #9 {Exception -> 0x0100, blocks: (B:78:0x00ef, B:80:0x00f4, B:82:0x00f9, B:83:0x00fc), top: B:115:0x00ef }] */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
    
        if (r3 != null) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Exception, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [int] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String e, byte[] bArr) {
        Throwable th;
        ?? r8;
        Exception e2;
        ?? r9;
        OutputStream outputStream;
        ?? inputStreamReader;
        ?? bufferedReader;
        try {
            try {
                e = (HttpURLConnection) new URL(e).openConnection();
                try {
                    e.setRequestMethod("POST");
                    e.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    e.setRequestProperty("Content-Type", ze1.g);
                    e.setConnectTimeout(5000);
                    e.setReadTimeout(5000);
                    e.setDoOutput(true);
                    e.setDoInput(true);
                    e.connect();
                    if (bArr.length > 0) {
                        outputStream = e.getOutputStream();
                        try {
                            outputStream.write((byte[]) bArr);
                        } catch (Exception e3) {
                            e2 = e3;
                            bArr = 0;
                            inputStreamReader = 0;
                            e = e;
                            bufferedReader = inputStreamReader;
                            f.a("OctopusAd", "An Exception Caught", e2);
                            e = e;
                            if (bArr != 0) {
                                try {
                                    bArr.close();
                                    if (inputStreamReader != 0) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                    e.disconnect();
                                    e = e;
                                } catch (Exception e4) {
                                    f.a("OctopusAd", "An Exception Caught", e4);
                                    e = e4;
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e5) {
                                    e = e5;
                                    f.a("OctopusAd", "An Exception Caught", e);
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bArr = 0;
                            inputStreamReader = 0;
                            e = e;
                            bufferedReader = inputStreamReader;
                            f.a("OctopusAd", "A Throwable Caught", th);
                            e = e;
                            if (bArr != 0) {
                                try {
                                    bArr.close();
                                    if (inputStreamReader != 0) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                    e.disconnect();
                                    e = e;
                                } catch (Exception e6) {
                                    f.a("OctopusAd", "An Exception Caught", e6);
                                    e = e6;
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return null;
                        }
                    } else {
                        outputStream = null;
                    }
                    bArr = e.getResponseCode();
                    inputStreamReader = 200;
                    if (bArr == 200) {
                        bArr = e.getInputStream();
                        try {
                            inputStreamReader = new InputStreamReader(bArr);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        sb.append(line);
                                    }
                                    String string = sb.toString();
                                    if (bArr != 0) {
                                        try {
                                            bArr.close();
                                            inputStreamReader.close();
                                            bufferedReader.close();
                                            e.disconnect();
                                        } catch (Exception e7) {
                                            f.a("OctopusAd", "An Exception Caught", e7);
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception e8) {
                                            f.a("OctopusAd", "An Exception Caught", e8);
                                        }
                                    }
                                    return string;
                                } catch (Exception e9) {
                                    e2 = e9;
                                    f.a("OctopusAd", "An Exception Caught", e2);
                                    e = e;
                                    if (bArr != 0) {
                                        bArr.close();
                                        if (inputStreamReader != 0) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                        e.disconnect();
                                        e = e;
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    return null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    f.a("OctopusAd", "A Throwable Caught", th);
                                    e = e;
                                    if (bArr != 0) {
                                        bArr.close();
                                        if (inputStreamReader != 0) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                        e.disconnect();
                                        e = e;
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    return null;
                                }
                            } catch (Exception e10) {
                                e2 = e10;
                                bufferedReader = 0;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = 0;
                            }
                        } catch (Exception e11) {
                            e2 = e11;
                            inputStreamReader = 0;
                            e = e;
                            bArr = bArr;
                            bufferedReader = inputStreamReader;
                            f.a("OctopusAd", "An Exception Caught", e2);
                            e = e;
                            if (bArr != 0) {
                                bArr.close();
                                if (inputStreamReader != 0) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != 0) {
                                    bufferedReader.close();
                                }
                                e.disconnect();
                                e = e;
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = 0;
                            e = e;
                            bArr = bArr;
                            bufferedReader = inputStreamReader;
                            f.a("OctopusAd", "A Throwable Caught", th);
                            e = e;
                            if (bArr != 0) {
                                bArr.close();
                                if (inputStreamReader != 0) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != 0) {
                                    bufferedReader.close();
                                }
                                e.disconnect();
                                e = e;
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return null;
                        }
                    }
                } catch (Exception e12) {
                    e2 = e12;
                    r9 = e;
                    bArr = 0;
                    outputStream = null;
                    inputStreamReader = 0;
                    e = r9;
                    bufferedReader = inputStreamReader;
                    f.a("OctopusAd", "An Exception Caught", e2);
                    e = e;
                    if (bArr != 0) {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                        e = e;
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    r8 = e;
                    bArr = 0;
                    outputStream = null;
                    inputStreamReader = 0;
                    e = r8;
                    bufferedReader = inputStreamReader;
                    f.a("OctopusAd", "A Throwable Caught", th);
                    e = e;
                    if (bArr != 0) {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                        e = e;
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th7) {
                if (bArr != 0) {
                    try {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                    } catch (Exception e13) {
                        f.a("OctopusAd", "An Exception Caught", e13);
                    }
                }
                if (outputStream == null) {
                    throw th7;
                }
                try {
                    outputStream.close();
                    throw th7;
                } catch (Exception e14) {
                    f.a("OctopusAd", "An Exception Caught", e14);
                    throw th7;
                }
            }
        } catch (Exception e15) {
            e2 = e15;
            r9 = 0;
        } catch (Throwable th8) {
            th = th8;
            r8 = 0;
        }
    }
}
