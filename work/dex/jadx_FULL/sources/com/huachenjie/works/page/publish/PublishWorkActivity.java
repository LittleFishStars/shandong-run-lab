package com.huachenjie.works.page.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.huachenjie.works.database.PublicWorkDraft;
import com.huachenjie.works.databinding.WorksActivityPulishWorkBinding;
import com.huachenjie.works.external.utils.WorksUtils;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.huachenjie.works.page.publish.delegate.PublishWorkCategoryDelegate;
import com.huachenjie.works.page.publish.delegate.PublishWorksDelegate;
import com.huachenjie.works.page.publish.menu.channel.PubWorkMenuChannelFragment;
import com.huachenjie.works.page.publish.menu.location.PubWorkMenuLocationFragment;
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment;
import com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment;
import com.huachenjie.works.page.user.InputSelectUserFragment;
import com.huachenjie.works.utils.a;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.vanniktech.emoji.EmojiEditText;
import com.zj.adlib.fe9;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.qk0;
import com.zj.adlib.ti7;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.WORKS_PUBLISH)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002>0B\u0007¢\u0006\u0004\b<\u0010=J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J \u0010$\u001a\u00020\t2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0002R\u001b\u0010)\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u00060/R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/huachenjie/works/page/publish/PublishWorkActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityPulishWorkBinding;", "Lcom/huachenjie/works/page/publish/PublishWorkViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "j0", "l0", "k0", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", bo.g, "s0", "o0", "n0", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "r0", "b", "Lkotlin/Lazy;", "getType", "()I", "type", "Lcom/huachenjie/works/database/PublicWorkDraft;", "c", "m0", "()Lcom/huachenjie/works/database/PublicWorkDraft;", "workDraft", "Lcom/huachenjie/works/page/publish/PublishWorkActivity$ClickProxy;", "a", "Lcom/huachenjie/works/page/publish/PublishWorkActivity$ClickProxy;", "clickProxy", "Lcom/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate;", "d", "h0", "()Lcom/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate;", "categoryDelegate", "e", "i0", "()Ljava/lang/String;", "compressPath", "<init>", "()V", "ClickProxy", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishWorkActivity extends BaseMVVMActivity<WorksActivityPulishWorkBinding, PublishWorkViewModel> {
    public static final int K = 1001;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "work_draft";

    @NotNull
    public static final String x = "#";

    @NotNull
    public static final String y = "@";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m945invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(yj7.g.WORKS_PUBLISH_TYPE, 1));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy workDraft = LazyKt.lazy(new Function0<PublicWorkDraft>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$workDraft$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PublicWorkDraft m946invoke() {
            PublicWorkDraft publicWorkDraft = (PublicWorkDraft) this.this$0.getIntent().getParcelableExtra(PublishWorkActivity.t);
            if (publicWorkDraft != null) {
                return publicWorkDraft;
            }
            PublicWorkDraft publicWorkDraft2 = new PublicWorkDraft(0L, 0L, 0, null, null, null, null, null, null, null, 0, false, null, null, 16383, null);
            publicWorkDraft2.setAttachmentType(this.this$0.getType());
            publicWorkDraft2.setMediaPath(WorksUtils.f37135a.a() + File.separator + System.currentTimeMillis());
            publicWorkDraft2.setNewWork(true);
            return publicWorkDraft2;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ClickProxy clickProxy = new ClickProxy();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy categoryDelegate = LazyKt.lazy(new Function0<PublishWorkCategoryDelegate>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$categoryDelegate$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PublishWorkCategoryDelegate m942invoke() {
            PublishWorkActivity publishWorkActivity = this.this$0;
            return new PublishWorkCategoryDelegate(publishWorkActivity, PublishWorkActivity.e0(publishWorkActivity), PublishWorkActivity.d0(this.this$0));
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy compressPath = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$compressPath$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            return this.this$0.m0().getMediaPath();
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/works/page/publish/PublishWorkActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "f", y6b.f, "", "isFromInputSymbol", "k", y6b.g, "m", "d", "b", "c", "j", "i", "<init>", "(Lcom/huachenjie/works/page/publish/PublishWorkActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPublishWorkActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorkActivity.kt\ncom/huachenjie/works/page/publish/PublishWorkActivity$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,428:1\n1549#2:429\n1620#2,3:430\n1549#2:433\n1620#2,3:434\n*S KotlinDebug\n*F\n+ 1 PublishWorkActivity.kt\ncom/huachenjie/works/page/publish/PublishWorkActivity$ClickProxy\n*L\n267#1:429\n267#1:430,3\n304#1:433\n304#1:434,3\n*E\n"})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public static final void e(final PublishWorkActivity publishWorkActivity, boolean z) {
            Intrinsics.checkNotNullParameter(publishWorkActivity, "this$0");
            if (!z) {
                fv5.b("无定位权限，获取获取周边位置信息失败");
                return;
            }
            PubWorkMenuLocationFragment pubWorkMenuLocationFragmentA = PubWorkMenuLocationFragment.INSTANCE.a(PublishWorkActivity.e0(publishWorkActivity).B().getValue());
            pubWorkMenuLocationFragmentA.setSelectCallback(new Function1<PubWorkLocationItemBean, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$ClickProxy$onSelectAddress$1$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PubWorkLocationItemBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable PubWorkLocationItemBean pubWorkLocationItemBean) {
                    PublishWorkActivity.e0(publishWorkActivity).B().setValue(pubWorkLocationItemBean);
                }
            });
            FragmentManager supportFragmentManager = publishWorkActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            pubWorkMenuLocationFragmentA.show(supportFragmentManager, PubWorkMenuLocationFragment.class.getSimpleName());
        }

        public static /* synthetic */ void l(ClickProxy clickProxy, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            clickProxy.k(z);
        }

        public static /* synthetic */ void n(ClickProxy clickProxy, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            clickProxy.m(z);
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Postcard postcardBuild = ARouter.getInstance().build(zj7.g.SELECT_GOODS);
            ArrayList<String> value = PublishWorkActivity.e0(PublishWorkActivity.this).w().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            postcardBuild.withStringArrayList(yj7.e.KEY_GOODS_NO_LIST, value).navigation(PublishWorkActivity.this, 1001);
        }

        public final void c(@Nullable View v) {
            PubWorkMenuPermissionFragment.Companion companion = PubWorkMenuPermissionFragment.INSTANCE;
            Integer value = PublishWorkActivity.e0(PublishWorkActivity.this).x().getValue();
            Intrinsics.checkNotNull(value);
            PubWorkMenuPermissionFragment pubWorkMenuPermissionFragmentB = PubWorkMenuPermissionFragment.Companion.b(companion, value.intValue(), null, false, 6, null);
            final PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            FragmentManager supportFragmentManager = publishWorkActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            pubWorkMenuPermissionFragmentB.show(supportFragmentManager, PubWorkMenuPermissionFragment.class.getSimpleName());
            pubWorkMenuPermissionFragmentB.setSelectCallback(new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$ClickProxy$onPermissionChange$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    PublishWorkActivity.e0(publishWorkActivity).x().setValue(Integer.valueOf(i));
                }
            });
        }

        public final void d(@Nullable View v) {
            final PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            vo6.j(publishWorkActivity, "android.permission.ACCESS_FINE_LOCATION", "为了根据您的位置获取周边位置信息，我们需要访问您的准确位置权限", new PermissionResultListener() { // from class: com.zj.adlib.b47
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    PublishWorkActivity.ClickProxy.e(publishWorkActivity, z);
                }
            });
        }

        public final void f(@Nullable View v) {
            PubWorkMenuChannelFragment pubWorkMenuChannelFragmentA = PubWorkMenuChannelFragment.INSTANCE.a(PublishWorkActivity.e0(PublishWorkActivity.this).A().getValue());
            final PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            pubWorkMenuChannelFragmentA.setSelectCallback(new Function1<PubWorkChannelBean, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$ClickProxy$onSelectChannel$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PubWorkChannelBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable PubWorkChannelBean pubWorkChannelBean) {
                    PublishWorkActivity.e0(publishWorkActivity).A().setValue(pubWorkChannelBean);
                }
            });
            FragmentManager supportFragmentManager = publishWorkActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            pubWorkMenuChannelFragmentA.show(supportFragmentManager, PubWorkMenuChannelFragment.class.getSimpleName());
        }

        public final void g(@Nullable View v) {
            l(this, false, 1, null);
        }

        public final void h(@Nullable View v) {
            n(this, false, 1, null);
        }

        public final void i(@Nullable View v) {
            if (PublishWorkActivity.e0(PublishWorkActivity.this).m(PublishWorkActivity.this.getType(), PublishWorkActivity.d0(PublishWorkActivity.this).f13915a.isSelectedMedia())) {
                List<RichSubjectBean> topicList = PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getTopicList();
                List<RichUserBean> userList = PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getUserList();
                PublishWorkViewModel publishWorkViewModelE0 = PublishWorkActivity.e0(PublishWorkActivity.this);
                PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
                int type = publishWorkActivity.getType();
                PublicWorkDraft publicWorkDraftM0 = PublishWorkActivity.this.m0();
                publicWorkDraftM0.setContent(PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getRichText());
                Unit unit = Unit.INSTANCE;
                publishWorkViewModelE0.F(publishWorkActivity, type, publicWorkDraftM0, topicList, userList);
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_SUB_INDEX, fe9.a.ATTENTION).navigation();
                PublishWorkActivity.this.finish();
            }
        }

        public final void j(@Nullable View v) {
            PublishWorkViewModel publishWorkViewModelE0 = PublishWorkActivity.e0(PublishWorkActivity.this);
            PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            int type = publishWorkActivity.getType();
            PublicWorkDraft publicWorkDraftM0 = PublishWorkActivity.this.m0();
            publicWorkDraftM0.setContent(PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getRichText());
            Unit unit = Unit.INSTANCE;
            PublishWorkViewModel.K(publishWorkViewModelE0, publishWorkActivity, type, publicWorkDraftM0, null, 8, null);
        }

        public final void k(final boolean isFromInputSymbol) {
            List<RichSubjectBean> topicList = PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getTopicList();
            ArrayList<String> arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(topicList, 10));
            Iterator<T> it = topicList.iterator();
            while (it.hasNext()) {
                arrayList.add(((RichSubjectBean) it.next()).getSubjectNo());
            }
            if (arrayList.size() >= 5) {
                fv5.b(PublishWorkActivity.this.getString(R.string.works_publish_work_menu_topic_max));
                return;
            }
            PubWorkMenuTopicFragment pubWorkMenuTopicFragment = new PubWorkMenuTopicFragment();
            final PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            pubWorkMenuTopicFragment.setSelectCallback(new Function1<PubWorkTopicBean, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$ClickProxy$showSelectTopic$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PubWorkTopicBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable PubWorkTopicBean pubWorkTopicBean) {
                    if (pubWorkTopicBean != null) {
                        PublishWorkActivity.d0(publishWorkActivity).f13914a.insertRichTextField('#' + pubWorkTopicBean.getTitle() + ' ', RichTextUtils.f32968a.k(pubWorkTopicBean.getSubjectNo()), isFromInputSymbol);
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(PubWorkMenuTopicFragment.SELECTED_TOPIC_KEY, arrayList);
            pubWorkMenuTopicFragment.setArguments(bundle);
            FragmentManager supportFragmentManager = publishWorkActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            pubWorkMenuTopicFragment.show(supportFragmentManager, PubWorkMenuTopicFragment.class.getSimpleName());
        }

        public final void m(final boolean isFromInputSymbol) {
            List<RichUserBean> userList = PublishWorkActivity.d0(PublishWorkActivity.this).f13914a.getUserList();
            ArrayList<String> arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(userList, 10));
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                arrayList.add(((RichUserBean) it.next()).getAppUserCode());
            }
            if (arrayList.size() >= 5) {
                fv5.b(PublishWorkActivity.this.getString(R.string.works_publish_work_menu_user_max));
                return;
            }
            InputSelectUserFragment inputSelectUserFragment = new InputSelectUserFragment();
            final PublishWorkActivity publishWorkActivity = PublishWorkActivity.this;
            inputSelectUserFragment.setSelectCallback(new Function1<UserInfoBean, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$ClickProxy$showSelectUser$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((UserInfoBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable UserInfoBean userInfoBean) {
                    if (userInfoBean != null) {
                        PublishWorkActivity.d0(publishWorkActivity).f13914a.insertRichTextField('@' + userInfoBean.getUserName() + ' ', RichTextUtils.f32968a.l(userInfoBean.getAppUserCode()), isFromInputSymbol);
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(InputSelectUserFragment.SELECTED_USER_KEY, arrayList);
            inputSelectUserFragment.setArguments(bundle);
            FragmentManager supportFragmentManager = publishWorkActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            inputSelectUserFragment.show(supportFragmentManager, InputSelectUserFragment.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.PublishWorkActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/page/publish/PublishWorkActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/works/database/PublicWorkDraft;", "workEntity", "", "a", "", "KEY_WORK_DRAFT", "Ljava/lang/String;", "", "REQUEST_SELECTED_GOOD_CODE", "I", "TOPIC_TYPE_START", "USER_TYPE_START", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull PublicWorkDraft workEntity) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workEntity, "workEntity");
            if (PublishWorksDelegate.f14925a.h()) {
                fv5.a(R.string.works_publish_work_publishing);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) PublishWorkActivity.class);
            intent.putExtra(yj7.g.WORKS_PUBLISH_TYPE, workEntity.getAttachmentType());
            workEntity.setPicListReplace(workEntity.getPicList());
            workEntity.setVideoMediaReplace(workEntity.getVideoMedia());
            workEntity.setChannelReplace(workEntity.getChannel());
            workEntity.setLocationReplace(workEntity.getLocation());
            Unit unit = Unit.INSTANCE;
            intent.putExtra(PublishWorkActivity.t, workEntity);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ WorksActivityPulishWorkBinding d0(PublishWorkActivity publishWorkActivity) {
        return publishWorkActivity.getMBinding();
    }

    public static final /* synthetic */ PublishWorkViewModel e0(PublishWorkActivity publishWorkActivity) {
        return publishWorkActivity.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    public static final void q0(PublishWorkActivity publishWorkActivity, View view) {
        Intrinsics.checkNotNullParameter(publishWorkActivity, "this$0");
        if (publishWorkActivity.s0()) {
            return;
        }
        publishWorkActivity.finish();
    }

    public static final void t0(PublishWorkActivity publishWorkActivity, View view) {
        Intrinsics.checkNotNullParameter(publishWorkActivity, "this$0");
        if (publishWorkActivity.m0().getIsNewWork()) {
            a.INSTANCE.b(publishWorkActivity.i0());
        }
        publishWorkActivity.finish();
    }

    public static final void u0(final PublishWorkActivity publishWorkActivity, View view) {
        Intrinsics.checkNotNullParameter(publishWorkActivity, "this$0");
        PublishWorkViewModel mViewModel = publishWorkActivity.getMViewModel();
        int type = publishWorkActivity.getType();
        PublicWorkDraft publicWorkDraftM0 = publishWorkActivity.m0();
        publicWorkDraftM0.setContent(publishWorkActivity.getMBinding().f13914a.getRichText());
        Unit unit = Unit.INSTANCE;
        mViewModel.J(publishWorkActivity, type, publicWorkDraftM0, new Function0<Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$showSaveDialog$2$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m944invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m944invoke() {
                this.this$0.finish();
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), this.clickProxy)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        h0().g();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_pulish_work;
    }

    public final PublishWorkCategoryDelegate h0() {
        return (PublishWorkCategoryDelegate) this.categoryDelegate.getValue();
    }

    @NotNull
    public final String i0() {
        return (String) this.compressPath.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        n0();
        if (m0().getIsNewWork()) {
            h0().f();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.white);
        }
        getMViewModel().G();
        p0();
        o0();
        h0().h();
        if (getType() == 1) {
            getMBinding().f13915a.initSelectGridPicture(this, i0());
        } else {
            getMBinding().f13915a.initSelectGridVideo(this, i0());
        }
    }

    @NotNull
    public final List<PubWorkMediaData> j0() {
        return getMBinding().f13915a.getSelPictureList();
    }

    @NotNull
    public final List<PubWorkMediaData> k0() {
        return getMBinding().f13915a.getSelVideoCoverList();
    }

    @Nullable
    public final PubWorkMediaData l0() {
        return getMBinding().f13915a.getSelectedVideo();
    }

    public final PublicWorkDraft m0() {
        return (PublicWorkDraft) this.workDraft.getValue();
    }

    public final void n0() {
        if (m0().getIsNewWork()) {
            return;
        }
        PublicWorkDraft publicWorkDraftM0 = m0();
        getMViewModel().E().setValue(publicWorkDraftM0.getTitle());
        EmojiEditText emojiEditText = getMBinding().f13914a;
        Intrinsics.checkNotNullExpressionValue(emojiEditText, "mBinding.etContent");
        ti7.e(emojiEditText, RichTextUtils.j(RichTextUtils.f32968a, publicWorkDraftM0.getContent(), 0, 2, null), false, 2, null);
        if (getType() == 1) {
            getMBinding().f13915a.insertPicture(publicWorkDraftM0.getPicListReplace());
        } else {
            getMBinding().f13915a.insertVideo(publicWorkDraftM0.getVideoMediaReplace());
        }
        getMViewModel().x().setValue(Integer.valueOf(RangesKt.coerceAtLeast(publicWorkDraftM0.getPermissionType(), PubWorkMenuPermissionFragment.VISIBLE_TYPE_PUBLIC)));
        getMViewModel().A().setValue(publicWorkDraftM0.getChannelReplace());
        getMViewModel().B().setValue(publicWorkDraftM0.getLocationReplace());
        getMViewModel().p(null, publicWorkDraftM0.getCategoryNo(), publicWorkDraftM0.getTagNo());
    }

    public final void o0() {
        PubWorkContentEditView pubWorkContentEditView = getMBinding().f13914a;
        pubWorkContentEditView.setSpecialSymbolCallback(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$initEtEvent$1$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                if (Intrinsics.areEqual(str, "#")) {
                    this.this$0.clickProxy.k(true);
                } else if (Intrinsics.areEqual(str, "@")) {
                    this.this$0.clickProxy.m(true);
                }
            }
        });
        pubWorkContentEditView.setTextChangedCallback(new Function1<Editable, Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkActivity$initEtEvent$1$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Editable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Editable editable) {
                PublishWorkActivity.e0(this.this$0).v().setValue(new SpannableStringBuilder(editable));
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != -1 || requestCode != 1001) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra(yj7.e.KEY_GOODS_NO_LIST) : null;
        if (stringArrayListExtra == null) {
            stringArrayListExtra = new ArrayList<>();
        }
        r0(stringArrayListExtra);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        boolean z = false;
        if (event != null && event.getKeyCode() == 4) {
            z = true;
        }
        if (z && s0()) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public final void p0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataD = getMViewModel().D();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(getString(R.string.works_publish_work_title));
        int i = R.color.color_2C3E50;
        BindingTitleBean backClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.y37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishWorkActivity.q0(this.f45949a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataD.setValue(backClick.setStatusBarHeight(value.intValue()).setShowDivider(true));
    }

    public final void r0(ArrayList<String> list) {
        ArrayList<String> value = getMViewModel().w().getValue();
        if (value != null) {
            value.clear();
        }
        getMViewModel().w().setValue(list);
    }

    public final boolean s0() {
        if (getMViewModel().o() || getMBinding().f13915a.isSelectedMedia()) {
            ft1.s(this, "", getString(R.string.works_publish_work_save_hint), true, getString(R.string.works_publish_work_save_cancel), getString(R.string.works_publish_work_save_menu), new View.OnClickListener() { // from class: com.zj.adlib.z37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishWorkActivity.t0(this.f46180a, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.a47
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishWorkActivity.u0(this.f40451a, view);
                }
            });
            return true;
        }
        if (!m0().getIsNewWork()) {
            return false;
        }
        a.INSTANCE.b(i0());
        return false;
    }
}
