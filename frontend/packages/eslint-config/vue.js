import base, { rules } from ".";
import pluginVue from "eslint-plugin-vue";

export default [
  ...base,
  ...pluginVue.configs["flat/recommended"],
  {
    rules: {
      "vue/no-unused-vars": "error",
    },
  },
];
