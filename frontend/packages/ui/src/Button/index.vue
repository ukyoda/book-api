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
  block = false,
} = defineProps<{
  type?: "button" | "submit" | "reset";
  id?: string;
  disabled?: boolean;
  color?: ButtonTheme;
  variant?: ButtonVariant;
  size?: ButtonSize;
  block?: boolean;
}>();
defineEmits<{
  click: [MouseEvent];
}>();

const sizeStyle = computed(() => {
  return {
    sm: "text-[0.8rem] px-[0.8rem] py-[0.4rem]",
    md: "text-md px-4 py-3",
    lg: "text-xl px-6 py-4",
  }[size];
});
const themeStyle = computed(() => {
  const key = `${variant}-${color}`;
  return (
    {
      // SOLID
      "solid-primary": "bg-primary text-white rounded-md",
      "solid-secondary": "bg-secondary text-white rounded-md",
      "solid-danger": "bg-danger text-white rounded-md",
      "solid-normal": "bg-gray-200 text-black rounded-md",
      // OUTLINE
      "outline-primary":
        "bg-transparent text-primary border border-primary rounded-md",
      "outline-secondary":
        "bg-transparent text-secondary border border-secondary rounded-md",
      "outline-danger":
        "bg-transparent text-danger border border-danger rounded-md",
      "outline-normal":
        "bg-transparent text-gray-600 border border-gray-600 rounded-md",
      // GHOST
      "ghost-primary": "text-primary rounded-md hover:bg-gray-100",
      "ghost-secondary": "text-secondary rounded-md hover:bg-gray-100",
      "ghost-danger": "text-danger rounded-md hover:bg-gray-100",
      "ghost-normal": "text-black rounded-md hover:bg-gray-100",
    } satisfies Record<`${ButtonVariant}-${ButtonTheme}`, string>
  )[key];
});
</script>
<template>
  <button
    :type="type"
    :id="id"
    :disabled="disabled"
    :class="[
      sizeStyle,
      themeStyle,
      block && 'w-full',
      'cursor-pointer active:opacity-80 px-4',
    ]"
    @click="(e) => $emit('click', e)"
  >
    <slot />
  </button>
</template>
