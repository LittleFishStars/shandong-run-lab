package com.baidu.mshield.x0.i;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.d.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.mshield.b.d.a {
    public b c;

    public c(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public boolean a(String str) {
        com.baidu.mshield.b.c.a.b("j=" + str);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            byte[] bArrD = d.d();
            String strB = this.c.b(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(bArrD, e.a(com.baidu.mshield.utility.c.b(this.b)).getBytes()), 0)));
            byte[] bArrA = this.c.a(bArrD, str);
            if (bArrA == null) {
                return true;
            }
            try {
                String strA = a(strB, bArrA);
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                try {
                    new JSONObject(strA).getInt(ConnectionLog.CONN_LOG_STATE_RESPONSE);
                    return true;
                } catch (Throwable th) {
                    d.a(th);
                    return true;
                }
            } catch (Throwable th2) {
                d.a(th2);
                return false;
            }
        } catch (Throwable th3) {
            d.a(th3);
            return true;
        }
    }
}
