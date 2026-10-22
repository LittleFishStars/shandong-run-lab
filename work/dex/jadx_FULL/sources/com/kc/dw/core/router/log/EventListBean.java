package com.kc.dw.core.router.log;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class EventListBean implements Serializable {
    private static final long serialVersionUID = 1;
    public EventBean[] list;
    public Map<String, Object> params;

    public EventListBean() {
    }

    public EventListBean(Map<String, Object> map, EventBean[] eventBeanArr) {
        this.params = map;
        this.list = eventBeanArr;
    }
}
