package com.alibaba.ariver.permission.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ApiPermissionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24364a = false;
    private Map<String, List<String>> b = new HashMap();
    private Map<String, String> c = new HashMap();

    public void clear() {
        this.b.clear();
        this.b = null;
        this.c.clear();
        this.c = null;
    }

    public List<String> getApiLevelList(String str) {
        return this.b.get(str);
    }

    public String getApiLevelStr(String str) {
        return this.c.get(str);
    }

    public boolean isHasPermissionFile() {
        return this.f24364a;
    }

    public void setApiLevelList(String str, List<String> list) {
        this.b.put(str, list);
    }

    public void setApiLevelStr(String str, String str2) {
        this.c.put(str, str2);
    }

    public void setHasPermissionFile(boolean z) {
        this.f24364a = z;
    }
}
