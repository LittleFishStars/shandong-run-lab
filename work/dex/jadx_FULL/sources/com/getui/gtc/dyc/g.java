package com.getui.gtc.dyc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dyc.b.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class g {

    /* JADX INFO: renamed from: com.getui.gtc.dyc.g$1, reason: invalid class name */
    public class AnonymousClass1 implements Call.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f30346a;
        final /* synthetic */ d c;
        final /* synthetic */ b d;

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onFailure(Call call, Exception exc) {
            c cVar = this.f30346a;
            if (cVar != null) {
                cVar.a(exc);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onResponse(Call call, Response response) {
            try {
                h hVarA = this.c.a(this.d, response);
                c cVar = this.f30346a;
                if (cVar != null) {
                    cVar.a(hVarA);
                }
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
                c cVar2 = this.f30346a;
                if (cVar2 != null) {
                    cVar2.a(th);
                }
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f30347a = new g(null);
    }

    public interface c {
        void a(h hVar);

        void a(Throwable th);
    }

    private g() {
        a(GtcProvider.context());
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a() {
        return a.f30347a;
    }

    private void a(Context context) {
        try {
            Bundle bundle = CommonUtil.getAppInfoForSelf(context).metaData;
            if (bundle != null) {
                String string = bundle.getString("DYC_P");
                if (!TextUtils.isEmpty(string)) {
                    d.f30340a = string;
                }
                String string2 = bundle.getString("DYC_K");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                d.c = string2;
            }
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }

    public h a(b bVar) throws Exception {
        return new d().a(bVar);
    }
}
