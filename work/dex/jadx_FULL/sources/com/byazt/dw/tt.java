package com.byazt.dw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 513, 13})
public abstract class tt implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    private PluginValueSet c() {
        return com.byazt.rl.c.c().tt();
    }

    public abstract int getCallToActionId();

    public abstract int getDecriptionTextId();

    public abstract Map<String, Integer> getExtras();

    public abstract int getGroupImage1Id();

    public abstract int getGroupImage2Id();

    public abstract int getGroupImage3Id();

    public abstract int getIconImageId();

    public abstract int getLayoutId();

    public abstract int getLogoLayoutId();

    public abstract int getMainImageId();

    public abstract int getMediaViewId();

    public abstract int getShakeViewContainerId();

    public abstract int getSourceId();

    public abstract int getTitleId();

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            PluginValueSet pluginValueSet = this.c;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
            PluginValueSet pluginValueSetC = c();
            this.c = pluginValueSetC;
            return pluginValueSetC.sparseArray();
        }
        switch (iIntValue) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(getShakeViewContainerId()));
            case 271034:
                return getExtras();
            default:
                return null;
        }
    }
}
