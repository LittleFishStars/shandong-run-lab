package com.efs.sdk.base.core.util;

import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.base.core.model.LogDto;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f29609a = new Random();

    public static void copy(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("efs.util.file", "error when copy", e);
                            safeClose(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        safeClose(fileInputStream);
                        safeClose(fileOutputStream);
                        throw th;
                    }
                }
                safeClose(fileInputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        safeClose(fileOutputStream);
    }

    public static LogDto createCodeLogDtoByName(String str) {
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length != 11) {
            Log.w("efs.util.file", "[code log]File name error, name is ".concat(str));
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        byte bByteValue = Byte.valueOf(strArrSplit[2]).byteValue();
        byte bByteValue2 = Byte.valueOf(strArrSplit[3]).byteValue();
        String str4 = strArrSplit[7];
        String str5 = strArrSplit[8];
        long jLongValue = Long.valueOf(strArrSplit[9]).longValue();
        long jLongValue2 = Long.valueOf(strArrSplit[10]).longValue();
        LogDto logDto = new LogDto(str2, bByteValue2);
        logDto.setCp(str3);
        logDto.setDe(bByteValue);
        logDto.setUid(str4);
        logDto.setDid(str5);
        logDto.setBeginTime(jLongValue);
        logDto.setEndTime(jLongValue2);
        return logDto;
    }

    public static LogDto createLogDtoByName(String str) {
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length != 7) {
            Log.w("efs.util.file", "File name error, name is ".concat(str));
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        byte bByteValue = Byte.valueOf(strArrSplit[2]).byteValue();
        LogDto logDto = new LogDto(str2, Byte.valueOf(strArrSplit[3]).byteValue());
        logDto.setCp(str3);
        logDto.setDe(bByteValue);
        return logDto;
    }

    public static void delete(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                delete(file2);
            }
        }
        file.delete();
    }

    public static String getCodelogFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getCp());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getDe());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append((int) logDto.getLogProtocol());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(ProcessUtil.myPid());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(f29609a.nextInt(10000));
        sb.append(LoginConstants.UNDER_LINE);
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getUid());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getDid());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getBeginTime());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getEndTime());
        return sb.toString();
    }

    public static String getFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getCp());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(logDto.getDe());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append((int) logDto.getLogProtocol());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(ProcessUtil.myPid());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(f29609a.nextInt(10000));
        sb.append(LoginConstants.UNDER_LINE);
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        return sb.toString();
    }

    public static long getFolderSize(File file) {
        long folderSize = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            folderSize += getFolderSize(file2);
        }
        return folderSize;
    }

    public static List<File> listFiles(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
                Log.i("efs.util.file", "file is " + file2.getName());
            } else {
                arrayList.addAll(listFiles(file2));
            }
        }
        return arrayList;
    }

    public static void move(File file, File file2) throws Throwable {
        copy(file, file2);
        delete(file);
    }

    public static String read(File file) {
        return read(file, 1024);
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean write(String str, byte[] bArr) {
        return write(new File(str), bArr);
    }

    public static String read(File file, int i) {
        String string = "";
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = fileInputStream2.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, i2));
                }
                string = sb.toString();
                safeClose(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    Log.e("efs.util.file", "read file error", th);
                } finally {
                    safeClose(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return string;
    }

    public static boolean write(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                safeClose(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    return false;
                } finally {
                    safeClose(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean write(File file, String str) {
        return write(file, str.getBytes());
    }

    public static byte[] read(String str) throws Throwable {
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    safeClose(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    Log.e("efs.util.file", "read data error", e);
                    safeClose(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
