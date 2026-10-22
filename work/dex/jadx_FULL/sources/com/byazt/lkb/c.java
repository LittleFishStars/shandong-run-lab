package com.byazt.lkb;

import android.util.SparseArray;
import com.byazt.je.ve;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1657, 20})
public class c {
    public PluginValueSet c;
    public com.byazt.dj.c tt;
    public com.byazt.je.c ve;

    private c(PluginValueSet pluginValueSet) {
        this.c = pluginValueSet;
        if (pluginValueSet != null) {
            com.byazt.dj.c cVar = new com.byazt.dj.c(pluginValueSet.sparseArray());
            this.tt = cVar;
            this.ve = cVar.z();
        }
    }

    public static c c(PluginValueSet pluginValueSet) {
        return new c(pluginValueSet);
    }

    public String a() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.tt();
        }
        return null;
    }

    public int da() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    public boolean gr() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.da();
        }
        return false;
    }

    public JSONObject gt() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    public boolean gu() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.i();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> h() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null && cVar.uj() != null) {
            Object obj = this.ve.uj().get("qa_common_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public String i() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.n();
        }
        return null;
    }

    public boolean m() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.tt();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> md() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null && cVar.uj() != null) {
            Object obj = this.ve.uj().get("qa_preview_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public boolean my() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.n();
        }
        return false;
    }

    public String n() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public ve nu() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.ve();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> p() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null && cVar.uj() != null) {
            Object obj = this.ve.uj().get("qa_onetap_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public boolean qy() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.x();
        }
        return false;
    }

    public Map<String, Object> rh() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.uj();
        }
        return null;
    }

    public String rl() {
        com.byazt.je.c cVar = this.ve;
        return cVar != null ? cVar.sp() : "";
    }

    public boolean sl() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.sp();
        }
        return false;
    }

    public boolean sp() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.ve();
        }
        return false;
    }

    public boolean t() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.da();
        }
        return false;
    }

    public PluginValueSet tt() {
        return this.c;
    }

    public int[] u() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.i();
        }
        return null;
    }

    public boolean uj() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.x();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> ve() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(15, Function.class);
        }
        return null;
    }

    public String x() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.uj();
        }
        return null;
    }

    public Map<String, Object> yp() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.nu();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> yv() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null && cVar.uj() != null) {
            Object obj = this.ve.uj().get("qa_event_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public String z() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> zm() {
        com.byazt.je.c cVar = this.ve;
        if (cVar != null && cVar.uj() != null) {
            Object obj = this.ve.uj().get("qa_config_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public boolean c() {
        com.byazt.dj.c cVar = this.tt;
        if (cVar != null) {
            return cVar.m();
        }
        return false;
    }
}
