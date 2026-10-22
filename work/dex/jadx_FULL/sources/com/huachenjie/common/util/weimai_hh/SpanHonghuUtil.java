package com.huachenjie.common.util.weimai_hh;

import android.content.Context;
import android.graphics.MaskFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zj.adlib.kj7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class SpanHonghuUtil {

    public static class SpanBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpannableStringBuilder f33933a = new SpannableStringBuilder("");

        public interface DecorCallback {
            void a(int start, int end);
        }

        public class a implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f33934a;

            public a(final int val$style) {
                this.f33934a = val$style;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.k0(this.f33934a, start, end);
            }
        }

        public class b implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f8934a;

            public b(final String val$family) {
                this.f8934a = val$family;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.o0(this.f8934a, start, end);
            }
        }

        public class c implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MaskFilter f33936a;

            public c(final MaskFilter val$maskFilter) {
                this.f33936a = val$maskFilter;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.X(this.f33936a, start, end);
            }
        }

        public class d implements DecorCallback {
            public d() {
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.u(start, end);
            }
        }

        public class e implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f33938a;

            public e(final int val$color) {
                this.f33938a = val$color;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.T(this.f33938a, start, end);
            }
        }

        public class f implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f33939a;

            public f(final int val$color) {
                this.f33939a = val$color;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.P(this.f33939a, start, end);
            }
        }

        public class g implements DecorCallback {
            public g() {
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.E(start, end);
            }
        }

        public class h implements DecorCallback {
            public h() {
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.I(start, end);
            }
        }

        public class i implements DecorCallback {
            public i() {
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.s0(start, end);
            }
        }

        public class j implements DecorCallback {
            public j() {
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.g0(start, end);
            }
        }

        public class k implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f33944a;

            public k(final int val$size) {
                this.f33944a = val$size;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.z(this.f33944a, start, end);
            }
        }

        public class l implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f33945a;

            public l(final float val$proportion) {
                this.f33945a = val$proportion;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.b0(this.f33945a, start, end);
            }
        }

        public class m implements DecorCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f8940a;

            public m(final String val$url) {
                this.f8940a = val$url;
            }

            @Override // com.huachenjie.common.util.weimai_hh.SpanHonghuUtil.SpanBuilder.DecorCallback
            public void a(int start, int end) {
                SpanBuilder.this.N(this.f8940a, start, end);
            }
        }

        public SpanBuilder A(String section, int size) {
            return B(section, size, Which.LAST);
        }

        public SpanBuilder B(String section, final int size, @NonNull Which which) {
            return t(section, false, which, new k(size));
        }

        public SpanBuilder C(Layout.Alignment alignment, int start, int end) {
            this.f33933a.setSpan(new AlignmentSpan.Standard(alignment), start, end, 33);
            return this;
        }

        public SpanBuilder D() {
            return E(0, this.f33933a.length());
        }

        public SpanBuilder E(int start, int end) {
            this.f33933a.setSpan(new SubscriptSpan(), start, end, 33);
            return this;
        }

        public SpanBuilder F(String section) {
            return G(section, Which.LAST);
        }

        public SpanBuilder G(@NonNull String section, @NonNull Which which) {
            return t(section, false, which, new g());
        }

        public SpanBuilder H() {
            return I(0, this.f33933a.length());
        }

        public SpanBuilder I(int start, int end) {
            this.f33933a.setSpan(new SuperscriptSpan(), start, end, 33);
            return this;
        }

        public SpanBuilder J(String section) {
            return K(section, Which.LAST);
        }

        public SpanBuilder K(String section, @NonNull Which which) {
            return t(section, false, which, new h());
        }

        public SpanBuilder L(String section, final String url, @NonNull Which which) {
            return t(section, false, which, new m(url));
        }

        public SpanBuilder M(String url) {
            return N(url, 0, this.f33933a.length());
        }

        public SpanBuilder N(String url, int start, int end) {
            this.f33933a.setSpan(new URLSpan(url), start, end, 33);
            return this;
        }

        public SpanBuilder O(int color) {
            return P(color, 0, this.f33933a.length());
        }

        public SpanBuilder P(int color, int start, int end) {
            this.f33933a.setSpan(new BackgroundColorSpan(color), start, end, 33);
            return this;
        }

        public SpanBuilder Q(String section, int color) {
            return R(section, color, true, Which.LAST);
        }

        public SpanBuilder R(String section, final int color, boolean ignoreCase, @NonNull Which which) {
            return t(section, ignoreCase, which, new f(color));
        }

        public SpanBuilder S(int color) {
            return T(color, 0, this.f33933a.length());
        }

        public SpanBuilder T(int color, int start, int end) {
            this.f33933a.setSpan(new ForegroundColorSpan(color), start, end, 17);
            return this;
        }

        public SpanBuilder U(String section, int color) {
            return V(section, color, true, Which.LAST);
        }

        public SpanBuilder V(final String section, final int color, boolean ignoreCase, @NonNull Which which) {
            return t(section, ignoreCase, which, new e(color));
        }

        public SpanBuilder W(MaskFilter maskFilter) {
            return X(maskFilter, 0, this.f33933a.length());
        }

        public SpanBuilder X(MaskFilter maskFilter, int start, int end) {
            this.f33933a.setSpan(new MaskFilterSpan(maskFilter), start, end, 33);
            return this;
        }

        public SpanBuilder Y(String section, MaskFilter maskFilter) {
            return Z(section, maskFilter, Which.LAST);
        }

        public SpanBuilder Z(String section, final MaskFilter maskFilter, @NonNull Which which) {
            return t(section, false, which, new c(maskFilter));
        }

        public SpanBuilder a(String section, int size) {
            return c(section, new AbsoluteSizeSpan(size, true), 33);
        }

        public SpanBuilder a0(float proportion) {
            return b0(proportion, 0, this.f33933a.length());
        }

        public SpanBuilder b(String section, int color) {
            return c(section, new BackgroundColorSpan(color), 33);
        }

        public SpanBuilder b0(float proportion, int start, int end) {
            this.f33933a.setSpan(new RelativeSizeSpan(proportion), start, end, 33);
            return this;
        }

        public SpanBuilder c(String section, Object span, int flag) {
            int length = this.f33933a.length();
            this.f33933a.append((CharSequence) section);
            this.f33933a.setSpan(span, length, this.f33933a.length(), flag);
            return this;
        }

        public SpanBuilder c0(String section, float proportion) {
            return d0(section, proportion, Which.LAST);
        }

        public SpanBuilder d(String section, int color) {
            return c(section, new ForegroundColorSpan(color), 33);
        }

        public SpanBuilder d0(String section, final float proportion, @NonNull Which which) {
            return t(section, false, which, new l(proportion));
        }

        public SpanBuilder e(Context context, int resId) {
            s(context, resId, this.f33933a.length());
            return this;
        }

        public SpanBuilder e0(kj7 roundBackgroundColorSpan, int start, int end) {
            this.f33933a.setSpan(roundBackgroundColorSpan, start, end, 33);
            return this;
        }

        public SpanBuilder f(String section, MaskFilter maskFilter) {
            return c(section, new MaskFilterSpan(maskFilter), 33);
        }

        public SpanBuilder f0() {
            return g0(0, this.f33933a.length());
        }

        public SpanBuilder g(String section, float proportion) {
            return c(section, new RelativeSizeSpan(proportion), 33);
        }

        public SpanBuilder g0(int start, int end) {
            this.f33933a.setSpan(new StrikethroughSpan(), start, end, 33);
            return this;
        }

        public SpanBuilder h(CharSequence section) {
            this.f33933a.append(section);
            return this;
        }

        public SpanBuilder h0(String section) {
            return i0(section, Which.LAST);
        }

        public SpanBuilder i(String section) {
            return c(section, new StrikethroughSpan(), 33);
        }

        public SpanBuilder i0(String section, @NonNull Which which) {
            return t(section, false, which, new j());
        }

        public SpanBuilder j(String section, int style) {
            return c(section, new StyleSpan(style), 33);
        }

        public SpanBuilder j0(int style) {
            return k0(style, 0, this.f33933a.length());
        }

        public SpanBuilder k(String section) {
            return c(section, new SubscriptSpan(), 33);
        }

        public SpanBuilder k0(int style, int start, int end) {
            this.f33933a.setSpan(new StyleSpan(style), start, end, 33);
            return this;
        }

        public SpanBuilder l(String section) {
            return c(section, new SuperscriptSpan(), 33);
        }

        public SpanBuilder l0(String section, int style) {
            return m0(section, style, Which.LAST);
        }

        public SpanBuilder m(String section, String family) {
            return c(section, new TypefaceSpan(family), 33);
        }

        public SpanBuilder m0(String section, final int style, @NonNull Which which) {
            return t(section, false, which, new a(style));
        }

        public SpanBuilder n(String section, String url) {
            return c(section, new URLSpan(url), 33);
        }

        public SpanBuilder n0(String family) {
            return o0(family, 0, this.f33933a.length());
        }

        public SpanBuilder o(String section) {
            return c(section, new UnderlineSpan(), 33);
        }

        public SpanBuilder o0(String family, int start, int end) {
            this.f33933a.setSpan(new TypefaceSpan(family), start, end, 33);
            return this;
        }

        public SpanBuilder p() {
            this.f33933a.clearSpans();
            return this;
        }

        public SpanBuilder p0(String section, String family) {
            return q0(section, family, Which.LAST);
        }

        public SpannableStringBuilder q() {
            return this.f33933a;
        }

        public SpanBuilder q0(String section, final String family, @NonNull Which which) {
            return t(section, false, which, new b(family));
        }

        public String r() {
            return this.f33933a.toString();
        }

        public SpanBuilder r0() {
            return s0(0, this.f33933a.length());
        }

        public SpanBuilder s(Context context, int resId, int where) {
            this.f33933a.insert(where, (CharSequence) " ");
            this.f33933a.setSpan(new ImageSpan(context, resId), where, where + 1, 33);
            return this;
        }

        public SpanBuilder s0(int start, int end) {
            this.f33933a.setSpan(new UnderlineSpan(), start, end, 33);
            return this;
        }

        public final SpanBuilder t(String section, boolean ignoreCase, @NonNull Which which, DecorCallback decorCallback) {
            String strR = r();
            if (ignoreCase) {
                section = section.toUpperCase();
                strR = strR.toUpperCase();
            }
            int i2 = a.f33947a[which.ordinal()];
            if (i2 == 1) {
                int iIndexOf = strR.indexOf(section);
                if (iIndexOf != -1) {
                    decorCallback.a(iIndexOf, section.length() + iIndexOf);
                }
            } else if (i2 == 2) {
                int iLastIndexOf = strR.lastIndexOf(section);
                if (iLastIndexOf != -1) {
                    decorCallback.a(iLastIndexOf, section.length() + iLastIndexOf);
                }
            } else if (i2 == 3) {
                int length = 0;
                while (true) {
                    int iIndexOf2 = strR.indexOf(section, length);
                    if (iIndexOf2 == -1) {
                        break;
                    }
                    decorCallback.a(iIndexOf2, section.length() + iIndexOf2);
                    length = iIndexOf2 + section.length();
                }
            }
            return this;
        }

        public SpanBuilder t0(String section) {
            return u0(section, Which.LAST);
        }

        public SpanBuilder u(int start, int end) {
            for (Object obj : this.f33933a.getSpans(start, end, Object.class)) {
                this.f33933a.removeSpan(obj);
            }
            return this;
        }

        public SpanBuilder u0(String section, @NonNull Which which) {
            return t(section, false, which, new i());
        }

        public SpanBuilder v(@NonNull String section) {
            return x(section, Which.LAST);
        }

        public void v0(TextView textView) {
            textView.setText(this.f33933a);
            this.f33933a.clearSpans();
            this.f33933a.clear();
            this.f33933a = null;
        }

        public SpanBuilder w(@NonNull String section, int fromIndex) {
            int iIndexOf = r().indexOf(section, fromIndex);
            u(iIndexOf, section.length() + iIndexOf);
            return this;
        }

        public SpanBuilder x(@NonNull String section, @NonNull Which which) {
            return t(section, false, which, new d());
        }

        public SpanBuilder y(int size) {
            return z(size, 0, this.f33933a.length());
        }

        public SpanBuilder z(int size, int start, int end) {
            this.f33933a.setSpan(new AbsoluteSizeSpan(size, true), start, end, 33);
            return this;
        }
    }

    public enum Which {
        FIRST,
        LAST,
        ALL
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33947a;

        static {
            int[] iArr = new int[Which.values().length];
            f33947a = iArr;
            try {
                iArr[Which.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33947a[Which.LAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33947a[Which.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static SpanBuilder a() {
        return new SpanBuilder();
    }
}
