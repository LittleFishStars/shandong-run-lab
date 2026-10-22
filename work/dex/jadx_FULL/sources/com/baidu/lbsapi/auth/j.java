package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class j extends Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f26311a;

    public j(i iVar) {
        this.f26311a = iVar;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        if (!TextUtils.isEmpty(this.f26311a.g) && !TextUtils.isEmpty(this.f26311a.h)) {
            return new PasswordAuthentication(this.f26311a.g, this.f26311a.h.toCharArray());
        }
        b.a("Proxy Username or Password is null");
        return null;
    }
}
