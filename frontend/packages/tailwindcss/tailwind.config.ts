import type { Config } from "tailwindcss";

const config: Omit<Config, "content"> = {
  theme: {
    extend: {
      colors: {
        // ベースカラー
        primary: "#4CAF50", // 落ち着いた緑 (清潔感＆安心感)
        secondary: "#2196F3", // 落ち着いた青 (視認性向上)
        accent: "#FFC107", // 柔らかい黄色 (ポイント的な使い方)
        normal: "#F5F5F5", // 背景色 (白っぽいグレー)
        dark: "#212121", // 文字色やヘッダーなどで使う濃いグレー
        danger: "#F44336", // 警告色 (赤)
        link: "#2196F3", // リンク色 (青)
        transparent: "transparent", // 透明
      },
      fontFamily: {
        sans: ['"Noto Sans"', "Arial", "sans-serif"], // 清潔感のあるフォント
        serif: ['"Noto Serif"', "serif"], // 見出しやアクセントに
        mono: ['"Roboto Mono"', "monospace"], // 特定情報用
      },
    },
  },
};

export default config;
