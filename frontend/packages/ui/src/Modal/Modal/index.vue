<script setup lang="ts">
import {
  Dialog,
  DialogPanel,
  DialogTitle,
  DialogDescription,
} from "@headlessui/vue";
import clsx from "clsx";
import { twMerge } from "tailwind-merge";
import { ref } from "vue";

const { initialOpen = false } = defineProps<{
  initialOpen?: boolean;
}>();
const isOpen = ref(initialOpen);

const show = () => {
  isOpen.value = true;
};
const hide = () => {
  isOpen.value = false;
  emits("close");
};

const emits = defineEmits<{ close: [] }>();
defineExpose({ show, hide });
</script>

<template>
  <Dialog :open="isOpen" @close="hide">
    <div class="fixed inset-0 flex items-center justify-center bg-gray-800/80">
      <DialogPanel
        :class="
          twMerge(
            'border border-gray-300 bg-white rounded-md p-4',
            $attrs.class ? clsx($attrs.class) : '',
          )
        "
      >
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
