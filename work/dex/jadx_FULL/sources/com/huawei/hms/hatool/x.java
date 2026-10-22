package com.huawei.hms.hatool;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37591a = q0.i().getFilesDir().getPath();

    private String a(String str) {
        return this.f37591a + "/hms/component/".replace(AlibcProtocolConstant.CALL_TYPE_COMPONENT, str);
    }

    private void a(String str, String str2) throws Throwable {
        File file = new File(a(str));
        File file2 = new File(a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            v.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            k1.a(file2, str2);
        } else {
            v.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            v.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    private char[] a(String str, String str2, String str3, String str4) {
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] bArrHexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = bArrHexStr2ByteArray.length;
        if (length > bArrHexStr2ByteArray2.length) {
            length = bArrHexStr2ByteArray2.length;
        }
        if (length > bArrHexStr2ByteArray3.length) {
            length = bArrHexStr2ByteArray3.length;
        }
        if (length > bArrHexStr2ByteArray4.length) {
            length = bArrHexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((bArrHexStr2ByteArray[i] ^ bArrHexStr2ByteArray2[i]) ^ bArrHexStr2ByteArray3[i]) ^ bArrHexStr2ByteArray4[i]);
        }
        return cArr;
    }

    private String b(String str) throws Throwable {
        File file = new File(a(str), "hianalytics_" + str);
        if (a(file)) {
            return k1.a(file);
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        k1.a(file, strGenerateSecureRandomStr);
        return strGenerateSecureRandomStr;
    }

    private boolean b() {
        long jA = d.a(q0.i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != jA) {
            return System.currentTimeMillis() - jA > 31536000000L;
        }
        v.c("hmsSdk", "First init components");
        return true;
    }

    private static boolean b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    v.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean c() {
        return b(new File(q0.i().getFilesDir().getPath() + WVNativeCallbackUtil.SEPERATER + "hms"));
    }

    private String d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() throws Throwable {
        String strB;
        String strB2;
        String strB3;
        String strB4;
        String strD = d();
        if (b()) {
            v.c("hmsSdk", "refresh components");
            strB = EncryptUtil.generateSecureRandomStr(128);
            a("aprpap", strB);
            strB2 = EncryptUtil.generateSecureRandomStr(128);
            a("febdoc", strB2);
            strB3 = EncryptUtil.generateSecureRandomStr(128);
            a("marfil", strB3);
            strB4 = EncryptUtil.generateSecureRandomStr(128);
            a("maywnj", strB4);
            d.b(q0.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            strB = b("aprpap");
            strB2 = b("febdoc");
            strB3 = b("marfil");
            strB4 = b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(strB, strB2, strB3, strD), HexUtil.hexStr2ByteArray(strB4), 10000, 16));
    }
}
