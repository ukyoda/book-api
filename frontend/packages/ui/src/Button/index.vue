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
    sm: "text-[0.8rem] px-[0.8rem] py-[0.4rem]",
    md: "text-md px-4 py-3",
    lg: "text-lg px-4 py-3",
  }[size];
});
const themeStyle = computed(() => {
  const key = `${variant}-${color}`;
  return (
    {
      "solid-primary": "bg-primary text-white rounded-md",
      "solid-secondary": "bg-secondary text-white rounded-md",
      "solid-danger": "bg-danger text-white rounded-md",
      "solid-normal": "bg-normal text-black border border-gray-400 rounded-md",
      "outline-primary":
        "bg-transparent text-primary border border-primary rounded-md",
      "outline-secondary":
        "bg-transparent text-secondary border border-secondary rounded-md",
      "outline-danger":
        "bg-transparent text-danger border border-danger rounded-md",
      "outline-normal":
        "bg-transparent text-black border border-black rounded-md",
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
    :class="[sizeStyle, themeStyle, 'cursor-pointer active:opacity-80 px-4']"
    @click="(e) => $emit('click', e)"
  >
    <slot />
  </button>
</template>
