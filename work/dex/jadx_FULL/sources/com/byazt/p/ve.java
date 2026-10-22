package com.byazt.p;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.hs.i;
import com.byazt.nr.m;
import com.byazt.w.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 350, 54})
public class ve {
    public static int c = 8;
    public static volatile ve tt;
    public c<Integer, Bitmap> ve;

    @com.byazt.zqa.c(c = {0, 1, 350, 24})
    public static class c<K, T> extends LinkedHashMap<K, T> {
        public final int c;

        public c(int i, int i2) {
            super(i2, 0.75f, true);
            this.c = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.c;
        }
    }

    private ve() {
        this.ve = null;
        int i = c;
        this.ve = new c<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream tt(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static ve c() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    public Bitmap c(int i) {
        return this.ve.get(Integer.valueOf(i));
    }

    public void c(final int i, final String str) {
        if (TextUtils.isEmpty(str) || c(i) != null) {
            return;
        }
        com.byazt.zz.ve.u().submit(new Runnable() { // from class: com.byazt.p.ve.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamTt;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStreamC;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        i iVarC = com.byazt.zz.ve.c(true, 0, str, null);
                        if (iVarC == null) {
                            a.c(null, null, null, null);
                            return;
                        }
                        inputStreamC = iVarC.c();
                        try {
                            byteArrayOutputStreamTt = ve.tt(inputStreamC);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamTt.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamTt.toByteArray());
                                    try {
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                        int iC = com.byazt.z.ve.c(com.byazt.zz.ve.ic(), 44.0f);
                                        options.inSampleSize = ve.c(iC, iC, options);
                                        options.inJustDecodeBounds = false;
                                        ve.this.ve.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                        a.c(inputStreamC, byteArrayOutputStreamTt, byteArrayInputStream, byteArrayInputStream2);
                                        return;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Exception e3) {
                                    byteArrayInputStream2 = null;
                                    e = e3;
                                } catch (Throwable th2) {
                                    closeable = null;
                                    th = th2;
                                    a.c(inputStreamC, byteArrayOutputStreamTt, byteArrayInputStream, closeable);
                                    throw th;
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e = e4;
                                byteArrayInputStream = null;
                            } catch (Throwable th3) {
                                closeable = null;
                                th = th3;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e = e5;
                            byteArrayOutputStreamTt = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream = null;
                            closeable = null;
                            th = th4;
                            byteArrayOutputStreamTt = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStreamTt = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    inputStreamC = null;
                } catch (Throwable th6) {
                    byteArrayOutputStreamTt = null;
                    byteArrayInputStream = null;
                    closeable = null;
                    th = th6;
                    inputStreamC = null;
                }
                m.c(e);
                a.c(inputStreamC, byteArrayOutputStreamTt, byteArrayInputStream, byteArrayInputStream2);
            }
        });
    }

    public static int c(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
