package com.byazt.uj;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 54})
public abstract class ve extends com.byazt.yl.ve {
    public Function<SparseArray<Object>, Object> i;
    public com.byazt.wn.tt x;

    public ve(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        this.x = ttVar;
        this.i = function;
    }

    @Override // com.byazt.yl.ve
    public void bidLoseNotify(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int i = 10001;
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue > 0) {
                i = iIntValue;
            }
        } catch (Exception unused) {
        }
        receiveBidResult(false, -1.0d, i, null);
    }

    @Override // com.byazt.yl.ve
    public void bidWinNotify(Map<String, Object> map) {
        receiveBidResult(true, getCpm(), -1, null);
    }

    @Override // com.byazt.yl.ve
    public boolean hasDestroyed() {
        return false;
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        com.byazt.wn.tt ttVar = this.x;
        return ttVar != null ? ttVar.isReadyStatus() : super.isReadyStatus();
    }

    @Override // com.byazt.yl.ve
    public void onDestroy() {
        super.onDestroy();
        com.byazt.wn.tt ttVar = this.x;
        if (ttVar != null) {
            ttVar.onDestroy();
        }
    }

    @Override // com.byazt.yl.ve
    public void onPause() {
        super.onPause();
        com.byazt.wn.tt ttVar = this.x;
        if (ttVar != null) {
            ttVar.onPause();
        }
    }

    @Override // com.byazt.yl.ve
    public void onResume() {
        super.onResume();
        com.byazt.wn.tt ttVar = this.x;
        if (ttVar != null) {
            ttVar.onResume();
        }
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        com.byazt.wn.tt ttVar = this.x;
        if (ttVar != null) {
            ttVar.receiveBidResult(z, d, i, map);
        }
    }
}
