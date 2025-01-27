<script setup lang="ts">
import { SwitchGroup, Switch, SwitchLabel } from "@headlessui/vue";
import { computed } from "vue";

const model = defineModel<boolean>();
const {
  color = "normal",
  size = "md",
  direction = "west",
  name,
} = defineProps<{
  /** altを表示します。labelが設定されている場合は無視します */
  alt?: string;
  /** labelを表示します */
  label?: string;
  /** labelの位置を決めます */
  direction?: "east" | "west";
  name?: string;
  color?: "primary" | "secondary" | "danger" | "normal";
  size?: "sm" | "md" | "lg";
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
const sizeStyle = computed(() => {
  return {
    md: ["h-6 w-11", "h-4 w-4"],
    sm: ["h-5 w-10", "h-3 w-3"],
    lg: ["h-7 w-12", "h-5 w-5"],
  }[size];
});
</script>

<template>
  <SwitchGroup>
    <div
      :class="
        label
          ? [
              'flex items-center justify-start',
              direction === 'west' ? 'flex-row' : 'flex-row-reverse',
            ]
          : 'inline-block'
      "
    >
      <SwitchLabel v-if="label" :class="direction === 'west' ? 'mr-2' : 'ml-2'">
        {{ label }}
      </SwitchLabel>
      <Switch
        v-model="model"
        :name="name"
        :class="[model ? colorStyle : 'bg-gray-200', sizeStyle[0]]"
        class="relative inline-flex items-center rounded-full"
      >
        <span class="sr-only" v-if="alt && !label">{{ alt }}</span>
        <span
          :class="[model ? 'translate-x-6' : 'translate-x-1', sizeStyle[1]]"
          class="inline-blocktransform rounded-full bg-white transition"
        />
      </Switch>
    </div>
  </SwitchGroup>
</template>
