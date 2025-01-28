<script setup lang="ts" generic="T">
import {
  Listbox,
  ListboxButton,
  ListboxOptions,
  ListboxOption,
} from "@headlessui/vue";
import { ChevronUpDownIcon, CheckIcon } from "@heroicons/vue/16/solid";

const { data, placeholder = "Select..." } = defineProps<{
  data: { label: string; value: T }[];
  placeholder?: string;
}>();
const model = defineModel<{ label: string; value: T }>();
</script>
<template>
  <Listbox v-model="model">
    <div class="relative mt-1">
      <ListboxButton
        class="relative px-4 py-3 border border-gray-400 rounded-md w-full text-left"
      >
        <template v-if="model !== undefined">
          {{ model.label }}
        </template>
        <template v-else>
          {{ placeholder }}
        </template>
        <ChevronUpDownIcon
          class="w-5 h-5 absolute right-2 top-1/2 transform -translate-y-1/2"
        />
      </ListboxButton>
      <ListboxOptions
        class="absolute mt-1 bg-white border border-gray-400 rounded-md py-1 w-full"
      >
        <ListboxOption
          v-for="(item, idx) in data"
          :key="idx"
          :value="item"
          as="template"
          v-slot="{ active, selected }"
        >
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
              {{ item.label }}
            </div>
          </li>
        </ListboxOption>
      </ListboxOptions>
    </div>
  </Listbox>
</template>
