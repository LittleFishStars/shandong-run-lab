package com.zj.adlib;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.run.map.RouteOverlay;
import com.kuaishou.weapon.p0.t;
import huachenjie.sdk.http.BaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observer;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u001d¨\u0006!"}, d2 = {"Lcom/zj/adlib/av3;", "", "", "type", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", t.d, "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "m", "", "f", "e", y6b.g, "j", "Landroid/content/Context;", "context", y6b.f, "a", "I", "ON_SECTION_UP", "b", "ON_TREASURE_BOX_OPEN", "c", "ON_PAY_SUCCESS", "d", "ON_STAR_LUCKY_VALUE_MAX", "ON_RECEIVE_INTERSTELLAR_GIFT", "Ljava/lang/String;", "FRAGMENT_TAG", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class av3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int ON_SECTION_UP = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final av3 f15400a = new av3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String FRAGMENT_TAG = "GOOD_REVIEWS";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int ON_TREASURE_BOX_OPEN = 2;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final int ON_PAY_SUCCESS = 3;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final int ON_STAR_LUCKY_VALUE_MAX = 4;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final int ON_RECEIVE_INTERSTELLAR_GIFT = 5;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/av3$a", "Lrx/Observer;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/alibaba/fastjson/JSONObject;", "", "e", "", TriverEmbedVideoView.b, "onCompleted", "data", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Observer<BaseEntity<JSONObject>> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@Nullable BaseEntity<JSONObject> data) {
            JSONObject jSONObject;
            if (data == null || (jSONObject = (JSONObject) data.data) == null || !jSONObject.containsKey("result")) {
                return;
            }
            Integer integer = jSONObject.getInteger("result");
            Intrinsics.checkNotNullExpressionValue(integer, "getInteger(\"result\")");
            ai9.w(integer.intValue());
        }

        public void onCompleted() {
        }

        public void onError(@NotNull Throwable e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/av3$b", "Lrx/Observer;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/alibaba/fastjson/JSONObject;", "", "e", "", TriverEmbedVideoView.b, "onCompleted", "data", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements Observer<BaseEntity<JSONObject>> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@Nullable BaseEntity<JSONObject> data) {
        }

        public void onCompleted() {
        }

        public void onError(@NotNull Throwable e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    public static final void i(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        new gq1().m().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static final void k(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        new gq1().y().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static final void n(View.OnClickListener onClickListener, View view) {
        f15400a.j();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void o(View.OnClickListener onClickListener, View view) {
        av3 av3Var = f15400a;
        av3Var.j();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        av3Var.g(context);
    }

    @NotNull
    public final String e(int type) {
        return "请给我们大家的元宇宙，一个好评吧！";
    }

    @NotNull
    public final String f(int type) {
        if (type == 1) {
            return "恭喜您升到星痕银！";
        }
        if (type == 2) {
            return "您的好运爆表！";
        }
        if (type == 3) {
            return "尊贵的星球主人";
        }
        if (type != 4) {
            return type != 5 ? "" : "您的好运爆表！";
        }
        return "哇！星运值达到了100%";
    }

    public final void g(Context context) {
        String strSubstring = "market://details?id=com.huachenjie.shandong_school".substring(StringsKt.lastIndexOf$default("market://details?id=com.huachenjie.shandong_school", "=", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        if (StringsKt.indexOf$default("market://details?id=com.huachenjie.shandong_school", "market://", 0, false, 6, (Object) null) == 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.huachenjie.shandong_school"));
            intent.addFlags(268435456);
            try {
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=" + strSubstring)));
                }
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public final void h() {
        if (ai9.h() != -1) {
            return;
        }
        final a aVar = new a();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.xu3
            @Override // java.lang.Runnable
            public final void run() {
                av3.i(aVar);
            }
        });
    }

    public final void j() {
        ai9.w(0);
        final b bVar = new b();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.wu3
            @Override // java.lang.Runnable
            public final void run() {
                av3.k(bVar);
            }
        });
    }

    public final void l(int type, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        m(type, fragmentManager, null);
    }

    public final void m(int type, @NotNull FragmentManager fragmentManager, @Nullable final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (ai9.h() == 0) {
            if (listener != null) {
                listener.onClick(null);
            }
        } else {
            if (fragmentManager.findFragmentByTag(FRAGMENT_TAG) != null) {
                return;
            }
            AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
            alertDataBean.setTitle(f(type));
            alertDataBean.setContent("请给我们大家的元宇宙，一个好评吧！");
            alertDataBean.setContentColor(-16777216);
            alertDataBean.setCancel(OptionsPickerHelper.e);
            alertDataBean.setConfirm("去评分");
            alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
            AlertDialog alertDialogA = AlertDialog.INSTANCE.a(alertDataBean);
            alertDialogA.setCancelClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yu3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    av3.n(listener, view);
                }
            });
            alertDialogA.setConfirmClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zu3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    av3.o(listener, view);
                }
            });
            alertDialogA.show(fragmentManager, FRAGMENT_TAG);
        }
    }
}
