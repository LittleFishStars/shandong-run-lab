package com.czhj.volley.toolbox;

import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Request;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseHttpStack {
    public abstract HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws AuthFailureError, IOException;
}
