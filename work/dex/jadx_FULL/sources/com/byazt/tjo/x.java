package com.byazt.tjo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.omf.md;
import com.byazt.omf.p;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.igexin.sdk.PushConsts;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 71})
public class x extends com.byazt.fb.uj {
    public final md c;
    public i tt;

    public x(md mdVar) {
        this.c = mdVar;
    }

    @DungeonFlag
    private void c(Object obj) {
        if (obj instanceof Function) {
            Function<SparseArray<Object>, Object> function = (Function) obj;
            if (c(function, "mediation_qa_common")) {
                com.byazt.lx.tt.getInstance().setQATool(function);
                com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
                ujVarC.c(10009).c(Void.class);
                ujVarC.c(PushConsts.SETTAG_IN_BLACKLIST, com.byazt.lx.tt.getInstance());
                function.apply(ujVarC.tt());
            }
        }
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Object objApply;
        if (i == -99999986) {
            md mdVar = this.c;
            if (mdVar != null) {
                return (T) mdVar.values();
            }
        } else if (i == 6) {
            Bundle bundle = pluginValueSet != null ? (Bundle) pluginValueSet.objectValue(10, Bundle.class) : null;
            Class cls2 = pluginValueSet != null ? (Class) pluginValueSet.objectValue(9, Class.class) : null;
            if (bundle != null && TextUtils.equals(bundle.getString("mediation_manager"), "mediation_manager")) {
                if (this.tt == null) {
                    this.tt = new i();
                }
                return (T) this.tt;
            }
            if (com.byazt.sq.uj.c(cls2, bundle)) {
                md mdVar2 = this.c;
                if (mdVar2 != null) {
                    Object objApply2 = mdVar2.apply(pluginValueSet.sparseArray());
                    if (objApply2 instanceof com.byazt.sq.uj.c) {
                        return (T) com.byazt.sq.uj.c(new da((com.byazt.sq.uj.c) objApply2), cls2, bundle);
                    }
                }
                return null;
            }
            md mdVar3 = this.c;
            if (mdVar3 != null) {
                return (T) mdVar3.apply(pluginValueSet.sparseArray());
            }
        } else if (i == 4) {
            Object objObjectValue = pluginValueSet != null ? pluginValueSet.objectValue(8, Object.class) : null;
            if (p.x() && (objObjectValue instanceof Function)) {
                Function function = (Function) objObjectValue;
                PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(com.byazt.yxi.ve.c((Function<SparseArray<Object>, Object>) function)).tt();
                if (pluginValueSetTt != null && pluginValueSetTt.intValue(10000) == 1 && (objApply = function.apply(com.byazt.yxi.uj.c().c(5).c(Object.class).tt())) != null) {
                    com.byazt.bp.c.t().c(objApply);
                }
            }
            if (com.byazt.omf.x.m().lr()) {
                c(objObjectValue);
            }
            md mdVar4 = this.c;
            if (mdVar4 != null) {
                return (T) mdVar4.apply(pluginValueSet.sparseArray());
            }
        } else {
            md mdVar5 = this.c;
            if (mdVar5 != null) {
                return (T) mdVar5.apply(pluginValueSet.sparseArray());
            }
        }
        return null;
    }

    private boolean c(Function function, String str) {
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        ujVarC.c(PushConsts.GET_SDKSERVICEPID).c(String.class);
        return str.equals(function.apply(ujVarC.tt()));
    }
}
