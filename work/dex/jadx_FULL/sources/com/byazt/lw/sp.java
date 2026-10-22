package com.byazt.lw;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 91})
public class sp implements com.byazt.dr.c {
    public final Object c;

    public sp(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.c = Boolean.TRUE;
        } else if (str.equalsIgnoreCase(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            this.c = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException();
            }
            this.c = null;
        }
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.c + "]";
    }

    @Override // com.byazt.dr.c
    public String tt() {
        Object obj = this.c;
        return obj != null ? obj.toString() : "NULL";
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.CONSTANT;
    }
}
