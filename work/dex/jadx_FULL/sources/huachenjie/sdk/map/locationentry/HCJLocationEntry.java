package huachenjie.sdk.map.locationentry;

import android.text.TextUtils;
import huachenjie.sdk.map.adapter.location.adapter.HCJLocationAdapter;
import huachenjie.sdk.map.lib_base.MapType;
import huachenjie.sdk.map.locationentry.consts.ConstLocation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HCJLocationEntry {
    private static HCJLocationAdapter mInstance;

    public static HCJLocationAdapter getInstance() {
        String str;
        HCJLocationAdapter hCJLocationAdapter = mInstance;
        if (hCJLocationAdapter != null) {
            return hCJLocationAdapter;
        }
        try {
            if (MapType.getMapType() == 1) {
                str = ConstLocation.AMAP_PATH;
            } else {
                if (MapType.getMapType() != 2) {
                    MapType.getMapType();
                }
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HCJLocationAdapter hCJLocationAdapter2 = (HCJLocationAdapter) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            mInstance = hCJLocationAdapter2;
            return hCJLocationAdapter2;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fail to load location module");
        }
    }
}
