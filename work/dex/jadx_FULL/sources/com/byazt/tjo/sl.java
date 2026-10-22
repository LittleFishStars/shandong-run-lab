package com.byazt.tjo;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.omf.md;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 158})
public class sl implements Function<SparseArray<Object>, Object> {
    public md c;
    public n tt = new n();
    public x ve;

    public sl(md mdVar) {
        this.c = mdVar;
        this.ve = new x(this.c);
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        if (iIntValue == -99999986) {
            md mdVar = this.c;
            if (mdVar != null) {
                return mdVar.values();
            }
        } else if (iIntValue != -999800) {
            if (iIntValue == 8303 || iIntValue == 999801) {
                if (iIntValue == 8303) {
                    com.byazt.eu.tt.tt("TMe", "initRequestCondition getBridge");
                    return this.tt;
                }
                if (this.c != null) {
                    return this.ve;
                }
            }
        } else if (this.c != null) {
            Context context = (Context) pluginValueSetTt.objectValue(-998000, Context.class);
            return new sp(context, this.c.createLoader(context));
        }
        return null;
    }
}
