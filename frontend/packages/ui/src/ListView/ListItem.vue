<script setup lang="ts">
import { isAbsoluteUrl } from "@repo/utils/link";

defineProps<{
  link?: string;
}>();
defineEmits<{
  click: [];
}>();
</script>
<template>
  <li class="first:border-0 border-t border-gray-200 hover:bg-gray-100">
    <component
      :is="link ? 'a' : 'div'"
      :href="link"
      class="px-3 py-4 block"
      @click="!!link && $emit('click')"
    >
      <div v-if="$slots.left || $slots.right" class="flex justify-between">
        <div>
          <slot name="left" />
        </div>
        <div>
          <slot name="right" />
        </div>
      </div>
      <slot />
    </component>
  </li>
</template>
