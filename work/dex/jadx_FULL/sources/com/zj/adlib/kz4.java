package com.zj.adlib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class kz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jz4 f17836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MappedByteBuffer f17837a;

    @KeepForSdk
    public kz4(@NonNull Context context, @NonNull jz4 jz4Var) {
        this.f42952a = context;
        this.f17836a = jz4Var;
    }

    @NonNull
    @KeepForSdk
    public jz4 a() {
        return this.f17836a;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer b() throws MlKitException, IllegalAccessException, InvocationTargetException {
        yw6.m(this.f42952a, "Context can not be null");
        yw6.m(this.f17836a, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.f17837a;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String strA = this.f17836a.a();
        String strB = this.f17836a.b();
        Uri uriC = this.f17836a.c();
        if (strA != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(strA, "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        this.f17837a = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        channel.close();
                        randomAccessFile.close();
                        return this.f17837a;
                    } catch (Throwable th) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th2) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th4) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.f17836a.a())), 14, e);
            }
        }
        if (strB == null) {
            if (uriC == null) {
                throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
            }
            try {
                AssetFileDescriptor assetFileDescriptorA = u3d.a(this.f42952a, uriC, "r");
                try {
                    FileChannel channel2 = assetFileDescriptorA.createInputStream().getChannel();
                    try {
                        this.f17837a = channel2.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorA.getStartOffset(), assetFileDescriptorA.getLength());
                        channel2.close();
                        assetFileDescriptorA.close();
                        return this.f17837a;
                    } catch (Throwable th5) {
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (Throwable th6) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th5, th6);
                            }
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    if (assetFileDescriptorA != null) {
                        try {
                            assetFileDescriptorA.close();
                        } catch (Throwable th8) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th7, th8);
                        }
                    }
                    throw th7;
                }
            } catch (IOException e2) {
                throw new MlKitException("Can not load the file from URI: ".concat(uriC.toString()), 14, e2);
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.f42952a.getAssets().openFd(strB);
            try {
                FileChannel channel3 = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel();
                try {
                    this.f17837a = channel3.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                    channel3.close();
                    assetFileDescriptorOpenFd.close();
                    return this.f17837a;
                } catch (Throwable th9) {
                    if (channel3 != null) {
                        try {
                            channel3.close();
                        } catch (Throwable th10) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th9, th10);
                        }
                    }
                    throw th9;
                }
            } catch (Throwable th11) {
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (Throwable th12) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th11, th12);
                    }
                }
                throw th11;
            }
        } catch (IOException e3) {
            throw new MlKitException("Can not load the file from asset: " + strB + ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression", 14, e3);
        }
    }
}
