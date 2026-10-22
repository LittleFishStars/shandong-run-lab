package com.igexin.base.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.igexin.base.api.SharedPreferencesManager;
import com.igexin.base.util.IOUtils;
import com.igexin.base.util.StringUtil;
import com.igexin.push.g.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class b implements Runnable {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<c> f37801a = new ArrayList();

    private b() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this, 5L, 5L, TimeUnit.SECONDS);
    }

    public static synchronized b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:112:0x0228  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x01f3 A[Catch: all -> 0x0220, TRY_ENTER, TryCatch #0 {all -> 0x0220, blocks: (B:87:0x01e0, B:99:0x01f3, B:100:0x01f8, B:103:0x0200, B:105:0x021c, B:106:0x021f), top: B:130:0x00e7 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.igexin.base.a.c] */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v11 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v14 */
    /* JADX WARN: Type inference failed for: r27v15 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    private static boolean a(c cVar) {
        ?? size;
        FileLock fileLock;
        JSONObject jSONObject;
        byte[] bArrA;
        boolean z;
        OutputStream outputStream;
        OutputStream fileOutputStream;
        ?? r27;
        ?? r9;
        boolean zIsEmpty;
        ?? r12;
        String str;
        ?? r28;
        String str2 = "logkey3";
        String str3 = "gbase";
        String string = "";
        str2 = null;
        try {
            File file = new File(cVar.a(cVar.f));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if ((!parentFile.exists() && !parentFile.mkdirs()) || !file.createNewFile()) {
                    return false;
                }
            }
            if (!file.isFile()) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            List<String> list = cVar.f37802a;
            while (true) {
                size = list.size();
                if (size <= 0) {
                    break;
                }
                sb.append(list.remove(0));
                sb.append("\r\n");
            }
            if (sb.length() <= 0) {
                return true;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock fileLockLock = randomAccessFile.getChannel().lock();
                    if (fileLockLock != null) {
                        try {
                            if (fileLockLock.isValid()) {
                                String string2 = sb.toString();
                                String str4 = cVar.e;
                                String md5 = StringUtil.getMD5(file.getAbsolutePath());
                                try {
                                    try {
                                        jSONObject = new JSONObject(SharedPreferencesManager.get("gbase").getParam("logkey3", "").toString());
                                        try {
                                            string = jSONObject.getString(md5);
                                        } catch (JSONException unused) {
                                        }
                                    } catch (JSONException unused2) {
                                        jSONObject = null;
                                    }
                                    String str5 = string;
                                    JSONObject jSONObject2 = jSONObject;
                                    if (TextUtils.isEmpty(str5)) {
                                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                                        keyGenerator.init(128);
                                        byte[] encoded = keyGenerator.generateKey().getEncoded();
                                        if (file.length() > 0) {
                                            file.delete();
                                        }
                                        bArrA = encoded;
                                        z = true;
                                    } else {
                                        bArrA = com.igexin.base.util.a.a.a(StringUtil.hexStringToBytes(str5), (TextUtils.isEmpty(str4) ? com.igexin.push.core.b.am : str4).getBytes());
                                        z = false;
                                    }
                                    try {
                                        try {
                                            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrA, "AES");
                                            byte[] bArr = new byte[16];
                                            try {
                                                try {
                                                    if (randomAccessFile.length() == 0) {
                                                        try {
                                                            String strBytesToHexString = StringUtil.bytesToHexString(secretKeySpec.getEncoded());
                                                            cVar = com.igexin.push.core.b.am;
                                                            try {
                                                                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(e.f38142a, 0)));
                                                                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
                                                                cipher.init(1, rSAPublicKey);
                                                                randomAccessFile.write(cipher.doFinal(strBytesToHexString.getBytes("UTF-8")));
                                                                new SecureRandom().nextBytes(bArr);
                                                                randomAccessFile.write(bArr);
                                                                str2 = "logkey3";
                                                                str = "gbase";
                                                                r28 = cVar;
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                str2 = "logkey3";
                                                                size = "gbase";
                                                                try {
                                                                    th.printStackTrace();
                                                                    fileOutputStream = new FileOutputStream(file, true);
                                                                    size = size;
                                                                    cVar = cVar;
                                                                } catch (IOException e) {
                                                                    e = e;
                                                                    outputStream = null;
                                                                    e.printStackTrace();
                                                                    r9 = size;
                                                                    r27 = cVar;
                                                                    IOUtils.close(outputStream);
                                                                    if (z) {
                                                                        if (jSONObject2 == null) {
                                                                            jSONObject2 = new JSONObject();
                                                                        }
                                                                        zIsEmpty = TextUtils.isEmpty(str4);
                                                                        r12 = str4;
                                                                        if (zIsEmpty) {
                                                                            r12 = r27;
                                                                        }
                                                                        jSONObject2.put(md5, StringUtil.bytesToHexString(com.igexin.base.util.a.a.a(bArrA, r12.getBytes())));
                                                                        SharedPreferencesManager.get(r9).saveParam(str2, jSONObject2.toString());
                                                                    }
                                                                    return fileLockLock == null ? true : true;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    outputStream = null;
                                                                    IOUtils.close(outputStream);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            cVar = com.igexin.push.core.b.am;
                                                        }
                                                    } else {
                                                        r28 = com.igexin.push.core.b.am;
                                                        if (randomAccessFile.length() < 144) {
                                                            throw new IllegalArgumentException("Invalid file length (need 2 blocks for iv and data)");
                                                        }
                                                        if (randomAccessFile.length() % 16 != 0) {
                                                            long length = (int) (randomAccessFile.length() % 16);
                                                            if (length < 16 && length > 0) {
                                                                randomAccessFile.setLength(randomAccessFile.length() - length);
                                                            }
                                                            randomAccessFile.seek(randomAccessFile.length() - 16);
                                                        } else {
                                                            randomAccessFile.seek(randomAccessFile.length() - 16);
                                                        }
                                                        randomAccessFile.read(bArr);
                                                        str = str3;
                                                    }
                                                    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                                    cipher2.init(1, secretKeySpec, new IvParameterSpec(bArr));
                                                    fileOutputStream = new CipherOutputStream(new FileOutputStream(randomAccessFile.getFD()), cipher2);
                                                    size = str;
                                                    cVar = r28;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    th.printStackTrace();
                                                    fileOutputStream = new FileOutputStream(file, true);
                                                    size = size;
                                                    cVar = cVar;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            fileLock = fileLockLock;
                                            if (fileLock != null && fileLock.isValid()) {
                                                fileLock.release();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        str2 = "logkey3";
                                        size = "gbase";
                                        fileLockLock = fileLockLock;
                                        cVar = com.igexin.push.core.b.am;
                                    }
                                    outputStream = fileOutputStream;
                                    try {
                                        try {
                                            outputStream.write(string2.getBytes("UTF-8"));
                                            r9 = size;
                                            r27 = cVar;
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            r9 = size;
                                            r27 = cVar;
                                        }
                                        IOUtils.close(outputStream);
                                        if (z) {
                                            if (jSONObject2 == null) {
                                                jSONObject2 = new JSONObject();
                                            }
                                            zIsEmpty = TextUtils.isEmpty(str4);
                                            r12 = str4;
                                            if (zIsEmpty) {
                                                r12 = r27;
                                            }
                                            jSONObject2.put(md5, StringUtil.bytesToHexString(com.igexin.base.util.a.a.a(bArrA, r12.getBytes())));
                                            SharedPreferencesManager.get(r9).saveParam(str2, jSONObject2.toString());
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        IOUtils.close(outputStream);
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    fileLock = fileLockLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    throw th;
                                }
                            } else {
                                fileLockLock = fileLockLock;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                        }
                    } else {
                        fileLockLock = fileLockLock;
                    }
                    if (fileLockLock == null && fileLockLock.isValid()) {
                        fileLockLock.release();
                        return true;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    fileLock = null;
                }
            } catch (Throwable unused3) {
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (c cVar : this.f37801a) {
            if (cVar.isEnabled()) {
                if (cVar.f37802a.size() >= cVar.b || SystemClock.elapsedRealtime() - cVar.d >= cVar.c) {
                    a(cVar);
                    cVar.d = SystemClock.elapsedRealtime();
                }
            }
        }
    }
}
