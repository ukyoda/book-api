import type { Meta, StoryObj } from "@storybook/vue3";

import TextInput from "./index.vue";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/TextInput",
  component: TextInput as Record<keyof typeof TextInput, unknown>,
  tags: ["autodocs"],
} satisfies Meta<typeof TextInput>;

export default meta;

export const Normal: Story = {
  args: {
    label: "Label",
  },
};
