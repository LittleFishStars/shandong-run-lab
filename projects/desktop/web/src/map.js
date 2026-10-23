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

export function initMap(el, onClickRef, ghostRef) {
  const L = window.L;
  const m = L.map(el, { center: HOME, zoom: 16, zoomControl: true, preferCanvas: true });
  m.layers = {};
  for (const k of ['fence', 'track', 'cps', 'start', 'ghost']) {
    m.layers[k] = L.layerGroup().addTo(m);
  }
  m.on('click', (e) => {
    const fn = onClickRef && onClickRef.current;
    if (fn) fn(e.latlng.lat, e.latlng.lng);
  });

  /* 跑步页：右键从「人」的位置拉出复制点轨迹 */
  let dragging = false;
  const container = m.getContainer();
  m.on('contextmenu', (e) => { if (e.originalEvent) e.originalEvent.preventDefault(); });
  container.addEventListener('contextmenu', (ev) => ev.preventDefault());
  container.addEventListener('mousedown', (ev) => {
    if (ev.button !== 2) return;
    const g = ghostRef && ghostRef.current;
    if (!g || !g.enabled) return;
    ev.preventDefault();
    dragging = true;
    m.dragging.disable();
    const ll = m.mouseEventToLatLng(ev);
    if (g.onStart) g.onStart(ll.lat, ll.lng);
  });
  container.addEventListener('mousemove', (ev) => {
    if (!dragging) return;
    const g = ghostRef && ghostRef.current;
    if (!g) return;
    const ll = m.mouseEventToLatLng(ev);
    if (g.onMove) g.onMove(ll.lat, ll.lng);
  });
  const endDrag = () => {
    if (!dragging) return;
    dragging = false;
    m.dragging.enable();
    const g = ghostRef && ghostRef.current;
    if (g && g.onEnd) g.onEnd();
  };
  window.addEventListener('mouseup', endDrag);
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
  const { status, walkPoints, checkpoints, ghostPath, fitKey } = data || {};
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
  const cps = (Array.isArray(checkpoints) && checkpoints.length) ? checkpoints
    : ((st.checkpoints || []).length ? st.checkpoints : (st.preview_points || []));
  cps.forEach((p, i) => {
    const lat = Number(p.lat), lng = Number(p.lng);
    if (!Number.isFinite(lat) || !Number.isFinite(lng)) return;
    const passed = Number(p.passed) === 1 || p.passed === true;
    const num = p.index != null ? Number(p.index) + 1 : i + 1;   // 服务端 sort 序号
    L.marker([lat, lng], {
      icon: L.divIcon({
        className: 'cp-icon',
        iconSize: [20, 20],
        iconAnchor: [10, 10],
        html: `<span class="cp-label${passed ? ' passed' : ''}">${num}</span>`,
      }),
      keyboard: false,
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

  /* 复制点轨迹（右键拖出来的那条线） */
  layers.ghost.clearLayers();
  if (Array.isArray(ghostPath) && ghostPath.length > 1) {
    L.polyline(ghostPath.map((p) => [Number(p[0]), Number(p[1])]), {
      color: '#13c2c2', weight: 3, dashArray: '4 6', opacity: 0.9,
    }).addTo(layers.ghost);
    const last = ghostPath[ghostPath.length - 1];
    L.circleMarker([Number(last[0]), Number(last[1])], {
      radius: 7, color: '#ffffff', weight: 2, fillColor: '#13c2c2', fillOpacity: 1,
    }).addTo(layers.ghost);
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
