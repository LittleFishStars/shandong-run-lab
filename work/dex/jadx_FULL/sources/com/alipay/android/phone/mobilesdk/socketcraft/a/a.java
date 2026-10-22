package com.alipay.android.phone.mobilesdk.socketcraft.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements f {
    private final f b;
    private Map c;

    public a() {
        this(null);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.f
    public Object a(String str) {
        f fVar;
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Map map = this.c;
        Object obj = map != null ? map.get(str) : null;
        return (obj != null || (fVar = this.b) == null) ? obj : fVar.a(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.f
    public Object b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Map map = this.c;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    public a(f fVar) {
        this.c = null;
        this.b = fVar;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.f
    public void a(String str, Object obj) {
        if (str != null) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            this.c.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("Id may not be null");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.f
    public void a() {
        Map map = this.c;
        if (map != null) {
            map.clear();
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.a();
        }
    }
}
