<script setup lang="ts">
import { twMerge } from "tailwind-merge";
defineProps<{
  className?: string;
}>();
</script>
<template>
  <ul :class="twMerge(className, 'border-b border-gray-200')">
    <slot />
  </ul>
</template>
