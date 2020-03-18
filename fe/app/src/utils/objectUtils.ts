export function isFunction(obj: any) {
  return obj && {}.toString.call(obj) === "[object Function]";
}
