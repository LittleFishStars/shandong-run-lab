/* Leaflet 地图封装：新建实例、切换瓦片、重绘围栏/打卡点/起点/路线/轨迹 */
const TILES = {
  amap: {
    url: 'https://webrd0{s}.is.autonavi.com/appmaptile?lang=zh_cn&size=1&scale=1&style=8&x={x}&y={y}&z={z}',
    subdomains: '1234', maxZoom: 18, attribution: '&copy; 高德地图',
  },
  'amap-sat': {
    url: 'https://webst0{s}.is.autonavi.com/appmaptile?style=6&x={x}&y={y}&z={z}',
    subdomains: '1234', maxZoom: 18, attribution: '&copy; 高德地图（卫星）',
  },
  osm: {
    url: 'https://{s}.tile.openstreetmap.de/{z}/{x}/{y}.png',
    subdomains: 'abc', maxZoom: 19, attribution: '&copy; OpenStreetMap',
  },
  none: null,
};

const HOME = [36.6615, 117.0265];

export function initMap(el, onClickRef) {
  const L = window.L;
  const m = L.map(el, { center: HOME, zoom: 16, zoomControl: true, preferCanvas: true });
  m.layers = {};
  for (const k of ['fence', 'route', 'wpt', 'track', 'cps', 'start']) {
    m.layers[k] = L.layerGroup().addTo(m);
  }
  m.on('click', (e) => {
    const fn = onClickRef && onClickRef.current;
    if (fn) fn(e.latlng.lat, e.latlng.lng);
  });
  return m;
}

export function setTileLayer(map, kind) {
  const L = window.L;
  if (!map) return;
  if (map._tile) { map.removeLayer(map._tile); map._tile = null; }
  const conf = TILES[kind];
  if (!conf) return;
  map._tile = L.tileLayer(conf.url, {
    subdomains: conf.subdomains, maxZoom: conf.maxZoom, attribution: conf.attribution,
  }).addTo(map);
}

/* 一次重绘全部叠加层；data 变化时调用 */
export function renderMap(map, data) {
  const L = window.L;
  if (!map) return;
  const { status, walkPoints, route, waypoints, fitKey } = data || {};
  const st = status || {};
  const layers = map.layers;

  /* 围栏 */
  layers.fence.clearLayers();
  const fence = (st.fence_polygon || []).map(([a, b]) => [Number(a), Number(b)])
    .filter(([a, b]) => Number.isFinite(a) && Number.isFinite(b));
  if (fence.length >= 3) {
    L.polygon(fence, { color: '#52c41a', weight: 2, fillColor: '#95de64', fillOpacity: 0.12 }).addTo(layers.fence);
  }

  /* 打卡点（服务端开跑后下发；开跑前用预览点） */
  layers.cps.clearLayers();
  const cps = (st.checkpoints || []).length ? st.checkpoints : (st.preview_points || []);
  cps.forEach((p) => {
    const lat = Number(p.lat), lng = Number(p.lng);
    if (!Number.isFinite(lat) || !Number.isFinite(lng)) return;
    L.circleMarker([lat, lng], {
      radius: 5, color: '#ffffff', weight: 1.5, fillColor: '#722ed1', fillOpacity: 1,
    }).addTo(layers.cps);
  });

  /* 起点 */
  layers.start.clearLayers();
  const sp = st.start_point;
  if (sp && Number.isFinite(Number(sp.lat)) && Number.isFinite(Number(sp.lng))) {
    L.marker([Number(sp.lat), Number(sp.lng)], {
      icon: L.divIcon({ className: 'start-label', html: '起', iconSize: [22, 22], iconAnchor: [11, 11] }),
    }).addTo(layers.start);
  }

  /* 规划路线 / 路点 */
  layers.route.clearLayers();
  if (Array.isArray(route) && route.length > 1) {
    L.polyline(route.map((p) => [Number(p[0]), Number(p[1])]), {
      color: '#faad14', weight: 3, dashArray: '6 6',
    }).addTo(layers.route);
  }
  layers.wpt.clearLayers();
  (waypoints || []).forEach((p) => {
    L.circleMarker([Number(p[0]), Number(p[1])], {
      radius: 4, color: '#1677ff', weight: 2, fillColor: '#ffffff', fillOpacity: 1,
    }).addTo(layers.wpt);
  });

  /* 本次轨迹 */
  layers.track.clearLayers();
  if (Array.isArray(walkPoints) && walkPoints.length > 1) {
    L.polyline(walkPoints.map((p) => [Number(p.lat), Number(p.lng)]), {
      color: '#1677ff', weight: 4, opacity: 0.9,
    }).addTo(layers.track);
    const last = walkPoints[walkPoints.length - 1];
    L.circleMarker([Number(last.lat), Number(last.lng)], {
      radius: 6, color: '#1677ff', weight: 2, fillColor: '#ffffff', fillOpacity: 1,
    }).addTo(layers.track);
  }

  /* 镜头：围栏或起点首次出现时 fit */
  const key = String(fitKey || '');
  if (key && map._fitKey !== key) {
    map._fitKey = key;
    const pts = fence.length >= 3 ? fence
      : (sp ? [[Number(sp.lat), Number(sp.lng)]] : []);
    if (pts.length) {
      try { map.fitBounds(L.latLngBounds(pts).pad(0.2), { animate: false }); } catch (_) { /* 忽略 */ }
    }
  }
}
