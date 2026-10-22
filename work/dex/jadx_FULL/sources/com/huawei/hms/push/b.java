package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    public static List<SubscribedItem> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i = jSONObject.getInt(next);
                SubscribedItem subscribedItem = new SubscribedItem();
                subscribedItem.setEntityId(next);
                subscribedItem.setResultCode(i);
                arrayList.add(subscribedItem);
            }
            return arrayList;
        } catch (JSONException unused) {
            HMSLog.e("PushBaseUtils", "trans subscribedItem list occurs exception");
            return Collections.emptyList();
        }
    }
}
