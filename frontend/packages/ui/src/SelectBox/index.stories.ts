import type { Meta, StoryObj } from "@storybook/vue3";
import { ref } from "vue";

import { Button } from "../Button";

import { SelectBox } from ".";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/SelectBox",
  component: SelectBox,
  tags: ["autodocs"],
  render: (args) => ({
    components: { SelectBox, Button },
    setup() {
      const model = ref<(typeof args.data)[number]["value"]>();
      return { args, model };
    },
    template: `
      <div class="max-w-xl p-6">
        <p class="mb-3">Value: {{ model }}</p>
        <SelectBox 
          v-bind="args"
          v-model="model" 
        />
        <Button type="button" @click="model = undefined" class="mt-3">Clear</Button>
      </div>
    `,
  }),
} satisfies Meta<typeof SelectBox>;

export default meta;

export const Default: Story = {
  args: {
    placeholder: "Select...",
    data: [
      { label: "Option 1", value: "option1" },
      { label: "Option 2", value: "option2" },
      { label: "Option 3", value: "option3" },
    ],
  },
};
