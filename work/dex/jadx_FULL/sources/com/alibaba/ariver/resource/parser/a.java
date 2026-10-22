package com.alibaba.ariver.resource.parser;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24449a = "AriverRes:Rsa";

    public static boolean a(String str, String str2, String str3) {
        if (IOUtils.isNIOEnabled()) {
            RVLogger.d(f24449a, "verify with NIO " + str);
            return b(str, str2, str3);
        }
        RVLogger.d(f24449a, "verify with stream " + str);
        return c(str, str2, str3);
    }

    private static boolean b(String str, String str2, String str3) {
        MappedByteBuffer mappedByteBuffer;
        FileChannel channel;
        boolean zC;
        FileInputStream fileInputStream = null;
        MappedByteBuffer map = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                channel = fileInputStream2.getChannel();
                try {
                    long size = channel.size();
                    if (size < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH || size > 5242880) {
                        RVLogger.d(f24449a, "verify size=" + size);
                        zC = c(str, str2, str3);
                    } else {
                        RVLogger.d(f24449a, "NIO verify size=" + size);
                        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
                        byte[] bArrDecode = Base64.decode(str3, 2);
                        Signature signature = Signature.getInstance("SHA1withRSA");
                        signature.initVerify(publicKeyGeneratePublic);
                        map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        signature.update(map);
                        zC = signature.verify(bArrDecode);
                    }
                    IOUtils.freeMappedBuffer(map);
                    IOUtils.closeQuietly(channel);
                    IOUtils.closeQuietly(fileInputStream2);
                    return zC;
                } catch (Throwable th) {
                    th = th;
                    mappedByteBuffer = null;
                    fileInputStream = fileInputStream2;
                    try {
                        RVLogger.e(f24449a, "verify exception" + th);
                        return false;
                    } finally {
                        IOUtils.freeMappedBuffer(mappedByteBuffer);
                        IOUtils.closeQuietly(channel);
                        IOUtils.closeQuietly(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                mappedByteBuffer = null;
                channel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            mappedByteBuffer = null;
            channel = null;
        }
    }

    private static boolean c(String str, String str2, String str3) {
        byte[] buf = IOUtils.getBuf(1024);
        boolean zVerify = false;
        BufferedInputStream bufferedInputStream = null;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            byte[] bArrDecode = Base64.decode(str3, 2);
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKeyGeneratePublic);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            int i = 0;
            while (bufferedInputStream2.available() != 0) {
                try {
                    int i2 = bufferedInputStream2.read(buf);
                    i += i2;
                    signature.update(buf, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        RVLogger.e(f24449a, "verify exception", th);
                    } finally {
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(bufferedInputStream);
                    }
                }
            }
            RVLogger.d(f24449a, "Stream verify size=" + i);
            zVerify = signature.verify(bArrDecode);
            IOUtils.returnBuf(buf);
            IOUtils.closeQuietly(bufferedInputStream2);
        } catch (Throwable th2) {
            th = th2;
        }
        return zVerify;
    }
}
