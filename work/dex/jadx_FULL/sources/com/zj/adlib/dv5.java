package com.zj.adlib;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/zj/adlib/dv5;", "", "<init>", "()V", "a", "b", "common_release"}, k = 1, mv = {1, 8, 0})
public final class dv5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/dv5$a;", "", "", TypedValues.Custom.S_STRING, "", "a", "", "textColor", "b", "", "relativeSize", "c", "Landroid/text/SpannableStringBuilder;", "d", "Landroid/text/SpannableStringBuilder;", "e", "()Landroid/text/SpannableStringBuilder;", "builder", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final SpannableStringBuilder builder = new SpannableStringBuilder();

        public final void a(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
            this.builder.append((CharSequence) new SpannableString(string));
        }

        public final void b(@NotNull String string, @ColorInt int textColor) {
            Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
            c(string, textColor, 0.0f);
        }

        public final void c(@NotNull String string, @ColorInt int textColor, float relativeSize) {
            Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
            SpannableString spannableString = new SpannableString(string);
            if (!(relativeSize == 0.0f)) {
                spannableString.setSpan(new RelativeSizeSpan(relativeSize), 0, StringsKt.getLastIndex(string), 18);
            }
            spannableString.setSpan(new ForegroundColorSpan(textColor), 0, StringsKt.getLastIndex(string), 18);
            this.builder.append((CharSequence) spannableString);
        }

        @NotNull
        /* JADX INFO: renamed from: d, reason: from getter */
        public final SpannableStringBuilder getBuilder() {
            return this.builder;
        }

        @NotNull
        public final SpannableStringBuilder e() {
            return this.builder;
        }
    }

    /* JADX INFO: renamed from: com.zj.adlib.dv5$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/zj/adlib/dv5$b;", "", "", "original", "", "target", "", "textColor", "Landroid/text/SpannableString;", "a", "(Ljava/lang/String;[Ljava/lang/String;I)Landroid/text/SpannableString;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SpannableString a(@NotNull String original, @NotNull String[] target, @ColorInt int textColor) {
            Intrinsics.checkNotNullParameter(original, "original");
            Intrinsics.checkNotNullParameter(target, "target");
            SpannableString spannableString = new SpannableString(original);
            for (String str : target) {
                if (StringsKt.contains$default(original, str, false, 2, (Object) null)) {
                    int iIndexOf$default = StringsKt.indexOf$default(original, str, 0, false, 6, (Object) null);
                    spannableString.setSpan(new ForegroundColorSpan(textColor), iIndexOf$default, str.length() + iIndexOf$default, 18);
                }
            }
            return spannableString;
        }
    }

    @JvmStatic
    @NotNull
    public static final SpannableString a(@NotNull String str, @NotNull String[] strArr, @ColorInt int i) {
        return INSTANCE.a(str, strArr, i);
    }
}
