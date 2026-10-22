package com.easyjson.parser;

import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ParseContext {
    public final Object fieldName;
    public Object object;
    public final ParseContext parent;
    public Type type;

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
    }

    public String toString() {
        StringBuilder sb;
        if (this.parent == null) {
            return "$";
        }
        if (this.fieldName instanceof Integer) {
            sb = new StringBuilder();
            sb.append(this.parent.toString());
            sb.append("[");
            sb.append(this.fieldName);
            sb.append("]");
        } else {
            sb = new StringBuilder();
            sb.append(this.parent.toString());
            sb.append(Consts.DOT);
            sb.append(this.fieldName);
        }
        return sb.toString();
    }
}
