import globals from "globals";
import pluginJs from "@eslint/js";
import tsEslint from "typescript-eslint";
import pluginVue from "eslint-plugin-vue";
import vueParser from "vue-eslint-parser";
import eslintConfigPrettier from "@vue/eslint-config-prettier";
import importPlugin from "eslint-plugin-import";

export default tsEslint.config(
  {
    ignores: ["*.d.ts", "**/covreage", "**/dist", "**/node_modules"],
  },
  { languageOptions: { globals: { ...globals.browser, ...globals.node } } },
  pluginJs.configs.recommended,
  tsEslint.configs.recommended,
  pluginVue.configs["flat/essential"],
  importPlugin?.flatConfigs?.recommended,
  eslintConfigPrettier,
  {
    files: ["**/*.{js,ts,jsx,tsx,vue}"],
    languageOptions: {
      parser: vueParser,
      parserOptions: {
        parser: tsEslint.parser,
        ecmaVersion: "latest",
        sourceType: "module",
      },
    },
    settings: {
      "import/resolver": {
        typescript: {
          alwaysTryTypes: true,
          project: ["**/tsconfig.json"],
        },
        node: {
          extensions: [".js", ".jsx", ".ts", ".tsx", ".d.ts"],
        },
      },
    },
    rules: {
      "no-console": "error",
      "import/order": [
        "error",
        {
          groups: ["builtin", "external", "parent", "sibling", "index"],
          alphabetize: {
            order: "asc",
          },
          "newlines-between": "always",
        },
      ],
    },
  }
);
