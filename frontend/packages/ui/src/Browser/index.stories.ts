import type { Meta, StoryObj } from "@storybook/vue3";

import { Browser } from ".";

type Story = StoryObj<typeof meta>;
const meta = {
  title: "@repo/ui/Browser",
  component: Browser,
  tags: ["autodocs"],
} satisfies Meta<typeof Browser>;

export default meta;

export const Default: Story = {
  args: {
    items: [
      {
        value: "Item 1",
        label: "Parent 1",
      },
      {
        value: "Item 2",
        label: "Parent 2",
      },
      {
        value: "Item 3",
        label: "Parent 3",
        children: [
          {
            value: "Item 3.1",
            label: "Child 3.1",
          },
          {
            value: "Item 3.2",
            label: "Child 3.2",
          },
          {
            value: "Item 3.3",
            label: "Child 3.3",
            children: [
              {
                value: "Item 3.3.1",
                label: "Grandchild 3.3.1",
              },
              {
                value: "Item 3.3.2",
                label: "Grandchild 3.3.2",
              },
              {
                value: "Item 3.3.3",
                label: "Grandchild 3.3.3",
              },
            ],
          },
        ],
      },
    ],
  },
};
