(set-env!
  :source-paths #{"data"}
  :dependencies '[[org.clojure/clojure "1.7.0"]
                  [org.clojure/clojurescript "1.7.170"]
                  [adzerk/boot-cljs "1.7.170-3"]])

(require '[adzerk.boot-cljs :refer [cljs]])

(deftask build []
  (set-env! :source-paths #{"data"})
  (comp (cljs :optimizations :whitespace)))
