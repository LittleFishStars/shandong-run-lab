package com.kc.bw.adIdUtils;

import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ByteStreams {
    public static long copy(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            }
        } catch (Throwable th) {
            Log.w(dexg.dexa("CzufTusfbnt.."), dexg.dexa("dpqz..") + th.toString());
        }
        return j;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
        } catch (Throwable th) {
            Log.w(dexg.dexa("CzufTusfbnt.."), dexg.dexa("czuf..") + th.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }
}
