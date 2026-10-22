package com.efs.sdk.base.core.util.a;

import androidx.annotation.Nullable;
import com.acse.ottn.p3;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f29613a;
    Map<String, String> b;
    public byte[] c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    @Nullable
    public final /* synthetic */ HttpResponse a() {
        String str = this.e;
        str.hashCode();
        if (str.equals(p3.f)) {
            return HttpEnv.getInstance().getHttpUtil().get(this.f29613a, this.b);
        }
        if (str.equals("post")) {
            byte[] bArr = this.c;
            if (bArr == null || bArr.length <= 0) {
                return HttpEnv.getInstance().getHttpUtil().post(this.f29613a, this.b, this.d);
            }
            return this.g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.f29613a, this.b, this.c) : HttpEnv.getInstance().getHttpUtil().post(this.f29613a, this.b, this.c);
        }
        Log.e("efs.util.http", "request not support method '" + this.e + "'");
        return null;
    }
}
