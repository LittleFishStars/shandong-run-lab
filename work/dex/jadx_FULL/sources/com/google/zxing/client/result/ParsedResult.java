package com.google.zxing.client.result;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParsedResultType f32502a;

    public ParsedResult(ParsedResultType parsedResultType) {
        this.f32502a = parsedResultType;
    }

    public static void b(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void c(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                b(str, sb);
            }
        }
    }

    public abstract String a();

    public final ParsedResultType getType() {
        return this.f32502a;
    }

    public final String toString() {
        return a();
    }
}
