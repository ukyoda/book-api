import type { Meta, StoryObj } from "@storybook/vue3";
import { ref } from "vue";

import { Button } from "../../Button";

import Modal from "./index.vue";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/modal/Modal",
  component: Modal,
  tags: ["autodocs"],
  render: (args) => ({
    components: { Modal, Button },
    setup() {
      const modalRef = ref<typeof Modal>();
      const openModal = () => {
        modalRef.value?.show();
      };
      const closeModal = () => {
        modalRef.value?.hide();
      };
      return { modalRef, openModal, closeModal, args };
    },
    template: `
      <div class="p-4">
        <Button @click="openModal">Open Modal</Button>
      </div>
      <Modal ref="modalRef" v-bind="args" class="min-w-3xl">
        <template #header>
          <h2 class="text-lg font-semibold">Modal Header</h2>
        </template>
        <template #body>
          <div>
            <p class="text-sm">Modal Body</p>
            <div class="flex justify-end mt-4">
                <Button @click="closeModal">Close</Button>
            </div>
          </div>
        </template>
      </Modal>
    `,
  }),
} satisfies Meta<typeof Modal>;

export default meta;

export const Default: Story = {
  args: {
    backdrop: false,
  },
};
