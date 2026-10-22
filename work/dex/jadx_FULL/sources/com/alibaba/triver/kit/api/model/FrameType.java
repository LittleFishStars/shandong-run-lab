package com.alibaba.triver.kit.api.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FrameType {
    public static final String PRIAREA = "priArea";
    public static final String PUBAREA = "pubArea";

    public enum Type {
        PriArea,
        PriArea2,
        PubArea,
        PubArea2,
        Default,
        Default2,
        PriTool,
        PriTool2
    }

    public static boolean isPri(Type type) {
        return type == Type.PriArea || type == Type.PriTool || type == Type.PriArea2 || type == Type.PriTool2;
    }

    public static boolean isPub(String str) {
        return PUBAREA.equals(str);
    }

    public static boolean isTool(String str) {
        return "priTool".equals(str);
    }

    public static Type str2Type(String str, boolean z) {
        if (PRIAREA.equals(str)) {
            return z ? Type.PriArea : Type.PriArea2;
        }
        if (PUBAREA.equals(str)) {
            return z ? Type.PubArea : Type.PubArea2;
        }
        if ("priTool".equals(str)) {
            return z ? Type.PriTool : Type.PriTool2;
        }
        return z ? Type.Default : Type.Default2;
    }

    public static String type2Str(Type type) {
        if (Type.PriArea == type || Type.PriArea2 == type) {
            return PRIAREA;
        }
        if (Type.PubArea == type || Type.PubArea2 == type) {
            return PUBAREA;
        }
        return (Type.PriTool == type || Type.PriTool2 == type) ? "priTool" : "default";
    }

    public static boolean isPri(String str) {
        return PRIAREA.equals(str);
    }
}
