<script setup lang="ts">
import { Switch } from "@headlessui/vue";
import { computed } from "vue";

const model = defineModel<boolean>();
const { color = "normal" } = defineProps<{
  alt?: string;
  name?: string;
  color?: "primary" | "secondary" | "danger" | "normal";
}>();

const colorStyle = computed(() => {
  switch (color) {
    case "primary":
      return "bg-primary";
    case "secondary":
      return "bg-secondary";
    case "danger":
      return "bg-danger";
    case "normal":
    default:
      return "bg-gray-600";
  }
});
</script>

<template>
  <Switch
    v-model="model"
    :name="name"
    :class="model ? colorStyle : 'bg-gray-200'"
    class="relative inline-flex h-6 w-11 items-center rounded-full"
  >
    <span class="sr-only" v-if="alt">{{ alt }}</span>
    <span
      :class="model ? 'translate-x-6' : 'translate-x-1'"
      class="inline-block h-4 w-4 transform rounded-full bg-white transition"
    />
  </Switch>
</template>
