<script setup lang="ts">
import { XMarkIcon } from "@heroicons/vue/16/solid";
import { useTemplateRef } from "vue";

import { Button } from "../../Button";
import Modal from "../Modal/index.vue";

const { color = "normal", buttonText = "OK" } = defineProps<{
  color?: "primary" | "secondary" | "danger" | "normal";
  buttonText?: string;
}>();
const modalRef = useTemplateRef("modalRef");

const show = () => {
  modalRef.value?.show();
};
const hide = () => {
  modalRef.value?.hide();
};
defineExpose({ show, hide });
defineEmits<{ close: [] }>();
</script>

<template>
  <Modal ref="modalRef" @close="$emit('close')" class="max-w-120 w-full m-4">
    <template #header>
      <div class="relative mb-6">
        <slot name="header" />
        <div class="absolute top-0 right-2">
          <button
            @click="hide"
            class="bg-transparent p-1 cursor-pointer hover:opacity-20"
          >
            <span class="sr-only">Close</span>
            <XMarkIcon class="w-6 h-6" />
          </button>
        </div>
      </div>
    </template>
    <template #body>
      <div class="mb-6">
        <slot name="body" />
      </div>
      <div class="flex justify-end">
        <Button :color="color" class="max-sm:w-full w-auto" @click="hide">{{
          buttonText
        }}</Button>
      </div>
    </template>
  </Modal>
</template>
