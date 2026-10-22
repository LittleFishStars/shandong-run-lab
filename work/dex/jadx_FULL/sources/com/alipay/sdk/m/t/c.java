package com.alipay.sdk.m.t;

import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25507a;
    public String b = q.a(24);

    public c(boolean z) {
        this.f25507a = z;
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        return com.alipay.sdk.m.p.e.b(str, bArr, str2);
    }

    public d a(b bVar, boolean z, String str) {
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z) {
            try {
                bytes2 = com.alipay.sdk.m.p.b.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        return new d(z, this.f25507a ? a(bytes, a(this.b, com.alipay.sdk.m.n.a.g), b(this.b, bytes2, str)) : a(bytes, bytes2));
    }

    /* JADX WARN: Code duplicated, block: B:47:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public b a(d dVar, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(dVar.a());
            try {
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new String(bArr2);
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int iA = a(new String(bArr3));
                        if (iA > 0) {
                            byte[] bArrB = new byte[iA];
                            byteArrayInputStream.read(bArrB);
                            if (this.f25507a) {
                                bArrB = a(this.b, bArrB, str);
                            }
                            if (dVar.b()) {
                                bArrB = com.alipay.sdk.m.p.b.b(bArrB);
                            }
                            str3 = new String(bArrB);
                        } else {
                            str3 = null;
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        try {
                            g.a(e);
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            str3 = null;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream2 = byteArrayInputStream;
                            byteArrayInputStream = byteArrayInputStream2;
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            str2 = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = byteArrayInputStream2;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
        if (str2 == null && str3 == null) {
            return null;
        }
        return new b(str2, str3);
    }

    public static byte[] a(String str, String str2) {
        return com.alipay.sdk.m.p.d.a(str, str2);
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        return com.alipay.sdk.m.p.e.a(str, bArr, str2);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:? A[SYNTHETIC] */
    public static byte[] a(byte[]... bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray = null;
        byteArray = null;
        byteArray = null;
        DataOutputStream dataOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                            try {
                                for (byte[] bArr2 : bArr) {
                                    dataOutputStream.write(a(bArr2.length).getBytes());
                                    dataOutputStream.write(bArr2);
                                }
                                dataOutputStream.flush();
                                byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused) {
                                }
                                dataOutputStream.close();
                            } catch (Exception e) {
                                e = e;
                                try {
                                    g.a(e);
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    return byteArray;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    dataOutputStream2 = dataOutputStream;
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (dataOutputStream2 != null) {
                                        try {
                                            dataOutputStream2.close();
                                            throw th;
                                        } catch (Exception unused4) {
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream2 = dataOutputStream;
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (dataOutputStream2 != null) {
                                    dataOutputStream2.close();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (dataOutputStream2 != null) {
                                dataOutputStream2.close();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        dataOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        dataOutputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        dataOutputStream2 = dataOutputStream;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                            throw th;
                        }
                        throw th;
                    }
                    return byteArray;
                }
            } catch (Exception unused5) {
            }
        }
        return null;
    }

    public static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }
}
