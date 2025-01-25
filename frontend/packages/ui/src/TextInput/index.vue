<script setup lang="ts">
const model = defineModel();
defineProps<{
  type: "text" | "number" | "password";
}>();
</script>

<template>
  <input :type="type" v-model="model" />
</template>
