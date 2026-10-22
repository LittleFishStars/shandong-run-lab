package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {

    public interface a {
        void b(AppStatusRules appStatusRules);

        void x(int i, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void dk(String str) {
                com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: HY, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.a createRequest() {
                return !t.UK() ? new com.kwad.sdk.collector.a.a(null) : new com.kwad.sdk.collector.a.a(bt.eD(context));
            }

            @NonNull
            private static AppStatusRules dl(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return dl(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.sdk.collector.a.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.x(i, str);
                }
            }
        });
    }
}
