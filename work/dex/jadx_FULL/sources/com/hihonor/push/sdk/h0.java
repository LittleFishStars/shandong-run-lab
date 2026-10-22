package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class h0 extends IPushCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32650a;
    public final i0 b;

    public h0(Object obj, i0 i0Var) {
        this.f32650a = obj;
        this.b = i0Var;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Log.i("IPCCallback", "onResult parse start.");
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f32650a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        i0 i0Var = this.b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f32650a;
        z.b bVar = (z.b) i0Var;
        bVar.getClass();
        z zVar = z.c;
        f1<?> f1Var = bVar.f32687a;
        zVar.getClass();
        Log.i("HonorApiManager", "sendResolveResult start");
        Handler handler = zVar.f32685a;
        handler.sendMessage(handler.obtainMessage(2, f1Var));
        bVar.f32687a.b(apiException, obj2);
        Log.i("IPCCallback", "onResult parse end.");
    }
}
