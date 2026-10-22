package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.a.a;
import com.efs.sdk.base.core.util.concurrent.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HttpEnv {
    private List<b<HttpResponse>> mHttpListenerList;
    private IHttpUtil mHttpUtil;

    public static class SingletonHolder {
        private static final HttpEnv INSTANCE = new HttpEnv();

        private SingletonHolder() {
        }
    }

    public static HttpEnv getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addListener(@NonNull AbsHttpListener absHttpListener) {
        this.mHttpListenerList.add(absHttpListener);
    }

    public List<b<HttpResponse>> getHttpListenerList() {
        return new ArrayList(this.mHttpListenerList);
    }

    public IHttpUtil getHttpUtil() {
        return this.mHttpUtil;
    }

    public void removeListener(@NonNull AbsHttpListener absHttpListener) {
        this.mHttpListenerList.remove(absHttpListener);
    }

    public void setHttpUtil(IHttpUtil iHttpUtil) {
        this.mHttpUtil = iHttpUtil;
    }

    private HttpEnv() {
        this.mHttpUtil = a.a();
        this.mHttpListenerList = new ArrayList(1);
    }
}
