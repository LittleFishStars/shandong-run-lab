package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ObjSerializUtil {
    private static final String TAG = "AriverKernel:RemoteCall";

    public static final Serializable deserializ(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
            return (Serializable) objectInputStream.readObject();
        } finally {
            try {
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
                RVLogger.w("AriverKernel:RemoteCall", "ObjSerializUtil deserializ exception: " + e.toString());
            }
        }
    }

    public static final byte[] serializ(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
                RVLogger.w("AriverKernel:RemoteCall", "ObjSerializUtil serializ exception: " + e.toString());
            }
        }
    }

    public static final Serializable deserializ(byte[] bArr, ClassLoader classLoader) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        a aVar = new a(byteArrayInputStream, classLoader);
        try {
            return (Serializable) aVar.readObject();
        } finally {
            try {
                byteArrayInputStream.close();
                aVar.close();
            } catch (Exception e) {
                RVLogger.w("AriverKernel:RemoteCall", "ObjSerializUtil deserializ2 exception: " + e.toString());
            }
        }
    }
}
