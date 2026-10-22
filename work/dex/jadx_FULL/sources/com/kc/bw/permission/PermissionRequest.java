package com.kc.bw.permission;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class PermissionRequest {
    public final OnRequestCallback onRequestCallback;
    public final String[] permissions;
    public final int requestCode;

    @Keep
    public static class Builder {
        public OnRequestCallback onRequestCallback;
        public String[] permissions;
        public int requestCode;
        public WMPermission wmPermission;

        public Builder(WMPermission wMPermission) {
            this.wmPermission = wMPermission;
        }

        public boolean check() {
            String[] strArr = this.permissions;
            if (strArr == null || strArr.length == 0) {
                throw new IllegalStateException("permissions must be not null or empty");
            }
            return this.wmPermission.check(new PermissionRequest(this));
        }

        public Builder permissions(String... strArr) {
            this.permissions = strArr;
            return this;
        }

        public void request(int i, OnRequestCallback onRequestCallback) {
            if (i < 0) {
                throw new IllegalStateException("requestCode must be >=0");
            }
            if (onRequestCallback == null) {
                throw new NullPointerException("onRequestCallback==null");
            }
            String[] strArr = this.permissions;
            if (strArr == null || strArr.length == 0) {
                throw new IllegalStateException("permissions must be not null or empty");
            }
            this.onRequestCallback = onRequestCallback;
            this.requestCode = i;
            this.wmPermission.request(new PermissionRequest(this));
        }
    }

    public PermissionRequest(Builder builder) {
        this.onRequestCallback = builder.onRequestCallback;
        this.permissions = builder.permissions;
        this.requestCode = builder.requestCode;
    }
}
