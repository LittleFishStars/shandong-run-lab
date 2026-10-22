package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\f¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/common/widget/SelectBoldTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attachViewPager", "", "vp2", "Landroidx/viewpager2/widget/ViewPager2;", "tabNameList", "", "", "(Landroidx/viewpager2/widget/ViewPager2;[Ljava/lang/String;)V", "", "handlerTabLayoutBold", "tabView", "Landroid/view/View;", "isBold", "", "setTabNormalStyle", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSelectBoldTabLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectBoldTabLayout.kt\ncom/huachenjie/common/widget/SelectBoldTabLayout\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,110:1\n1295#2,2:111\n*S KotlinDebug\n*F\n+ 1 SelectBoldTabLayout.kt\ncom/huachenjie/common/widget/SelectBoldTabLayout\n*L\n86#1:111,2\n*E\n"})
public final class SelectBoldTabLayout extends TabLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/common/widget/SelectBoldTabLayout$Companion;", "", "()V", "desensitization", "", "vp2", "Landroidx/viewpager2/widget/ViewPager2;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void desensitization(@NotNull ViewPager2 vp2) {
            Intrinsics.checkNotNullParameter(vp2, "vp2");
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(vp2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 6));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBoldTabLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.huachenjie.common.widget.SelectBoldTabLayout.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(@Nullable TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachViewPager$lambda$0(String[] strArr, SelectBoldTabLayout selectBoldTabLayout, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(strArr, "$tabNameList");
        Intrinsics.checkNotNullParameter(selectBoldTabLayout, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(strArr[i]);
        selectBoldTabLayout.handlerTabLayoutBold(tab.view, i == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachViewPager$lambda$1(List list, SelectBoldTabLayout selectBoldTabLayout, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(list, "$tabNameList");
        Intrinsics.checkNotNullParameter(selectBoldTabLayout, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText((CharSequence) list.get(i));
        selectBoldTabLayout.handlerTabLayoutBold(tab.view, i == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlerTabLayoutBold(View tabView, boolean isBold) {
        if (tabView instanceof ViewGroup) {
            for (View view : ViewGroupKt.getChildren((ViewGroup) tabView)) {
                if (view instanceof TextView) {
                    if (isBold) {
                        ((TextView) view).setTypeface(Typeface.DEFAULT_BOLD);
                    } else {
                        ((TextView) view).setTypeface(Typeface.DEFAULT);
                    }
                }
            }
        }
    }

    public final void attachViewPager(@NotNull ViewPager2 vp2, @NotNull final String[] tabNameList) {
        Intrinsics.checkNotNullParameter(vp2, "vp2");
        Intrinsics.checkNotNullParameter(tabNameList, "tabNameList");
        new TabLayoutMediator(this, vp2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.zj.adlib.c48
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                SelectBoldTabLayout.attachViewPager$lambda$0(tabNameList, this, tab, i);
            }
        }).attach();
        try {
            INSTANCE.desensitization(vp2);
        } catch (Exception unused) {
        }
    }

    public final void setTabNormalStyle() {
        int tabCount = getTabCount();
        int i = 0;
        while (i < tabCount) {
            TabLayout.Tab tabAt = getTabAt(i);
            handlerTabLayoutBold(tabAt != null ? tabAt.view : null, i == 0);
            i++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBoldTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.huachenjie.common.widget.SelectBoldTabLayout.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(@Nullable TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, false);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBoldTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.huachenjie.common.widget.SelectBoldTabLayout.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(@Nullable TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(@Nullable TabLayout.Tab tab) {
                SelectBoldTabLayout.this.handlerTabLayoutBold(tab != null ? tab.view : null, false);
            }
        });
    }

    public final void attachViewPager(@NotNull ViewPager2 vp2, @NotNull final List<String> tabNameList) {
        Intrinsics.checkNotNullParameter(vp2, "vp2");
        Intrinsics.checkNotNullParameter(tabNameList, "tabNameList");
        new TabLayoutMediator(this, vp2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.zj.adlib.d48
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                SelectBoldTabLayout.attachViewPager$lambda$1(tabNameList, this, tab, i);
            }
        }).attach();
        try {
            INSTANCE.desensitization(vp2);
        } catch (Exception unused) {
        }
    }
}
