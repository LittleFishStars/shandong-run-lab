package com.zj.adlib;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g3c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f41814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Api.b f16694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Api f16695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Scope f16696a;
    public static final Api.AbstractClientBuilder b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @ShowFirstParty
    public static final Api.b f16697b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Api f16698b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Scope f16699b;

    static {
        Api.b bVar = new Api.b();
        f16694a = bVar;
        Api.b bVar2 = new Api.b();
        f16697b = bVar2;
        a0c a0cVar = new a0c();
        f41814a = a0cVar;
        h1c h1cVar = new h1c();
        b = h1cVar;
        f16696a = new Scope(dx7.f41301a);
        f16699b = new Scope("email");
        f16695a = new Api("SignIn.API", a0cVar, bVar);
        f16698b = new Api("SignIn.INTERNAL_API", h1cVar, bVar2);
    }
}
