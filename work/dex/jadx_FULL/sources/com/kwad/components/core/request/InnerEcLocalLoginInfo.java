package com.kwad.components.core.request;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class InnerEcLocalLoginInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -695874749919913665L;
    public long expire;
    public String serviceToken;
    public String sid;
    public long userId;
}
