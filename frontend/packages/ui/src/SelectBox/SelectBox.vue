<script setup lang="ts" generic="T extends ModelTypeBase">
import { Listbox, ListboxButton, ListboxOptions } from "@headlessui/vue";
import { ChevronUpDownIcon } from "@heroicons/vue/16/solid";
import { provide } from "vue";

import { type ModelTypeBase, provideKey } from "./type";
const { placeholder = "Select..." } = defineProps<{
  placeholder?: string;
}>();
const model = defineModel<T>();
defineSlots<{
  default?: unknown;
  placeholder: unknown;
}>();
provide(provideKey, model);
</script>
<template>
  <Listbox v-model="model">
    <div class="relative mt-1">
      <ListboxButton
        class="relative px-2 py-1 border border-gray-400 rounded-md w-full text-left"
      >
        <slot name="placeholder">
          {{ placeholder }}
        </slot>
        <ChevronUpDownIcon
          class="w-4 h-4 absolute right-2 top-1/2 transform -translate-y-1/2"
        />
      </ListboxButton>
      <ListboxOptions
        class="mt-1 bg-white border border-gray-400 rounded-md py-1 w-full"
      >
        <slot />
      </ListboxOptions>
    </div>
  </Listbox>
</template>
