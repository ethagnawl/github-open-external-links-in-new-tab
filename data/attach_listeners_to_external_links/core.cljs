(ns attach-listeners-to-external-links.core)

(enable-console-print!)

(defn external-link?
  [url]
  (let [match-index (.indexOf "https://github.com" url)]
    (< match-index 0)))

(defn open-external-link
  [event]
  (let [target (aget event "target")
        url (aget target "href")]
      (.preventDefault event)
      (.emit (.-port js/self) "open-url-in-new-tab" url)))

(let [nas (.querySelectorAll js/document "a")
      as (.call (.-slice (js/Array.)) nas)
      external-as (filter external-link? as)]
  (doseq [external-a external-as]
    (.addEventListener external-a "click" #(open-external-link %))))
