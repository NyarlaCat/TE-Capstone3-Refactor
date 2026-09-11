const { spawnSync } = require('node:child_process');

const args = process.argv.slice(2);
const hasWatchFlag = args.includes('--watch');
const hasNoWatchFlag = args.includes('--no-watch');
const fileArg = args.find((arg) => {
  if (arg.startsWith('-')) return false;
  return /(^|\/)(tests\/)?[^/]+\.test\.[tj]sx?$/.test(arg) || /\/tests\//.test(arg);
});

const jestArgs = [];
if (hasWatchFlag && !hasNoWatchFlag) {
  jestArgs.push('--watch');
}
if (fileArg) {
  jestArgs.push(fileArg);
}

const result = spawnSync('npx', ['jest', ...jestArgs], {
  stdio: 'inherit',
  shell: true,
});

if (result.error) {
  console.error(result.error);
  process.exit(1);
}

process.exit(result.status ?? 0);
