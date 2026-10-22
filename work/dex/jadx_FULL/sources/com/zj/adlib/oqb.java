package com.zj.adlib;

import com.easyjson.JSONArray;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.deserializer.FieldDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class oqb extends FieldDeserializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DefaultJSONParser f18709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f18710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Collection f18711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f18712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f18713a;

    public oqb(DefaultJSONParser defaultJSONParser, List list, int i) {
        super(null, null, 0);
        this.f18709a = defaultJSONParser;
        this.f43817a = i;
        this.f18712a = list;
        this.f18710a = null;
        this.f18713a = null;
        this.f18711a = null;
    }

    public oqb(Collection collection) {
        super(null, null, 0);
        this.f18709a = null;
        this.f43817a = -1;
        this.f18712a = null;
        this.f18710a = null;
        this.f18713a = null;
        this.f18711a = collection;
    }

    public oqb(Map map, Object obj) {
        super(null, null, 0);
        this.f18709a = null;
        this.f43817a = -1;
        this.f18712a = null;
        this.f18710a = obj;
        this.f18713a = map;
        this.f18711a = null;
    }

    @Override // com.easyjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // com.easyjson.parser.deserializer.FieldDeserializer
    public void setValue(Object obj, Object obj2) {
        JSONArray jSONArray;
        Object relatedArray;
        Map map = this.f18713a;
        if (map != null) {
            map.put(this.f18710a, obj2);
            return;
        }
        Collection collection = this.f18711a;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f18712a.set(this.f43817a, obj2);
        List list = this.f18712a;
        if (!(list instanceof JSONArray) || (relatedArray = (jSONArray = (JSONArray) list).getRelatedArray()) == null || Array.getLength(relatedArray) <= this.f43817a) {
            return;
        }
        if (jSONArray.getComponentType() != null) {
            obj2 = TypeUtils.cast(obj2, jSONArray.getComponentType(), this.f18709a.config);
        }
        Array.set(relatedArray, this.f43817a, obj2);
    }
}
