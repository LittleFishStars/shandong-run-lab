package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity;
import com.huachenjie.works.page.campus_wall.detail.PostDetailActivity;
import com.huachenjie.works.page.comment.me_list.CommentOnMeListActivity;
import com.huachenjie.works.page.details.WorksDetailsActivity;
import com.huachenjie.works.page.dormitory.DormitoryActivity;
import com.huachenjie.works.page.local.LocalDraftActivity;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.huachenjie.works.page.this_school.ThisSchoolActivity;
import com.zj.adlib.zj7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$works implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        RouteType routeType = RouteType.ACTIVITY;
        atlas.put(zj7.i.DORMITORY, RouteMeta.build(routeType, DormitoryActivity.class, "/works/dormitoryactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.BROADCAST_FLOOR, RouteMeta.build(routeType, BroadcastFloorActivity.class, "/works/broadcastflooractivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.COMMENT_ON_ME_LIST, RouteMeta.build(routeType, CommentOnMeListActivity.class, "/works/commentonmelistactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.POST_DETAIL, RouteMeta.build(routeType, PostDetailActivity.class, "/works/postdetailactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.WORKS_PUBLISH, RouteMeta.build(routeType, PublishWorkActivity.class, "/works/workpublishactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.WORKS_DETAIL, RouteMeta.build(routeType, WorksDetailsActivity.class, "/works/worksdetailactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.WORKS_DRAFT, RouteMeta.build(routeType, LocalDraftActivity.class, "/works/worksdraftactivity", "works", null, -1, Integer.MIN_VALUE));
        atlas.put(zj7.i.WORKS_THIS_SCHOOL, RouteMeta.build(routeType, ThisSchoolActivity.class, "/works/worksthisschoolactivity", "works", null, -1, Integer.MIN_VALUE));
    }
}
