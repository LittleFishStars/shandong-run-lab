package com.ali.auth.third.login.task;

import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.rpc.PureHttpConnectionHelper;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.util.QRCodeUtil;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoadQrCodePicTask extends AbsAsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultCallback f23475a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f23476a;

        public a(Map map) {
            this.f23476a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadQrCodePicTask.this.f23475a.onSuccess(this.f23476a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadQrCodePicTask.this.f23475a.onFailure(0, "");
        }
    }

    public LoadQrCodePicTask(ResultCallback resultCallback) {
        this.f23475a = resultCallback;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public Object asyncExecute(Object[] objArr) {
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(PureHttpConnectionHelper.get(ConfigManager.getQrCodeContentUrl));
            JSONUtils.toMap(map, jSONObject);
            int iIntValue = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
            int iIntValue2 = (objArr == null || objArr.length < 1) ? 480 : ((Integer) objArr[0]).intValue();
            if (objArr != null && objArr.length >= 2) {
                iIntValue = ((Integer) objArr[1]).intValue();
            }
            map.put("imageBitMap", QRCodeUtil.createQRCodeBitmap(jSONObject.getString("url"), iIntValue2, iIntValue, (objArr == null || objArr.length < 3) ? null : (String) objArr[2]));
            KernelContext.executorService.postUITask(new a(map));
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        KernelContext.executorService.postUITask(new b());
    }
}
