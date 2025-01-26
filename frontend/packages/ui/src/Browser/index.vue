<script setup lang="ts">
import Browser from "./Browser.vue";
import { type BrowsingData } from "./type";

const { items } = defineProps<{
  items: BrowsingData[];
}>();
defineEmits<{
  click: [value: BrowsingData];
}>();
</script>
<template>
  <div class="flex">
    <Browser :items="items" @click="(item) => $emit('click', item)" />
  </div>
</template>
