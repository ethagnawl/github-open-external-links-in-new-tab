(set-env!
  :target-path "data"
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.7.0"]
                  [org.clojure/clojurescript "1.7.170"]
                  [adzerk/boot-cljs "1.7.170-3"]])

(require '[adzerk.boot-cljs :refer [cljs]])

(deftask build []
  (comp (cljs :optimizations :whitespace)))
