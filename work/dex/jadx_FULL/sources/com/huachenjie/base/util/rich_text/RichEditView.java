package com.huachenjie.base.util.rich_text;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.base.util.rich_text.RichEditView;
import com.huachenjie.run.map.RouteOverlay;
import com.vanniktech.emoji.EmojiEditText;
import com.zj.adlib.ti7;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JB\u001b\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bI\u0010MJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nJ \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0014R?\u0010(\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R2\u00103\u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/0-8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00109R$\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010;R\u001b\u0010@\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b>\u0010?R$\u0010F\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006O"}, d2 = {"Lcom/huachenjie/base/util/rich_text/RichEditView;", "Lcom/vanniktech/emoji/EmojiEditText;", "", "start", "before", "count", "", "f", "k", "getAllSpan", "", "Lcom/huachenjie/base/bean/RichUserBean;", "getUserList", "Lcom/huachenjie/base/bean/RichSubjectBean;", "getTopicList", "", "richTextField", "url", "", "delPreSymbol", "insertRichTextField", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "id", "onTextContextMenuItem", "selStart", "selEnd", "onSelectionChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", "s", "a", "Lkotlin/jvm/functions/Function1;", "getTextChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "textChangedCallback", "b", "getSpecialSymbolCallback", "setSpecialSymbolCallback", "specialSymbolCallback", "", "Landroid/text/style/URLSpan;", "Lkotlin/Pair;", "Ljava/util/Map;", "getSpansRanges", "()Ljava/util/Map;", "spansRanges", "K", "I", "preSelectionStart", "L", "preSelectionEnd", "Z", "isPasteContent", "Lkotlin/Pair;", "pasteRange", "Lkotlin/Lazy;", "getMaxLength", "()I", "maxLength", "value", "getRichText", "()Ljava/lang/String;", "setRichText", "(Ljava/lang/String;)V", "richText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRichEditView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RichEditView.kt\ncom/huachenjie/base/util/rich_text/RichEditView\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,399:1\n215#2,2:400\n215#2,2:417\n1855#3,2:402\n1855#3,2:404\n1855#3,2:406\n1855#3,2:408\n1045#3:414\n1855#3,2:420\n13309#4,2:410\n13309#4,2:412\n13309#4,2:415\n1#5:419\n*S KotlinDebug\n*F\n+ 1 RichEditView.kt\ncom/huachenjie/base/util/rich_text/RichEditView\n*L\n56#1:400,2\n284#1:417,2\n134#1:402,2\n153#1:404,2\n211#1:406,2\n222#1:408,2\n267#1:414\n324#1:420,2\n240#1:410,2\n259#1:412,2\n279#1:415,2\n*E\n"})
public class RichEditView extends EmojiEditText {

    @NotNull
    public static final String GOODS_START = "$ ";

    @NotNull
    public static final String TOPIC_START = "#";

    @NotNull
    public static final String USER_START = "@";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int preSelectionStart;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int preSelectionEnd;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Map<URLSpan, Pair<Integer, Integer>> spansRanges;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy maxLength;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Pair<Integer, Integer> pasteRange;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public Function1<? super Editable, Unit> textChangedCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isPasteContent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public Function1<? super String, Unit> specialSymbolCallback;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0017J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0017J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0017¨\u0006\u000e"}, d2 = {"com/huachenjie/base/util/rich_text/RichEditView$a", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        @CallSuper
        public void afterTextChanged(@Nullable Editable s) {
            RichEditView.this.k();
            RichEditView.this.getAllSpan();
            RichEditView.this.getTextChangedCallback().invoke(s);
        }

