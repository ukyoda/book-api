<script setup lang="ts">
import { computed } from "vue";

type ButtonVariant = "solid" | "outline" | "ghost";
type ButtonTheme = "primary" | "secondary" | "danger" | "normal";
type ButtonSize = "sm" | "md" | "lg";

const {
  type = "button",
  color = "normal",
  variant = "solid",
  size = "md",
} = defineProps<{
  type?: "button" | "submit" | "reset";
  id?: string;
  disabled?: boolean;
  color?: ButtonTheme;
  variant?: ButtonVariant;
  size?: ButtonSize;
}>();
defineEmits<{
  click: [MouseEvent];
}>();

const sizeStyle = computed(() => {
  return {
    sm: "text-sm px-2 py-1",
    md: "text-md px-2 py-1",
    lg: "text-lg px-4 py-1",
  }[size];
});
const themeStyle = computed(() => {
  const key = `${variant}-${color}`;
  return (
    {
      "solid-primary":
        "bg-primary text-black border border-gray-400 rounded-md",
      "solid-secondary":
        "bg-secondary border text-black border border-gray-400 rounded-md",
      "solid-danger": "bg-red-500 text-white",
      "solid-normal": "bg-gray-500 text-white",
      "outline-primary": "border-blue-500 text-blue-500",
      "outline-secondary": "border-gray-500 text-gray-500",
      "outline-danger": "border-red-500 text-red-500",
      "outline-normal": "border-gray-500 text-gray-500",
      "ghost-primary": "text-blue-500",
      "ghost-secondary": "text-gray-500",
      "ghost-danger": "text-red-500",
      "ghost-normal": "text-gray-500",
    } satisfies Record<`${ButtonVariant}-${ButtonTheme}`, string>
  )[key];
});
</script>
<template>
  <button
    :type="type"
    :id="id"
    :disabled="disabled"
    :class="[sizeStyle, themeStyle, 'cursor-pointer active:opacity-80']"
    @click="(e) => $emit('click', e)"
  >
    <slot />
  </button>
</template>
