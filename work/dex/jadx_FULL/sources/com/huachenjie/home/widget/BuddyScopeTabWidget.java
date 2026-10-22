package com.huachenjie.home.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.home.widget.BuddyScopeTabWidget;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.fe9;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0002J\u0018\u0010\u0014\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/huachenjie/home/widget/BuddyScopeTabWidget;", "Lcom/noober/background/view/BLLinearLayout;", "", "scopeType", "", "setScopeType", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setOnScopeChangeListener", "", "text", "Landroidx/appcompat/widget/AppCompatTextView;", y6b.f, "view", "", "isSelected", y6b.g, "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "e", "f", "a", "Landroidx/appcompat/widget/AppCompatTextView;", "schoolTabView", "b", "cityTabView", "Lkotlin/jvm/functions/Function1;", "onScopeChangeListener", "K", "I", "currentScopeType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "home_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyScopeTabWidget extends BLLinearLayout {
    public static final int SCOPE_CITY = 2;
    public static final int SCOPE_SCHOOL = 1;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int currentScopeType;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final AppCompatTextView schoolTabView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> onScopeChangeListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final AppCompatTextView cityTabView;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public BuddyScopeTabWidget(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AttributeSet attributeSet = null;
        this(context, attributeSet, 2, attributeSet);
    }

    public /* synthetic */ BuddyScopeTabWidget(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void c(BuddyScopeTabWidget buddyScopeTabWidget, View view) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(buddyScopeTabWidget, "this$0");
        if (buddyScopeTabWidget.currentScopeType == 1 || (function1 = buddyScopeTabWidget.onScopeChangeListener) == null) {
            return;
        }
        function1.invoke(1);
    }

    public static final void d(BuddyScopeTabWidget buddyScopeTabWidget, View view) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(buddyScopeTabWidget, "this$0");
        if (buddyScopeTabWidget.currentScopeType == 2 || (function1 = buddyScopeTabWidget.onScopeChangeListener) == null) {
            return;
        }
        function1.invoke(2);
    }

    public final Drawable e() {
        return new DrawableCreator.Builder().setSolidColor(-1513240).setCornersRadius(jj8.a(10.0f)).build();
    }

    public final Drawable f(boolean isSelected) {
        return new DrawableCreator.Builder().setSolidColor(isSelected ? -16002049 : 0).setCornersRadius(jj8.a(14.0f)).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AppCompatTextView g(String text) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        appCompatTextView.setGravity(17);
        appCompatTextView.setPadding(jj8.a(12.0f), 0, jj8.a(12.0f), 0);
        appCompatTextView.setTextSize(12.0f);
        appCompatTextView.setTextColor(RunIndexRecordAdapter.K);
        appCompatTextView.setText(text);
        return appCompatTextView;
    }

    public final void h(AppCompatTextView view, boolean isSelected) {
        view.setBackground(f(isSelected));
        view.setTypeface(isSelected ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    public final void setOnScopeChangeListener(@Nullable Function1<? super Integer, Unit> listener) {
        this.onScopeChangeListener = listener;
    }

    public final void setScopeType(int scopeType) {
        int i = scopeType == 2 ? 2 : 1;
        this.currentScopeType = i;
        h(this.schoolTabView, i == 1);
        h(this.cityTabView, this.currentScopeType == 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BuddyScopeTabWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatTextView appCompatTextViewG = g(fe9.b.ALUMNI);
        this.schoolTabView = appCompatTextViewG;
        AppCompatTextView appCompatTextViewG2 = g("同城");
        this.cityTabView = appCompatTextViewG2;
        this.currentScopeType = 1;
        setOrientation(0);
        setGravity(16);
        setBackground(e());
        addView(appCompatTextViewG);
        addView(appCompatTextViewG2);
        appCompatTextViewG.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.z01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyScopeTabWidget.c(this.f46152a, view);
            }
        });
        appCompatTextViewG2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyScopeTabWidget.d(this.f40430a, view);
            }
        });
        setScopeType(1);
    }
}
