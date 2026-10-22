package com.alibaba.triver.inside.impl;

import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.console.a.c;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Page f25000a;

    public a(Page page) {
        this.f25000a = page;
    }

    @Override // com.alibaba.ariver.console.a.c
    public void a(String str, JSONObject jSONObject) {
        EngineUtils.sendToRender(this.f25000a.getRender(), str, jSONObject, null);
    }

    @Override // com.alibaba.ariver.console.a.c
    public void b() {
        this.f25000a.destroy();
    }

    @Override // com.alibaba.ariver.console.a.c
    public View a() {
        return this.f25000a.getRender().getView();
    }
}
