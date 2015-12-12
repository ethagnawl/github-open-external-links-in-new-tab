var pageMod = require('sdk/page-mod');
var tabs = require("sdk/tabs");
var { ToggleButton } = require("sdk/ui/button/toggle");

var ACTIVE = true;
var worker = null;

function openUrlInNewTab(url) {
    return tabs.open(url);
};

function generateButtonLabel(buttonIsActive = true) {
    var bool = buttonIsActive ? 'Disable' : 'Enable';
    return `${bool} opening of external links in a new tab on Github.com`
}

function getAddOnStatus() {
    return ACTIVE;
}

function updateAddOnStatus(status) {
    ACTIVE = !!status;
    worker && worker.port.emit('add-on-status-change', getAddOnStatus());
    return getAddOnStatus();
}

pageMod.PageMod({
    contentScriptFile: './attach-listeners-to-external-links.js',
    include: 'https://github.com*',
    onAttach: function (_worker) {
        worker = _worker;
        worker.port.on('open-url-in-new-tab', function (url) {
            if (getAddOnStatus()) {
                openUrlInNewTab(url);
            }
        });
    }
});

var button = ToggleButton({
    id: "github-open-external-links-in-new-tab-toggle-button",
    label: generateButtonLabel(),
    icon: {
        "16": "./icon-16.png",
        "32": "./icon-32.png",
        "64": "./icon-64.png"
    },
    onChange: function (state) {
        return;
        // updateAddOnStatus(!getAddOnStatus());
        // button.label = generateButtonLabel(getAddOnStatus());
    }
});
