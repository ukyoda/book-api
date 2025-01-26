import type { Meta, StoryObj } from "@storybook/vue3";

import { ListView, ListItem } from ".";

type Story = StoryObj<typeof meta>;

const meta = {
  title: "@repo/ui/ListView",
  component: ListView,
  tags: ["autodocs"],
  render: (args) => ({
    components: { ListView, ListItem },
    setup() {
      return { args };
    },
    template: `
      <ListView v-bind="args">
        <ListItem>Item 1</ListItem>
        <ListItem>Item 2</ListItem>
        <ListItem>Item 3</ListItem>
      </ListView
    `,
  }),
} satisfies Meta<typeof ListView>;

export default meta;

export const Default: Story = {
  render: (args) => ({
    components: { ListView, ListItem },
    setup: () => ({ args }),
    template: `
      <ListView v-bind="args">
        <ListItem>
          <template #left>
            TITLE
          </template>
          <template #right>
            RIGHT
          </template>
        </ListItem>
        <ListItem link="https://example.com">
          CENTER
        </ListItem>
        <ListItem>
          <template #left>
            TITLE
          </template>
          <template #right>
            RIGHT
          </template>
        </ListItem>
      </ListView>
    `,
  }),
};
