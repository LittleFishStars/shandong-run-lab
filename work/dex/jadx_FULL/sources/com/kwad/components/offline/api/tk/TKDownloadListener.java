package com.kwad.components.offline.api.tk;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(@NonNull StyleTemplate styleTemplate);
}
