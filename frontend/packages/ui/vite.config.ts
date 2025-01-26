import { URL, fileURLToPath } from "node:url";

import tailwindcss from "@tailwindcss/vite";
import vue from "@vitejs/plugin-vue";
import { defineConfig } from "vite";
import { libInjectCss } from "vite-plugin-lib-inject-css";

export default defineConfig({
  plugins: [vue(), tailwindcss(), libInjectCss()],
  build: {
    lib: {
      entry: [
        fileURLToPath(new URL("src/index.ts", import.meta.url)),
        fileURLToPath(new URL("src/Button/index.ts", import.meta.url)),
        fileURLToPath(new URL("src/TextInput/index.ts", import.meta.url)),
        fileURLToPath(new URL("src/List/index.ts", import.meta.url)),
      ],
      formats: ["es"],
    },
    rollupOptions: {
      external: ["vue"],
      output: {
        globals: {
          vue: "Vue",
        },
      },
    },
  },
});
