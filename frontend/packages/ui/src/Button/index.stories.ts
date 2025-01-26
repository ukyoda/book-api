import type { Meta, StoryObj } from "@storybook/vue3";

import Button from "./index.vue";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/Button",
  component: Button,
  tags: ["autodocs"],
  render: (args) => ({
    components: { Button },
    setup() {
      return { args };
    },
    template: `<Button v-bind="args">CLICK</Button>`,
  }),
} satisfies Meta<typeof Button>;

export default meta;

export const Size: Story = {
  render: (args) => ({
    components: { Button },
    setup() {
      return { args };
    },
    template: `
      <div class="space-x-4">
      <Button v-bind="args" size="sm">SMALL</Button>
      <Button v-bind="args" size="md">MEDIUM</Button>
      <Button v-bind="args" size="lg">LARGE</Button>
      </div>
    `,
  }),
};
export const Color: Story = {
  render: (args) => ({
    components: { Button },
    setup() {
      return { args };
    },
    template: `
          <div class="space-x-4">
            <Button v-bind="args" color="primary">PRIMARY</Button>
            <Button v-bind="args" color="secondary">SECONDARY</Button>
            <Button v-bind="args" color="danger">DANGER</Button>
            <Button v-bind="args" color="normal">NORMAL</Button>
          </div>
        `,
  }),
};
