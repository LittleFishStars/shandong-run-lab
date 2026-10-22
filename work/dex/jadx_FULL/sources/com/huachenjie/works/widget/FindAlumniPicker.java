package com.huachenjie.works.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.widget.PopupWindowCompat;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import com.huachenjie.works.widget.FindAlumniPicker;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ar6;
import com.zj.adlib.fv5;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010L\u001a\u00020\u000b¢\u0006\u0004\bM\u0010NJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\"\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0014\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018J/\u0010#\u001a\u00020\u00052'\u0010\"\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\u001eJ\b\u0010$\u001a\u00020\u0005H\u0016R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010%R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010%R*\u0010\"\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010.R#\u00106\u001a\n 2*\u0004\u0018\u000101018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u00103\u001a\u0004\b4\u00105R#\u00109\u001a\n 2*\u0004\u0018\u000101018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\u001b\u0010=\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b?\u0010@R\u001b\u0010E\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\bC\u0010DR\u001b\u0010I\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\bG\u0010H¨\u0006O"}, d2 = {"Lcom/huachenjie/works/widget/FindAlumniPicker;", "Lcom/noober/background/view/BLLinearLayout;", "Landroid/widget/PopupWindow$OnDismissListener;", "Landroid/util/AttributeSet;", "attrs", "", "f", t.d, "i", "", y6b.f, "", y6b.g, "expanded", "m", j.b, "position", "e", "d", "selected", "notifyItemChanged", "n", "j", "k", "", "", "c", "Lcom/huachenjie/works/bean/InterestTag;", "data", "setPickerData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", PageLog.PAGE_LOG_TAGS, ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setOnConfirmListener", "onDismiss", "Ljava/lang/String;", RVParams.LONG_DEFAULT_TITLE, "K", "I", "maxCount", "countLimitInfo", "a", "Lkotlin/jvm/functions/Function1;", "", "Ljava/util/List;", "confirmSelectIndex", "draftSelectIndex", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getNormalBg", "()Landroid/graphics/drawable/Drawable;", "normalBg", "b", "getSelectedBg", "selectedBg", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "getIndicatorView", "()Landroid/widget/ImageView;", "indicatorView", "Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", "getAdapter", "()Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", "adapter", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "popupWindow", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFindAlumniPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FindAlumniPicker.kt\ncom/huachenjie/works/widget/FindAlumniPicker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,286:1\n1864#2,3:287\n1855#2,2:291\n1855#2,2:293\n1855#2,2:295\n1549#2:297\n1620#2,3:298\n1#3:290\n*S KotlinDebug\n*F\n+ 1 FindAlumniPicker.kt\ncom/huachenjie/works/widget/FindAlumniPicker\n*L\n152#1:287,3\n269#1:291,2\n272#1:293,2\n278#1:295,2\n284#1:297\n284#1:298,3\n*E\n"})
public final class FindAlumniPicker extends BLLinearLayout implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int maxCount;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<Integer> confirmSelectIndex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy normalBg;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super List<String>, Unit> listener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy selectedBg;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> draftSelectIndex;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textView;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy indicatorView;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy adapter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String defaultTitle;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy popupWindow;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String countLimitInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FindAlumniPicker(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FindAlumniPicker(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FindAlumniPicker(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void b(FindAlumniPicker findAlumniPicker, View view) {
        Intrinsics.checkNotNullParameter(findAlumniPicker, "this$0");
        findAlumniPicker.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingInterestTagsAdapter getAdapter() {
        return (SettingInterestTagsAdapter) this.adapter.getValue();
    }

    private final ImageView getIndicatorView() {
        return (ImageView) this.indicatorView.getValue();
    }

    private final Drawable getNormalBg() {
        return (Drawable) this.normalBg.getValue();
    }

    private final PopupWindow getPopupWindow() {
        return (PopupWindow) this.popupWindow.getValue();
    }

    private final Drawable getSelectedBg() {
        return (Drawable) this.selectedBg.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.textView.getValue();
    }

    public static /* synthetic */ void updateTagSelected$default(FindAlumniPicker findAlumniPicker, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        findAlumniPicker.n(i, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<String> c() {
        String tagNo;
        List<Integer> list = this.confirmSelectIndex;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            InterestTag interestTag = (InterestTag) getAdapter().getItemOrNull(((Number) it.next()).intValue());
            if (interestTag == null || (tagNo = interestTag.getTagNo()) == null) {
                tagNo = "";
            }
            arrayList.add(tagNo);
        }
        return arrayList;
    }

    public final void d(int position) {
        if (!this.draftSelectIndex.contains(Integer.valueOf(position)) && this.draftSelectIndex.size() >= h()) {
            fv5.b(this.countLimitInfo);
            return;
        }
        boolean z = !this.draftSelectIndex.contains(Integer.valueOf(position));
        if (z) {
            this.draftSelectIndex.add(Integer.valueOf(position));
        } else {
            this.draftSelectIndex.remove(Integer.valueOf(position));
        }
        updateTagSelected$default(this, position, z, false, 4, null);
    }

    public final void e(int position) {
        if (this.draftSelectIndex.contains(Integer.valueOf(position))) {
            return;
        }
        Integer num = (Integer) CollectionsKt.firstOrNull(this.draftSelectIndex);
        this.draftSelectIndex.clear();
        this.draftSelectIndex.add(Integer.valueOf(position));
        if (num != null) {
            updateTagSelected$default(this, num.intValue(), false, false, 4, null);
        }
        updateTagSelected$default(this, position, true, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.works_FindAlumniPicker);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.works_FindAlumniPicker_works_fap_default_title);
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, o.f);
            this.defaultTitle = string;
        }
        this.maxCount = typedArrayObtainStyledAttributes.getInt(R.styleable.works_FindAlumniPicker_works_fap_max_count, 1);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.works_FindAlumniPicker_works_fap_count_limit_info);
        if (string2 != null) {
            Intrinsics.checkNotNullExpressionValue(string2, o.f);
            this.countLimitInfo = string2;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean g() {
        return this.maxCount == 1;
    }

    public final int h() {
        int i = this.maxCount;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final void i() {
        this.confirmSelectIndex.clear();
        this.confirmSelectIndex.addAll(this.draftSelectIndex);
        o();
        Function1<? super List<String>, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(c());
        }
        getPopupWindow().dismiss();
    }

    public final void j() {
        this.draftSelectIndex.clear();
        this.draftSelectIndex.addAll(this.confirmSelectIndex);
    }

    public final void k() {
        if (Intrinsics.areEqual(this.draftSelectIndex, this.confirmSelectIndex)) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.draftSelectIndex.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (!this.confirmSelectIndex.contains(Integer.valueOf(iIntValue))) {
                linkedHashSet.add(Integer.valueOf(iIntValue));
            }
        }
        Iterator<T> it2 = this.confirmSelectIndex.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (!this.draftSelectIndex.contains(Integer.valueOf(iIntValue2))) {
                linkedHashSet.add(Integer.valueOf(iIntValue2));
            }
        }
        j();
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Number) it3.next()).intValue();
            updateTagSelected$default(this, iIntValue3, this.confirmSelectIndex.contains(Integer.valueOf(iIntValue3)), false, 4, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        m(true);
        j();
        PopupWindow popupWindow = getPopupWindow();
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        PopupWindowCompat.showAsDropDown(popupWindow, (View) parent, 0, 0, 80);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(boolean expanded) {
        setBackground(expanded ? getSelectedBg() : getNormalBg());
        getTextView().setTextColor(expanded ? -1 : RunIndexRecordAdapter.K);
        getIndicatorView().setImageResource(expanded ? R.drawable.works_ic_picker_arrow_open : R.drawable.works_ic_picker_arrow_close);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(int position, boolean selected, boolean notifyItemChanged) {
        InterestTag interestTag = (InterestTag) getAdapter().getItem(position);
        if (interestTag.getSelected() == selected) {
            return;
        }
        interestTag.setSelected(selected);
        if (notifyItemChanged) {
            getAdapter().notifyItemChanged(position);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o() {
        String tagName;
        TextView textView = getTextView();
        if (this.confirmSelectIndex.isEmpty()) {
            tagName = this.defaultTitle;
        } else if (g()) {
            InterestTag interestTag = (InterestTag) getAdapter().getItemOrNull(((Number) CollectionsKt.first(this.confirmSelectIndex)).intValue());
            if (interestTag == null || (tagName = interestTag.getTagName()) == null) {
                tagName = this.defaultTitle;
            }
        } else {
            tagName = this.defaultTitle + '(' + this.confirmSelectIndex.size() + ')';
        }
        textView.setText(tagName);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        m(false);
        k();
    }

    public final void setOnConfirmListener(@NotNull Function1<? super List<String>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.listener = listener;
    }

    public final void setPickerData(@NotNull List<InterestTag> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.confirmSelectIndex.clear();
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            InterestTag interestTag = (InterestTag) obj;
            if (!interestTag.getIsHeader() && interestTag.getSelected()) {
                this.confirmSelectIndex.add(Integer.valueOf(i));
            }
            i = i2;
        }
        j();
        getAdapter().setList(data);
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public FindAlumniPicker(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultTitle = "";
        this.maxCount = 1;
        this.countLimitInfo = "";
        this.confirmSelectIndex = new ArrayList();
        this.draftSelectIndex = new ArrayList();
        this.normalBg = LazyKt.lazy(new Function0<Drawable>() { // from class: com.huachenjie.works.widget.FindAlumniPicker$normalBg$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Drawable m988invoke() {
                return new DrawableCreator.Builder().setSolidColor(ar6.E).setCornersRadius(SizeUtils.b(10.0f)).build();
            }
        });
        this.selectedBg = LazyKt.lazy(new Function0<Drawable>() { // from class: com.huachenjie.works.widget.FindAlumniPicker$selectedBg$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Drawable m990invoke() {
                return new DrawableCreator.Builder().setSolidColor(RunIndexRecordAdapter.K).setCornersRadius(SizeUtils.b(10.0f)).build();
            }
        });
        this.textView = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.widget.FindAlumniPicker$textView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m991invoke() {
                TextView textView = new TextView(context);
                textView.setTextColor(RunIndexRecordAdapter.K);
                textView.setTextSize(12.0f);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                return textView;
            }
        });
        this.indicatorView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.works.widget.FindAlumniPicker$indicatorView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m987invoke() {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.works_ic_picker_arrow_close);
                return imageView;
            }
        });
        this.adapter = LazyKt.lazy(new FindAlumniPicker$adapter$2(this));
        this.popupWindow = LazyKt.lazy(new FindAlumniPicker$popupWindow$2(context, this));
        f(attributeSet);
        setBackground(getNormalBg());
        setGravity(16);
        setPadding(SizeUtils.b(12.0f), 0, SizeUtils.b(12.0f), 0);
        TextView textView = getTextView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(0, 0, SizeUtils.b(12.0f), 0);
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        addView(getIndicatorView(), SizeUtils.b(12.0f), SizeUtils.b(12.0f));
        o();
        y57.f(this, 0L, new View.OnClickListener() { // from class: com.zj.adlib.zg3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindAlumniPicker.b(this.f46258a, view);
            }
        }, 1, null);
    }
}
