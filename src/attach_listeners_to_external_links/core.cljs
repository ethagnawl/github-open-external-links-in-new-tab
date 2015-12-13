(ns attach-listeners-to-external-links.core)

(enable-console-print!)

(defn dispatch-message
  [pattern message]
  (.emit (.-port js/self) pattern message))

(defn dispatch-open-external-link-message
  [event]
  (let [target (aget event "target")
        url (aget target "href")]
      (.preventDefault event)
      (dispatch-message "open-url-in-new-tab" url)))

(defn external-link?
  [link]
  (let [url (.-href link)
        match-index (.indexOf url "github.com")]
    (< match-index 0)))

(defn find-external-links
  []
  (let [nas (.querySelectorAll js/document "a")
        as (.call (.-slice (js/Array.)) nas)
        external-as (filter external-link? as)]
    external-as))

(defn attach!
  []
  (doseq [external-a (find-external-links)]
    (.addEventListener
      external-a
      "click"
      dispatch-open-external-link-message)))

(defn detach!
  []
  (doseq [external-a (find-external-links)]
    (.removeEventListener
      external-a
      "click"
      dispatch-open-external-link-message)))

(attach!)
