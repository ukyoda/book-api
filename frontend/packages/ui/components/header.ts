export function Header({ title }: { title: string }) {
  return `
    <header id="header">
      <h1 class="text-lg">${title}</h1>
    </header>
    `;
}
