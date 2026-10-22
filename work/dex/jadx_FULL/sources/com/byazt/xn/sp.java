package com.byazt.xn;

import com.byazt.gqp.da;
import com.byazt.gqp.nu;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 91})
public class sp extends nu {
    public HttpURLConnection c;
    public InputStream tt;

    public sp(HttpURLConnection httpURLConnection) throws IOException {
        this.c = httpURLConnection;
        this.tt = new n(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.byazt.gqp.nu
    public long c() {
        try {
            return this.c.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.byazt.gqp.nu, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.tt.close();
            this.c.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gqp.nu
    public da n() {
        if (this.c.getContentType() != null) {
            return da.c(this.c.getContentType());
        }
        return null;
    }

    @Override // com.byazt.gqp.nu
    public String tt() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.tt));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.byazt.gqp.nu
    public byte[] uj() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.tt.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.byazt.gqp.nu
    public InputStream ve() {
        return this.tt;
    }
}
