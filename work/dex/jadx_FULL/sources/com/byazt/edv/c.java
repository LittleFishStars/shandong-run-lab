package com.byazt.edv;

import com.aliyun.vod.common.utils.FileUtils;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.omf.gt;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1881, 20})
public final class c {
    public static byte[] c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return c(new FileInputStream(file));
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public static void tt(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    tt(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static JSONObject ve(String str) {
        File fileUj = sp.uj(gt.getContext(), false, null);
        if (fileUj != null) {
            File file = new File(fileUj, str);
            if (file.exists()) {
                try {
                    return new JSONObject(new String(c(new FileInputStream(file.getAbsoluteFile()))));
                } catch (Exception e) {
                    m.c(e);
                }
            }
        }
        return null;
    }

    public static boolean c(InputStream inputStream, String str, String str2, long j) throws Throwable {
        File file;
        File file2;
        if (inputStream == null) {
            return false;
        }
        long j2 = j != -2147483648L ? j * 1048576 : FileUtils.ONE_TB;
        FileOutputStream fileOutputStream = null;
        long j3 = 0;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    m.c(e);
                }
                return false;
            }
            file2 = new File(file3, str2);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        j3 += (long) i;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    try {
                        inputStream.close();
                        if (j == -2147483648L || j3 <= j2) {
                            return true;
                        }
                        file2.delete();
                        return false;
                    } catch (Exception e2) {
                        m.c(e2);
                        return true;
                    }
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    file = file2;
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            m.c(e3);
                        }
                    }
                    try {
                        inputStream.close();
                        if (j != -2147483648L && j3 > j2 && file != null) {
                            file.delete();
                            return false;
                        }
                        throw th;
                    } catch (Exception e4) {
                        m.c(e4);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                file = file2;
                th = th2;
            }
        } catch (Exception unused3) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e5) {
                m.c(e5);
            }
        }
        try {
            inputStream.close();
            if (j != -2147483648L && j3 > j2 && file2 != null) {
                file2.delete();
                return false;
            }
        } catch (Exception e6) {
            m.c(e6);
        }
        return false;
    }

    public static byte[] c(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c(bufferedInputStream, byteArrayOutputStream, 2048);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            m.c(e);
            return new byte[0];
        } finally {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static long c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }
}
