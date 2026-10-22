package com.huachenjie.run.page.activities_run.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.jj8;
import com.zj.adlib.sq9;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 #2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u001b\u0010\u001c\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "applyNonCancelable", "", "Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b$b;", "paragraphs", "bindParagraphs", "constrainBodyHeight", "", "text", "phrases", "", "highlightColor", "", "highlight", "getWidth", "getHeight", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "initView", "onStart", "runScene$delegate", "Lkotlin/Lazy;", "getRunScene", "()I", ReadySceneTipDialog.KEY_RUN_SCENE, "minKmText$delegate", "getMinKmText", "()Ljava/lang/String;", "minKmText", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReadySceneTipDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadySceneTipDialog.kt\ncom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,305:1\n1864#2,3:306\n1855#2,2:309\n1#3:311\n*S KotlinDebug\n*F\n+ 1 ReadySceneTipDialog.kt\ncom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog\n*L\n130#1:306,3\n164#1:309,2\n*E\n"})
public final class ReadySceneTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_MIN_KM = "minKm";

    @NotNull
    private static final String KEY_RUN_SCENE = "runScene";

    @NotNull
    public static final String PREF_KEY_PREFIX = "key_ready_scene_tip_skip_";

    @NotNull
    private static final String PREF_SKIP_VALUE = "1";

    @NotNull
    private static final String TAG = "ReadySceneTipDialog";

    /* JADX INFO: renamed from: runScene$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy runScene = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$runScene$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m644invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("runScene", 0) : 0);
        }
    });

    /* JADX INFO: renamed from: minKmText$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy minKmText = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$minKmText$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("minKm") : null;
            if (string == null) {
                string = "";
            }
            return string.length() == 0 ? "0.0" : string;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fm", "", ReadySceneTipDialog.KEY_RUN_SCENE, "", "minKmText", "", "e", "", "d", "b", "c", "KEY_MIN_KM", "Ljava/lang/String;", "KEY_RUN_SCENE", "PREF_KEY_PREFIX", "PREF_SKIP_VALUE", "TAG", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void f(Companion companion, FragmentManager fragmentManager, int i, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = "0.0";
            }
            companion.e(fragmentManager, i, str);
        }

        public final void b(int runScene) {
            ai9.t(c(runScene), "1");
        }

        public final String c(int runScene) {
            String userId = ai9.e().getUserId();
            if (userId == null) {
                userId = "";
            }
            return ReadySceneTipDialog.PREF_KEY_PREFIX + userId + '_' + runScene;
        }

        public final boolean d(int runScene) {
            return Intrinsics.areEqual(ai9.f(c(runScene)), "1");
        }

        public final void e(@NotNull FragmentManager fm, int runScene, @NotNull String minKmText) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(minKmText, "minKmText");
            if (fm.findFragmentByTag(ReadySceneTipDialog.TAG) != null || d(runScene)) {
                return;
            }
            ReadySceneTipDialog readySceneTipDialog = new ReadySceneTipDialog();
            readySceneTipDialog.setArguments(BundleKt.bundleOf(TuplesKt.to(ReadySceneTipDialog.KEY_RUN_SCENE, Integer.valueOf(runScene)), TuplesKt.to(ReadySceneTipDialog.KEY_MIN_KM, minKmText)));
            readySceneTipDialog.show(fm, ReadySceneTipDialog.TAG);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$b, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0006B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b;", "", "", "a", "", "Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b$b;", "b", "title", "paragraphs", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class SceneTipContent {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        @NotNull
        public final String title;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        @NotNull
        public final List<Paragraph> paragraphs;

        /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$b$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b$a;", "", "", ReadySceneTipDialog.KEY_RUN_SCENE, "Landroid/content/res/Resources;", "res", "", "minKmText", "Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SceneTipContent a(int runScene, @NotNull Resources res, @NotNull String minKmText) {
                Intrinsics.checkNotNullParameter(res, "res");
                Intrinsics.checkNotNullParameter(minKmText, "minKmText");
                String string = res.getString(R.string.run_ready_scene_tip_title_score);
                Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.r…dy_scene_tip_title_score)");
                String string2 = res.getString(R.string.run_ready_scene_tip_title_before);
                Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.r…y_scene_tip_title_before)");
                String string3 = res.getString(R.string.run_ready_scene_tip_p1);
                Intrinsics.checkNotNullExpressionValue(string3, "res.getString(R.string.run_ready_scene_tip_p1)");
                Paragraph paragraph = new Paragraph(string3, CollectionsKt.listOf(res.getString(R.string.run_ready_scene_tip_hl_phone_setup)));
                if (runScene == 0) {
                    String str = minKmText + "km";
                    String string4 = res.getString(R.string.run_ready_scene_tip_p1_normal, minKmText);
                    Intrinsics.checkNotNullExpressionValue(string4, "res.getString(\n         …                        )");
                    int i = R.string.run_ready_scene_tip_hl_min_run;
                    Object[] objArr = {minKmText};
                    String string5 = res.getString(R.string.run_ready_scene_tip_p2_normal, minKmText);
                    Intrinsics.checkNotNullExpressionValue(string5, "res.getString(\n         …                        )");
                    return new SceneTipContent(string2, CollectionsKt.listOf(new Paragraph[]{new Paragraph(string4, CollectionsKt.listOf(res.getString(i, objArr))), new Paragraph(string5, CollectionsKt.listOf(new String[]{res.getString(R.string.run_ready_scene_tip_hl_more_distance), str}))}));
                }
                if (runScene == 10) {
                    String string6 = res.getString(R.string.run_ready_scene_tip_p2_vision);
                    Intrinsics.checkNotNullExpressionValue(string6, "res.getString(R.string.r…eady_scene_tip_p2_vision)");
                    return new SceneTipContent(string2, CollectionsKt.listOf(new Paragraph[]{paragraph, new Paragraph(string6, CollectionsKt.listOf(res.getString(R.string.run_ready_scene_tip_hl_vision_face)))}));
                }
                if (runScene == 20) {
                    String string7 = res.getString(R.string.run_ready_scene_tip_p2_face);
                    Intrinsics.checkNotNullExpressionValue(string7, "res.getString(R.string.r…_ready_scene_tip_p2_face)");
                    return new SceneTipContent(string, CollectionsKt.listOf(new Paragraph[]{paragraph, new Paragraph(string7, CollectionsKt.listOf(res.getString(R.string.run_ready_scene_tip_hl_face_self)))}));
                }
                if (runScene == 30) {
                    String string8 = res.getString(R.string.run_ready_scene_tip_p2_clock);
                    Intrinsics.checkNotNullExpressionValue(string8, "res.getString(R.string.r…ready_scene_tip_p2_clock)");
                    return new SceneTipContent(string2, CollectionsKt.listOf(new Paragraph[]{paragraph, new Paragraph(string8, CollectionsKt.listOf(new String[]{res.getString(R.string.run_ready_scene_tip_hl_clock_order), res.getString(R.string.run_ready_scene_tip_hl_clock_face)}))}));
                }
                String string9 = res.getString(R.string.run_ready_scene_tip_p1_normal, minKmText);
                Intrinsics.checkNotNullExpressionValue(string9, "res.getString(R.string.r…tip_p1_normal, minKmText)");
                String string10 = res.getString(R.string.run_ready_scene_tip_p2_normal, minKmText);
                Intrinsics.checkNotNullExpressionValue(string10, "res.getString(R.string.r…tip_p2_normal, minKmText)");
                return new SceneTipContent(string2, CollectionsKt.listOf(new Paragraph[]{new Paragraph(string9, CollectionsKt.listOf(res.getString(R.string.run_ready_scene_tip_hl_min_run, minKmText))), new Paragraph(string10, CollectionsKt.listOf(new String[]{res.getString(R.string.run_ready_scene_tip_hl_more_distance), minKmText + "km"}))}));
            }
        }

        /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog$b$b, reason: collision with other inner class name and from toString */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003J#\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ReadySceneTipDialog$b$b;", "", "", "a", "", "b", "text", "highlights", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "run_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Paragraph {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            public final String text;

            /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
            @NotNull
            public final List<String> highlights;

            public Paragraph(@NotNull String str, @NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(str, "text");
                Intrinsics.checkNotNullParameter(list, "highlights");
                this.text = str;
                this.highlights = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Paragraph d(Paragraph paragraph, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = paragraph.text;
                }
                if ((i & 2) != 0) {
                    list = paragraph.highlights;
                }
                return paragraph.c(str, list);
            }

            @NotNull
            /* JADX INFO: renamed from: a, reason: from getter */
            public final String getText() {
                return this.text;
            }

            @NotNull
            public final List<String> b() {
                return this.highlights;
            }

            @NotNull
            public final Paragraph c(@NotNull String text, @NotNull List<String> highlights) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(highlights, "highlights");
                return new Paragraph(text, highlights);
            }

            @NotNull
            public final List<String> e() {
                return this.highlights;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Paragraph)) {
                    return false;
                }
                Paragraph paragraph = (Paragraph) other;
                return Intrinsics.areEqual(this.text, paragraph.text) && Intrinsics.areEqual(this.highlights, paragraph.highlights);
            }

            @NotNull
            public final String f() {
                return this.text;
            }

            public int hashCode() {
                return (this.text.hashCode() * 31) + this.highlights.hashCode();
            }

            @NotNull
            public String toString() {
                return "Paragraph(text=" + this.text + ", highlights=" + this.highlights + ')';
            }
        }

        public SceneTipContent(@NotNull String str, @NotNull List<Paragraph> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "paragraphs");
            this.title = str;
            this.paragraphs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SceneTipContent d(SceneTipContent sceneTipContent, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sceneTipContent.title;
            }
            if ((i & 2) != 0) {
                list = sceneTipContent.paragraphs;
            }
            return sceneTipContent.c(str, list);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final List<Paragraph> b() {
            return this.paragraphs;
        }

        @NotNull
        public final SceneTipContent c(@NotNull String title, @NotNull List<Paragraph> paragraphs) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(paragraphs, "paragraphs");
            return new SceneTipContent(title, paragraphs);
        }

        @NotNull
        public final List<Paragraph> e() {
            return this.paragraphs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SceneTipContent)) {
                return false;
            }
            SceneTipContent sceneTipContent = (SceneTipContent) other;
            return Intrinsics.areEqual(this.title, sceneTipContent.title) && Intrinsics.areEqual(this.paragraphs, sceneTipContent.paragraphs);
        }

        @NotNull
        public final String f() {
            return this.title;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.paragraphs.hashCode();
        }

        @NotNull
        public String toString() {
            return "SceneTipContent(title=" + this.title + ", paragraphs=" + this.paragraphs + ')';
        }
    }

    private final void applyNonCancelable() {
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    private final void bindParagraphs(List<SceneTipContent.Paragraph> paragraphs) {
        View view = getView();
        LinearLayout linearLayout = view != null ? (LinearLayout) view.findViewById(R.id.llBody) : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        int color = ContextCompat.getColor(requireContext(), R.color.color_191F20);
        int color2 = ContextCompat.getColor(requireContext(), R.color.run_color_ff9118);
        int iA = jj8.a(8.0f);
        int i = 0;
        for (Object obj : paragraphs) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SceneTipContent.Paragraph paragraph = (SceneTipContent.Paragraph) obj;
            TextView textView = new TextView(requireContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = iA;
            }
            textView.setLayoutParams(layoutParams);
            textView.setText(highlight(paragraph.f(), paragraph.e(), color2));
            textView.setTextColor(color);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            i = i2;
        }
    }

    private final void constrainBodyHeight() {
        View view = getView();
        final View viewFindViewById = view != null ? view.findViewById(R.id.svBody) : null;
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.post(new Runnable() { // from class: com.zj.adlib.mb7
            @Override // java.lang.Runnable
            public final void run() {
                ReadySceneTipDialog.constrainBodyHeight$lambda$6(this.f18167a, viewFindViewById);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void constrainBodyHeight$lambda$6(ReadySceneTipDialog readySceneTipDialog, View view) {
        Intrinsics.checkNotNullParameter(readySceneTipDialog, "this$0");
        Intrinsics.checkNotNullParameter(view, "$sv");
        int iA = readySceneTipDialog.getResources().getDisplayMetrics().heightPixels - jj8.a(220.0f);
        if (iA <= 0 || view.getHeight() <= iA) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = iA;
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    private final String getMinKmText() {
        return (String) this.minKmText.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRunScene() {
        return ((Number) this.runScene.getValue()).intValue();
    }

    private final CharSequence highlight(String text, List<String> phrases, int highlightColor) {
        SpannableString spannableString = new SpannableString(text);
        for (String str : phrases) {
            if (!(str.length() == 0)) {
                int iIndexOf$default = StringsKt.indexOf$default(text, str, 0, false, 6, (Object) null);
                while (iIndexOf$default >= 0) {
                    int length = iIndexOf$default + str.length();
                    spannableString.setSpan(new ForegroundColorSpan(highlightColor), iIndexOf$default, length, 33);
                    spannableString.setSpan(new StyleSpan(1), iIndexOf$default, length, 33);
                    iIndexOf$default = StringsKt.indexOf$default(text, str, length, false, 4, (Object) null);
                }
            }
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CheckBox checkBox, View view) {
        if (checkBox != null) {
            checkBox.toggle();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_ready_scene_tip;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        TextView textView;
        LinearLayout linearLayout;
        applyNonCancelable();
        SceneTipContent.Companion companion = SceneTipContent.INSTANCE;
        int runScene = getRunScene();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        SceneTipContent sceneTipContentA = companion.a(runScene, resources, getMinKmText());
        View view = getView();
        TextView textView2 = view != null ? (TextView) view.findViewById(R.id.tvTitle) : null;
        if (textView2 != null) {
            textView2.setText(sceneTipContentA.f());
        }
        bindParagraphs(sceneTipContentA.e());
        constrainBodyHeight();
        View view2 = getView();
        final CheckBox checkBox = view2 != null ? (CheckBox) view2.findViewById(R.id.cbDontRemind) : null;
        View view3 = getView();
        if (view3 != null && (linearLayout = (LinearLayout) view3.findViewById(R.id.llDontRemind)) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nb7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    ReadySceneTipDialog.initView$lambda$0(checkBox, view4);
                }
            });
        }
        View view4 = getView();
        if (view4 == null || (textView = (TextView) view4.findViewById(R.id.tvKnow)) == null) {
            return;
        }
        sq9.f(textView, null, new Function1<View, Unit>() { // from class: com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog.initView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view5) {
                Intrinsics.checkNotNullParameter(view5, o.f);
                CheckBox checkBox2 = checkBox;
                boolean z = false;
                if (checkBox2 != null && checkBox2.isChecked()) {
                    z = true;
                }
                if (z) {
                    ReadySceneTipDialog.INSTANCE.b(this.getRunScene());
                }
                this.dismissAllowingStateLoss();
            }
        }, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyNonCancelable();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        applyNonCancelable();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.0f;
        window.setAttributes(window.getAttributes());
    }
}
