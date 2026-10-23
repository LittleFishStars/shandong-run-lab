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
export default function RecordCard({ item }) {
  const km = (Number(item.distance_m) || 0) / 1000;
  const kmText = (Number.isInteger(km) && km >= 1) ? String(km)
    : km.toFixed(3).replace(/0+$/, '').replace(/\.$/, '');
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
        <span>本次总里程 {kmText}km</span>
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
