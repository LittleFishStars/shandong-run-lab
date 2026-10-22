package com.byazt.ch;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1054, 15})
public abstract class uj implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        return com.byazt.rl.c.c().tt();
    }

    public abstract Map<String, Object> getMediationExtraInfo();

    public abstract void loadDrawToken(Context context, c cVar, com.byazt.cw.c cVar2, Function<SparseArray<Object>, Object> function);

    public abstract void loadNativeToken(Context context, c cVar, com.byazt.cw.ve veVar, Function<SparseArray<Object>, Object> function);

    public abstract Object mtool(int i, PluginValueSet pluginValueSet);

    public abstract void preload(Activity activity, List<n> list, int i, int i2, Function<SparseArray<Object>, Object> function);

    public abstract void requestPermissionIfNecessary(Context context);

    public abstract void requestPermissionIfNecessary(Context context, int[] iArr);

    public abstract void setPulisherDid(String str);

    public abstract void setThemeStatus(int i);

    public abstract void setUserInfoForSegment(com.byazt.je.ve veVar);

    public abstract int showOpenOrInstallAppDialog(com.byazt.cw.uj ujVar);

    public abstract void updateLocalExtra(Map<String, Object> map);

    public abstract void updatePrivacyConfig(com.byazt.dj.uj ujVar);

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return values().sparseArray();
            case 270024:
                return getMediationExtraInfo();
            case 271043:
                return mtool(pluginValueSetTt.intValue(0), com.byazt.rl.c.c((SparseArray<Object>) pluginValueSetTt.objectValue(1, SparseArray.class)).tt());
            case 271050:
                updateLocalExtra((Map) pluginValueSetTt.objectValue(0, Map.class));
                return null;
            default:
                switch (iIntValue) {
                    case 270013:
                        Activity activity = (Activity) pluginValueSetTt.objectValue(0, Activity.class);
                        List arrayList = (List) pluginValueSetTt.objectValue(1, List.class);
                        if (arrayList == null) {
                            arrayList = new ArrayList(0);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new n((Function) it.next()));
                        }
                        preload(activity, arrayList2, pluginValueSetTt.intValue(2), pluginValueSetTt.intValue(3), (Function) pluginValueSetTt.objectValue(4, Function.class));
                        return null;
                    case 270014:
                        setUserInfoForSegment(new com.byazt.je.ve((SparseArray) pluginValueSetTt.objectValue(0, SparseArray.class)));
                        return null;
                    case 270015:
                        setPulisherDid((String) pluginValueSetTt.objectValue(0, String.class));
                        return null;
                    case 270016:
                        updatePrivacyConfig(new com.byazt.dj.uj((SparseArray) pluginValueSetTt.objectValue(0, SparseArray.class)));
                        return null;
                    case 270017:
                        requestPermissionIfNecessary((Context) pluginValueSetTt.objectValue(0, Context.class));
                        return null;
                    case 270018:
                        requestPermissionIfNecessary((Context) pluginValueSetTt.objectValue(0, Context.class), (int[]) pluginValueSetTt.objectValue(1, int[].class));
                        return null;
                    case 270019:
                        setThemeStatus(pluginValueSetTt.intValue(0));
                        return null;
                    case 270020:
                        return Integer.class.cast(Integer.valueOf(showOpenOrInstallAppDialog(new com.byazt.cw.uj((Function) pluginValueSetTt.objectValue(0, Function.class)))));
                    case 270021:
                        Context context = (Context) pluginValueSetTt.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetTt.objectValue(3, Function.class);
                        loadNativeToken(context, new c((SparseArray) pluginValueSetTt.objectValue(1, SparseArray.class), null), new com.byazt.cw.ve((Function) pluginValueSetTt.objectValue(2, Function.class)), function);
                        return null;
                    case 270022:
                        Context context2 = (Context) pluginValueSetTt.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSetTt.objectValue(3, Function.class);
                        loadDrawToken(context2, new c((SparseArray) pluginValueSetTt.objectValue(1, SparseArray.class), null), new com.byazt.cw.c((Function) pluginValueSetTt.objectValue(2, Function.class)), function2);
                        return null;
                    default:
                        return null;
                }
        }
    }
}
