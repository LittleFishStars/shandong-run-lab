package com.byazt.vnu;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 54})
public class ve {
    public int c(File file, boolean z, StringBuilder sb) {
        String string;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.byazt.uq.sp.c(zipFile2);
                    return 200;
                }
                if (z) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ");
                        sb.append(file2.getAbsolutePath());
                        com.byazt.uq.sp.c(zipFile2);
                        return 300;
                    }
                    string = com.byazt.uq.x.c(file2);
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    com.byazt.uq.x.c(zipFile2.getInputStream(entry), byteArrayOutputStream);
                    string = byteArrayOutputStream.toString();
                }
                if (TextUtils.isEmpty(string)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb.append(z);
                    com.byazt.uq.sp.c(zipFile2);
                    return 300;
                }
                JSONObject jSONObject = new JSONObject(string);
                JSONObject jSONObject2 = new JSONObject(string);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                final HashSet<String> hashSet = new HashSet<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add((String) jSONArray.get(i));
                }
                final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
                final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
                final int[] iArr = {0};
                try {
                    c(file, hashSet, new x() { // from class: com.byazt.vnu.ve.1
                        @Override // com.byazt.vnu.x
                        public int c(int i2) {
                            String str = "0x" + Integer.toHexString(i2);
                            String str2 = (String) jSONObject3.opt(str);
                            if (str2 == null) {
                                return i2;
                            }
                            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            if (identifier == 0) {
                                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll(LoginConstants.UNDER_LINE, Consts.DOT), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            }
                            if (identifier == 0) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                                return i2;
                            }
                            String str3 = "0x" + Integer.toHexString(identifier);
                            if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                                jSONObject4.remove(str);
                            }
                            try {
                                jSONObject4.put(str3, str2);
                            } catch (Throwable th) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
                            }
                            if (identifier != i2) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                            }
                            return identifier;
                        }

                        @Override // com.byazt.vnu.x
                        public boolean c(String str) {
                            return hashSet.contains(str);
                        }
                    });
                    ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                    if (com.byazt.uq.x.c(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                        com.byazt.uq.sp.c(zipFile2);
                        return 100;
                    }
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                    sb.append("writeText failed.");
                    com.byazt.uq.sp.c(zipFile2);
                    return 300;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    try {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                        sb.append("modifyRes failed. catch: ");
                        sb.append(th.getMessage());
                        return 300;
                    } finally {
                        if (zipFile != null) {
                            com.byazt.uq.sp.c(zipFile);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void c(File file, HashSet<String> hashSet, x xVar) throws Throwable {
        MappedByteBuffer mappedByteBufferC = c(file);
        int iC = c(mappedByteBufferC);
        if (iC != -1) {
            int i = mappedByteBufferC.getInt(iC + 12);
            int i2 = mappedByteBufferC.getInt(iC + 16);
            int i3 = i + i2;
            while (i2 < i3) {
                if (mappedByteBufferC.getInt(i2) == 33639248) {
                    int i4 = mappedByteBufferC.getShort(i2 + 28);
                    short s = mappedByteBufferC.getShort(i2 + 30);
                    byte[] bArr = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        bArr[i5] = mappedByteBufferC.get(i2 + 46 + i5);
                    }
                    String str = new String(bArr);
                    int i6 = mappedByteBufferC.getInt(i2 + 20);
                    int i7 = mappedByteBufferC.getInt(i2 + 24);
                    if (hashSet.contains(str)) {
                        if (i6 == i7) {
                            com.byazt.uq.n<Integer, byte[]> nVarC = c(mappedByteBufferC, mappedByteBufferC.getInt(i2 + 42), str);
                            try {
                                sl.c(str, nVarC.tt, xVar);
                                for (int i8 = 0; i8 < nVarC.tt.length; i8++) {
                                    mappedByteBufferC.put(nVarC.c.intValue() + i8, nVarC.tt[i8]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i2 += i4 + 46 + s;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + mappedByteBufferC.getInt(i2));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.byazt.uq.n<Integer, byte[]> c(MappedByteBuffer mappedByteBuffer, int i, String str) {
        if (mappedByteBuffer.getInt(i) == 67324752) {
            int i2 = mappedByteBuffer.getInt(i + 18);
            int i3 = mappedByteBuffer.getInt(i + 22);
            if (i2 == i3) {
                byte[] bArr = new byte[i3];
                int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr[i5] = mappedByteBuffer.get(i4 + i5);
                }
                return new com.byazt.uq.n<>(Integer.valueOf(i4), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
    }

    private int c(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && byteBuffer.getShort(i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public MappedByteBuffer c(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            ZeusLogger.d("temp-pxr", "mappedByteBuffer " + file.canWrite());
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                FileChannel channel = randomAccessFile2.getChannel();
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
                byte[] bArr = new byte[4194304];
                long j = size / PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                int i = (int) (size % PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED);
                for (int i2 = 0; i2 < j; i2++) {
                    map.get(bArr);
                }
                if (i > 0) {
                    map.get(new byte[i]);
                }
                map.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile2.close();
                return map;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
