package com.byazt.je;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 725, 20})
public class c {
    public final PluginValueSet c;

    public c(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
    }

    public JSONObject a() {
        return (JSONObject) this.c.objectValue(264106, JSONObject.class);
    }

    public String c() {
        return (String) this.c.objectValue(264101, String.class);
    }

    public boolean da() {
        return this.c.booleanValue(264110);
    }

    public boolean i() {
        return this.c.booleanValue(264109);
    }

    public boolean n() {
        return this.c.booleanValue(264105);
    }

    public String sl() {
        return (String) this.c.objectValue(264111, String.class);
    }

    public String sp() {
        return (String) this.c.objectValue(264107, String.class);
    }

    public boolean tt() {
        return this.c.booleanValue(264102);
    }

    public Map<String, Object> uj() {
        return (Map) this.c.objectValue(264104, Map.class);
    }

    public ve ve() {
        SparseArray sparseArray = (SparseArray) this.c.objectValue(264103, SparseArray.class);
        if (sparseArray == null) {
            return null;
        }
        return new ve(sparseArray);
    }

    public boolean x() {
        return this.c.booleanValue(264108);
    }
}
