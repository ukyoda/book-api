<script setup lang="ts">
import { defineProps } from "vue";
import { demo } from "./utils/demo";

console.log("aaa");
defineProps<{ val?: number }>();
demo();
</script>
<template>
  <div>test</div>
</template>
