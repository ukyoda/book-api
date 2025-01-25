<script setup lang="ts">
const model = defineModel();
defineProps<{
  type?: "text" | "number" | "password";
}>();
</script>

<template>
  <input :type="type" v-model="model" class="bg-gray-300 p-3 font-bold" />
</template>
