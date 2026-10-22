package com.kwad.components.core.innerEc.followuser;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class a extends com.kwad.sdk.core.response.a.a {
    public String Tg;
    public int Th;

    public static a az(String str) {
        a aVar = new a();
        aVar.Tg = str;
        aVar.Th = 1;
        return aVar;
    }
}
