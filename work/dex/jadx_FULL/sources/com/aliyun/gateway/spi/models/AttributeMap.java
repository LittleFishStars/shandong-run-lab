package com.aliyun.gateway.spi.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AttributeMap extends TeaModel {

    @NameInMap("attributes")
    @Validation(required = true)
    public Map<String, ?> attributes;

    @NameInMap(CachedContentIndex.a.e)
    @Validation(required = true)
    public Map<String, String> key;

    public static AttributeMap build(Map<String, ?> map) {
        return (AttributeMap) TeaModel.build(map, new AttributeMap());
    }

    public Map<String, ?> getAttributes() {
        return this.attributes;
    }

    public Map<String, String> getKey() {
        return this.key;
    }

    public AttributeMap setAttributes(Map<String, ?> map) {
        this.attributes = map;
        return this;
    }

    public AttributeMap setKey(Map<String, String> map) {
        this.key = map;
        return this;
    }
}
