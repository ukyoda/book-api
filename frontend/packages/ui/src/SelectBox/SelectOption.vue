<script setup lang="ts">
import { ListboxOption } from "@headlessui/vue";
import { CheckIcon } from "@heroicons/vue/20/solid";

const { value } = defineProps<{
  value: string;
}>();
</script>

<template>
  <ListboxOption :value="value" as="template" v-slot="{ active, selected }">
    <li
      :class="{
        'bg-secondary text-white': active,
        'bg-white text-black': !active,
      }"
      class="flex items-center px-2 py-1 justify-start cursor-pointer"
    >
      <CheckIcon v-show="selected" class="w-4 h-4" />
      <div
        :class="{
          'ml-5': !selected,
          'ml-1': selected,
        }"
      >
        <slot />
      </div>
    </li>
  </ListboxOption>
</template>
