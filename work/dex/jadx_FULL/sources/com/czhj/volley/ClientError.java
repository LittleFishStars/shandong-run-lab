package com.czhj.volley;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ClientError extends ServerError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29461a;

    public ClientError() {
    }

    public ClientError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ClientError(String str, String str2) {
        super(str);
        this.f29461a = str2;
    }

    public String getRequest_id() {
        return this.f29461a;
    }
}
