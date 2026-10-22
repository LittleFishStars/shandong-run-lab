package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SplitPairFilter {

    @NotNull
    private final ComponentName primaryActivityName;

    /* JADX INFO: renamed from: secondaryActivityIntentAction, reason: from kotlin metadata and from toString */
    @Nullable
    private final String secondaryActivityAction;

    @NotNull
    private final ComponentName secondaryActivityName;

    /* JADX WARN: Code duplicated, block: B:13:0x005d  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0114  */
    /* JADX WARN: Code duplicated, block: B:65:0x011e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0128  */
    public SplitPairFilter(@NotNull ComponentName componentName, @NotNull ComponentName componentName2, @Nullable String str) {
        boolean z;
        boolean z2;
        Object obj;
        int i;
        CharSequence charSequence;
        boolean z3;
        String str2;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(componentName, "primaryActivityName");
        Intrinsics.checkNotNullParameter(componentName2, "secondaryActivityName");
        this.primaryActivityName = componentName;
        this.secondaryActivityName = componentName2;
        this.secondaryActivityAction = str;
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "primaryActivityName.packageName");
        String className = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "primaryActivityName.className");
        String packageName2 = componentName2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName2.getClassName();
        Intrinsics.checkNotNullExpressionValue(className2, "secondaryActivityName.className");
        boolean z6 = true;
        if (packageName.length() == 0) {
            z = false;
        } else {
            if (packageName2.length() == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            throw new IllegalArgumentException("Package name must not be empty".toString());
        }
        if (className.length() == 0) {
            z2 = false;
        } else {
            if (className2.length() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        if (!(!StringsKt.contains$default(packageName, "*", false, 2, (Object) null) || StringsKt.indexOf$default(packageName, "*", 0, false, 6, (Object) null) == packageName.length() + (-1))) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (StringsKt.contains$default(className, "*", false, 2, (Object) null)) {
            obj = null;
            i = 2;
            charSequence = "*";
            z3 = false;
            str2 = className2;
            if (StringsKt.indexOf$default(className, "*", 0, false, 6, (Object) null) != className.length() - 1) {
                z4 = false;
            }
            if (z4) {
                throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
            }
            if (StringsKt.contains$default(packageName2, charSequence, z3, i, obj) || StringsKt.indexOf$default(packageName2, "*", 0, false, 6, (Object) null) == packageName2.length() - 1) {
                z5 = true;
            } else {
                z5 = z3;
            }
            if (z5) {
                throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
            }
            if (StringsKt.contains$default(str2, charSequence, z3, i, obj) && StringsKt.indexOf$default(str2, "*", 0, false, 6, (Object) null) != str2.length() - 1) {
                z6 = z3;
            }
            if (z6) {
                throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
            }
        }
        obj = null;
        i = 2;
        charSequence = "*";
        z3 = false;
        str2 = className2;
        z4 = true;
        if (z4) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
        if (StringsKt.contains$default(packageName2, charSequence, z3, i, obj)) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (z5) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (StringsKt.contains$default(str2, charSequence, z3, i, obj)) {
            z6 = z3;
        }
        if (z6) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) other;
        return Intrinsics.areEqual(this.primaryActivityName, splitPairFilter.primaryActivityName) && Intrinsics.areEqual(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && Intrinsics.areEqual(this.secondaryActivityAction, splitPairFilter.secondaryActivityAction);
    }

    @NotNull
    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    @Nullable
    /* JADX INFO: renamed from: getSecondaryActivityIntentAction, reason: from getter */
    public final String getSecondaryActivityAction() {
        return this.secondaryActivityAction;
    }

    @NotNull
    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int iHashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityAction;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivityIntentPair(@NotNull Activity primaryActivity, @NotNull Intent secondaryActivityIntent) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivityIntent, "secondaryActivityIntent");
        ComponentName componentName = primaryActivity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(secondaryActivityIntent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityAction;
        return str == null || Intrinsics.areEqual(str, secondaryActivityIntent.getAction());
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    public final boolean matchesActivityPair(@NotNull Activity primaryActivity, @NotNull Activity secondaryActivity) {
        boolean z;
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivity, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        boolean z2 = matcherUtils.areComponentsMatching$window_release(primaryActivity.getComponentName(), this.primaryActivityName) && matcherUtils.areComponentsMatching$window_release(secondaryActivity.getComponentName(), this.secondaryActivityName);
        if (secondaryActivity.getIntent() == null) {
            return z2;
        }
        if (z2) {
            Intent intent = secondaryActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "secondaryActivity.intent");
            z = matchesActivityIntentPair(primaryActivity, intent);
        }
        return z;
    }

    @NotNull
    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + ((Object) this.secondaryActivityAction) + '}';
    }
}
