import type { Meta, StoryObj } from "@storybook/vue3";
import { ref } from "vue";

import { SelectBox, SelectOption } from ".";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/SelectBox",
  render: (args) => ({
    components: { SelectBox, SelectOption },
    setup() {
      const model = ref<(typeof args.data)[number]["value"]>();
      return { args, model };
    },
    template: `
      <div class="max-w-xl p-6">
        <p class="mb-3">Value: {{ model }}</p>
        <SelectBox v-model="model" placeholder="Select an option">
            <SelectOption 
              v-for="{ label, value } in args.data" 
              :value="value" 
              :key="label"
            >
              {{ label }}
            </SelectOption>
        </SelectBox>
      </div>
    `,
  }),
} satisfies Meta<{
  data: {
    label: string;
    value: string;
  }[];
}>;

export default meta;

export const Default: Story = {
  args: {
    data: [
      { label: "Option 1", value: "option1" },
      { label: "Option 2", value: "option2" },
      { label: "Option 3", value: "option3" },
    ],
  },
};
