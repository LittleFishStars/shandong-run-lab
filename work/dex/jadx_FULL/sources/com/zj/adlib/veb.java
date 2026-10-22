package com.zj.adlib;

import android.util.Base64;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class veb {
    public static boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            qhb qhbVar = new qhb();
            qhbVar.f19105a.put("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
            qhbVar.f19105a.put("aps_c_src", Base64.encodeToString(qhb.a().getBytes(), 2));
            qhbVar.f19105a.put("aps_c_key", Base64.encodeToString(qhb.b().getBytes(), 2));
            qhbVar.f19107a = bArr;
            if (ccb.f40947a) {
                qhbVar.f19104a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                qhbVar.f19104a = (ccb.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            rhb rhbVarA = pfb.c().a(qhbVar);
            byte[] bArr2 = (rhbVarA == null || rhbVarA.f44458a != 200) ? null : rhbVarA.f19325a;
            return bArr2 != null && "true".equals(new String(bArr2, StandardCharsets.UTF_8));
        } catch (Exception e) {
            phb.a(e);
            return false;
        }
    }
}
