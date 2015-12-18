var pageMod = require('sdk/page-mod');
var tabs = require("sdk/tabs");

function openUrlInNewTab(url) {
    return tabs.open(url);
};

pageMod.PageMod({
    contentScriptFile: './main.js',
    include: 'https://github.com*',
    onAttach: function (worker) {
        worker.port.on('open-url-in-new-tab', function (url) {
            openUrlInNewTab(url);
        });
    }
});
