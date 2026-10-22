export function fmtDur(sec) {
  const s = Math.max(0, Math.round(Number(sec) || 0));
  return `${Math.floor(s / 60)}分${String(s % 60).padStart(2, '0')}秒`;
}

export function fmtPace(secPerKm) {
  const v = Number(secPerKm) || 0;
  if (!v) return '--';
  const s = Math.round(v);
  return `${Math.floor(s / 60)}'${String(s % 60).padStart(2, '0')}"/公里`;
}

export function fmtPaceShort(secPerKm) {
  const s = Math.round(Number(secPerKm) || 0);
  return s ? `${Math.floor(s / 60)}'${String(s % 60).padStart(2, '0')}"` : '--';
}

export function fmtKm(m) {
  const v = Number(m || 0) / 1000;
  return Number.isInteger(v) ? String(v) : v.toFixed(1);
}

export function fmtDateTime(ms) {
  const t = Number(ms) || 0;
  if (!t) return '--';
  const d = new Date(t);
  const p = (n) => String(n).padStart(2, '0');
  return `${d.getMonth() + 1}/${d.getDate()} ${p(d.getHours())}:${p(d.getMinutes())}`;
}

export function parsePace(text) {
  const s = String(text == null ? '' : text).trim();
  if (!s) return 0;
  const m = s.match(/^(\d+)\s*[':：]\s*(\d+(?:\.\d+)?)/);
  if (m) return Number(m[1]) * 60 + Number(m[2]);
  const n = Number(s);
  return Number.isFinite(n) && n > 0 ? n : 0;
}

export function paceToSpeed(secPerKm) {
  if (!(secPerKm > 0)) return 0;
  return Math.min(6, Math.max(0.5, 1000 / secPerKm));
}

export function fmtPaceInput(secPerKm) {
  const s = Math.round(Number(secPerKm) || 0);
  if (!s) return '';
  return `${Math.floor(s / 60)}'${String(s % 60).padStart(2, '0')}"`;
}
