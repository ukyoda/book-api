<script setup lang="ts">
import {
  Dialog,
  DialogPanel,
  DialogTitle,
  DialogDescription,
} from "@headlessui/vue";
import { ref } from "vue";

const { initialOpen = false, backdrop = true } = defineProps<{
  initialOpen?: boolean;
  backdrop?: boolean;
}>();
const isOpen = ref(initialOpen);

const show = () => {
  isOpen.value = true;
};
const hide = () => {
  isOpen.value = false;
};

defineExpose({ show, hide });
</script>

<template>
  <Dialog :open="isOpen" @close="() => backdrop && hide()">
    <div class="fixed inset-0 flex items-center justify-center bg-gray-800/80">
      <DialogPanel class="border border-gray-300 bg-white rounded-md p-4">
        <DialogTitle>
          <slot name="header" />
        </DialogTitle>
        <DialogDescription>
          <slot name="body" />
        </DialogDescription>
      </DialogPanel>
    </div>
  </Dialog>
</template>
