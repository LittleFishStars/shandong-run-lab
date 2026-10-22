package com.alibaba.analytics.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    /* JADX WARN: Code duplicated, block: B:56:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:? A[SYNTHETIC] */
    public static byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] byteArray = null;
        byteArray = null;
        byteArray = null;
        gZIPOutputStream = null;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                    try {
                        try {
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.finish();
                            byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream;
                        if (gZIPOutputStream2 != null) {
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            throw th;
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream2 != null) {
                        gZIPOutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        } catch (Exception e8) {
            e = e8;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        byte[] byteArray = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                try {
                                    int i = gZIPInputStream.read(bArr2, 0, 1024);
                                    if (i == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i);
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (gZIPInputStream != 0) {
                                        try {
                                            gZIPInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                    return byteArray;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != 0) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (byteArrayInputStream == null) {
                                    throw th;
                                }
                                try {
                                    byteArrayInputStream.close();
                                    throw th;
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } catch (Exception e9) {
                        e = e9;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        byteArrayOutputStream = null;
                        th = th3;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (gZIPInputStream != 0) {
                            gZIPInputStream.close();
                        }
                        if (byteArrayInputStream == null) {
                            throw th;
                        }
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    gZIPInputStream = 0;
                    byteArrayOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    th = th;
                    gZIPInputStream = byteArrayOutputStream;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (gZIPInputStream != 0) {
                        gZIPInputStream.close();
                    }
                    if (byteArrayInputStream == null) {
                        throw th;
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            e = e12;
            gZIPInputStream = 0;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }
}
