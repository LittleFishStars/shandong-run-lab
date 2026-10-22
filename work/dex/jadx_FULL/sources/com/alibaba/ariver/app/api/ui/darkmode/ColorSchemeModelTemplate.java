package com.alibaba.ariver.app.api.ui.darkmode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ColorSchemeModelTemplate<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f23826a;
    private T b;
    private T c;
    private ColorSchemeDecider d;

    /* JADX INFO: renamed from: com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType;

        static {
            int[] iArr = new int[ColorSchemeType.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType = iArr;
            try {
                iArr[ColorSchemeType.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType[ColorSchemeType.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public T getTarget() {
        T t;
        ColorSchemeDecider colorSchemeDecider = this.d;
        if (colorSchemeDecider != null) {
            int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType[colorSchemeDecider.getCurrentColorScheme().ordinal()];
            if (i == 1) {
                T t2 = this.b;
                if (t2 != null) {
                    return t2;
                }
            } else if (i == 2 && (t = this.c) != null) {
                return t;
            }
        }
        return this.f23826a;
    }

    public void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.d = colorSchemeDecider;
    }

    public void setDark(T t) {
        this.c = t;
    }

    public void setDefault(T t) {
        this.f23826a = t;
    }

    public void setLight(T t) {
        this.b = t;
    }

    public String toString() {
        return "ColorSchemeModelTemplate{def=" + this.f23826a + ", light=" + this.b + ", dark=" + this.c + '}';
    }
}
