<script setup lang="ts">
import { ChevronRightIcon } from "@heroicons/vue/16/solid";
import { ref } from "vue";

import Browser from "./Browser.vue";
import { type BrowsingData } from "./type";
const { items } = defineProps<{
  items: BrowsingData[];
}>();
const emits = defineEmits<{
  click: [value: BrowsingData];
}>();

const nextPage = ref<BrowsingData[]>();
const onClick = (item: BrowsingData) => {
  if (item.children) {
    nextPage.value = item.children;
  } else {
    nextPage.value = undefined;
    emits("click", item);
  }
};
</script>
<template>
  <div
    class="flex-1 not-last:w-16 flex flex-col items-start not-first:border-l not-first:border-l-gray-200"
  >
    <button
      v-for="(item, idx) in items"
      :key="idx"
      type="button"
      class="flex items-center justify-between w-full text-left bg-white hover:bg-gray-200 px-4 py-2 rounded-md cursor-pointer"
      @click="onClick(item)"
    >
      <span>
        {{ item.label }}
      </span>
      <template v-if="item.children">
        <ChevronRightIcon class="w-4" />
      </template>
    </button>
  </div>
  <Browser v-if="nextPage" :items="nextPage" />
</template>
