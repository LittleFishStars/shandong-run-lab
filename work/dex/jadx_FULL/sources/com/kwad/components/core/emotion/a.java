package com.kwad.components.core.emotion;

import android.app.Application;
import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static void a(final Application application) {
        new l<b, EmotionPackageResponse>() { // from class: com.kwad.components.core.emotion.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: at, reason: merged with bridge method [inline-methods] */
            public EmotionPackageResponse parseData(String str) {
                EmotionPackageResponse emotionPackageResponse = new EmotionPackageResponse();
                emotionPackageResponse.parseJson(new JSONObject(str));
                f.b(application, emotionPackageResponse.getFullJson());
                return emotionPackageResponse;
            }

            @NonNull
            private static b qO() {
                return new b();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return qO();
            }
        }.request(new g<b, EmotionPackageResponse>() { // from class: com.kwad.components.core.emotion.a.2
            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i, String str) {
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            }
        });
    }
}
