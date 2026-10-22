package com.alibaba.ariver.commonability.device.jsapi.system.field;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension;
import com.alibaba.ariver.commonability.device.jsapi.system.field.a.b;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.a;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.c;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.d;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.e;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.f;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.g;
import com.alibaba.ariver.commonability.device.jsapi.system.field.group.h;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class SystemInfoManager {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile SystemInfoManager sInstance;
    private Context mContext;
    private List<b> mFields;

    private SystemInfoManager(Context context) {
        ArrayList arrayList = new ArrayList();
        this.mFields = arrayList;
        arrayList.add(new c());
        this.mFields.add(new com.alibaba.ariver.commonability.device.jsapi.system.field.group.b());
        this.mFields.add(new g());
        this.mFields.add(new d());
        this.mFields.add(new f());
        this.mFields.add(new h());
        this.mFields.add(new a());
        this.mFields.add(new e());
        Iterator<b> it = this.mFields.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
        this.mContext = context;
    }

    private static JSONObject createJSONObject() {
        return new JSONObject();
    }

    public static SystemInfoManager getInstance() {
        return sInstance;
    }

    public static void init(Context context) {
        if (sInstance == null && context != null) {
            synchronized (SystemInfoManager.class) {
                sInstance = new SystemInfoManager(context);
            }
        }
    }

    public JSONObject getValues(App app, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return getValues(app);
        }
        JSONObject jSONObjectCreateJSONObject = createJSONObject();
        for (b bVar : this.mFields) {
            for (String str : strArr) {
                if (bVar.a().contains(str) && !jSONObjectCreateJSONObject.containsKey(str)) {
                    bVar.a(this.mContext, app, jSONObjectCreateJSONObject);
                }
            }
        }
        return jSONObjectCreateJSONObject;
    }

    private JSONObject getValues(App app) {
        JSONObject jSONObjectCreateJSONObject = createJSONObject();
        for (b bVar : this.mFields) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            bVar.a(this.mContext, app, jSONObjectCreateJSONObject);
            RVLogger.d(SystemInfoBridgeExtension.TAG, JSON.toJSONString(bVar.a()) + " cost time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return jSONObjectCreateJSONObject;
    }
}
