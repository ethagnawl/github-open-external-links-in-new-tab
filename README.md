# About
This project is just a proof-of-concept. Functionally, all the Add-on does is
open outbound links on github.com in a new browser tab. I wanted to try
building a Firefox Add-on with ClojureScript and this was the first marginally
useful idea that I came up with.

## Dependencies
- [Node - 0.12.3](https://nodejs.org/en/)
- [JPM - 1.0.3](https://www.npmjs.com/package/jpm)
- [Boot - 2.5.1](http://boot-clj.com/)

## Running the Add-on Locally
- `npm run add-on`

## Packaging the Add-on
- `npm run package`

## TODO
- port index.js to cljs
- use :advanced compilation mode
- introduce toggle button and allow users to toggle add-on on/off
- use boot for publish, package, etc.

## Resources
- [Firefox Add-on SDK "Getting Started" tutorial](https://developer.mozilla.org/en-US/Add-ons/SDK/Tutorials/Getting_Started_%28jpm%29)
