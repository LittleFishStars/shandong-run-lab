package com.getui.gtc.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g {
    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                    } finally {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
        } catch (Exception e5) {
        }
        return byteArray;
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] byteArray = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = gZIPInputStream.read();
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                byteArrayInputStream.close();
                            } finally {
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                try {
                                    byteArrayInputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e8) {
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }
}
