package com.byazt.bzd;

import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 46})
public class n {
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                m.tt("FileUtils", e);
            }
        }
    }

    public static void tt(File file) {
        if (file.isDirectory()) {
            ve(file);
        } else {
            file.delete();
        }
    }

    private static void ve(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                tt(file2);
            }
        }
    }

    public static File c(File file, String str) throws Throwable {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                c(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e) {
                            e = e;
                            zipOutputStream = zipOutputStream2;
                            m.tt("FileUtils", e);
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            c(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            file2 = null;
        }
        c(zipOutputStream);
        return file2;
    }

    public static boolean c(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    c(bufferedWriter2);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    m.tt("FileUtils", e);
                    c(bufferedWriter);
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    m.tt("FileUtils", e);
                    c(bufferedWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    c(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    public static String c(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        m.tt("FileUtils", e);
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - System.lineSeparator().length());
                    }
                    String strTrim = sb.toString().trim();
                    bufferedReader.close();
                    return strTrim;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Exception e) {
                m.tt("FileUtils", e);
            }
        }
        return null;
    }

    public static void c(OutputStream outputStream, File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i != -1) {
                            outputStream.write(bArr, 0, i);
                        } else {
                            c(fileInputStream2);
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    m.tt("FileUtils", e);
                    c(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    m.tt("FileUtils", e);
                    c(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }
}
