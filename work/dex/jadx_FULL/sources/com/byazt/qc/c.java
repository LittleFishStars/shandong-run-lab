package com.byazt.qc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nys.i;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2241, 20})
public final class c implements Function<SparseArray<Object>, Object> {
    public static volatile c c;

    private Plugin c(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    public static c instance() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        String strC;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987);
        if (iIntValue != -99999986) {
            if (iIntValue != 13) {
                if (iIntValue == 109) {
                    c();
                } else {
                    if (iIntValue != 110) {
                        switch (iIntValue) {
                            case 4:
                                return Zeus.getPlugin(valueSetTt.stringValue(0)).mClassLoader;
                            case 5:
                                return Boolean.valueOf(Zeus.loadPlugin(valueSetTt.stringValue(0)));
                            case 6:
                                return Boolean.valueOf(Zeus.isPluginInstalled(valueSetTt.stringValue(0)));
                            case 7:
                                return Boolean.valueOf(Zeus.isPluginLoaded(valueSetTt.stringValue(0)));
                            case 8:
                                String strStringValue = valueSetTt.stringValue(0);
                                if (TextUtils.isEmpty(strStringValue)) {
                                    strC = "";
                                } else {
                                    strC = i.c(strStringValue);
                                    if (TextUtils.isEmpty(strC)) {
                                        strC = i.tt(strStringValue);
                                    }
                                }
                                return TextUtils.isEmpty(strC) ? "0.0.0.0" : strC;
                            default:
                                switch (iIntValue) {
                                    case 100:
                                        Zeus.unInstallPlugin(valueSetTt.stringValue(0), valueSetTt.intValue(1));
                                        return null;
                                    case 101:
                                        i.c(TTAppContextHolder.getContext());
                                        Plugin pluginC = c(valueSetTt);
                                        if (pluginC != null) {
                                            return Integer.valueOf(pluginC.getApiVersionCode());
                                        }
                                        return null;
                                    case 102:
                                        Plugin pluginC2 = c(valueSetTt);
                                        if (pluginC2 != null) {
                                            return Integer.valueOf(pluginC2.getInternalVersionCode());
                                        }
                                        return null;
                                    case 103:
                                        Plugin pluginC3 = c(valueSetTt);
                                        if (pluginC3 != null) {
                                            return Integer.valueOf(pluginC3.getVersion());
                                        }
                                        return null;
                                    case 104:
                                        return Boolean.valueOf(Zeus.isPluginLoaded(valueSetTt.stringValue(0)));
                                    case 105:
                                        return Boolean.valueOf(Zeus.isPluginInstalled(valueSetTt.stringValue(0)));
                                    case 106:
                                        TTPluginListener tTPluginListener = (TTPluginListener) valueSetTt.objectValue(0, TTPluginListener.class);
                                        if (tTPluginListener != null) {
                                            i.c(TTAppContextHolder.getContext()).tt(tTPluginListener);
                                        }
                                        return null;
                                }
                        }
                    }
                    Plugin pluginC4 = c(valueSetTt);
                    if (pluginC4 != null) {
                        return pluginC4.getInstalledVersionCodes();
                    }
                }
                return null;
            }
            Plugin pluginC5 = c(valueSetTt);
            if (pluginC5 != null) {
                return pluginC5.getJsonConfig();
            }
        }
        return ve.c().c(10000, 4).tt().sparseArray();
    }

    private void c() {
        if (Zeus.hasInit()) {
            return;
        }
        i.c(TTAppContextHolder.getContext());
    }
}
