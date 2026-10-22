package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.igexin.push.g.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010<\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010=\u001a\u00020\rH\u0002J\b\u0010>\u001a\u00020\rH\u0014J\"\u0010?\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\r0-R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b \u0010!R#\u0010#\u001a\n $*\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b%\u0010!R#\u0010'\u001a\n $*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b)\u0010*R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\r0-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0013\u00103\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u001b\u00107\u001a\u0002088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0017\u001a\u0004\b9\u0010:¨\u0006A"}, d2 = {"Lcom/huachenjie/common/widget/CommonSearchViewV2;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clearListener", "Lkotlin/Function0;", "", "getClearListener", "()Lkotlin/jvm/functions/Function0;", "setClearListener", "(Lkotlin/jvm/functions/Function0;)V", "etSearch", "Landroid/widget/EditText;", "getEtSearch", "()Landroid/widget/EditText;", "etSearch$delegate", "Lkotlin/Lazy;", "intervalCallback", "Ljava/lang/Runnable;", "intervalHandler", "Landroid/os/Handler;", "intervalTime", "", "ivBack", "Landroid/widget/ImageView;", "getIvBack", "()Landroid/widget/ImageView;", "ivBack$delegate", "ivClear", "kotlin.jvm.PlatformType", "getIvClear", "ivClear$delegate", "llSearch", "Landroid/view/View;", "getLlSearch", "()Landroid/view/View;", "llSearch$delegate", "searchListener", "Lkotlin/Function1;", "", "getSearchListener", "()Lkotlin/jvm/functions/Function1;", "setSearchListener", "(Lkotlin/jvm/functions/Function1;)V", "text", "Landroid/text/Editable;", "getText", "()Landroid/text/Editable;", "tvSearch", "Landroid/widget/TextView;", "getTvSearch", "()Landroid/widget/TextView;", "tvSearch$delegate", "initAttrs", "initView", "onDetachedFromWindow", "openIntervalCallback", "textChangeCallback", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonSearchViewV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,178:1\n65#2,16:179\n93#2,3:195\n65#2,16:198\n93#2,3:214\n*S KotlinDebug\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2\n*L\n140#1:179,16\n140#1:195,3\n164#1:198,16\n164#1:214,3\n*E\n"})
public final class CommonSearchViewV2 extends LinearLayout {

    @NotNull
    private Function0<Unit> clearListener;

    /* JADX INFO: renamed from: etSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy etSearch;

    @Nullable
    private Runnable intervalCallback;

    @Nullable
    private Handler intervalHandler;
    private long intervalTime;

    /* JADX INFO: renamed from: ivBack$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivBack;

    /* JADX INFO: renamed from: ivClear$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivClear;

    /* JADX INFO: renamed from: llSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy llSearch;

    @NotNull
    private Function1<? super String, Unit> searchListener;

    /* JADX INFO: renamed from: tvSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvSearch;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView getIvBack() {
        return (ImageView) this.ivBack.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getIvClear() {
        return (ImageView) this.ivClear.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getLlSearch() {
        return (View) this.llSearch.getValue();
    }

    private final void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CommonSearchView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…,\n            0\n        )");
        EditText etSearch = getEtSearch();
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.CommonSearchView_csv_searchHint);
        if (string == null) {
            string = "";
        }
        etSearch.setHint(string);
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.CommonSearchView_csv_showBackView, false)) {
            getIvBack().setVisibility(0);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void initView() {
        setGravity(16);
        getEtSearch().addTextChangedListener(new TextWatcher() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$initView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                this.this$0.getIvClear().setVisibility(s == null || s.length() == 0 ? 8 : 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        getTvSearch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openIntervalCallback$lambda$2(CommonSearchViewV2 commonSearchViewV2, Function1 function1) {
        Intrinsics.checkNotNullParameter(commonSearchViewV2, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$textChangeCallback");
        if (commonSearchViewV2.getEtSearch().isFocusable()) {
            function1.invoke(commonSearchViewV2.getEtSearch().getText().toString());
        }
    }

    @NotNull
    public final Function0<Unit> getClearListener() {
        return this.clearListener;
    }

    @NotNull
    public final EditText getEtSearch() {
        Object value = this.etSearch.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-etSearch>(...)");
        return (EditText) value;
    }

    @NotNull
    public final Function1<String, Unit> getSearchListener() {
        return this.searchListener;
    }

    @Nullable
    public final Editable getText() {
        return getEtSearch().getText();
    }

    @NotNull
    public final TextView getTvSearch() {
        Object value = this.tvSearch.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvSearch>(...)");
        return (TextView) value;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.intervalHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void openIntervalCallback(final long intervalTime, @NotNull final Function1<? super String, Unit> textChangeCallback) {
        Intrinsics.checkNotNullParameter(textChangeCallback, "textChangeCallback");
        this.intervalTime = intervalTime;
        this.intervalHandler = new Handler(Looper.getMainLooper());
        this.intervalCallback = new Runnable() { // from class: com.zj.adlib.kq1
            @Override // java.lang.Runnable
            public final void run() {
                CommonSearchViewV2.openIntervalCallback$lambda$2(this.f42885a, textChangeCallback);
            }
        };
        getEtSearch().addTextChangedListener(new TextWatcher() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$openIntervalCallback$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                Handler handler = this.this$0.intervalHandler;
                Intrinsics.checkNotNull(handler);
                Runnable runnable = this.this$0.intervalCallback;
                Intrinsics.checkNotNull(runnable);
                handler.removeCallbacks(runnable);
                if (s == null || s.length() == 0) {
                    Runnable runnable2 = this.this$0.intervalCallback;
                    Intrinsics.checkNotNull(runnable2);
                    runnable2.run();
                } else {
                    Handler handler2 = this.this$0.intervalHandler;
                    Intrinsics.checkNotNull(handler2);
                    Runnable runnable3 = this.this$0.intervalCallback;
                    Intrinsics.checkNotNull(runnable3);
                    handler2.postDelayed(runnable3, intervalTime);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
    }

    public final void setClearListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.clearListener = function0;
    }

    public final void setSearchListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.searchListener = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.searchListener = new Function1<String, Unit>() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$searchListener$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
            }
        };
        this.clearListener = new Function0<Unit>() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$clearListener$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m383invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m383invoke() {
            }
        };
        this.llSearch = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$llSearch$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m387invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.view_common_search_v2, (ViewGroup) this.this$0, false);
                this.this$0.addView(viewInflate);
                return viewInflate;
            }
        });
        this.etSearch = LazyKt.lazy(new CommonSearchViewV2$etSearch$2(this));
        this.tvSearch = LazyKt.lazy(new CommonSearchViewV2$tvSearch$2(this));
        this.ivClear = LazyKt.lazy(new CommonSearchViewV2$ivClear$2(this));
        this.ivBack = LazyKt.lazy(new CommonSearchViewV2$ivBack$2(this));
        initAttrs(context, attributeSet, i);
        initView();
    }
}
