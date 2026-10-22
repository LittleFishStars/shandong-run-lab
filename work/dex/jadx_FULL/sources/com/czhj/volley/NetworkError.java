package com.czhj.volley;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetworkError extends VolleyError {
    public NetworkError() {
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public NetworkError(Throwable th) {
        super(th);
    }
}
