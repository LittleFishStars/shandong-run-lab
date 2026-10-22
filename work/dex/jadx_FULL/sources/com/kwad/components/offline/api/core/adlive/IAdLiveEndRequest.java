package com.kwad.components.offline.api.core.adlive;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdLiveEndRequest {
    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();

    Map<String, String> getUrlParam();
}
