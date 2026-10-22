package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.sdk.commercial.convert.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    @NonNull
    public final ImpInfo abn;

    @NonNull
    public final com.kwad.components.core.request.c ajK;

    @Nullable
    public j ajL;

    @Nullable
    public List<String> ajM;
    public boolean ajN;
    public boolean ajO;

    @Nullable
    public c ajP;
    private String ajQ;

    /* JADX INFO: renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    public static class C1230a {
        public ImpInfo abn;
        public com.kwad.components.core.request.c ajK;
        public boolean ajN;
        public boolean ajO;
        public j ajR;

        public final C1230a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.ajK = cVar;
            return this;
        }

        public final C1230a aY(boolean z) {
            this.ajN = true;
            return this;
        }

        public final C1230a aZ(boolean z) {
            this.ajO = z;
            return this;
        }

        public final C1230a e(ImpInfo impInfo) {
            this.abn = impInfo;
            return this;
        }

        public final a wd() {
            if (com.kwad.components.ad.f.a.pe.booleanValue() && (this.abn == null || this.ajK == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C1230a a(j jVar) {
            this.ajR = jVar;
            return this;
        }
    }

    public /* synthetic */ a(C1230a c1230a, byte b) {
        this(c1230a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        e.a(aVar.abn.adScene, aVar.wc(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.ajK.a(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.ajK.a(adResultData, z);
        }
    }

    public final void bi(String str) {
        this.ajQ = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.abn.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.abn.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.abn.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final j wb() {
        return this.ajL;
    }

    public final String wc() {
        return !TextUtils.isEmpty(this.ajQ) ? this.ajQ : "network_only";
    }

    private a(C1230a c1230a) {
        this.abn = c1230a.abn;
        this.ajK = c1230a.ajK;
        this.ajN = c1230a.ajN;
        this.ajO = c1230a.ajO;
        this.ajL = c1230a.ajR;
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        aVar.ajK.a(i, str, z);
        e.a(aVar.getAdStyle(), i, str, aVar.wc());
    }
}
