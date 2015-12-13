(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:main 'attach-listeners-to-external-links.core
   :optimizations :whitespace
   :output-to "data/attach-listeners-to-external-links.js"})
