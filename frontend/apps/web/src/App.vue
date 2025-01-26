<script setup lang="ts">
import { Button } from "@repo/ui/Button";
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
    <p class="text-primary">test</p>
    <Button variant="solid" color="primary">aa</Button>
    <TextInput
      v-model="value"
      type="text"
      label="Text Field"
      :validation-schema="toTypedSchema(validator)"
    />
    <p class="text-lg text-green-500">{{ value }}</p>
  </div>
</template>
