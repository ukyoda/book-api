<script setup lang="ts">
defineProps<{
  link?: string;
  isExternal?: boolean;
}>();
defineEmits<{
  click: [e: MouseEvent];
}>();
</script>
<template>
  <li class="first:border-0 border-t border-gray-200 hover:bg-gray-100">
    <component
      :is="link ? 'a' : 'div'"
      :href="link"
      :target="isExternal ? '_blank' : undefined"
      :rel="isExternal ? 'noopener noreferrer' : undefined"
      class="px-3 py-4 block"
      @click="(e: MouseEvent) => !!link && $emit('click', e)"
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
