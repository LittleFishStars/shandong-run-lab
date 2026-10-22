package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class RefreshHeader extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected TriverSwipeRefreshLayout.a f25245a;
    protected RefreshState b;

    /* JADX INFO: renamed from: com.alibaba.triver.triver_render.view.refresh.RefreshHeader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25246a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f25246a = iArr;
            try {
                iArr[RefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25246a[RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25246a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25246a[RefreshState.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25246a[RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25246a[RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25246a[RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum RefreshHeaderStyle {
        NORMAL,
        DARK
    }

    public enum RefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        PREPARE_TO_SECOND_FLOOR,
        SECOND_FLOOR_START,
        SECOND_FLOOR_END;

        @Override // java.lang.Enum
        public String toString() {
            switch (AnonymousClass1.f25246a[ordinal()]) {
                case 1:
                    return "NONE";
                case 2:
                    return "PULL_TO_REFRESH";
                case 3:
                    return "RELEASE_TO_REFRESH";
                case 4:
                    return "REFRESHING";
                case 5:
                    return "PREPARE_TO_SECOND_FLOOR";
                case 6:
                    return "SECOND_FLOOR_START";
                case 7:
                    return "SECOND_FLOOR_END";
                default:
                    return "";
            }
        }
    }

    public RefreshHeader(Context context) {
        super(context);
        this.b = RefreshState.NONE;
    }

    public void a(RefreshHeaderStyle refreshHeaderStyle) {
    }

    public abstract void a(RefreshState refreshState);

    public abstract void a(String[] strArr, @Nullable String str);

    public RefreshState getCurrentState() {
        return this.b;
    }

    public abstract View getRefreshView();

    public abstract View getSecondFloorView();

    public abstract void setProgress(float f);

    public void setPullRefreshListener(TriverSwipeRefreshLayout.a aVar) {
        this.f25245a = aVar;
    }

    public abstract void setRefreshTipColor(@ColorInt int i);

    public abstract void setRefreshTips(String[] strArr);

    public abstract void setSecondFloorView(View view);
}
