package com.zj.adlib;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¨\u0006\u001a"}, d2 = {"Lcom/zj/adlib/bw9;", "", "Landroid/view/View;", "view", "", "b", "Landroid/graphics/Rect;", "a", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "", "e", "f", y6b.f, "Landroidx/recyclerview/widget/RecyclerView;", "d", "", "softInputMode", "", "i", "c", "hideAnimation", "overScrollNever", y6b.g, "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class bw9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bw9 f40853a = new bw9();

    @JvmStatic
    @Nullable
    public static final Rect a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.isEmpty()) {
            return null;
        }
        return rect;
    }

    @JvmStatic
    public static final boolean b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        return view.getGlobalVisibleRect(rect) && rect.width() == view.getWidth() && rect.height() == view.getHeight();
    }

    public final void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ViewGroup) {
            i4a.a("view type is ViewGroup");
        } else {
            i4a.a("view type is View");
        }
        i4a.a("view class is " + view.getClass().getSimpleName());
    }

    public final void d(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getItemAnimator() != null) {
            view.setItemAnimator(null);
        }
        view.setOverScrollMode(2);
    }

    public final void e(@NotNull ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        h(viewPager, true, false);
    }

    public final void f(@NotNull ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        h(viewPager, false, true);
    }

    public final void g(@NotNull ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        h(viewPager, true, true);
    }

    public final void h(ViewPager2 viewPager, boolean hideAnimation, boolean overScrollNever) {
        int childCount = viewPager.getChildCount();
        if (childCount < 0) {
            return;
        }
        int i = 0;
        while (true) {
            View childAt = viewPager.getChildAt(i);
            if (childAt instanceof RecyclerView) {
                if (hideAnimation) {
                    RecyclerView recyclerView = (RecyclerView) childAt;
                    if (recyclerView.getItemAnimator() != null) {
                        recyclerView.setItemAnimator(null);
                    }
                }
                if (overScrollNever) {
                    ((RecyclerView) childAt).setOverScrollMode(2);
                    return;
                }
                return;
            }
            if (i == childCount) {
                return;
            } else {
                i++;
            }
        }
    }

    @Nullable
    public final String i(int softInputMode) {
        StringBuilder sb = new StringBuilder();
        sb.append("softInputMode=" + softInputMode + ' ');
        int i = softInputMode & 15;
        if (i != 0) {
            sb.append("state=");
            if (i == 1) {
                sb.append("unchanged");
            } else if (i == 2) {
                sb.append("hidden");
            } else if (i == 3) {
                sb.append("always_hidden");
            } else if (i == 4) {
                sb.append("visible");
            } else if (i != 5) {
                sb.append(i);
            } else {
                sb.append("always_visible");
            }
            sb.append(' ');
        }
        int i2 = softInputMode & 240;
        if (i2 != 0) {
            sb.append("adjust=");
            if (i2 == 16) {
                sb.append("resize");
            } else if (i2 == 32) {
                sb.append("pan");
            } else if (i2 != 48) {
                sb.append(i2);
            } else {
                sb.append("nothing");
            }
            sb.append(' ');
        }
        if ((softInputMode & 256) != 0) {
            sb.append("forwardNavigation");
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
