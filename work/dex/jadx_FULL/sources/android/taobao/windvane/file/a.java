package android.taobao.windvane.file;

import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {
    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        return a(new File(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r5v7 */
    public static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileChannel channel;
        try {
            try {
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream((File) file);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                        channel.read(byteBufferAllocate);
                        byte[] bArrArray = byteBufferAllocate.array();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                        return bArrArray;
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                    channel = null;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (file == 0) {
                        throw th;
                    }
                    try {
                        file.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused7) {
            channel = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            file = 0;
        }
        TaoLog.w("FileAccesser", "read loacl file failed");
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused8) {
            }
        }
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException unused9) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[SYNTHETIC] */
    public static boolean a(File file, ByteBuffer byteBuffer) throws Throwable {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream = null;
        channel = null;
        FileChannel channel = null;
        fileOutputStream = null;
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return false;
                }
                parentFile.mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                channel = fileOutputStream2.getChannel();
                byteBuffer.position(0);
                channel.write(byteBuffer);
                channel.force(true);
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    channel.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                fileChannel = channel;
                fileOutputStream = fileOutputStream2;
                try {
                    String message = e.getMessage();
                    if (message != null && message.contains("ENOSPC")) {
                        throw new NotEnoughSpace("not enouth space in flash");
                    }
                    if (file != null) {
                        file.delete();
                    }
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                            throw th;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public static boolean a(String str, ByteBuffer byteBuffer) {
        if (str == null) {
            return false;
        }
        return a(new File(str), byteBuffer);
    }
}
