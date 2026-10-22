package com.kwad.sdk.core.response.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.a.hl;
import com.kwad.sdk.core.d;
import com.kwad.sdk.core.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements b {
    private static final List<String> WHITE_LIST;
    private final List<d<a>> mHolders = new ArrayList();

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("com.kwad.sdk.core.report.BaseReportAction");
    }

    public a() {
        initHolders();
    }

    private d<a> getHolder(Class<? extends a> cls) {
        if (a.class.equals(cls) || WHITE_LIST.contains(cls.getName())) {
            return null;
        }
        return hl.getHolder(cls);
    }

    private void initHolders() {
        for (Class<?> superclass = getClass(); superclass != null && a.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
            d<a> holder = getHolder(superclass);
            if (holder != null) {
                this.mHolders.add(0, holder);
            }
        }
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void beforeToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        List<d<a>> list = this.mHolders;
        if (list == null || list.isEmpty()) {
            c.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
        } else {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).a(this, jSONObject);
            }
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List<d<a>> list = this.mHolders;
        if (list == null || list.isEmpty()) {
            c.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
        }
        JSONObject jSONObject = new JSONObject();
        beforeToJson(jSONObject);
        if (list == null) {
            return jSONObject;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            d<a> dVar = list.get(size);
            if (dVar != null) {
                dVar.b(this, jSONObject);
            }
        }
        afterToJson(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