        @Override // android.text.TextWatcher
        @CallSuper
        public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
            RichEditView.this.getAllSpan();
        }

        @Override // android.text.TextWatcher
        @CallSuper
        public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
            CharSequence charSequenceSubSequence;
            String string;
            RichEditView.this.f(start, before, count);
            if (RichEditView.this.isPasteContent) {
                RichEditView.this.pasteRange = new Pair(Integer.valueOf(start), Integer.valueOf(start + count));
            }
            if (count != 1 || s == null || (charSequenceSubSequence = s.subSequence(start, count + start)) == null || (string = charSequenceSubSequence.toString()) == null) {
                return;
            }
            RichEditView.this.getSpecialSymbolCallback().invoke(string);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 RichEditView.kt\ncom/huachenjie/base/util/rich_text/RichEditView\n*L\n1#1,328:1\n267#2:329\n*E\n"})
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues((Integer) ((Pair) ((Pair) t).getSecond()).getFirst(), (Integer) ((Pair) ((Pair) t2).getSecond()).getFirst());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RichEditView(@NotNull Context context) {
        super(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textChangedCallback = RichEditView$textChangedCallback$1.INSTANCE;
        this.specialSymbolCallback = RichEditView$specialSymbolCallback$1.INSTANCE;
        this.spansRanges = new LinkedHashMap();
        this.maxLength = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.base.util.rich_text.RichEditView$maxLength$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m228invoke() {
                InputFilter[] filters = this.this$0.getFilters();
                Intrinsics.checkNotNullExpressionValue(filters, "filters");
                InputFilter inputFilter = (InputFilter) ArraysKt.firstOrNull(filters);
                return Integer.valueOf(inputFilter instanceof InputFilter.LengthFilter ? ((InputFilter.LengthFilter) inputFilter).getMax() : 500);
            }
        });
        addTextChangedListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(RichEditView richEditView, SpannableStringBuilder spannableStringBuilder, Pair pair) {
        Intrinsics.checkNotNullParameter(richEditView, "this$0");
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "$preText");
        Intrinsics.checkNotNullParameter(pair, "$range");
        richEditView.setText(spannableStringBuilder.delete(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue() - 1));
        richEditView.setSelection(((Number) pair.getFirst()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void getAllSpan() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Editable text = getText();
        if (text != null) {
            URLSpan[] uRLSpanArr = (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class);
            Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "spans");
            for (URLSpan uRLSpan : uRLSpanArr) {
                Intrinsics.checkNotNullExpressionValue(uRLSpan, "clickableSpan");
                linkedHashMap.put(uRLSpan, new Pair(Integer.valueOf(text.getSpanStart(uRLSpan)), Integer.valueOf(text.getSpanEnd(uRLSpan))));
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(MapsKt.toList(linkedHashMap), new c());
        this.spansRanges.clear();
        this.spansRanges.putAll(MapsKt.toMap(listSortedWith));
    }

    private final int getMaxLength() {
        return ((Number) this.maxLength.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(RichEditView richEditView, Pair pair, int i, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(richEditView, "this$0");
        Intrinsics.checkNotNullParameter(pair, "$range");
        Intrinsics.checkNotNullParameter(entry, "$it");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(richEditView.getText());
        spannableStringBuilder.removeSpan(entry.getKey());
        richEditView.setText(spannableStringBuilder);
        richEditView.setSelection(((Number) pair.getFirst()).intValue() + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(RichEditView richEditView, Ref.IntRef intRef, String str) {
        Intrinsics.checkNotNullParameter(richEditView, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$preSelection");
        Intrinsics.checkNotNullParameter(str, "$richTextField");
        richEditView.setSelection(intRef.element + str.length());
    }

    public static /* synthetic */ void insertRichTextField$default(RichEditView richEditView, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertRichTextField");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        richEditView.insertRichTextField(str, str2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(RichEditView richEditView, SpannableStringBuilder spannableStringBuilder, int i) {
        Intrinsics.checkNotNullParameter(richEditView, "this$0");
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "$this_apply");
        richEditView.setText(spannableStringBuilder);
        richEditView.setSelection(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(RichEditView richEditView, SpannableStringBuilder spannableStringBuilder, Pair pair) {
        Intrinsics.checkNotNullParameter(richEditView, "this$0");
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "$this_apply");
        Intrinsics.checkNotNullParameter(pair, "$this_apply$1");
        richEditView.setText(spannableStringBuilder);
        richEditView.setSelection(((Number) pair.getSecond()).intValue());
        richEditView.getAllSpan();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int start, int before, final int count) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        if (count == 0 && before == 1) {
            int i = start + before;
            Iterator<T> it = this.spansRanges.entrySet().iterator();
            while (it.hasNext()) {
                final Pair pair = (Pair) ((Map.Entry) it.next()).getValue();
                if (i == ((Number) pair.getSecond()).intValue()) {
                    post(new Runnable() { // from class: com.zj.adlib.qi7
                        @Override // java.lang.Runnable
                        public final void run() {
                            RichEditView.g(this.f19113a, spannableStringBuilder, pair);
                        }
                    });
                }
            }
            return;
        }
        if (1 <= count && count < before) {
            Iterator<T> it2 = this.spansRanges.entrySet().iterator();
            while (it2.hasNext()) {
                final Map.Entry entry = (Map.Entry) it2.next();
                final Pair pair2 = (Pair) entry.getValue();
                if (start == ((Number) pair2.getFirst()).intValue() && start + before == ((Number) pair2.getSecond()).intValue()) {
                    post(new Runnable() { // from class: com.zj.adlib.ri7
                        @Override // java.lang.Runnable
                        public final void run() {
                            RichEditView.h(this.f44463a, pair2, count, entry);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String getRichText() {
        String strValueOf = String.valueOf(getText());
        if (this.spansRanges.isEmpty()) {
            return strValueOf;
        }
        StringBuilder sb = new StringBuilder(strValueOf);
        int length = 0;
        for (Map.Entry<URLSpan, Pair<Integer, Integer>> entry : this.spansRanges.entrySet()) {
            Pair<Integer, Integer> value = entry.getValue();
            String strSubstring = strValueOf.substring(((Number) value.getFirst()).intValue(), ((Number) value.getSecond()).intValue());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String str = "<a href=\"" + entry.getKey().getURL() + "\">" + strSubstring + "</a>";
            if (((Number) value.getSecond()).intValue() + length <= sb.length()) {
                sb.replace(((Number) value.getFirst()).intValue() + length, ((Number) value.getSecond()).intValue() + length, str);
                length += str.length() - strSubstring.length();
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "build.toString()");
        return StringsKt.trim(string).toString();
    }

    @NotNull
    public final Map<URLSpan, Pair<Integer, Integer>> getSpansRanges() {
        return this.spansRanges;
    }

    @NotNull
    public final Function1<String, Unit> getSpecialSymbolCallback() {
        return this.specialSymbolCallback;
    }

    @NotNull
    public final Function1<Editable, Unit> getTextChangedCallback() {
        return this.textChangedCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<RichSubjectBean> getTopicList() {
        ArrayList arrayList = new ArrayList();
        for (URLSpan uRLSpan : this.spansRanges.keySet()) {
            Editable text = getText();
            Intrinsics.checkNotNull(text);
            Pair<Integer, Integer> pair = this.spansRanges.get(uRLSpan);
            Intrinsics.checkNotNull(pair);
            int iIntValue = ((Number) pair.getFirst()).intValue();
            Pair<Integer, Integer> pair2 = this.spansRanges.get(uRLSpan);
            Intrinsics.checkNotNull(pair2);
            String string = text.subSequence(iIntValue, ((Number) pair2.getSecond()).intValue()).toString();
            if (StringsKt.startsWith$default(string, "#", false, 2, (Object) null)) {
                String strSubstring = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                String string2 = StringsKt.trim(strSubstring).toString();
                RichTextUtils richTextUtils = RichTextUtils.f32968a;
                String url = uRLSpan.getURL();
                Intrinsics.checkNotNullExpressionValue(url, "it.url");
                arrayList.add(new RichSubjectBean(string2, richTextUtils.e(url)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<RichUserBean> getUserList() {
        ArrayList arrayList = new ArrayList();
        for (URLSpan uRLSpan : this.spansRanges.keySet()) {
            Editable text = getText();
            Intrinsics.checkNotNull(text);
            Pair<Integer, Integer> pair = this.spansRanges.get(uRLSpan);
            Intrinsics.checkNotNull(pair);
            int iIntValue = ((Number) pair.getFirst()).intValue();
            Pair<Integer, Integer> pair2 = this.spansRanges.get(uRLSpan);
            Intrinsics.checkNotNull(pair2);
            String string = text.subSequence(iIntValue, ((Number) pair2.getSecond()).intValue()).toString();
            if (StringsKt.startsWith$default(string, "@", false, 2, (Object) null)) {
                String strSubstring = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                String string2 = StringsKt.trim(strSubstring).toString();
                RichTextUtils richTextUtils = RichTextUtils.f32968a;
                String url = uRLSpan.getURL();
                Intrinsics.checkNotNullExpressionValue(url, "it.url");
                arrayList.add(new RichUserBean(string2, richTextUtils.e(url)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insertRichTextField(@NotNull final String richTextField, @NotNull String url, boolean delPreSymbol) {
        Editable text;
        Intrinsics.checkNotNullParameter(richTextField, "richTextField");
        Intrinsics.checkNotNullParameter(url, "url");
        Editable text2 = getText();
        if ((text2 != null ? text2.length() : 0) + richTextField.length() <= getMaxLength() && (text = getText()) != null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = getSelectionStart();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            if (delPreSymbol) {
                int i = intRef.element;
                spannableStringBuilder.delete(i - 1, i);
                intRef.element--;
            }
            spannableStringBuilder.insert(intRef.element, (CharSequence) richTextField);
            RichTextUtils richTextUtils = RichTextUtils.f32968a;
            int i2 = intRef.element;
            RichTextUtils.b(richTextUtils, spannableStringBuilder, url, i2, i2 + richTextField.length(), 0, 16, null);
            setText(spannableStringBuilder);
            post(new Runnable() { // from class: com.zj.adlib.ni7
                @Override // java.lang.Runnable
                public final void run() {
                    RichEditView.i(this.f43531a, intRef, richTextField);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k() {
        final Pair<Integer, Integer> pair = this.pasteRange;
        if (pair != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
            Object[] spans = spannableStringBuilder.getSpans(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue(), CharacterStyle.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(first, second, …aracterStyle::class.java)");
            for (Object obj : spans) {
                spannableStringBuilder.removeSpan((CharacterStyle) obj);
            }
            post(new Runnable() { // from class: com.zj.adlib.oi7
                @Override // java.lang.Runnable
                public final void run() {
                    RichEditView.l(this.f18644a, spannableStringBuilder, pair);
                }
            });
        }
        this.pasteRange = null;
        this.isPasteContent = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestoreInstanceState(@Nullable Parcelable state) {
        super/*android.view.View*/.onRestoreInstanceState(state);
        final int selectionEnd = getSelectionEnd();
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, URLSpan::class.java)");
        for (Object obj : spans) {
            URLSpan uRLSpan = (URLSpan) obj;
            Pair pair = new Pair(Integer.valueOf(spannableStringBuilder.getSpanStart(uRLSpan)), Integer.valueOf(spannableStringBuilder.getSpanEnd(uRLSpan)));
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "it.url");
            linkedHashMap.put(pair, url);
            spannableStringBuilder.removeSpan(uRLSpan);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            spannableStringBuilder.setSpan(new RichColorUrlSpan((String) entry.getValue(), Color.parseColor(RouteOverlay.f12338c)), ((Number) ((Pair) entry.getKey()).getFirst()).intValue(), ((Number) ((Pair) entry.getKey()).getSecond()).intValue(), 33);
        }
        post(new Runnable() { // from class: com.zj.adlib.pi7
            @Override // java.lang.Runnable
            public final void run() {
                RichEditView.j(this.f18852a, spannableStringBuilder, selectionEnd);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSelectionChanged(int selStart, int selEnd) {
        Object next;
        Pair pair;
        super/*android.widget.TextView*/.onSelectionChanged(selStart, selEnd);
        Map<URLSpan, Pair<Integer, Integer>> map = this.spansRanges;
        if (map == null) {
            return;
        }
        if (selStart == selEnd) {
            Iterator<T> it = map.values().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    pair = (Pair) next;
                }
            } while (!(selStart > ((Number) pair.getFirst()).intValue() && selStart < ((Number) pair.getSecond()).intValue()));
            if (((Pair) next) != null) {
                setSelection(this.preSelectionStart);
                return;
            }
        } else {
            Iterator<T> it2 = map.values().iterator();
            int iIntValue = selStart;
            int iIntValue2 = selEnd;
            while (it2.hasNext()) {
                Pair pair2 = (Pair) it2.next();
                if (iIntValue >= ((Number) pair2.getFirst()).intValue() && iIntValue < ((Number) pair2.getSecond()).intValue()) {
                    iIntValue = ((Number) pair2.getFirst()).intValue();
                }
                if (iIntValue2 > ((Number) pair2.getFirst()).intValue() && iIntValue2 < ((Number) pair2.getSecond()).intValue()) {
                    iIntValue2 = ((Number) pair2.getSecond()).intValue();
                }
            }
            if (iIntValue != selStart || iIntValue2 != selEnd) {
                setSelection(iIntValue, iIntValue2);
                return;
            }
        }
        this.preSelectionStart = selStart;
        this.preSelectionEnd = selEnd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTextContextMenuItem(int id) {
        if (id == 16908322) {
            this.isPasteContent = true;
        }
        return super/*androidx.appcompat.widget.AppCompatEditText*/.onTextContextMenuItem(id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRichText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ti7.d(this, str, true);
    }

    public final void setSpecialSymbolCallback(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.specialSymbolCallback = function1;
    }

    public final void setTextChangedCallback(@NotNull Function1<? super Editable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.textChangedCallback = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RichEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textChangedCallback = RichEditView$textChangedCallback$1.INSTANCE;
        this.specialSymbolCallback = RichEditView$specialSymbolCallback$1.INSTANCE;
        this.spansRanges = new LinkedHashMap();
        this.maxLength = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.base.util.rich_text.RichEditView$maxLength$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m228invoke() {
                InputFilter[] filters = this.this$0.getFilters();
                Intrinsics.checkNotNullExpressionValue(filters, "filters");
                InputFilter inputFilter = (InputFilter) ArraysKt.firstOrNull(filters);
                return Integer.valueOf(inputFilter instanceof InputFilter.LengthFilter ? ((InputFilter.LengthFilter) inputFilter).getMax() : 500);
            }
        });
        addTextChangedListener(new a());
    }
}
