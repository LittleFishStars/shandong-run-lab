package com.baidu.location;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String str, int i) {
    }

    public void onLocDiagnosticMessage(int i, int i2, String str) {
    }

    public void onReceiveLocString(String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);

    public void onReceiveVdrLocation(BDLocation bDLocation) {
    }
}
