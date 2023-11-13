(ns app.dev
  "A place to add preloads for developer tools!"
  (:require
    [helix.experimental.refresh :as r]
    [hyperfiddle.rcf]))


(hyperfiddle.rcf/enable!)

(r/inject-hook!)

(enable-console-print!)


(defn ^:dev/after-load clear-cache-and-render!
  []
  (println "refreshing!!!")
  (r/refresh!))


