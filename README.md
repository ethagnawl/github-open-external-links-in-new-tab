# About
This project is just a proof-of-concept. Functionally, all the Add-on does is
open outbound links on github.com in a new browser tab. I wanted to try
building a Firefox Add-on with ClojureScript and this was the first marginally
useful idea that I came up with.

## Dependencies
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
