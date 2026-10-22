package huachenjie.sdk.map.mapentry;

import android.text.TextUtils;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.lib_base.MapType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HCJMapEntry {
    private static HCJMapAdapter mInstance;

    public static HCJMapAdapter getInstance() {
        String str;
        HCJMapAdapter hCJMapAdapter = mInstance;
        if (hCJMapAdapter != null) {
            return hCJMapAdapter;
        }
        HCJMapFragment.mMapType = MapType.getMapType();
        try {
            if (MapType.getMapType() == 1) {
                str = ConstMap.AMAP_PATH;
            } else {
                if (MapType.getMapType() != 2) {
                    MapType.getMapType();
                }
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HCJMapAdapter hCJMapAdapter2 = (HCJMapAdapter) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            mInstance = hCJMapAdapter2;
            return hCJMapAdapter2;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load map module");
        }
    }
}
