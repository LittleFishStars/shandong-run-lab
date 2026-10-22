package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    public interface a {
        void aT(int i);

        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();

        void qG();

        boolean qH();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a.b$b, reason: collision with other inner class name */
    public static class C1280b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public final void aT(int i) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void qG() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final boolean qH() {
            return false;
        }
    }

    public static int I(Context context, String str) {
        return a(context, str, new C1280b());
    }

    public static int a(Context context, String str, @NonNull a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            if (TextUtils.isEmpty(str)) {
                aVar.aT(3);
            } else if (context == null) {
                aVar.aT(4);
            }
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri uri = Uri.parse(str);
            h hVar = (h) ServiceProvider.get(h.class);
            int iCQ = hVar != null ? hVar.cQ(uri.getScheme()) : -1;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: configFlags: " + iCQ);
            if (iCQ > 0) {
                intent.setFlags(iCQ);
            } else {
                intent.setFlags(268435456);
            }
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                aVar.onStart();
                context.startActivity(intent);
                aVar.onSuccess();
                return 1;
            }
            aVar.qG();
            if (!aVar.qH()) {
                return 0;
            }
            aVar.onStart();
            context.startActivity(intent);
            aVar.onSuccess();
            return 1;
        } catch (Throwable th) {
            aVar.onError(th);
            return -1;
        }
    }
}
