package com.alibaba.ariver.app.api.point.dialog;

import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateActionSheetParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f23820a;
    private ArrayList<String> b;
    private ArrayList<JSONObject> c;
    private String d;
    private BridgeCallback e;

    public CreateActionSheetParam(Context context, ArrayList<String> arrayList, ArrayList<JSONObject> arrayList2, String str, BridgeCallback bridgeCallback) {
        this.f23820a = context;
        this.b = arrayList;
        this.c = arrayList2;
        this.d = str;
        this.e = bridgeCallback;
    }

    public ArrayList<JSONObject> getBadgeList() {
        return this.c;
    }

    public BridgeCallback getBridgeContext() {
        return this.e;
    }

    public Context getContext() {
        return this.f23820a;
    }

    public ArrayList<String> getList() {
        return this.b;
    }

    public String getTitle() {
        return this.d;
    }
}
