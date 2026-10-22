package com.baidu.mshield.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.baidu.mshield.ac.F;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    public static String a(Context context, String str, boolean z, boolean z2) throws Throwable {
        return a(context, str, "", z, z2, true, null);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = bArrA[i];
            i2 = ((b & 255) + i2) & 255;
            bArrA[i] = bArrA[i2];
            bArrA[i2] = b;
            byte b2 = (byte) (bArrA[((bArrA[i] & 255) + (b & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = b2;
            bArr3[i3] = (byte) (b2 ^ 42);
        }
        return bArr3;
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        return a(context, str, str2, z, z2, false, "");
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3) throws Throwable {
        return a(context, str, str2, z, z2, false, str3);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3) throws Throwable {
        byte[] bytes;
        String strA;
        String str4 = "";
        if (!com.baidu.mshield.b.e.a.d(context)) {
            return "";
        }
        String[] strArrI = a.i(context);
        String str5 = strArrI[0];
        String str6 = strArrI[1];
        String strValueOf = String.valueOf(new Date().getTime() / 1000);
        String strA2 = com.baidu.mshield.b.f.e.a(str5 + strValueOf + str6);
        byte[] bArrA = com.baidu.mshield.core.b.a();
        com.baidu.mshield.b.c.a.b("after get aesKey:" + new String(bArrA));
        com.baidu.mshield.b.c.a.b("after get aesKey:base64:" + Base64.encode(bArrA, 0));
        if (!TextUtils.isEmpty(str2)) {
            byte[] bArrA2 = com.baidu.mshield.b.a.c.a(str2.getBytes());
            com.baidu.mshield.b.c.a.b("afterGzipPostBody,length=" + bArrA2.length);
            bytes = F.getInstance().ae(bArrA2, bArrA);
        } else {
            bytes = "".getBytes();
        }
        com.baidu.mshield.b.c.a.b("afterEncryptPostBody length=" + bytes.length + "," + new String(bytes));
        byte[] bytes2 = com.baidu.mshield.b.f.e.a(c.b(context)).getBytes();
        StringBuilder sb = new StringBuilder();
        sb.append("afterLoadRc4Key:");
        sb.append(new String(bytes2));
        com.baidu.mshield.b.c.a.b(sb.toString());
        byte[] bArrRe = F.getInstance().re(bArrA, bytes2);
        com.baidu.mshield.b.c.a.b("after ar:sKey length=" + bArrRe.length);
        String strEncodeToString = Base64.encodeToString(bArrRe, 0);
        com.baidu.mshield.b.c.a.b("after Base64:sKey=" + strEncodeToString);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(WVNativeCallbackUtil.SEPERATER);
        sb2.append("250");
        sb2.append(WVNativeCallbackUtil.SEPERATER);
        sb2.append(str5);
        sb2.append(WVNativeCallbackUtil.SEPERATER);
        sb2.append(strValueOf);
        sb2.append(WVNativeCallbackUtil.SEPERATER);
        sb2.append(strA2);
        if (!TextUtils.isEmpty(strEncodeToString)) {
            sb2.append("?skey=");
            sb2.append(URLEncoder.encode(strEncodeToString, "utf-8"));
        }
        com.baidu.mshield.b.c.a.b(sb2.toString());
        try {
            if (z3) {
                strA = new com.baidu.mshield.b.d.b(context, null).a(sb2.toString());
            } else {
                strA = new com.baidu.mshield.b.d.b(context, null).a(sb2.toString(), bytes);
            }
            str4 = strA;
        } catch (Throwable th) {
            a.a(th);
        }
        com.baidu.mshield.b.c.a.b("r:" + str4);
        if (z && TextUtils.isEmpty(str4)) {
            a(context);
            throw new NetworkErrorException("response is empty");
        }
        if (!z2) {
            return str4;
        }
        JSONObject jSONObject = new JSONObject(str4);
        String strOptString = jSONObject.optString("skey");
        com.baidu.mshield.b.c.a.b("base sKey from server:" + strOptString);
        byte[] bArrDecode = Base64.decode(strOptString, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + bArrDecode.length);
        byte[] bArrRd = F.getInstance().rd(bArrDecode, bytes2);
        com.baidu.mshield.b.c.a.b("after dr aes key:size=" + new String(bArrRd));
        String strOptString2 = jSONObject.optString(ConnectionLog.CONN_LOG_STATE_RESPONSE);
        com.baidu.mshield.b.c.a.b("plugins:requestId:" + jSONObject.optString("request_id"));
        com.baidu.mshield.b.c.a.b("plugins:response Base64:" + strOptString2);
        byte[] bArrDecode2 = Base64.decode(strOptString2, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + bArrDecode2.length);
        byte[] bArrAd = F.getInstance().ad(bArrDecode2, bArrRd);
        if (bArrDecode2.length > 0 && (bArrAd == null || bArrAd.length == 0)) {
            a.g(context);
            throw new NetworkErrorException("aes is fail");
        }
        String str7 = new String(bArrAd);
        com.baidu.mshield.b.c.a.b("sdk res:" + str7);
        return str7;
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            if (System.currentTimeMillis() - aVarA.y() > 86400000) {
                HashMap map = new HashMap();
                if (com.baidu.mshield.b.a.d.c(context)) {
                    map.put("0", Integer.valueOf(aVarA.A() + 1));
                    map.put("1", Integer.valueOf(aVarA.z()));
                } else {
                    map.put("0", Integer.valueOf(aVarA.A()));
                    map.put("1", Integer.valueOf(aVarA.z() + 1));
                }
                aVarA.d(0);
                aVarA.e(0);
                aVarA.j();
                a.a(context, "1067112", map);
                return;
            }
            if (com.baidu.mshield.b.a.d.c(context)) {
                aVarA.c(aVarA.A() + 1);
            } else {
                aVarA.b(aVarA.z() + 1);
            }
        } catch (Throwable th) {
            a.a(th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = bArr[length] & 255;
            byte b = bArr2[i3];
            i2 = (i4 + (b & 255) + i2) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
            length = (length + 1) % bArr.length;
        }
        return bArr2;
    }
}
