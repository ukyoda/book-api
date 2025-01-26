<script setup lang="ts">
import { ref } from "vue";

import Browser from "./index.vue";
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
  <div>
    <div v-for="(item, idx) in items" :key="idx">
      <button type="button" @click="onClick(item)">
        {{ item.label }}
      </button>
    </div>
  </div>
  <Browser v-if="nextPage" :items="nextPage" />
</template>
