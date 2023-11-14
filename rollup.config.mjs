import { nodeResolve } from '@rollup/plugin-node-resolve';
import commonjs from '@rollup/plugin-commonjs';
import postcss from 'rollup-plugin-postcss'
import replace from '@rollup/plugin-replace';
import * as process  from 'node:process';


const postcssOpts = {
    modules: false,
    autoModules: true,
    extract: 'main.css'
};


const nodeResolveOpts = {
    browser: true
};


const replaceOpts = {
    preventAssignment: true,
    values: {
        'process.env.NODE_ENV': JSON.stringify(process.env.BUILD),
    }
};

function warnFilter (warning, warn) {
    if (warning.code === 'MODULE_LEVEL_DIRECTIVE') {
        return
    }
    warn(warning)
}

const pluginsConf = [
    postcss(postcssOpts),
    commonjs(),
    nodeResolve(nodeResolveOpts),
    replace(replaceOpts)
];



export default [{
    plugins: pluginsConf,
    input: 'src-js/main/index.js',
    output: {
        sourcemap: true,
        dir: 'resources/public/',
        entryFileNames: 'js/libs/[name].js',
        format: 'es'
    },
    onwarn: warnFilter
},{
    plugins: pluginsConf,
    input: 'src-js/portfolio/index.js',
    output: {
        sourcemap: true,
        dir: 'resources/portfolio/',
        entryFileNames: 'js/libs/[name].js',
        format: 'es'
    },
    onwarn: warnFilter
}];

