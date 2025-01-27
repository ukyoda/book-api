import type { Meta, StoryObj } from "@storybook/vue3";

import Toggle from "./index.vue";

type Story = StoryObj<typeof meta>;

const meta = {
  title: "@repo/ui/Toggle",
  component: Toggle,
  argTypes: {
    color: {
      control: "inline-radio",
      options: ["primary", "secondary", "danger", "normal"],
    },
    direction: {
      control: "inline-radio",
      options: ["west", "east"],
    },
  },
  tags: ["autodocs"],
} satisfies Meta<typeof Toggle>;

export default meta;

export const Default: Story = {
  args: {
    alt: "Alternative text",
    modelValue: true,
  },
};

export const Color: Story = {
  args: {
    alt: "Alternative text",
    modelValue: true,
  },
  render: (args) => ({
    components: { Toggle },
    setup() {
      return { args };
    },
    template: `
      <div class="m-4 flex items-center gap-4">
        <Toggle v-bind="args" color="primary" />
        <Toggle v-bind="args" color="secondary" />
        <Toggle v-bind="args" color="danger" />
        <Toggle v-bind="args" color="normal" />
      </div>
    `,
  }),
};

export const Size: Story = {
  args: {
    alt: "Alternative text",
    modelValue: true,
    color: "primary",
  },
  render: (args) => ({
    components: { Toggle },
    setup() {
      return { args };
    },
    template: `
        <div class="m-4 flex items-center gap-4">
          <Toggle v-bind="args" size="sm" />
          <Toggle v-bind="args" size="md" />
          <Toggle v-bind="args" size="lg" />
        </div>
      `,
  }),
};

export const WithLabel: Story = {
  args: {
    modelValue: true,
    color: "primary",
    label: "Toggle Switch",
  },
  render: (args) => ({
    components: { Toggle },
    setup() {
      return { args };
    },
    template: `
            <div class="m-4 flex items-center gap-4">
              <Toggle v-bind="args" />
            </div>
          `,
  }),
};
