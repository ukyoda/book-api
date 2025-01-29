import type { Meta, StoryObj } from "@storybook/vue3";
import { ref } from "vue";

import { Button } from "../../Button";

import AlertModal from "./index.vue";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/modal/AlertModal",
  component: AlertModal,
  tags: ["autodocs"],
  render: (args) => ({
    components: { AlertModal, Button },
    setup() {
      const modalRef = ref<typeof AlertModal>();
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
      <AlertModal ref="modalRef" v-bind="args">
        <template #header>
          <h2 class="text-lg font-semibold">Modal Header</h2>
        </template>
        <template #body>
          aaaaaa
        </template>
      </AlertModal>
    `,
  }),
} satisfies Meta<typeof AlertModal>;

export default meta;

export const Default: Story = {
  args: {
    backdrop: false,
  },
};
