<script setup lang="ts" generic="T extends string | number">
import { XCircleIcon } from "@heroicons/vue/16/solid";
import { useField, type TypedSchema } from "vee-validate";
import { defineEmits, computed, useId, type InputHTMLAttributes } from "vue";

const model = defineModel<T>();
const props = defineProps<{
  type?: InputHTMLAttributes["type"];
  id?: string;
  name?: string;
  label?: string;
  validationSchema?: TypedSchema;
}>();
defineEmits<{
  click: [value: T];
}>();

const formId = useId();
const nameRef = computed(() => props.name ?? `text-input-${formId}`);
const idRef = computed(() => props.id ?? `text-input-${formId}`);

const { errorMessage, value: fieldValue } = useField(
  nameRef.value,
  props.validationSchema,
  {
    initialValue: model.value,
    syncVModel: true,
  },
);
const isError = computed(() => errorMessage.value?.length);
const clear = () => {
  fieldValue.value = "";
};
const fontSize = "text-sm font-medium";
</script>

<template>
  <div class="flex flex-col">
    <label
      v-if="label"
      :for="idRef"
      :class="[fontSize, 'text-sm font-medium text-gray-700']"
    >
      {{ label }}
    </label>
    <div
      class="border-[1px] rounded-md flex px-2.5"
      :class="[isError ? 'border-red-600' : 'border-gray-300']"
    >
      <input
        v-model="fieldValue"
        :type="type"
        :id="idRef"
        :name="nameRef"
        class="py-2 focus:outline-none flex-1"
      />
      <button v-if="(fieldValue?.length ?? 0) > 0" type="button" @click="clear">
        <span class="sr-only">Clear</span>
        <XCircleIcon class="size-[1.2rem] text-gray-500" />
      </button>
    </div>
    <div v-if="errorMessage" :class="[fontSize, 'text-red-600']">
      {{ errorMessage }}
    </div>
  </div>
</template>
