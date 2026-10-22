package com.getui.gtc.i.b;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    public static String a(String str) {
        File file = new File(str);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest == null) {
                    return "0";
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[10240];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    if (i < 10240) {
                        byte[] bArr2 = new byte[i];
                        System.arraycopy(bArr, 0, bArr2, 0, i);
                        messageDigest.update(bArr2);
                    } else {
                        messageDigest.update(bArr);
                    }
                }
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(String.format("%02X", Byte.valueOf(b)));
                }
                String string = sb.toString();
                fileInputStream.close();
                return string;
            } catch (NoSuchAlgorithmException e) {
                com.getui.gtc.i.c.a.d(e);
                return "0";
            }
        } catch (Exception e2) {
            com.getui.gtc.i.c.a.d(e2);
            return "0";
        }
    }

    public static void a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        a(file2);
                    }
                    file.delete();
                    return;
                }
                file.delete();
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    public static void a(String str, final String str2) {
        File[] fileArrListFiles;
        File file = new File(str);
        if (file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.getui.gtc.i.b.a.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory() || file2.getName().startsWith(str2);
            }
        })) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2.getAbsolutePath(), str2);
                } else {
                    file2.delete();
                }
            }
        }
    }
}
