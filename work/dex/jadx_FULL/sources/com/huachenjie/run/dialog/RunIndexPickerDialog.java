package com.huachenjie.run.dialog;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.contrarywind.view.WheelView;
import com.huachenjie.common.reconfig.baseView.BaseBottomDialogFragment;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.RunIndexPickerDialog;
import com.zj.adlib.hb0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000e0\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010&R\u001d\u0010-\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018RF\u00103\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110#¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00040.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/huachenjie/run/dialog/RunIndexPickerDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "Lcom/contrarywind/view/WheelView;", "wheelView", "", "setupWheel", "Landroid/widget/CheckBox;", "cbRemember", "setupRemember", "bindWheelData", "", "resolveLineSpacingMultiplier", "applySelectedBold", "", "", "ellipsizeItems", "", "getWidth", "getHeight", "getLayoutResID", "initView", "titleText$delegate", "Lkotlin/Lazy;", "getTitleText", "()Ljava/lang/String;", "titleText", "kotlin.jvm.PlatformType", "items$delegate", "getItems", "()Ljava/util/List;", RunIndexPickerDialog.KEY_ITEMS, "selectedIndex$delegate", "getSelectedIndex", "()I", DressingTableActivity.x, "", "showRemember$delegate", "getShowRemember", "()Z", "showRemember", "rememberChecked$delegate", "getRememberChecked", "rememberChecked", "bottomActionText$delegate", "getBottomActionText", "bottomActionText", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "remember", "onSave", "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunIndexPickerDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunIndexPickerDialog.kt\ncom/huachenjie/run/dialog/RunIndexPickerDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,213:1\n1726#2,3:214\n1549#2:217\n1620#2,3:218\n*S KotlinDebug\n*F\n+ 1 RunIndexPickerDialog.kt\ncom/huachenjie/run/dialog/RunIndexPickerDialog\n*L\n206#1:214,3\n208#1:217\n208#1:218,3\n*E\n"})
public final class RunIndexPickerDialog extends BaseBottomDialogFragment {
    private static final float HIGHLIGHT_HEIGHT_DP = 52.0f;
    private static final float HIGHLIGHT_MARGIN_DP = 16.0f;

    @NotNull
    private static final String KEY_BOTTOM_ACTION_TEXT = "bottom_action_text";

    @NotNull
    private static final String KEY_ITEMS = "items";

    @NotNull
    private static final String KEY_REMEMBER_CHECKED = "remember_checked";

    @NotNull
    private static final String KEY_SELECTED_INDEX = "selected_index";

    @NotNull
    private static final String KEY_SHOW_REMEMBER = "show_remember";

    @NotNull
    private static final String KEY_TITLE = "title";
    private static final float OPTION_PADDING_DP = 16.0f;
    private static final float WHEEL_TEXT_SIZE_SP = 20.0f;
    private static volatile float cachedLineSpacing;
    private static volatile float cachedScaledDensity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int COLOR_TEXT_PRIMARY = Color.parseColor("#191F20");
    private static final int COLOR_TEXT_SECONDARY = Color.parseColor("#757979");

