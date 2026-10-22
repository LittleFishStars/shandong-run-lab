package com.byazt.of;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.zj.adlib.u15;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1217, 34})
public class a {
    @DungeonFlag
    private static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(u15.f19942b);
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static JSONObject tt(List<c> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (c cVar : list) {
            if (cVar != null) {
                arrayList.add(c(cVar.tt()));
                arrayList2.add(String.valueOf(cVar.c()));
            }
        }
        c(jSONObject, UserTrackConstant.SIGN, arrayList, false);
        c(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    public static void c(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, n.c(list));
    }

    private static JSONObject c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        c(jSONObject, AliyunVodHttpCommon.Format.FORMAT_XML, arrayList, true);
        c(jSONObject, "png", arrayList2, true);
        c(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    public static long c(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j2;
            }
            j2 += (long) i;
        }
    }

    private static void c(File file, List<c> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                tt ttVarC = ve.c(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.byazt.ct.c.c(ttVarC, com.byazt.tdd.c.c(ttVarC)));
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    public static JSONObject c(File file) {
        JSONObject jSONObject;
        ZipFile zipFile;
        JSONObject jSONObject2;
        Enumeration<? extends ZipEntry> enumeration;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JSONObject jSONObject3 = new JSONObject();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        JSONObject jSONObject4 = new JSONObject();
        c(file, arrayList10);
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    long jC = 0;
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null) {
                            String name = zipEntryNextElement.getName();
                            if (!TextUtils.isEmpty(name) || !zipEntryNextElement.isDirectory()) {
                                String[] strArrSplit = name.split(WVNativeCallbackUtil.SEPERATER);
                                ArrayList arrayList11 = arrayList9;
                                ArrayList arrayList12 = arrayList10;
                                long size = zipEntryNextElement.getSize();
                                enumeration = enumerationEntries;
                                jSONObject2 = jSONObject3;
                                if (name.startsWith("res/drawable/")) {
                                    try {
                                        arrayList3 = arrayList8;
                                        if (name.length() > 13) {
                                            arrayList5.add(strArrSplit[2]);
                                        }
                                        arrayList2 = arrayList11;
                                        arrayList = arrayList12;
                                        arrayList8 = arrayList3;
                                        arrayList10 = arrayList;
                                        enumerationEntries = enumeration;
                                        arrayList9 = arrayList2;
                                        jSONObject3 = jSONObject2;
                                    } catch (Throwable unused) {
                                        jSONObject = jSONObject2;
                                        if (zipFile != null) {
                                            zipFile.close();
                                        }
                                        return jSONObject;
                                    }
                                } else {
                                    arrayList3 = arrayList8;
                                }
                                if (name.startsWith("res/") && strArrSplit.length == 2) {
                                    arrayList6.add(strArrSplit[1]);
                                } else if (name.startsWith("classes") && name.endsWith(".dex")) {
                                    jC += c(size, zipFile.getInputStream(zipEntryNextElement));
                                    arrayList9 = arrayList11;
                                    arrayList10 = arrayList12;
                                    enumerationEntries = enumeration;
                                    jSONObject3 = jSONObject2;
                                    arrayList8 = arrayList3;
                                } else if (name.startsWith("assets/") && strArrSplit.length >= 2) {
                                    arrayList4.add(strArrSplit[1]);
                                    if (name.startsWith("assets/assets/resources/native/") && strArrSplit.length >= 6 && jSONObject4.length() < 10) {
                                        if (!TextUtils.isEmpty(strArrSplit[4]) && !jSONObject4.has(strArrSplit[4])) {
                                            jSONObject4.put(strArrSplit[4], c(size, zipFile.getInputStream(zipEntryNextElement)));
                                        } else if (jSONObject4.has(strArrSplit[4])) {
                                            jSONObject4.put(strArrSplit[4], jSONObject4.getLong(strArrSplit[4]) + c(size, zipFile.getInputStream(zipEntryNextElement)));
                                        }
                                    }
                                } else {
                                    if (name.startsWith("lib/armeabi/") && name.length() > 12) {
                                        arrayList7.add(strArrSplit[2]);
                                    } else {
                                        if (name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                            arrayList8 = arrayList3;
                                            arrayList8.add(strArrSplit[2]);
                                            arrayList2 = arrayList11;
                                        } else {
                                            arrayList8 = arrayList3;
                                            if (name.startsWith("lib/arm64-v8a/") && name.length() > 14) {
                                                arrayList2 = arrayList11;
                                                arrayList2.add(strArrSplit[2]);
                                            } else {
                                                arrayList2 = arrayList11;
                                                if (((name.startsWith("META-INF/") && name.endsWith(".RSA")) || name.endsWith(".DSA") || name.endsWith(".EC")) && arrayList12.isEmpty()) {
                                                    try {
                                                        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                                        if (certificateFactory != null) {
                                                            for (Certificate certificate : certificateFactory.generateCertificates(zipFile.getInputStream(zipEntryNextElement))) {
                                                                if (certificate instanceof X509Certificate) {
                                                                    c cVar = new c(String.valueOf(((X509Certificate) certificate).getSubjectDN()), ((X509Certificate) certificate).getEncoded());
                                                                    arrayList = arrayList12;
                                                                    try {
                                                                        arrayList.add(cVar);
                                                                    } catch (CertificateException unused2) {
                                                                    }
                                                                } else {
                                                                    arrayList = arrayList12;
                                                                }
                                                                arrayList12 = arrayList;
                                                            }
                                                        }
                                                    } catch (CertificateException unused3) {
                                                    }
                                                }
                                            }
                                        }
                                        arrayList = arrayList12;
                                    }
                                    arrayList10 = arrayList;
                                    enumerationEntries = enumeration;
                                    arrayList9 = arrayList2;
                                    jSONObject3 = jSONObject2;
                                }
                                arrayList2 = arrayList11;
                                arrayList = arrayList12;
                                arrayList8 = arrayList3;
                                arrayList10 = arrayList;
                                enumerationEntries = enumeration;
                                arrayList9 = arrayList2;
                                jSONObject3 = jSONObject2;
                            }
                        }
                        jSONObject2 = jSONObject3;
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        enumeration = enumerationEntries;
                        arrayList10 = arrayList;
                        enumerationEntries = enumeration;
                        arrayList9 = arrayList2;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject2 = jSONObject3;
                    ArrayList arrayList13 = arrayList9;
                    ArrayList arrayList14 = arrayList10;
                    jSONObject = jSONObject2;
                    try {
                        jSONObject.put("apkSize", file.length());
                        jSONObject.put("dexSize", jC);
                        if (jSONObject4.length() > 0) {
                            jSONObject.put("cocos", jSONObject4);
                        }
                        c(jSONObject, "assets", arrayList4, false);
                        JSONObject jSONObject5 = new JSONObject();
                        c(jSONObject5, "eabi", arrayList7, false);
                        c(jSONObject5, "v7a", arrayList8, false);
                        c(jSONObject5, "v8a", arrayList13, false);
                        if (jSONObject5.length() > 0) {
                            jSONObject.put("lib", jSONObject5);
                        }
                        JSONObject jSONObjectC = c(arrayList5);
                        if (jSONObjectC != null && jSONObjectC.length() > 0) {
                            jSONObject.put("drawable", jSONObjectC);
                        }
                        JSONObject jSONObjectC2 = c(arrayList6);
                        if (jSONObjectC2 != null && jSONObjectC2.length() > 0) {
                            jSONObject.put("res", jSONObjectC2);
                        }
                        JSONObject jSONObjectTt = tt(arrayList14);
                        if (jSONObjectTt.length() > 0) {
                            jSONObject.put("signInfo", jSONObjectTt);
                        }
                    } catch (Throwable unused4) {
                        if (zipFile != null) {
                        }
                        return jSONObject;
                    }
                } catch (Throwable unused5) {
                    jSONObject = jSONObject3;
                }
            } catch (Throwable unused6) {
                jSONObject = jSONObject3;
                zipFile = null;
            }
            zipFile.close();
        } catch (IOException unused7) {
        }
        return jSONObject;
    }
}
