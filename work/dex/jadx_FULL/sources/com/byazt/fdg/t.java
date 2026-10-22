package com.byazt.fdg;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 66})
public class t implements sl {
    public static final long c = Os.sysconf(OsConstants._SC_PAGESIZE);
    public final FileDescriptor tt;
    public final long uj;
    public final long ve;

    public t(FileDescriptor fileDescriptor, long j, long j2) {
        this.tt = fileDescriptor;
        this.ve = j;
        this.uj = j2;
    }

    @Override // com.byazt.fdg.sl
    public long c() {
        return this.uj;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.fdg.sl
    public void c(da daVar, long j, int i) throws Throwable {
        long j2;
        long jMmap;
        int iIntValue;
        ByteBuffer byteBuffer;
        long j3 = this.ve + j;
        long j4 = c;
        long j5 = (j3 / j4) * j4;
        int i2 = (int) (j3 - j5);
        long j6 = i + i2;
        try {
            try {
                ByteBuffer byteBuffer2 = null;
                if (com.byazt.uq.i.da()) {
                    try {
                        iIntValue = ((Integer) FieldUtils.readField(OsConstants.class.getField("MAP_POPULATE"), (Object) null)).intValue();
                    } catch (IllegalAccessException e) {
                        com.byazt.bog.a.c(e);
                        iIntValue = 0;
                    } catch (Exception e2) {
                        com.byazt.bog.a.c(e2);
                        iIntValue = 0;
                    }
                } else {
                    iIntValue = 0;
                }
                jMmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.tt, j5);
                try {
                    try {
                        if (com.byazt.uq.i.t()) {
                            try {
                                Class<?> cls = Class.forName("java.nio.DirectByteBuffer");
                                Class<?>[] clsArr = {Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                                Constructor<?> constructor = cls.getConstructor(clsArr);
                                if (constructor == null) {
                                    constructor = cls.getDeclaredConstructor(clsArr);
                                }
                                if (constructor != null) {
                                    constructor.setAccessible(true);
                                    byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.tt, null, Boolean.TRUE);
                                    byteBuffer2 = byteBuffer;
                                }
                            } catch (ClassNotFoundException e3) {
                                com.byazt.bog.a.c(e3);
                            } catch (IllegalAccessException e4) {
                                com.byazt.bog.a.c(e4);
                            } catch (InstantiationException e5) {
                                com.byazt.bog.a.c(e5);
                            } catch (InvocationTargetException e6) {
                                com.byazt.bog.a.c(e6);
                            } catch (Exception e7) {
                                com.byazt.bog.a.c(e7);
                            }
                        } else {
                            try {
                                Constructor<?> declaredConstructor = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                                if (declaredConstructor != null) {
                                    declaredConstructor.setAccessible(true);
                                    byteBuffer = (ByteBuffer) declaredConstructor.newInstance(Long.valueOf(((long) i2) + jMmap), Integer.valueOf(i));
                                    byteBuffer2 = byteBuffer;
                                }
                            } catch (ClassNotFoundException e8) {
                                com.byazt.bog.a.c(e8);
                            } catch (IllegalAccessException e9) {
                                com.byazt.bog.a.c(e9);
                            } catch (InstantiationException e10) {
                                com.byazt.bog.a.c(e10);
                            } catch (InvocationTargetException e11) {
                                com.byazt.bog.a.c(e11);
                            } catch (Exception e12) {
                                com.byazt.bog.a.c(e12);
                            }
                        }
                        daVar.c(byteBuffer2);
                        if (jMmap != 0) {
                            try {
                                Os.munmap(jMmap, j6);
                            } catch (ErrnoException unused) {
                            }
                        }
                    } catch (ErrnoException e13) {
                        e = e13;
                        throw new IOException("Failed to mmap " + j6 + " bytes", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    j2 = 0;
                    if (jMmap != j2) {
                        try {
                            Os.munmap(jMmap, j6);
                        } catch (ErrnoException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (ErrnoException e14) {
                e = e14;
                jMmap = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
            jMmap = 0;
            if (jMmap != j2) {
                Os.munmap(jMmap, j6);
            }
            throw th;
        }
    }
}
