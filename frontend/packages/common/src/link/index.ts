export const isAbsoluteUrl = (url: string): boolean => {
  return /^([a-z][a-z\d\+\-\.]*:)?\/\//i.test(url);
};
