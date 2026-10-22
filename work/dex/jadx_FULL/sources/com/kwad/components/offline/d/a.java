package com.kwad.components.offline.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a implements com.kwad.components.core.offline.a.e.a {
    private final IObiwanOfflineCompo axM;

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.axM = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.axM.getLog();
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.axM.priority();
    }

    public final void updateConfigs() {
        this.axM.updateConfigs();
    }
}
