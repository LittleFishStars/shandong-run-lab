package com.alipay.android.phone.mrpc.core.a;

import android.util.Log;
import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.m.y.o;
import com.zj.adlib.u15;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public Object a() {
        try {
            String str = new String(this.b);
            Log.v("HttpCaller", "threadid = " + Thread.currentThread().getId() + "; rpc response:  " + str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt(o.f25542a);
            if (i == 1000) {
                return this.f25314a == String.class ? jSONObject.optString("result") : com.alipay.sdk.m.f.a.a(jSONObject.optString("result"), this.f25314a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("response  =");
            sb.append(new String(this.b));
            sb.append(u15.f19942b);
            sb.append(e);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e.getMessage());
        }
    }
}
