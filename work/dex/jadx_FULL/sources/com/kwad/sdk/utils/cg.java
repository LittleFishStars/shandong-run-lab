package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class cg {

    public static class a extends ZipOutputStream {
        private Map<String, Integer> brI;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.brI = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) throws IOException {
            ZipEntry zipEntry2;
            Integer numValueOf;
            String name = zipEntry.getName();
            Integer num = this.brI.get(name);
            if (num == null || num.intValue() <= 0) {
                zipEntry2 = zipEntry;
                numValueOf = 1;
            } else {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num + ")."));
                numValueOf = Integer.valueOf(num.intValue() + 1);
            }
            this.brI.put(name, numValueOf);
            super.putNextEntry(zipEntry2);
        }
    }

    private static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            byte[] bArr = new byte[4096];
            a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i = 0; i <= 0; i++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                }
            }
            aVar2.flush();
            aVar2.closeEntry();
            com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String eH(Context context) {
        try {
            String str = context.getFilesDir() + File.separator + "ksdsdk_ziptmp";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String is(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    public static boolean unZip(Context context, InputStream inputStream, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        String str2 = "ziptmp_" + str.hashCode();
        String strEH = eH(context);
        if (strEH == null) {
            return false;
        }
        String str3 = strEH + File.separator + str2;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        Closeable closeable = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            }
                            String name = nextEntry.getName();
                            if (!name.contains("../")) {
                                if (nextEntry.isDirectory()) {
                                    new File(str3 + File.separator + name).mkdirs();
                                } else {
                                    File file2 = new File(str3 + File.separator + name);
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                        while (true) {
                                            try {
                                                try {
                                                    int i = zipInputStream.read(bArr);
                                                    if (i == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, i);
                                                } catch (IOException e) {
                                                    e = e;
                                                    com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip when write", e);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                closeable = fileOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                throw th;
                                            }
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                    } catch (IOException e2) {
                                        e = e2;
                                        fileOutputStream = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                    zipInputStream.closeEntry();
                                }
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                    } catch (IOException e3) {
                        e = e3;
                        closeable = zipInputStream;
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = zipInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
        try {
            u.e(file, new File(str));
            return true;
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return false;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) throws IOException {
        File[] fileArrListFiles;
        if (zipOutputStream != null && file != null) {
            if (!file.exists()) {
                com.kwad.sdk.core.d.c.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
                return;
            }
            String strIs = TextUtils.isEmpty(str) ? is(file.getName()) : str + File.separator + is(file.getName());
            if (file.isFile()) {
                BufferedInputStream bufferedInputStream = null;
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(strIs));
                        while (true) {
                            int i = bufferedInputStream2.read(bArr, 0, bArr.length);
                            if (-1 != i) {
                                zipOutputStream.write(bArr, 0, i);
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error doZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    a(zipOutputStream, file2, strIs, bArr);
                }
            }
        } else {
            com.kwad.sdk.core.d.c.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        }
    }
}
