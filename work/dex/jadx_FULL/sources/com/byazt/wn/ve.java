package com.byazt.wn;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 54})
public class ve extends tt {
    public ve(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadFail(com.byazt.zm.c cVar) {
        if (hasNotifyFail()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
        } else {
            notifyLoadFail(new com.byazt.pp.c(49010, com.byazt.pp.c.c(49010), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.tt()));
        }
    }

    public void callLoadSucceed(List<Function<SparseArray<Object>, Object>> list) {
        if (list == null) {
            callLoadFail(new com.byazt.zm.c(49010, "list is null"));
            return;
        }
        if (hasNotifySuccess()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.byazt.uj.uj(this, it.next()));
        }
        notifyLoadSuccess(arrayList);
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean zIsExpressRender = isExpressRender();
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw loader : isExpressRender: " + zIsExpressRender);
            return (T) Boolean.valueOf(zIsExpressRender);
        }
        if (i == 8223) {
            boolean zIsNativeAd = isNativeAd();
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw loader : isNativeAd: " + zIsNativeAd);
            return (T) Boolean.valueOf(zIsNativeAd);
        }
        if (i != 8123) {
            if (i != 8107) {
                return null;
            }
            List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
            StringBuilder sb = new StringBuilder("Adn custom draw loader : callLoadSucceed  list size:");
            sb.append(list != null ? list.size() : 0);
            com.byazt.eu.tt.tt(MediationConstant.TAG, sb.toString());
            callLoadSucceed(list);
            return null;
        }
        int iIntValue = pluginValueSet.intValue(8014);
        String strStringValue = pluginValueSet.stringValue(8015);
        com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom draw loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
        callLoaderFail(iIntValue, strStringValue);
        return null;
    }

    public boolean isExpressRender() {
        com.byazt.ih.ve veVar = ((tt) this).tt;
        return veVar != null && veVar.tt() == 1;
    }

    public boolean isNativeAd() {
        com.byazt.ih.ve veVar = ((tt) this).tt;
        return veVar != null && veVar.tt() == 2;
    }
}
