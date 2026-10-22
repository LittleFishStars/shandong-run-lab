package com.huachenjie.common.binding_adapter;

import android.animation.Animator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.coroutines.BindingAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.common.widget.PointCardView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.common.widget.StatusImageView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.c67;
import com.zj.adlib.jj8;
import com.zj.adlib.qk3;
import com.zj.adlib.v39;
import com.zj.adlib.yn1;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CommonBindingAdapter {

    public interface OnScroll {
        void a(RecyclerView recyclerView, int dx, int dy);
    }

    public interface OnScrollStateChanged {
        void a(RecyclerView recyclerView, int newState);
    }

    public class a implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable arg0) {
            if (!CommonBindingAdapter.j(arg0.toString())) {
                arg0.clear();
            }
            if (arg0.toString().startsWith("0")) {
                arg0.delete(0, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    }

    public class b implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (source.equals(" ") || source.toString().contentEquals("\n")) {
                return "";
            }
            return null;
        }
    }

    public class c implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(source.toString()).find()) {
                return "";
            }
            return null;
        }
    }

    public class d extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f33646a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f8510a;
        public final /* synthetic */ boolean b;

        public d(final boolean val$autoScrollToTopWhenInsert, final RecyclerView val$recyclerView, final boolean val$autoScrollToBottomWhenInsert) {
            this.f8510a = val$autoScrollToTopWhenInsert;
            this.f33646a = val$recyclerView;
            this.b = val$autoScrollToBottomWhenInsert;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            if (this.f8510a) {
                this.f33646a.scrollToPosition(0);
            } else if (this.b) {
                RecyclerView recyclerView = this.f33646a;
                recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount());
            }
        }
    }

    public class e extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnScroll f33647a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnScrollStateChanged f8511a;

        public e(final OnScrollStateChanged val$onScrollStateChanged, final OnScroll val$onScroll) {
            this.f8511a = val$onScrollStateChanged;
            this.f33647a = val$onScroll;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            OnScrollStateChanged onScrollStateChanged = this.f8511a;
            if (onScrollStateChanged != null) {
                onScrollStateChanged.a(recyclerView, newState);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            OnScroll onScroll = this.f33647a;
            if (onScroll != null) {
                onScroll.a(recyclerView, dx, dy);
            }
        }
    }

    @BindingAdapter({"setCheckedListener"})
    public static void A(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener listener) {
        switchCompat.setOnCheckedChangeListener(listener);
    }

    @BindingAdapter(requireAll = false, value = {"color"})
    public static void B(SwipeRefreshLayout view, @ColorInt int color) {
        view.setColorSchemeColors(color);
    }

    @BindingAdapter({"isDingFont"})
    public static void C(TextView textView, boolean isDing) {
        try {
            textView.setTypeface(qk3.a("font/shandong.ttf"));
        } catch (Exception unused) {
        }
    }

    @BindingAdapter(requireAll = false, value = {"noSpace", "noSpeChat"})
    public static void D(EditText editText, boolean noSpace, boolean noSpeChat) {
        if (noSpace) {
            new b();
        }
        if (noSpeChat) {
            editText.setFilters(new InputFilter[]{new c()});
        }
    }

    @BindingAdapter(requireAll = false, value = {"setHasFixedSize"})
    public static void E(final RecyclerView recyclerView, boolean b2) {
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(b2);
        }
    }

    @BindingAdapter({"horizontalBias"})
    public static void F(View view, Float value) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (value.floatValue() < 0.0f) {
                layoutParams2.horizontalBias = 0.0f;
            } else if (value.floatValue() > 1.0f) {
                layoutParams2.horizontalBias = 1.0f;
            } else {
                layoutParams2.horizontalBias = value.floatValue();
            }
            view.setLayoutParams(layoutParams2);
        }
    }

    @BindingAdapter({"android:layout_height"})
    public static void G(View view, float height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) height;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"android:layout_width"})
    public static void H(View view, float width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) width;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter(requireAll = false, value = {LayoutModel.MODEL_KEY_MARGIN_LEFT, LayoutModel.MODEL_KEY_MARGIN_TOP, LayoutModel.MODEL_KEY_MARGIN_RIGHT, LayoutModel.MODEL_KEY_MARGIN_BOTTOM, "marginIsDp"})
    public static void I(View view, int left, int top, int right, int bottom, Boolean isDp) {
        if (isDp == null || isDp.booleanValue()) {
            left = jj8.a(left);
            top = jj8.a(top);
            right = jj8.a(right);
            bottom = jj8.a(bottom);
        }
        ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(left, top, right, bottom);
    }

    @BindingAdapter({"numberDecimalLength"})
    public static void J(EditText editText, final int length) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.zj.adlib.zp1
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return CommonBindingAdapter.m(length, charSequence, i, i2, spanned, i3, i4);
            }
        }});
    }

    @BindingAdapter({"OnPageChange"})
    public static void K(ViewPager2 viewPager2, ViewPager2.OnPageChangeCallback callback) {
        viewPager2.registerOnPageChangeCallback(callback);
    }

    @BindingAdapter(requireAll = false, value = {"onScrolled", "onScrollStateChanged"})
    public static void L(RecyclerView recyclerView, final OnScroll onScroll, final OnScrollStateChanged onScrollStateChanged) {
        recyclerView.addOnScrollListener(new e(onScrollStateChanged, onScroll));
    }

    @BindingAdapter(requireAll = false, value = {"onlyNumber"})
    public static void M(EditText view, boolean b2) {
        if (b2) {
            view.setInputType(2);
            view.addTextChangedListener(new a());
        }
    }

    @BindingAdapter({"overScrollMode"})
    public static void N(ViewPager2 viewPager2, int scrollMode) {
        try {
            View childAt = viewPager2.getChildAt(0);
            if (childAt instanceof RecyclerView) {
                childAt.setOverScrollMode(scrollMode);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @BindingAdapter(requireAll = false, value = {"paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "paddingIsDp"})
    public static void O(View view, int left, int top, int right, int bottom, Boolean isDp) {
        if (isDp == null || isDp.booleanValue()) {
            left = jj8.a(left);
            top = jj8.a(top);
            right = jj8.a(right);
            bottom = jj8.a(bottom);
        }
        view.setPadding(left, top, right, bottom);
    }

    @BindingAdapter({AliyunLogCommon.TERMINAL_TYPE, "format"})
    public static void P(TextView textView, String phone, String format) {
        if (phone == null || phone.length() < 11 || format == null || textView == null) {
            return;
        }
        textView.setText(ys8.c(format, phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")));
    }

    @BindingAdapter({"pointValue"})
    public static void Q(View view, String value) {
        if (view instanceof PointCardView) {
            ((PointCardView) view).setText(value);
        }
    }

    @BindingAdapter({"android:progress"})
    public static void R(ProgressBar progressbar, int progress) {
        if (progressbar != null) {
            progressbar.setProgress(progress);
        }
    }

    @BindingAdapter({"src"})
    public static void S(View view, int res) {
        if (!(view instanceof ImageView) || res == 0) {
            return;
        }
        ((ImageView) view).setImageResource(res);
    }

    @BindingAdapter({"bindSlBgColor"})
    public static void T(ShadowConstraintLayout view, @ColorInt int bgColor) {
        view.setBgColor(bgColor);
    }

    @BindingAdapter({"statusImage"})
    public static void U(StatusImageView statusImageView, StatusImageView.StatusImage statusImage) {
        statusImageView.setStatusImage(statusImage);
    }

    @BindingAdapter({"android:textColor"})
    public static void V(TextView textView, @ColorInt Integer textColor) {
        textView.setTextColor(textColor.intValue());
    }

    @BindingAdapter({"android:textColor"})
    public static void W(TextView textView, String textColor) {
        if (TextUtils.isEmpty(textColor)) {
            return;
        }
        textView.setTextColor(zn1.o(textColor));
    }

    @BindingAdapter({"textSize"})
    public static void X(TextView textView, Float textSize) {
        if (textSize == null || textSize.floatValue() <= 0.0f) {
            return;
        }
        textView.setTextSize(textSize.floatValue());
    }

    @BindingAdapter({"tint"})
    public static void Y(ImageView imageView, @ColorInt Integer tintColor) {
        Drawable drawable;
        if (tintColor == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        drawable.setTint(tintColor.intValue());
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter({"startTintColor", "endTintColor", "tintAlpha"})
    public static void Z(ImageView imageView, @ColorInt Integer startTextColor, @ColorInt Integer endTextColor, float alpha) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.setTint(yn1.a(startTextColor, endTextColor, Math.max(0.0f, Math.min(255.0f, alpha)) / 255.0f));
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter(requireAll = false, value = {"imageResource"})
    public static void a0(ImageView view, int resId) {
        if (view == null || resId == 0) {
            return;
        }
        view.setImageResource(resId);
    }

    @BindingAdapter(requireAll = false, value = {"url", "option", "centerCrop"})
    public static void b0(final ImageView view, final Object url, final RequestOptions requestOptions, boolean centerCrop) {
        if (centerCrop && (url instanceof String)) {
            view.post(new Runnable() { // from class: com.zj.adlib.aq1
                @Override // java.lang.Runnable
                public final void run() {
                    CommonBindingAdapter.n(view, url, requestOptions);
                }
            });
            return;
        }
        if (url == null) {
            url = "";
        }
        o(view, requestOptions, url);
    }

    @BindingAdapter({"android:alpha"})
    public static void c0(View view, float alpha) {
        if (view != null) {
            view.setAlpha(alpha);
        }
    }

    @BindingAdapter(requireAll = false, value = {"itemDecoration"})
    public static void d(final RecyclerView recyclerView, RecyclerView.ItemDecoration itemDecoration) {
        if (recyclerView == null || itemDecoration == null) {
            return;
        }
        if (recyclerView.getItemDecorationCount() > 0) {
            recyclerView.removeItemDecorationAt(0);
        }
        recyclerView.addItemDecoration(itemDecoration);
    }

    @BindingAdapter({"android:drawableStart"})
    public static void d0(TextView textView, int res) {
        if (textView == null) {
            return;
        }
        if (res == 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(textView.getContext(), res), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @BindingAdapter({"allowItemAnimator"})
    public static void e(RecyclerView recyclerView, boolean allow) {
        ((DefaultItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(allow);
    }

    @BindingAdapter({"android:enabled"})
    public static void e0(View view, boolean enabled) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
    }

    @BindingAdapter({"topToId", "toTop"})
    public static void f(View view, int id, boolean toTop) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topToBottom = toTop ? -1 : id;
            if (!toTop) {
                id = -1;
            }
            layoutParams.topToTop = id;
            view.setLayoutParams(layoutParams);
        }
    }

    @BindingAdapter({"layout_height"})
    public static void f0(View view, float height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) height;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter(requireAll = false, value = {"adapter", "autoScrollToTopWhenInsert", "autoScrollToBottomWhenInsert"})
    public static void g(final RecyclerView recyclerView, RecyclerView.Adapter adapter, final boolean autoScrollToTopWhenInsert, final boolean autoScrollToBottomWhenInsert) {
        if (recyclerView == null || recyclerView.getAdapter() != null || adapter == null) {
            return;
        }
        recyclerView.setAdapter(adapter);
        adapter.registerAdapterDataObserver(new d(autoScrollToTopWhenInsert, recyclerView, autoScrollToBottomWhenInsert));
    }

    @BindingAdapter({"layout_width"})
    public static void g0(View view, float width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) width;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter(requireAll = false, value = {"onFocus"})
    public static void h(final View view, View.OnFocusChangeListener listener) {
        if (view != null) {
            view.setOnFocusChangeListener(listener);
        }
    }

    @BindingAdapter({"flowId", "stringList", "adapter"})
    public static void h0(ConstraintLayout constraintLayout, int flowId, List<String> stringList, FlowAdapter flowAdapter) {
        View viewFindViewById = constraintLayout.findViewById(flowId);
        if (viewFindViewById instanceof Flow) {
            Flow flow = (Flow) viewFindViewById;
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                flow.removeView(constraintLayout.getChildAt(i));
            }
            constraintLayout.removeAllViews();
            constraintLayout.addView(flow);
            if (flowAdapter == null) {
                return;
            }
            Iterator<String> it = stringList.iterator();
            while (it.hasNext()) {
                View viewA = flowAdapter.a(constraintLayout.getContext(), it.next());
                if (viewA != null) {
                    if (viewA.getId() == -1) {
                        viewA.setId(View.generateViewId());
                    }
                    constraintLayout.addView(viewA);
                    flow.addView(viewA);
                }
            }
        }
    }

    @BindingAdapter(requireAll = false, value = {"invisible"})
    public static void i(View view, boolean invisible) {
        view.setVisibility(invisible ? 0 : 4);
    }

    @BindingAdapter({"startAnim"})
    public static void i0(LottieAnimationView view, boolean isStart) {
        if (view == null || !isStart) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            view.playAnimation();
        }
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(^[0-9]*$)").matcher(str).find();
    }

    @BindingAdapter(requireAll = false, value = {"textSpan"})
    public static void j0(TextView view, SpannableStringBuilder textSpan) {
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setHighlightColor(view.getResources().getColor(R.color.transparent));
        view.setText(textSpan);
    }

    @BindingAdapter(requireAll = false, value = {"showKeyBoard"})
    public static void k(final EditText view, boolean b2) {
        if (b2) {
            view.postDelayed(new Runnable() { // from class: com.zj.adlib.bq1
                @Override // java.lang.Runnable
                public final void run() {
                    CommonBindingAdapter.l(view);
                }
            }, 100L);
        }
    }

    @BindingAdapter(requireAll = false, value = {"area"})
    public static void k0(View view, boolean b2) {
        if (!b2 || view == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= 300;
        rect.bottom += 300;
        rect.left -= 300;
        rect.right += 3000;
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
    }

    public static /* synthetic */ void l(EditText editText) {
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
        editText.setSelection(editText.getText().length());
    }

    @BindingAdapter(requireAll = false, value = {"visible"})
    public static void l0(View view, boolean visible) {
        view.setVisibility(visible ? 0 : 8);
    }

    public static /* synthetic */ CharSequence m(int i, CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        String str = spanned.toString().substring(0, i4) + ((Object) charSequence.subSequence(i2, i3)) + ((Object) spanned.subSequence(i5, spanned.length()));
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf < 0 || (iLastIndexOf + i) + 1 >= str.length()) ? charSequence : "";
    }

    public static /* synthetic */ void n(ImageView imageView, Object obj, RequestOptions requestOptions) {
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        Uri.Builder builderBuildUpon = Uri.parse((String) obj).buildUpon();
        builderBuildUpon.appendQueryParameter(RequestParameters.X_OSS_PROCESS, ys8.c("image/resize,m_fill,w_%d,h_%d", Integer.valueOf(SizeUtils.b(width)), Integer.valueOf(SizeUtils.b(height))));
        o(imageView, requestOptions, builderBuildUpon.build().toString());
    }

    public static void o(ImageView view, RequestOptions requestOptions, Object url) {
        RequestManager requestManagerWith = Glide.with(view);
        if (url == null) {
            url = "";
        }
        RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load(url);
        if (requestOptions != null) {
            requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptions);
        }
        requestBuilderLoad.into(view);
    }

    @BindingAdapter({"android:text", "maxSize"})
    public static void p(TextView view, CharSequence text, int maxSize) {
        if (maxSize > 0 && text != null && text.length() > maxSize) {
            text = text.toString().substring(0, maxSize) + v39.CHARACTER_ELLIPSIZE;
        }
        view.setText(text);
    }

    @BindingAdapter(requireAll = false, value = {"android:onClick", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME})
    public static void q(View view, View.OnClickListener clickListener, Long waitTime) {
        if (view == null || clickListener == null) {
            return;
        }
        new c67(view, clickListener, waitTime);
    }

    @BindingAdapter({"csv_searchHint"})
    public static void r(CommonSearchView searchView, String searchHint) {
        if (searchView == null || TextUtils.isEmpty(searchHint)) {
            return;
        }
        searchView.getEtSearch().setHint(searchHint);
    }

    @BindingAdapter(requireAll = false, value = {"scrollBy"})
    public static void s(RecyclerView recyclerView, int x, int y) {
        recyclerView.scrollBy(x, y);
    }

    @BindingAdapter({"adapter"})
    public static void t(ViewPager2 viewPager2, RecyclerView.Adapter adapter) {
        viewPager2.setAdapter(adapter);
    }

    @BindingAdapter({"backgroundAlpha"})
    public static void u(View view, int alpha) {
        view.getBackground().mutate().setAlpha(alpha);
    }

    @BindingAdapter({"animListener"})
    public static void v(LottieAnimationView view, Animator.AnimatorListener listener) {
        if (view != null) {
            view.addAnimatorListener(listener);
        }
    }

    @BindingAdapter({"backgroundColor"})
    public static void w(View view, @ColorInt Integer color) {
        view.setBackgroundColor(color.intValue());
    }

    @BindingAdapter({"backgroundResource"})
    public static void x(View view, int resId) {
        if (resId == 0 || view == null) {
            return;
        }
        view.setBackgroundResource(resId);
    }

    @BindingAdapter({"background"})
    public static void y(View view, Drawable background) {
        if (background == null || view == null) {
            return;
        }
        view.setBackground(background);
    }

    @BindingAdapter({"isBold"})
    public static void z(TextView view, boolean isBold) {
        if (isBold) {
            view.setTypeface(null, 1);
        } else {
            view.setTypeface(null, 0);
        }
    }
}
