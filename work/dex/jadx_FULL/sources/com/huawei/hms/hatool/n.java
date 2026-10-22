package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f37574a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i) {
        if (str == null || str.length() < i) {
            return new Pair<>(new byte[0], str);
        }
        String strSubstring = str.substring(0, i);
        return new Pair<>(HexUtil.hexStr2ByteArray(strSubstring), str.substring(i));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> pairA = a(str, 32);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) pairA.second), HexUtil.hexStr2ByteArray(str2), (byte[]) pairA.first), f37574a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (bArrHexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesGcm.encrypt(bArr, bArrHexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f37574a), HexUtil.hexStr2ByteArray(str2)));
    }
}
