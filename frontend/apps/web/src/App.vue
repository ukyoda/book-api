<script setup lang="ts">
import { TextInput } from "@repo/ui/TextInput";
import { toTypedSchema } from "@vee-validate/zod";
import { computed, ref } from "vue";
import { z } from "zod";

const validator = computed(() => z.string().min(5).max(20));
const value = ref("");
</script>
<template>
  <div>test</div>
  <div class="p-4">
    <TextInput
      v-model="value"
      type="text"
      label="Text Field"
      :validation-schema="toTypedSchema(validator)"
    />
    <p>{{ value }}</p>
  </div>
</template>
