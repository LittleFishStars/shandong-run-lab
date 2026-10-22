package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class f {

    public static class a {
        public int httpResponseCode = -1;
        public byte[] data = null;
        public long rt = 0;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:168:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x01c1 A[EDGE_INSN: B:178:0x01c1->B:100:0x01c1 BREAK  A[LOOP:0: B:96:0x01b6->B:192:?], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x01bd A[Catch: IOException -> 0x01d7, all -> 0x01ee, TRY_LEAVE, TryCatch #0 {IOException -> 0x01d7, blocks: (B:95:0x01b4, B:96:0x01b6, B:98:0x01bd), top: B:156:0x01b4 }] */
    public static a a(int i, String str, Map<String, Object> map, boolean z) throws Throwable {
        byte[] byteArray;
        Throwable th;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream gZIPInputStream;
        Throwable th2;
        InputStream inputStream;
        byte[] bArr;
        int i2;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                char c = 1;
                if (i == 2 || i == 3) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setDoInput(true);
                try {
                    if (i == 2 || i == 3) {
                        httpURLConnection.setRequestMethod("POST");
                    } else {
                        httpURLConnection.setRequestMethod("GET");
                    }
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setRequestProperty("Connection", "close");
                    if (z) {
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                    }
                    httpURLConnection.setInstanceFollowRedirects(true);
                    if (i == 2 || i == 3) {
                        if (i == 2) {
                            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                        } else if (i == 3) {
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        }
                        if (map == null || map.size() <= 0) {
                            byteArray = null;
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            Set<String> setKeySet = map.keySet();
                            String[] strArr = new String[setKeySet.size()];
                            setKeySet.toArray(strArr);
                            String[] strArrA = i.a().a(strArr, true);
                            int length = strArrA.length;
                            int i3 = 0;
                            while (i3 < length) {
                                String str2 = strArrA[i3];
                                if (i == 2) {
                                    byte[] bArr2 = (byte[]) map.get(str2);
                                    if (bArr2 != null) {
                                        try {
                                            Object[] objArr = new Object[2];
                                            objArr[0] = str2;
                                            objArr[c] = str2;
                                            byteArrayOutputStream2.write(String.format("--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n", objArr).getBytes());
                                            byteArrayOutputStream2.write(bArr2);
                                            byteArrayOutputStream2.write("\r\n".getBytes());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } else if (i == 3) {
                                    String str3 = (String) map.get(str2);
                                    if (byteArrayOutputStream2.size() > 0) {
                                        try {
                                            byteArrayOutputStream2.write(("&" + str2 + "=" + str3).getBytes());
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    } else {
                                        try {
                                            byteArrayOutputStream2.write((str2 + "=" + str3).getBytes());
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                                i3++;
                                c = 1;
                            }
                            if (i == 2) {
                                try {
                                    byteArrayOutputStream2.write("--GJircTeP--\r\n".getBytes());
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            byteArray = byteArrayOutputStream2.toByteArray();
                        }
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(byteArray != null ? byteArray.length : 0));
                    } else {
                        byteArray = null;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        httpURLConnection.connect();
                        if ((i == 2 || i == 3) && byteArray != null && byteArray.length > 0) {
                            dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                try {
                                    dataOutputStream2.write(byteArray);
                                    dataOutputStream2.flush();
                                } catch (Exception e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    aVar.rt = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (dataOutputStream2 != null) {
                                        try {
                                            dataOutputStream2.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    return aVar;
                                }
                            } catch (Throwable th3) {
                                dataOutputStream = dataOutputStream2;
                                th = th3;
                                if (dataOutputStream != null) {
                                    throw th;
                                }
                                try {
                                    dataOutputStream.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        } else {
                            dataOutputStream2 = null;
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        try {
                            try {
                                try {
                                    aVar.httpResponseCode = httpURLConnection.getResponseCode();
                                    while (true) {
                                        i2 = inputStream.read(bArr, 0, 2048);
                                        if (i2 == -1) {
                                            byteArrayOutputStream.write(bArr, 0, i2);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e9) {
                                                e9.printStackTrace();
                                            }
                                        }
                                        th2 = th;
                                        if (inputStream != null) {
                                            throw th2;
                                        }
                                        try {
                                            inputStream.close();
                                            throw th2;
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                            throw th2;
                                        }
                                    }
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                                if (z) {
                                    try {
                                        if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                                            gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                                        }
                                        inputStream = gZIPInputStream;
                                        bArr = new byte[2048];
                                        while (true) {
                                            i2 = inputStream.read(bArr, 0, 2048);
                                            if (i2 == -1) {
                                                break;
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, i2);
                                            th2 = th;
                                            if (inputStream != null) {
                                                throw th2;
                                            }
                                            inputStream.close();
                                            throw th2;
                                        }
                                        inputStream.close();
                                        if (byteArrayOutputStream.size() > 0) {
                                            aVar.data = byteArrayOutputStream.toByteArray();
                                        }
                                    } catch (IOException e12) {
                                        e = e12;
                                        inputStream = null;
                                        e.printStackTrace();
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e13) {
                                                e13.printStackTrace();
                                            }
                                        }
                                        return aVar;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        inputStream = null;
                                    }
                                }
                                bArr = new byte[2048];
                                inputStream.close();
                                if (byteArrayOutputStream.size() > 0) {
                                    aVar.data = byteArrayOutputStream.toByteArray();
                                }
                            } catch (IOException e14) {
                                e = e14;
                                e.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return aVar;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                        }
                        aVar.rt = System.currentTimeMillis() - jCurrentTimeMillis;
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        gZIPInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        inputStream = gZIPInputStream;
                    } catch (Exception e15) {
                        e = e15;
                        dataOutputStream2 = null;
                    } catch (Throwable th6) {
                        th = th6;
                        dataOutputStream = null;
                        if (dataOutputStream != null) {
                            throw th;
                        }
                        dataOutputStream.close();
                        throw th;
                    }
                } catch (ProtocolException e16) {
                    e16.printStackTrace();
                }
            }
            return aVar;
        } catch (MalformedURLException e17) {
            e17.printStackTrace();
            return aVar;
        } catch (IOException e18) {
            e18.printStackTrace();
            return aVar;
        }
    }
}
