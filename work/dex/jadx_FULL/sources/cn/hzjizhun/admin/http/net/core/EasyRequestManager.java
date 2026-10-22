package cn.hzjizhun.admin.http.net.core;

import cn.hzjizhun.admin.http.net.EasyHttpConfig;
import cn.hzjizhun.admin.http.net.EasyHttpUtils;
import cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback;
import cn.hzjizhun.admin.http.net.thread.RequestTaskProxy;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyRequestManager {
    private HashMap<String, RequestTaskProxy> mRequestHashMap = new HashMap<>();

    public class a implements IBaseEasyCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseEasyCallback f22734a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Request f309a;

        public a(IBaseEasyCallback iBaseEasyCallback, Request request) {
            this.f22734a = iBaseEasyCallback;
            this.f309a = request;
        }

        @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
        public void onCancel() {
            IBaseEasyCallback iBaseEasyCallback = this.f22734a;
            if (iBaseEasyCallback != null) {
                iBaseEasyCallback.onCancel();
            }
            EasyRequestManager.this.removeRequest(this.f309a.tag.toString());
        }

        @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
        public void onFailure(EasyCall easyCall, Throwable th) {
            EasyHttpUtils.d("onFailure...." + this.f22734a);
            IBaseEasyCallback iBaseEasyCallback = this.f22734a;
            if (iBaseEasyCallback != null) {
                iBaseEasyCallback.onFailure(easyCall, th);
            }
            EasyRequestManager.this.removeRequest(this.f309a.tag.toString());
        }

        @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
        public void onResponse(EasyCall easyCall, HttpURLConnection httpURLConnection) {
            EasyHttpUtils.d("onResponse...." + this.f22734a);
            IBaseEasyCallback iBaseEasyCallback = this.f22734a;
            if (iBaseEasyCallback != null) {
                iBaseEasyCallback.onResponse(easyCall, httpURLConnection);
            }
            EasyRequestManager.this.removeRequest(this.f309a.tag.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRequest(Object obj) {
        try {
            this.mRequestHashMap.remove(obj.toString());
        } catch (Exception unused) {
        }
    }

    public void performCancelAll() {
        Iterator<Map.Entry<String, RequestTaskProxy>> it = this.mRequestHashMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
    }

    public void performCancelRequest(Object obj) {
        RequestTaskProxy requestTaskProxy = this.mRequestHashMap.get(obj.toString());
        if (requestTaskProxy != null) {
            requestTaskProxy.cancel();
        }
    }

    public void performRequest(EasyHttpConfig easyHttpConfig, Request request, IBaseEasyCallback iBaseEasyCallback) {
        RequestTaskProxy requestTaskProxy = new RequestTaskProxy(easyHttpConfig, request, new a(iBaseEasyCallback, request));
        this.mRequestHashMap.put(requestTaskProxy.getRequest().tag.toString(), requestTaskProxy);
        requestTaskProxy.start();
    }
}
