package com.aliyun.vod.log.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CRC64Util {
    public static String calculateCrc64(String str) {
        byte[] bArr = new byte[1024];
        CRC64 crc64 = new CRC64();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    bufferedInputStream.close();
                    return String.valueOf(crc64.getValue());
                }
                crc64.update(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
