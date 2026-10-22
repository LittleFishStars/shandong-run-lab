package com.huachenjie.works.adapter.buddy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.buddy.BuddyCardAdapter;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.bean.BuddyUserBean;
import com.huachenjie.works.databinding.WorksItemBuddyCardBinding;
import com.kuaishou.weapon.p0.t;
import com.noober.background.view.BLImageView;
import com.zj.adlib.fx7;
import com.zj.adlib.j14;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import com.zj.adlib.su9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\bI\u0010JJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bH\u0002R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00104\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00108\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u00105\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001b\u0010>\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107R\u001b\u0010A\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u00107R\u0014\u0010D\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010G¨\u0006K"}, d2 = {"Lcom/huachenjie/works/adapter/buddy/BuddyCardAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/BuddyCardBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemBuddyCardBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", "w", "Landroid/content/Context;", "context", "", "emptyLayoutId", "v", "B", "u", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "", "x", "binding", "", "", "imageList", t.d, "j", "k", "index", "Lcom/noober/background/view/BLImageView;", "n", "Landroid/widget/ImageView;", "imageView", AvatarFragment.AVATAR_URL, "y", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "r", "()Lkotlin/jvm/functions/Function0;", j.o, "(Lkotlin/jvm/functions/Function0;)V", "onBeforeOpenDetail", "Z", "t", "()Z", "A", "(Z)V", "trackHomeDaziClick", "Lkotlin/Lazy;", "s", "()I", "previewImageSize", "b", "q", "memberAvatarSize", "c", j.b, "memberAvatarOverlap", "d", "p", "memberAvatarRingWidth", "K", "I", "edgeMargin", "L", "itemMargin", "Landroid/view/View;", "emptyView", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBuddyCardAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuddyCardAdapter.kt\ncom/huachenjie/works/adapter/buddy/BuddyCardAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n766#2:248\n857#2,2:249\n1855#2,2:251\n1864#2,3:253\n1549#2:256\n1620#2,3:257\n1864#2,3:260\n*S KotlinDebug\n*F\n+ 1 BuddyCardAdapter.kt\ncom/huachenjie/works/adapter/buddy/BuddyCardAdapter\n*L\n98#1:248\n98#1:249,2\n107#1:251,2\n115#1:253,3\n136#1:256\n136#1:257,3\n142#1:260,3\n*E\n"})
public final class BuddyCardAdapter extends BaseQuickAdapter<BuddyCardBean, BaseDataBindingHolder<WorksItemBuddyCardBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int edgeMargin;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int itemMargin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View emptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy previewImageSize;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function0<Unit> onBeforeOpenDetail;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean trackHomeDaziClick;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy memberAvatarSize;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy memberAvatarOverlap;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy memberAvatarRingWidth;

    public BuddyCardAdapter() {
        super(R.layout.works_item_buddy_card, null, 2, null);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.v01
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BuddyCardAdapter.g(this.f45263a, baseQuickAdapter, view, i);
            }
        });
        this.previewImageSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter$previewImageSize$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m803invoke() {
                return Integer.valueOf((int) ((fx7.j() - jj8.a(73.0f)) / 4.0f));
            }
        });
        this.memberAvatarSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter$memberAvatarSize$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m802invoke() {
                return Integer.valueOf(jj8.a(20.0f));
            }
        });
        this.memberAvatarOverlap = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter$memberAvatarOverlap$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m800invoke() {
                return Integer.valueOf(jj8.a(4.0f));
            }
        });
        this.memberAvatarRingWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter$memberAvatarRingWidth$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m801invoke() {
                return Integer.valueOf(jj8.a(1.0f));
            }
        });
        this.edgeMargin = jj8.a(16.0f);
        this.itemMargin = jj8.a(12.0f);
    }

    public static final void g(BuddyCardAdapter buddyCardAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(buddyCardAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BuddyCardBean item = buddyCardAdapter.getItem(i);
        if (item.getBuddyCode().length() == 0) {
            return;
        }
        if (buddyCardAdapter.trackHomeDaziClick) {
            Context context = buddyCardAdapter.getContext();
            String buddyCode = item.getBuddyCode();
            BuddyTypeScopeTypeBean buddyTypeInfo = item.getBuddyTypeInfo();
            String buddyTypeName = buddyTypeInfo != null ? buddyTypeInfo.getBuddyTypeName() : null;
            if (buddyTypeName == null) {
                buddyTypeName = "";
            }
            j14.c(context, "卡片", buddyCode, buddyTypeName, i + 1);
        }
        Function0<Unit> function0 = buddyCardAdapter.onBeforeOpenDetail;
        if (function0 != null) {
            function0.invoke();
        }
        su9.l(buddyCardAdapter.getContext(), Environment.c + "/#/buddy/detail?code=" + item.getBuddyCode());
    }

    public static final void m(ImageView imageView, List list, int i, final List list2, View view) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(list, "$previewImages");
        Intrinsics.checkNotNullParameter(list2, "$imageViews");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        PicturePreviewUtil.h(context, list, i, new Function1<Integer, View>() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter$bindPreviewImages$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @Nullable
            public final View invoke(int i2) {
                return list2.get(i2);
            }
        });
    }

    public final void A(boolean z) {
        this.trackHomeDaziClick = z;
    }

    public final void B() {
        View view;
        if (hasEmptyView() || (view = this.emptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    public final void j(WorksItemBuddyCardBinding binding, BuddyCardBean item) {
        List<BuddyUserBean> memberPreviewList = item.getMemberPreviewList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberPreviewList, 10));
        Iterator<T> it = memberPreviewList.iterator();
        while (it.hasNext()) {
            arrayList.add(((BuddyUserBean) it.next()).getAvatar());
        }
        List listTake = CollectionsKt.take(arrayList, 5);
        binding.f14493b.removeAllViews();
        boolean z = !listTake.isEmpty();
        int i = 8;
        int i2 = 0;
        binding.f14493b.setVisibility(z ? 0 : 8);
        View view = binding.f37009a;
        if (z && item.getMaxMemberCount() != -1) {
            i = 0;
        }
        view.setVisibility(i);
        for (Object obj : listTake) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Context context = binding.f14493b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.llMemberAvatarPreview.context");
            BLImageView bLImageViewN = n(context, i2);
            binding.f14493b.addView(bLImageViewN);
            y(bLImageViewN, (String) obj);
            i2 = i3;
        }
    }

    public final void k(WorksItemBuddyCardBinding binding, BuddyCardBean item) {
        String str;
        if (item.getMaxMemberCount() == -1) {
            return;
        }
        int iMax = item.getMaxMemberCount() <= 0 ? Math.max(item.getCurrentMemberCount(), 1) : item.getMaxMemberCount();
        int iRoundToInt = MathKt.roundToInt((RangesKt.coerceAtMost(item.getCurrentMemberCount(), iMax) * 100.0f) / iMax);
        if (x(item)) {
            str = "#FFFF5A5F";
        } else {
            str = iRoundToInt >= 60 ? "#FFFF9F1C" : "#FF36C06A";
        }
        binding.f14490a.setGrpProgress(iRoundToInt);
        binding.f14490a.setProgressColor(Color.parseColor(str));
        binding.f14497c.setTextColor(Color.parseColor(str));
    }

    public final void l(WorksItemBuddyCardBinding binding, List<String> imageList) {
        final ArrayList arrayList = new ArrayList();
        for (Object obj : imageList) {
            if (true ^ StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listTake = CollectionsKt.take(arrayList, 4);
        final List listListOf = CollectionsKt.listOf(new ImageView[]{binding.f14486a, binding.b, binding.c, binding.d});
        binding.f14487a.setVisibility(listTake.isEmpty() ? 8 : 0);
        List list = listListOf;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ImageView imageView = (ImageView) it.next();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.width = s();
                layoutParams2.height = s();
                layoutParams2.weight = 0.0f;
                imageView.setLayoutParams(layoutParams2);
            }
        }
        final int i = 0;
        for (Object obj2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final ImageView imageView2 = (ImageView) obj2;
            if (i < listTake.size()) {
                imageView2.setVisibility(0);
                Glide.with(imageView2).load((String) listTake.get(i)).apply((BaseRequestOptions<?>) ju3.m).into(imageView2);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.w01
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BuddyCardAdapter.m(imageView2, arrayList, i, listListOf, view);
                    }
                });
            } else {
                imageView2.setVisibility(8);
                imageView2.setImageDrawable(null);
                imageView2.setOnClickListener(null);
            }
            i = i2;
        }
    }

    public final BLImageView n(Context context, int index) {
        BLImageView bLImageView = new BLImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q(), q());
        if (index > 0) {
            layoutParams.setMarginStart(-o());
        }
        bLImageView.setLayoutParams(layoutParams);
        bLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bLImageView.setPadding(p(), p(), p(), p());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        bLImageView.setBackground(gradientDrawable);
        bLImageView.setImageResource(R.drawable.ic_default_avatar);
        return bLImageView;
    }

    public final int o() {
        return ((Number) this.memberAvatarOverlap.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.works.adapter.buddy.BuddyCardAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (BuddyCardAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        outRect.set(BuddyCardAdapter.this.edgeMargin, childAdapterPosition == 0 ? 0 : BuddyCardAdapter.this.itemMargin, BuddyCardAdapter.this.edgeMargin, 0);
                        break;
                }
            }
        });
    }

    public final int p() {
        return ((Number) this.memberAvatarRingWidth.getValue()).intValue();
    }

    public final int q() {
        return ((Number) this.memberAvatarSize.getValue()).intValue();
    }

    @Nullable
    public final Function0<Unit> r() {
        return this.onBeforeOpenDetail;
    }

    public final int s() {
        return ((Number) this.previewImageSize.getValue()).intValue();
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final boolean getTrackHomeDaziClick() {
        return this.trackHomeDaziClick;
    }

    public final void u() {
        removeEmptyView();
    }

    public final void v(@NotNull Context context, int emptyLayoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.emptyView = LayoutInflater.from(context).inflate(emptyLayoutId, (ViewGroup) null);
    }

    public final void w(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.emptyView = view;
    }

    public final boolean x(BuddyCardBean item) {
        return item.getStatus() == 2 || (item.getMaxMemberCount() > 0 && item.getCurrentMemberCount() >= item.getMaxMemberCount());
    }

    public final void y(ImageView imageView, String avatarUrl) {
        Glide.with(imageView).load(avatarUrl).apply((BaseRequestOptions<?>) ju3.b).into(imageView);
    }

    public final void z(@Nullable Function0<Unit> function0) {
        this.onBeforeOpenDetail = function0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemBuddyCardBinding> holder, @NotNull BuddyCardBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemBuddyCardBinding worksItemBuddyCardBinding = (WorksItemBuddyCardBinding) holder.getDataBinding();
        if (worksItemBuddyCardBinding != null) {
            worksItemBuddyCardBinding.k(item);
            l(worksItemBuddyCardBinding, item.getImageList());
            j(worksItemBuddyCardBinding, item);
            k(worksItemBuddyCardBinding, item);
            worksItemBuddyCardBinding.executePendingBindings();
        }
    }
}