    @NotNull
    private static final Lazy<Field> paintCenterTextField$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Field>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$Companion$paintCenterTextField$2
        @Nullable
        public final Field invoke() {
            Object obj;
            RunIndexPickerDialog.Companion companion = RunIndexPickerDialog.INSTANCE;
            try {
                Result.Companion companion2 = Result.Companion;
                Field declaredField = WheelView.class.getDeclaredField("b");
                declaredField.setAccessible(true);
                obj = Result.constructor-impl(declaredField);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return (Field) obj;
        }
    });

    /* JADX INFO: renamed from: titleText$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleText = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$titleText$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("title") : null;
            return string == null ? "" : string;
        }
    });

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy items = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$items$2
        {
            super(0);
        }

        @NotNull
        public final List<String> invoke() {
            Bundle arguments = this.this$0.getArguments();
            ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList("items") : null;
            return stringArrayList == null ? CollectionsKt.emptyList() : stringArrayList;
        }
    });

    /* JADX INFO: renamed from: selectedIndex$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedIndex = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$selectedIndex$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m619invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("selected_index", 0) : 0);
        }
    });

    /* JADX INFO: renamed from: showRemember$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy showRemember = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$showRemember$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m620invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("show_remember", false) : false);
        }
    });

    /* JADX INFO: renamed from: rememberChecked$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rememberChecked = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$rememberChecked$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m618invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("remember_checked", false) : false);
        }
    });

    /* JADX INFO: renamed from: bottomActionText$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomActionText = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$bottomActionText$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("bottom_action_text");
            }
            return null;
        }
    });

    @NotNull
    private Function2<? super Integer, ? super Boolean, Unit> onSave = new Function2<Integer, Boolean, Unit>() { // from class: com.huachenjie.run.dialog.RunIndexPickerDialog$onSave$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i, boolean z) {
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.RunIndexPickerDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u0080\u0001\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000426\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010$R\u0014\u0010*\u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010!R\u0014\u0010+\u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010,\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010!R\u0016\u0010-\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010!¨\u00060"}, d2 = {"Lcom/huachenjie/run/dialog/RunIndexPickerDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "title", "", RunIndexPickerDialog.KEY_ITEMS, "", DressingTableActivity.x, "", "showRemember", "rememberChecked", "bottomActionText", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "remember", "", "onSave", "c", "Ljava/lang/reflect/Field;", "paintCenterTextField$delegate", "Lkotlin/Lazy;", "b", "()Ljava/lang/reflect/Field;", "paintCenterTextField", "COLOR_TEXT_PRIMARY", "I", "COLOR_TEXT_SECONDARY", "", "HIGHLIGHT_HEIGHT_DP", "F", "HIGHLIGHT_MARGIN_DP", "KEY_BOTTOM_ACTION_TEXT", "Ljava/lang/String;", "KEY_ITEMS", "KEY_REMEMBER_CHECKED", "KEY_SELECTED_INDEX", "KEY_SHOW_REMEMBER", "KEY_TITLE", "OPTION_PADDING_DP", "WHEEL_TEXT_SIZE_SP", "cachedLineSpacing", "cachedScaledDensity", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Field b() {
            return (Field) RunIndexPickerDialog.paintCenterTextField$delegate.getValue();
        }

        public final void c(@NotNull FragmentManager manager, @NotNull String title, @NotNull List<String> items, int selectedIndex, boolean showRemember, boolean rememberChecked, @Nullable String bottomActionText, @NotNull Function2<? super Integer, ? super Boolean, Unit> onSave) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(items, RunIndexPickerDialog.KEY_ITEMS);
            Intrinsics.checkNotNullParameter(onSave, "onSave");
            if (items.isEmpty()) {
                return;
            }
            RunIndexPickerDialog runIndexPickerDialog = new RunIndexPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putStringArrayList(RunIndexPickerDialog.KEY_ITEMS, new ArrayList<>(items));
            bundle.putInt(RunIndexPickerDialog.KEY_SELECTED_INDEX, RangesKt.coerceIn(selectedIndex, 0, CollectionsKt.getLastIndex(items)));
            bundle.putBoolean(RunIndexPickerDialog.KEY_SHOW_REMEMBER, showRemember);
            bundle.putBoolean(RunIndexPickerDialog.KEY_REMEMBER_CHECKED, rememberChecked);
            bundle.putString(RunIndexPickerDialog.KEY_BOTTOM_ACTION_TEXT, bottomActionText);
            runIndexPickerDialog.setArguments(bundle);
            runIndexPickerDialog.onSave = onSave;
            runIndexPickerDialog.show(manager, Reflection.getOrCreateKotlinClass(RunIndexPickerDialog.class).getSimpleName());
        }
    }

    private final void applySelectedBold(WheelView wheelView) {
        Field fieldB = INSTANCE.b();
        if (fieldB == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Object obj = fieldB.get(wheelView);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Paint");
            Paint paint = (Paint) obj;
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setTextScaleX(1.0f);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void bindWheelData(WheelView wheelView) {
        wheelView.setAdapter(new hb0(ellipsizeItems()));
        wheelView.setCurrentItem(RangesKt.coerceIn(getSelectedIndex(), 0, CollectionsKt.getLastIndex(getItems())));
    }

    private final List<String> ellipsizeItems() {
        float f = getResources().getDisplayMetrics().widthPixels - ((int) ((getResources().getDisplayMetrics().density * 32.0f) * 2));
        if (f <= 0.0f) {
            return getItems();
        }
        boolean z = true;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        List<String> items = getItems();
        if (!(items instanceof Collection) || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (!(textPaint.measureText((String) it.next()) <= f)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return getItems();
        }
        List<String> items2 = getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
        Iterator<T> it2 = items2.iterator();
        while (it2.hasNext()) {
            arrayList.add(TextUtils.ellipsize((String) it2.next(), textPaint, f, TextUtils.TruncateAt.END).toString());
        }
        return arrayList;
    }

    private final String getBottomActionText() {
        return (String) this.bottomActionText.getValue();
    }

    private final List<String> getItems() {
        return (List) this.items.getValue();
    }

    private final boolean getRememberChecked() {
        return ((Boolean) this.rememberChecked.getValue()).booleanValue();
    }

    private final int getSelectedIndex() {
        return ((Number) this.selectedIndex.getValue()).intValue();
    }

    private final boolean getShowRemember() {
        return ((Boolean) this.showRemember.getValue()).booleanValue();
    }

    private final String getTitleText() {
        return (String) this.titleText.getValue();
    }

    private static final void initView$confirm(RunIndexPickerDialog runIndexPickerDialog, WheelView wheelView, CheckBox checkBox) {
        runIndexPickerDialog.onSave.invoke(Integer.valueOf(wheelView.getCurrentItem()), Boolean.valueOf(runIndexPickerDialog.getShowRemember() && checkBox.isChecked()));
        runIndexPickerDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(RunIndexPickerDialog runIndexPickerDialog, View view) {
        Intrinsics.checkNotNullParameter(runIndexPickerDialog, "this$0");
        runIndexPickerDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(RunIndexPickerDialog runIndexPickerDialog, WheelView wheelView, CheckBox checkBox, View view) {
        Intrinsics.checkNotNullParameter(runIndexPickerDialog, "this$0");
        Intrinsics.checkNotNullParameter(wheelView, "$wheelView");
        Intrinsics.checkNotNullParameter(checkBox, "$cbRemember");
        initView$confirm(runIndexPickerDialog, wheelView, checkBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(RunIndexPickerDialog runIndexPickerDialog, WheelView wheelView, CheckBox checkBox, View view) {
        Intrinsics.checkNotNullParameter(runIndexPickerDialog, "this$0");
        Intrinsics.checkNotNullParameter(wheelView, "$wheelView");
        Intrinsics.checkNotNullParameter(checkBox, "$cbRemember");
        initView$confirm(runIndexPickerDialog, wheelView, checkBox);
    }

    private final float resolveLineSpacingMultiplier() {
        float f = getResources().getDisplayMetrics().scaledDensity;
        if (cachedLineSpacing > 0.0f) {
            if (cachedScaledDensity == f) {
                return cachedLineSpacing;
            }
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(20.0f * f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        Rect rect = new Rect();
        textPaint.getTextBounds("星期", 0, 2, rect);
        float fCoerceIn = RangesKt.coerceIn((getResources().getDisplayMetrics().density * 52.0f) / RangesKt.coerceAtLeast(rect.height() + 2, 1), 1.0f, 4.0f);
        cachedLineSpacing = fCoerceIn;
        cachedScaledDensity = f;
        return fCoerceIn;
    }

    private final void setupRemember(final CheckBox cbRemember) {
        cbRemember.setVisibility(getShowRemember() ? 0 : 8);
        cbRemember.setChecked(getRememberChecked());
        setupRemember$updateRememberTextColor(cbRemember, cbRemember.isChecked());
        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.fm7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RunIndexPickerDialog.setupRemember$lambda$6(cbRemember, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRemember$lambda$6(CheckBox checkBox, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(checkBox, "$cbRemember");
        setupRemember$updateRememberTextColor(checkBox, z);
    }

    private static final void setupRemember$updateRememberTextColor(CheckBox checkBox, boolean z) {
        checkBox.setTextColor(z ? COLOR_TEXT_PRIMARY : COLOR_TEXT_SECONDARY);
    }

    private final void setupWheel(WheelView wheelView) {
        wheelView.setCyclic(false);
        wheelView.setItemsVisibleCount(5);
        wheelView.setAlphaGradient(true);
        applySelectedBold(wheelView);
        wheelView.setLineSpacingMultiplier(resolveLineSpacingMultiplier());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_index_picker;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        TextView textView;
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        super.initView();
        if (getItems().isEmpty()) {
            dismiss();
            return;
        }
        String bottomActionText = getBottomActionText();
        boolean z = !(bottomActionText == null || bottomActionText.length() == 0);
        View view = getView();
        TextView textView2 = view != null ? (TextView) view.findViewById(R.id.tv_title) : null;
        if (textView2 != null) {
            textView2.setText(getTitleText());
        }
        View view2 = getView();
        if (view2 != null && (viewFindViewById3 = view2.findViewById(R.id.tv_cancel)) != null) {
            viewFindViewById3.setVisibility(z ? 4 : 0);
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gm7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    RunIndexPickerDialog.initView$lambda$1$lambda$0(this.f41938a, view3);
                }
            });
        }
        View view3 = getView();
        if (view3 != null && (viewFindViewById2 = view3.findViewById(R.id.tv_save)) != null) {
            viewFindViewById2.setVisibility(z ? 4 : 0);
        }
        View view4 = getView();
        final WheelView wheelView = view4 != null ? (WheelView) view4.findViewById(R.id.wheel_view) : null;
        if (wheelView == null) {
            return;
        }
        setupWheel(wheelView);
        bindWheelData(wheelView);
        View view5 = getView();
        final CheckBox checkBox = view5 != null ? (CheckBox) view5.findViewById(R.id.cb_remember) : null;
        if (checkBox == null) {
            return;
        }
        setupRemember(checkBox);
        View view6 = getView();
        if (view6 != null && (viewFindViewById = view6.findViewById(R.id.tv_save)) != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.hm7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    RunIndexPickerDialog.initView$lambda$3(this.f17026a, wheelView, checkBox, view7);
                }
            });
        }
        View view7 = getView();
        if (view7 == null || (textView = (TextView) view7.findViewById(R.id.tv_start_run)) == null) {
            return;
        }
        if (!z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(getBottomActionText());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.im7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                RunIndexPickerDialog.initView$lambda$5$lambda$4(this.f17243a, wheelView, checkBox, view8);
            }
        });
    }
}
