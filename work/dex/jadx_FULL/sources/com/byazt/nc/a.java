package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 34})
public class a implements Function<SparseArray<Object>, Object> {
    public Function<SparseArray<Object>, Object> c;

    public a(Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> function2 = com.byazt.rl.c.tt;
        this.c = function2;
        this.c = function == null ? function2 : function;
    }

    public void addOption(a aVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, aVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public String getId() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public boolean getIsSelected() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public String getName() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public List<a> getOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.c.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new a(com.byazt.gxc.ve.c(it.next())));
        }
        return arrayList2;
    }

    public boolean hasSecondOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public boolean isValid() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public void setIsSelected(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
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
        if (iIntValue == -99999986) {
            return new SparseArray();
        }
        switch (iIntValue) {
            case 241101:
                addOption(new a((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 241102:
                setIsSelected(pluginValueSetTt.booleanValue(0));
                return null;
            case 241103:
                return getId();
            case 241104:
                return getName();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(getIsSelected()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(hasSecondOptions()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(isValid()));
            case 241108:
                return getOptions();
            default:
                return null;
        }
    }
}
