package androidx.window.flow;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002#$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/FoldingFeature;", "featureBounds", "Landroidx/window/core/Bounds;", "type", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "state", "Landroidx/window/layout/FoldingFeature$State;", "(Landroidx/window/core/Bounds;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/FoldingFeature$State;)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "isSeparating", "", "()Z", "occlusionType", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$OcclusionType;", "orientation", "Landroidx/window/layout/FoldingFeature$Orientation;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$Orientation;", "getState", "()Landroidx/window/layout/FoldingFeature$State;", "getType$window_release", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "Type", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HardwareFoldingFeature implements FoldingFeature {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Bounds featureBounds;

    @NotNull
    private final FoldingFeature.State state;

    @NotNull
    private final Type type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Companion;", "", "()V", "validateFeatureBounds", "", "bounds", "Landroidx/window/core/Bounds;", "validateFeatureBounds$window_release", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void validateFeatureBounds$window_release(@NotNull Bounds bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (!((bounds.getWidth() == 0 && bounds.getHeight() == 0) ? false : true)) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (!(bounds.getLeft() == 0 || bounds.getTop() == 0)) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Type {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final Type FOLD = new Type("FOLD");

        @NotNull
        private static final Type HINGE = new Type("HINGE");

        @NotNull
        private final String description;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type$Companion;", "", "()V", "FOLD", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "getFOLD", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "HINGE", "getHINGE", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Type getFOLD() {
                return Type.FOLD;
            }

            @NotNull
            public final Type getHINGE() {
                return Type.HINGE;
            }
        }

        private Type(String str) {
            this.description = str;
        }

        @NotNull
        /* JADX INFO: renamed from: toString, reason: from getter */
        public String getDescription() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(@NotNull Bounds bounds, @NotNull Type type, @NotNull FoldingFeature.State state) {
        Intrinsics.checkNotNullParameter(bounds, "featureBounds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        this.featureBounds = bounds;
        this.type = type;
        this.state = state;
        INSTANCE.validateFeatureBounds$window_release(bounds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(HardwareFoldingFeature.class, other == null ? null : other.getClass())) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) other;
        return Intrinsics.areEqual(this.featureBounds, hardwareFoldingFeature.featureBounds) && Intrinsics.areEqual(this.type, hardwareFoldingFeature.type) && Intrinsics.areEqual(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.flow.DisplayFeature
    @NotNull
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override // androidx.window.flow.FoldingFeature
    @NotNull
    public FoldingFeature.OcclusionType getOcclusionType() {
        return (this.featureBounds.getWidth() == 0 || this.featureBounds.getHeight() == 0) ? FoldingFeature.OcclusionType.NONE : FoldingFeature.OcclusionType.FULL;
    }

    @Override // androidx.window.flow.FoldingFeature
    @NotNull
    public FoldingFeature.Orientation getOrientation() {
        return this.featureBounds.getWidth() > this.featureBounds.getHeight() ? FoldingFeature.Orientation.HORIZONTAL : FoldingFeature.Orientation.VERTICAL;
    }

    @Override // androidx.window.flow.FoldingFeature
    @NotNull
    public FoldingFeature.State getState() {
        return this.state;
    }

    @NotNull
    /* JADX INFO: renamed from: getType$window_release, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.flow.FoldingFeature
    public boolean isSeparating() {
        Type type = this.type;
        Type.Companion companion = Type.INSTANCE;
        if (Intrinsics.areEqual(type, companion.getHINGE())) {
            return true;
        }
        return Intrinsics.areEqual(this.type, companion.getFOLD()) && Intrinsics.areEqual(getState(), FoldingFeature.State.HALF_OPENED);
    }

    @NotNull
    public String toString() {
        return ((Object) HardwareFoldingFeature.class.getSimpleName()) + " { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
