package com.byazt.vnu;

import android.text.TextUtils;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 158})
public class sl {
    public static int c(sp spVar) {
        return (int) spVar.c.c().tt();
    }

    public static byte[] c(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int c(byte[] bArr, int i, int i2, x xVar) {
        if (i < 2130706432) {
            return i;
        }
        int iC = xVar.c(i);
        byte[] bArrC = c(iC);
        bArr[i2] = bArrC[0];
        bArr[i2 + 1] = bArrC[1];
        bArr[i2 + 2] = bArrC[2];
        bArr[i2 + 3] = bArrC[3];
        return iC;
    }

    public static void c(byte[] bArr, x xVar) throws IOException {
        tt ttVar = new tt(bArr, xVar);
        ttVar.tt(new ByteArrayInputStream(bArr));
        while (ttVar.ve() != 1) {
        }
    }

    public static void c(String str, byte[] bArr, x xVar) throws Throwable {
        if (!TextUtils.isEmpty(str) && xVar.c(str)) {
            if (str.equals("AndroidManifest.xml")) {
                c(bArr, xVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                c(bArr, xVar);
            } else if (str.equals("resources.arsc")) {
                new c(bArr, xVar).c();
            }
        }
    }

    public static void c(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (map.containsKey(Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                map2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i7, i7 + 20));
                map3.put(Integer.valueOf(map.get(Integer.valueOf(i6)).intValue()), Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) map2.get(Integer.valueOf(((Integer) map3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }
}
