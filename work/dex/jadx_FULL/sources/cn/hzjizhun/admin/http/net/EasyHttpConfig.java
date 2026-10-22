package cn.hzjizhun.admin.http.net;

import cn.hzjizhun.admin.http.net.callback.InterceptRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyHttpConfig {
    public static boolean isDebug = false;
    private int connectTimeoutMillis = 15000;
    private List<InterceptRequest> interceptRequests = new ArrayList();
    private boolean isOpenRetry = true;
    private int readTimeoutMillis = 15000;
    private int retryCount = 3;
    private long retryIntervalMillis = 3000;

    public void addIntercepts(InterceptRequest interceptRequest) {
        this.interceptRequests.add(interceptRequest);
    }

    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public List<InterceptRequest> getInterceptRequests() {
        return this.interceptRequests;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public long getRetryIntervalMillis() {
        return this.retryIntervalMillis;
    }

    public boolean isOpenRetry() {
        return this.isOpenRetry;
    }

    public void setConnectTimeoutMillis(int i) {
        this.connectTimeoutMillis = i;
    }

    public void setOpenRetry(boolean z) {
        this.isOpenRetry = z;
    }

    public void setReadTimeoutMillis(int i) {
        this.readTimeoutMillis = i;
    }

    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    public void setRetryIntervalMillis(long j) {
        this.retryIntervalMillis = j;
    }
}
