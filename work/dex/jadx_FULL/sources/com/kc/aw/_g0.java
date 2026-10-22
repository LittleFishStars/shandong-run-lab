package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g0 {
    public static String _a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
            }
            String string = stringBuffer.toString();
            if (TextUtils.isEmpty(strSubstring)) {
                return string;
            }
            return string + Consts.DOT + strSubstring;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
