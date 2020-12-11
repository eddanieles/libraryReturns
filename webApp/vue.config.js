module.exports = {
    devServer: {
        proxy: {
            '^/api': {
                target: 'http://localhost:3080',
                changeOrigin: true
            },
        }
    },
    css: {
        loaderOptions: {
            sass: {
                sassOptions: {
                    prependData: `
                  @import "@/scss/variables.scss";
                  @import "@/scss/mixins.scss";
                  @import "@/scss/functions.scss";
                `
                }
            }
        }
    }
}