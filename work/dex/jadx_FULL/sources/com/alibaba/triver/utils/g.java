package com.alibaba.triver.utils;

import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.proxy.ISecurityProxy;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {
    @RequiresApi(api = 8)
    public static String a(List<String> list) {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            return ((ISecurityProxy) RVProxy.get(ISecurityProxy.class)).encryptString(a(Base64.encodeToString(sb.toString().getBytes("utf-8"), 2)));
        } catch (Exception e) {
            RVLogger.e("SignUtils", "generateSignStr error", e);
            return null;
        }
    }

    public static String a(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Throwable th) {
            RVLogger.e("CommonUtils", "stringToMD5 error", th);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static List<String> a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (String str : set) {
            if (arrayList.isEmpty()) {
                arrayList.add(str);
            } else if (str.compareToIgnoreCase((String) arrayList.get(0)) < 0) {
                arrayList.add(0, str);
            } else {
                int size = arrayList.size();
                int i = 1;
                while (true) {
                    if (i >= size) {
                        i = -1;
                        break;
                    }
                    if (str.compareToIgnoreCase((String) arrayList.get(i)) < 0) {
                        break;
                    }
                    i++;
                }
                if (i > 0) {
                    arrayList.add(i, str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
