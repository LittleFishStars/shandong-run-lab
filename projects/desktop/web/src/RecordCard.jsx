import React from 'react';
import { fmtPaceShort } from './format';

function fmtHms(sec) {
  const s = Math.max(0, Math.round(Number(sec) || 0));
  const h = Math.floor(s / 3600);
  const m = Math.floor((s % 3600) / 60);
  const x = s % 60;
  return [h, m, x].map((n) => String(n).padStart(2, '0')).join(':');
}

function fmtDateShort(ms) {
  const t = Number(ms) || 0;
  if (!t) return '';
  const d = new Date(t);
  const p = (n) => String(n).padStart(2, '0');
  return `${p(d.getMonth() + 1)}-${p(d.getDate())} ${p(d.getHours())}:${p(d.getMinutes())}`;
}

/* 单条跑步记录：大号距离 + 状态标签 + 总里程/时间 + 时长/配速/消耗（照 App 记录页样式） */
function fmtKm(m) {
  const km = (Number(m) || 0) / 1000;
  return (Number.isInteger(km) && km >= 1) ? String(km)
    : km.toFixed(3).replace(/0+$/, '').replace(/\.$/, '');
}

export default function RecordCard({ item }) {
  // 大号数字 = 计入成绩的里程（服务端 validDistance，已按单日上限封顶）；无效记录回退实际里程
  const totalM = Number(item.distance_m) || 0;
  const validM = Number(item.valid_distance_m) || 0;
  const shownM = validM > 0 ? validM : totalM;
  const kmText = fmtKm(shownM);
  const totalText = fmtKm(totalM);
  const ok = item.state_kind === 'ok';
  const stateText = item.state || (ok ? '计入成绩' : '无效');
  return (
    <div className="rec-card">
      <div className="rec-head">
        <span className={`rec-dist${ok ? '' : ' invalid'}`}>{kmText}</span>
        <span className="rec-unit">Km</span>
        <span className={`rec-tag${ok ? '' : ' err'}`}>{stateText}</span>
      </div>
      <div className="rec-sub">
        <span>本次总里程 {totalText}km</span>
        <span className="rec-date">{fmtDateShort(item.start_ms)}</span>
      </div>
      <div className="rec-stats">
        <span className="rec-stat"><i>⏱</i>{fmtHms(item.duration_s)}</span>
        <span className="rec-stat"><i>⚡</i>{fmtPaceShort(item.pace_s_per_km)}</span>
        <span className="rec-stat"><i>🔥</i>{item.calorie || '--'}</span>
      </div>
    </div>
  );
}
