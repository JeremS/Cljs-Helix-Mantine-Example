const autoprefixer = require('autoprefixer');
const postcssPresetMantine = require('postcss-preset-mantine');
const postcssSimpleVars = require('postcss-simple-vars');

const vs = {
    'mantine-breakpoint-xs': '36em',
    'mantine-breakpoint-sm': '48em',
    'mantine-breakpoint-md': '62em',
    'mantine-breakpoint-lg': '75em',
    'mantine-breakpoint-xl': '88em',
};

module.exports = {
  plugins:[
      autoprefixer({}),
      postcssPresetMantine({}),
      postcssSimpleVars({variables: vs})
  ],
};
